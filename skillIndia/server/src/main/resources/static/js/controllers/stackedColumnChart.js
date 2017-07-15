$(function () {
	
	var year= [];
	var stateSkillLevel= [];
	var marketMode= [];
	var mnreFunded=[];
	var nbc=[];
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
		  	++j;		 
		 }
		 if(year[j]==data[i].years)
			 {
			 	if(mode=='MNRE')
			 	{
			  	mnreFunded.push(data[i].candidatesCertified);
			  	continue;
			 	}
			 	if(mode=='Market Mode')
			  	{
			  		  marketMode.push(data[i].candidatesCertified);
			  		  continue;
			  	}
			 	if(mode=='State Skill Level')
			  	{
			  		  stateSkillLevel.push(data[i].candidatesCertified);
			  		  continue;
			  	}
			 	if(mode=='NBC'||mode=='FDC')
			  	  {
			  		  nbc.push(data[i].candidatesCertified);
			  		  continue;
			  	  }
			 }
		  
	 }
		     
	  console.log(year);
	  console.log('MNRE is ' +mnreFunded);
	  console.log('Market Mode is '+marketMode);
	  console.log('NBC/FDC  is '+nbc);
	  console.log('State Skill Level is '+stateSkillLevel);
	
	  $('#container').highcharts({
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
        x: -30,
        verticalAlign: 'top',
        y: 25,
        floating: true,
        backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
        borderColor: '#CCC',
        borderWidth: 1,
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
        name: 'NBC/FDC',
        data: nbc
    }, {
        name: 'Market Mode',
        data: marketMode
    },{
      
       name: 'MNRE Funded',
       data: mnreFunded
}
    ]
});
});
  
  //var year=[2015, 2016];
  //console.log(year);
  
  });