var profileCreationTp = angular.module('hello');

profileCreationTp.controller('profileCreationTp' , function($scope, $http, fileUpload){

//    $http.get('/url')
//        .then(function(response){
//
//        });

//     $scope.trainingPartner;

    // Store response.data into trainingPartner

//    $scope.TrainingPartnerOrganizationDetails;

    $http.get('/getDataNewUserProfileCreation')
        .then(function(response){
            console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
//            $scope.trainingPartner = response.data;

            $scope.trainingPartner = response.data;
            $scope.TrainingPartnerOrganizationDetails = $scope.trainingPartner.TrainingPartnerOrganizationDetails;

            $scope.spocName = $scope.TrainingPartnerOrganizationDetails.sPOCName;
            console.log("THE SPOC name is " + JSON.stringify($scope.spocName));
            console.log("The training partner is to be filled " + JSON.stringify($scope.trainingPartner));
            console.log("The training partner organization details are " + JSON.stringify($scope.trainingPartner.TrainingPartnerOrganizationDetails));
            console.log("The training partner organization details are " + JSON.stringify($scope.TrainingPartnerOrganizationDetails));

        });
    $scope.states = ["UP", "Uttarakhand", "MP", "Bihar"];

    $scope.addNew = function(experience){
        console.log("data added successfully");
        $scope.trainingPartner.PriorExperienceDetails.push({
            'courseName' : "",
            'numberOfBatchesPerYear' : "",
            'numberOfStudentsInEachBatch' : ""
        });
    }

    $scope.addNewRecognition = function(recognition){
        console.log("data added successfully");
        $scope.trainingPartner.InstituteRecognitionDetails.push({
            'nameOfMinistry' : "",
            'natureOfWork' : "",
            'remarks' : ""
        });
    }

    $scope.addNewGrant = function(experience){
        console.log("data added successfully");
        $scope.trainingPartner.InstituteGrantDetails.push({
            'nameOfMinistry' : "",
            'natureOfWork' : "",
            'remarks' : ""
        });
    }



//  Check All functionality for all the tables


// Remove functionality for all the tables

    $scope.remove = function(){
        var newDataList=[];
//        $scope.selectedAll = false;
        angular.forEach($scope.trainingPartner.PriorExperienceDetails, function(selected){
            if(!selected.selected){
                newDataList.push(selected);
            }
        });
        $scope.trainingPartner.PriorExperienceDetails = newDataList;
    };

    $scope.removeRecognition = function(){
        var newDataList=[];
//        $scope.selectedAllRecognition = false;
        angular.forEach($scope.trainingPartner.InstituteRecognitionDetails, function(selected){
            if(!selected.selected){
                newDataList.push(selected);
            }
        });
        $scope.trainingPartner.InstituteRecognitionDetails = newDataList;
    };


    $scope.removeGrant = function(){
        var newDataList=[];
//        $scope.selectedAllGrant = false;
        angular.forEach($scope.trainingPartner.InstituteGrantDetails, function(selected){
            if(!selected.selected){
                newDataList.push(selected);
            }
        });
        $scope.trainingPartner.InstituteGrantDetails = newDataList;
    };

// Remove all functionality for all the tables

    $scope.removeAll = function(){
        console.log("Removing all the details..!");
        $scope.trainingPartner.PriorExperienceDetails = [];
    }

    $scope.removeAllRecognition = function(){
        console.log("Removing all the details..!");
        $scope.trainingPartner.InstituteRecognitionDetails = [];
    }

    $scope.removeAllGrant = function(){
        console.log("Removing all the details..!");
        $scope.trainingPartner.InstituteGrantDetails = [];
    };

    $scope.saveAccordionOne = function(){
        console.log("Button Working " + JSON.stringify($scope.trainingPartner));
    };

//Upload File functionality
    $scope.uploadFile = function(){
        var file = $scope.myFile;
        console.log("File is " + file);

        var uploadUrl = "/fileUpload";
        fileUpload.uploadFileToUrl(file, uploadUrl);
    };

    //Preview attachments
    $scope.previewAttachments = function(event){
        var files = event.target.files;
        $scope.attachments = [];
        angular.forEach(files, function(file){
            $scope.attachments.push(file.name);
            var reader = new FileReader();
            reader.onload = function(){
                $scope.$apply();
            }
            reader.readAsDataURL(file);
        })
    }

    $scope.grantTable = {
        enableGridMenus : false,
        enableSorting: false,
        enableFiltering: false,
        enableCellEdit : true,
        enableColumnMenus : false,
        enableHorizontalScrollbar:0,

        columnDefs:[
          { name: 'SNo',           displayName: 'SNo.',              cellClass:'sno',  headerCellClass:'layer'},
          { name: 'ministry',            displayName: 'Ministry from which grant was received ',          cellClass:'fname',headerCellClass:'File-Name'},
          { name: 'natureOfWork',            displayName: 'Nature of Work',               cellClass:'type', headerCellClass:'Type'},
          { name: 'remark',    displayName: 'Remarks',               cellClass:'date', headerCellClass:'Date'},
       ]
      };

    $scope.directorTable = {
          enableGridMenus : false,
          enableSorting: false,
          enableFiltering: false,
          enableCellEdit : true,
          enableColumnMenus : false,
          enableHorizontalScrollbar:0,

          columnDefs:[
            { name: 'Name',           displayName: 'Name',              cellClass:'sno',  headerCellClass:'layer'},
            { name: 'Designation',            displayName: 'Designation',          cellClass:'fname',headerCellClass:'File-Name'},
            { name: 'EmailId',            displayName: 'Email-id',               cellClass:'type', headerCellClass:'Type'},
            { name: 'ContactNumber',    displayName: 'Contact Number',               cellClass:'date', headerCellClass:'Date'},
            { name: 'Educational Qualification',    displayName: 'Educational Qualification',               cellClass:'date', headerCellClass:'Date'},
            { name: 'Experience',    displayName: 'Experience',               cellClass:'date', headerCellClass:'Date'},
            { name: 'UploadCV',    displayName: 'Upload CV',               cellClass:'date', headerCellClass:'Date'},
         ]
        };

    $scope.trainingStaffTable = {
          enableGridMenus : false,
          enableSorting: false,
          enableFiltering: false,
          enableCellEdit : true,
          enableColumnMenus : false,
          enableHorizontalScrollbar:0,

          columnDefs:[
            { name: 'Name',           displayName: 'Name',              cellClass:'sno',  headerCellClass:'layer'},
            { name: 'Designation',            displayName: 'Designation',          cellClass:'fname',headerCellClass:'File-Name'},
            { name: 'EmailId',            displayName: 'Email-id',               cellClass:'type', headerCellClass:'Type'},
            { name: 'EducationalQualification',    displayName: 'Educational Qualification',               cellClass:'date', headerCellClass:'Date'},
            { name: 'IndustrialExperience',    displayName: 'Industrial Experience',               cellClass:'date', headerCellClass:'Date'},
            { name: 'Regular/Visiting',    displayName: 'Regular/Visiting',               cellClass:'date', headerCellClass:'Date'},
            { name: 'UploadCV',    displayName: 'Upload CV',               cellClass:'date', headerCellClass:'Date'},
            { name: 'UploadCertificate',    displayName: 'Upload Certificate',               cellClass:'date', headerCellClass:'Date'},
         ]
        };
    //response is the string that contains the nature of the button
    /*$scope.submit = function(response){
        alert("Application filled successfully! " + response);
        //POST function to post the data into backend

    };*/

    $scope.save = function(response){
        alert("Data saved successfully.. " + response);
        //POST function to post into backend
		

        console.log("here in save as draft");


        var manageControllerURI = "/saveAsDraftAndSubmit";
        
        console.log($scope.trainingPartner);
        
       /* $scope.trainingPartner = $scope.trainingPartner.concat([
                                                  {type : "SaveAsDraft"}
                                                ]);*/
        
        $scope.trainingPartner["type"] = "SaveAsDraft";
        
        console.log($scope.trainingPartner);

        $http({
        	url : manageControllerURI,
        	method : "POST",
        	data : $scope.trainingPartner
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
        
        
        $scope.submit = function(response){
            alert("Data saved successfully.. " + response);
            //POST function to post into backend
    		

            console.log("here in submit");


            var manageControllerURI = "/saveAsDraftAndSubmit";
            
            console.log($scope.trainingPartner);
            
           /* $scope.trainingPartner = $scope.trainingPartner.concat([
                                                      {type : "SaveAsDraft"}
                                                    ]);*/
            
            $scope.trainingPartner["type"] = "Submit";
            
            console.log($scope.trainingPartner);

            $http({
            	url : manageControllerURI,
            	method : "POST",
            	data : $scope.trainingPartner
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
        
        
        
            $http.get('/getTrainingPartnerData')
            .then(function(response){
            	console.log("In Get  Function ");
            	console.log(response.data);
            	$scope.trainingPartner=response.data;
              console.log($scope.trainingPartner);
              console.log(response.data.pincode);
              console.log($scope.trainingPartner.sPOCName);
              console.log($scope.trainingPartner.pincode);
              /*if($scope.profileTp.pincode==0)
            	  $scope.profileTp.pincode=null;*/
             
          });
        
        
        
        
        
        
        
        
        
});