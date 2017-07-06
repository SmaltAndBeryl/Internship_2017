var app = angular.module('app', [ 'ui.grid', 'ui.grid.edit', 'ui.grid.cellNav']);

app.controller('FAQScreenController', ['$scope', '$http', function ($scope, $http) {
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
		{ name: 'totalNoOfTrained' diplayname: 'Trained', width: 250},
		{ displayname: 'Assessed', width:250},
		{ displayname: 'Certified', width:250}
    ]
  };
  var queryParameter = $scope.schemeDropDownOptions;
  $scope.getDataOfScheme = function getDataOfScheme() {
	  var FAQURI = "/192.168.3.29:8080/getFAQTotalCandidatesTrainedAssessedCertifiedSchemeWise?batchType";
	  console.log($scope.selectedScheme);
	  console.log('192.168.3.29:8080/getFAQTotalCandidatesTrainedAssessedCertifiedSchemeWise?batchType='+ $scope.schemeDropDownOptions)
	  $http({
		  url : FAQURI,
		  method : "POST",
		  data : angular.toJson($scope.selectedScheme),
		  headers : {
			  'Content-type': 'application/json'
					}
		  }).then(function(response)
					{
				     console.log(response);
				     $scope.gridOptions.data = response;
					});
	  }
     
}
]);



