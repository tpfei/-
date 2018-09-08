	$(function(){
		$("tr:odd").css("background-color","#bbbbff");
		$("tr:even").css("background-color","#F5F5F5");
	})
	function saveFun()
	{	
			var dyMessage={
				
					"dyId":$('#td0').val(),
					"zbId":$('#td1').val(),
					"name":$('#td2').val(),
					"sex":$("input[name='sex']:checked").val(),
					"jiguan":$('#td4').val(),
					"mingzu":$(".mingzu option:selected").text(),
					"sfzhm":$('#td6').val(),
					"rylb":$('.leixing option:selected').text(),
					"sqrdsj":$('.i5').val(),
					"lwjjfzsj":$('.i6').val(),
					"bylxr":$('#td10').val(),
					"fzdxsj":$('.i7').val(),
					"rdjxr":$('#td12').val(),
					"rdsj":$('.i8').val(),
					"dwspsj1":$('.i9').val(),
					"zzsj":$('.i10').val(),
					"dwspsj2":$('#i11').val(),
					"lxfs":$('#td17').val(),
					"jtzz":$('#td18').val()			
						
			}
			if(dyMessage['sfzhm']&&dyMessage['dyId']&&dyMessage['name'])
				{
					toSave(dyMessage);
					alert("保存成功!");
					window.opener.location.reload();	
					window.close();
				}
			else{
					alert('信息不够完整!');
				}
	}
	
	function toSave(dyMessage)
	{
		$.ajax({
	        contentType:"application/json",
			url: "../saveDangyuan.do",
			dataType: "json",
			data:
			{
				dyMessage:JSON.stringify(dyMessage)
			}
		
		});


		var tr = $('<tr>');
		var td1 = $('<td>');
		td1.append(dyMessage['name']).attr('name',dyMessage['sfzhm']);

		var td2 = $('<td>');
		td2.append(dyMessage['sfzhm']);
		var td3 = $('<td>');
		td2.append(dyMessage['sex']);
		var td4 = $('<td>');
		td4.append(dyMessage['mingzu']);
		var td5 = $('<td>');
		td5.append(dyMessage['zzsj']);
		var td6 = $('<td>');
		td6.append(dyMessage['rylb']);
		var td7 = $('<td>');
		td7.append(dyMessage['zbId']);
		var td8 = $('<td>');
		td8.append(dyMessage['lxfs']);
		var td9 = $('<td>');
		td9.append($('<input>').attr('type', 'button').attr('value', '删除').attr('name',dyMessage['sfzhm']));
		tr.append(td1);
		tr.append(td2);
		tr.append(td3);
		tr.append(td4);
		tr.append(td5);
		tr.append(td6);
		tr.append(td7);
		tr.append(td8);
		tr.append(td9);
		window.opener.$("#tables").append(tr);	
	}
		