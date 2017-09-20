var profileCreationTp = angular.module('hello');

profileCreationTp.controller('profileCreationAb' , function($scope, $http.$location){


     $scope.assessmentBody = {};

    $scope.save = function(response){
        alert("Data saved successfully.. " + response);

        console.log("here in save as draft");


        var manageControllerURI = "/saveAsDraftAndSubmit";
        
        console.log($scope.trainingPartner);
        
        $scope.assessmentBody["type"] = "SaveAsDraft";
        
        console.log($scope.trainingPartner);

        $http({
        	url : manageControllerURI,
        	method : "POST",
        	data : $scope.assessmentBody
        	/*data: angular.toJson(editdetailsOfApplication)*/
        }).then(
        		function(response)
        		{
        			console.log("SUCCESS 123");
        			console.log("RESPONSE COMING FROM SERVER IS  : "+ response);
        			
        			console.log("RESPONSE COMING FROM SERVER IS  : "+ response.data);
        		 if(response.data == "" )
        			 {
        			 console.log("NULL DATA I.E. ERROR");
        			 }
        		 else
        			 console.log("ELSE");
        			
        
        		},
        		function(errorResponse, status)
        		{
        			
        			
        			console.log('THIS IS THE RESPONSE IN THE COMMENT:'+failure);	
        		  
        			
        		}
        		)
        };
        
        
        $scope.submit = function(response){
            alert("Data saved successfully.. " + response);
            //
    		

            console.log("here in submit");


            var manageControllerURI = "/saveAsDraftAndSubmit";
            
            console.log($scope.assessmentBody);
            
          
            $scope.assessmentBody["type"] = "Submit";
            
            console.log($scope.assessmentBody);

            $http({
            	url : manageControllerURI,
            	method : "POST",
            	data : $scope.assessmentBody
            	/*data: angular.toJson(editdetailsOfApplication)*/
            }).then(
            		function(response)
            		{
            		 console.log("SUCCESS");
          
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
        
        
        
            $http.get()
            .then(function(response){
            	console.log("In Get  Function ");
            	console.log(response.data);
            	$scope.assessmentBody=response.data;
              console.log($scope.assessmentBody);
              console.log(response.data.pincode);
              console.log($scope.assessmentBody.sPOCName);
              console.log($scope.assessmentBody.pincode);
              /*if($scope.profileTp.pincode==0)
            	  $scope.profileTp.pincode=null;*/
             
          });
        
        
        
        
        
        
        
        
        
});