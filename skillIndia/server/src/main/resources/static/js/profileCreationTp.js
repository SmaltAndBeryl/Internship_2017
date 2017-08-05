var profileCreationTp = angular.module('hello');

profileCreationTp.controller('profileCreationTp' , function($scope, $http){


//    $http.get('/url')
//        .then(function(response){
//
//        });

    $scope.states = ["UP", "Uttarakhand", "MP", "Bihar"];
    $scope.organizationName = "JSS";
    $scope.sPOCName = "Rakshit";

    $scope.submit = function(){
        alert("Application filled successfully!")
        //POST function to post the data into backend
    };

    $scope.save = function(){
        alert("Data saved successfully..");
        //POST function to post into backend
    }
});