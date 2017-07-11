var app = angular.module('app', [ 'ui.grid', 'ui.grid.edit', 'ui.grid.cellNav','ui.grid.autoResize']);


	 
app.controller('presentCtrl',['$scope','$http', function($scope,$http){
	$scope.gridOptions={
		enableSorting: false,
		enableGridMenus:false,  
		enableSorting: false, 
		enableFiltering: false,
		enableCellEdit : false,
		enableColumnMenus : false,
	
		columnDefs:[
			{name:'batchId', displayname:'Batch ID', cellClass:'bId',  headerCellClass:'batchId'},
			{name:'completionDate', displayname:'Completion Date', cellClass:'cDate',  headerCellClass:'compDate'},
			{name:'instructorName', displayname:'Instructor Name', cellClass:'iName', headerCellClass:'insName'},
			{name:'noOfCandidates', displayname:'Number of Candidates', cellClass:'no-Candidates', headerCellClass:'candidates'}
			]			 		            			            	
	};
			
			 $http.get("/trainingPartnerPastBatches")
			    .success(function (data) {
			      $scope.gridOptions.data= data.PresentBatches;
			    })
		}]);
    
    
    
    
    
    app.controller('pastCtrl',['$scope','$http', function($scope,$http){
		
		$scope.gridOptions={
				enableSorting: false,
				enableGridMenus:false,  
				enableSorting: false, 
			    enableFiltering: false,
			    enableCellEdit : false,
			    enableColumnMenus : false,
			    
		columnDefs:[
		{name:'batchId',displayname:'Batch ID', cellClass:'bId',  headerCellClass:'batchId' },
		{name:'completionDate', displayname:'Completion Date', cellClass:'cDate',  headerCellClass:'compDate'},
		{name:'instructorName', displayname:'Instructor Name', cellClass:'iName', headerCellClass:'insName'},
		{name:'noOfCandidates', displayname:'Number of Candidates', cellClass:'noCandidates', headerCellClass:'candidates'},
		{name:'Display', displayName: 'Download Certificate', cellClass:'download',  headerCellClass:'downCer', cellTemplate: '<img src="" ng-click=grid.appScope.myfunction()>'}
		]			 		            			            	
		};
		
		 $http.get("/trainingPartnerPastBatches")
		    .success(function (data) {
		      $scope.gridOptions.data= data.PastBatches;
		    })
	}]);