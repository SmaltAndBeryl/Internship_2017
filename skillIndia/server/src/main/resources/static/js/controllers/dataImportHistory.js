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

importController.$inject = ['$scope', '$http', 'fileUpload'];

function importController($scope, $http, $fileUpload){
  //refresh();
	

$scope.gridOptions = {
///*	  enableGridMenus : false,  
//	  enableSorting: false, 
//	  enableFiltering: false,
//	  enableCellEdit : false,
//	  enableColumnMenus : false,
//  */    enableHorizontalScrollbar:0,
	  
columnDefs:[
	  { name: 'SNo',           displayName: '#',              cellClass:'sno',  headerCellClass:'layer', cellTemplate: '<div class="ui-grid-cell-contents">{{grid.renderContainers.body.visibleRowCache.indexOf(row)+1}}</div>' },
      { name: 'csvname',            displayName: 'File Name',          cellClass:'fname',headerCellClass:'File-Name'},
	  { name: 'csvtype',            displayName: 'Type',               cellClass:'type', headerCellClass:'Type'},
	  { name: 'csv_Upload_Date',    displayName: 'Date',               cellClass:'date', headerCellClass:'Date', cellFilter: 'date:\'dd/MM/yyyy\''},
	  { name: 'csv_Upload_UserId',  displayName: 'Uploaded By',        cellClass:'uby',  headerCellClass:'Uploaded-By'},
	  { name: 'View Uploaded File', displayName: 'View Uploaded File', cellClass:'vub',  headerCellClass:'View-Uploaded-File', cellTemplate: '<img src="/images/CSVDownloadIcon.png" ng-click=grid.appScope.download(row)>'}
	       ]
  };

	
  $scope.download = function(rowData){
	  var  index = Object.values(Object.values(rowData)[1])[0];
	  console.log("Row Data is " + index);
	  var urldata = "/files/"+ index;
	  window.open(urldata);
  };
     $http.get("/importHistory")
      .then(function(response){
    	  $scope.gridOptions.data = response.data;
    	  var obj = $scope.gridOptions.data[0].csvname;
    	  var str = JSON.stringify(obj)
    	  console.log(Object.values(obj)+ "     sasas    "+ str);

   
    });
     $scope.optionValues = [{
         id: 'Batch',
         name: 'Batch'
     },{
         id: 'Candidate',
         name:'Candidate'
     },{
         id: 'Training Partner',
         name: 'Training Partner'
     },{
         id: 'Trainer',
         name: 'Trainer'
     },{
         id: 'Assessment Agency',
         name: 'Assessment Agency'
     },{
         id: 'Centre',
         name: 'Centre'
     },{
         id: 'Employer',
         name: 'Employer'
    },{
         id: 'Assessor',
         name: 'Assessor'
     }];
     $scope.uploadCSV = function(){
         
     	var file = $scope.csvFile;
     	var csvType = $scope.csvType;
               
         var uploadUrl = "/upload";
         fileUpload.uploadFileToUrl(file, csvType, uploadUrl);
         
     };
     
}





