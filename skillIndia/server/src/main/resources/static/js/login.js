    $(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
		$("#password").password('toggle');

	});
//	$('#register-form-link').click(function(e) {
//		$("#register-form").delay(100).fadeIn(100);
// 		$("#login-form").fadeOut(100);
//		$('#login-form-link').removeClass('active');
//		$(this).addClass('active');
//		e.preventDefault();
//	});

});

        function login(){
        //login code here
    var username = $('#username').val();
      
            $.post(url, function(data, status)
            		{
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
      
            
         
    {
        password=confirmpassword,
        email=email,
        username=username
    }
    
   };
 