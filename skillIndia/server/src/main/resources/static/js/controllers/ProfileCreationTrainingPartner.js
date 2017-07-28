var app = angular.module('profileCreationTrainingPartner', ['ui.bootstrap']);
app.controller("AccordionDemoCtrl", ['$scope', '$http',function($scope, $http){
    $scope.states=["--Select--","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Delhi","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu & Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttarakhand","Uttar Pradesh","West Bengal"];
    
    $scope.profileTp={};

    
    $http.get('/getTrainingPartnerData')
    .then(function(response){
    	console.log("In Get  Function ");
    	console.log(response.data);
      $scope.profileTp=response.data;
      console.log($scope.profileTp);
      console.log(response.data.pincode);
      console.log($scope.profileTp.spocname);
      console.log($scope.profileTp.pincode);
      /*if($scope.profileTp.pincode==0)
    	  $scope.profileTp.pincode=null;*/
     
  });
    
$scope.mobileNumbers = [{id: 'mobileNumber1'}];
  
  $scope.addMobileNumber = function() {
    var newItemNo = $scope.mobileNumbers.length+1;
    $scope.mobileNumbers.push({'id':'mobileNumber'+newItemNo});
    
  };
  
  
    
  $scope.removeMobileNumber = function(numberToRemove) {
    $scope.mobileNumbers.splice(numberToRemove,1);
  };


$scope.landlineNumbers = [{id: 'landlineNumber1'}];
  
  $scope.addLandlineNumber = function() {
    var newItemNo = $scope.landlineNumbers.length+1;
    $scope.landlineNumbers.push({'id':'landlineNumber'+newItemNo});
  };
    
  $scope.removeLandlineNumber = function() {
    var lastItem = $scope.landlineNumbers.length-1;
    $scope.landlineNumbers.splice(lastItem);
  };

    
     
  $scope.saveAsDraft = function() {
	  
		

console.log("here in save as draft");


var manageControllerURI = "/saveAsDraft";

$http({
	url : manageControllerURI,
	method : "POST",
	data : $scope.profileTp
	/*data: angular.toJson(editdetailsOfApplication)*/
}).then(
		function(response)
		{
		 console.log("SUCCESS");
/*			
			 $http.get('/approve')
	    	    .then(function(dataResponse){
	    	      $scope.gridOptions.data = dataResponse.data.submitted;
	    	      $scope.gridOptionsIncomplete.data = dataResponse.data.incomplete;
	    	      $scope.gridOptionsRejected.data = dataResponse.data.rejected;
	    	      $scope.gridOptionsApproved.data = dataResponse.data.approved;
	    	      
	    	      var message = response.data.successMessage;
					console.log(response.data);
					$scope.message = response.data.successMessage;
					$scope.messagealert= true;
					var success=$scope.message;
					console.log('THIS IS THE RESPONSE IN THE COMMENT:'+success);	
				    alert(success);
					  	    
	    	      
	    	  })*/
		},
		function(errorResponse, status)
		{
			
			/*$scope.message = response.data.errorMessage;
			$scope.messagealert= true;
			var failure=$scope.message;*/
			console.log('THIS IS THE RESPONSE IN THE COMMENT:'+failure);	
		  
			
		}
		)
};
	  
  
    $scope.validateOnSubmit = function() {
        
  if($scope.profileTp.address==null || $scope.profileTp.address=="")
       $scope.addressExists=true;
         else 
        $scope.addressExists=false;
        
    if($scope.profileTp.city==null || $scope.profileTp.city=="")
       $scope.cityExists=true;
         else 
        $scope.cityExists=false;
        
    if(angular.equals($scope.profileTp.state,"--Select--"))
       $scope.stateExists=true;
         else 
        $scope.stateExists=false;
        
        if($scope.profileTp.pincode==null || $scope.profileTp.pincode=="")
       $scope.pincodeExists=true;
         else 
        $scope.pincodeExists=false;
         
    if($scope.profileTp.mobileNumber==null || $scope.profileTp.mobileNumber=="")
        $scope.mobileNumberExists=true;
         else 
        $scope.mobileNumberExists=false;
        
    if($scope.profileTp.landlineNumber==null || $scope.profileTp.landlineNumber=="")
        $scope.landlineNumberExists=true;
         else 
        $scope.landlineNumberExists=false;
        
     if($scope.profileTp.faxNumber==null || $scope.profileTp.faxNumber=="")
        $scope.faxNumberExists=true;
         else 
        $scope.faxNumberExists=false;
        
     if($scope.profileTp.website==null || $scope.profileTp.website=="" )
        $scope.websiteExists=true;
         else 
        $scope.websiteExists=false; 
  /*   
     if($scope.profileTp.pincode == "/^[0-9]{6}$/")
    	 console.log("Invalid Pincode");*/
     
     
     
     var manageControllerURI = "/submit";

     $http({
     	url : manageControllerURI,
     	method : "POST",
     	data : $scope.profileTp
     	/*data: angular.toJson(editdetailsOfApplication)*/
     }).then(
     		function(response)
     		{
     		 console.log("SUCCESS");
     /*			
     			 $http.get('/approve')
     	    	    .then(function(dataResponse){
     	    	      $scope.gridOptions.data = dataResponse.data.submitted;
     	    	      $scope.gridOptionsIncomplete.data = dataResponse.data.incomplete;
     	    	      $scope.gridOptionsRejected.data = dataResponse.data.rejected;
     	    	      $scope.gridOptionsApproved.data = dataResponse.data.approved;
     	    	      
     	    	      var message = response.data.successMessage;
     					console.log(response.data);
     					$scope.message = response.data.successMessage;
     					$scope.messagealert= true;
     					var success=$scope.message;
     					console.log('THIS IS THE RESPONSE IN THE COMMENT:'+success);	
     				    alert(success);
     					  	    
     	    	      
     	    	  })*/
     		},
     		function(errorResponse, status)
     		{
     			
     			/*$scope.message = response.data.errorMessage;
     			$scope.messagealert= true;
     			var failure=$scope.message;*/
     			console.log('THIS IS THE RESPONSE IN THE COMMENT:'+failure);	
     		  
     			
     		}
     		)
     
     
     
     
        
        
  };

  
  
  
  
  
  
  

}]);
