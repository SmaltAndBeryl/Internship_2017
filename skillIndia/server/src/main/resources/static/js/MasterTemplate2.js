var myApp = angular.module('myApp', ['ngRoute','tpApp']);

myApp.controller('username-ctrl', function($scope) {
  $scope.username = "Alkesh Srivastava";
});

//RouteProvider