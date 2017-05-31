var app =angular.module('skillIndia', []);
(function(){
	var chartConfig ={
	        chart: {
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false
	          },
	          title: {
	            text: 'Browser market shares at a specific website, 2010'
	          },
	          tooltip: {
	            pointFormat: '{series.name}: <b>{point.percentage}%</b>',
	            percentageDecimals: 1
	          },
	          plotOptions: {
	            pie: {
	              allowPointSelect: true,
	              cursor: 'pointer',
	              dataLabels: {
	                enabled: true,
	                color: '#000000',
	                connectorColor: '#000000',
	                formatter: function () {
	                  return '<b>' + this.point.name + '</b>: ' + this.percentage + ' %';
	                }
	              }
	            }
	          },
	          credits:{
	        	  enabled:false
	          },
	          series: [{
	            type: 'pie',
	            name: 'Browser share'
	            
	          }]
	        }
	angular.module('skillIndia').constant("pieChartConfig",chartConfig);
}());