var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.autoResize']);
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
{ name:'Show Interest',cellClass:'check',headerCellClass:'CommonCell',cellTemplate: '<div><label><input type="checkbox" value="">&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp<button class="btn btn-default" data-toggle="confirmation" onclick="confirmfunction2()" ng-click="grid.appScope.confirmfunction()">&#10004</button></label></div>'}
];
	  
	   $http.get('getUpcomingBatchesAssessmentBodyHomepage')
	    .success(function(data) {
	     $scope.gridOptions.data = data;
	   })
	    
	    $scope.confirmfunction = function(){
	    console.log("Function Reached");
	    $http.get('/ShowInterestupcomingtable').success(function(data){
	     console.log("data populated");
	    })
	    }
	   
	 }]); // End of controller

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
{ name: 'Action',cellClass:'check',headerCellClass:'CommonCell',cellTemplate: '<label><img src="icon/indexPageIcons/tick.png" ng-click=grid.appScope.myfunction1()>  &nbsp; &nbsp; &nbsp; &nbsp; <img src="icon/indexPageIcons/close.png" ng-click=grid.appScope.myfunction2()></label>' }
	    ];

	    $scope.myfunction1 = function(){
	        alert("Your comment has been logged..!");
	        location.href = 'http://www.google.com';
	    };

	    $scope.myfunction2 = function(){
	        alert("Your comment has been discarded..!");
	        location.href = 'http://www.facebook.com';
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
