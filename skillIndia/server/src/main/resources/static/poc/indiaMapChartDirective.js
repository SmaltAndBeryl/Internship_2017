var app =angular.module('skillIndia');

  app.directive('mapChart', function (indiaMapChartConfig) {
  return {
    restrict: 'C',
    replace: true,
    scope: {
    	data: '='
    },
    controller: function ($scope, $element, $attrs) {
      console.log(2);

    },
    template: '<div id="container" style="margin: 0 auto">not working</div>',
    link: function (scope, element, attrs) {
      console.log(3);
      console.log(pieChartConfig);
      scope.chartConfig = pieChartConfig;
      scope.chartConfig.chart.renderTo =  attrs.id;
      scope.chartConfig.chart.data= scope.data;
      
      var chart = new Highcharts.Chart(scope.chartConfig);
      scope.$watch("data", function (newValue) {
        chart.series[0].setData(newValue, true);
      }, true);
      
    }
  }
});