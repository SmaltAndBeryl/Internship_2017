var page3 = angular.module('hello');

page3.controller('page3',function($scope, $http, $window,$timeout,fileUploadDataImport, zipCertificateUpload) {
    $scope.dataImportHistory = {
    	  enableGridMenus : false,
    	  enableSorting: false,
    	  enableFiltering: false,
    	  enableCellEdit : false,
    	  enableColumnMenus : false,
       enableHorizontalScrollbar:0,
       enableVerticalScrollbar:1,
       paginationPageSizes: [5, 10, 20, 30],
       paginationPageSize: 10,
       useExternalPagination: true,
       useExternalPagination: true,

    columnDefs:[
          { name: 'csvname',            displayName: 'File Name',          cellClass:'fname',headerCellClass:'File-Name', width: "37%"},
    	  { name: 'csvtype',            displayName: 'Type',               cellClass:'type', headerCellClass:'Type', width: "15%"},
    	  { name: 'csv_Upload_Date',    displayName: 'Date',               cellClass:'date', headerCellClass:'Date',width:"13%", cellFilter: 'date:\'dd/MM/yyyy\''},
    	  { name: 'csv_Upload_UserId',  displayName: 'Uploaded By',        cellClass:'uby',  headerCellClass:'Uploaded-By', width:"23%"},
    	  { name: 'View Uploaded File', displayName: 'View Uploaded File', cellClass:'vub',  headerCellClass:'View-Uploaded-File', width:"14%",cellTemplate: '<img src="/images/CSVDownloadIcon.png" class="pointer" ng-click=grid.appScope.download(row)>'}
    	       ]
      };

$scope.dataImport={};

      $scope.download = function(rowData){
    	  var  fileName = rowData.entity.csvname;
    	  
   	   //console.log("the row value is >>>" + rowData.entity.csvname);
    	  var checkFileUrl = "/checkFile?file_name="+ rowData.entity.csvname;
    	  
    	  $http.get(checkFileUrl).then(function(response){
    		  if (response.data == 1)
    			  {
    		   	  var urldata = "/downloadCSVFile/"+ fileName;
    	    	  $window.open(urldata);
    			  }
    		  else if(response.data == 0)
    			  {
    			  $scope.successText = "Could not find file - " + fileName;
    	          $scope.successTextColor = "red";
    	          $scope.rolling = false;
    			  }
    		  else if (response.data == -1)
    			  {
    			  $scope.successText = "File Name is empty";
    	          $scope.successTextColor = "red";
    	          $scope.rolling = false;
    			  }
    		  else if (response.data == -2)
    			  {
    			  $scope.successText = "An exception occured in downloading csv file - "+ fileName;
    	          $scope.successTextColor = "red";
    	          $scope.rolling = false;
    			  }
    		  $timeout(function() {
                  $scope.successText="";
               }, 2000);
    	  }, function(errorResponse){
    		  $scope.successText = errorResponse.data;
	          $scope.successTextColor = "red";
	          $scope.rolling = false;
	          
	          $timeout(function() {
                  $scope.successText="";
               }, 2000);
    	  }
    			  );

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
     	//console.log('File selected is :'+file);
     	var csvType = $scope.csvType;

         var uploadUrl = "/upload";
       var fileuploaded = fileUploadDataImport.uploadFileToUrl(file, csvType, uploadUrl);
       
       fileuploaded.then(function(response){
    	  // //console.log("aa gya yahan pe");
       },
       function(errorResponse){
    	   
       });
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
{ name: 'View Uploaded File',  displayName: 'View Uploaded File', cellClass:'vub',   headerCellClass:'View-Uploaded-File', cellTemplate: '<img src="/icon/CertificateDownlad/Certificate Download.png" class="pointer" ng-click=grid.appScope.downloadCertificate(row)>'}
  ]
};
$scope.downloadCertificate = function(rowData){

  var  fileName = rowData.entity.certificateName;
   //console.log("the row value is >>>" + rowData.entity.certificateName);
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
                     { name:'batchId' ,     displayname:'Batch id' , width: "10%"},
                     { name:'batchName' ,    displayname:'Batch Name', width:"15%"},
                     { name:'batchStartDate' ,   displayname:'Batch Start date', width:"12%"},
                     { name:'batchEndDate' ,      displayname:'Batch End date',width:"12%"},
                     { name:'trainingPartnerName',displayname:'Training Partner Name',width:"23%"},
                     { name:'view', displayName:'Upload Certificate',cellClass:'fname', headerCellClass:'File-Name',width:"13%" , cellTemplate:  '<label> <input type="file" id="uploadFile" accept=".zip" file-model/ ng-click=grid.appScope.selectLocation(row)></label>'},
                     {name:'viewNAme', displayName:'Upload File', cellClass:'fname',headerCellClass:'File-Name',   cellTemplate:  '<label> <img src="icon/indexPageIcons/tick.png" ng-click=grid.appScope.uploadCertificate(row)></label>', width:"15%"}
                   ]
   };



 $scope.getDataOfBatch = function()
 {
	 //console.log($scope.dataImportBatchIdSearch);
  $http.post('/findBatch?batchId='+$scope.dataImportBatchIdSearch)
  .then(function(response) {
     //console.log("inside request method");
     ////console.log(response.data);
     var err;

     if(response.data[0] == null)
      {
      ////console.log('In the NULL')
      var exists= document.getElementById("responseMessage");
      $scope.searchBatch.data = response.data;
      //exists.style.color = "Red";
      $scope.errorMessage="No Record Found";
      ////console.log('YE AAY ANULL');
      }
      ////console.log("Error");

     else
     {
      $scope.searchBatch.data = response.data;
      $scope.errorMessage="";
     }
    });
 };


 $scope.uploadCertificate = function(rowData){

	 var  batchId = rowData.entity.batchId;
//	 //console.log('Batch Id is:'+batchId);
	 var file = $scope.uploadCertificate;
//	 //console.log("File is "+file);
     var url = '/uploadCertificate';
     zipCertificateUpload.uploadZip(batchId,url);
     $http.get("/certificateImportHistory")
     .then(function(response){
      $scope.certificateImportHistory.data = response.data;
     },
     function(errorResponse){
    	 //console.log("error");
     });
 };


});