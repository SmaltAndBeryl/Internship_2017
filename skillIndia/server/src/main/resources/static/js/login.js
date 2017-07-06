
       <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
    <script>
        
    //Create a module and create a controller for angular
        var myangularapp = angular.module("myangularapp", []);
myangularapp.controller("myangularController", function($scope,$http) {
       
        
    $scope.login = function (){
     alert('test3');
    
        $scope.username;
        $scope.password1;
        
        $http.post('http://localhost/loginangulartutorial2/webservices/login.php', { username: $scope.username,
       password: $scope.password1,
             }).then(function(response) {
        alert('hi i am working');
        //alert(JSON.stringify(response));
        alert(response.data[0].status);
            if(response.data[0].status == 1){
                window.location.href = 'http://joelwebsites.com';
            }
            
    }, function errorCallback(response) {
            alert('error');
    // called asynchronously if an error occurs
    // or server returns response with an error status.
  });
    }
    
});
    
    
    
    </script>
    
    
    
  <script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script>
    
    $(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
		$('#password').password('toggle');

	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});

        function login(){
        //login code here
    var username = $('#username').val();
    var password = $('#password1').val();
            
    alert(username+'hi i am the username login');
        alert(password+'hi i am the password login');
            
        alert('login function is called!');
       var url = 'http://localhost/logintutorial/webservices/login.php?username='+username+'&password='+password;
            
            alert(url);
            console.log(url);
            $.post(url,
    function(data, status){
                
                alert(JSON.stringify(data));
                var status = data[0].status;
                
                if(status == 1){
                    //this is the sucess code
                    window.location.href = 'http://joelwebsites.com';
                }
                
                if(status != 1){
                    alert('login failed');
                }
                alert(status+'i am the status test');
        alert("Data: " + data + "\nStatus: " + status);
    });
        
        }
        function register(){
    var email = $('#email').val();
    var username = $('#username').val();
    var confirmpassword =$('#confirm-password').val();
      
            
            $.post("http://localhost/logintutorial/webservices/register.php",
    {
        password: confirmpassword,
        email: email,
        username: username
    },
    function(data, status){
        alert("Data: " + data + "\nStatus: " + status);
    });
        }
        
    </script>

    
   