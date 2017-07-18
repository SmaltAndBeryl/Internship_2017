//var app = angular.module('app', ['ui.grid', 'ui.grid.edit', 'ui.grid.cellNav']);

var manage = angular
                    .module('manage', [
                        'ui.grid',
                        'ui.grid.edit',
                        'ui.grid.cellNav'
                    ]);

//app.controller('MainCtrl', ['$scope', '$location', '$http', function ($scope, $location, $http) {
manage.controller('manageController', manageController);

manageController.$inject = ['$scope', '$location', '$http'];

function manageController($scope, $location, $http){
	$scope.messagealert= false;
  //refresh();
       
  $scope.gridOptions = {
         enableGridMenus : false,  
         enableSorting: false, 
         enableFiltering: false,
         enableCellEdit : false,
         enableColumnMenus : false,
         paginationPageSizes: [10, 2, 50],
         paginationPageSize: 2,   
         useExternalPagination: true,   
         columnDefs: [
              { name: 'applicationId', displayName: '#', cellClass:'sno',headerCellClass:'Institution-Name', width: 30},
      { name: 'applicationState', displayName: 'Institution Name' ,cellClass:'fname',headerCellClass:'Institution-Name' },
              { name: 'activeFlag',displayName: 'Type' , cellClass:'Type',headerCellClass:'Institution-Name'},
              { name: 'dateOfSubmission', displayName: 'Date',cellClass:'layer',headerCellClass:'Institution-Name'},
              { name: 'userId', displayName:'View Application', cellTemplate:'<img src="icon/indexPageIcons/pdf.png" ng-click=grid.appScope.myfunction()>',headerCellClass:'Institution-Name', cellClass:'va',width:120},
              { name: 'Comments', displayName:'Comments' ,enableCellEdit: true,headerCellClass:'Institution-Name',cellClass:'va'},
        { name: 'Action', displayName:'Action' , cellTemplate: '<label><img src="icon/indexPageIcons/edit.png"  ng-click=grid.appScope.myfunctionedit(row)>&nbsp; &nbsp; &nbsp<img src="icon/indexPageIcons/tick.png" ng-click=grid.appScope.myfunctionapprove(row)>  &nbsp; &nbsp; <img src="icon/indexPageIcons/close.png"  ng-click=grid.appScope.myfunctionreject(row)></label>',headerCellClass:'Institution-Name',cellClass:'va'}
              
    ]
  }; 
  
  
  
  
  //function for edit functionalities
  
    $scope.myfunctionedit = function(rowData){
    	$scope.messagealert= false;
    	var editdetailsOfApplication = {    			
    						applicationState: 'incomplete',
    						applicationId: rowData.entity.applicationId,
    						comment : rowData.entity.Comments
    								}
    	//console.log(dataOfRow[0][0]);
    	console.log(rowData.entity.Comments);
    	console.log(editdetailsOfApplication);
    	//grid.getCellValue(row,col);
    	 //var abj = Object.values(rowData)[1];
        //console.log("Row Data is " + abj);
    	
		var manageControllerURI = "/setManageRegistrationsComment";
		console.log(manageControllerURI);
				console.log("click is working");
					$http({
						url : manageControllerURI,
						method : "POST",
						
						data: angular.toJson(editdetailsOfApplication)
					}).then(
							function(response)
							{
								$scope.message = response.data.successMessage;
								$scope.messagealert= true;
							},
							function(errorResponse, status)
							{
								$scope.message = response.data.errorMessage;
								$scope.messagealert= true;
							}
							)
    };

    
    
    
    //function for approve functionalities
    
    $scope.myfunctionapprove = function(rowData){
    	$scope.messagealert= false;
        alert("are you sure you want to accept this application")
        
       
        
        var editDetailsOfApplication = {
        		'applicationState' : 'approved',
        		'applicationId' : rowData.entity.applicationId,
        		'activeFlag' : 'true',
        		'userId': rowData.entity.userId
        }
              
            console.log(rowData.entity.applicationId);
            console.log(editDetailsOfApplication);
        
        
        var manageControllerURI = "/affiliationActionOfAnApplicant";
        console.log(manageControllerURI);
		console.log("click is working");
			$http({
				url : manageControllerURI,
				method : "POST",
				data: angular.toJson(editDetailsOfApplication),
			}).then(function(response){
				var message = response.data.successMessage;
				console.log(response.data);
				$scope.message = response.data.successMessage;
				
				$scope.messagealert= true;
				
			},
			function(errorResponse, status)
			{			
				alert(error.data.errorMessage);
				$scope.message = response.data.errorMessage;
				$scope.messagealert = true;

			}
			)
			
};
			

	//function for reject functionalities

    $scope.myfunctionreject = function(rowData){
    	 alert("are you sure you want to accept this application")
    	 $scope.messagealert= false;
    	
        
    	var rejectApplicationData = {
        		'applicationState':'rejected',
        		'applicationId': rowData.entity.applicationId,
        		'userId': rowData.entity.userId,
        		'activeFlag': "false"
   }
        
        var manageControllerURI = "/affiliationActionOfAnApplicant";
        console.log(manageControllerURI);
		console.log("click is working");
			$http({
				url : manageControllerURI,
				method : "POST",
				data: angular.toJson(rejectApplicationData),
			}).then(function(response){
				$scope.message = response.data.successMessage;
				$scope.messageAlert = true;
				console.log(response.data.successMessage);
			},
			function(errorResponse, status)
			{			
				console.log(error.data.errorMessage);
				$scope.message = error.data.errorMessage
				$scope.messageAlert = true;
			}
			)
};   
    
    
    $http.get('/approve?applicationState=submit')
    .then(function(response){
      $scope.gridOptions.data = response.data;
  });
    
//    // accepted table
//    
//    manage.controller('manageController', manageController);
//
//    manageController.$inject = ['$scope', '$location', '$http'];
//
//    function manageController($scope, $location, $http){
//      //refresh();
//           
      $scope.gridOptionsApproved = {
             enableGridMenus : false,  
             enableSorting: false, 
             enableFiltering: false,
             enableCellEdit : false,
             enableColumnMenus : false,
        
             columnDefs: [
                  { name: 'applicationId', displayName: '#', cellClass:'sno',headerCellClass:'Institution-Name', width: 30},
          { name: 'applicationState', displayName: 'Institution Name' ,cellClass:'fname',headerCellClass:'Institution-Name' },
                  { name: 'activeFlag',displayName: 'Type' , cellClass:'Type',headerCellClass:'Institution-Name'},
                  { name: 'dateOfSubmission', displayName: 'Date',cellClass:'layer',headerCellClass:'Institution-Name'}                  
                  
                 ]
      }; 
      $http.get('/approve?applicationState=approved')
      .then(function(response){
        $scope.gridOptionsApproved.data = response.data;
    });
      
      //for Incomplete Applications
    
      
      $scope.gridOptionsIncomplete = {
              enableGridMenus : false,  
              enableSorting: false, 
              enableFiltering: false,
              enableCellEdit : false,
              enableColumnMenus : false,
         
              columnDefs: [
                   { name: 'applicationId', displayName: '#', cellClass:'sno',headerCellClass:'Institution-Name', width: 30},
           { name: 'applicationState', displayName: 'Institution Name' ,cellClass:'fname',headerCellClass:'Institution-Name' },
                   { name: 'activeFlag',displayName: 'Type' , cellClass:'Type',headerCellClass:'Institution-Name'},
                   { name: 'dateOfSubmission', displayName: 'Date',cellClass:'layer',headerCellClass:'Institution-Name'},                  
                   { name: 'Comments', displayName:'Comments' ,enableCellEdit: true,headerCellClass:'Institution-Name',cellClass:'va'}
                  ]
       }; 
      
      $http.get('/approve?applicationState=incomplete')
      .then(function(response){
        $scope.gridOptionsIncomplete.data = response.data;
    }); 
//             //rejected table     
//              
//                  manage.controller('manageController', manageController);
//
//                  manageController.$inject = ['$scope', '$location', '$http'];
//
//                  function manageController($scope, $location, $http){
//                    //refresh();
//                         
                    $scope.gridOptionsRejected = {
                           enableGridMenus : false,  
                           enableSorting: false, 
                           enableFiltering: false,
                           enableCellEdit : false,
                           enableColumnMenus : false,
                      
                           columnDefs: [
                                { name: 'applicationId', displayName: '#', cellClass:'sno',headerCellClass:'Institution-Name', width: 30},
                        { name: 'applicationState', displayName: 'Institution Name' ,cellClass:'fname',headerCellClass:'Institution-Name' },
                                { name: 'activeFlag',displayName: 'Type' , cellClass:'Type',headerCellClass:'Institution-Name'},
                                { name: 'dateOfSubmission', displayName: 'Date',cellClass:'layer',headerCellClass:'Institution-Name'}
                                ]
                    };
                    $http.get('/approve?applicationState=rejected')
                    .then(function(response){
                      $scope.gridOptionsRejected.data = response.data;
                  });
                    
  }
