console.log("code reacxhed to faq.js");
var faq = angular.module('faq', [ 'ui.grid', 'ui.grid.edit', 'ui.grid.cellNav','ui.grid.autoResize']);

faq.controller('faqController', faqController);

faqController.$inject = ['$scope', '$http'];

function faqController($scope, $http){

  

  $scope.schemeDropDownOptions = [{ id:'PMKVY',scheme:'PMKVY'},{id:'Non-PMKVY',scheme:'Non-PMKVY'}];
  
  $scope.candidatesOptions = [{ id:'Enrolled', name:'Enrolled'},{ id:'Assessed', name:'Assessed'},{ id:'Certified', name:'Certified'}];
  
  $scope.yearOptions = [{id:2015, value:2015},
                        {id:2016, value:2016},
                        {id:2017, value:2017},
                        {id:2018, value:2018},
                        {id:2019, value:2019}];
  
  $scope.stateDropDownOptions = [{	id:'Andhra Pradesh', state:'Andhra Pradesh'			},
                         		{	id:'Arunachal Pradesh',state:'Arunachal Pradesh'	},
                         		{	id:'Assam',state:'Assam'							},
                         		{	id:'Bihar',state:'Bihar'							},
                         		{	id:'Chandigarh',state:'Chandigarh'					},
                         		{   id:'Chhattisgarh',state:'Chhattisgarh'				},
                         		{	id:'Delhi',state:'Delhi'							},		
                         		{   id:'Goa',state:'Goa'								},
                         		{   id:'Gujarat',state:'Gujarat'						},
                         		{   id:'Haryana',state:'Haryana'						},
                         		{	id:'Himachal Pradesh',state:'Himachal Pradesh'		},
                         		{   id:'Jammu & Kashmir',state:'Jammu & Kashmir'		},
                         		{	id:'Jharkhand',state:'Jharkhand'					},
                         		{	id:'Karnataka',state:'Karnataka'					},
                         		{   id:'Kerala',state:'Kerala'							},
                         		{	id:'Madhya Pradesh',state:'Madhya Pradesh'			},
                         		{	id:'Maharastra',state:'Maharastra'					},
                         		{	id:'Manipur',state:'Manipur'						},
                         		{	id:'Meghalaya',state:'Meghalaya'					},
                         		{	id:'Mizoram',state:'Mizoram'						},
                         		{	id:'Nagaland',state:'Nagaland'						},
                         		{	id:'Orissa',state:'Odisha'							},
                         		{	id:'Punjab',state:'Punjab'							},
                         		{	id:'Rajasthan',state:'Rajasthan'					},
                         		{	id:'Sikkim',state:'Sikkim'							},
                         		{	id:'Tamil Nadu',state:'Tamil Nadu'					},
                         		{	id:'Telangana',state:'Telangana'					},
                         		{	id:'Tripura',state:'Tripura'						},
                         		{	id:'Uttarakhand',state:'Uttarakhand'				},
                         		{	id:'Uttar Pradesh',state:'Uttar Pradesh'			},
                         		{   id:'West Bengal',state:'West Bengal'				}
                         		];
  
  $scope.monthDropDownOptions = [{  id:01,  month:'JANUARY'     },
                                 {  id:02,  month:'FEBRUARY'    },
                                 {  id:03,  month:'MARCH'       },
                                 {  id:04,  month:'APRIL'       },
                                 {  id:05,  month:'MAY'         },
                                 {  id:06,  month:'JUNE'        },
                                 {  id:07,  month:'JULY'        },
                                 {  id:08,  month:'AUGUST'      },
                                 {  id:09,  month:'SEPTEMBER'   },
                                 {  id:10,  month:'OCTOBER'     },
                                 {  id:11,  month:'NOVEMBER'    },
                                 {  id:12,  month:'DECEMBER'    }];
  
  $scope.gridOptions = {
	  enableGridMenus : false,  
	  enableSorting: false, 
	  enableFiltering: false,
	  enableCellEdit : false,
	  enableColumnMenus : false,
    columnDefs: [
		{ name: 'totalNoOfCandidatesEnrolled' , displayName: 'Total No. Of Candidate Enrolled', width:250},
		{ name: 'totalNoOfCandidatesAssessed' , displayName: 'Total No. Of Candidate Assessed', width:250},
		{ name: 'totalNoOfCandidatesCertified', displayName: 'Total No. Of Candidate Certified', width:250}
    ]
  };

  $scope.gridOptionsSelectedScheme = {
		  enableGridMenus : false,  
		  enableSorting: false, 
		  enableFiltering: false,
		  enableCellEdit : false,
		  enableColumnMenus : false,
	    columnDefs: [
			{ name: 'totalNoOfCandidatesEnrolled' , displayName: 'Total No. Of Candidate Enrolled', width:250},
			{ name: 'totalNoOfCandidatesAssessed' , displayName: 'Total No. Of Candidate Assessed', width:250},
			{ name: 'totalNoOfCandidatesCertified', displayName: 'Total No. Of Candidate Certified', width:250}
	    ]
	  };
  
  $scope.gridOptionsSelectCandidates = {
		  enableGridMenus : false,  
		  enableSorting: false, 
		  enableFiltering: false,
		  enableCellEdit : false,
		  enableColumnMenus : false,
	    columnDefs: [
			{ name: 'month' ,				 displayName: 'Months',				  width:350},
			{ name: 'numberOfCandidates' ,   displayName: 'Number of Candidates', width:350}
	    ]
	  };
  
  $scope.gridOptionsSelectCandidatesSchemeWise = {
		  enableGridMenus : false,  
		  enableSorting: false, 
		  enableFiltering: false,
		  enableCellEdit : false,
		  enableColumnMenus : false,
	    columnDefs: [
			{ name: 'month' , 				displayName: 'Months',				 width:350},
			{ name: 'numberOfCandidates' ,  displayName: 'Number of Candidates', width:350}
	    ]
	  };
  
  $scope.getTotalBatchesAndTotalCandidatesInState = {
		  enableGridMenus : false,  
		  enableSorting: false, 
		  enableFiltering: false,
		  enableCellEdit : false,
		  enableColumnMenus : false,
	    columnDefs: [
			{ name: 'batches' ,			 displayName: 'Number of batches', 		width:350},
			{ name: 'totalCandidates' ,  displayName: 'Number of Candidates', 	width:350}
	    ]
	  };
  
  $scope.getTotalBatchesAndTotalCandidatesInAScheme = {
		  enableGridMenus : false,  
		  enableSorting: false, 
		  enableFiltering: false,
		  enableCellEdit : false,
		  enableColumnMenus : false,
	    columnDefs: [
			{ name: 'batches' ,				 displayName: 'Number of batches', 		 width:350},
			{ name: 'totalCandidates' , 	 displayName: 'Number of Candidates',	 width:350}
	    ]
	  };
  
  $scope.gridOptionsForSelectedStateShowingTotalBatchesAndCandidatesEnrolled = {
		  enableGridMenus : false,  
		  enableSorting: false, 
		  enableFiltering: false,
		  enableCellEdit : false,
		  enableColumnMenus : false,
	    columnDefs: [
			{ name: 'month' , displayName: 'Month', width:250},
			{ name: 'totalBatches' , 		displayName: 'Number of Batches', 			width:250},
            { name: 'candidatesEnrolled' ,  displayName: 'Total Candidates Enrolled', 	width:250}
	    ]
	  };
  
  $scope.gridOptionForNamesOfTrainingCentresNotConductingTraining = {
		  enableGridMenus : false,  
		  enableSorting: false, 
		  enableFiltering: false,
		  enableCellEdit : false,
		  enableColumnMenus : false,
	    columnDefs: [
			{ name: 'centreId' ,		 displayName: 'Centre Id', 	     width:400},
			{ name: 'centreName' , 		 displayName: 'Centre Name',	 width:400}
	    ]
	  };
    
  $scope.gridOptionsBatchStausOfAParticularBatchWithBatchId = {
		  enableGridMenus : false,  
		  enableSorting: false, 
		  enableFiltering: false,
		  enableCellEdit : false,
		  enableColumnMenus : false,
	    columnDefs: [
			{ name: 'batchId' ,				 displayName: 'Batch Id',				 width:130},
			{ name: 'trainingPartnerName' ,  displayName: 'Training Partner Name',   width:130},
			{ name: 'batchStartDate' , 		 displayName: 'Batch Start Date', 		 width:130},
			{ name: 'batchEndDate' , 	     displayName: 'Batch End Date', 		 width:130},
			{ name: 'assessmentDate' ,  	 displayName: 'Assessment Date',         width:130},
			{ name: 'resultApproved' , 		 displayName: 'Result Approved', 		 width:130}
					]
	  };
    
  $scope.gridOptionsBatchWiseCandidateDetails = {
		  enableGridMenus : false,  
		  enableSorting: false, 
		  enableFiltering: false,
		  enableCellEdit : false,
		  enableColumnMenus : false,
	    columnDefs: [
			{ name: 'candidateName' ,				 displayName: 'Candidate Name',			 width:130},
			{ name: 'mobileNumber' ,  				 displayName: 'Mobile Number',  		 width:130},
			{ name: 'traineeAddress' , 		 		 displayName: 'Trainee Address', 		 width:130},
			{ name: 'trainingPartnerName' , 	     displayName: 'Training Partner Name', 	 width:130},
			{ name: 'batchId' ,  					 displayName: 'Batch Id',         		 width:130},
			{ name: 'batchStartDate' , 				 displayName: 'Batch Start Date', 		 width:130},
			{ name: 'batchEndDate' , 				 displayName: 'Batch End Date', 		 width:130},
			{ name: 'eMailId' , 		 			 displayName: 'E-Mail Id', 		    	 width:130}
					]
	  };
  
    
 $scope.getDataAcrossAllScheme = function(){
	 
	 $http.get('/getFAQTotalCandidatesTrainedAssessedCertified')
	 	.then(function (response)	{
	 		console.log(response);
	 		$scope.gridOptions.data = response.data;
	 	});
 };
 
 $scope.getDataOfScheme = function(){
	 
	 var scheme = $scope.selectedScheme;
	 $http.post('/getFAQTotalCandidatesTrainedAssessedCertifiedSchemeWise?batchType='+scheme)
	 	.then(function (response)	{
	 		console.log(response);
	 		$scope.gridOptionsSelectedScheme.data = response.data;
	 	});
 };
 
 $scope.getDataOfCandidatesMonthWise = function(){
	 
	 var candidatesType = $scope.candidatesSelected;
	 console.log('CANDIDATES  :'+candidatesType);
	 var selectedYear = $scope.year;
	 var url = '/getFAQCandidatesEnrolledAssessedCertifiedMonthWise?year='+selectedYear+'&candidates='+candidatesType;
	 console.log(url);
	 $http.post(url)
	 	.then(function (response)	{
	 		console.log(response);
	 		$scope.gridOptionsSelectCandidates.data = response.data;
	 	});
 };
   
 	$scope.getDataOfCandidatesSchemeAndMonthWise = function(){
 		
 		var candidatesType = $scope.candidatesSelected;
 		 console.log('CANDIDATES  :'+candidatesType);
 		 var selectedYear = $scope.selectedYear;
 		 var selectedscheme = $scope.selectScheme;
 		 var url = '/getFAQCandidatesEnrolledAssessedCertifiedMonthAndSchemeWise?year='+selectedYear+'&candidates='+candidatesType+'&batchType='+selectedscheme;
 		 console.log('YE HAI URL'+url);
 		 $http.post(url)
 		 	.then(function (response)	{
 		 		console.log(response);
 		 		$scope.gridOptionsSelectCandidatesSchemeWise.data = response.data;
 		 	});
 	};
 	
 	$scope.getTotalBatchesAndAllCandidatesInAState = function(){
 		
 		var state = $scope.selectedState;
 		console.log('State is :'+state);
 		var url = '/getFAQCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularState?state='+state;
 		$http.post(url)
 			.then(function (response) 	{
 				console.log(response);
 				$scope.getTotalBatchesAndTotalCandidatesInState.data = response.data;
 			});
 	};
 	
 	 $scope.getTotalBatchesAndAllCandidatesInAScheme = function(){
         
         var selectedBatchScheme  = $scope.selectedBatchType;
         console.log('SELECTED SCHEME IS:'+selectedBatchScheme);
         var url = '/getFAQCountOfTotalNumberOfBatchesAndTotalEnrolledInAParticularScheme?batchType='+selectedBatchScheme ;
         $http.post(url)
             .then(function (response)   {
             console.log(response);
             $scope.getTotalBatchesAndTotalCandidatesInAScheme.data = response.data;
         });
     };
     
     $scope.getTotalCandidatesToBeAssessedForMonth = function(){
         
         var selectedMonth = $scope.selectMonth;
         console.log(selectedMonth);
         var url = '/getFAQCountOfCandidatesAssessmentUpcomingForAMonth?month='+selectedMonth;
         $http.post(url)
             .then(function (response)   {
             console.log(response.data);
             $scope.candidatesAssessmentForUpcomingMonth = response.data;
//             $scope.getTotalCandidatesToBeAssessedForUpcomingMonth = response.data;
         });
     };
     
     $scope.getTotalTrainingCentresInAState = function(){
         
         var state = $scope.selectedStateForTrainingCentres;
         console.log(state);
         var url = '/getFAQTotalTrainingCentresInAState?state='+state ;
         $http.post(url)
             .then(function (response)   {
             console.log(response.data);
             $scope.NumberOfTrainingCentres = response.data;
         });
     };
     
     $scope.getTotalBatchesAndCandidatesEnrolledMonthWiseForAYear = function(){
         
         var year = $scope.selectYearForAllBatchesAndCandidatesEnrolled;
         console.log(year);
         var url = '/getFAQTotalBatchesWithTotalCandidatesEnrolledYearWise?year='+year;
         $http.post(url)
             .then(function (response)   {
             console.log(response);
             $scope.gridOptionsForSelectedStateShowingTotalBatchesAndCandidatesEnrolled.data = response.data;
         });
     };
     
     $scope.getTotalTrainingCentresConductingTraining = function(){
         
    	 var url = '/getFAQCountOfTotalTrainingCentresConductingTraining';
         $http.get(url)
             .then(function (response)   {
                 console.log(response.data);
                 $scope.CountOfTrainingCentresConductingTraining = response.data;
             //            Return Output here
         });
     };
     
     $scope.getNamesOfTrainingCentresNotConductingTraining = function(){
         
         var url = '/getFAQTrainingCentresNotTakingAnyBatches';
         $http.get(url)
             .then(function (response)   {
             console.log(response.data);
             $scope.gridOptionForNamesOfTrainingCentresNotConductingTraining.data = response.data;
         });
     };
     
     $scope.getTotalTrainingCentresAllIndia = function(){
    	 
    	 var url = '/getDashboardTotalTrainingCentersInIndia';
    	 $http.get(url)
    	 	.then(function (response)	{
    	 		console.log(response.data);
    	 		$scope.totalTrainingCentresWeHave = response.data;
    	 	});
     };
     
     $scope.getAgencyNameForParticularBatchWithId = function(){
    	 
    	 var batchId = $scope.inputtedBatchId;
    	 var url = '/getFAQNameOfAgencyToWhichABatchIsAssigned?batchId='+batchId;
    	 var agencyName;
    	 $http({
    		 method: 'POST',
    		 url: url,
    		 transformResponse: [function (data)  {
    			 console.log(data);
    			 agencyName=data;
    			 return data;
    		 }]
    	 }).then(function(response) {
    		 
    		 if(agencyName)
    		 {
    			 $scope.AgencyNameForParticularBatchWithId = 'Agency Name='+agencyName;
    		 }
    		 else
    			 {
    			 	$scope.AgencyNameForParticularBatchWithId = 'BatchId Not Found';
    			 }
    		 
			
		});
    	 };
    	 
    	 $scope.getStatusOfABatchWithBatchId = function() {
    		 
    		 var batchId = $scope.inputBatchIdForBatchStatus;
    		 var url = '/getFAQStatusOfAParticularBatchWithId?batchId='+batchId;
    		 $http.post(url)
    		 	.then(function (response)	{
    		 		console.log(response.data);
    		 		$scope.gridOptionsBatchStausOfAParticularBatchWithBatchId.data = response.data;
    		 	});
    	 };
    	 
    	 $scope.getNumberofBatchesAssignedToAParticularAssessmentAgency = function(){
    		 
    		 var agencyName = $scope.getNameOfAssessmentAgency;
    		 var batchesCountForAgencyName;
    		 var url = '/getFAQTotalCountOfBatchesAssignedToAAssessmentAgency?agencyName='+agencyName;
    		 $http.post(url)
    		 	.then(function	(response) {
        		  if(response.data==0)
        		  	{
        			  $scope.batchesAssignedToAssessmentAgency = 'No Records Found';
        		  	}
        		 else
        			 {
        			 	$scope.batchesAssignedToAssessmentAgency = 'Total Batches : '+response.data;
        			 }
        		});
    	 };
    	 
    	 $scope.getNumberOfAssessorForAParticularAgencyInAParticularState = function() {
    		 
    		 var agencyName = $scope.assessmentAgencyForAParticularState;
    			 var state  = $scope.selectedStateForAParticularAgencyForAParticularState;
    			 var url    = '/getFAQCountTotalAssessorsOfAParticularAgencyInAParticularState?agencyName='+agencyName+'&state='+state;
    			 $http.post(url)
    			 	.then(function (response)	{
    			 		$scope.assessorNumberForSelectedStateAndSelectedAgency = 'Total Assessors Of Agency '+agencyName+' : '+response.data; 
    			 	});
			
		};
    	 	
    	 $scope.getCountOfBatchesForWhichResultIsPending = function()	{
    		 
    		 var url = '/getFAQCountBatchesForWhichResultIsPending';
    		 $http.get(url)
    		 	.then(function (response)	{
    		 		console.log(response.data);
    		 		$scope.countOfBatchesForWhichResultUploadIsPending = 'Result Pending : '+response.data;
    		 	});
    	 };
    	 
    	 $scope.getCountOfNonAssignedBatches = function()	{
    		 
    		 var url = '/getFAQCountTotalNonAssignedBatches';
    		 $http.get(url)
    		 	.then(function (response)	{
    		 		console.log(response.data);
    		 		$scope.countOfTotalNonAssignedbatches = 'Non-Assigned Batches :'+response.data;
    		 	});
    	 };
    	 
    	 $scope.getbatchWiseCandidateDetailsForAParticularBatchWithBatchId = function()	{
    		 
    		 var batchId = $scope.inputBatchIdForBatchWiseCandidateDetails;
    		 var url = '/getFAQBatchWiseCandidatesDetails?batchId='+batchId;
    		 $http.post(url)
    		 	.then(function (response)	{
    		 		console.log(response.data);
    		 		$scope.gridOptionsBatchWiseCandidateDetails.data = response.data;
    		 	});
    
    	};
}



//function ends here //pooja
    	function isNumberKey(evt){
    	    var charCode = (evt.which) ? evt.which : event.keyCode
    	    if (charCode > 31 && (charCode < 48 || charCode > 57))
    	        return false;
    	    return true;
    	}

    	function toggleIcon(e) {
    	    $(e.target)
    	        .prev('.panel-heading')
    	        .find(".more-less")
    	        .toggleClass('glyphicon-plus glyphicon-minus');
    	}
    	
    	
    	
    	$('.panel-group').on('hidden.bs.collapse', toggleIcon);
    	$('.panel-group').on('shown.bs.collapse', toggleIcon);



