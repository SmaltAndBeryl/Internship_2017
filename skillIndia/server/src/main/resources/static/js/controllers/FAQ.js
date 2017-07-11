//var app = angular.module('app', [ 'ui.grid', 'ui.grid.edit', 'ui.grid.cellNav']);

var faq = angular.module('faq', ['ui.grid', 'ui.grid.edit', 'ui.grid.cellNav']);


faq.controller('faqController', faqController);

faqController.$inject = ['$scope', '$http'];

function faqController($scope, $http){
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
	    .then(function (response) {
	      $scope.gridOptions.data = response.data;
	    });
       }
}

//
//app.controller('FAQTotalTrainingCentresInAStateController',['$scope', '$http', function ($scope, $http) {
//	 //to fill data in scheme drop down
//	   $scope.stateDropDownOptions = ['Andhra Pradesh','Arunachal Pradesh','Assam','Bihar','Chhattisgarh','Delhi','Goa','Gujarat','Haryana','Himachal Pradesh','Jammu & Kashmir','Jharkhand','Karnataka','Kerala','Madhya Pradesh','Maharastra','Manipur','Meghalaya','Mizoram','Nagaland','Odisha','Punjab','Rajasthan','Sikkim','Tamil Nadu','Telangana','Tripura','Uttarakhand','Uttar Pradesh','West Bengal'];
//
//	  var queryParameter = $scope.stateDropDownOptions;
//	  $scope.getDataOfState = function getDataOfState() {
//		  var getTotalTrainingCenterUrl = "/getFAQTotalTrainingCentresInAState?state="+$scope.selectedState;
//		  console.log($scope.selectedState);
//		  console.log(getTotalTrainingCenterUrl);
//
//		  $http.post(getTotalTrainingCenterUrl).then(function(state)
//						{
//					     console.log(state.data);
//					     $scope.state = state.data;
////
//						});
//		  }
//
//	}
//	]);
//app.controller('FAQCountOfTotalTrainingCentresConductingTrainingController', ['$scope', '$http', function ($scope, $http) {
//	   $scope.schemeDropDownOptions = ['PMKVY','Non-PMKVY'];
//	  var queryParameter = $scope.schemeDropDownOptions;
//	  $scope.getDataOfScheme = function getDataOfScheme() {
//
//		  var getFAQCountOfTotalTrainingCentresUrl = "/getFAQCountOfTotalTrainingCentresConductingTraining?scheme="+$scope.selectedScheme;
//		  console.log($scope.selectedScheme);
//		  console.log(getFAQCountOfTotalTrainingCentresUrl);
//			  $http.get('/getFAQCountOfTotalTrainingCentresConductingTraining')
//			    .then(function (response) {
//			    	$scope.number=response.data;
//
//			    });
//		  }
//
//	}
//	]);