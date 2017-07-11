//var app = angular.module('app', ['ui.grid', 'ui.grid.edit', 'ui.grid.cellNav']);

var manage = angular
                    .module('manage', [
                        'ui.grid',
                        'ui.grid.edit',
                        'ui.grid.cellNav'
                    ]);

//app.controller('MainCtrl', ['$scope', '$location', '$http', function ($scope, $location, $http) {
manage.controller('manageController', manageController);

manageController.$inject = ['$scope', '$location', '$http'];

function manageController($scope, $location, $http){
  //refresh();
	
  $scope.gridOptions = {
	  enableGridMenus : false,  
	  enableSorting: false, 
	  enableFiltering: false,
	  enableCellEdit : false,
	  enableColumnMenus : false,
    
	  columnDefs: [
		{ name: 'applicationId', displayName: '#', cellClass:'sno',headerCellClass:'Institution-Name', width: 30},
      	{ name: 'applicationState', displayName: 'Institution Name' ,cellClass:'fname',headerCellClass:'Institution-Name' },
		{ name: 'activeFlag',displayName: 'Type' , cellClass:'Type',headerCellClass:'Institution-Name'},
		{ name: 'dateOfSubmission', displayName: 'Date',cellClass:'layer',headerCellClass:'Institution-Name'},
		{ name: 'userId', displayName:'View', cellTemplate:'<img src="icon/indexPageIcons/pdf.png" ng-click=grid.appScope.myfunction()>',headerCellClass:'Institution-Name', cellClass:'va',width:120},
		{ name: 'Comments', displayName:'Comments' ,enableCellEdit: true,headerCellClass:'Institution-Name',cellClass:'va'},
        { name: 'Action', displayName:'Action' , cellTemplate: '<label><img src="icon/indexPageIcons/edit.png" ng-click=grid.appScope.myfunction()>&nbsp; &nbsp; &nbsp<img src="icon/indexPageIcons/tick.png" ng-click=grid.appScope.myfunction1()>  &nbsp; &nbsp; <img src="icon/indexPageIcons/close.png" ng-click=grid.appScope.myfunction2()></label>',headerCellClass:'Institution-Name',cellClass:'va'}
		
    ]
  };
    $scope.myfunction = function(){
        location.href = 'http://www.google.com';
    };

    $scope.myfunction1 = function(){
        alert("Your comment has been logged..!");
        location.href = 'http://www.google.com';
    };

    $scope.myfunction2 = function(){
        alert("Your comment has been discarded..!");
        location.href = 'http://www.facebook.com';
    };
  

    $http.get('/approve')
      .then(function(response){
        $scope.gridOptions.data = response.data;
    });
//  }
}