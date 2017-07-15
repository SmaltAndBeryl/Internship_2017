
$(function () {
	
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
		  		if(batchType=='PMKVY')
		  		{
		  			pmkvyCandidates.push(data[i].trained);
		  			continue;
		  		}
		  	   if(batchType=='Non-PMKVY')
				{
		  			nonPmkvyCandidates.push(data[i].trained);
		  			continue;
				}
		  }
	  }  
	 
	  
	   $('#container').highcharts({
		   chart: {
	        type: 'column'
	    },
	    title: {
	        text: 'Candidates Trained'
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
