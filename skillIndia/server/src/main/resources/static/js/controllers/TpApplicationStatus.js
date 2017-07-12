var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.autoResize']);
app.controller('MainCtrl', ['$scope', '$http', '$location', function ($scope, $http, $location) {
	
	$scope.gridOptions = {
		  enableColumnMenus: false,
		  enableSorting: false,
		  verticalScrollbar:0,
		  
  columnDefs : [
{ name: 'applicationID' ,	displayName:'Application ID',	cellClass:'Prostokt-2-kopia-2-copy-10',	headerCellClass:'Application-ID',
},
{ name: 'dateOfSubmission',	displayName:'Date of Submission',	cellClass:'Prostokt-2-kopia-2-copy-11',	headerCellClass:'Date-of-Submission',
},
{ name: 'trainingPartnerName' ,	displayName:'Submitted By',	cellClass:'Prostokt-2-kopia-2-copy-12',	headerCellClass:'Submitted-By',
},
{ name: 'applicationState' ,	displayName:'Status',	cellClass:'Prostokt-2-kopia-2-copy-13',	headerCellClass:'Status',
},
{ name:'Action',	cellClass: 'Prostokt-2-kopia-2-copy-14',	width:76,	headerCellClass: 'Action-copy',	cellTemplate:'<img src="icon/indexpageIcons/edit1.png" ng-click=grid.appScope.myfunction()>',
},
{ name: 'comment' ,	displayName:'Comment',	cellClass:'Prostokt-2-kopia-2-copy-15',	headerCellClass:'Comment',
}
	]
  };
$scope.myfunction = function() 
  {  location.href = 'http://www.google.com';
};
$http.get('/trainingPartnerApplicationStatus')
//$http.get('poc/Status.json')
    .success(function (data) {
      $scope.gridOptions.data = data;
    });
	
}]);