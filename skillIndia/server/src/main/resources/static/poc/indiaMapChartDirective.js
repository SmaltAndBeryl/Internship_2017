var app =angular.module('skillIndia');

  app.directive('mapChart', function (indiaMapConfig) {
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
      console.log(indiaMapConfig);
      scope.chartConfig = indiaMapConfig;
      scope.chartConfig.chart.renderTo =  attrs.id;
      scope.chartConfig.series[0].data= scope.data;
      
      var chart = new Highcharts.mapChart(scope.chartConfig);
      scope.$watch("data", function (newValue) {
        chart.series[0].setData(newValue, true);
      }, true);
      
    }
  }
});