var batch = angular
                .module('batch',[
                    'ui.grid',
                    'ngTouch',
                    'ngAnimate',
                    'ui.grid.edit'
                ]);
//batch.config(['$qProvider', function ($qProvider) {
//    $qProvider.errorOnUnhandledRejections(false);
//}]);

batch.controller('batchController', batchController)

batchController.$inject = ['$scope', '$http', '$log', '$location'];

function batchController($scope, $http, $log, $location){

//    console.log(names);

    $scope.gridOptions = {
        enableGridMenus : false,
        enableSorting: false,
    	enableFiltering: false,
        enableCellEdit : false,
        enableColumnMenus : false,
        columnDefs : [
            { name : 'batchID', displayName : 'Batch ID'},
            { name : 'state', displayName : 'Location'},
            { name : 'batchEndDate', displayName : 'End Date'},
            { name : 'assessmentDate', displayName : 'Assessment Date'},
            { name : 'recommendedAB', displayName : 'Recommended AB'},
//            { name : 'assignedAB',
//               displayName : 'Assigned AB',
//               width : 80,
//               cellTemplate : '<span><select ng-model="myColor"><option ng-repeat="name in ["alkesh","frank"]">{{name}}</option></select>'},
            { name : 'Assign',
              displayName: 'Assign',
              cellTemplate: '<label><img src="icon/indexPageIcons/tick.png" ng-click=grid.appScope.saveFunction(row)></label>'}
        ]
    };

    var btc = "";
    $http.get('/non')
        //$http.get("batch.json")
            .then(function(response){
                $scope.gridOptions.data = response.data;
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

    // JS for search bar
    $scope.gridOptionsSearch = { enableGridMenus : false,
    		  enableSorting: false,
    		  enableFiltering: false,
    		  enableCellEdit : false,
    		  enableColumnMenus : false,
    		  enableHideColoumn: false,

      columnDefs : [

        { name:'#' , displayname:'1' , height:'71' , width:'100'},
        { name:'batchId' , displayname:'Batch id' , cellClass:'batch id' , width:'162' , height:'71' },
        { name:'state' , displayname:'location' , width:'162' , height:'71' },
        { name:'batchEndDate' , displayname:'Batch End date' ,  width:'163' , height:'71'},
        { name:'assessmentDate' , dispalyname:'Assessment Date' , width:'162' , height:'71'},
        { name:'assessorName' ,displayname:'Proposed AB',  width:'163',height:'71'},

      ]
    };

    	$scope.getDataOfBatch = function()
    	{
    		$http.post('/getInformationOfTheBatchId?batchId='+$scope.batchAssignmentSearch)
    		  .then(function (response) {
    			  console.log("inside request method");
    		    $scope.gridOptionsSearch.data = response.data;
    		  });
    	};



}

