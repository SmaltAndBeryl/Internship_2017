 var myangularapp = angular.module("myangularapp", []);
myangularapp.controller("myangularController", function($scope,$http) {
       
        
    $scope.login = function (){
     alert('test3');
    
        $scope.username1;
        $scope.password1;
        
        $http.post('http://loginurl/', { username: $scope.username1,
       password: $scope.password1,
             }).then(function(response) {
        alert('hi i am working');
        //alert(JSON.stringify(response));
        alert(response.data[0].status);
            if(response.data[0].status == 1){
                window.location.href = 'http://';
            }
            
    }, function errorCallback(response) {
            alert('error');
    // called asynchronously if an error occurs
    // or server returns response with an error status.
  });
    }
    
});

