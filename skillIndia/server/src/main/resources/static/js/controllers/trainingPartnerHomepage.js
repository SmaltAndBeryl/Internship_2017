//var statusApp = angular
//				.module('statusApp', [
//				                'ngTouch',
//				                'ui.grid',
//				                'ui.grid.autoResize'
//				               ]);
//
//statusApp.controller('TpApplication',TpApplication);
//TpApplication.$inject=['$scope','$http','$location'];
//function TpApplication($scope, $http, $location) {
//	
//	$scope.gridOptions = {
//		  enableColumnMenus: false,
//		  enableSorting: false,
//		  verticalScrollbar:0,
//		  
//  columnDefs : [
//{ name: 'applicationID' ,	displayName:'Application ID',	cellClass:'commoncell',	headerCellClass:'Application-ID'
//},
//{ name: 'dateOfSubmission',	displayName:'Date of Submission',	cellClass:'commoncell',	headerCellClass:'Date-of-Submission'
//},
//{ name: 'trainingPartnerName' ,	displayName:'Submitted By',	cellClass:'commoncell',	headerCellClass:'Submitted-By'
//},
//{ name: 'applicationState' ,	displayName:'Status',	cellClass:'statuscell',	headerCellClass:'Status'
//},
//{ name:'Action',	cellClass: 'Prostokt-2-kopia-2-copy-14',	width:76,	headerCellClass: 'Action-copy',	cellTemplate:'<img src="icon/indexpageIcons/edit1.png" ng-show="1" ng-click="grid.appScope.myfunction(row)">',
//},
//{ name: 'comment' ,	displayName:'Comment',	cellClass:'comment',	headerCellClass:'Comment',cellTemplate:'<center ng-click=grid.appScope.myfunction1(row)>Click to View',
//}
//	]
//  };
//	$scope.myfunction1 = function(rowData)
//	{var commentCheck=Object.values(Object.values(rowData)[1])[4];
//	window.alert(commentCheck);
//
//}
//$scope.myfunction = function(rowData) 
//  {   var appState=Object.values(Object.values(rowData)[1])[3];
//  if(appState=="Incomplete"){
//	  window.location="https://www.google.co.in";
//	  console.log("Please Edit the Form");
//	  
//  }
//  else{
//	  window.alert("Invalid Access");
//  }
//	console.log("Click is working"+appState);
//};
//
//$http.get('/trainingPartnerApplicationStatus')
////$http.get('poc/Status.json')
//    .then(function (response) {
//      $scope.gridOptions.data = response.data;
//    })
//};
var tpApp = angular
                   .module('tpApp', [ 
                            'ui.grid', 
                            'ui.grid.cellNav',
                            'ui.grid.autoResize'
                            ]);

  tpApp.controller('presentController', presentController);
  presentController.$inject=['$scope','$http'];

function presentController($scope, $http){
	    
	$scope.tpAppStatus = {
			  enableColumnMenus: false,
			  enableSorting: false,
			  verticalScrollbar:0,
			  
	  columnDefs : [
	{ name: 'applicationID' ,	displayName:'Application ID',	cellClass:'commoncell',	headerCellClass:'Application-ID'
	},
	{ name: 'dateOfSubmission',	displayName:'Date of Submission',	cellClass:'commoncell',	headerCellClass:'Date-of-Submission'
	},
	{ name: 'trainingPartnerName' ,	displayName:'Submitted By',	cellClass:'commoncell',	headerCellClass:'Submitted-By'
	},
	{ name: 'applicationState' ,	displayName:'Status',	cellClass:'statuscell',	headerCellClass:'Status'
	},
	{ name:'Action',	cellClass: 'Prostokt-2-kopia-2-copy-14',	width:76,	headerCellClass: 'Action-copy',	cellTemplate:'<img src="icon/indexpageIcons/edit1.png" ng-show="1" ng-click="grid.appScope.myfunction(row)">',
	},
	{ name: 'comment' ,	displayName:'Comment',	cellClass:'comment',	headerCellClass:'Comment',cellTemplate:'<center ng-click=grid.appScope.myfunction1(row)>Click to View',
	}
		]
	  };
	
	$scope.myfunction1 = function(rowData)
	{var commentCheck=Object.values(Object.values(rowData)[1])[4];
	window.alert(commentCheck);

}
$scope.myfunction = function(rowData) 
  {   var appState=Object.values(Object.values(rowData)[1])[3];
  if(appState=="Incomplete"){
	  window.location="https://www.google.co.in";
	  console.log("Please Edit the Form");
	  
  }
  else{
	  window.alert("Invalid Access");
  }
	console.log("Click is working"+appState);
};

$http.get('/trainingPartnerApplicationStatus')
    .then(function (response) {
      $scope.tpAppStatus.data = response.data;
    })
    
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
	
	
