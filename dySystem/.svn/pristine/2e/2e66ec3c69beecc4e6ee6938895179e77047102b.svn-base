$(function () {
	
	$.ajax({
		url: "../addBranch.do",
		dataType: "json",
		success: callBack1,

	})
});

function callBack1(data) {
	
	$("#books tr:not(:first)").html("");
//	var trs=$('#books').find($('tr:has(td)'));
//	
//	$.each(trs,function(i,row){
//		$('#books').find($('tr:has(td)').remove());
//	});
	$.each(data, function (i, party) {
		var tr = $('<tr>'); //创建tr
//		var url = '../page/dyxx.html?dzbId="+party.dept_id;
		var tdPartyName = $('<td>');
		tdPartyName.append(party.dept_name).wrapInner("<a href='../page/dyxx.html?dzbId="+party.dept_id+"'></a>");
		var tdPartyId = $('<td>');
		tdPartyId.append(party.dept_id);

		var tdCategory = $('<td>');
		tdCategory.append(party.dept_sort);

		var tdContacts = $('<td>');
		tdContacts.append(party.dept_lxr);

		var tdTel = $('<td>');
		tdTel.append(party.dept_tel);

		var tdResponsiblePerson = $('<td>');
		tdResponsiblePerson.append(party.dept_sj);


		var tdOperation = $('<td>');


		tdOperation.append($('<input>').attr('type', 'button').attr('id', 'write').attr('class', 'btn btn-primary').attr('onclick', 'Change(this)')
		.attr('data-toggle', 'modal').attr('data-target', '#editModel').attr('value', '编辑'));
		
		tdOperation.append($('<input>').attr('type', 'button').attr('onclick', 'Save(this)')
				.attr('class', 'btn').attr('class', 'btn btn-primary').attr('class', 'btn').attr('value', '保存'));
		
		tdOperation.append($('<input>').attr('type', 'button').attr('id', 'delete').attr('class', 'btn btn-danger')
			.attr('class', 'btn').attr('data-toggle', 'modal').attr('data-target', 'deleteModel').attr('value', '删除').attr('flg',party.dept_id));

	

		tr.append(tdPartyName);
		tr.append(tdPartyId);
		tr.append(tdCategory);
		tr.append(tdContacts);
		tr.append(tdTel);
		tr.append(tdResponsiblePerson);
		tr.append(tdOperation);

		$('#books').append(tr);
		//删除
			
		

	});
	
	$("#btn_add").click(function(){
		
		$("#myModal").modal();
	});
	
	$(".btn").click(function() {
		var id = $(this).attr("flg");
		var t=$(this).parent().parent();
		if ($(this).val() == "删除") {
			$.ajax({
				url : "../deleteBranch.do",
				dataType : "text",
				data : {
					id : id
				},
			  success:result
			
			});
			function result(data){
				
				if(data!=""){
					t.remove();
					alert(data);
				}else{
					alert("该组织存在党员，若您想继续删除该组织，请将组织内的党员全部删除");
				}
				
			}
		
			
		}

	});
	
	Change = function (obj){ 
		$(obj).parent().prevUntil().each(function()
		{
			var txt=$(this).text();
			var input=$("<input type='text' name='editname' value='"+txt+"'>");//添加文本框
			$(this).html(input); 
		});
		$(obj).html('保存');
		}
		//实现编辑之后保存	
	 
	Save=function (obj){  
		var i=0;
		var array=new Array();//这里将对象属性值存入数组，属性顺序不能变
		
		$('input[name=editname]').each(function()
		{
			var txt=$(this).text();
			var newtxt=$(this).parent('td').parent('tr').children().find('input').val();
			array[i++]=newtxt;
			$(this).parent('td').html(newtxt);
		})
		$(obj).html('修改');
		
		$.ajax({
			url:"../updateBranch.do",
			dataType:"text",
			data:{
				dept_name:array[0],
				dept_id:array[1],
				dept_sort:array[2],
				dept_lxr:array[3],
				dept_tel:array[4],
				dept_sj:array[5]
			},
			success:function(data){
				alert(data);
				
			}
		});
		}
	
	
}

$(document).ready(function () {

	
	$("#btn_select").click(function(){
		var branchName=$("#branchName").val();
		var branchSort=$("#branchSort").find("option:selected").text();
		
		$.ajax({
			url : "../selectBranch.do",
			dataType : "json",
			data : "branchName="+branchName+"&branchSort="+branchSort,
				
		  success:callBack1
		});
		
	});
	
});

