        $(function () {
           
                var processed_json = new Array();   
            
      $.getJSON('/topStates', function(data) {                                                  
          for (i = 0; i < data.length; i++){
                        processed_json.push([data[i].key, data[i].value]);
                    }
                 
                    // draw chart
                    $('#container').highcharts({
                    chart: {
                        type: "column"
                    },
                    title: {
                        text: ""
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
    