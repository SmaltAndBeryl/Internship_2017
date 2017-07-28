console.log("App.js being executed");
var hello = angular.module('hello', ['ngRoute','ui.grid', 'ui.grid.edit', 'ui.grid.cellNav','ui.grid.autoResize','ui.bootstrap']);

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
	.otherwise('/');

	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

});

hello.controller('navigation', function($rootScope, $http, $location, $route) {
    var self = this;
    self.tab = function(route) {
        return $route.current && route === $route.current.controller;
    };

    var authenticate = function(credentials, callback) {

        var headers = credentials ? {
//            authorization : "Basic " + btoa(credentials.username + ":" + credentials.password)
              authorization : "Basic " + btoa(credentials.username + ":" + credentials.password)
            } : {};

        $http.get('getUserDetails', {
            headers : headers
        }).then(function(response) {
        console.log("Backend value " + response.data);
            if (response.data.name) {

                $rootScope.authenticated = true;
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
                console.log("Login succeeded")
                $location.path("/master");
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
        console.log("Logging out./././././././");
        $http.post('logout', {}).finally(function() {
            console.log("Logged out successfully..")
            $rootScope.authenticated = false;
            $location.path("/");
        });
    }
});



