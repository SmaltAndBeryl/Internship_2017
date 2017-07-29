console.log("working page 5");
var page5 = angular.module('hello');

page5.controller('page5' , function($scope, $http, $log, $location){
    $scope.message = "Page loaded via angular module";

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
            console.log("get successful");
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
        { name : 'recommendedAB',
          displayName : 'Suggestion',
          enableCellEdit : true,
          cellTemplate : 'partials/suggest.html'
          },
        { name : 'assignedAB',
          displayName : 'Assigned AB',
//               width : 80,
          enableCellEdit: true,
          cellTemplate : 'partials/dropdown.html'},


        { name : 'Assign',
          displayName: 'Assign',
          cellTemplate: '<label><img src="icon/indexPageIcons/tick.png" ng-click=grid.appScope.pushFunction(row)></label>'}
    ]
};
        $http.get('/non')
            .then(function(response){
                console.log("Get successful" + response.data)
                $scope.gridOptions.data = response.data;
            });

        $http.get('/dropdown')
            .then(function(response){
                console.log("get successful")
                $scope.genderTypes  = response.data;
            })

     var btc = "";

    //Algorithm code
    $scope.suggestFunction = function(rowData){
        alert("Thanks for choosing..!");
        var batchIdFromRow = rowData.entity.batchID;
        //To prevent fall through due to a known bug
        var agencyIdFromRow = 3001;

        console.log("Batch and Agency ID are " + batchIdFromRow + " " + agencyIdFromRow);

        var getBatchId = "getBatchId";
        var getAgencyId = "getAgencyId";

        //      Code hit to get the batchId, state and centre
        $http({
             url : getBatchId,
             method : "POST",
             params : { batchId :  batchIdFromRow }
          })
         .then(function(response){
             console.log("The batches are " + JSON.stringify(response.data));
             var suggested = [];
                     var i = 0;
                     var nameOfAgency;

                     //Parameter 1 - Code to get the show interested agencies
                     $http({
                         url : getAgencyId,
                         method : "POST",
                         params : { batchId : batchIdFromRow }
                     })
                         .then(function(response){
                             for(var key in response.data){
                                 suggested[i++] = response.data[key].agencyName;
                             }

                             // x stores the number of bodies who have shown interest
                             var x = 0;

                             for(x in suggested){
                                 console.log("Suggested body is >> " + suggested[x]);
                             }



                             console.log("The number of bodies recommended bodies are " + x);

                             //If number of bodies is greater than one then move to second parameter
                             if(x > 1){
                                 console.log("Multiple bodies have shown interest, moving to next parameter...")
                                 //Move on to second parameter
                                 $http.get('getAssessorState')
                                     .then(function(response){
                                     //Now allot marks on the basis of parameters
                                         $http.get('getAgencyName')
                                             .then(function(response){
                                                 //initialize in a variable
                                                 nameOfAgency = JSON.parse(response).data;
                                                 console.log("The recommended AB is >> " + nameOfAgency);
                                                 alert("Recommended AB >> " + nameOfAgency);
                                             })
                                     })
                             }

                             //If exactly one body has shown interest, then display the assessment body
                             if(x == 1){

                                 console.log("TOP RECOMMENDATION >> " + suggested[0]);
                                 $scope.suggestedAB = suggested[0];
                                 console.log("The scope variable is >> " + $scope.suggestedAB);
                                 alert("Recommended AB >> " + suggested[0]);
                                 $scope.suggestedAB = function(){
                                     console.log("suggested AB is >> " + suggested[0]);
                                 }
                             }

                             //If no one has shown interest, move to second parameter
                             if(x == 0){
                             console.log("No one has shown interest..moving to next parameters..")
                             var req = {
                                method : 'GET',
                                url : 'getAssessorState',
                                transformResponse : [function(data){
                                    var res = data;
                                    return data;
                                }]
                             }
                             $http(req)
                              .then(function(response){
                              //Now allot marks on the basis of parameters
                                  $http.get('getAgencyName')
                                      .then(function(response){
                                          console.log("get successful..")
                                          //initialize in a variable
                                          nameOfAgency = JSON.parse(response.data);
                                          console.log("The recommended AB is >> " + nameOfAgency);
                                          alert("Recommended AB >> " + nameOfAgency);
                                      })
                              })
        //                                 console.log("Sorry, no recommendation for now as no one has shown interest..!");
                             }
                       })
             })

        };

    var agencyId = 0;
    //Get dropdown selected value from dropdown
    $scope.drop = function(selectedValue){
        console.log("Selected value is " + selectedValue.agencyId);
        agencyId = selectedValue.agencyId;
        console.log("Select assignment successful" + agencyId)
    }


    // Code to update the DB
    $scope.pushFunction = function(rowData){

        var batchIdFromRow = rowData.entity.batchID;
        var agencyIdFromRow = 0;
        console.log("Selected value is "+ agencyId);
        console.log("Batch and Agency ID are " + batchIdFromRow + " " + agencyId);

        // If assessment body is not set, do not update the DB
        if(agencyId == 0){
            alert("Please select an assessment body first...!!");
        }

        else{
            //Code for batches update
            var urldata = "/nonUpdate";

            $http({
                url : urldata,
                method : "POST",
                params : {batchId : batchIdFromRow}
            })
                .then(function(response){
                    alert("Your response has been recorded..!")
                    console.log("Status changed to proposed.! "+ btc)
                })


            $http({
                url : "/agencyUpdate",
                method : "POST",
                params : { agencyId : agencyId , batchId : batchIdFromRow}
            }).then(function(response){
                alert("Agency Updated");
                console.log("Success in agency update");
            })
        }
    };
});