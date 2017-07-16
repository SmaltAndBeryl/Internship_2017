var myApp = angular.module('myApp', ['ngRoute','statusApp']);

myApp.controller('username-ctrl', function($scope) {
  $scope.username = "Alkesh Srivastava";
});