$(function () {
           
                var processed_json = new Array();   
            
      $.getJSON('/getDashboardTopStatesWithMaxTrainingCenters', function(data) {                                                  
          for (i = 0; i < data.length; i++){
                        processed_json.push([data[i].state, data[i].trainingCenters]);
                    }
                 
                    // draw chart
                    $('#container').highcharts({
                    chart: {
                        type: "column"
                    },
                    xAxis: {
                        type: 'category',
                        allowDecimals: false,
                        title: {
                            text: "States"
                        }
                    },
                    yAxis: {
                        title: {
                            text: "Total Training Centres"
                        }
                    },
                        credits: {
            enabled: false
        },
                    series: [{
                        name: 'Training Centres',
                        data: processed_json
                    }]
                }); 
                                                                                    
                                                                                    
                                                                              
                                                                                    
                                                                                    
            });
        });
    