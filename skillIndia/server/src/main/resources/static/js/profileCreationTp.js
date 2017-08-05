var profileCreationTp = angular.module('hello');

profileCreationTp.controller('profileCreationTp' , function($scope, $http){


//    $http.get('/url')
//        .then(function(response){
//
//        });

    $scope.states = ["UP", "Uttarakhand", "MP", "Bihar"];
    $scope.organizationName = "JSS";
    $scope.sPOCName = "Rakshit";

    $scope.address = "Sacramento";
    $scope.city = "Lucknow";
    $scope.pincode = 5555555;
    $scope.mobile = 1112223334;
    $scope.mobileAlt = 7778889996;
    $scope.landline = 8888888888;
    $scope.landlineAlt = 0522888999;
    $scope.fax = 4654681351;
    $scope.website = "random@random.org";


    $scope.submit = function(){
        alert("Application filled successfully!")
        //POST function to post the data into backend
    };

    $scope.save = function(){
        alert("Data saved successfully..");
        //POST function to post into backend
    }
});