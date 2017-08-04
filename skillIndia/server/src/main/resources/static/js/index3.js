console.log("App.js being executed");
var hello = angular.module('hello', ['ngRoute',
                                        'ui.grid',
                                         'ui.grid.edit',
                                          'ui.grid.cellNav',
                                          'ui.grid.autoResize',
                                          'ui.bootstrap']);

console.log("Module initialized successfully..");
hello.config(function($routeProvider, $httpProvider) {

	$routeProvider.when('/', {
		templateUrl : 'index3.html',
		controller : 'navigation'

	})
	.when('/master', {
	    templateUrl : 'master.html',
	    controller : 'master'

	})
	.when('/trainingPartner', {
        templateUrl : 'trainingPartner.html',
        controller : 'trainingPartner'

    })
    .when('/assessmentBody', {
        templateUrl : 'assessmentBody.html',
        controller : 'assessmentBody'
    })
	.otherwise('/');

	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

});

hello.controller('navigation', function($rootScope, $http, $location, $route) {
    var self = this;
    var spock;
    self.tab = function(route) {
        return $route.current && route === $route.current.controller;
    };

    var authenticate = function(credentials, callback) {

        var headers = credentials ? {
              authorization : "Basic " + btoa(credentials.username + ":" + credentials.password)
            } : {};

        $http.get('/getUserDetails', {
            headers : headers
        }).then(function(response) {
            if (response.data.name) {

                $http({
                   method: 'POST',
                   url: "/getSPOCNameAndApplicationState",
                   transformResponse: [function (data)  {
                    console.log(data);

                   spock = data;
                    return data;
                   }]
                   })
                    .then(function(response){
                        alert("get Successful " + spock);
//                            if(JSON.stringify(response) == '""'){
//                                alert("no name");
//                                $rootScope.spockName = "Jane Doe";
//                            }
//                            else{
//                                alert("A name");
//                                $rootScope.spockName = response;
//                            }
                            $rootScope.spockName = spock ;
                    });
                console.log("Backend value " + response + "String Format " + JSON.stringify(response.data.authorities[0].authority));
                $rootScope.authenticated = true;
                $rootScope.type = JSON.stringify(response.data.authorities[0].authority);
                console.log("USER role is " + $rootScope.type);
            } else {
                console.log("Backend value " + response);
                $rootScope.authenticated = false;
            }
            callback && callback($rootScope.authenticated);
        }, function() {
            $rootScope.authenticated = false;
            callback && callback(false);
        });


    }

    authenticate();

    self.credentials = {};

    self.login = function() {
        authenticate(self.credentials, function(authenticated) {
            if (authenticated) {
                var userType = $rootScope.type;
                var AB = '"AB"';
                var TP = '"TP"';
                var SCGJ = '"SCGJ"';


                if(userType == AB){
                    alert("Welcome assessment body");
                    $location.path("/assessmentBody");
                    $rootScope.priv = "AB";
                }

                if(userType == TP){
                    alert("Welcome training partner");
                    $location.path("/trainingPartner");
                    $rootScope.priv = "TP";
                }

                if(userType == SCGJ){
                    alert("Welcome SCGJ user");
                    $location.path("/master");
                    $rootScope.priv = "SCGJ";
                }

                self.error = false;
                $rootScope.authenticated = true;


            } else {
                console.log("Login failed")
                $location.path("/login");
                self.error = true;
                $rootScope.authenticated = false;
            }
        })
    };

    self.logout = function($route) {
        $rootScope.type = "logout";
        console.log("Logging out./././././././");
        $http.post('logout', {}).finally(function() {
            console.log("Logged out successfully..")
            $rootScope.authenticated = false;
            $location.path("/");
        });
    }
});


