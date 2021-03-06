var profileCreationTp = angular.module('hello');

profileCreationTp.controller('profileCreationTp', function($scope, $http, $location, fileUpload,$timeout) {


    $http.get('/getDataNewUserProfileCreation')
        .then(function(response) {
            //console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
            //            $scope.trainingPartner = response.data;

            $scope.trainingPartner = response.data;
            //console.log("this is $scope.trainingPartner  " +  JSON.stringify($scope.trainingPartner));
            $scope.TrainingPartnerOrganizationDetails = $scope.trainingPartner.TrainingPartnerOrganizationDetails;


        });
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
    $scope.type = ["regular", "visiting"];
    $scope.buildingTypes = ["Own" , "Rented", "Lease"];
    $scope.pctpCenterDetails = [];
    $scope.center="";
    $scope.pctpInstituteGrantDetail = [];
    $scope.pctpRecognition = [];
    $scope.pctpTrainingStaff = [];
    $scope.pctpTrainingExperience = [];
    
    $scope.addNew = function(experience) {
        //console.log("data added successfully");
        $scope.trainingPartner.PriorExperienceDetails.push({
            'courseName': "",
            'numberOfBatchesPerYear': "",
            'numberOfStudentsInEachBatch': ""
        });
    }
$scope.AddCenter = function()
{
	$scope.trainingPartner.TrainingPartnerCenterDetails.push({
		'nameOfCenter' :""
	});
	}
$scope.addManagement = function(){
	$scope.trainingPartner.ManagementAndStaffAndOfficialDetails.push({
		'name' : ""
	})
}

$scope.addTrainer = function(){
	$scope.trainingPartner.TrainingStaff.push({
		name:""
	})
}


//Remove Trainer 
$scope.removeTrainer = function(){
	//console.log("Inside remove training center function");
	
	
    angular.forEach($scope.trainingPartner.TrainingStaff, function(selected) {
    	//console.log("Inside function" + selected.nameOfCenter);
        if (selected.selected) {
            //console.log("Is active" + selected.isActive)
            selected.isActive = false;
            //console.log("Is active center" + selected.isActive);
            
        }
    }); 
            var url = '/saveAsDraftAndSubmitTP';
            var method = 'POST';
            $scope.postValue = {
                    'type' : 'Draft',
                    'profileCreationTrainingPartnerOrganizationDetailsDto':  $scope.trainingPartner.TrainingPartnerOrganizationDetails,
                    'profileCreationTrainingPartnerCenterDetailsDto' :  $scope.trainingPartner.TrainingPartnerCenterDetails,
                    'profileCreationTrainingPartnerInstituteGrantDto' : $scope.trainingPartner.InstituteGrantDetails,
                    'profileCreationTrainingPartnerInstituteRecognitionDto' :$scope.trainingPartner.InstituteRecognitionDetails,
                    'profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto': $scope.trainingPartner.ManagementAndStaffAndOfficialDetails,
                    'profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto' : $scope.trainingPartner.PriorExperienceDetails,
                    'profileCreationTrainingPartnerTrainingStaffDetailsDto' : $scope.trainingPartner.TrainingStaff
                }
            $http({
            	url : url,
            	method : method,
            	data  : angular.toJson($scope.postValue)
            }).then(function(response){
            	//console.log("response success " + response)
            	$http.get('/getDataNewUserProfileCreation')
                .then(function(response) {
                    //console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
                    $scope.trainingPartner = response.data;
                    //console.log("this is $scope.trainingPartner  " +  JSON.stringify($scope.trainingPartner));
                    $scope.TrainingPartnerOrganizationDetails = $scope.trainingPartner.TrainingPartnerOrganizationDetails;


                });
            },function(errorResponse){
            	//console.log("error response" + errorResponse)
            });
    
}




//Remove Management Staff function 
$scope.removeManagement = function(){
	//console.log("Inside remove training center function");
	
	
    angular.forEach($scope.trainingPartner.ManagementAndStaffAndOfficialDetails, function(selected) {
    	//console.log("Inside function" + selected.nameOfCenter);
        if (selected.selected) {
            //console.log("Is active" + selected.isActive)
            selected.isActive = false;
            //console.log("Is active center" + selected.isActive);
        }
        else
        	{
        	//console.log("inside else");
        	}
    });  
            var url = '/saveAsDraftAndSubmitTP';
            var method = 'POST';
            $scope.postValue = {
                    'type' : 'Draft',
                    'profileCreationTrainingPartnerOrganizationDetailsDto':  $scope.trainingPartner.TrainingPartnerOrganizationDetails,
                    'profileCreationTrainingPartnerCenterDetailsDto' :  $scope.trainingPartner.TrainingPartnerCenterDetails,
                    'profileCreationTrainingPartnerInstituteGrantDto' : $scope.trainingPartner.InstituteGrantDetails,
                    'profileCreationTrainingPartnerInstituteRecognitionDto' :$scope.trainingPartner.InstituteRecognitionDetails,
                    'profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto': $scope.trainingPartner.ManagementAndStaffAndOfficialDetails,
                    'profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto' : $scope.trainingPartner.PriorExperienceDetails,
                    'profileCreationTrainingPartnerTrainingStaffDetailsDto': $scope.trainingPartner.TrainingStaff
                }
            $http({
            	url : url,
            	method : method,
            	data  : angular.toJson($scope.postValue)
            }).then(function(response){
            	//console.log("response success " + response)
            	$http.get('/getDataNewUserProfileCreation')
                .then(function(response) {
                    //console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
                    $scope.trainingPartner = response.data;
                    //console.log("this is $scope.trainingPartner  " +  JSON.stringify($scope.trainingPartner));
                    $scope.TrainingPartnerOrganizationDetails = $scope.trainingPartner.TrainingPartnerOrganizationDetails;


                });
            },function(errorResponse){
            	//console.log("error response" + errorResponse)
            })
   
}

	//Remove training partner center
	$scope.RemoveCenter = function(){
		//console.log("Inside remove training center function");	
		//console.log($scope.trainingPartner.TrainingPartnerCenterDetails);
		//console.log($scope.trainingPartner.TrainingPartnerCenterDetails.selected);		
        angular.forEach($scope.trainingPartner.TrainingPartnerCenterDetails, function(TrainingPartnerCenterDetails, key) {
        	//console.log($scope.trainingPartner.TrainingPartnerCenterDetails.checked);
        	//console.log("key is " + key);
        	//console.log("Inside function" + TrainingPartnerCenterDetails.nameOfCenter);
        	//console.log(TrainingPartnerCenterDetails);
        	//console.log(TrainingPartnerCenterDetails.select);
           if (TrainingPartnerCenterDetails.select)
           {
        	   //console.log("runnig for " + TrainingPartnerCenterDetails.nameOfCenter);
                //console.log("Is active" + TrainingPartnerCenterDetails.isActive);
                TrainingPartnerCenterDetails.isActive = false;
                //console.log("Is active center" + TrainingPartnerCenterDetails.isActive);
                
            }
           else
        	   {
        	   //console.log("Inside else");
        	   }
        });  
           var url = '/saveAsDraftAndSubmitTP';
           var method = 'POST';
           $scope.postValue = {
                   'type' : 'Draft',
                   'profileCreationTrainingPartnerOrganizationDetailsDto':  $scope.trainingPartner.TrainingPartnerOrganizationDetails,
                   'profileCreationTrainingPartnerCenterDetailsDto' :  $scope.trainingPartner.TrainingPartnerCenterDetails,
                   'profileCreationTrainingPartnerInstituteGrantDto' : $scope.trainingPartner.InstituteGrantDetails,
                   'profileCreationTrainingPartnerInstituteRecognitionDto' :$scope.trainingPartner.InstituteRecognitionDetails,
                   'profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto': $scope.trainingPartner.ManagementAndStaffAndOfficialDetails,
                   'profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto' : $scope.trainingPartner.PriorExperienceDetails,
                   'profileCreationTrainingPartnerTrainingStaffDetailsDto' : $scope.trainingPartner.TrainingStaff
               }
           $http({
           	url : url,
           	method : method,
           	data  : angular.toJson($scope.postValue)
           }).then(function(response){
           	//console.log("response success " + response)
           	$http.get('/getDataNewUserProfileCreation')
               .then(function(response) {
                   //console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
                   $scope.trainingPartner = response.data;
                   //console.log("this is $scope.trainingPartner  " +  JSON.stringify($scope.trainingPartner));
                   $scope.TrainingPartnerOrganizationDetails = $scope.trainingPartner.TrainingPartnerOrganizationDetails;


               });
           },function(errorResponse){
           	//console.log("error response" + errorResponse)
           });
             
		
	};
	//Add new recognition in table
    $scope.addNewRecognition = function(recognition) {
        //console.log("data added successfully");
        $scope.trainingPartner.InstituteRecognitionDetails.push({
            'nameOfRecognizingBody': ""
        });
    }
//add new grant
    $scope.addNewGrant = function(experience) {
        //console.log("data added successfully");
        $scope.trainingPartner.InstituteGrantDetails.push({
            'nameOfMinistry': "",
            'natureOfWork': "",
            'remarks': ""
        });
    }
    //remove from prior experience
    $scope.remove = function() {
        var newDataList = [];
        //        $scope.selectedAll = false;
        angular.forEach($scope.trainingPartner.PriorExperienceDetails, function(selected) {
            if (selected.selected) {
            	//console.log("Name of selected center" + selected.nameOfCenter)
                selected.isActive = 0;
            }
        });
            var url = '/saveAsDraftAndSubmitTP';
            var method = 'POST';
            $scope.postValue = {
                    'type' : 'Draft',
                    'profileCreationTrainingPartnerOrganizationDetailsDto':  $scope.trainingPartner.TrainingPartnerOrganizationDetails,
                    'profileCreationTrainingPartnerCenterDetailsDto' :  $scope.trainingPartner.TrainingPartnerCenterDetails,
                    'profileCreationTrainingPartnerInstituteGrantDto' : $scope.trainingPartner.InstituteGrantDetails,
                    'profileCreationTrainingPartnerInstituteRecognitionDto' :$scope.trainingPartner.InstituteRecognitionDetails,
                    'profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto': $scope.trainingPartner.ManagementAndStaffAndOfficialDetails,
                    'profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto' : $scope.trainingPartner.PriorExperienceDetails,
                    'profileCreationTrainingPartnerTrainingStaffDetailsDto' : $scope.trainingPartner.TrainingStaff
                }
            $http({
            	url : url,
            	method : method,
            	data  : angular.toJson($scope.postValue)
            }).then(function(response){
            	//console.log("response success " + response)
            	$http.get('/getDataNewUserProfileCreation')
                .then(function(response) {
                    //console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
                    $scope.trainingPartner = response.data;
                    //console.log("this is $scope.trainingPartner  " +  JSON.stringify($scope.trainingPartner));
                    $scope.TrainingPartnerOrganizationDetails = $scope.trainingPartner.TrainingPartnerOrganizationDetails;


                });
            },function(errorResponse){
            	//console.log("error response" + errorResponse)
            });
        
       
    };

    $scope.removeManagement = function() {
        var newDataList = [];
        //        $scope.selectedAll = false;
        angular.forEach($scope.trainingPartner.ManagementAndStaffAndOfficialDetails, function(selected) {
            if (selected.selected) {
            	//console.log("Name of selected center" + selected.nameOfCenter)
                selected.isActive = 0;
            }
            
        });
        var url = '/saveAsDraftAndSubmitTP';
        var method = 'POST';
        $scope.postValue = {
                'type' : 'Draft',
                'profileCreationTrainingPartnerOrganizationDetailsDto':  $scope.trainingPartner.TrainingPartnerOrganizationDetails,
                'profileCreationTrainingPartnerCenterDetailsDto' :  $scope.trainingPartner.TrainingPartnerCenterDetails,
                'profileCreationTrainingPartnerInstituteGrantDto' : $scope.trainingPartner.InstituteGrantDetails,
                'profileCreationTrainingPartnerInstituteRecognitionDto' :$scope.trainingPartner.InstituteRecognitionDetails,
                'profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto': $scope.trainingPartner.ManagementAndStaffAndOfficialDetails,
                'profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto' : $scope.trainingPartner.PriorExperienceDetails,
                'profileCreationTrainingPartnerTrainingStaffDetailsDto' : $scope.trainingPartner.TrainingStaff
            }
        $http({
        	url : url,
        	method : method,
        	data  : angular.toJson($scope.postValue)
        }).then(function(response){
        	//console.log("response success " + response)
        	$http.get('/getDataNewUserProfileCreation')
            .then(function(response) {
                //console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
                $scope.trainingPartner = response.data;
                //console.log("this is $scope.trainingPartner  " +  JSON.stringify($scope.trainingPartner));
                $scope.TrainingPartnerOrganizationDetails = $scope.trainingPartner.TrainingPartnerOrganizationDetails;


            });
        },function(errorResponse){
        	//console.log("error response" + errorResponse)
        })
    };

    
    $scope.removeRecognition = function() {
        var newDataList = [];
        angular.forEach($scope.trainingPartner.InstituteRecognitionDetails, function(selected) {
            if (selected.selected)
            {
            	//console.log("Name of selected center" + selected.nameOfCenter)
                selected.isActive = 0;
            }
        });
                var url = '/saveAsDraftAndSubmitTP';
                var method = 'POST';
                $scope.postValue = {
                        'type' : 'Draft',
                        'profileCreationTrainingPartnerOrganizationDetailsDto':  $scope.trainingPartner.TrainingPartnerOrganizationDetails,
                        'profileCreationTrainingPartnerCenterDetailsDto' :  $scope.trainingPartner.TrainingPartnerCenterDetails,
                        'profileCreationTrainingPartnerInstituteGrantDto' : $scope.trainingPartner.InstituteGrantDetails,
                        'profileCreationTrainingPartnerInstituteRecognitionDto' :$scope.trainingPartner.InstituteRecognitionDetails,
                        'profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto': $scope.trainingPartner.ManagementAndStaffAndOfficialDetails,
                        'profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto' : $scope.trainingPartner.PriorExperienceDetails,
                        'profileCreationTrainingPartnerTrainingStaffDetailsDto' : $scope.trainingPartner.TrainingStaff
                    }
                $http({
                	url : url,
                	method : method,
                	data  : angular.toJson($scope.postValue)
                }).then(function(response){
                	//console.log("response success " + response)
                	$http.get('/getDataNewUserProfileCreation')
                    .then(function(response) {
                        //console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
                        $scope.trainingPartner = response.data;
                        //console.log("this is $scope.trainingPartner  " +  JSON.stringify($scope.trainingPartner));
                        $scope.TrainingPartnerOrganizationDetails = $scope.trainingPartner.TrainingPartnerOrganizationDetails;


                    });
                },function(errorResponse){
                	//console.log("error response" + errorResponse)
                });
      
        
    };


    $scope.removeGrant = function() {
        var newDataList = [];
        //        $scope.selectedAllGrant = false;
        angular.forEach($scope.trainingPartner.InstituteGrantDetails, function(selected) {
            if (selected.selected) {
            	//console.log("Name of selected center" + selected.nameOfCenter)
                selected.isActive = 0;
            }
        });
                var url = '/saveAsDraftAndSubmitTP';
                var method = 'POST';
                $scope.postValue = {
                        'type' : 'Draft',
                        'profileCreationTrainingPartnerOrganizationDetailsDto':  $scope.trainingPartner.TrainingPartnerOrganizationDetails,
                        'profileCreationTrainingPartnerCenterDetailsDto' :  $scope.trainingPartner.TrainingPartnerCenterDetails,
                        'profileCreationTrainingPartnerInstituteGrantDto' : $scope.trainingPartner.InstituteGrantDetails,
                        'profileCreationTrainingPartnerInstituteRecognitionDto' :$scope.trainingPartner.InstituteRecognitionDetails,
                        'profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto': $scope.trainingPartner.ManagementAndStaffAndOfficialDetails,
                        'profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto' : $scope.trainingPartner.PriorExperienceDetails,
                        'profileCreationTrainingPartnerTrainingStaffDetailsDto' : $scope.trainingPartner.TrainingStaff
                    }
                $http({
                	url : url,
                	method : method,
                	data  : angular.toJson($scope.postValue)
                }).then(function(response){
                	//console.log("response success " + response)
                	$http.get('/getDataNewUserProfileCreation')
                    .then(function(response) {
                        //console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
                        $scope.trainingPartner = response.data;
                        //console.log("this is $scope.trainingPartner  " +  JSON.stringify($scope.trainingPartner));
                        $scope.TrainingPartnerOrganizationDetails = $scope.trainingPartner.TrainingPartnerOrganizationDetails;


                    });
                },function(errorResponse){
                	//console.log("error response" + errorResponse)
                })
  
        
    };

    // Remove all functionality for all the tables

    $scope.removeAll = function()
    {
        //console.log("Removing all the details..!");
        angular.forEach
        $scope.trainingPartner.PriorExperienceDetails = [];
    };

    $scope.removeAllRecognition = function() 
    {
        //console.log("Removing all the details..!");
        $scope.trainingPartner.InstituteRecognitionDetails = [];
    };

    $scope.removeAllGrant = function() 
    {
        //console.log("Removing all the details..!");
        $scope.trainingPartner.InstituteGrantDetails = [];
    };


    //Upload PAN
    $scope.uploadFilePan = function()
    {
        var file = $scope.trainingPartner.pan;
        //console.log("File is " + file);

        var uploadPAN = "/fileUploadTPPAN";
        fileUpload.uploadFileToUrl(file, uploadPAN, "pan");
    };
    
    //Upload TAN
    $scope.uploadFileTAN = function()
    {
    	var file = $scope.trainingPartner.tan;
    	//console.log("File is "+ file);
    	var uploadTAN = "/fileUploadTPTAN";
    	fileUpload.uploadFileToUrl(file, uploadTAN, "tan");
    };
//Upload NSDC Certificate
    $scope.uploadNSDCCertificate = function()
    {
    	
    };
    
    //Update no in nsdc funded
    $scope.updateNoInNSDCCertifiacte = function()
    {
    	$scope.trainingPartner.TrainingPartnerOrganizationDetails.nsdcFunded = "no";
    };
    
    $scope.uploadFileNSDCCertificate = function()
    {
    	var file = $scope.trainingPartner.nsdcCertificateFile;
    	//console.log("File is "+ file);
    	var uploadNSDCCertificate = "/fileUploadTPNSDC";
    	fileUpload.uploadFileToUrl(file, uploadNSDCCertificate, "nsdcCertificate");
    };
    
    //Upload self owned annexure
    $scope.uploadFileselfOwnedAnnexure = function()
    {
    	var file = $scope.trainingPartner.selfOwnedAnnexureFile;
    	//console.log("File is "+ file);
    	var uploadSelfOwnedAnnexure = "/fileuploadTPSelfOwned";
    	
    	fileUpload.uploadFileToUrl(file, uploadSelfOwnedAnnexure, "selfOwnedAnnexure");
    };
    
    
    //Upload franchisee model annexure
    $scope.uploadFilefranchiseeAnnexure = function()
    {
    	var file  = $scope.trainingPartner.franchiseeAnnexureFile;
    	//console.log("File is "+ file);
    	var uploadFranchisee = "/fileuploadTPFranchisee";
    	fileUpload.uploadFileToUrl(file, uploadFranchisee, "fileuploadTPFranchisee");
    };
    
    //Upload Mobile Model Annexure 
    $scope.uploadFilemobileAnnexure = function()
    {
    	var file = $scope.trainingPartner.mobileFile;
    	var uploadMobile = "/fileUploadTPMobile"
    		fileUpload.uploadFileToUrl(file, uploadFranchisee, "fileuploadTPFranchisee");
    };
    
    //Upload Education certificates
    $scope.uploadFileCertificatesQP = function()
    {
    	var file = $scope.trainingPartner.certificatesQP;
    	var uploadEducationCertificates = "/fileUploadTpEducationCertificates";
    	fileUpload.uploadFileToUrl(file, uploadEducationCertificates, "fileuploadTPEducationCertificate");
    	
    };
    
    //Upload Training Staff Cvs
    $scope.uploadFileTrainingStaffCV = function()
    {
    	var file = $scope.trainingPartner.trainingStaffCV;
    	var uploadTrainingStaffCvUrl = "/fileUploadTrainingStaffCv";
    	fileUpload.uploadFileToUrl(file, uploadTrainingStaffCvUrl, "fileuploadTrainingStaffCv");
    };
    
    
    //Upload Cv of Training Partner Management Staff
   $scope.uploadFileManagementStaffCV = function()
   {
	   var file = $scope.trainingPartner.managementStaffCV;
	   var uploadTpManagementStaffCvUrl = "/fileUploadManagementStaffCv";
	   fileUpload.uploadFileToUrl(file, uploadTpManagementStaffCvUrl, "fileUploadTpManagementCv");
		  
   };
   
   //Upload Operation Head Cv
   $scope.uploadFileOperationHeadCv = function(trainingcenter)
   {
	   var file = $scope.trainingPartner.OperationHeadCv;
	   var uploadUrl = "/fileUploadOperationHeadCv";
	   //console.log("Clicked name of center is " );
	   fileUpload.uploadFileWithKey(file, uploadUrl, "operationHeadCv","centerName",trainingcenter.nameOfCenter)
   };
   
   //Upload AffiliationCoordinator Cv
   $scope.uploadFileAffiliationCoordinatorCv = function(trainingcenter)
   {
	   var file = $scope.trainingPartner.affiliationCoordinatorCv;
	   var uploadUrl = "/fileUploadAffiliationCoordinatorCv";
	   fileUpload.uploadFileWithKey(file, uploadUrl, "affiliationCoordinatorCv","centerName",trainingcenter.nameOfCenter);
   };
   
   //Upload SPOC Cv
   $scope.uploadFileSPOCCv = function(trainingcenter)
   {
	   var file = $scope.trainingPartner.SPOCCv;
	   var uploadUrl = "/fileUploadSPOCCv";
	   fileUpload.uploadFileWithKey(file, uploadUrl, "SPOCCv","centerName",trainingcenter.nameOfCenter);
   };
   //Upload ClassroomPics path
   $scope.uploadClassRoomPics = function(trainingcenter)
   {
	   //console.log(trainingcenter)
	   var file = $scope.trainingPartner.fileSizeOfClassrooms;
	   var fileUploadUrl = "/fileUploadClassroomImage";
	   fileUpload.uploadFileWithKey(file,fileUploadUrl,"fileClassroomPic", "centerName",trainingcenter.nameOfCenter)
   };
   //Upload Lab images
   $scope.uploadLabImage = function(trainingcenter)
   {
	   var file = $scope.trainingPartner.fileLab;
	   var uploadUrl = "/fileUploadLabImage";
	   fileUpload.uploadFileWithKey(file,uploadUrl,"fileLabImage", "centerName",trainingcenter.nameOfCenter)
   }
   
   //Upload workshop images
	$scope.uploadWorkshopIamges = function(trainingcenter)
	{
		var file = $scope.trainingPartner.fileWorkshop;
		   var uploadUrl = "/fileUploadWorkshopImage";
		   fileUpload.uploadFileWithKey(file,uploadUrl,"fileWorkshopImage", "centerName",trainingcenter.nameOfCenter)
	}
	
	//Upload Mandatory Toolkit Images
	$scope.uploadMandatoryToolkitImages = function (trainingcenter)
	{
		var file = $scope.trainingPartner.fileMandatoryToolkitImage;
		   var uploadUrl = "/fileUploadMandatoryToolkitImage";
		   fileUpload.uploadFileWithKey(file,uploadUrl,"fileManadatoryToolkitImage", "centerName",trainingcenter.nameOfCenter)
	}
	
	//Upload Mandatory Toolkit Annexure 
	$scope.uploadMandatoryToolkitAnnexure = function(trainingcenter)
	{
		var file = $scope.trainingPartner.fileMandatoryToolkitAnnexure;
		var uploadUrl = "/fileUploadMandatoryToolkitAnnexure";
		   fileUpload.uploadFileWithKey(file,uploadUrl,"fileMandatoryToolkitAnnexure", "centerName",trainingcenter.nameOfCenter)
	}
	//Upload Undertaking
	$scope.uploadLetterofDeclaration = function()
	{
		var file = $scope.trainingPartner.undertaking;
		var uploadUrl = "/fileUploadUndertakingTrainingPartner";
		var key = "undertakingTP";
		   fileUpload.uploadFileToUrl(file,uploadUrl,key);
	}
	
    $scope.grantTable = {
        enableGridMenus: false,
        enableSorting: false,
        enableFiltering: false,
        enableCellEdit: true,
        enableColumnMenus: false,
        enableHorizontalScrollbar: 0,

        columnDefs: [{
                name: 'SNo',
                displayName: 'SNo.',
                cellClass: 'sno',
                headerCellClass: 'layer'
            },
            {
                name: 'ministry',
                displayName: 'Ministry from which grant was received ',
                cellClass: 'fname',
                headerCellClass: 'File-Name'
            },
            {
                name: 'natureOfWork',
                displayName: 'Nature of Work',
                cellClass: 'type',
                headerCellClass: 'Type'
            },
            {
                name: 'remark',
                displayName: 'Remarks',
                cellClass: 'date',
                headerCellClass: 'Date'
            },
        ]
    };

    $scope.directorTable = {
        enableGridMenus: false,
        enableSorting: false,
        enableFiltering: false,
        enableCellEdit: true,
        enableColumnMenus: false,
        enableHorizontalScrollbar: 0,

        columnDefs: [{
                name: 'Name',
                displayName: 'Name',
                cellClass: 'sno',
                headerCellClass: 'layer'
            },
            {
                name: 'Designation',
                displayName: 'Designation',
                cellClass: 'fname',
                headerCellClass: 'File-Name'
            },
            {
                name: 'EmailId',
                displayName: 'Email-id',
                cellClass: 'type',
                headerCellClass: 'Type'
            },
            {
                name: 'ContactNumber',
                displayName: 'Contact Number',
                cellClass: 'date',
                headerCellClass: 'Date'
            },
            {
                name: 'Educational Qualification',
                displayName: 'Educational Qualification',
                cellClass: 'date',
                headerCellClass: 'Date'
            },
            {
                name: 'Experience',
                displayName: 'Experience',
                cellClass: 'date',
                headerCellClass: 'Date'
            },
            {
                name: 'UploadCV',
                displayName: 'Upload CV',
                cellClass: 'date',
                headerCellClass: 'Date'
            },
        ]
    };

    $scope.trainingStaffTable = {
        enableGridMenus: false,
        enableSorting: false,
        enableFiltering: false,
        enableCellEdit: true,
        enableColumnMenus: false,
        enableHorizontalScrollbar: 0,

        columnDefs: [{
                name: 'Name',
                displayName: 'Name',
                cellClass: 'sno',
                headerCellClass: 'layer'
            },
            {
                name: 'Designation',
                displayName: 'Designation',
                cellClass: 'fname',
                headerCellClass: 'File-Name'
            },
            {
                name: 'EmailId',
                displayName: 'Email-id',
                cellClass: 'type',
                headerCellClass: 'Type'
            },
            {
                name: 'EducationalQualification',
                displayName: 'Educational Qualification',
                cellClass: 'date',
                headerCellClass: 'Date'
            },
            {
                name: 'IndustrialExperience',
                displayName: 'Industrial Experience',
                cellClass: 'date',
                headerCellClass: 'Date'
            },
            {
                name: 'Regular/Visiting',
                displayName: 'Regular/Visiting',
                cellClass: 'date',
                headerCellClass: 'Date'
            },
            {
                name: 'UploadCV',
                displayName: 'Upload CV',
                cellClass: 'date',
                headerCellClass: 'Date'
            },
            {
                name: 'UploadCertificate',
                displayName: 'Upload Certificate',
                cellClass: 'date',
                headerCellClass: 'Date'
            },
        ]
    };
    
    $scope.nextOne = function()
    {
    	 
         
    }
    //Method to be called on save button
    $scope.save = function(response) {
    	var saveUrl = '/saveAsDraftAndSubmitTP';
        var saveMethod = 'POST';
        $scope.rolling = true;
        $scope.generating = "Trying to save data.Please wait";
    	$scope.postValue = {
    			
            'type' : 'Draft',
            'profileCreationTrainingPartnerOrganizationDetailsDto':  $scope.trainingPartner.TrainingPartnerOrganizationDetails,
            'profileCreationTrainingPartnerCenterDetailsDto' :  $scope.trainingPartner.TrainingPartnerCenterDetails,
            'profileCreationTrainingPartnerInstituteGrantDto' : $scope.trainingPartner.InstituteGrantDetails,
            'profileCreationTrainingPartnerInstituteRecognitionDto' :$scope.trainingPartner.InstituteRecognitionDetails,
            'profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto': $scope.trainingPartner.ManagementAndStaffAndOfficialDetails,
            'profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto' : $scope.trainingPartner.PriorExperienceDetails,
            'profileCreationTrainingPartnerTrainingStaffDetailsDto' : $scope.trainingPartner.TrainingStaff
        }
        
        //console.log("Preparing to post the values.............");
        $http({
                url: saveUrl,
                method: saveMethod,
                data: angular.toJson($scope.postValue)
        
            }).then(
                function successCallback(response) {
                	
                    //console.log("SUCCESS 123");
                    //console.log("RESPONSE COMING FROM SERVER IS  : " + JSON.stringify(response));
                    
                    //console.log("RESPONSE COMING FROM SERVER IS  : " + JSON.stringify(response.data));
                    if(response.status == 200){
                        $scope.successText = "Your data has been saved successfully";
                        $scope.successTextColor = "green";
                        $scope.rolling = false;
                    }
                    if (response.data == "") {
                        //console.log("NULL DATA I.E. ERROR");
                    } else
                    	{
                    	//console.log("ELSE");
                    	$http.get('/getDataNewUserProfileCreation')
                        .then(function(response) {
                            //console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
                            //            $scope.trainingPartner = response.data;

                            $scope.trainingPartner = response.data;
                            
                            //console.log("this is $scope.trainingPartner  " +  JSON.stringify($scope.trainingPartner));
                            $scope.TrainingPartnerOrganizationDetails = response.data.TrainingPartnerOrganizationDetails;
                            $scope.trainingPartner.TrainingPartnerCenterDetails = response.data.TrainingPartnerCenterDetails;
                            $scope.trainingPartner.InstituteGrantDetails = response.data.InstituteGrantDetails;
                            $scope.trainingPartner.InstituteRecognitionDetails = response.data.InstituteRecognitionDetails;
                            $scope.trainingPartner.ManagementAndStaffAndOfficialDetails = response.data.ManagementAndStaffAndOfficialDetails;
                            $scope.trainingPartner.PriorExperienceDetails = response.data.PriorExperienceDetails;
                            $scope.trainingPartner.TrainingStaff = response.data.TrainingStaff;
                        });
                    	$timeout(function() {
                            $scope.successText="";
                         }, 2000);
                    	//console.log("ELSE");
                    	}
                        

                },
                function errorCallBack(response) {
                	
                        $scope.successText = "Could not save your data please refresh page";
                        $scope.successTextColor = "red";
                        $scope.rolling = false;
                    
                    //console.log("Sorry the data could not be posted, an unknown error occurred..// " + response.status + " " + response.statusText);
                });
    };

    	//Submit button Method
    $scope.submit = function(response) {
    	var url = '/saveAsDraftAndSubmitTP';
    	var method = 'POST';
    	$scope.rolling = true;
        $scope.generating = "Trying to submit application.Please wait"
    	$scope.postValue = {
                'type' : 'Submit',
                'profileCreationTrainingPartnerOrganizationDetailsDto':  $scope.trainingPartner.TrainingPartnerOrganizationDetails,
                'profileCreationTrainingPartnerCenterDetailsDto' :  $scope.trainingPartner.TrainingPartnerCenterDetails,
                'profileCreationTrainingPartnerInstituteGrantDto' : $scope.trainingPartner.InstituteGrantDetails,
                'profileCreationTrainingPartnerInstituteRecognitionDto' :$scope.trainingPartner.InstituteRecognitionDetails,
                'profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto': $scope.trainingPartner.ManagementAndStaffAndOfficialDetails,
                'profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto' : $scope.trainingPartner.PriorExperienceDetails,
                'profileCreationTrainingPartnerTrainingStaffDetailsDto' : $scope.trainingPartner.TrainingStaff
            }
    	$http({
    		url : url,
    		method : method,
    		data : angular.toJson($scope.postValue)
    	}).then(function(response){
    		
    		if(response.status == 200){
            $scope.successText = "Your data has been saved successfully";
            $scope.successTextColor = "green";
            $scope.rolling = false;
            $location.path("/trainingPartner");
        }
    		
    	},
    	function(errorResponse){
    		//console.log(errorResponse);
    	})
    };

});