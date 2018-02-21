var profileCreationAb = angular.module('hello');

profileCreationAb.controller('profileCreationAb' , function($scope, $http, $location ,fileUpload){
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
    $scope.states = ["Andaman and Nicobar Islands",
                     "Andhra Pradesh", 
                     "Arunachal Pradesh", 
                     "Assam",
                     "Bihar",
                     "Chandigarh",
                     "Chhattisgarh",
                     "Dadra and Nagar Haveli",
                     "Daman and Diu",
                     "Delhi",
                     "Goa",
                     "Gujarat",
                     "Haryana",
                     "Himachal Pradesh",
                     "Jammu and Kashmir",
                     "Jharkhand",
                     "Karnataka",
                     "Kerala",
                     "Lakshadweep",
                     "Madhya Pradesh",
                     "Maharashtra",
                     "Manipur",
                     "Meghalaya",
                     "Mizoram",
                     "Nagaland",
                     "Odisha",
                     "Puducherry",
                     "Punjab",
                     "Rajasthan",
                     "Sikkim",
                     "Tamil Nadu",
                     "Telangana",
                     "Tripura",
                     "Uttar Pradesh",
                     "Uttarakhand",
                     "West Bengal"
                     ];

    //Get the data from backend
    $http.get('/getDataNewUserProfileCreation')
    .then(function(response){
        console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
        $scope.assessmentBody = response.data;
        console.log("The response from backend is " + JSON.stringify($scope.assessmentBody));

    });

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
            	var saveDraftAndSubmit = "/saveAsDraftAndSubmitAB";
                var RequestMethod = "POST";
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
                
                $http({
                	url: saveDraftAndSubmit,
                	method : RequestMethod,
                	data :  angular.toJson( $scope.profileCreationABTPDto)
                
                }).then(
                		function(response)
                		{
                			//Get the data from backend
                		    $http.get('/getDataNewUserProfileCreation')
                		    .then(function(response){
                		        console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
                		        $scope.assessmentBody = response.data;
                		        console.log("The response from backend is " + JSON.stringify($scope.assessmentBody));

                		    });
                
                		},
                		function(errorResponse, status)
                		{
                			console.log("Failed "+ errorResponse);
                		});
    };

    $scope.removeRecognition = function(){
        var newDataList=[];
        $scope.selectedAllRecognition = false;
        angular.forEach($scope.assessmentBody.AssessmentBodyRecognitions, function(selected){
        	if(selected.selected){
            	selected.isActive = 0;
            	console.log(selected.domain);
            	selected.isActive = 0;
            }
        });
            	var saveDraftAndSubmit = "/saveAsDraftAndSubmitAB";
                var RequestMethod = "POST";
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
                
                $http({
                	url: saveDraftAndSubmit,
                	method : RequestMethod,
                	data :  angular.toJson( $scope.profileCreationABTPDto)
                
                }).then(
                		function(response)
                		{
                			//Get the data from backend
                		    $http.get('/getDataNewUserProfileCreation')
                		    .then(function(response){
                		        console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
                		        $scope.assessmentBody = response.data;
                		        console.log("The response from backend is " + JSON.stringify($scope.assessmentBody));

                		    });
                
                		},
                		function(errorResponse, status)
                		{
                			console.log("Failed "+ errorResponse)
                		});

    };

    $scope.removeAffiliation = function(){
       
        angular.forEach($scope.assessmentBody.AssessmentBodyAffiliationDetails, function(selected){
        	if(selected.selected){
            	selected.isActive = 0;
            	console.log(selected.domain);
            	selected.isActive = 0;
            }
        });
            	var saveDraftAndSubmit = "/saveAsDraftAndSubmitAB";
                var RequestMethod = "POST";
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
                
                $http({
                	url: saveDraftAndSubmit,
                	method : RequestMethod,
                	data :  angular.toJson( $scope.profileCreationABTPDto)
                
                }).then(
                		function(response)
                		{
                			//Get the data from backend
                		    $http.get('/getDataNewUserProfileCreation')
                		    .then(function(response){
                		        console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
                		        $scope.assessmentBody = response.data;
                		        console.log("The response from backend is " + JSON.stringify($scope.assessmentBody));

                		    });
                
                		},
                		function(errorResponse, status)
                		{
                			console.log("Failed "+ errorResponse)
                		}
                		);

        
    };


    $scope.removeDirectors = function(){
        angular.forEach($scope.assessmentBody.AssessmentBodyDirectorsAndManagementTeamDetails, function(selected){
        	if(selected.selected){
            	selected.isActive = 0;
            	console.log(selected.domain);
            	selected.isActive = 0;
            }
        });
            	var saveDraftAndSubmit = "/saveAsDraftAndSubmitAB";
                var RequestMethod = "POST";
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
                
                $http({
                	url: saveDraftAndSubmit,
                	method : RequestMethod,
                	data :  angular.toJson( $scope.profileCreationABTPDto)
                
                }).then(
                		function(response)
                		{
                			//Get the data from backend
                		    $http.get('/getDataNewUserProfileCreation')
                		    .then(function(response){
                		        console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
                		        $scope.assessmentBody = response.data;
                		        console.log("The response from backend is " + JSON.stringify($scope.assessmentBody));

                		    });
                
                		},
                		function(errorResponse, status)
                		{
                			console.log("Failed "+ errorResponse)
                		}
                		);
        
    };

    $scope.removeOffice = function(){
        var newDataList=[];
        $scope.selectedAllExperience = false;
        angular.forEach($scope.assessmentBody.AssessmentBodyRegionalOfficeDetails, function(selected){
        	if(selected.selected){
            	selected.isActive = 0;
            	console.log(selected.domain);
            	selected.isActive = 0;
        	  }
        });
            	var saveDraftAndSubmit = "/saveAsDraftAndSubmitAB";
                var RequestMethod = "POST";
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
                
                $http({
                	url: saveDraftAndSubmit,
                	method : RequestMethod,
                	data :  angular.toJson( $scope.profileCreationABTPDto)
                
                }).then(
                		function(response)
                		{
                			//Get the data from backend
                		    $http.get('/getDataNewUserProfileCreation')
                		    .then(function(response){
                		        console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
                		        $scope.assessmentBody = response.data;
                		        console.log("The response from backend is " + JSON.stringify($scope.assessmentBody));

                		    });
                
                		},
                		function(errorResponse, status)
                		{
                			console.log("Failed "+ errorResponse)
                		}
                		);
          
    };

    $scope.removeAssessor = function(){
        var newDataList=[];
        angular.forEach($scope.assessmentBody.AssessmentStaffDetails, function(selected){
        	if(selected.selected){
            	selected.isActive = 0;
            	console.log(selected.domain);
            	selected.isActive = 0;
        	 }
        });
            	var saveDraftAndSubmit = "/saveAsDraftAndSubmitAB";
                var RequestMethod = "POST";
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
                
                $http({
                	url: saveDraftAndSubmit,
                	method : RequestMethod,
                	data :  angular.toJson( $scope.profileCreationABTPDto)
                
                }).then(
                		function(response)
                		{
                			//Get the data from backend
                		    $http.get('/getDataNewUserProfileCreation')
                		    .then(function(response){
                		        console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
                		        $scope.assessmentBody = response.data;
                		        console.log("The response from backend is " + JSON.stringify($scope.assessmentBody));

                		    });
                
                		},
                		function(errorResponse, status)
                		{
                			console.log("Failed "+ errorResponse)
                		}
                		);
           
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
    $scope.uploadUndertakingAB = function()
    {
    	var file = $scope.assessmentbody.undertaking;
    	var uploadUrl = "fileUploadUndertakingAssessmentBody";
    	fileUpload.uploadFileToUrl(file, uploadUrl, "undertakingAB");
    }
    //Upload tan number
    $scope.uploadFileTan = function()
    {
    	var file = $scope.assessmentBody.tan; 
    	var uploadFileUrl = "/fileUploadABTAN";
    	 fileUpload.uploadFileToUrl(file, uploadFileUrl, "tan");
    ;}
    
    //Upload Management Staff CV
    $scope.uploadCvMgmt = function(){
    	var file = $scope.assessmentBody.ManagementResume;
    	var uploadURl = "/fileUploadAbMgmtCv";
    	fileUpload.uploadFileToUrl(file, uploadURl, "AssessmentBodyManagementCV");
    }
    
  //Upload Assessor CV
    $scope.uploadCvAssessor = function(){
    	var file = $scope.assessmentBody.AssessmentResume;
    	var uploadURl = "/fileUploadAbAssessorCv";
    	fileUpload.uploadFileToUrl(file, uploadURl, "AssessmentBodyAssessmentStaffCV");
    }
    
    //Upload Assessment staff certificate 
    $scope.uploadAssessmentStaffCertificate = function(){
    	var file = $scope.assessmentBody.AssessmentStaffCertificate;
    	var uploadURl = "/fileUploadAbAssessorCertificate";
    	fileUpload.uploadFileToUrl(file, uploadURl, "AssessmentBodyAssessmentStaffEducationCertificate");
    }
    
    //Save as draft function
    $scope.save = function(){    

        var url = "/saveAsDraftAndSubmitAB";
        var RequestMethod = "POST";
        $scope.profileCreationABTPDto = {
        		'type' : 'Draft',
        		'profileCreationAssessmentBodyRegistrationDetailsDto' : $scope.assessmentBody.AssessmentBodyRegistrationDetails,
        		'profileCreationAssessmentBodyAffiliationDetailsDto' : $scope.assessmentBody.AssessmentBodyAffiliationDetails,
        		'profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto' : $scope.assessmentBody.AssessmentBodyDirectorsAndManagementTeamDetails,
        		'profileCreationAssessmentBodyRecognitionsDto' : $scope.assessmentBody.AssessmentBodyRecognitions,
        		'profileCreationAssessmentBodyRegionalOfficeDetailsDto' : $scope.assessmentBody.AssessmentBodyRegionalOfficeDetails,
        		'profileCreationAssessmentsExperienceInTechnicalDomainDto': $scope.assessmentBody.AssessmentsExperienceInTechnicalDomain,
        		'profileCreationAssessmentStaffDetailsDto': $scope.assessmentBody.AssessmentStaffDetails
        };
        
        $http({
        	url: url,
        	method : RequestMethod,
        	data :  angular.toJson( $scope.profileCreationABTPDto)
        
        }).then(
        		function(response)
        		{
        			console.log("Success " + response);
        		    $http.get('/getDataNewUserProfileCreation')
        		    .then(function(response){
        		        console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
        		        $scope.assessmentBody = response.data;
        		        console.log("The response from backend is " + JSON.stringify($scope.assessmentBody));

        		    });
       			
        
        		},
        		function(errorResponse, status)
        		{
        			console.log("Failed "+ errorResponse)
        		});
        };
   
        $scope.submit = function(response){
          
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
            		 $location.path("/assessmentBody");
          
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
    
        
});