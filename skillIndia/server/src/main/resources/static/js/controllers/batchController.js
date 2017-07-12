var batch = angular
                .module('batch',[
                    'ui.grid',
                    'ngTouch',
                    'ngAnimate'
                ]);

batch.controller('batchController', batchController);

batchController.$inject = ['$scope', '$http'];

function batchController($scope, $http){
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
            { name : 'Assign', displayName: 'Assign', cellTemplate: '<label><img src="icon/indexPageIcons/tick.png"></label>'}
        ]
    };

    $http.get('/non')
    //$http.get("batch.json")
        .then(function(response){
            $scope.gridOptions.data = response.data;
        });


     //Enter the code
}