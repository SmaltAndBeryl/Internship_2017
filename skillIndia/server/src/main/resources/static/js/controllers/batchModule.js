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
            { field : 'id'},
            { field : 'batch'},
            { field : 'location'},
            { field : 'end'},
            { field : 'assessment'},
            { field : 'recommended'},
            { field : 'assigned'},
            { field : 'confirm'}
        ]
    };

    $http.get('data.json')
        .then(function(response){
            $scope.gridOptions.data = response.data;
        });
}