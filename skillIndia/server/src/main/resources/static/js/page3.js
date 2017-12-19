var page3 = angular.module('hello');

page3.controller('page3',function($scope, $http, fileUploadDataImport, zipCertificateUpload) {
    $scope.dataImportHistory = {
    	  enableGridMenus : false,
    	  enableSorting: false,
    	  enableFiltering: false,
    	  enableCellEdit : false,
    	  enableColumnMenus : false,
       enableHorizontalScrollbar:0,
       enableVerticalScroll:1,

    columnDefs:[
    	  { name: 'SNo',           displayName: 'SNo.',              cellClass:'sno',  headerCellClass:'layer', cellTemplate: '<div class="ui-grid-cell-contents">{{grid.renderContainers.body.visibleRowCache.indexOf(row)+1}}</div>' },
          { name: 'csvname',            displayName: 'File Name',          cellClass:'fname',headerCellClass:'File-Name'},
    	  { name: 'csvtype',            displayName: 'Type',               cellClass:'type', headerCellClass:'Type'},
    	  { name: 'csv_Upload_Date',    displayName: 'Date',               cellClass:'date', headerCellClass:'Date', cellFilter: 'date:\'dd/MM/yyyy\''},
    	  { name: 'csv_Upload_UserId',  displayName: 'Uploaded By',        cellClass:'uby',  headerCellClass:'Uploaded-By'},
    	  { name: 'View Uploaded File', displayName: 'View Uploaded File', cellClass:'vub',  headerCellClass:'View-Uploaded-File', cellTemplate: '<img src="/images/CSVDownloadIcon.png" ng-click=grid.appScope.download(row)>'}
    	       ]
      };

$scope.dataImport={};

      $scope.download = function(rowData){
    	  var  fileName = rowData.entity.csvname;
   	   console.log("the row value is >>>" + rowData.entity.csvname);
   	  var urldata = "/downloadCSVFile/"+ fileName;
    	  window.open(urldata);
      };
         $http.get("/importHistory")
          .then(function(response){
        	  $scope.dataImportHistory.data = response.data;

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

     	var file = $scope.dataImport.uploadCsvFile;
     	console.log('File selected is :'+file);
     	var csvType = $scope.csvType;

         var uploadUrl = "/upload";
       fileUploadDataImport.uploadFileToUrl(file, csvType, uploadUrl);
       $http.get("/importHistory")
       .then(function(response){
     	  $scope.dataImportHistory.data = response.data;

     });

     };
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
enableVerticalScroll:1,

columnDefs:[
{ name: 'SNo',             displayName: 'SNo',                cellClass:'sno',   headerCellClass:'layer', cellTemplate: '<div class="ui-grid-cell-contents">{{grid.renderContainers.body.visibleRowCache.indexOf(row)+1}}</div>' },
{ name: 'batchID',           displayName: 'Batch ID',           cellClass:'date',  headerCellClass:'Date'},
{ name: 'batchEndDate',         displayName: 'Batch End Date',     cellClass:'date',  headerCellClass:'Date'},
{ name: 'certificateName',      displayName: 'File Name',          cellClass:'fname', headerCellClass:'File-Name'},
{ name: 'userId',      displayName: 'Uploaded By',        cellClass:'uby',   headerCellClass:'Uploaded-By'},
{ name: 'certificateUploadDate',displayName: 'Date',               cellClass:'date',  headerCellClass:'Date'},
{ name: 'View Uploaded File',  displayName: 'View Uploaded File', cellClass:'vub',   headerCellClass:'View-Uploaded-File', cellTemplate: '<img src="/icon/CertificateDownlad/Certificate Download.png" ng-click=grid.appScope.downloadCertificate(row)>'}
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

                     //{ name:'SNo' ,            displayname:'SNo',       cellClass:'batch id',    headerCellClass:'layer' ,     cellTemplate:"1"},
                     { name:'batchId' ,     displayname:'Batch id' },
                     { name:'batchName' ,    displayname:'Batch Name'},
                     { name:'batchStartDate' ,   displayname:'Batch Start date'},
                     { name:'batchEndDate' ,      displayname:'Batch End date'},
                     { name:'trainingPartnerName',displayname:'Training Partner Name'},
                     { name:'view', displayName:'Upload Certificate',cellClass:'fname', headerCellClass:'File-Name',width:200,  cellTemplate:  '<label> <input type="file" id="uploadFile" accept=".zip" file-model/ ng-click=grid.appScope.selectLocation(row)></label>'},
                     {name:'viewNAme', displayName:'Upload File', cellClass:'fname',headerCellClass:'File-Name',   cellTemplate:  '<label> <img src="icon/indexPageIcons/tick.png" ng-click=grid.appScope.uploadCertificate(row)></label>'}
                   ]
   };



 $scope.getDataOfBatch = function()
 {
	 console.log($scope.dataImportBatchIdSearch);
  $http.post('/findBatch?batchId='+$scope.dataImportBatchIdSearch)
  .then(function(response) {
     console.log("inside request method");
     //console.log(response.data);
     var err;

     if(response.data[0] == null)
      {
      //console.log('In the NULL')
      var exists= document.getElementById("responseMessage");
      $scope.searchBatch.data = response.data;
      //exists.style.color = "Red";
      $scope.errorMessage="No Record Found";
      //console.log('YE AAY ANULL');
      }
      //console.log("Error");

     else
     {
      $scope.searchBatch.data = response.data;
      $scope.errorMessage="";
     }
    });
 };


 $scope.uploadCertificate = function(rowData){

	 var  batchId = rowData.entity.batchId;
//	 console.log('Batch Id is:'+batchId);
	 var file = $scope.uploadCertificate;
//	 console.log("File is "+file);
     var url = '/uploadCertificate';
     zipCertificateUpload.uploadZip(batchId,url);
 };


});