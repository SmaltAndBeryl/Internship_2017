var app = angular.module('app', [ 'ui.grid', 'ui.grid.edit', 'ui.grid.cellNav']);

app.controller('MainCtrl', ['$scope', '$http', function ($scope, $http) {
	
	
	$scope.gridOptions = {
			  enableGridMenus : false,  
			  enableSorting: false, 
			  enableFiltering: false,
			  enableCellEdit : false,
			  enableColumnMenus : false,
	};
	  
    $scope.gridOptions.columnDefs = [
		{ name: '#', width: 200},
      	{ name: 'Institution name', width: 200  },
		{ name: 'Type', width: 200},
		{ name: 'Date', width: 200},
		{ name: 'Action', cellTemplate: '<button class="btn primary" ng-click="grid.appScope.confirmfunction(); grid.appScope.deleteRow(row)">&#10004</button>' }
    ];
  
	$http.get('/poc/MR_ApproveRejectFormTable_SampleData.json')
    		.success(function(data) {
    			$scope.gridOptions.data = data;
    })
  
    $scope.confirmfunction = function(){
	    	console.log("Function Reached");
	    	$scope.deleteRow = function(row) {
	    	    var index = $scope.gridOptions.data.indexOf(row.entity);
	    	    $scope.gridOptions.data.splice(index, 1);
	    	  };
	    	$http.get('/MR_Approve_Table')
	    		.success(function (data) {
//	    			$scope.gridOptions.data = data;
	    			console.log("data populated");
	    		});
}
}]);