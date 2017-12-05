var profileCreationAb = angular.module('hello');

profileCreationAb.controller('profileCreationAb' , function($scope, $http, fileUpload){


    $scope.assessmentBody = {
    		
    };

    $scope.names = [
        {
            name : "JSS",
            number : "587",
            year : "2017",
            validity : "2017-08-09"


        },
        {
                    name : "JSS",
                    number : "587",
                    year : "2017",
                    validity : "2017-08-09"

                },
    {
                name : "JSS",
                number : "587",
                year : "2017",
                validity : "2017-08-09"

            }
    ];

    //Get the data from backend
    $http.get('/getDataNewUserProfileCreation')
    .then(function(response){
        console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
        $scope.assessmentBody = response.data;
        console.log("The response from backend is " + JSON.stringify($scope.assessmentBody));

    });


    //Save the data on the click of next button

    $scope.saveAccordionOne = function(){
        console.log("Button Working " + JSON.stringify($scope.assessmentBody));
    }

    // Add new row functionality for the tables
    $scope.addNewExperience = function(experience){
        console.log("data added successfully");
        $scope.assessmentBody.AssessmentsExperienceInTechnicalDomain.push({
            'domain' : ""
        });
    }
    $scope.addNewRecognition = function(recognition){
        console.log("data added successfully");
        $scope.assessmentBody.AssessmentBodyRecognitions.push({
            'name' : ""
        });
    }
    $scope.addNewAffiliation = function(affiliation){
        console.log("data added successfully");
        $scope.assessmentBody.AssessmentBodyAffiliationDetails.push({
            'nameOfSectorSkillCouncil' : ""
        });
    }

    $scope.addNewDirectors = function(directors){
        console.log("Data added successfully");
        $scope.assessmentBody.AssessmentBodyDirectorsAndManagementTeamDetails.push({
             'name' : ""
        });
    }


    $scope.addNewOffice = function(office){
        console.log("Data added successfully");
        $scope.assessmentBody.AssessmentBodyRegionalOfficeDetails.push({
             'address' : ""
        });
    }

    $scope.addNewAssessor = function(assessor){
        console.log("Data added successfully");
        $scope.assessmentBody.AssessmentStaffDetails.push({
             'name' : ""
        });
    }

    //Remove functionality
    $scope.removeExperience = function(){
        
        
        angular.forEach($scope.assessmentBody.AssessmentsExperienceInTechnicalDomain, function(selected){
            if(selected.selected){
            	console.log(selected.domain);
            	selected.isActive = 0;
            	
            }
        });
        //$scope.assessmentBody.AssessmentsExperienceInTechnicalDomain = newDataList;
    };

    $scope.removeRecognition = function(){
        var newDataList=[];
        $scope.selectedAllRecognition = false;
        angular.forEach($scope.assessmentBody.AssessmentBodyRecognitions, function(selected){
        	if(selected.selected){
            	selected.isActive = 0;
            }
        });
    };

    $scope.removeAffiliation = function(){
        var newDataList=[];
//        $scope.selectedAllRecognition = false;
        angular.forEach($scope.assessmentBody.AssessmentBodyAffiliationDetails, function(selected){
        	if(selected.selected){
            	selected.isActive = 0;
            }
        });
        
    };


    $scope.removeDirectors = function(){
        var newDataList=[];
//        $scope.selectedAllRecognition = false;
        angular.forEach($scope.assessmentBody.AssessmentBodyDirectorsAndManagementTeamDetails, function(selected){
        	if(selected.selected){
            	selected.isActive = 0;
            }
        });
    };

    $scope.removeOffice = function(){
        var newDataList=[];
        $scope.selectedAllExperience = false;
        angular.forEach($scope.assessmentBody.AssessmentBodyRegionalOfficeDetails, function(selected){
        	if(selected.selected){
            	selected.isActive = 0;
            }
        });
    };

    $scope.removeAssessor = function(){
        var newDataList=[];
        angular.forEach($scope.assessmentBody.AssessmentStaffDetails, function(selected){
        	if(selected.selected){
            	selected.isActive = 0;
            }
        });
    };

    //Remove all functionality
    $scope.removeAllExperience = function(){
        console.log("Removing all the details..!");
        $scope.assessmentBody.AssessmentsExperienceInTechnicalDomain = [];
    }
    $scope.removeAllRecognition = function(){
        console.log("Removing all the details..!");
        $scope.assessmentBody.AssessmentBodyRecognitions = [];
    }

    $scope.removeAllAffiliation = function(){
        console.log("Removing all the details..!");
        $scope.assessmentBody.AssessmentBodyAffiliationDetails = [];
    }


    $scope.update = function(){
        console.log("The updated JSON is " + JSON.stringify($scope.names));
    };
    
    //Upload file
    $scope.uploadFilePan = function() {
        var file = $scope.assessmentBody.pan;
        console.log("File is " + file);

        var uploadPAN = "/fileUploadABPAN";
        fileUpload.uploadFileToUrl(file, uploadPAN, "pan");
    };
    
    //Upload tan number
    $scope.uploadFileTan = function()
    {
    	var file = $scope.assessmentBody.tan; 
    	var uploadFileUrl = "/fileUploadABTAN";
    	 fileUpload.uploadFileToUrl(file, uploadFileUrl, "tan");
    ;}
    
    $scope.save = function(response){
       // alert("Data saved successfully.. " + response);

        console.log("here in save as draft");


        var saveDraftAndSubmit = "/saveAsDraftAndSubmit";
        
        //console.log($scope.trainingPartner);
        
//        $scope.profileCreationABTPDto = {
//        		"type" : "Draft",
//        		"userData" : null,
//        		"userUploads" : null,
//        		"userDeletes" : null
//        }
    
        

        
        $scope.profileCreationABTPDto = {
        		'type' : 'Draft',
        		'profileCreationAssessmentBodyRegistrationDetailsDto' : $scope.assessmentBody.AssessmentBodyRegistrationDetails,
        		'profileCreationAssessmentBodyAffiliationDetailsDto' : $scope.assessmentBody.AssessmentBodyAffiliationDetails,
        		'profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto' : $scope.assessmentBody.AssessmentBodyDirectorsAndManagementTeamDetails,
        		'profileCreationAssessmentBodyRecognitionsDto' : $scope.assessmentBody.AssessmentBodyRecognitions,
        		'profileCreationAssessmentBodyRegionalOfficeDetailsDto' : $scope.assessmentBody.AssessmentBodyRegionalOfficeDetails,
        		'profileCreationAssessmentsExperienceInTechnicalDomainDto': $scope.assessmentBody.AssessmentsExperienceInTechnicalDomain,
        		'profileCreationAssessmentStaffDetailsDto': $scope.assessmentBody.AssessmentStaffDetails
        }
        $scope.ProfileCreationTestDto = {
        		'name' : 'Ruchi'
        }
       
        
        //console.log($scope.trainingPartner);

        $http({
        	url: "/saveAsDraftAndSubmitAB",
        	method : "POST",
        	data :  angular.toJson( $scope.profileCreationABTPDto)
        	//headers: { 'Content-Type': 'multipart/form-data', 'boundary' :'???' }
        	//headers: { 'Accept': 'application/json', 'Content-Type': 'application/json; ; charset=UTF-8' }
        
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
        			
        			
        			//console.log('THIS IS THE RESPONSE IN THE COMMENT:'+failure);	
        		  
        			
        		}
        		)
        };
   
        $scope.submit = function(response){
            alert("Data saved successfully.. " + response);
            //
    		

            console.log("here in submit");


            var manageControllerURI = "/saveAsDraftAndSubmitAB";
            $scope.profileCreationABTPDto = {
            		'type' : 'Submit',
            		'profileCreationAssessmentBodyRegistrationDetailsDto' : $scope.assessmentBody.profileCreationAssessmentBodyRegistrationDetailsDto,
            		'profileCreationAssessmentBodyAffiliationDetailsDto' : $scope.assessmentBody.AssessmentBodyAffiliationDetails,
            		'profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto' : $scope.assessmentBody.AssessmentBodyDirectorsAndManagementTeamDetails,
            		'profileCreationAssessmentBodyRecognitionsDto' : $scope.assessmentBody.AssessmentBodyRecognitions,
            		'profileCreationAssessmentBodyRegionalOfficeDetailsDto' : $scope.assessmentBody.AssessmentBodyRegionalOfficeDetails,
            		'profileCreationAssessmentsExperienceInTechnicalDomainDto': $scope.assessmentBody.AssessmentsExperienceInTechnicalDomain,
            		'profileCreationAssessmentStaffDetailsDto': $scope.assessmentBody.AssessmentStaffDetails
            }
            console.log($scope.assessmentBody);
            
          
            //$scope.assessmentBody["type"] = "Submit";
            
            console.log($scope.assessmentBody);

            $http({
            	url : manageControllerURI,
            	method : "POST",
            	data : angular.toJson($scope.profileCreationABTPDto)
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