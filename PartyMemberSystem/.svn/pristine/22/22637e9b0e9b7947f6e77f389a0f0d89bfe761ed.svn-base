 		var name1=window.location.search.substring(1);
  		var name=decodeURI(name1);
  		$(function()
  			{	$("tr:odd").css("background-color","#bbbbff");
  				$("tr:even").css("background-color","#494949");
  				$.ajax({
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
  			/*var j=0;
  			$.each(data,function(k,mess)
  					{
  					
  						$('#td'+j).attr('value',mess);  
  						j++;
  						
  					})	*/
  			$('#td0').attr('value',data['dyId']);
  			$('#td1').attr('value',data['zbId']);
  			$('#td2').attr('value',data['name']);
  			$('#td3').attr('value',data['sex']);
  			$('#td4').attr('value',data['jiguan']);
  			$('#td5').attr('value',data['mingzu']);
  			$('#td6').attr('value',data['sfzhm']);
  			$('#td7').attr('value',data['rylb']);
  			$('#td8').attr('value',data['sqrdsj']);
  			$('#td9').attr('value',data['lwjjfzsj']);
  			$('#td10').attr('value',data['bylxr']);
  			$('#td11').attr('value',data['fzdxsj']);
  			$('#td12').attr('value',data['rdjxr']);
  			$('#td13').attr('value',data['rdsj']);
  			$('#td14').attr('value',data['dwspsj1']);
  			$('#td15').attr('value',data['zzsj']);
  			$('#td16').attr('value',data['dwspsj2']);
  			$('#td17').attr('value',data['lxfs']);
  			$('#td18').attr('value',data['jtzz']);
  			
  		}
  		function saveFun()
  		{
  		
  			var dyMessage={
  					
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
						
			}
  			alert('确定保存吗？');
  			$.ajax({
  		        contentType:"application/json",
  				url: "../updateDangyuan.do",
  				dataType: "json",
  				data:
  				{
  					dyMessage:JSON.stringify(dyMessage)
  				}
  			
  			});
  			window.opener.location.reload();
  			alert("保存成功!");	
  			window.close();
  		}