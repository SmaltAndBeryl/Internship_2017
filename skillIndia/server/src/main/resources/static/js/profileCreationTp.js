var profileCreationTp = angular.module('hello');

profileCreationTp.controller('profileCreationTp', function($scope, $http, fileUpload) {

    //    $http.get('/url')
    //        .then(function(response){
    //
    //        });

    //     $scope.trainingPartner;

    // Store response.data into trainingPartner

    //    $scope.TrainingPartnerOrganizationDetails;

    $http.get('/getDataNewUserProfileCreation')
        .then(function(response) {
            console.log("values fetched successfully from the back end " + JSON.stringify(response.data));
            //            $scope.trainingPartner = response.data;

            $scope.trainingPartner = response.data;
            console.log("this is $scope.trainingPartner  " +  JSON.stringify($scope.trainingPartner));
            $scope.TrainingPartnerOrganizationDetails = $scope.trainingPartner.TrainingPartnerOrganizationDetails;

//            $scope.spocName = $scope.TrainingPartnerOrganizationDetails.sPOCName;
//            console.log("THE SPOC name is " + JSON.stringify($scope.spocName));
//            console.log("The training partner is to be filled " + JSON.stringify($scope.trainingPartner));
//            console.log("The training partner organization details are " + JSON.stringify($scope.trainingPartner.TrainingPartnerOrganizationDetails));
//            console.log("The training partner organization details are " + JSON.stringify($scope.TrainingPartnerOrganizationDetails));

        });
    $scope.states = ["UP", "Uttarakhand", "MP", "Bihar"];
    $scope.type = ["regular", "visiting"];

    $scope.addNew = function(experience) {
        console.log("data added successfully");
        $scope.trainingPartner.PriorExperienceDetails.push({
            'courseName': "",
            'numberOfBatchesPerYear': "",
            'numberOfStudentsInEachBatch': ""
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
    $scope.uploadTan = function()
    {
    	var file = $scope.trainingPartner.tan;
    	console.log("File is "+ file);
    	var uploadTAN = "/fileUploadTPTAN";
    	fileUpload.uploadFileToUrl(file, uploadTAN, "tan");
    }

    
    //Preview attachments
    $scope.previewAttachments = function(event) {
        var files = event.target.files;
        $scope.attachments = [];
        angular.forEach(files, function(file) {
            $scope.attachments.push(file.name);
            var reader = new FileReader();
            reader.onload = function() {
                $scope.$apply();
            }
            reader.readAsDataURL(file);
        })
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
    //response is the string that contains the nature of the button
    /*$scope.submit = function(response){
        alert("Application filled successfully! " + response);
        //POST function to post the data into backend

    };*/

    $scope.save = function(response) {
    	
    	$scope.dataPAN = new FormData();
        var recordPan="PanNumber";
        console.log("PanNumber :"+$scope.file);
        
        $scope.dataPAN.append("PanNumber",$scope.file);
            console.log($scope.file);

        $scope.pctpOrgDetails = {
        		'trainingPartnerRegistrationId' :'1',
    			'applicationId' : '2',
    			'organizationName' : 'Smalt and Beryl',
    			'sPOCName' : 'Ruchi Pareek',
    			'address' : 'NH 24, near Vijay Nagar',
    			'city':'Ghazibad',
    			'state':'UP',
    			'pincode':'201301',
    			'mobileNumber':'87789979',
    			'alternateMobileNumber':'98000909',
    			'landlineNumber':'014123234',
    			'alternateLandlineNumber':'014189890',
    			'faxNumber':'014189890',
    			'websites':'www.smaltandberyl.com',
    			'yearOfEstablishment':'2012',
    			'qualificationPacks':'abc',
    			'qualificationPacksAnnexurePath':null,
    			'nSDCFunded':'no',
    			'nSDCFundedCertificatePath':null,
    			'mediumOfInstructions':null,
    			'selfOwnedInstitution':null,
    			'selfOwnedInstitutionAnnexurePath':null,
    			'franchiseOwnedInstitution':null,
    			'franchiseOwnedInstitutionAnnexurePath':null,
    			'mobileTrainingInstitution':'3',
    			'mobileTrainingInstitutionAnnexurePath':null,
    			'panNumber':'CIXPP90909',
    			'panNumberPath':null,
    			'tanNumber':'NI898989',
    			'tanNumberPath':null,
    			'turnOverOfInstitution':'56',
    			'turnOverOfInstitutionBalanceSheetPath':null,
    			'instituteReceivedAnyGrant':'no',
    			'instituteReceivedAnyRecognition':'no',
    			'priorExperienceOfInstitutionInSkillDevelopment':'12',
    			'trainingStaffDetailsAnnexurePath':null
        }
        $scope.pctpCenterDetails =[
                                   {
                                	   'trainingPartnerCenterId' :1,
                                	   'trainingPartnerRegistrationId' : 1,
                                	   'nameOfCenter' : 'Smalt and beryl Business Solution center',
                                	   'numberOfPermanentOfficeManager' : 1,
                                	   'numberOftemporaryOfficeManager': null,
                                	   'numberOfPermanentOfficeStaff' : null,
                                	   'numberOfTemporaryOfficeStaff': 3,
                                	   'numberOfPermanentLabAssistants' : 4,
                                	   'numberOfTemporaryLabAssistants' : 56,
                                	   'numberOfPermanentAccountants' :4,
                                	   'numberOfTemporaryAccountants' :5,
                                	   'numberOfPermanentSupportStaff' : 6,
                                	   'numberOfTemporarySupportStaff' : 0,
                                	   'numberOfPermanentOtherEmployees' : 8,
                                	   'numberOfTemporaryOtherEmployees' :0,
                                	   'areaOfInstitute':345,
                                	   'buildingType' :self,
                                	   'sizeOfClassrooms':45,
                                	   'classroomPicsPath':null,
                                	   'numberOfClassrooms': null,
                                	   'sizeOfLabs': null,
                                	   'labPicsPath': null,
                                	   'numberOfLabs': 12,
                                	   'sizeOfWorkshops':null,
                                	   'workshopPicsPath':null,
                                	   'numberOfWorkshops' :null,
                                	   'mandatoryToolKitpresent':null,
                                	   'mandatoryToolKitAnnexurePath':null,
                                	   'mandatoryToolKitPicsPath':null,
                                	   'safeDrinkingWater':null,
                                	   'powerBackup':1,
                                	   'separateToilets': 1,
                                	   'transportFacility':1,
                                	   'presenceOfLibrary':1,
                                	   'numberOfTechnicalBooks':120,
                                	   'numberOfNonTechnicalBooks':5,
                                	   'numberOfMagazines': 5,
                                	   'numberOfDailies':3,
                                	   'remarksOnInfrastructureDetails':6,
                                	   'sufficientClassroomIlluminationLevel':1,
                                	   'sufficientClassroomVentilationLevel': 1,
                                	   'sufficientCenterCleanliness':1,
                                	   'centerWeatherProtected':1,
                                	   'remarksOnLearningEnviornment':1,
                                	   'printedBrochureOrProspectus':1,
                                	   'documentedPolicyAndProcedures':1,
                                	   'concessionPolicy':1,
                                	   'safeCustodyOfStudentDocuments':1,
                                	   'studentAgreementWithInstitution':1,
                                	   'remarksOnStudentAdmissionDetails':1,
                                	   'isActive':1
                                   }
                                 ]
        
        $scope.pctpInstituteGrantDetail = [
        {
        	'instituteGrantId': '1',
        	'trainingPartnerRegistrationId':'1',
        	'nameOfMinistry' : 'M.H.Rr.D',
        	'natureOfWork': 'Aenwaii 2',
        	'remarks': 'no remakrs 2',
        	'isActive': true
        }]
        $scope.pctpRecognition = [{
        	'trainingPartnerRegistrationId':1,
        	'instituteRecognitionId' :1,
        	'nameOfRecognizingBody': 'SSCGJJ',
        	'recognitionNumber': '1213212',
        	'yearOfRecognition':'2323',
        	'validityOfRecognition':'33',
        	'isActive': false
        
        }]
        $scope.pctpTrainingStaff = [{
        	'managementAndStaffId' : '1',
        	'trainingPartnerRegistrationId': 1,
        	'trainingPartnerCenterId':1,
        	'type':'no type',
        	'name':'Ruchi Pareek',
        	'designation':'CLO',
        	'emailId':'ruchi@smaltandberyl.com',
        	'contactNumber':989898989,
        	'educationalQualification': 'B Tech.',
        	'regularOrVisiting': 'regular',
        	'experience':'10',
        	'isActive':1
        	
        }]
        $scope.pctpTrainingExperience =[{
        	'priorExperienceInSkillTrainingId' : '1',
        	'trainingPartnerRegistrationId' : '1',
        	'courseName' : 'Course Name 1',
        	'numberOfBatchesPerYear' : '123',
        	'numberOfStudentsInEachBatch' : '43',
        	'isActive' : 1
        }]
        
        $scope.postValue = {
            'type' : 'Draft',
            'profileCreationTrainingPartnerOrganizationDetailsDto':  $scope.pctpOrgDetails,
            'profileCreationTrainingPartnerCenterDetailsDto' :  $scope.pctpCenterDetails,
            'profileCreationTrainingPartnerInstituteGrantDto' : $scope.pctpInstituteGrantDetail,
            'profileCreationTrainingPartnerInstituteRecognitionDto' :$scope.pctpRecognition,
            'profileCreationTrainingPartnerManagementAndStaffAndOfficialsDetailsDto': $scope.pctpTrainingStaff,
            'profileCreationTrainingPartnerPriorExperienceInSkillTrainingDto' : $scope.pctpTrainingExperience
        }
        var saveUrl = '/saveAsDraftAndSubmitTP';
        var saveMethod = 'POST';
        
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