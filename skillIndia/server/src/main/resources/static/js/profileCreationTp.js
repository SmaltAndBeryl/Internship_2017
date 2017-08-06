var profileCreationTp = angular.module('hello');

profileCreationTp.controller('profileCreationTp' , function($scope, $http){

//    $http.get('/url')
//        .then(function(response){
//
//        });

    var trainingPartner = {};

    // Store response.data into trainingPartner

    $scope.states = ["UP", "Uttarakhand", "MP", "Bihar"];
//    $scope.organizationName = "JSS";
//    $scope.sPOCName = "Rakshit";
//
//
//    $scope.address = "Sacramento";
//    $scope.city = "Lucknow";
//    $scope.pincode = 5555555;
//    $scope.mobile = 1112223334;
//    $scope.mobileAlt = 7778889996;
//    $scope.landline = 8888888888;
//    $scope.landlineAlt = 0522888999;
//    $scope.fax = 4654681351;
//    $scope.website = "random@random.org";


    //response is the string that contains the nature of the button
    $scope.submit = function(response){
        alert("Application filled successfully! " + response);
        //POST function to post the data into backend

    };

    $scope.save = function(response){
        alert("Data saved successfully.. " + response);
        //POST function to post into backend
    }
});