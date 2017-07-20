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





imp.service('fileUpload', ['$http', function ($http) {

}]);


imp.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function() {
                scope.$apply(function() {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);




function importController($scope, $http, $fileUpload){
  //refresh();
	
	/*
	 * CSV UPLOAD HISTORY TABLE 
	 */
	
	

$scope.gridOptions = {
	  enableGridMenus : false,  
	  enableSorting: false, 
	  enableFiltering: false,
	  enableCellEdit : false,
	  enableColumnMenus : false,
      enableHorizontalScrollbar:0,
	  
columnDefs:[
	  { name: 'SNo',                displayName: 'SNo',                cellClass:'sno',  headerCellClass:'layer', cellTemplate: '<div class="ui-grid-cell-contents">{{grid.renderContainers.body.visibleRowCache.indexOf(row)+1}}</div>'},
      { name: 'csvname',            displayName: 'File Name',          cellClass:'fname',headerCellClass:'File-Name'},
	  { name: 'csvtype',            displayName: 'Type',               cellClass:'type', headerCellClass:'Type'},
	  { name: 'csv_Upload_Date',    displayName: 'Date',               cellClass:'date', headerCellClass:'Date', cellFilter: 'date:\'dd/MM/yyyy\''},
	  { name: 'csv_Upload_UserId',  displayName: 'Uploaded By',        cellClass:'uby',  headerCellClass:'Uploaded-By'},
	  { name: 'View Uploaded File', displayName: 'View Uploaded File', cellClass:'vub',  headerCellClass:'View-Uploaded-File', cellTemplate: '<img src="/images/CSVDownloadIcon.png" ng-click=grid.appScope.download(row)>'}
	       ]
  };


	
	
  $scope.download = function(rowData){
	  var  fileName = rowData.entity.csvname;
	  console.log("the row value is >>>" + rowData.entity.csvname);
	  var urldata = "/downloadCSVFile/"+ fileName;
	  window.open(urldata);
  };
  
  $scope.uploadCSV = function(){

	  console.log('file is ');
	  console.dir(file);

	  var uploadUrl = "/uploadCertificate";
	  fileUpload.uploadFileToUrl(file, uploadUrl);
	  };
  
     $http.get("/importHistory")
      .then(function(response){
    	  $scope.gridOptions.data = response.data;
    });
     
     /*
      * UPLOAD CSV BUTTON
      */
     $scope.uploadFileToUrl = function (file,uploadUrl) {
         var fd = new FormData();
         
//         fd.append('csvType', csvType);
       fd.append('file', file);
//         console.log(csvType);
         console.log(fd);
         
         $http({
         	method: 'POST',
         	url: uploadUrl,
             data: fd,
             headers: {'Content-Type': undefined},
             responseType: 'text',
             transformRequest: angular.identity,
             transformResponse: [function (data) {
             	console.log(data);
             	return data;
             }]
         }).then(function(response) {
             console.log('Success: '+response.data); 
             console.log('a= '+JSON.stringify(response.data));
             console.log("response of success -----"+response);
             return response.data;
             
         }, function errorCallback(response) {
         	console.log("Error in receiving response from backend------" +response);
             console.log('Error: '+response);
          });
         
     }
     
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
     
  
     
     /*
      * CERTIFICATE IMPORT HISTORY TABLE 
      */

$scope.certificateImportHistory = {
enableGridMenus : false,
enableSorting: false,
enableFiltering: false,
enableCellEdit : false,
enableColumnMenus : false,
enableHorizontalScrollbar:0,

columnDefs:[
{ name: 'SNo',           		displayName: 'SNo',                cellClass:'sno',   headerCellClass:'layer', cellTemplate: '<div class="ui-grid-cell-contents">{{grid.renderContainers.body.visibleRowCache.indexOf(row)+1}}</div>' },
{ name: 'batchID',          	displayName: 'Batch ID',           cellClass:'date',  headerCellClass:'Date'},
{ name: 'batchEndDate',         displayName: 'Batch End Date',     cellClass:'date',  headerCellClass:'Date'},
{ name: 'certificateName',      displayName: 'File Name',          cellClass:'fname', headerCellClass:'File-Name'},
{ name: 'userId',  				displayName: 'Uploaded By',        cellClass:'uby',   headerCellClass:'Uploaded-By'},
{ name: 'certificateUploadDate',displayName: 'Date',               cellClass:'date',  headerCellClass:'Date'},
{ name: 'View Uploaded File', 	displayName: 'View Uploaded File', cellClass:'vub',   headerCellClass:'View-Uploaded-File', cellTemplate: '<img src="/icon/Certificateicons/Certificate Download.png" ng-click=grid.appScope.downloadCertificate(row)>'}
  ]
};
$scope.downloadCertificate = function(rowData){
	
	 var  fileName = rowData.entity.certificateName;
	  console.log("the row value is >>>" + rowData.entity.certificateName);
	  var urldata = "/downloadCertificate/"+ fileName;
	
	  window.open(urldata);
};

$http.get("/certificateImportHistory")
.then(function(response){
 $scope.certificateImportHistory.data = response.data;
});

/*
 * UPLOAD CERTIFICATE USING BATCH ID TABLE  
 */

$scope.searchBatch = {
		  enableGridMenus : false,  
		  enableSorting: false, 
		  enableFiltering: false,
		  enableCellEdit : false,
		  enableColumnMenus : false,
	      enableHorizontalScrollbar:0,
		  
	      columnDefs : [
                        
	                    //{ name:'SNo' , 		         displayname:'SNo',					  cellClass:'batch id',	   headerCellClass:'layer' ,				 cellTemplate:"1"},
	                    { name:'batchId' ,  		 displayname:'Batch id' , 			  cellClass:'batch id', headerCellClass:'Date'},
	                    { name:'batchName' , 		 displayname:'Batch Name' , 	      cellClass:'batch id', headerCellClass:'Date'},
	                    { name:'batchStartDate' , 	 displayname:'Batch Start date',	  cellClass:'date',	   headerCellClass:'Date'},
	                    { name:'batchEndDate' ,      displayname:'Batch End date',		  cellClass:'date',	   headerCellClass:'Date'},
	                    { name:'trainingPartnerName',displayname:'Training Partner Name', cellClass:'fname',    headerCellClass:'File-Name'},
	                    { name: 'View Uploaded File',displayName:'Uploaded File', 		  cellClass:'vub',      headerCellClass:'View-Uploaded-File', cellTemplate:  ' <form action="/downloadCertificate/ab" method="post" enctype="multipart/form-data"><input type="file" accept=".zip" name="file" /><input type="submit" value="submit" /></form>'}
	                  ]
	  };



	$scope.getDataOfBatch = function()
	{
		$http.post('/findBatch?batchId='+$scope.batchId)
		.then(function(response) {
			  console.log("inside request method");
			  //console.log(response.data);
			  var err;
			  
			  if(response.data[0] == null)
				  {
				  var exists= document.getElementById("responseMessage");
				  exists.style.color = "Red";
				  $scope.errorMessage="No Record Found";
				  console.log('YE AAY ANULL');
				  }
				  //console.log("Error");
			  
			  else
				  $scope.searchBatch.data = response.data;
		  });
	};
	
	
	$scope.UploadCertificate = function(rowData){
		
		var  batchId = rowData.entity.batchName;
		//uploadCSV($scope);
		console.log(rowData.entity.batchName);
		$http.post('/uploadCertificate')
		.then(function(response) {
			
		  });
			
		  console.log("the row value is >>>" + rowData.entity.batchName);
		  var urldata = "/downloadCertificate/"+ fileName;
		
		  window.open(urldata);
	};
	
	

}


