var tpApp = angular
                   .module('tpApp', [ 
                            'ui.grid', 
                            'ui.grid.edit', 
                            'ui.grid.cellNav',
                            'ui.grid.autoResize'
                            ]);

  tpApp.controller('presentController', presentController);
  presentController.$inject=['$scope','$http'];

function presentController($scope, $http){
	    
		$scope.gridOptions={
				enableSorting: false,
				enableGridMenus:false,  
				enableSorting: false, 
			    enableFiltering: false,
			    enableCellEdit : false,
			    enableColumnMenus : false,
			    verticalScrollbar:0,
			    
		columnDefs:[
		{name:'batchId',displayname:'Batch ID', cellClass:'bId', headerCellClass:'batchId' },
		{name:'completionDate', displayname:'Completion Date', cellClass:'cDate',  headerCellClass:'compDate'},
		{name:'instructorName', displayname:'Instructor Name', cellClass:'iName', headerCellClass:'insName'},
		{name:'noOfCandidates', displayname:'Number of Candidates', cellClass:'noCandidates', headerCellClass:'candidates'},
				]			 		            			            	
	};
		
		 $http.get("/trainingPartnerPastBatches")
		    .then(function (data) {
		      $scope.gridOptions.data= data.PresentBatches;
		    })
	};
tpApp.controller('pastController', pastController);
pastController.$inject=['$scope','$http'];

function pastController($scope, $http){
    
		$scope.gridOptions={
				enableSorting: false,
				enableGridMenus:false,  
				enableSorting: false, 
			    enableFiltering: false,
			    enableCellEdit : false,
			    enableColumnMenus : false,
			    verticalScrollbar:0,
			    
		columnDefs:[
		{name:'batchId',displayname:'Batch ID', cellClass:'bId',  headerCellClass:'batchId' },
		{name:'completionDate', displayname:'Completion Date', cellClass:'cDate',  headerCellClass:'compDate'},
		{name:'instructorName', displayname:'Instructor Name', cellClass:'iName', headerCellClass:'insName'},
		{name:'noOfCandidates', displayname:'Number of Candidates', cellClass:'noCandidates', headerCellClass:'candidates'},
		{name:'Display', displayName: 'Download Certificate', cellClass:'download',  headerCellClass:'downCer', cellTemplate: '<img src="icon/CertificateDownlad/Certificate Download.png" ng-click=grid.appScope.myfunction()>'}
		]			 		            			            	
	};
		
		 $http.get("/trainingPartnerPastBatches")
		    .then(function (data) {
		      $scope.gridOptions.data= data.PastBatches;
		    })
	};
   
