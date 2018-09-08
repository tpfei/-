function deleteBranch(dept_id) {
	// alert(arguments[0]);
	$.ajax({
		url : "deleteBranch.do",
		method : "get",
		data : {
			id : dept_id
		},
		dataType : "text",
		success : function(){
			 window.location.reload();
		}
	});
}
function refreshData(data) {

	var trs = $('table').find($('tr:has(td)'));

	$.each(trs, function(i, row) {
		$('table').find($('tr:has(td)').remove());
	});

	// 下节课内容：删除除了表头以外的所有行
	jQuery.getJSON('viewBranchJSON.do', function(data) {

		$.each(data.list, function(i, branch) {
			var tr = $('<tr align="center">');
			var tdName = $('<td >');
			tdName.append(branch['dept_name']);

			var tdId = $('<td >');
			tdId.append(branch['dept_id']).attr("name", branch['dept_id']);

			var tdUpName = $('<td >');
			tdUpName.append(branch['dept_upname']);

			var tdLxr = $('<td >');
			tdLxr.append(branch['dept_lxr']);

			var tdTel = $('<td>');
			tdTel.append(branch['dept_tel']);

			var tdSj = $('<td>');
			tdSj.append(branch['dept_sj']);

			var tdDo = $('<td>');

			tdDo.append($('<input>').attr('id', 'edit').attr('type', 'button')
					.attr('value', '编辑'));
			tdDo.append($('<input>').attr('id', 'del').attr('type', 'button')
					.attr('value', '删除'));

			tr.append(tdName);
			tr.append(tdId);
			tr.append(tdUpName);
			tr.append(tdLxr);
			tr.append(tdTel);
			tr.append(tdSj);
			tr.append(tdDo);
			$("table #del").click(function() {
				var value = $(this).attr("name");
				$.ajax({
					url : "deleteBranch.do",
					dataType : "json",
					data : {
						id : value
					}
				});
				$(this).parent().parent().remove();
			});
			$("table #edit").click(function() {
				alert("edit");
//				var value = $(this).attr("name");
//				$.ajax({
//					url : "editBranch1.do",
//					dataType : "json",
//					data : {
//						dept_id : value
//					}
//				});
			});
			$('table').append(tr);
		});
	});
}