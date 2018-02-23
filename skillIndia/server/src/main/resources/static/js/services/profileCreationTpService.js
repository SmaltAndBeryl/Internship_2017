profileCreationTp.service('fileUpload', ['$http', function($http){
    this.uploadFileToUrl = function(file, uploadUrl,key){
       var fd = new FormData();
       
            fd.append(key, file)
       
var method = "POST";
       $http.post(uploadUrl, fd, {
          transformRequest: angular.identity,
          headers: {'Content-Type': undefined}
       })
       .then(function(response){
            //console.log("The file was uploaded successfully");
            //console.log(response);
       },function errorCallback(response){
            //console.log(JSON.stringify(response.data));
       });
      
    }
    
    this.uploadFileWithKey = function(file, uploadUrl,keyFile, keyData, keyDataValue){
    	var fd = new FormData();
        
        fd.append(keyFile, file);
        fd.append(keyData,keyDataValue);
   
var method = "POST";
   $http.post(uploadUrl, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
   })
   .then(function(response){
        //console.log("The file was uploaded successfully");
        //console.log(response);
   },function errorCallback(response){
        //console.log(JSON.stringify(response.data));
   });
    }
 }]);