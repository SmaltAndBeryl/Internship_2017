var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.autoResize']);

app.controller('MainCtrl', ['$scope', '$http', '$log', function ($scope, $http, $log) {
  $scope.gridOptions = { enableGridMenus : false,  
		  enableSorting: false, 
		  enableFiltering: false,
		  enableCellEdit : false,
		  enableColumnMenus : false,
		  enableHideColoumn: false};

  $scope.gridOptions.columnDefs = [
                                   
    { name:'#',height:71 , width:45 },
    { name:'Batch id',cellClass:'batch id',width:'96',height:'71' },
    { name:'location',width:127,height:'71' },
    { name:'Batch End date',  width:'154',height:'71'},
    { name:'Assessment Date',width:'156',height:'71'},
    { name:'Recomended AB', width:'165',height:'71'},
    { name:'Assigned AB',  width:'145',height:'71'},
    { name:'Assign', width:'52',height:'71'},
  ];



  $scope.randomSize = function () {
    var newHeight = Math.floor(Math.random() * (300 - 100 + 1) + 300);
    var newWidth = Math.floor(Math.random() * (600 - 200 + 1) + 200);

    angular.element(document.getElementsByClassName('grid')[0]).css('height', newHeight + 'px');
    angular.element(document.getElementsByClassName('grid')[0]).css('width', newWidth + 'px');
  };
}]);
