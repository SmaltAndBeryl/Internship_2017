//var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.autoResize']);

var batchAssignment = angular
							.module('batchAssignment',[]);
batchAssignment.controller('batchAssignmentController', batchAssignmentController);

batchAssignmentController.$inject = ['$scope', '$http', '$log', '$location'];

function batchAssignmentController($scope, $http, $log, $location) {
  
	$scope.proposedBatchesBatchAssignmentGridOptions = {
		  enableGridMenus: false,
		  enableSorting: false,
		  enableColumnMenus: false,
		  enableFiltering: false,
		  enableCellEdit: false,
		  
	columnDefs : [
	{name:'serialNumber',
	displayName: 'S.No.',
	//cellClass: '',
	//headerCellClass: '',
	width:73},
    {name:'batchId',
    displayName: 'Batch ID',
    //cellClass: '',
    //headerCellClass: '',
    width:100},
    {name:'location',
    displayName: 'Location',
    //cellClass: '',
    //headerCellClass: '',
    width:150},
    {name:'batchEndDate',
    displayName: 'Batch End Date',
    //cellClass: '',
    //headerCellClass: '',
    width: 140},
    {name:'assessmentDate',
    displayName: 'Assessment Date',
    //cellClass: '',
    //headerCellClass: '',
    width:150},
    {name:'proposedAB',
    displayName: 'Proposed AB',
    //cellClass: '',
    //headerCellClass: '',
    width:120},
    {name:'propose',
     displayName: 'Propose',
     //cellClass: '',
     //headerCellClass: '',
     cellTemplate: '<label><img src="icon/indexPageIcons/close.png" ng-click=grid.appScope.saveFunction(row)></label>',
     width:155}
  ]
};
	  $scope.approvedBatchesBatchAssignmentGridOptions = {
			  enableGridMenus: false,
			  enableSorting: false,
			  enableColumnMenus: false,
			  enableFiltering: false,
			  enableCellEdit: false,	
	
	columnDefs : [
    { name:'serialNumber',
    displayName: 'S.No.',
    //cellClass: '',
    //headerCellClass: '',
    width:73},
    {name:'batchId',
    displayName: 'Batch ID',
    //cellClass: '',
    //headerCellClass: '',
    width:100},
    {name:'location',
    displayName: 'Location',
    //cellClass: '',
    //headerCellClass: '',
    width:150},
    {name:'batchEndDate',
    displayName: 'Batch End Date',
    //cellClass: '',
    //headerCellClass: '',
    width: 140},
    {name:'assessmentDate',
    displayName: 'Assessment Date',
    //cellClass: '',
    //headerCellClass: '',
    width:150},
    {name:'proposedAB',
    displayName: 'Assigned AB',
    //cellClass: '',
    //headerCellClass: '',
    width:150},
    { name:'withdraw',
    displayName: 'Withdraw',
    //cellClass: '',
    //headerCellClass: '',
    cellTemplate: '<label><img src="icon/indexPageIcons/close.png" ng-click=grid.appScope.saveFunction(row)></label>',
    width:155}
  ]
};
	 $scope.rejectedBatchesBatchAssignmentGridOptions = {
			  enableGridMenus: false,
			  enableSorting: false,
			  enableColumnMenus: false,
			  enableFiltering: false,
			  enableCellEdit: false,

	columnDefs : [
    { name:'serialNumber',
    displayName: 'S.No.',
    //cellClass: '',
    //headerCellClass: '',
    width:73},
    {name:'batchId',
    displayName: 'Batch ID',
    //cellClass: '',
    //headerCellClass: '',
    width:100},
    {name:'location',
    displayName: 'Location',
    //cellClass: '',
    //headerCellClass: '',
    width:150},
    {name:'batchEndDate',
    displayName: 'Batch End Date',
    //cellClass: '',
    //headerCellClass: '',
    width: 140},
    {name:'assessmentDate',
    displayName: 'Assessment Date',
    //cellClass: '',
    //headerCellClass: '',
    width:150},
    {name:'proposedAB',
    displayName: 'Rejected AB',
    //cellClass: '',
    //headerCellClass: '',
    width:150}
  ]
};
	 $http.get('/getProposedBatchesBatchAssignment')
	 .then(function(response) {
	 $scope.proposedBatchesBatchAssignmentGridOptions.data = response.data;
	});
	 
	 $http.get('/getApprovedBatchesBatchAssignment')
	 .then(function(response) {
	 $scope.approvedBatchesBatchAssignmentGridOptions.data = response.data;
	});
	 
	 $http.get('/getRejectedBatchesBatchAssignment')
	 .then(function(response) {
     $scope.rejectedBatchesBatchAssignmentGridOptions.data = response.data;
    });
	 
	    $scope.saveFunction = function(rowData){
	        alert("You have withdrawn the assignment");

	        //Extract first cell value
	        var abj = Object.values(Object.values(rowData)[1])[0];
	        console.log("Row Data is " + abj);


	        //Code for query update
	        var urldata = "/withdrawAssignment";

	        $http({
	            url : urldata,
	            method : "POST",
	            params : { batchId : abj }
	        })
	            .then(function(response){
	                console.log("Status changed to Default! "+ btc)
	            });
	    }
};
