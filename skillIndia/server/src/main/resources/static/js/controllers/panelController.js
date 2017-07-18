//var app= angular.module('app',[]);

var dashboard = angular.module('dashboard', []);

dashboard.controller('dashboardController', dashboardController);

dashboardController.$inject = ['$scope', '$http'];

function dashboardController($scope, $http)  {
	
	  $http.get("/getDashboardTotalCandidatesEnrolled")
	  .then(function(response) {
	      $scope.enrolled = response.data;
	  });

	  $http.get("/getDashboardTotalCandidatesAccessed")
      	  .then(function(response) {
      	      $scope.assessed =response.data;
      	  });

       $http.get("/getDashboardTotalCandidatesCertified")
             	  .then(function(response) {
             	      $scope.certified = response.data;
             	  });


        $http.get("/getDashboardTotalTrainingPartners")
              	  .then(function(response) {
              	      $scope.partner = response.data;
              	  });

        $http.get("/getDashboardTotalTrainingCentersInIndia")
                      	  .then(function(response) {
                      	      $scope.centre = response.data;
                      	  });

	
 //Stacked Column Chart
//        
        $(document).ready(function() {
        	
        	var year= [];
        	var stateSkillLevel= [];
        	var marketMode= [];
        	var mnreFunded=[];
        	var nbc=[];
        	var paidRpl=[];
        	var candidatesCertified=[];
            var mode;            
                       
          $.getJSON('/getDashboardTotalCandidatesCertifiedWithModeInLastThreeYears', function(data){
        	  
        	 
        	  for(i = 0; i < data.length; i++)
        	  {
        		   year.push(data[i].years);
        	  }
        	 
        	  year = jQuery.unique(year); 
        	  
        	  console.log('LENGTH OF DATA:'+data.length);
        	  console.log('TOTAL NO OF YEARS:  '+year.length)
//        	 
        	 var j=0;  
        	 for(i = 0; i < data.length; i++)
        	 {
        		 mode=(data[i].modes);
        		 if(data[i].years>year[j])
        		 {
        		 	if(mnreFunded[j]==null)
        		 		{
        		 			mnreFunded.push(null);
        		 		}
        		 	if(marketMode[j]==null)
        		  		{
        		 		 marketMode.push(null);
        		  		}
        		  	if(stateSkillLevel[j]==null)
        		  		{
        		  			stateSkillLevel.push(null);
        		  		}
        		  	if(nbc[j]==null)
        		  		{
        					nbc.push(null);
        	  			}
        		  	if(paidRpl[j]==null)
    		  		{
    					paidRpl.push(null);
    	  			}
        		  	++j;		 
        		 }
        		 if(year[j]==data[i].years)
        			 {
        			 	if(mode=='mnre')
        			 	{
        			  	mnreFunded.push(data[i].candidatesCertified);
        			  	continue;
        			 	}
        			 	if(mode=='market')
        			  	{
        			  		  marketMode.push(data[i].candidatesCertified);
        			  		  continue;
        			  	}
        			 	if(mode=='state skill level')
        			  	{
        			  		  stateSkillLevel.push(data[i].candidatesCertified);
        			  		  continue;
        			  	}
        			 	if(mode=='nbcfdc')
        			  	  {
        			  		  nbc.push(data[i].candidatesCertified);
        			  		  continue;
        			  	  }
        			 	if(mode=='paid rpl')
      			  	  {
      			  		  paidRpl.push(data[i].candidatesCertified);
      			  		  continue;
      			  	  }
        		
        	    }
        		 
        		  
     	 }
     		     
//        	  console.log(year);
//  	  console.log('MNRE is ' +mnreFunded);
//        	  console.log('Market Mode is '+marketMode);
//        	  console.log('NBC/FDC  is '+nbc);
//      	  console.log('State Skill Level is '+stateSkillLevel);
      
       	 Highcharts.chart('stackedColumnChart', {
            chart: {
                type: 'column'
            },
            title: {
                text: 'Candidates Certified Under Non-PMKVY'
            },
            xAxis: {
                categories:year 
                },
            yAxis: {
                min: 0,
                title: {
                    text: 'Candidates Certified'
                },
                stackLabels: {
                    enabled: true,
                    style: {
                        fontWeight: 'bold',
                        color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                    }
                }
            },
            legend: {
                align: 'right',
                verticalAlign: 'bottom',
                floating: false,
                backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
                borderColor: '#CCC',
                borderWidth: 0,
                shadow: false
            },
            tooltip: {
                headerFormat: '<b>{point.x}</b><br/>',
                pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
            },
            credits: {
                enabled: false
            },
            plotOptions: {
                column: {
                    stacking: 'normal',
                    dataLabels: {
                        enabled: true,
                        color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white'
                    }
                }
            },
            series: [{
                name: 'State Skill Level',
                data: stateSkillLevel
            }, {
                name: 'NBCFDC',
                data: nbc
            }, {
                name: 'Market Mode',
                data: marketMode
            },{
              
               name: 'MNRE Funded',
               data: mnreFunded
        },
        {
            
            name: 'Paid RPL',
            data: paidRpl
     }
            ]
        });
        });
          
          //var year=[2015, 2016];
          //console.log(year);
          
          });
//
//};
        
  //      Pie-Chart
        
        $(document).ready(function() {
            
        	var processed_json = new Array();   
            
            $.getJSON('/getDashboardTotalBatchesAccordingToJobRole', function(data) {                                                  
                for (i = 0; i < data.length; i++){
                              processed_json.push([data[i].jobRole, data[i].batches]);
                //console.log(processed_json);
                }
//               // console.log('outside loop is' +processed_json);
//                
//      // Radialize the colors
                
                
      Highcharts.chart('pieChart', {
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        credits:{
        	enabled:false
        },
        title: {
            text: 'Total Trainings in Each Sector'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.0f}</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                size:'50%',
                dataLabels: {
                    enabled: true,
                    itemStyle: {
                        font: '5pt sans-serif'
                    },
                    format: '<b>{point.name}</b>: {point.percentage:.0f} ',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
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

        


//
        
//        
//        //Column-Chart
       
        $(document).ready(function() {
        	
      
            
            var processed_json = new Array();   
        
  $.getJSON('/getDashboardTopStatesWithMaxTrainingCenters', function(data) {                                                  
      for (i = 0; i < data.length; i++){
                    processed_json.push([data[i].state, data[i].trainingCenters]);
                }
             console.log("data is" +processed_json);
                // draw chart
             Highcharts.chart('columnChart', {
            	 chart: {
                    type: "column"
                },
                title:{
                	text:"Top 5 States"
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
//};

//        
//        //Grouped-Column Chart
//        

         $(document).ready(function() {
        	
        	var year= [];
        	var pmkvyCandidates= [];
        	var nonPmkvyCandidates= [];           
            var batchType;            
                       
          $.getJSON('/getDashboardTotalCandidatesTrainedWithBatchTypeInLastThreeYears', function(data){
        	  
        	 
        	  for(i = 0; i < data.length; i++){
        	      year.push(data[i].years);	      
        	  }
        	  year = jQuery.unique(year); 
        	  j=0;
        	  for(i = 0; i < data.length; i++)    
        	  {
        	  batchType=(data[i].batchType);
        	  if(data[i].years>year[j])
        		 {
        		  if(pmkvyCandidates[j]==null)
        		  {
        			  pmkvyCandidates.push(null);
        		  }
        		  if(nonPmkvyCandidates[j]==null) 
        		   {
        			  nonPmkvyCandidates.push(null);
        		   }
        		  ++j;
        		 }
        	  if(year[j]==data[i].years)
        		  {
        		  		if(batchType=='pmkvy')
        		  		{
        		  			pmkvyCandidates.push(data[i].trained);
        		  			continue;
        		  		}
        		  	   if(batchType=='non-pmkvy' )
        		  		
        		  		{
        		  			nonPmkvyCandidates.push(data[i].trained);
        		  			continue;
        				}
        		  }
        	  }  
        	 
        	   Highcharts.chart('groupedColumnChart', {
        		   chart: {
        	        type: 'column'
        	    },
        	    title: {
        	        text: 'Candidates Enrolled under PMKVY and Non-PMKVY'
        	    },
        	    subtitle: {
        	        text: 'Source: SCGJ.in'
        	    },
        	    xAxis: {
        	        categories: year,
        	        crosshair: true
        	    },
        	    yAxis: {
        	        min: 0,
        	        title: {
        	            text: 'Candidates Trained'
        	        }
        	    },
        	    credits: {
                    enabled: false
                },
        	    tooltip: {
        	        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        	        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
        	            '<td style="padding:0"><b>{point.y:.0f}</b></td></tr>',
        	        footerFormat: '</table>',
        	        shared: true,
        	        useHTML: true
        	    },
        	    plotOptions: {
        	        column: {
        	            pointPadding: 0.2,
        	            borderWidth: 0
        	        }
        	    },
        	    series: [{
        	        name: 'PMKVY',
        	        data: pmkvyCandidates

        	    }, {
        	        name: 'Non-PMKVY',
        	        data: nonPmkvyCandidates

        	    }]
        	});

          });
          
          
           });

};
      