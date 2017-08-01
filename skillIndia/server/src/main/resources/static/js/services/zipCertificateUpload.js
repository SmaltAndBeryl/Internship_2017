page3.service('zipCertificateUpload', ['$http', function ($http){
	this.uploadZip = function (batchId, url){
		var fd = new FormData()
		var file = document.getElementById('uploadFile').files[0];
	//console.log('File Name:....'+file);
		var userId = 'xyz@gmail.com';
		fd.append('file',file);
		fd.append('batchId',batchId);
		fd.append('userId',userId);
		
		
		$http({
			method: 'POST',
        	url: url,
            data: fd,
            headers: {'Content-Type': undefined},
            
            transformRequest: angular.identity,
            transformResponse: [function (data) {
//            	console.log(data);
            	thisIsResponse=data;
//            	console.log(thisIsResponse);
            	return data;
          
            }]
		}).then(function(response) {
            
//        	console.log("response of success -----");
//        	console.log(thisIsResponse);
//        	responseOfUpload(thisIsResponse);
        	alert(thisIsResponse);
            return response.data;
            
        }, function errorCallback(response) {
        	alert('Unable to upload try again later');
//        	console.log("Error in receiving response from backend------" +response);
//            console.log('Error: '+response);
         });
        
    }
}]);