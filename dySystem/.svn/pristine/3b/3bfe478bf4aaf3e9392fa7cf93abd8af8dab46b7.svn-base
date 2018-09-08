 
		var name1=window.location.search.substring(1);
  		var name=decodeURI(name1);  
  		$(function()
  			{
  				$.ajax({
  					url:"../selectDangyuan.do",
  					dataType:"json",
  					data:{
  						dyName:name
  					},
  					success:addMessage
  				});
  			});
  		function addMessage(data)
  		{
  		/*	var j=0;
  			$.each(data,function(k,mess)
  					{
  						$('#td'+j).html(mess);  
  						j++;
  					})	*/
  			$('#td0').html(data['dyId']);
  			$('#td1').html(data['zbId']);
  			$('#td2').html(data['name']);
  			$('#td3').html(data['sex']);
  			$('#td4').html(data['jiguan']);
  			$('#td5').html(data['mingzu']);
  			$('#td6').html(data['sfzhm']);
  			$('#td7').html(data['rylb']);
  			$('#td8').html(data['sqrdsj']);
  			$('#td9').html(data['lwjjfzsj']);
  			$('#td10').html(data['bylxr']);
  			$('#td11').html(data['fzdxsj']);
  			$('#td12').html(data['rdjxr']);
  			$('#td13').html(data['rdsj']);
  			$('#td14').html(data['dwspsj1']);
  			$('#td15').html(data['zzsj']);
  			$('#td16').html(data['dwspsj2']);
  			$('#td17').html(data['lxfs']);
  			$('#td18').html(data['jtzz']);
  			$("tr:odd").css("background-color","#bbbbff");
  			$("tr:even").css("background-color","#F5F5F5");
  		}
  		