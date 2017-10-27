var profileCreationAb = angular.module('hello');

profileCreationAb.controller('profileCreationAb' , function($scope, $http, $location){

	
	$scope.files=[];
    var idName= [];
     var status=0;
     var i = 0;
     // GET THE FILE INFORMATION.
     
     $scope.getFileDetails = function (e) {
       
     
         $scope.$apply(function () {
              console.log(i);
             
				var j=-1;
             for(j;j<idName.length;j++)
                 {
                     console.log(e.id+"      "+idName[j]);
                     if(e.id == idName[j])
                         {
                             console.log("In If ");
                             status=1;   
                             break;
                         }
                     else
                         {
                             status=0;
                             console.log("In else");
                             //break;
                         }
                 }
             
             if(status==1)
                 {
                     console.log("Value of J for if is : " + j);
                     $scope.files.splice(j,1,e.files[0]); 
                 }
             else if(status==0)
                 {
                     console.log("Value of J for else is : " + j);
                     idName.push(e.id); 
                     console.log("Hey Id is  : "+ e.id);
                     $scope.files.push(e.files[0]);
                     i++;  
                 }
              
                     
             // STORE THE FILE OBJECT IN AN ARRAY.
            
                         
         });
     };
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
            'domain' : "",
            'numberOfAssessmentsDone' : ""
        });
    }
    $scope.addNewRecognition = function(recognition){
        console.log("data added successfully");
        $scope.assessmentBody.AssessmentBodyRecognitions.push({
            'name' : "",
            'number' : "",
            'year' : "",
            'validity' : ""
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
             'name' : "",
             'designation':"",
             'contactNumber': '',
             'emailId': '',
             'educationalQualification': '',
             'experience': ''
        });
    }


    $scope.addNewOffice = function(office){
        console.log("Data added successfully");
        $scope.assessmentBody.AssessmentBodyRegionalOfficeDetails.push({
             'address' : "",
             'state':"",
             'contactNumber': '',
             'pincode': '',
             'contactNumber': '',
             'alternateContactNumber': ''
        });
    }

    $scope.addNewAssessor = function(assessor){
        console.log("Data added successfully");
        $scope.assessmentBody.AssessmentStaffDetails.push({
             'name' : "",
             'jobRoleCode':"",
             'designation': '',
             'contactNumber': '',
             'emailId': '',
             'state': '',
             'city':'',
             'educationalQualification' : '',
             'experience' : ''
        });
    }

    //Remove functionality
    $scope.removeExperience = function(){
        var newDataList=[];
        $scope.selectedAllExperience = false;
        angular.forEach($scope.assessmentBody.AssessmentsExperienceInTechnicalDomain, function(selected){
            if(!selected.selected){
                newDataList.push(selected);
            }
        });
        $scope.assessmentBody.AssessmentsExperienceInTechnicalDomain = newDataList;
    };

    $scope.removeRecognition = function(){
        var newDataList=[];
        $scope.selectedAllRecognition = false;
        angular.forEach($scope.assessmentBody.AssessmentBodyRecognitions, function(selected){
            if(!selected.selected){
                newDataList.push(selected);
            }
        });
        $scope.assessmentBody.AssessmentBodyRecognitions = newDataList;
    };

    $scope.removeAffiliation = function(){
        var newDataList=[];
//        $scope.selectedAllRecognition = false;
        angular.forEach($scope.assessmentBody.AssessmentBodyAffiliationDetails, function(selected){
            if(!selected.selected){
                newDataList.push(selected);
            }
        });
        $scope.assessmentBody.AssessmentBodyAffiliationDetails = newDataList;
    };


    $scope.removeDirectors = function(){
        var newDataList=[];
//        $scope.selectedAllRecognition = false;
        angular.forEach($scope.assessmentBody.AssessmentBodyDirectorsAndManagementTeamDetails, function(selected){
            if(!selected.selected){
                newDataList.push(selected);
            }
        });
        $scope.assessmentBody.AssessmentBodyDirectorsAndManagementTeamDetails = newDataList;
    };

    $scope.removeOffice = function(){
        var newDataList=[];
        $scope.selectedAllExperience = false;
        angular.forEach($scope.assessmentBody.AssessmentBodyRegionalOfficeDetails, function(selected){
            if(!selected.selected){
                newDataList.push(selected);
            }
        });
        $scope.assessmentBody.AssessmentBodyRegionalOfficeDetails = newDataList;
    };

    $scope.removeAssessor = function(){
        var newDataList=[];
        angular.forEach($scope.assessmentBody.AssessmentStaffDetails, function(selected){
            if(!selected.selected){
                newDataList.push(selected);
            }
        });
        $scope.assessmentBody.AssessmentStaffDetails = newDataList;
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
    $scope.save = function(response){
        alert("Data saved successfully.. " + response);

        console.log("here in save as draft");


        var saveDraftAndSubmit = "/saveAsDraftAndSubmit";
        
        //console.log($scope.trainingPartner);
        
//        $scope.profileCreationABTPDto = {
//        		"type" : "Draft",
//        		"userData" : null,
//        		"userUploads" : null,
//        		"userDeletes" : null
//        }
        $scope.userData = {
        		'AssessmentBodyRegistrationDetails' :{
        			'record' : {'assessmentBodyRegistrationId': '1'},
        			'record' : {'applicationId': '4'},
        			'record' : {'organizationName': 'ABESIT'},
        			'record' : {'sPOCName': 'Ashu Goel'},
        			'record' : {'address': 'NH 24 Vijay Nagar'},
        			'record' : {'city': 'Ghaziabad'},
        			'record' : {'state': 'UP'},
        			'record' : {'pincode': '121212'},
        			'record' : {'mobileNumber': '9898989876'},
        			'record' : {'alternateMobileNumber': '9898877978'},
        			'record' : {'landlineNumber': '0141333023'},
        			'record' : {'alternateLandlineNumber': '0141333024'},
        			'record' : {'faxNumber': '0141333024'},
        			'record' : {'websites': 'www.abesit.in'},
        			'record' : {'yearOfEstablishment': '2010'},
        			'record' : {'priorAssessmentExperience': '5'},
        			'record' : {'panNumber': 'CIPX9090'},
        			'record' : {'panNumberPath': 'C:\Users\Ruchi Pareek\Documents\ABESIT\PANNumber'},
        			'record' : {'tanNumber': '67676767'},
        			'record' : {'tanNumberPath': 'C:\Users\Ruchi Pareek\Documents\ABESIT\TANNumber'},
        			'record' : {'numberOfTechnicalAssessors': '10'},
        			'record' : {'numberOfNonTechnicalAssessors': '76'},
        			'record' : {'affiliatedToAnySectorSkillCouncil': 'no'}
        		},
        		'AssessmentBodyRecognitions' : null,
        		'AssessmentsExperienceInTechnicalDomain' :null,
        		'AssessmentBodyDirectorsAndManagementTeamDetails' : null,
        		'AssessmentStaffDetails' :null,
        		'AssessmentBodyRegionalOfficeDetails' :null,
        		'AssessmentBodyAffiliationDetails' :null
        		
        };
        $scope.userDeletes= {
        	'AssessmentBodyRecognitions' :{
        		'record' :{'assessmentBodyRecognitionId' : '1'},
        		'record' :{'assessmentBodyRegistrationId' : '1'},
        		'record' :{'nameOfRecognitionBody' : 'NSDC'},
        		'record' :{'recognitionNumber' : '10101565'},
        		'record' :{'yearOfRecognition' : '2011'},
        		'record' :{'validityOfRecognition' : '12'}
        		
        	} ,
        	'AssessmentsExperienceInTechnicalDomain' :null,
        	'AssessmentBodyDirectorsAndManagementTeamDetails' :null,
        	'AssessmentStaffDetails' :null ,
        	'AssessmentBodyRegionalOfficeDetails' :null,
        	'AssessmentBodyAffiliationDetails':null
        }
        
        
        
        $scope.dataPAN = new FormData();
        var recordPan="PanNumber";
        console.log("PanNumber :"+$scope.files);
        
        $scope.dataPAN.append("PanNumber",$scope.files[0]);
            console.log($scope.files[0]);
        
        
        $scope.dataTAN = new FormData();
        var recordTAN="TanNumber";
        console.log("TanNumber :"+$scope.files);
        $scope.dataTAN.append("TanNumber",$scope.files[1]);
            console.log($scope.files[1]);
        
        
        $scope.userUploads = {
        	'AssessmentBodyRegistrationDetails' :{
        		'Record1': {'PanNumber' : $scope.dataPAN},
        		'Record2': {'TanNumber': $scope.dataTAN}
        	} ,
        	'AssessmentBodyDirectorsAndManagementTeamDetails' :{
        		'record1':{'CV':$scope.something} /*There will be more than one CV files uploaded for directors and management details*/
        	},
        	'AssessmentStaffDetails' : {
        		'record1' : {'CV':$scope.something} /*There will be more than one CV files uploaded for staff details*/
        	}      	
        }
        
//        $scope.profileCreationABTPDto = {
//        		'type' : 'Draft',
//        		'userData' :$scope.userData,
//        		'userDeletes' :$scope.userDeletes,
//        		//'userUploads' :$scope.userUploads
//        }
        
        $scope.profileCreationAssessmentBodyRegistrationDetailsDto = {
			'assessmentBodyRegistrationId': '1',
			'applicationId': '4',
			'organizationName': 'ABESIT',
			'sPOCName': 'Ashu Goel',
			'address': 'NH 24 Vijay Nagar',
			'city': 'Ghaziabad',
			'state': 'UP',
			'pincode': '121212',
			'mobileNumber': '9898989876',
			'alternateMobileNumber': '9898877978',
			'landlineNumber': '0141333023',
			'alternateLandlineNumber': '0141333024',
			'faxNumber': '0141333024',
			'websites': 'www.abesit.in',
			'yearOfEstablishment': '2010',
			'priorAssessmentExperience': '5',
			'panNumber': 'CIPX9090',
			'tanNumber': '67676767',
			'numberOfTechnicalAssessors': '10',
			'numberOfNonTechnicalAssessors': '76',
			'affiliatedToAnySectorSkillCouncil': 'no'
		}
        $scope.pcabAffiliation = [{
        		'assessmentBodyRegistrationId': '1',
        		'affiliationId' :'1',
        		'nameOfSectorSkillCouncil' : 'SSCD',
        		'isActive' : 1
        },
        {
        	'assessmentBodyRegistrationId': '1',
        	'affiliationId' :'2',
    		'nameOfSectorSkillCouncil' : 'ruchi',
    		'isActive' : 1
        },
        {
        	'assessmentBodyRegistrationId': '1',
        	'affiliationId' :'3',
    		'nameOfSectorSkillCouncil' : 'tuvhi',
    		'isActive' : 0
        }
        ]
        $scope.pcabManagement = [{
        	'directorsAndManagementId' : "2",
        	'assessmentBodyRegistrationId' : '1',
        	'name' : 'Ruchi Pareek',
            'designation':"Co-founder",
            'contactNumber': '98989898989',
            'emailId': 'ruchi@smaltandberyl.com',
            'educationalQualification': 'BTech.',
            'experience': '4',
            'isActive' :1
        },
        {
        	'directorsAndManagementId' : "3",
        	'assessmentBodyRegistrationId' : '1',
        	'name' : 'Falaana',
            'designation':"Co-founder",
            'contactNumber': '98989898989',
            'emailId': 'falaana@smaltandberyl.com',
            'educationalQualification': 'BTech.',
            'experience': '4',
            'isActive' :1
        }]
        $scope.pcabrecognition = [{
        	'assessmentBodyRecognitionId' : '1',
        	'assessmentBodyRegistrationId' :'1',
        	'nameOfRecognitionBody' : 'NSDC',
        	'recognitionNumber' : 'h7y8',
        	'yearOfRecognition' : '2012',
        	'validityOfRecognition' : 'forever'
        }]
        $scope.profileCreationABTPDto = {
        		'type' : 'Draft',
        		'profileCreationAssessmentBodyRegistrationDetailsDto' : $scope.assessmentBody.profileCreationAssessmentBodyRegistrationDetailsDto,
        		'profileCreationAssessmentBodyAffiliationDetailsDto' : $scope.pcabAffiliation,
        		'profileCreationAssessmentBodyDirectorsAndManagementTeamDetailsDto' : $scope.pcabManagement,
        		'profileCreationAssessmentBodyRecognitionsDto' : $scope.pcabrecognition
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