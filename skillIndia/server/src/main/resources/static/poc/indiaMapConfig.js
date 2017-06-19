(function() {

	var mapChartConfig = {

		chart : {
			map : 'countries/in/custom/in-all-disputed'
		},

		mapNavigation : {
			enabled : true,
			buttonOptions : {
				verticalAlign : 'bottom'
			}
		},

		colorAxis : {
			min : 0
		},

		credits : {
			enabled : false
		},
		series : [ {
			name : 'Random data',
			states : {
				hover : {
					color : '#BADA55'
				}
			},
			dataLabels : {
				enabled : true,
				format : '{point.name}'
			}

		} ]
	}
	angular.module('skillIndia').constant("indiaMapConfig", mapChartConfig);
}());