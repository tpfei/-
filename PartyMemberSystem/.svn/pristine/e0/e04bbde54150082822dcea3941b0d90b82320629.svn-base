$(function() {
	$.ajax({
		url : "../viewUser.do",
		type : "post",
		dataType : "text",
		success : showView
	})
})
function user(userId, username, password, rolename) {
	this.userId = userId
	this.username = username
	this.password = password
	this.rolename = rolename
}
function showView(data) {
	// alert(data);
	var arr = [];
	var roleNa;
	data = eval('(' + data + ')');
	$.each(data, function(i, partMember) {
		var tr = $('<tr>');
		var td1 = $('<td>');
		var td2 = $('<td>');
		var td3 = $('<td>');
		var td4 = $('<td>');
		$.each(partMember.roles, function(j, role) {
			roleNa = role['roleName'];
		});
		userItem = new user(partMember['userId'], partMember['username'],
				partMember['password'], roleNa);
		arr[i] = userItem;
	});
	var table = $('#books').DataTable({
		data : arr,
		columns : [ {
			data : 'userId'
		}, {
			data : 'username'
		}, {
			data : 'password'
		}, {
			data : 'rolename'
		} ],
		"pagingType" : "full_numbers",
		"bSort" : true,
		"language" : {
			"sProcessing" : "处理中...",
			"sLengthMenu" : "显示 _MENU_ 项结果",
			"sZeroRecords" : "没有匹配结果",
			"sInfo" : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
			"sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
			"sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
			"sInfoPostFix" : "",
			"sSearch" : "搜索:",
			"sUrl" : "",
			"sEmptyTable" : "表中数据为空",
			"sLoadingRecords" : "载入中...",
			"sInfoThousands" : ",",
			"oPaginate" : {
				"sFirst" : "首页",
				"sPrevious" : "上页",
				"sNext" : "下页",
				"sLast" : "末页"
			},
			"oAria" : {
				"sSortAscending" : ": 以升序排列此列",
				"sSortDescending" : ": 以降序排列此列"
			}
		},
		"columnDefs" : [ {
			"searchable" : false,
			"orderable" : true,
			"targets" : 0
		} ],
		"order" : [ [ 1, 'asc' ] ]
	});
	$('#books tbody').on('click', 'tr', function() {
		if ($(this).hasClass('selected')) {
			$(this).removeClass('selected');
		} else {
			table.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
		}
	});
	$("#cancelAdd").on('click', function() {
		console.log('cancelAdd');
		$("#addBookModal").find('input').val('')
	})
	$("#addBooksInfo").on(
			'click',
			function() {
				console.log('addBooksInfo');
				if (data.length) {
					if ($("#addBookModal").find('input').val() != '') {
						var bookName = $("#bookName").val()
						var bookAuthor = $("#bookAuthor").val()
						var bookPrice = $("#bookPrice").val()
						var bookPublish = $("#bookPublish").val()
						var addBookInfos = new user(bookName, bookAuthor,
								bookPrice, bookPublish);
						for (var i = 0; i < addBookInfos.length; i++) {
							if (addBookInfos[i].userId === ''
									|| addBookInfos[i].username === ''
									|| addBookInfos[i].password === ''
									|| addBookInfos[i].rolename === '') {
								alert('内容不能为空')
							}
						}

						$.ajax({
							url : "../addUser.do",
							dataType : "text",
							type : "post",
							data : {
								username : bookAuthor,
								password : bookPrice,
								rolename : bookPublish
							},
							success : function(data) {
								alert("添加成功");
								data = eval('(' + data + ')');
								// alert(data['userId']);
								// window.location.reload();
								table.row.add(
										new user(data['userId'],
												data['userName'],
												data['password'],
												data['roleName'])).draw();
								$("#addBookModal").find('input').val('')
							}
						});
					}
				} else {
					alert('请输入内容')
				}
			})
	$("#addBooksInfo").click();
	$("#btn_add").click(function() {
		console.log('add');
		$("#addBook").modal()
	});
	$('#btn_edit').click(function() {
		console.log('edit');
		if (table.rows('.selected').data().length) {
			$("#editBookInfo").modal()
			var rowData = table.rows('.selected').data()[0];
			var inputs = $("#editBookModal").find('input')
			// for (var i = 0; i < inputs.length; i++) {
			$(inputs[0]).val(rowData.userId);
			$(inputs[1]).val(rowData.username);
			$(inputs[2]).val(rowData.password);
			$(inputs[3]).val(rowData.rolename);
			// }
		} else {
			alert('请选择项目');
		}
	});
	$("#saveEdit").click(
			function() {
				var editBookName = $("#editBookName").val()
				var editBookAuthor = $("#editBookAuthor").val()
				var editBookPrice = $("#editBookPrice").val()
				var editBookPublish = $("#editBookPublish").val()
				var newRowData = new user(editBookName, editBookAuthor,
						editBookPrice, editBookPublish);
				var tds = Array.prototype.slice.call($('.selected td'))
				if (newRowData !== '') {
					tds[0].innerHTML = newRowData.userId;
					tds[1].innerHTML = newRowData.username;
					tds[2].innerHTML = newRowData.password;
					if (newRowData.rolename == 'R10004') {
						tds[3].innerHTML = "普通党员";
					} else if (newRowData.rolename == 'R10001') {
						tds[3].innerHTML = "党委管理员";
					} else if (newRowData.rolename == 'R10002') {
						tds[3].innerHTML = "党支部管理员";
					}
				} else {
					alert('内容不能为空')
				}
				$.ajax({
					url : "../editUser.do",
					dataType : "text",
					type : "post",
					data : {
						userId : editBookName,
						username : editBookAuthor,
						password : editBookPrice,
						rolename : editBookPublish
					},
					success : function(data) {
						alert("修改成功")
						// window.location.reload();
					}
				});
			})
	$("#cancelEdit").click(function() {
		console.log('cancelAdd');
		$("#editBookModal").find('input').val('')
	})
	$('#btn_delete').click(function() {

		if (table.rows('.selected').data().length) {
			$("#deleteBook").modal()
		} else {
			alert('请选择项目');
		}
	});
	$('#delete').click(function() {
		var tds = Array.prototype.slice.call($('.selected td'))
		var userid = tds[0].innerHTML;
		$.ajax({
			url : "../deleteUser.do",
			dataType : "text",
			type : "post",
			data : {
				userId : userid,
			},
			success : function(data) {
				alert("删除成功");
			}
		});
		table.row('.selected').remove().draw(false);
	});
}
