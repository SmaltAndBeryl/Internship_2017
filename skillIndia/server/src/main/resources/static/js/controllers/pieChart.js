
$(function () {
           
                var processed_json = new Array();   
            
      $.getJSON('/getDashboardTotalBatchesAccordingToJobRole', function(data) {                                                  
          for (i = 0; i < data.length; i++){
                        processed_json.push([data[i].jobRole, data[i].batches]);
          //console.log(processed_json);
          }
         // console.log('outside loop is' +processed_json);
          
// Radialize the colors
Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function (color) {
    return {
        radialGradient: {
            cx: 0.5,
            cy: 0.3,
            r: 0.7
        },
        stops: [
            [0, color],
            [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
        ]
    };
});

// Build the chart
$('#pieChart').highcharts({
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: 'Total Batches According to Job Role'
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.y:.0f}</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>:<b>  {point.y:.0f}</b>',
                size:"75%",
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                },
                connectorColor: 'silver'
            }
        }
    },
    credits: {
        enabled: false
    },
    series: [{
        name: 'Batch',
        data: processed_json,
        sliced: true,
        selected: true,

    }]
});                                                                   
});
});
