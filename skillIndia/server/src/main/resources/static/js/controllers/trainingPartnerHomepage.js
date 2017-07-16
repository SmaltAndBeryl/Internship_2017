var tpApp = angular
                   .module('tpApp', [ 
                            'ui.grid', 
                            'ui.grid.cellNav',
                            'ui.grid.autoResize'
                            ]);

  tpApp.controller('presentController', presentController);
  presentController.$inject=['$scope','$http'];

function presentController($scope, $http){
	    
		$scope.presentGridOptions={
					  enableColumnMenus: false,
						  enableSorting: false,
						  verticalScrollbar:0,
						  
				  columnDefs : [
				{ name: 'batchId' ,	displayName:'Batch ID',	cellClass:'Prostokt-2-kopia-2-copy-10',	headerCellClass:'bId',
				},
				{ name: 'completionDate',	displayName:'Completion Date',	cellClass:'Prostokt-2-kopia-2-copy-11',	headerCellClass:'compDate',
				},
				{ name: 'instructorName' ,	displayName:'Instructor Name',	cellClass:'Prostokt-2-kopia-2-copy-12',	headerCellClass:'insName',
				},
				{ name: 'noOfCandidates' ,	displayName:'Number of Candidates',	cellClass:'Prostokt-2-kopia-2-copy-13',	headerCellClass:'candidates',
				}
					]
			};	 		            			            
		
		 $http.get("/trainingPartnerPastBatches")
		    .then(function (response) {
		      $scope.presentGridOptions.data= response.data.PresentBatches;
		    })
		
		$scope.pastGridOptions={
					  enableColumnMenus: false,
						  enableSorting: false,
						  verticalScrollbar:0,	    
						  columnDefs : [
										{ name: 'batchId' ,	displayName:'Batch ID',	cellClass:'Prostokt-2-kopia-2-copy-10',	headerCellClass:'bId',width: 100
										},
										{ name: 'completionDate',	displayName:'Completion Date',	cellClass:'Prostokt-2-kopia-2-copy-11',	headerCellClass:'compDate', width: 150
										},
										{ name: 'instructorName' ,	displayName:'Instructor Name',	cellClass:'Prostokt-2-kopia-2-copy-12',	headerCellClass:'insName',width: 150
										},
										{ name: 'noOfCandidates' ,	displayName:'Number of Candidates',	cellClass:'Prostokt-2-kopia-2-copy-13',	headerCellClass:'candidates',
										},
										{name:'Display', displayName: 'Download Certificate', cellClass:'download',  headerCellClass:'downCer', cellTemplate: '<img src="icon/CertificateDownlad/Certificate Download.png" ng-click=grid.appScope.myfunction()>'}
											]	
		 };
		 $http.get("/trainingPartnerPastBatches")
		    .then(function (response) {
		      $scope.pastGridOptions.data= response.data.PastBatches;
		    })	
};
	
	
