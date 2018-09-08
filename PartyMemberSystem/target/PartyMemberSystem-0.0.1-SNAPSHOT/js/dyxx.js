$(function () {

		//
		$.ajax({
//			url: "../json/dyxx.json",
			url: "../viewDangyuan.do",
			dataType: "text",
			success: cxdy
		});
		$("#upload").click(function() {
			var formData = new FormData($('#uploadForm')[0]);
			$.ajax({
				type : "post",
				url : "../import.do",
				data : formData,
				cache : false,
				processData : false,//禁止jquery对数据的处理
				contentType : false,//禁止设置请求类型
				success: function() {
					alert("提交成功");
					window.location.reload();
				}
			});
		})
	});
	function cxdy(data) {

		data = eval('('+data+')') ;
		
		$.each(data, function (i, partMember) {

			var tr = $('<tr>');
			var td1 = $('<td>');
			td1.append(partMember['name']).attr('name',partMember['sfzhm']).bind("click",clicks);

			var td2 = $('<td>');
			td2.append(partMember['sfzhm']);
			var td3 = $('<td>');
			td3.append(partMember['sex']);
			var td4 = $('<td>');
			td4.append(partMember['mingzu']);
			var td5 = $('<td>');
			td5.append(partMember['zzsj']);
			var td6 = $('<td>');
			td6.append(partMember['rylb']);
			var td7 = $('<td>');
			td7.append(partMember['zbId']);
			var td8 = $('<td>');
			td8.append(partMember['lxfs']);
			var td9 = $('<td>');
			td9.append($('<input>').attr('type', 'button').attr('value', '删除').attr('name',partMember['sfzhm']));
			tr.append(td1);
			tr.append(td2);
			tr.append(td3);
			tr.append(td4);
			tr.append(td5);
			tr.append(td6);
			tr.append(td7);
			tr.append(td8);
			tr.append(td9);
			$('#tables').append(tr);
			$("#tables td").click(function () {
				console.log($(this).text())
			})
		})
		 $("table input:button").click(function() {
		        var value = $(this).attr("name");
				$.ajax({
					url: "../deleteDangyuan.do",
					dataType: "json",
					data:
						{
							sfzhm:value
						}
				});        
		        $(this).parent().parent().remove();
		    });
		$("tr:odd").css("background-color","#bbbbff");
		$("tr:even").css("background-color","#F5F5F5");
	}
function downMenu() {
	$.ajax({
		url:"../downDYMessage.do",
		dataType:"text",
		data:{
			aa:"aa"
		}
	})
}
	function clicks()
	{	
		var name=$(this).text();
		var url = "../page/selfMessage.html?"+name;
		//$("#main").load(url);
		window.open(url,'_blank','height=500px,width=520px,top='+(screen.availHeight-500)/2+',left='+(screen.availWidth-520)/2+',status=yes');
	}
	function selectFun()
	{
		var name=$('#a').val();
		window.open('select.html?'+name,'select','height=600px,width=900px,top='+(screen.availHeight-600)/2+',left='+(screen.availWidth-900)/2+',status=yes');
	}
	function blFun()
	{
		window.open('bulu.html','bl','height=800px,width=900px,top='+(screen.availHeight-300)/2+',left='+(screen.availWidth-900)/2+',status=yes');
	}