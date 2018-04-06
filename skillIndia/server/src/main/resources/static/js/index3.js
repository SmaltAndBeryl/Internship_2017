//console.log("App.js being executed");
var hello = angular.module('hello', ['ngRoute',
                                        'ui.grid',
                                         'ui.grid.edit',
                                          'ui.grid.cellNav',
                                          'ui.grid.autoResize',
                                          'ui.bootstrap',
                                          'ui.grid.pagination']);

//console.log("Module initialized successfully..");
hello.config(function($routeProvider, $httpProvider) {

	$routeProvider.when('/master', {
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
    .when('/profileCreationTp', {
        templateUrl : 'profileCreationTp.html',
        controller : 'profileCreationTp'
    }).when('/profileCreationAb', {
        templateUrl : 'profileCreationAb.html',
        controller : 'profileCreationAb'
    })

	.otherwise('/');

	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

});

hello.controller('navigation', function($rootScope, $http, $location, $route,$scope,$timeout) {
    var self = this;
    var spock;
    self.tab = function(route) {
        return $route.current && route === $route.current.controller;
    };
         
    
    var checkAndSetState =function(submitRoutingUrl,acceptedRoutingUrl){
        $http({
            method: 'POST',
            url: "/getApplicationState"})
             .then(function(response){
            	 var appState = response.data.applicationState;
//                 alert("Application get successful, state = " + appState);
                 if(appState == 'Draft'){
                     $location.path(submitRoutingUrl);
                 }

                 else{
                     //alert("Not routing to pc " + appState);
                     $location.path(acceptedRoutingUrl);
                 }

             });

     

    }
    var successCallBack = function(authenticated) {
        if (authenticated) {
            var userType = $rootScope.type;
            var AB = '"AB"';
            var TP = '"TP"';
            var SCGJ = '"SCGJ"';
            var appState = "Submit";



            if(userType == AB){
                
              //  $location.path("/assessmentBody");
                $rootScope.priv = "AB";
                checkAndSetState("/profileCreationAb","/assessmentBody");
            }

            if(userType == TP){
                
                $rootScope.priv = "TP";
                checkAndSetState("/profileCreationTp","/trainingPartner");
            }

            if(userType == SCGJ){
                
                $location.path("/master");
                $rootScope.priv = "SCGJ";
            }

            self.error = false;
            $rootScope.authenticated = true;


        } 
    
}

    var authenticate = function(credentials) {

    	var headers = credentials ? {
              authorization : "Basic " + btoa(credentials.username + ":" + credentials.password)
            } : {};

        $http.get('/getUserDetails', {
            headers : headers
        }).then(function(response) {
            if (response.data.name) {

                $http({
                   method: 'POST',
                   url: "/getSPOCName",
                   transformResponse: [function (data)  {
                    //console.log(data);

                    spock = data;
                    return data;
                   }]
                   })
                    .then(function(response){
// alert("get Successful " + spock);
                        $rootScope.spockName = spock ;
                        
                    });
// //console.log("Backend value " + response + "String Format " +
// JSON.stringify(response.data.authorities[0].authority));
            
            } else {
// //console.log("Backend value " + response);
                $rootScope.authenticated = false;
                
                
            }
            $rootScope.authenticated = true;
            $rootScope.type = JSON.stringify(response.data.authorities[0].authority);
            successCallBack($rootScope.authenticated);
            //console.log("USER role is " + $rootScope.type);
//         
            
        }, function() {
          if(credentials){
        	  //console.log("Login failed");
              self.error = true;
              $rootScope.authenticated = false;
              //console.log("I AM HERE");
              $rootScope.errorMessagesForLoggingIn = 'Invalid UserName/Password';
              $timeout(function() {
            	  $rootScope.errorMessagesForLoggingIn="";
               }, 2000);
                
          }
        });


    }

 authenticate();

    self.credentials = {};
    self.newUser ={};
    self.signup = function (){
    	//alert(JSON.stringify(self.newUser));
    	
		$http({
			url : "/signup",
			method : "POST",
			data : angular.toJson(self.newUser),
			headers : {
						'Content-type': 'application/json'
						}
			
			}).then(function(response)
				{
			     //console.log(response);
		     var signupAction=response;
		     var userName=signupAction.userId;
		     
		     if(response.data == -1)
		     {
		    	$scope.errorMessagesForSignUp = "Organisation name is already in use."
		    		$timeout(function() {
		            	  $rootScope.errorMessagesForSignUp="";
		               }, 2000);
		    }
		     else if(response.data == -2)
		    	 {
		    	 	$scope.errorMessagesForSignUp = "Could not create your account as of now .Please try later";
		    	 	$timeout(function() {
		            	  $rootScope.errorMessagesForSignUp="";
		               }, 2000);
		    	 }
		     else 
		     {
		    	 //alert("User created with userId - "+self.newUser.userId); 
		    	 $scope.successMessagesForSignUp = "User created successfully.Please login now.";
		    	 //window.location.href ="/";
		     }
		     //window.location.href ="/";
		    	 
			  },
			  function(errorResponse)
			  {
				  $scope.errorMessagesForSignUp = "Could not create your account as of now .Please try later"
			  });
    }
    self.login = function() {
        authenticate(self.credentials);
    } 
    
    self.logout = function($route) {
        $rootScope.type = "logout"; 	
        //console.log("Logging out./././././././");
        $http.post('logout', {}).finally(function() {
            //console.log("Logged out successfully..")
            window.location.href ="/";
           // $location.path("/");
        });
    }
    
//    $scope.master = function() {
////    	console.log("Image is working");
//    	$location.path("/master");
//    }
    
});


