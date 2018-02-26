//console.log("working page 5");
var page5 = angular.module('hello');

page5.controller('page5', function($scope, $http, $log, $location, $timeout) {
    $scope.message = "Page loaded via angular module";
    var selectedvalue="";


    $scope.proposedBatchesBatchAssignmentGridOptions = {
        enableGridMenus: false,
        enableSorting: false,
        enableColumnMenus: false,
        enableFiltering: false,
        enableCellEdit: false,
        columnDefs: [{
                name: 'serialNumber',
                displayName: 'S.No.',
                cellClass: '',
                headerCellClass: '',
                cellTemplate: '<div class="ui-grid-cell-contents">{{grid.renderContainers.body.visibleRowCache.indexOf(row)+1}}</div>' 
            },
            {
                name: 'batchId',
                displayName: 'Batch ID',
                cellClass: '',
                headerCellClass: ''
            },
            {
                name: 'location',
                displayName: 'Location',
                cellClass: '',
                headerCellClass: ''
            },
            {
                name: 'batchEndDate',
                displayName: 'Batch End Date',
                cellClass: '',
                headerCellClass: ''
            },
            {
                name: 'assessmentDate',
                displayName: 'Assessment Date',
                cellClass: '',
                headerCellClass: ''
            },
            {
                name: 'agencyName',
                displayName: 'Proposed AB',
                cellClass: '',
                headerCellClass: ''
            },
            {
                name: 'withdraw',
                displayName: 'Withdraw',
                cellClass: '',
                headerCellClass: '',
                cellTemplate: '<center><label><img src="icon/indexPageIcons/close.png" class="pointer" ng-click=grid.appScope.withdrawFunctionForProposedBatches(row)></label></center>'
            }
        ]
    };
    $http.get('/getProposedBatchesBatchAssignment')
        .then(function(response) {
            //console.log("get successful");
            $scope.proposedBatchesBatchAssignmentGridOptions.data = response.data;
        });


    $scope.approvedBatchesBatchAssignmentGridOptions = {
        enableGridMenus: false,
        enableSorting: false,
        enableColumnMenus: false,
        enableFiltering: false,
        enableCellEdit: false,

        columnDefs: [{
                name: 'serialNumber',
                displayName: 'S.No.',
                cellClass: '',
                headerCellClass: '',
                cellTemplate: '<div class="ui-grid-cell-contents">{{grid.renderContainers.body.visibleRowCache.indexOf(row)+1}}</div>' 
            },
            {
                name: 'batchId',
                displayName: 'Batch ID',
                cellClass: '',
                headerCellClass: ''
            },
            {
                name: 'location',
                displayName: 'Location',
                cellClass: '',
                headerCellClass: ''
            },
            {
                name: 'batchEndDate',
                displayName: 'Batch End Date',
                cellClass: '',
                headerCellClass: ''
            },
            {
                name: 'assessmentDate',
                displayName: 'Assessment Date',
                cellClass: '',
                headerCellClass: ''
            },
            {
                name: 'agencyName',
                displayName: 'Assigned AB',
                cellClass: '',
                headerCellClass: ''
            },
            {
                name: 'withdraw',
                displayName: 'Withdraw',
                cellClass: '',
                headerCellClass: '',
                cellTemplate: '<center><label><img src="icon/indexPageIcons/close.png" ng-click=grid.appScope.withdrawFunctionForApprovedBatches(row)></label></center>'
            }
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

        columnDefs: [{
                name: 'serialNumber',
                displayName: 'S.No.',
                cellClass: '',
                headerCellClass: '',
                cellTemplate: '<div class="ui-grid-cell-contents">{{grid.renderContainers.body.visibleRowCache.indexOf(row)+1}}</div>'  
            },
            {
                name: 'batchId',
                displayName: 'Batch ID',
                cellClass: '',
                headerCellClass: ''
            },
            {
                name: 'location',
                displayName: 'Location',
                cellClass: '',
                headerCellClass: ''
            },
            {
                name: 'batchEndDate',
                displayName: 'Batch End Date',
                cellClass: '',
                headerCellClass: ''
            },
            {
                name: 'assessmentDate',
                displayName: 'Assessment Date',
                cellClass: '',
                headerCellClass: ''
            },
            {
                name: 'agencyName',
                displayName: 'Rejected AB',
                cellClass: '',
                headerCellClass: ''
            }
        ]
    };

    $http.get('/getRejectedBatchesBatchAssignment')
        .then(function(response) {
            $scope.rejectedBatchesBatchAssignmentGridOptions.data = response.data;
        });

    //function for withdrawing of Proposed Batches Table
    
    $scope.withdrawFunctionForProposedBatches = function(rowData) {

        //Extract first cell value
        var withdraw = rowData.entity.batchId;
        //console.log("Row Data is " + withdraw);


        //Code for query update
        var urldata = "/withdrawAssignment";

        $http({
                url: urldata,
                method: "POST",
                params: {
                    batchId: withdraw,
                }
            })
            .then(function(response) {
                $scope.responseMessageForBatchWithdrawForProposedBatches='Successfully withdrawn proposal';
                //refresh non assigned batches table
                $http.get('/non')
                .then(function(response) {
                    //console.log("Get successful" + response.data)
                    $scope.gridOptions.data = response.data;
                });
                
                //refresh proposed table
                $http.get('/getProposedBatchesBatchAssignment')
                .then(function(response) {
                    //console.log("get successful");
                    $scope.proposedBatchesBatchAssignmentGridOptions.data = response.data;
                });
            });
        
        		//refresh approved batches
        
        $http.get('/getApprovedBatchesBatchAssignment')
        .then(function(response) {
            $scope.approvedBatchesBatchAssignmentGridOptions.data = response.data;
        });
        
        $timeout(function() {
         $scope.responseMessageForBatchWithdrawForProposedBatches='';
      }, 2000);
      };
	
    //function for withdrawing batches for Approved Batches Table
    
	$scope.withdrawFunctionForApprovedBatches = function(rowData) {

        //Extract first cell value
        var withdraw = rowData.entity.batchId;
        //console.log("Row Data is " + withdraw);


        //Code for query update
        var urldata = "/withdrawAssignment";

        $http({
                url: urldata,
                method: "POST",
                params: {
                    batchId: withdraw,
                }
            })
            .then(function(response) {
                $scope.responseMessageForBatchWithdrawForApprovedBatches='Successfully withdrawn proposal';
                //refresh non assigned batches table
                $http.get('/non')
                .then(function(response) {
                    //console.log("Get successful" + response.data)
                    $scope.gridOptions.data = response.data;
                });
                
                //refresh proposed table
                $http.get('/getProposedBatchesBatchAssignment')
                .then(function(response) {
                    //console.log("get successful");
                    $scope.proposedBatchesBatchAssignmentGridOptions.data = response.data;
                });
            });
        
        		//refresh approved batches
        
        $http.get('/getApprovedBatchesBatchAssignment')
        .then(function(response) {
            $scope.approvedBatchesBatchAssignmentGridOptions.data = response.data;
        });
        
        $timeout(function() {
         $scope.responseMessageForBatchWithdrawForApprovedBatches='';
      }, 2000);
    };
	


    $scope.searchGridOptions = {
        enableGridMenus: false,
        enableSorting: false,
        enableColumnMenus: false,
        verticalScrollbar: 0,

        columnDefs: [
            {
                name: 'batchId',
                displayName: 'Batch id',
                cellClass: 'batch'
            },
            {
                name: 'state',
                displayName: 'Location'
            },
            {
                name: 'batchEndDate',
                displayName: 'Batch End date'
            },
            {
                name: 'assessmentDate',
                displayName: 'Assessment Date'
            },
            {
                name: 'agencyName',
                displayName: 'Proposed AB'
            }

        ]
    };

    $scope.getDataOfBatch = function() {
        $http.post('/getInformationOfTheBatchId?batchId=' + $scope.batchAssignmentSearch)
            .then(function(response) {
                //console.log("inside request method");
                //console.log(response.data);
                if(response.data[0] == null)
                	{
                	$scope.searchGridOptions.data = response.data;
                	$scope.errorMessageForSearchBatchAssignment="No Record Found";
                        $timeout(function() {
         $scope.errorMessageForSearchBatchAssignment='';
      }, 2000);
                	}
                else
                	{
                	$scope.searchGridOptions.data = response.data;
                	$scope.errorMessageForSearchBatchAssignment="";
                	}
                	
            });
    };



    $scope.gridOptions = {
        enableGridMenus: false,
        enableSorting: false,
        enableFiltering: false,
        enableCellEdit: false,
        enableColumnMenus: false,

        columnDefs: [{
                name: 'batchID',
                displayName: 'Batch ID',
                width: "9%"
                
            },
            {
                name: 'state',
                displayName: 'Location',
                width: "13%"
            },
            {
                name: 'batchEndDate',
                displayName: 'End Date',
                width: "12%"
            },
            {
                name: 'assessmentDate',
                displayName: 'Assessment Date',
                width : "12%"
            },
            {
                name: 'recommendedAB',
                displayName: 'Recommended Assessment Body',
                enableCellEdit: false,
                width: "23%",
            },
            {
                name: 'assignedAB',
                displayName: 'Assigned AB',
                width : "18%",
                enableCellEdit: true,
                cellTemplate: 'partials/dropdown.html'
            },


            {
                name: 'Assign',
                displayName: 'Assign',
                cellTemplate: '<center><label><img src="icon/indexPageIcons/tick.png" class="pointer" ng-click=grid.appScope.pushFunction(row)></label></center>',
                width : "15%"
            }
        ]
    };

    $http.get('/non')
        .then(function(response) {
            //console.log("get successful")
            $scope.gridOptions.data = response.data;
        })

    $http.get('/dropdown')
        .then(function(response) {
            //console.log("get successful")
            $scope.genderTypes = response.data;
        })


    var agencyId = 0;
    
    //Get dropdown selected value from dropdown
    $scope.drop = function(selectedValue) {
    	
        //console.log("Selected value is " + selectedValue.agencyId);
        selectedAgencyId = selectedValue.agencyId;
        //console.log("Select assignment successful" + selectedAgencyId)
    }


    // code to call method which proposes Assessment body
    $scope.pushFunction = function(rowData) {
    //console.log("Inside propose function");
        var batchIdFromRow = rowData.entity.batchID;
        var agencyIdFromRow = 0;
        //console.log("Selected value is " + selectedAgencyId);
        //console.log("Batch and Agency ID are " + batchIdFromRow + " " + selectedAgencyId);

        // If assessment body is not set, do not update the DB
        if (selectedAgencyId == 0) {
            alert("Please select an assessment body first...!!");
        } 
        else {
            //Code for batches update
            var urldata = "/nonUpdate";

            $http({
                    url: urldata,
                    method: "POST",
                    params: {
                        batchId: batchIdFromRow,
                        agencyId: selectedAgencyId,
                        responseType: 'proposed'
                    }
                })
                .then(function(response) {
                    $scope.responseMessagesForBatchesProposed = 'Agency Id has been proposed';
                    //console.log("Status changed to proposed.! " + response.data)
                    
                    //refresh proposed batches table
                    $http.get('/getProposedBatchesBatchAssignment')
                    .then(function(response) {
                        //console.log("get successful");
                        $scope.proposedBatchesBatchAssignmentGridOptions.data = response.data;
                    });

                    //refresh non-assigned batches table
                    $http.get('/non')
                    .then(function(response) {
                        //console.log("Get successful" + response.data)
                        $scope.gridOptions.data = response.data;
                    });

                },
                function()
                {
                	alert("Error in proposing agency");
                })

        }
    $timeout(function() {
         $scope.responseMessagesForBatchesProposed='';
      }, 2000);
    };
});