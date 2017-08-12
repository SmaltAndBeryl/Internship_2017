window.onload = function(){
	var open = 'glyphicon-eye-open';
	var close = 'glyphicon-eye-close';
	

	document.getElementById('toggleBtn').onclick = function() {
		var ele = document.getElementById('password');
		if( this.classList.contains(open) ) {
			
	  	ele.type="text";
	    this.classList.remove(open);
	    this.className += ' '+close;
	  } else {
	  	ele.type="password";
	    this.classList.remove(close);
	    this.className += ' '+open;
	  }
	}
	document.getElementById('signUptoggleBtn').onclick = function() {
		var ele = document.getElementById('registerPassword');
		if( this.classList.contains(open) ) {
	  	ele.type="text";
	    this.classList.remove(open);
	    this.className += ' '+close;
	  } else {
	  	ele.type="password";
	    this.classList.remove(close);
	    this.className += ' '+open;
	  }
	}
	//to toggle to login form
	$('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
		//$('#password').password('toggle');

	});
	
	// to toggle to registration form
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	
	//check for blank email
	$('.button').click(function(){
        if ($('input#userId').val() == "")
        {
            alert('Please fill the Email');
        }
    
    
    });
	//check for blank password
	$('#login-submit').click(function(){
        if ($('input#password').val() == "")
        {
            alert('Please fill the password');
        }
    
    
    });
	$('#signup').click(function(){
        if ($('input#registerPassword').val() == "")
        {
            alert('Please fill the password');
        }
    
    
    });
}