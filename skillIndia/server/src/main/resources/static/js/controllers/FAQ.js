var app = angular.module('app', [ 'ui.grid', 'ui.grid.edit', 'ui.grid.cellNav']);

app.controller('FAQTotalCandidatesTrainedAssessedCertifiedController', ['$scope', '$http', function ($scope, $http) {
 //to fill data in scheme drop down
//    $scope.deleteRow = function(row) {
//    var index = $scope.gridOptions.data.indexOf(row.entity);
//	var obj = $scope.gridOptions.data[0];
//	console.log(Object.values(obj));
//		
//		
//	var temp = Object.values(obj)[5];
//	
//	console.log(Object.values(obj)[5]);
//    $scope.gridOptions.data.splice(index, 1);
//  };
  
    getDataAcrossAllScheme();

  $scope.gridOptions = {
	  enableGridMenus : false,  
	  enableSorting: false, 
	  enableFiltering: false,
	  enableCellEdit : false,
	  
	  enableColumnMenus : false,
    columnDefs: [
		{ name: 'totalNoOfCandidatesEnrolled' , displayName: 'Total No. Of Candidate Enrolled', width:250},
		{ name: 'totalNoOfCandidatesAssessed' , displayName: 'Total No. Of Candidate Assessed', width:250},
		{ name: 'totalNoOfCandidatesCertified', displayName: 'Total No. Of Candidate Certified', width:250}
    ]
  };

  function getDataAcrossAllScheme() {
  
	  $http.get('/getFAQTotalCandidatesTrainedAssessedCertified')
	    .success(function (response) {
	      $scope.gridOptions.data = response;
	    });
  
  
       }
     
}
]);

app.controller('FAQCountOfTotalTrainingCentresConductingTrainingController', ['$scope', '$http', function ($scope, $http) {
	 //to fill data in scheme drop down
	   $scope.schemeDropDownOptions = ['PMKVY','Non-PMKVY'];
	    $scope.deleteRow = function(row) {
	    var index = $scope.gridOptions.data.indexOf(row.entity);
		var obj = $scope.gridOptions.data[0];
		console.log(Object.values(obj));
			
			
		var temp = Object.values(obj)[5];
		
		console.log(Object.values(obj)[5]);
	    $scope.gridOptions.data.splice(index, 1);
	  };

	  $scope.gridOptions = {
		  enableGridMenus : false,  
		  enableSorting: false, 
		  enableFiltering: false,
		  enableCellEdit : false,
		  
		  enableColumnMenus : false,
	    columnDefs: [
			{ name: 'Total No. Of Training', width:250}
	    ]
	  };
	  var queryParameter = $scope.schemeDropDownOptions;
	  $scope.getDataOfScheme = function getDataOfScheme() {
//		  var FAQURI2 = "/getFAQCountOfTotalTrainingCentresConductingTraining?batchType=";
		  console.log($scope.selectedScheme);
		  console.log('/getFAQCountOfTotalTrainingCentresConductingTraining?batchType='+ $scope.selectedScheme)
		  $http.post("/getFAQCountOfTotalTrainingCentresConductingTraining?batchType=").then(function(scheme)
						{
					     console.log(scheme);
					     $scope.gridOptions.data = scheme;
						});
		  }
	     
	}
	]);


app.controller('FAQScreenController3', ['$scope', '$http', function ($scope, $http) {
	 //to fill data in scheme drop down
	   $scope.stateDropDownOptions = ['Andhra Pradesh','Arunachal Pradesh','Assam','Bihar','Chhattisgarh','Delhi','Goa','Gujarat','Haryana','Himachal Pradesh','Jammu & Kashmir','Jharkhand','Karnataka','Kerala','Madhya Pradesh','Maharastra','Manipur','Meghalaya','Mizoram','Nagaland','Odisha','Punjab','Rajasthan','Sikkim','Tamil Nadu','Telangana','Tripura','Uttarakhand','Uttar Pradesh','West Bengal'];
//	    $scope.deleteRow = function(row) {
//	    var index = $scope.gridOptions.data.indexOf(row.entity);
//		var obj = $scope.gridOptions.data[0];
//		console.log(Object.values(obj));
//			
//			
//		var temp = Object.values(obj)[5];
//		
//		console.log(Object.values(obj)[5]);
//	    $scope.gridOptions.data.splice(index, 1);
//	  };
//
//	  $scope.gridOptions = {
//		  enableGridMenus : false,  
//		  enableSorting: false, 
//		  enableFiltering: false,
//		  enableCellEdit : false,
//		  
//		  enableColumnMenus : false,
//	    columnDefs: [
//			{ name: 'trained', width:250, displayName:'Total candidates trained in a state'}
//	    ]
//	  };
	  var queryParameter = $scope.stateDropDownOptions;
	  $scope.getDataOfState = function getDataOfState() {
		  var getTotalTrainingCenterUrl = "/getFAQTotalTrainingCentresInAState?state="+$scope.selectedState;
		  console.log($scope.selectedState);
		  console.log(getTotalTrainingCenterUrl);
		//  console.log('/getFAQTotalTrainingCentresInAState?state='+ $scope.stateDropDownOptions)
		  $http.post(getTotalTrainingCenterUrl).then(function(state)
						{
					     console.log(state);
					     $scope.state = state.data;
					      
					     
//					     $scope.gridOptions.data = state;
						});
		  }
	     
	}
	]);







