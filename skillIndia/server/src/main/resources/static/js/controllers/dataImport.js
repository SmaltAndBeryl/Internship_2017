var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.autoResize']);

app.controller('MainCtrl', ['$scope', '$location','$http', '$log', function ($scope,$location, $http, $log) {
  
	$scope.gridOptions = {enableColumnMenus : false,
						enableSorting : false,
						enableHorizontalScrollbar:0,
						enableVerticalScrollbar:0};

  $scope.gridOptions.columnDefs = [
    { name:'S No' , cellClass:'sno'},
    { name:'file name', cellClass:'fname'},
    { name:'type', cellClass:'type'},
    { name:'date', cellClass:'date'},
    { name:'uploaded by', cellClass:'uby'},
   { name: 'view uploaded by',cellClass:'vub',cellTemplate: '<img src="images/CSVDownloadIcon.png" ng-click=grid.appScope.myfunction()>' }
  ];
	
	
 $scope.myfunction = function() 
  {  location.href = 'http://www.google.com';
};
  $http.get('https://cdn.rawgit.com/angular-ui/ui-grid.info/gh-pages/data/500_complex.json')
    .success(function(data) {
      $scope.gridOptions.data = data;
    });

 }]);


