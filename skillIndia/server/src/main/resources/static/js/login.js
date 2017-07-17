console.log("File reached");


var open = 'glyphicon-eye-open';
var close = 'glyphicon-eye-close';
var ele = document.getElementById('password');

document.getElementById('toggleBtn').onclick = function() {
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

var open = 'glyphicon-eye-open';
var close = 'glyphicon-eye-close';
var el = document.getElementById('mypassword');

document.getElementById('toggleBt').onclick = function() {
	if( this.classList.contains(open) ) {
  	el.type="text";
    this.classList.remove(open);
    this.className += ' '+close;
  } else {
  	el.type="password";
    this.classList.remove(close);
    this.className += ' '+open;
  }
}

console.log("File reached");

//    $(function() {
//
//    $('#login-form-link').click(function(e) {
//		$("#login-form").delay(100).fadeIn(100);
// 		$("#register-form").fadeOut(100);
//		$('#register-form-link').removeClass('active');
//		$(this).addClass('active');
//		e.preventDefault();
//		$('#password').password('toggle');
//
//	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

//});

        
    
        
   
        
       

    
   