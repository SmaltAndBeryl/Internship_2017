var app = angular.module('app', ['ui.grid', 'ui.grid.edit', 'ui.grid.cellNav']);

app.controller('MainCtrl', ['$scope', '$location', '$http', function ($scope, $location, $http) {
refresh();
	
  $scope.gridOptions = {
	  enableGridMenus : false,  
	  enableSorting: false, 
	  enableFiltering: false,
	  enableCellEdit : false,
	  enableColumnMenus : false,
    
	  columnDefs: [
		{ name: 'Serial no', displayName: 'Serial No', cellClass:'sno',headerCellClass:'Institution-Name',width:80},
      	{ name: 'Institution name | Location', displayName: 'Institution Name', width: 190 ,cellClass:'fname',headerCellClass:'Institution-Name' },
		{ name: 'Type',displayName: 'Type' , cellClass:'Type',headerCellClass:'Institution-Name'},
		{ name: 'Date', displayName: 'Date',width:100,cellClass:'layer',headerCellClass:'Institution-Name'},
		{ name: 'View Application', displayName:'View', cellTemplate:'<img src="icon/indexPageIcons/pdf.png" ng-click=grid.appScope.myfunction()>',headerCellClass:'Institution-Name', cellClass:'va',width:120},
		{ name: 'Comments', displayName:'Comments' ,enableCellEdit: true, width:180,headerCellClass:'Institution-Name',cellClass:'va'},
        { name: 'Action', displayName:'Action' , cellTemplate: '<label><img src="icon/indexPageIcons/edit.png" ng-click=grid.appScope.myfunction()>&nbsp; &nbsp; &nbsp<img src="icon/indexPageIcons/tick.png" ng-click=grid.appScope.myfunction1()>  &nbsp; &nbsp; <img src="icon/indexPageIcons/close.png" ng-click=grid.appScope.myfunction2()></label>',headerCellClass:'Institution-Name',cellClass:'va'}
		
    ]
  };
    $scope.myfunction = function()
    {
        location.href = 'http://www.google.com';
    };
     $scope.myfunction1 = function() 
  {  location.href = 'http://www.google.com';
};
    $scope.myfunction2 = function()
    {location.href = 'http://www.facebook.com';
    };
  
  function refresh() {
    $http.get('')
    .success(function (data) {
      $scope.gridOptions.data = data;
    });
  }
}]);