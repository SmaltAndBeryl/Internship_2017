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
// For Total Candidates Trained Assessed Certified Scheme Wise Controller
//app.controller('FAQTotalCandidatesTrainedAssessedCertifiedSchemeWiseController', ['$scope', '$http', function ($scope, $http) {
//	 //to fill data in scheme drop down
//	   $scope.schemeDropDownOptions = ['PMKVY','Non-PMKVY'];
//	  var queryParameter = "/getFAQTotalCandidatesTrainedAssessedCertifiedSchemeWise?batchType="+ $scope.selectedScheme;
//	  $scope.getDataOfScheme = function getDataOfScheme() {
//		  var faq2;
////		  var FAQURI2 = "/getFAQCountOfTotalTrainingCentresConductingTraining?batchType=";
//		  console.log($scope.selectedScheme);
//		  console.log('/getFAQTotalCandidatesTrainedAssessedCertifiedSchemeWise?batchType='+ $scope.selectedScheme)
//		  $http.post(queryParameter).then(function(scheme)
//						{
//			  
//					     console.log(angular.fromJson(scheme));
//					     faq2 = angular.fromJson(scheme);
//					     $scope.scheme=faq2.totalNoOfCandidatesEnrolled;
//					     
//						});
//		  }
//	     
//	}
//	]);


app.controller('FAQTotalTrainingCentresInAStateController',['$scope', '$http', function ($scope, $http) {
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
					     console.log(state.data);
					     $scope.state = state.data;
					      
					     
//					     $scope.gridOptions.data = state;
						});
		  }
	     
	}
	]);





app.controller('FAQCountOfTotalTrainingCentresConductingTrainingController', ['$scope', '$http', function ($scope, $http) {
	   $scope.schemeDropDownOptions = ['PMKVY','Non-PMKVY'];
	  var queryParameter = $scope.schemeDropDownOptions;
	  $scope.getDataOfScheme = function getDataOfScheme() {
		 
		  var getFAQCountOfTotalTrainingCentresUrl = "/getFAQCountOfTotalTrainingCentresConductingTraining?scheme="+$scope.selectedScheme;
		  console.log($scope.selectedScheme);
		  console.log(getFAQCountOfTotalTrainingCentresUrl);
			  $http.get('/getFAQCountOfTotalTrainingCentresConductingTraining')
			    .then(function (response) {
			    	$scope.number=response.data;
			     
			    });
		  }
	     
	}
	]);




//app.controller('FAQCountOfCandidatesAssessmentUpcomingForAMonthController', ['$scope', '$http', function ($scope, $http) {
//
//	   $scope.monthDropDownOptions = ['January','February','March','April','May','June','July','August','September','October','November','December'];
//	  var queryParameter = $scope.monthDropDownOptions;
//	  $scope.getDataOfMonth = function getDataOfMonth() {
//		  var getFAQCountOfCandidatesAssessmentUpcomingForAMonthUrl = "/getFAQCountOfCandidatesAssessmentUpcomingForAMonth?month="+$scope.selectedMonth;
//		  console.log($scope.selectedMonth);
//		  console.log(getFAQCountOfCandidatesAssessmentUpcomingForAMonthUrl);
//		  $http.post(getFAQCountOfCandidatesAssessmentUpcomingForAMonthUrl).then(function(month)
//						{
//					     console.log(month.data);
//					     $scope.month = month.data;
//
//						});
//		  }
//	     
//	}
//	]);
//
//
//
//app.controller('FAQCountTotalNumberOfBatchesInAParticularStateController', ['$scope', '$http', function ($scope, $http) {
//	   $scope.stateDropDownOptions = ['Andhra Pradesh','Arunachal Pradesh','Assam','Bihar','Chhattisgarh','Delhi','Goa','Gujarat','Haryana','Himachal Pradesh','Jammu & Kashmir','Jharkhand','Karnataka','Kerala','Madhya Pradesh','Maharastra','Manipur','Meghalaya','Mizoram','Nagaland','Odisha','Punjab','Rajasthan','Sikkim','Tamil Nadu','Telangana','Tripura','Uttarakhand','Uttar Pradesh','West Bengal'];
//	  var queryParameter = $scope.stateDropDownOptions;
//	  $scope.getDataOfState = function getDataOfState() {
//		  var getFAQCountTotalNumberOfBatchesInAParticularStateUrl = "/getFAQCountTotalNumberOfBatchesInAParticularState?state="+$scope.selectedState;
//		  console.log($scope.selectedState);
//		  console.log(getFAQCountTotalNumberOfBatchesInAParticularStateUrl);
//		  $http.post(getFAQCountTotalNumberOfBatchesInAParticularStateUrl).then(function(state)
//						{
//					     console.log(state.data);
//ata;
//
//						});
//		  }
//	 