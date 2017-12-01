var profileCreationTp = angular.module('hello');

profileCreationTp.controller('profileCreationTp', function($scope, $http, fileUpload) {


    $http.get('/getDataNewUserProfileCreation')
        .then(function(response) {
            console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
            //            $scope.trainingPartner = response.data;

            $scope.trainingPartner = response.data;
            console.log("this is $scope.trainingPartner  " +  JSON.stringify($scope.trainingPartner));
            $scope.TrainingPartnerOrganizationDetails = $scope.trainingPartner.TrainingPartnerOrganizationDetails;


        });
    $scope.states = ["UP", "Uttarakhand", "MP", "Bihar"];
    $scope.type = ["regular", "visiting"];
    $scope.pctpCenterDetails = [];
    $scope.pctpOrgDetails = [];
    $scope.pctpInstituteGrantDetail = [];
    $scope.pctpRecognition = [];
    $scope.pctpTrainingStaff = [];
    $scope.pctpTrainingExperience = [];
    
    $scope.addNew = function(experience) {
        console.log("data added successfully");
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

    $scope.addNewRecognition = function(recognition) {
        console.log("data added successfully");
        $scope.trainingPartner.InstituteRecognitionDetails.push({
            'nameOfMinistry': "",
            'natureOfWork': "",
            'remarks': ""
        });
    }

    $scope.addNewGrant = function(experience) {
        console.log("data added successfully");
        $scope.trainingPartner.InstituteGrantDetails.push({
            'nameOfMinistry': "",
            'natureOfWork': "",
            'remarks': ""
        });
    }


    // Remove functionality for all the tables

    $scope.remove = function() {
        var newDataList = [];
        //        $scope.selectedAll = false;
        angular.forEach($scope.trainingPartner.PriorExperienceDetails, function(selected) {
            if (!selected.selected) {
                newDataList.push(selected);
            }
        });
        $scope.trainingPartner.PriorExperienceDetails = newDataList;
    };
    //remove from management and training staff
    $scope.remove = function() {
        var newDataList = [];
        //        $scope.selectedAll = false;
        angular.forEach($scope.trainingPartner.PriorExperienceDetails, function(selected) {
            if (!selected.selected) {
                newDataList.push(selected);
            }
        });
        $scope.trainingPartner.PriorExperienceDetails = newDataList;
    };

    
    $scope.removeRecognition = function() {
        var newDataList = [];
        //        $scope.selectedAllRecognition = false;
        angular.forEach($scope.trainingPartner.InstituteRecognitionDetails, function(selected) {
            if (!selected.selected) {
                newDataList.push(selected);
            }
        });
        $scope.trainingPartner.InstituteRecognitionDetails = newDataList;
    };


    $scope.removeGrant = function() {
        var newDataList = [];
        //        $scope.selectedAllGrant = false;
        angular.forEach($scope.trainingPartner.InstituteGrantDetails, function(selected) {
            if (!selected.selected) {
                newDataList.push(selected);
            }
        });
        $scope.trainingPartner.InstituteGrantDetails = newDataList;
    };

    // Remove all functionality for all the tables

    $scope.removeAll = function() {
        console.log("Removing all the details..!");
        $scope.trainingPartner.PriorExperienceDetails = [];
    }

    $scope.removeAllRecognition = function() {
        console.log("Removing all the details..!");
        $scope.trainingPartner.InstituteRecognitionDetails = [];
    }

    $scope.removeAllGrant = function() {
        console.log("Removing all the details..!");
        $scope.trainingPartner.InstituteGrantDetails = [];
    };

    $scope.saveAccordionOne = function() {
        console.log("Button Working " + JSON.stringify($scope.trainingPartner));
    };

    //Upload PAN
    $scope.uploadFilePan = function() {
        var file = $scope.trainingPartner.pan;
        console.log("File is " + file);

        var uploadPAN = "/fileUploadTPPAN";
        fileUpload.uploadFileToUrl(file, uploadPAN, "pan");
    };
    
    //Upload TAN
    $scope.uploadFileTAN = function()
    {
    	var file = $scope.trainingPartner.tan;
    	console.log("File is "+ file);
    	var uploadTAN = "/fileUploadTPTAN";
    	fileUpload.uploadFileToUrl(file, uploadTAN, "tan");
    }
//Upload NSDC Certificate
    $scope.uploadNSDCCertificate = function()
    {
    	
    }
    
    //Update no in nsdc funded
    $scope.updateNoInNSDCCertifiacte = function()
    {
    	$scope.trainingPartner.TrainingPartnerOrganizationDetails.nsdcFunded = "no";
    }
    
    $scope.uploadFileNSDCCertificate = function()
    {
    	var file = $scope.trainingPartner.nsdcCertificateFile;
    	console.log("File is "+ file);
    	var uploadNSDCCertificate = "/fileUploadTPNSDC";
    	fileUpload.uploadFileToUrl(file, uploadNSDCCertificate, "nsdcCertificate");
    }
    
    //Upload self owned annexure
    $scope.uploadFileselfOwnedAnnexure = function()
    {
    	var file = $scope.trainingPartner.selfOwnedAnnexureFile;
    	console.log("File is "+ file);
    	var uploadSelfOwnedAnnexure = "/fileuploadTPSelfOwned";
    	fileUpload.uploadFileToUrl(file, uploadSelfOwnedAnnexure, "selfOwnedAnnexure");
    }
    
    
    //Upload franchisee model annexure
    $scope.uploadFilefranchiseeAnnexure = function()
    {
    	var file  = $scope.trainingPartner.franchiseeAnnexureFile;
    	console.log("File is "+ file);
    	var uploadFranchisee = "/fileuploadTPFranchisee";
    	fileUpload.uploadFileToUrl(file, uploadFranchisee, "fileuploadTPFranchisee");
    }
    
    //Upload Mobile Model Annexure 
    $scope.uploadFilemobileAnnexure = function()
    {
    	var file = $scope.trainingPartner.mobileFile;
    	var uploadMobile = "/fileUploadTPMobile"
    }
    
    //Preview attachments
//    $scope.previewAttachments = function(event) {
//        var files = event.target.files;
//        $scope.attachments = [];
//        angular.forEach(files, function(file) {
//            $scope.attachments.push(file.name);
//            var reader = new FileReader();
//            reader.onload = function() {
//                $scope.$apply();
//            }
//            reader.readAsDataURL(file);
//        })
//    }

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
    //response is the string that contains the nature of the button
    /*$scope.submit = function(response){
        alert("Application filled successfully! " + response);
        //POST function to post the data into backend

    };*/
    
    
    //Save Center details
    $scope.saveCenter = function()
    {
    	console.log("Inside save center function");
    	
    	angular.foreach($scope.trainingPartner.TrainingPartnerCenterDetails, function(){
    		console.log($scope.trainingPartner.TrainingPartnerCenterDetails.name);
    	});
    	
    	
    	$scope.postValue = {
                'type' : 'Draft',
                'profileCreationTrainingPartnerOrganizationDetailsDto':  $scope.pctpOrgDetails,
                'profileCreationTrainingPartnerCenterDetailsDto' :  $scope.pctpCenterDetails,
                'profileCreationTrainingPartnerInstituteGrantDto' : $scope.pctpInstituteGrantDetail,
                'profileCreationTrainingPartnerInstituteRecognitionDto' :$scope.pctpRecognition,
                'profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto': $scope.pctpTrainingStaff,
                'profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto' : $scope.pctpTrainingExperience
            }
    }
    $scope.save = function(response) {
    	var saveUrl = '/saveAsDraftAndSubmitTP';
        var saveMethod = 'POST';
        
    	$scope.postValue = {
    			
            'type' : 'Draft',
            'profileCreationTrainingPartnerOrganizationDetailsDto':  $scope.pctpOrgDetails,
            'profileCreationTrainingPartnerCenterDetailsDto' :  $scope.pctpCenterDetails,
            'profileCreationTrainingPartnerInstituteGrantDto' : $scope.pctpInstituteGrantDetail,
            'profileCreationTrainingPartnerInstituteRecognitionDto' :$scope.pctpRecognition,
            'profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto': $scope.pctpTrainingStaff,
            'profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto' : $scope.pctpTrainingExperience
        }
        
        console.log("Preparing to post the values.............");
        $http({
                url: saveUrl,
                method: saveMethod,
                data: angular.toJson($scope.postValue)
        
            }).then(
                function successCallback(response) {
                    console.log("SUCCESS 123");
                    console.log("RESPONSE COMING FROM SERVER IS  : " + JSON.stringify(response));

                    console.log("RESPONSE COMING FROM SERVER IS  : " + JSON.stringify(response.data));
                    if (response.data == "") {
                        console.log("NULL DATA I.E. ERROR");
                    } else
                        console.log("ELSE");

                },
                function errorCallBack(response) {
                    console.log("Sorry the data could not be posted, an unknown error occurred..// " + response.status + " " + response.statusText);
                });
    };

    	//Submit button Method
    $scope.submit = function(response) {
        alert("Data saved successfully.. " + response);
       


        console.log("here in submit");


        var manageControllerURI = "/saveAsDraftAndSubmitTP";

        console.log($scope.trainingPartner);

       
        $scope.trainingPartner = {
        		'type' : "Save"
        }

        console.log($scope.trainingPartner);
        $http({
            url: manageControllerURI,
            method: "POST",
            data: $scope.trainingPartner
            /*data: angular.toJson(editdetailsOfApplication)*/
        }).then(
            function(response) {
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
            function(errorResponse, status) {

                /*$scope.message = response.data.errorMessage;
                $scope.messagealert= true;
                var failure=$scope.message;*/
                //            			console.log('THIS IS THE RESPONSE IN THE COMMENT:'+failure);
                console.log("Data could not be posted")

            }
        )
    };

});