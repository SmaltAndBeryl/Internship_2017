profileCreationTp.service('fileUpload', ['$http', function($http){
    this.uploadFileToUrl = function(file, uploadUrl){
       var fd = new FormData();

       angular.forEach(form.attachedFiles, function(file, key){
            var fileName = 'attached-file' + key;
            fd.append(fileName, file)
       })

       $http.post(uploadUrl, fd, {
          transformRequest: angular.identity,
          headers: {'Content-Type': undefined}
       })

       .then(function(response){
            console.log("The file was uploaded successfully");
       },function errorCallback(response){
            console.log(JSON.stringify(response.data));
       });
    }
 }]);