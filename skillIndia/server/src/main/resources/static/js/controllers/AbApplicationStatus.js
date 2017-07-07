var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.autoResize']);
app.controller('MainCtrl', ['$scope', '$http', '$location', function ($scope, $http, $location) {
	
	$scope.gridOptions = {
		  enableColumnMenus: false,
		  enableSorting: false,
		  verticalScrollbar:0,
		  
  columnDefs : [
    { name: 'applicationID' ,	displayName:'Application ID',	cellClass:'Prostokt-2-kopia-2-copy-10',	headerCellClass:'Application-ID',	width:260,
	},
    { name: 'dateOfSubmission',	displayName:'Date of Submission',	cellClass:'Prostokt-2-kopia-2-copy-11',	headerCellClass:'Date-of-Submission',	width:208,
	},
    { name: 'submittedby' ,	displayName:'Submitted By',	cellClass:'Prostokt-2-kopia-2-copy-12',	headerCellClass:'Submitted-By',	width:208,
	},
    { name: 'status' ,	displayName:'Status',	cellClass:'Prostokt-2-kopia-2-copy-13',	headerCellClass:'Status',	width:185,
	},
    { name:	'Action',	cellClass: 'Prostokt-2-kopia-2-copy-14',	width:76,	headerCellClass: 'Action-copy', ,cellTemplate:'<span class="edit"></span><img src="icon/indexpageIcons/edit1.png" ng-click=grid.appScope.myfunction()>',paddingTop:10,
    },
    { name: 'comment' ,	displayName:'Comment',	cellClass:'Prostokt-2-kopia-2-copy-15',	headerCellClass:'Comment',	width:201,
	}
	]
  };
$scope.myfunction = function() 
  {  location.href = 'http://www.google.com';
};
$http.get('/assessmentBodyApplicationStatus')
    .success(function (data) {
      $scope.gridOptions.data = data;
    });
	
}]);