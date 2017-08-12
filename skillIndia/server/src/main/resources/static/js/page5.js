console.log("working page 5");
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
                cellTemplate: '<center><label><img src="icon/indexPageIcons/close.png" ng-click=grid.appScope.withdrawFunctionForProposedBatches(row)></label></center>'
            }
        ]
    };
    $http.get('/getProposedBatchesBatchAssignment')
        .then(function(response) {
            console.log("get successful");
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
        console.log("Row Data is " + withdraw);


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
                    console.log("Get successful" + response.data)
                    $scope.gridOptions.data = response.data;
                });
                
                //refresh proposed table
                $http.get('/getProposedBatchesBatchAssignment')
                .then(function(response) {
                    console.log("get successful");
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
        console.log("Row Data is " + withdraw);


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
                    console.log("Get successful" + response.data)
                    $scope.gridOptions.data = response.data;
                });
                
                //refresh proposed table
                $http.get('/getProposedBatchesBatchAssignment')
                .then(function(response) {
                    console.log("get successful");
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
                displayName: 'location'
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
                console.log("inside request method");
                console.log(response.data);
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
                displayName: 'Batch ID'
            },
            {
                name: 'state',
                displayName: 'Location'
            },
            {
                name: 'batchEndDate',
                displayName: 'End Date'
            },
            {
                name: 'assessmentDate',
                displayName: 'Assessment Date'
            },
            {
                name: 'recommendedAB',
                displayName: 'Recommended Assessment Body',
                enableCellEdit: true,
                width: 100,
                cellTemplate: 'partials/suggest.html'
            },
            {
                name: 'assignedAB',
                displayName: 'Assigned AB',
                //               width : 80,
                enableCellEdit: true,
                cellTemplate: 'partials/dropdown.html'
            },


            {
                name: 'Assign',
                displayName: 'Assign',
                cellTemplate: '<center><label><img src="icon/indexPageIcons/tick.png" ng-click=grid.appScope.pushFunction(row)></label></center>'
            }
        ]
    };
    $http.get('/non')
        .then(function(response) {
            console.log("Get successful" + response.data)
            $scope.gridOptions.data = response.data;
        });

    $http.get('/dropdown')
        .then(function(response) {
            console.log("get successful")
            $scope.genderTypes = response.data;
        })

    var suggestedAgencyName = "";
    //Algorithm code
    $scope.suggestFunction = function(rowData) {
        var batchIdFromRow = rowData.entity.batchID;
        //To prevent fall through due to a known bug

        $scope.suggestedAgencyName = "AKG";
        $scope.suggestedShow = true;

        var getBatchId = "getBatchId";
        var getAgencyId = "getAgencyId";

        //      Code hit to get the batchId, state and centre
        $http({
                url: getBatchId,
                method: "POST",
                params: {
                    batchId: batchIdFromRow
                }
            })
            .then(function(response) {
                    console.log("The batches are " + JSON.stringify(response.data));
                    var suggested = [];
                    var i = 0;
                    var nameOfAgency;

                    //Parameter 1 - Code to get the show interested agencies
                    $http({
                            url: getAgencyId,
                            method: "POST",
                            params: {
                                batchId: batchIdFromRow
                            }
                    })
                        .then(function(response) {
                                for (var key in response.data) {
                                    suggested[i++] = response.data[key].agencyName;
                                }
                                var x = 0;

                                for (x in suggested) {
                                    console.log("Suggested body is >> " + suggested[x]);
                                }
                                console.log("The number of bodies recommended bodies are " + x++);

//                                For exactly one body
                                if(x == 1){
                                    console.log("Only one RECOMMENDATION(shown interest) >> " + suggested[0]);
                                    $scope.suggestedAgencyName = suggested[0];

                                }
//                                For more than one show interest
                                else{
                                if(x > 1){
//                                    $scope.suggestedAgencyName = "Multiple Recommendations";
                                    console.log("Multiple bodies have shown interest, moving to next parameter...")
                                     //Move on to second parameter
                                     $http.get('/getAssessorState')
                                         .then(function(response){
                                         //Now allot marks on the basis of parameters
                                             $http.get('/getAgencyName')
                                                 .then(function(response){
                                                     //initialize in a variable
                                                     nameOfAgency = JSON.parse(response).data;
                                                     console.log("The recommended AB is >> " + nameOfAgency);
//                                                     alert("Recommended AB >> " + nameOfAgency);
                                                     $scope.suggestedAgencyName = nameOfAgency;
                                                 })
                                         })
                                }

                                else{

                                    console.log("No one has shown interest..moving to next parameters..")
                                    var req = {
                                        method: 'GET',
                                        url: 'getAssessorState',
                                        transformResponse: [function(data) {
                                            var res = data;
                                            alert(res);
                                            return data;
                                        }]
                                    }
                                    $http(req)
                                        .then(function(response) {
                                            //Now allot marks on the basis of parameters
                                            $http.get('getAgencyName')
                                                .then(function(response) {
                                                    console.log("get successful..")
                                                    //initialize in a variable
                                                    nameOfAgency = JSON.parse(response.data);
                                                    console.log("The recommended AB is >> " + nameOfAgency);
                                                    alert("Recommended AB >> " + nameOfAgency);
                                                })
                                        })


                                }

                                }


                        })
            })
        };





    var agencyId = 0;
    
    //Get dropdown selected value from dropdown
    $scope.drop = function(selectedValue) {
    	
        console.log("Selected value is " + selectedValue.agencyId);
        selectedAgencyId = selectedValue.agencyId;
        console.log("Select assignment successful" + selectedAgencyId)
    }


    // code to call method which proposes Assessment body
    $scope.pushFunction = function(rowData) {
console.log("Inside propose function");
        var batchIdFromRow = rowData.entity.batchID;
        var agencyIdFromRow = 0;
        console.log("Selected value is " + selectedAgencyId);
        console.log("Batch and Agency ID are " + batchIdFromRow + " " + selectedAgencyId);

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
                    console.log("Status changed to proposed.! " + response.data)
                    
                    //refresh proposed batches table
                    $http.get('/getProposedBatchesBatchAssignment')
                    .then(function(response) {
                        console.log("get successful");
                        $scope.proposedBatchesBatchAssignmentGridOptions.data = response.data;
                    });
                    
                    //refresh non-assigned batches table
                    $http.get('/non')
                    .then(function(response) {
                        console.log("Get successful" + response.data)
                        $scope.gridOptions.data = response.data;
                    });

                },
                function()
                {
                	alert("Error in proposing agency");
                })


//            $http({
//                url: "/agencyUpdate",
//                method: "POST",
//                params: {
//                    agencyId: selectedAgencyId,
//                    batchId: batchIdFromRow,
//                    responseType:'proposed'
//                }
//            }).then(function(response) {
//                alert("Agency Updated");
//                console.log("Success in agency update");
//            })
        }
    $timeout(function() {
         $scope.responseMessagesForBatchesProposed='';
      }, 2000);
    };
});