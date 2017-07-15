var app = angular.module('app', ['ngTouch', 'ui.grid.edit', 'ui.grid.autoResize']);

app.controller('MainCtrl', ['$scope', '$http',function ($scope, $http) {	 

  $scope.gridOptions = { enableGridMenus : false,  
		  enableSorting: false, 
		  enableFiltering: false,
		  enableCellEdit : false,
		  enableColumnMenus : false,
		  enableHideColoumn: false,

  columnDefs : [
                                   
    { name:'#' , displayname:'1' , height:'71' , width:'100'},
    { name:'batchId' , displayname:'Batch id' , cellClass:'batch id' , width:'162' , height:'71' },
    { name:'state' , displayname:'location' , width:'162' , height:'71' },
    { name:'batchEndDate' , displayname:'Batch End date' ,  width:'163' , height:'71'},
    { name:'assessmentDate' , dispalyname:'Assessment Date' , width:'162' , height:'71'},
    { name:'assessorName' ,displayname:'Proposed AB',  width:'163',height:'71'},
    
  ]
};
 /* 
  function refresh() {
	    $http.get('classpath:sql/batchAssignmentsSearchBatches.yml')
	    .success(function (data) {
	      $scope.gridOptions.data = data;
	    });*/
	$scope.getDataOfBatch = function()
	{
		$http.post('/getInformationOfTheBatchId?batchId='+$scope.batchAssignmentSearch)
		  .success(function (data) {
			  console.log("inside request method");
		    $scope.gridOptions.data = data;
		  });
	};
  
 
}]);
