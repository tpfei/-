 
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
  			var j=0;
  			$.each(data,function(k,mess)
  					{
  						$('#td'+j).html(mess);  
  						j++;
  					})	
  			$("tr:odd").css("background-color","#bbbbff");
  			$("tr:even").css("background-color","#F5F5F5");
  		}
  		