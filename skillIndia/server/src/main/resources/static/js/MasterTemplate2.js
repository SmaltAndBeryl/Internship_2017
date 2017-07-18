var myApp = angular.module('myApp', ['ngRoute','tpApp','abApp']);

myApp.config(function($routeProvider) {
	  $routeProvider
	  .when('/tp',{
	    templateUrl: 'partials/trainingPartnerHomepage.html',
	    //templateUrl: 'partials/Dashboard.html',
	    controller: 'presentController'
	  })

	  .when('/ab',{
	    templateUrl: 'partials/assessmentBodyHomepage.html',
	    //templateUrl : 'partials/dashboard.html'
	    controller: 'abhomepageController'
	  })
});

myApp.controller('username-ctrl', function($scope) {
  $scope.username = "Alkesh Srivastava";
});

//RouteProvider