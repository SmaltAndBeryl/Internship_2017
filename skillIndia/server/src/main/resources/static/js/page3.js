console.log("Page 3 working");
var page3 = angular.module('hello');
console.log("Page 3 working and value get");
page3.controller('page3' , function($scope, $http){
console.log("Controller working");
      $scope.message = "Import Page route successful..!";
      $scope.gridOpts = {
        columnDefs : [
          {field : 'batch'},
          {field : 'id'}
        ]
      };
});