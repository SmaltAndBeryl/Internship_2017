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
	  
columnDefs:[
	  { name: 'SNo',           displayName: '#',              cellClass:'sno',  headerCellClass:'layer', width: 55, cellTemplate: '<div class="ui-grid-cell-contents">{{grid.renderContainers.body.visibleRowCache.indexOf(row)+1}}</div>' },
      { name: 'csvname',            displayName: 'File Name',          cellClass:'fname',headerCellClass:'File-Name', width: 132},
	  { name: 'csvtype',            displayName: 'Type',               cellClass:'type', headerCellClass:'Type', width: 221},
	  { name: 'csv_Upload_Date',    displayName: 'Date',               cellClass:'date', headerCellClass:'Date', width: 150, cellFilter: 'date:\'dd/MM/yyyy\''},
	  { name: 'csv_Upload_UserId',  displayName: 'Uploaded By',        cellClass:'uby',  headerCellClass:'Uploaded-By', width: 210},
	  { name: 'View Uploaded File', displayName: 'View Uploaded File', cellClass:'vub',  headerCellClass:'View-Uploaded-File', cellTemplate: '<img src="/images/CSVDownloadIcon.png" ng-click=grid.appScope.myfunction()>', width: 165}
	       ]
                     };
 $scope.myfunction = function()
 {
	 location.href = 'http://localhost:8080/approve';
 };
  
     function refresh(){
     $http.get("/importHistory")
     .success(function (data){
      $scope.gridOptions.data = data;
    });
  }
}
  
]);