use strict;

var app = angular.module('skillIndia', [ 'ngResource','ngRoute', 'ui.bootstrap' ]);

app.config(function($routeProvider, $httpProvider, $locationProvider) {

    $routeProvider.when('/', {
      templateUrl : 'home.html',
      controller : 'home',
      controllerAs: 'controller'
      controllerAs:'homeCltr' 	  
    }).when('/login', {
      templateUrl : 'login.html',
      controller : 'loginCltr',
      controllerAs: 'controller'
    }).otherwise('/');

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

  });

