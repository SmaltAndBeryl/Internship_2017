var batch = angular
                .module('batch',[
                    'ui.grid',
                    'ngTouch',
                    'ngAnimate',
                    'ui.grid.edit'
                ]);

batch.controller('batchController', batchController)
batchController.$inject = ['$scope', '$http', '$log', '$location'];
function batchController($scope, $http, $log, $location){

// Non-Assigned Batches Grid Info
	
    $scope.nonAssignedBatchGridOptions = {
        enableSorting: false,
        enableColumnMenus: false,
        verticalScrollbar:0,
        columnDefs: [
            {name : 'batchID', displayName : 'Batch ID'},
            {name : 'state', displayName : 'Location'},
            {name : 'batchEndDate', displayName : 'End Date'},
            {name : 'assessmentDate', displayName : 'Assessment Date'},
            {name : 'recommendedAB', displayName : 'Recommended AB'},
//          {name : 'assignedAB',
//           displayName : 'Assigned AB',
//           width : 80,
//           cellTemplate : '<span><select ng-model="myColor"><option ng-repeat="name in ["alkesh","frank"]">{{name}}</option></select>'},
            {name : 'Assign',
             displayName: 'Assign',
             cellTemplate: '<label><img src="icon/indexPageIcons/tick.png" ng-click=grid.appScope.saveFunction(row)></label>'}
            ]
    };

    var btc = "";
    $http.get('/non')
        //$http.get("batch.json")
            .then(function(response){
                $scope.nonAssignedBatchGridOptions.data = response.data;
                //var obj = $scope.gridOptions.data[0].batchID;
                //var str = JSON.stringify(obj);
                //btc = str;
                //console.log("VALUE is "+obj+" another " + str + btc);
            });


$scope.show = function(){['Lancelot', 'Touchstone'];}
    $scope.saveFunction = function(rowData){
        alert("Button is working..!!");

        //Extract first cell value
        var abj = Object.values(Object.values(rowData)[1])[0];
        console.log("Row Data is " + abj);


        //Code for query update
        var urldata = "/nonUpdate";

        $http({
            url : urldata,
            method : "POST",
            params : { batchId : abj }
        })
            .then(function(response){
                console.log("Status changed to proposed.! "+ btc)
            })
    };
    
    // JS for search bar
    $scope.searchGridOptions = { enableGridMenus : false,
    		  enableSorting: false,
    		  enableColumnMenus : false,
    		  verticalScrollbar:0,

      columnDefs : [

        { name:'#' , displayName:'#'},
        { name:'batchId' , displayName:'Batch id' , cellClass:'batch'},
        { name:'state' , displayName:'location'},
        { name:'batchEndDate' , displayName:'Batch End date'},
        { name:'assessmentDate' , displayName:'Assessment Date'},
        { name:'agencyName' ,displayName:'Proposed AB'}

      ]
    };

    	$scope.getDataOfBatch = function()
    	{
    		$http.post('/getInformationOfTheBatchId?batchId='+$scope.batchAssignmentSearch)
    		  .then(function (response) {
    			  console.log("inside request method");
    		    $scope.searchGridOptions.data = response.data;
    		  });
    	};

    //Other tables JS code
    $scope.proposedBatchesBatchAssignmentGridOptions = {
    		  enableGridMenus: false,
    		  enableSorting: false,
    		  enableColumnMenus: false,
    		  enableFiltering: false,
    		  enableCellEdit: false,

    	columnDefs : [
    	{name:'serialNumber',
    	displayName: 'S.No.',
    	cellClass: '',
    	headerCellClass: ''},
        {name:'batchId',
        displayName: 'Batch ID',
        cellClass: '',
        headerCellClass: ''},
        {name:'location',
        displayName: 'Location',
        cellClass: '',
        headerCellClass: ''},
        {name:'batchEndDate',
        displayName: 'Batch End Date',
        cellClass: '',
        headerCellClass: ''},
        {name:'assessmentDate',
        displayName: 'Assessment Date',
        cellClass: '',
        headerCellClass: ''},
        {name:'agencyName',
        displayName: 'Proposed AB',
        cellClass: '',
        headerCellClass: ''},
        {name:'withdraw',
         displayName: 'Withdraw',
         cellClass: '',
         headerCellClass: '',
         cellTemplate: '<label><img src="icon/indexPageIcons/close.png" ng-click=grid.appScope.withdrawFunction(row)></label>'}
      ]
    };
    $http.get('/getProposedBatchesBatchAssignment')
	 .then(function(response) {
	 $scope.proposedBatchesBatchAssignmentGridOptions.data = response.data;
	});

     $scope.approvedBatchesBatchAssignmentGridOptions = {
    			  enableGridMenus: false,
    			  enableSorting: false,
    			  enableColumnMenus: false,
    			  enableFiltering: false,
    			  enableCellEdit: false,

    	columnDefs : [
        { name:'serialNumber',
        displayName: 'S.No.',
        cellClass: '',
        headerCellClass: ''},
        {name:'batchId',
        displayName: 'Batch ID',
        cellClass: '',
        headerCellClass: ''},
        {name:'location',
        displayName: 'Location',
        cellClass: '',
        headerCellClass: ''},
        {name:'batchEndDate',
        displayName: 'Batch End Date',
        cellClass: '',
        headerCellClass: ''},
        {name:'assessmentDate',
        displayName: 'Assessment Date',
        cellClass: '',
        headerCellClass: ''},
        {name:'agencyName',
        displayName: 'Assigned AB',
        cellClass: '',
        headerCellClass: ''},
        { name:'withdraw',
        displayName: 'Withdraw',
        cellClass: '',
        headerCellClass: '',
        cellTemplate: '<label><img src="icon/indexPageIcons/close.png" ng-click=grid.appScope.withdrawFunction(row)></label>'}
      ]
    };
     $http.get('/getApprovedBatchesBatchAssignment')
	 .then(function(response) {
	 $scope.approvedBatchesBatchAssignmentGridOptions.data = response.data;
	});
    $scope.rejectedBatchesBatchAssignmentGridOptions = {
    			  enableGridMenus: false,
    			  enableSorting: false,
    			  enableColumnMenus: false,
    			  enableFiltering: false,
    			  enableCellEdit: false,

    	columnDefs : [
        {name:'serialNumber',
        displayName: 'S.No.',
        cellClass: '',
        headerCellClass: '',
        cellTemplate: '<div>{{row.grid.renderContainers.body.visibleRowsCache.indexOf(row)}}</div>' },
        {name:'batchId',
        displayName: 'Batch ID',
        cellClass: '',
        headerCellClass: ''},
        {name:'location',
        displayName: 'Location',
        cellClass: '',
        headerCellClass: ''},
        {name:'batchEndDate',
        displayName: 'Batch End Date',
        cellClass: '',
        headerCellClass: ''},
        {name:'assessmentDate',
        displayName: 'Assessment Date',
        cellClass: '',
        headerCellClass: ''},
        {name:'agencyName',
        displayName: 'Rejected AB',
        cellClass: '',
        headerCellClass: ''}
      ]
    };
 
    $http.get('/getRejectedBatchesBatchAssignment')
    	 .then(function(response) {
         $scope.rejectedBatchesBatchAssignmentGridOptions.data = response.data;
        });

    	 $scope.withdrawFunction = function(rowData){
    	        alert("You have withdrawn the assignment");

    	        //Extract first cell value
    	        var withdraw = Object.values(Object.values(rowData)[1])[0];
    	        console.log("Row Data is " + withdraw);


    	        //Code for query update
    	        var urldata = "/withdrawAssignment";

    	        $http({
    	            url : urldata,
    	            method : "POST",
    	            params : { batchId : withdraw }
    	        })
    	            .then(function(response){
    	                console.log("Status changed to Default! "+ btc)
    	            });
    	    }
}

