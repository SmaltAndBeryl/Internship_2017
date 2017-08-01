
angular.module('hello', [ 'ngRoute' ]) // ... omitted code
.controller('navigation',

  function($rootScope, $http, $location, $scope) {
	 $scope.alerts = [
	                  { type: 'danger', msg: 'Invalid credentials, Please check username and password entered' }, 
	                  { type: 'success', msg: 'Successful login' }
	                ];

  var self = this

  var authenticate = function(credentials, callback) {

    var headers = credentials ? {authorization : "Basic "
        + btoa(credentials.username + ":" + credentials.password)
    } : {};

    $http.get('user', {headers : headers}).then(function(response) {
      if (response.data.name) {
        $rootScope.authenticated = true;
        self.error= false;
      } else {
        $rootScope.authenticated = false;
        $scope.alerts.push({type: 'danger'});
        self.error = true;
      }
      callback && callback();
    }, 
    function() {
      $rootScope.authenticated = false;
      self.error = true;
      callback && callback();
    });

  }

  authenticate();
  self.credentials = {};
  self.login = function() {
      authenticate(self.credentials, function() {
        if ($rootScope.authenticated) {
          $location.path("/");
          self.error = false;
          
        	}
        else {
          
          $scope.alerts.push({type: 'danger'});
          self.error = true;
          //$scope.alerts.push({type: 'danger'});
          //$location.path("/login");
        }
      });
  };
});