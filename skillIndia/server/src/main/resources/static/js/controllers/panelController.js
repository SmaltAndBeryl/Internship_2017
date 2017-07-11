//var app= angular.module('app',[]);

var dashboard = angular.module('dashboard', []);

dashboard.controller('dashboardController', dashboardController);

dashboardController.$inject = ['$scope', '$http'];

function dashboardController($scope, $http)  {
	
	  $http.get("/getDashboardTotalCandidatesEnrolled")
	  .then(function(response) {
	      $scope.enrolled = response.data;
	  });

	  $http.get("/getDashboardTotalCandidatesAccessed")
      	  .then(function(response) {
      	      $scope.assessed = response.data;
      	  });

       $http.get("/getDashboardTotalCandidatesCertified")
             	  .then(function(response) {
             	      $scope.certified = response.data;
             	  });


        $http.get("/getDashboardTotalTrainingPartners")
              	  .then(function(response) {
              	      $scope.partner = response.data;
              	  });

        $http.get("/getDashboardTotalTrainingCentersInIndia")
                      	  .then(function(response) {
                      	      $scope.centre = response.data;
                      	  });


	};
	  
//app.controller('secondCtrl', function($scope, $http)  {
//	  $http.get("/getDashboardTotalCandidatesAccessed")
//	  .then(function(response) {
//	      $scope.number = response.data;
//	  });
//	});
//app.controller('thirdCtrl',function ($scope,$http) {
//
//			$http.get('/getDashboardTotalCandidatesCertified')
//		.then(function(response) {
//      $scope.number= response.data;
//		});
//	});
//
//app.controller('fourthCtrl', function ($scope,$http) {
//
//		$http.get('/getDashboardTotalTrainingPartners')
//		.then(function(response) {
//      $scope.number= response.data;
//		});
//
//});
//
//app.controller('fifthCtrl',function ($scope,$http) {
//			$http.get('/getDashboardTotalTrainingCentersInIndia')
//		.then(function(response) {
//      $scope.number= response.data;
//		});
//
//});
	  
