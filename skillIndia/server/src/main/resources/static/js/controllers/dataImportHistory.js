var app = angular.module('app', [ 'ui.grid', 'ui.grid.edit', 'ui.grid.cellNav','ui.grid.autoResize']);

app.controller('MainCtrl', ['$scope', '$http', function ($scope, $http) {
 refresh();
	

  $scope.gridOptions = {
	  enableGridMenus : false,  
	  enableSorting: false, 
	  enableFiltering: false,
	  enableCellEdit : false,
	  enableColumnMenus : false,
	  enableHorizontalScrollbar:0,
	  enableVerticalScrollbar:0,
	  
    columnDefs: [
		{ name: 'serialNo',           displayName: 'Serial Number',      cellClass:'sno',  headerCellClass:'layer'},
      	{ name: 'csvname',            displayName: 'File Name',          cellClass:'fname',headerCellClass:'File-Name'},
		{ name: 'csvtype',            displayName: 'Type',               cellClass:'type', headerCellClass:'Type'},
		{ name: 'csv_Upload_Date',    displayName: 'Date',               cellClass:'date', headerCellClass:'Date'},
		{ name: 'csv_Upload_UserId',  displayName: 'Uploaded By',        cellClass:'uby',  headerCellClass:'Uploaded-By'},
		{ name: 'View Uploaded File', displayName: 'View Uploaded File', cellClass:'vub',  headerCellClass:'View-Uploaded-File', cellTemplate: '<img src="/images/CSVDownloadIcon.png" ng-click=grid.appScope.myfunction()>'}
	
    ]
  
  };
  $scope.myfunction = function() 
  {  location.href = 'http://localhost:8080/approve';
};
  
  function refresh() {
    $http.get("/importHistory")
    .success(function (data) {
      $scope.gridOptions.data = data;
    });
  }
}
  
]);