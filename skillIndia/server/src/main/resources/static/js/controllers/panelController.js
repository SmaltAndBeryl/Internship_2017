var app= angular.module('app',[]);

app.controller('firstCtrl', function($scope, $http)  {
	
	  $http.get("/getDashboardTotalCandidatesEnrolled")
	  .then(function(response) {
	      $scope.number = response.data;
	  });
	});
	  
app.controller('secondCtrl', function($scope, $http)  {
	  $http.get("/getDashboardTotalCandidatesAccessed")
	  .then(function(response) {
	      $scope.number = response.data;
	  });
	});
app.controller('thirdCtrl',function ($scope,$http) {
	
			$http.get('/getDashboardTotalCandidatesCertified')
		.then(function(response) {
      $scope.number= response.data;
		});
	});
	  
app.controller('fourthCtrl', function ($scope,$http) {
	
		$http.get('/getDashboardTotalTrainingPartners')
		.then(function(response) {
      $scope.number= response.data;
		});
	
});
	  
app.controller('fifthCtrl',function ($scope,$http) {
			$http.get('/getDashboardTotalTrainingCentersInIndia')
		.then(function(response) {
      $scope.number= response.data;
		});
	
});
	  
