var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.autoResize']);
app.controller('MainCtrl', ['$scope', '$http', '$location', function ($scope, $http, $location) {
	$scope.gridOptions = {
					  enableColumnMenus: false,
		  enableSorting: false,
		  verticalScrollbar:0,
		  
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
{ name: 'comment' ,	displayName:'Comment',	cellClass:'comment',	headerCellClass:'Comment',cellTemplate:'<center ng-click=grid.appScope.myfunction1(row)>Click to View',
}
	]
  };
	
	$scope.myfunction1 = function(rowData)
	{var commentCheck=Object.values(Object.values(rowData)[1])[4];
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
};
$http.get('/assessmentBodyApplicationStatus')
//$http.get('poc/AbStatus.json')
    .success(function (data) {
      $scope.gridOptions.data = data;
    });
	
}]);

app.controller('PastCtrl', ['$scope', '$http', '$location', function ($scope, $http, $location) {
	$scope.gridOptions = {
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
	$http.get('getPastBatchesAssessmentBodyHomepage')
		.success(function(data) {
			$scope.gridOptions.data =data;
		});
}]);


app.controller('UpcommingCtrl', ['$scope', '$http', '$log', function ($scope, $http, $log) {
	  $scope.gridOptions = {enableColumnMenus: false,enableSorting: false};

	  $scope.gridOptions.columnDefs = [
{ name:'batchId',displayName:'Batch ID',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'trainingPartnerDetails',displayName:'TP Name|Email|Contact No',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'assessmentDate',displayName:'Assessment Date',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'location',displayName:'District|State',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'totalCandidatesInBatch',displayName:'Candidates',displayName:'No. of Candidates',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'Show Interest',cellClass:'check',headerCellClass:'CommonCell',cellTemplate: '<div><input type="checkbox" id="myCheck" value="abc" ng-click=grid.appScope.check(row)>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp<img src="icon/indexPageIcons/tick.png" ng-click=grid.appScope.confirmfinal(row)></div>'}
];
	  
	   $http.get('getUpcomingBatchesAssessmentBodyHomepage')
	    .success(function(data) {
	     $scope.gridOptions.data = data;
	   })
	    var bool;
	   $scope.check = function(rowData){
		    console.log("Check Reached");
		    bool = document.getElementById("myCheck").checked 
		    if(bool == true)
		    	{
		    	console.log("getit");
		    	}
		    
		    }
	   
	    $scope.confirmfinal = function(rowData){
	    //console.log("Function Reached");
	    if(bool==true)
	    	{
	    	var interestid = Object.values(Object.values(rowData)[1])[0];
	        //Code for query update
	        var urldata = "/showInterest?batchId="+interestid+"&agencyId=3001";
console.log("entered");
	        $http.post(urldata).then(function(response){
	        	
	                console.log("batch id for Interest is "+interestid);
	                //$scope.response=response.data;
	            });
	    	
	    	console.log("you are on right track");
	    	}
	    }
	   
	 }]); // End of controller

	
	app.controller('AssignCtrl', ['$scope', '$http', function ($scope, $http) {
		
		
		$scope.gridOptions = {
				  enableGridMenus : false,  
				  enableSorting: false, 
				  enableFiltering: false,
				  enableCellEdit : false,
				  enableColumnMenus : false,
		};
		  
	    $scope.gridOptions.columnDefs = [
{ name:'batchId',displayName:'Batch ID',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'trainingPartnerDetails',displayName:'TP Name|Email|Contact No',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'assessmentDate',displayName:'Assessment Date',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'location',displayName:'District|State',cellClass:'cell',headerCellClass:'CommonCell'},
{ name:'totalCandidatesInBatch',displayName:'Candidates',displayName:'No. of Candidates',cellClass:'cell',headerCellClass:'CommonCell'},
{ name: 'Action',cellClass:'check',headerCellClass:'CommonCell',cellTemplate: '<label><img src="icon/indexPageIcons/tick.png" ng-click=grid.appScope.approve(row)>  &nbsp; &nbsp; &nbsp; &nbsp; <img src="icon/indexPageIcons/close.png" ng-click=grid.appScope.reject(row)></label>' }
	    ];

	    $scope.approve = function(rowData){
	        //Extract first cell value
	        var approveid = Object.values(Object.values(rowData)[1])[0];


	        //Code for query update
	        var urldata = "/approveAssignment?batchId="+approveid;

	        $http.post(urldata).then(function(response){
	                console.log("batch id for Approve is "+approveid);
	                //$scope.response=response.data;
	            });
	    };
	    

	    $scope.reject = function(rowData){
	    	var rejectid = Object.values(Object.values(rowData)[1])[0];


	        //Code for query update
	        var urldata = "/rejectAssignment?batchId="+rejectid;

	        $http.post(urldata).then(function(response){
	                console.log("batch id for Approve is "+rejectid);
	                //$scope.response=response.data;
	            });
	    };
	  
		$http.get('getAssignedBatchesAssessmentBodyHomepage')
	    		.success(function(data) {
	    			$scope.gridOptions.data = data;
	    })
	}]);

app.controller('ConfirmedCtrl', ['$scope', '$http', '$location', function ($scope, $http, $location) {
	$scope.gridOptions = {
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
	$http.get('getConfirmedBatchesAssessmentBodyHomepage')
	.success(function(data) {
		$scope.gridOptions.data =data;
	});
}]);
