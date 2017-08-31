var assessmentBody = angular.module("hello");

assessmentBody.controller("assessmentBody", function($scope, $location, $http, $rootScope) {
    $scope.message = "Hi Assessment Body";
    $scope.abAppStatus = {
        enableColumnMenus: false,
        enableSorting: false,
        verticalScrollbar: 0,

        columnDefs: [{
                name: 'applicationID',
                displayName: 'Application ID',
                cellClass: 'commoncell',
                headerCellClass: 'Application-ID'
            },
            {
                name: 'dateOfSubmission',
                displayName: 'Date of Submission',
                cellClass: 'commoncell',
                headerCellClass: 'Date-of-Submission'
            },
            {
                name: 'assessmentAgencyName',
                displayName: 'Submitted By',
                cellClass: 'commoncell',
                headerCellClass: 'Submitted-By'
            },
            {
                name: 'applicationState',
                displayName: 'Status',
                cellClass: 'statuscell',
                headerCellClass: 'Status'
            },
            {
                name: 'Action',
                displayName: 'Action',
                cellClass: 'Prostokt-2-kopia-2-copy-14',
                width: 76,
                headerCellClass: 'Action-copy',
                cellTemplate: '<img src="icon/indexpageIcons/edit1.png" ng-show="1" ng-click="grid.appScope.myfunction(row)">'
            },
            {
                name: 'comment',
                displayName: 'Comment',
                cellClass: 'comment',
                headerCellClass: 'Comment',
                cellTemplate: '<center ng-click=grid.appScope.myfunction1(row)>Click to View'
            }
        ]
    };

    $scope.myfunction1 = function(rowData) {
        var commentCheck = rowData.entity.comment;
        window.alert(commentCheck);

    }

    $scope.myfunction = function(rowData) {
        var appState = Object.values(Object.values(rowData)[1])[3];
        profileCreationURL = '';
        if (appState == "Incomplete") {
            //window.location = "https://www.google.co.in";
            //$location.path();
            $location.path(acceptedRoutingUrl)
            console.log("Please Edit the Form");

        } else {
            window.alert("Invalid Access");
        }
        console.log("Click is working" + appState);
    };

    $http.get('/assessmentBodyApplicationStatus')
        .then(function(response) {
                $scope.abAppStatus.data = response.data;
            },
            function(errorResponse) {
                console.log("inside error function application status table");
            })

    //Application status Ends

    $scope.gridOptions1 = {
        enableColumnMenus: false,
        enableSorting: false,
        verticalScrollbar: 0,

        columnDefs: [{
                name: 'batchId',
                displayName: 'Batch ID',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'trainingPartnerDetails',
                displayName: 'TP Name|Email|Contact No',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'assessmentDate',
                displayName: 'Assessment Date',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'location',
                displayName: 'District|State',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'totalCandidatesInBatch',
                displayName: 'Candidates',
                displayName: 'No. of Candidates',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
        ]
    };
    $http.get("/getPastBatchesAssessmentBodyHomepage")
        .then(function(response) {
                $scope.gridOptions1.data = response.data;
            },
            function(errorResponse) {
                console.log("inside error");
            })

    //Past Batches table ends

    $scope.gridOptions2 = {
        enableColumnMenus: false,
        enableSorting: false,

        columnDefs: [{
                name: 'batchId',
                displayName: 'Batch ID',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'trainingPartnerDetails',
                displayName: 'TP Name|Email|Contact No',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'assessmentDate',
                displayName: 'Assessment Date',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'location',
                displayName: 'District|State',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'totalCandidatesInBatch',
                displayName: 'Candidates',
                displayName: 'No. of Candidates',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'Show Interest',
                displayName: 'Express Interest',
                cellClass: 'check',
                headerCellClass: 'CommonCell',
                cellTemplate: '<div><input type="checkbox" id="myCheck" value="abc" ng-click=grid.appScope.check(row)></div>'
            },
            {
            	name: 'Confirm',
            	displayName: 'Confirm',
            	cellTemplate : '<div><img src="icon/indexPageIcons/tick.png" class="ab-img-shadow" ng-click=grid.appScope.confirmfinal(row)></div>'
            }
        ]
    };

    $http.get("/getUpcomingBatchesAssessmentBodyHomepage")
        .then(function(response) {
            $scope.gridOptions2.data = response.data;
        })
    var bool;
    $scope.check = function(rowData) {
        bool = document.getElementById("myCheck").checked
        if (bool == true) {
            console.log("Interest captured");
        }
    }
    $scope.confirmfinal = function(rowData) {
        if (bool == true) {
            var interestid = rowData.entity.batchId;
            var urldata = "/showInterest?batchId=" + interestid
            //remove agency Id- pick it from session
            //let batch id as is
            $http.post(urldata).then(function(response) {

                console.log("batch id for Interest is " + interestid);
            });

            console.log("Interest Shown");
        }
    }

    //Upcomming Batch table ends

    $scope.gridstatus = {
        enableColumnMenus: false,
        enableSorting: false,
        verticalScrollbar: 0,

        columnDefs: [{
                name: 'batchId',
                displayName: 'Batch ID',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'trainingPartnerDetails',
                displayName: 'TP Name|Email|Contact No',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'assessmentDate',
                displayName: 'Assessment Date',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'location',
                displayName: 'District|State',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'totalCandidatesInBatch',
                displayName: 'Candidates',
                displayName: 'No. of Candidates',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
        ]
    };
    $http.get("/getShownInterestBatchesAssessmentBodyHomepage")
        .then(function(response) {
            $scope.gridstatus.data = response.data;
        })

    //Interest status

    $scope.gridOptions3 = {
        enableGridMenus: false,
        enableSorting: false,
        enableFiltering: false,
        enableCellEdit: false,
        enableColumnMenus: false,

        columnDefs: [{
                name: 'batchId',
                displayName: 'Batch ID',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'trainingPartnerDetails',
                displayName: 'TP Name|Email|Contact No',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'assessmentDate',
                displayName: 'Assessment Date',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'location',
                displayName: 'District|State',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'totalCandidatesInBatch',
                displayName: 'Candidates',
                displayName: 'No. of Candidates',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'Action',
                cellClass: 'check',
                headerCellClass: 'CommonCell',
                cellTemplate: '<label><img src="icon/indexPageIcons/tick.png" ng-click=grid.appScope.approve(row)>  &nbsp; &nbsp; &nbsp; &nbsp; <img src="icon/indexPageIcons/close.png" ng-click=grid.appScope.reject(row)></label>'
            }
        ]
    };

    $scope.approve = function(rowData) {
        //Extract first cell value
        var approveid = rowData.entity.batchId;
        var urldata = "/approveAssignment?batchId=" + approveid;

        $http.post(urldata).then(function(response) {
            console.log("batch id for Approve is " + approveid);
        });
    }
    $scope.reject = function(rowData) {
        var rejectid = rowData.entity.batchId;
        var urldata = "/rejectAssignment?batchId=" + rejectid;

        $http.post(urldata).then(function(response) {
            console.log("batch id for Approve is " + rejectid);
        });
    }

    $http.get("/getAssignedBatchesAssessmentBodyHomepage")
        .then(function(response) {
            $scope.gridOptions3.data = response.data;
        })

    //Assign Batch table ends
    $scope.gridOptions4 = {
        enableColumnMenus: false,
        enableSorting: false,
        verticalScrollbar: 0,


        columnDefs: [{
                name: 'batchId',
                displayName: 'Batch ID',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'trainingPartnerDetails',
                displayName: 'TP Name|Email|Contact No',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'assessmentDate',
                displayName: 'Assessment Date',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'location',
                displayName: 'District|State',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
            {
                name: 'totalCandidatesInBatch',
                displayName: 'Candidates',
                displayName: 'No. of Candidates',
                cellClass: 'cell',
                headerCellClass: 'CommonCell'
            },
        ]
    };
    $http.get("/getConfirmedBatchesAssessmentBodyHomepage")
        .then(function(response) {
            $scope.gridOptions4.data = response.data;
        })

    //Confirmed Batch table ends
    if($rootScope.authenticated){
              $rootScope.$on("$locationChangeStart", function(event,next,current){
                if($rootScope.type == '"AB"'){
                    event.preventDefault();
                    alert("Not allowed");
                }
                else{
                    alert("Logging out..!");
                }
              });
          }
});