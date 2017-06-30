var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.autoResize']);

app.controller('MainCtrl', ['$scope', '$location','$http', '$log', function ($scope,$location, $http, $log) {
  
	$scope.gridOptions = {enableColumnMenus : false,
						enableSorting : false,
						enableHorizontalScrollbar:0,
						enableVerticalScrollbar:0};

  $scope.gridOptions.columnDefs = [
    { name:'S No' , width:45,cellClass:'sno',headerCellClass:'layer'},
    { name:'File Name',width:132, cellClass:'fname',headerCellClass:'File-Name'},
    { name:'Type',width:236, cellClass:'type',headerCellClass:'Type'},
    { name:'Date',width:150, cellClass:'date',headerCellClass:'Date '},
    { name:'Uploaded By',width:210, cellClass:'uby',headerCellClass:'Uploaded-By'},
   { name: 'View Uploaded File',width:165,cellClass:'vub', headerCellClass:'View-Uploaded-File',cellTemplate: '<img src="img.png" ng-click=grid.appScope.myfunction()>' }
  ];
	
	
 $scope.myfunction = function() 
  {  location.href = 'http://localhost:8080/DownloadExcel';
};
  $http.get('data.json')
    .success(function(data) {
      $scope.gridOptions.data = data;
    });

 }]);


