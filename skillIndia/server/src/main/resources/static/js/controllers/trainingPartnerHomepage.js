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
	    
		$scope.presentGridOptions={
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
		    .then(function (response) {
		      $scope.presentGridOptions.data= response.data.PresentBatches;
		    })
		    
		    
		    $scope.pastGridOptions={
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
		    .then(function (response) {
		      $scope.pastGridOptions.data= response.data.PastBatches;
		    })
		    
	};
