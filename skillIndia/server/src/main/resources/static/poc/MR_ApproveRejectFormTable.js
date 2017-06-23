var app = angular.module('app', [ 'ui.grid', 'ui.grid.edit', 'ui.grid.cellNav']);

app.controller('MainCtrl', ['$scope', '$http', function ($scope, $http) {
 
   
    $scope.deleteRow = function(row) {
    var index = $scope.gridOptions.data.indexOf(row.entity);
	//console.log($scope.gridOptions.data[0]);
	var obj = $scope.gridOptions.data[0];
	console.log(Object.values(obj));
		
		
	var temp = Object.values(obj)[5];
	
	console.log(Object.values(obj)[5]);
//	console.log(arr[1]);
    $scope.gridOptions.data.splice(index, 1);
  };
	
//	  $scope.saveRow = function (row) {
//        var promise = $http.post('data.json');
//		console.log(promise)
//        $scope.gridApi.rowEdit.setSavePromise($scope.gridApi.grid, rowEntity, promise.promise);
//        console.log(rowEntity);
//		  
//		  
//		  onRegisterApi: function (gridApi) {
//            $scope.gridApi = gridApi;
//            gridApi.rowEdit.on.saveRow($scope, $scope.saveRow);
//        }
		 
		  
	 refresh();
	
  $scope.gridOptions = {
	  enableGridMenus : false,  
	  enableSorting: false, 
	  enableFiltering: false,
	  enableCellEdit : false,
	  
	  enableColumnMenus : false,
    columnDefs: [
		{ name: '#'},
      	{ name: 'Institution name'  },
		{ name: 'Type'},
		{ name: 'Date'},
		{ name: 'Comments', enableCellEdit : true},
		{ name: 'Action', cellTemplate: '<button class="btn primary" ng-click="grid.appScope.deleteRow(row)">Accept</button>' }
    ]
  };
  
  function refresh() {
    $http.get('MR_ApproveRejectFormTable_SampleData.json')
    .success(function (data) {
      $scope.gridOptions.data = data;
    });
  }
}
  
]);