page3.service('zipCertificateUpload', ['$http', function ($http){
	this.uploadZip = function (batchId, url){
		var fd = new FormData()
		var file = document.getElementById('uploadFile').files[0];
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
            	thisIsResponse=data;
            	return data;
          
            }]
		}).then(function(response) {
        	alert(thisIsResponse);
            return response.data;
            
        }, function errorCallback(response) {
        	alert('Unable to upload try again later');
         });
        
    }

}]);