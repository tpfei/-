 		var name1=window.location.search.substring(1);
  		var name=decodeURI(name1);
  		$(function()
  			{	$("tr:odd").css("background-color","#bbbbff");
  				$("tr:even").css("background-color","#494949");
  				$.ajax({
  					//url:"../json/select.json",
  					url:"../selectDangyuan.do",
  					dataType:"json",
  					data:
  						{
  							dyName:name
  						},
  					success:addMessage
  				});
  			});
  		function addMessage(data)
  		{	
  			/*
  			var j=0;
  			$.each(data,function(k,mess)
  					{
  					
  						$('#td'+j).html(mess);  
  						j++;
  						
  					})	
  					"dyId":$('#td0').val(),
					"zbId":$('#td1').val(),
					"name":$('#td2').val(),
					"sex":$('#td3').val(),
					"jiguan":$('#td4').val(),
					"mingzu":$('#td5').val(),
					"sfzhm":$('#td6').val(),
					"rylb":$('#td7').val(),
					"sqrdsj":$('#td8').val(),
					"lwjjfzsj":$('#td9').val(),
					"bylxr":$('#td10').val(),
					"fzdxsj":$('#td11').val(),
					"rdjxr":$('#td12').val(),
					"rdsj":$('#td13').val(),
					"dwspsj1":$('#td14').val(),
					"zzsj":$('#td15').val(),
					"dwspsj2":$('#td16').val(),
					"lxfs":$('#td17').val(),
					"jtzz":$('#td18').val()	
  			*/
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
  			
			
  		}