console.log("code reacxhed to imort.js");
//var app = angular.module('app', [ 'ui.grid', 'ui.grid.edit', 'ui.grid.cellNav','ui.grid.autoResize']);

var imp = angular
                    .module('imp', [
                        'ui.grid',
                        'ui.grid.edit',
                        'ui.grid.cellNav',
                        'ui.grid.autoResize'
                    ]);

//app.controller('MainCtrl', ['$scope', '$http', function ($scope, $http) {
 
imp.controller('importController', importController);

importController.$inject = ['$scope', '$http'];

function importController($scope, $http){
  //refresh();
	

$scope.gridOptions = {
	  enableGridMenus : false,  
	  enableSorting: false, 
	  enableFiltering: false,
	  enableCellEdit : false,
	  enableColumnMenus : false,
      enableHorizontalScrollbar:0,
	  
columnDefs:[
	  { name: 'SNo',           displayName: '#',              cellClass:'sno',  headerCellClass:'layer', cellTemplate: '<div class="ui-grid-cell-contents">{{grid.renderContainers.body.visibleRowCache.indexOf(row)+1}}</div>' },
      { name: 'csvname',            displayName: 'File Name',          cellClass:'fname',headerCellClass:'File-Name'},
	  { name: 'csvtype',            displayName: 'Type',               cellClass:'type', headerCellClass:'Type'},
	  { name: 'csv_Upload_Date',    displayName: 'Date',               cellClass:'date', headerCellClass:'Date', cellFilter: 'date:\'dd/MM/yyyy\''},
	  { name: 'csv_Upload_UserId',  displayName: 'Uploaded By',        cellClass:'uby',  headerCellClass:'Uploaded-By'},
	  { name: 'View Uploaded File', displayName: 'View Uploaded File', cellClass:'vub',  headerCellClass:'View-Uploaded-File', cellTemplate: '<img src="/images/CSVDownloadIcon.png" ng-click=grid.appScope.download()>'}
	       ]
                     };
// $scope.myfunction = function()
// {
//	 location.href = 'http://localhost:8080/approve';
// };
$scope.download = function(){
//	//http.get().then(function(file){ window.open(file,'_blank')});
//	
	 window.open("Sheets.csv", "_blank")
	}
  
     $http.get("/importHistory")
      .then(function(response){
       $scope.gridOptions.data = response.data;
    });
}
