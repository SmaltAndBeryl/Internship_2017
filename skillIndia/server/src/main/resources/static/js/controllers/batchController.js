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

batchController.$inject = ['$scope', '$http'];

function batchController($scope, $http){


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
}

//batch.filter('mapGender', function(){
//                var genderHash = {
//                    1 : 'male',
//                    2 : 'female'
//                };
//
//                return function(input){
//                    if(!input){
//                    return '';
//                    }
//
//                    else{
//                        genderHash[input]
//                    }
//                }
//            });
