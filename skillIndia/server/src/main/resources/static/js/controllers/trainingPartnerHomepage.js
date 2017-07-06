var app = angular.module('app', [ 'ui.grid', 'ui.grid.edit', 'ui.grid.cellNav','ui.grid.autoResize']);


	 
app.controller('PresentCtrl',['$scope','$http', function($scope,$http){
	$scope.gridOptions={
		enableSorting: false,
		enableGridMenus:false,  
		enableSorting: false, 
		enableFiltering: false,
		enableCellEdit : false,
		enableColumnMenus : false,
		enableHorizontalScrollbar:0,
		enableVerticalScrollbar:0,
			
		columnDefs:[
			{name:'batchId',displayname:'Batch ID', cellClass:'bId',  headerCellClass:'Batch-Id' },
			{name:'completionDate', displayname:'Completion Date', cellClass:'cDate',  headerCellClass:'Comp-Date'},
			{name:'instructorName', displayname:'Instructor Name', cellClass:'iName', headerCellClass:'Ins-Name'},
			{name:'noOfCandidates', displayname:'Number of Candidates', cellClass:'no-Candidates', headerCellClass:'Candidates'}
			]			 		            			            	
	};
			
			 $http.get("192.168.4.120:8080/trainingPartnerPastBatches")
			    .success(function (data) {
			      $scope.gridOptions.data= data;
			    })
		}]);
    
    
    
    
    
    app.controller('PastCtrl',['$scope','$http', function($scope,$http){
		
		$scope.gridOptions={
				enableSorting: false,
				enableGridMenus:false,  
				enableSorting: false, 
			    enableFiltering: false,
			    enableCellEdit : false,
			    enableColumnMenus : false,
			    enableHorizontalScrollbar:0,
			    enableVerticalScrollbar:0,
		columnDefs:[
		{name:'batchId',displayname:'Batch ID', cellClass:'bId',  headerCellClass:'Batch-Id' },
		{name:'completionDate', displayname:'Completion Date', cellClass:'cDate',  headerCellClass:'Comp-Date'},
		{name:'instructorName', displayname:'Instructor Name', cellClass:'iName', headerCellClass:'Ins-Name'},
		{name:'noOfCandidates', displayname:'Number of Candidates', cellClass:'no-Candidates', headerCellClass:'Candidates'},
		{name:'Display', displayName: 'Download Certificate', cellClass:'dowCer',  headerCellClass:'down-cer', cellTemplate: '<img src="/images/CSVDownloadIcon.png" ng-click=grid.appScope.myfunction()>', width: 165}
		]			 		            			            	
		};
		
		 $http.get("192.168.4.120:8080/trainingPartnerPastBatches")
		    .success(function (data) {
		      $scope.gridOptions.data= data;
		    })
	}]);