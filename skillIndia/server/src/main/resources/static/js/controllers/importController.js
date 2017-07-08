console.log("Code reached of import controller");
//angular.module.requires.push('ui.grid', 'ng-touch');
//var imp = angular.module('imp', ['ui.grid','ng-touch']);

var imp = angular
            .module('imp', [
                            'ngAnimate',
                            'ngTouch',
                            'ui.grid'
                    ]);

//Wrong way of injecting dependencies----->>>>

// imp.controller('importController', function($scope) {
// imp.controller('importController', ['$scope', function($scope) {
//     $scope.message = 'Import controller routed successfully..!!';
//     //console.log("message printed");
//     $scope.myData = [
//       {
//        }
//     ];
//   }]);

//declare the controller
imp.controller('importController', importController);

//inject the dependencies via $inject
importController.$inject = ['$scope','$http'];

//declare the controller functionality in the rootScope rather than inside the scope
function importController($scope, $http){
  $scope.message = "Import Page route successful..!";
  $scope.gridOpts = {
    columnDefs : [
      {field : 'batch'},
      {field : 'id'}
    ]
  };

  $http.get("data.json")
    .then(function (response){
      console.log("GET successful...!!");
      $scope.gridOpts.data = response.data;
  });
}
