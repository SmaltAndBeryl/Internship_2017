//var master = angular.module('master' , []);
//var master = angular.module('hello');
var master = angular.module('hello');

master.controller('master', function ($scope){
  console.log("Master controller working..");
  $scope.page = 'page1';
  $scope.message = 'Master working';
});

