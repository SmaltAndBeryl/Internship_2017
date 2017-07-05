var app = angular.module('app', [ 'ui.grid', 'ui.grid.edit', 'ui.grid.cellNav']);

app.controller('MainCtrl', ['$scope', '$http', function ($scope, $http) {
 
   
    $scope.deleteRow = function(row) {
    var index = $scope.gridOptions.data.indexOf(row.entity);
	var obj = $scope.gridOptions.data[0];
	console.log(Object.values(obj));
		
		
	var temp = Object.values(obj)[5];
	
	console.log(Object.values(obj)[5]);
    $scope.gridOptions.data.splice(index, 1);
  };
			  
	 refresh();
	
  $scope.gridOptions = {
	  enableGridMenus : false,  
	  enableSorting: false, 
	  enableFiltering: false,
	  enableCellEdit : false,
	  
	  enableColumnMenus : false,
    columnDefs: [
		{ name: 'Candidates', width: 400},
		{ name: 'Total No. Of Candidates', width:500}
    ]
  };
  
  function refresh() {
    $http.get('192.168.4.15:8080/getFAQTotalCandidatesTrainedAssessedCertifiedDao')
    .success(function (data) {
      $scope.gridOptions.data = data;
    });
  }
}
  
]);