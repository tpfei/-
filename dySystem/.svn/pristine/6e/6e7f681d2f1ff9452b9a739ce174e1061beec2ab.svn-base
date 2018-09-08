$(function() {
	$.ajax({
		url:"../viewUser.do",
		type:"post",
		dataType:"text",
		success:showView 
	})
})

function showView(data) {
		data = eval('('+data+')') ;
		$.each(data, function (i, partMember) {
			alert(partMember['name']);
//			var tr = $('<tr>');
//			var td1 = $('<td>');
//			td1.append(partMember['name']).attr('name',partMember['sfzhm']).bind("click",clicks);
//
//			var td2 = $('<td>');
//			td2.append(partMember['sfzhm']);
//			var td3 = $('<td>');
//			td3.append(partMember['sex']);
//			var td4 = $('<td>');
//			td4.append(partMember['mingzu']);
//			var td5 = $('<td>');
//			td5.append(partMember['zzsj']);
//			var td6 = $('<td>');
//			td6.append(partMember['rylb']);
//			var td7 = $('<td>');
//			td7.append(partMember['zbId']);
//			var td8 = $('<td>');
//			td8.append(partMember['lxfs']);
//			var td9 = $('<td>');
//			td9.append($('<input>').attr('type', 'button').attr('value', '删除').attr('name',partMember['sfzhm']));
//			tr.append(td1);
//			tr.append(td2);
//			tr.append(td3);
//			tr.append(td4);
//			tr.append(td5);
//			tr.append(td6);
//			tr.append(td7);
//			tr.append(td8);
//			tr.append(td9);
//			$('#tables').append(tr);
//			$("#tables td").click(function () {
//				console.log($(this).text())
//			})
//		})
//		 $("table input:button").click(function() {
//		        var value = $(this).attr("name");
//				$.ajax({
//					url: "../deleteDangyuan.do",
//					dataType: "json",
//					data:
//						{
//							sfzhm:value
//						}
//				});        
//		        $(this).parent().parent().remove();
//		    });
//		$("tr:odd").css("background-color","#bbbbff");
//		$("tr:even").css("background-color","#F5F5F5");
		});
	}