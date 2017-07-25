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
  {   var appState=rowData.entity.applicationState;
  if(appState=="Incomplete"){
	  window.location="https://www.google.co.in";
	  //replace with $location.path();
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