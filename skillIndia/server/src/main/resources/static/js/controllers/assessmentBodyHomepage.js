var abApp = angular
                   .module('abApp', [ 
                            'ui.grid', 
                            'ui.grid.cellNav',
                            'ui.grid.autoResize'
                            ]);

  abApp.controller('abhomepageController', abhomepageController);
  abhomepageController.$inject=['$scope','$http', '$location'];

function abhomepageController($scope, $http,$location){
     
	$scope.gridOptions = {
		 enableColumnMenus: false,
		  enableSorting: false,
		  verticalScrollbar:0,
		  enablehorizontalScrollbar: true,
		  
  columnDefs : [
{ name: 'applicationID' ,	displayName:'Application ID',	cellClass:'commoncell',	headerCellClass:'Application-ID',
},
{ name: 'dateOfSubmission',	displayName:'Date of Submission',	cellClass:'commoncell',	headerCellClass:'Date-of-Submission',
},
{ name: 'assessmentAgencyName' ,	displayName:'Submitted By',	cellClass:'commoncell',	headerCellClass:'Submitted-By',
},
{ name: 'applicationState' ,	displayName:'Status',	cellClass:'statuscell',	headerCellClass:'Status',
},
{ name:'Action',	cellClass: 'Prostokt-2-kopia-2-copy-14',	width:76,	headerCellClass: 'Action-copy',	cellTemplate:'<img src="icon/indexpageIcons/edit1.png" ng-show="1" ng-click="grid.appScope.myfunction(row)">',
},
{ name: 'comment' ,	displayName:'Comment',	cellClass:'comment',	headerCellClass:'Comment',cellTemplate:'<center ng-click=grid.appScope.comment(row)>Click to View',
}
	]
  };
	
	$scope.comment = function(rowData)
	{ var commentCheck=Object.values(Object.values(rowData)[1])[4];
	window.alert(commentCheck);
}
	
$scope.myfunction = function(rowData) 
  {   var appState=Object.values(Object.values(rowData)[1])[3];
  if(appState=="Incomplete"){
	  window.location="https://www.google.co.in";
	  console.log("Please Edit the Form");
	  
  }
  else{
	  window.alert("Invalid Access");
  }
	console.log("Click is working"+appState);
}
$http.get('/assessmentBodyApplicationStatus')
//$http.get('poc/AbStatus.json')
   .then(function (response) {
      $scope.gridOptions.data = response.data;
    })
	
	$scope.gridOptions1 = {
					  enableColumnMenus: false,
		  enableSorting: false,
		  verticalScrollbar:0,
		  
		  columnDefs : [
{ name:'batchId',displayName:'Batch ID',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'trainingPartnerDetails',displayName:'TP Name|Email|Contact No',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'assessmentDate',displayName:'Assessment Date',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'location',displayName:'District|State',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'totalCandidatesInBatch',displayName:'Candidates',displayName:'No. of Candidates',cellClass:'cell',headerCellClass:'CommonCell'},
		        	  ]
  };
	$http.get('/getPastBatchesAssessmentBodyHomepage')
		.then(function (response) {
      $scope.gridOptions.data = response.data;
    })


	  $scope.gridOptions2 = {
		   enableColumnMenus: false,
           enableSorting: false,

	 columnDefs : [
{ name:'batchId',displayName:'Batch ID',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'trainingPartnerDetails',displayName:'TP Name|Email|Contact No',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'assessmentDate',displayName:'Assessment Date',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'location',displayName:'District|State',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'totalCandidatesInBatch',displayName:'Candidates',displayName:'No. of Candidates',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'Show Interest',cellClass:'check',headerCellClass:'CommonCell',cellTemplate: '<div><label><input type="checkbox" value="">&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp<button class="btn btn-default" data-toggle="confirmation" onclick="confirmfunction2()" ng-click="grid.appScope.confirmfunction()">&#10004</button></label></div>'}
]
	};
	  
	   $http.get('/getUpcomingBatchesAssessmentBodyHomepage')
	  .then(function (response) {
      $scope.gridOptions.data = response.data;
    })
	    
	    $scope.confirmfunction = function(){
	    console.log("Function Reached");
	    $http.get('/ShowInterestupcomingtable').success(function(data){
	     console.log("data populated");
	    })
	    }
	   
	function confirmfunction2()
	{
	  console.log("button Code reached");
	  console.log("Cnf Function reached");
	  
	 if (confirm("Do you want to confirm interest?")==true)
	     txt = "Your Interest is Confirmed!";
	 else
	  txt = "Your Interest is Cancel!";   
	     document.getElementById("demo").innerHTML = txt;
	}
		
		$scope.gridOptions3 = {
				  enableGridMenus : false,  
				  enableSorting: false, 
				  enableFiltering: false,
				  enableCellEdit : false,
				  enableColumnMenus : false,
		  
	    columnDefs : [
{ name:'batchId',displayName:'Batch ID',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'trainingPartnerDetails',displayName:'TP Name|Email|Contact No',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'assessmentDate',displayName:'Assessment Date',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'location',displayName:'District|State',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'totalCandidatesInBatch',displayName:'Candidates',displayName:'No. of Candidates',cellClass:'cell',headerCellClass:'CommonCell'},
{ name: 'Action',cellClass:'check',headerCellClass:'CommonCell',cellTemplate: '<label><img src="icon/indexPageIcons/tick.png" ng-click=grid.appScope.myfunction1()>  &nbsp; &nbsp; &nbsp; &nbsp; <img src="icon/indexPageIcons/close.png" ng-click=grid.appScope.myfunction2()></label>' }
	    ]};

	    $scope.myfunction1 = function(){
	        alert("Your comment has been logged..!");
	        location.href = 'http://www.google.com';
	    }

	    $scope.myfunction2 = function(){
	        alert("Your comment has been discarded..!");
	        location.href = 'http://www.facebook.com';
	    }
	  
		$http.get('/getAssignedBatchesAssessmentBodyHomepage')
	    		.then(function (response) {
      $scope.gridOptions.data = response.data;
	    })
	 
	    $scope.gridOptions4 = {
					  enableColumnMenus: false,
		  enableSorting: false,
		  verticalScrollbar:0,


columnDefs : [
{ name:'batchId',displayName:'Batch ID',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'trainingPartnerDetails',displayName:'TP Name|Email|Contact No',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'assessmentDate',displayName:'Assessment Date',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'location',displayName:'District|State',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'totalCandidatesInBatch',displayName:'Candidates',displayName:'No. of Candidates',cellClass:'cell',headerCellClass:'CommonCell'},
]
};
	$http.get('/getConfirmedBatchesAssessmentBodyHomepage')
	.then(function (response) {
      $scope.gridOptions.data = response.data;
    })
};