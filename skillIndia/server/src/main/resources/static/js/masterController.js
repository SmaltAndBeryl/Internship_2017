var master = angular.module('hello');

master.controller('master', function ($scope, $rootScope){
  console.log("Master controller working..");
  $scope.page = 'page1';
//  if($rootScope.authenticated){
//      $rootScope.$on("$locationChangeStart", function(event,next,current){
//        if($rootScope.type == '"SCGJ"'){
//            event.preventDefault();
//            alert("Not allowed");
//        }
//        else{
//            alert("Logging out..!");
//        }
//      });
//  }
});
