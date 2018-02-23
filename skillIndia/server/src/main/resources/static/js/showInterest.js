var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.autoResize']);

app.controller('MainCtrl', ['$scope', '$http', '$log', function ($scope, $http, $log) {
  $scope.gridOptions = {enableColumnMenus: false,enableSorting: false};

  $scope.gridOptions.columnDefs = [
    { name:'Batch ID', width:100},
    { name:'TP Name|Email|Contact No', width:250},
    { name:'Assessment Date', width:150},
    { name:'District|State', width:150},
    { name:'No. of Candidates', width:170},
    { name:'Show Interest',cellTemplate: '<div><label><input type="checkbox" value=""> <button class="btn btn-default" data-toggle="confirmation" onclick="confirmfunction2()" ng-click="grid.appScope.confirmfunction()">&#10004</button></label></div>' , width:170}
  ];
  
  	$http.get('/poc/data.json')
  		.success(function(data) {
  			$scope.gridOptions.data = data;
  	})
  		
    $scope.confirmfunction = function(){
  		//console.log("Function Reached");
  		$http.get('/ShowInterestupcomingtable').success(function(data){
  			//console.log("data populated");
  		})
    }
  	
 }]); // End of controller

function confirmfunction2()
{
  //console.log("button Code reached");
  //console.log("Cnf Function reached");
  
	if (confirm("Do you want to confirm interest?")==true)
	    txt = "Your Interest is Confirmed!";
	else
		txt = "Your Interest is Cancel!";			
    	document.getElementById("demo").innerHTML = txt;
}
