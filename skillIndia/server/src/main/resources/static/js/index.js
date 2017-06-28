// var app = angular.module('app', ['ui.grid']);

// URL Routing

var myApp = angular.module('myApp', ['ngRoute']);

myApp.controller('username-ctrl', function($scope) {
  $scope.username = "Alkesh Srivastava";
});
myApp.config(function($routeProvider) {
  $routeProvider
  .when('/',{
    templateUrl: '../partials/main.html',
    // controller: 'mainController'
  })

  .when('/dashboard',{
    templateUrl: '../partials/main.html',
    // controller: 'dashController'
  })
  .when("/manage-registrations", {
    templateUrl: "../partials/manage.html",
    // controller: 'manageController'
  })
  .when("/import", {
    templateUrl: "../partials/import.html",
    // controller: 'importController'
  })
  .when("/faq", {
    templateUrl: "../partials/faq.html",
    // controller: 'faqController'
  })
  .when("/batch-assignment", {
    templateUrl: "../partials/batch.html",
    // controller: 'batchController'
  });
});

console.log("routed");
myApp.controller('mainController', function($scope) {
  $scope.message = 'Alkesh';
  console.log("message 1 printed");
});

console.log("routed for second time");
myApp.controller('dashController', function($scope) {
  $scope.message = 'Dashboard Page';
  console.log("message 2 printed");
});
