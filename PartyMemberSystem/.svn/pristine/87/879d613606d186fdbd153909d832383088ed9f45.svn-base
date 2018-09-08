<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>login</title>
<style type="text/css">
#s1 {
	color: black;
}

#s1:hover {
	color: red;
}

#s2 {
	color: black;
}

#s2:hover {
	color: red;
}

#s3 {
	color: black;
	float: left;
}
</style>
<link rel="stylesheet" type="text/css" href="css/zhuzhi.css" />
<script type="text/javascript" src="jQuery/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/deleteBranch.js"></script>
<script type="text/javascript" src="js/viewBranch.js"></script>
<script type="text/javascript">
	var totalPage = "${pm.totalPage}";//全局变量
	var currentPage = "${currentPage}";//全局变量
	function openEditWindow(dept_id) {
		window.open('editBranch.do?dept_id=' + dept_id, '_blank',
				'width=600,height=400,top=100px,left=500px');
	}
	function openSelWindow(dept_id) {
		window.open('selBranch.do?dept_id=' + dept_id, '_blank',
				'width=600,height=400,top=100px,left=500px');
	}
</script>
</head>
<body>
	<div id="main">
		<div id="h2">
			<form action="selectBranch.do" method="post">
				<input type="text" placeholder="输入党组织名称" name="organize" /> <select
					name="">
					<option value="">党组织</option>
				</select> <input type="checkbox"><font size="3">包含下级</font> <input
					type="submit" name="select" font-size="5" value="查询"> <input
					type="button" id="addOrgan" name="new" value="新建下级党组织"> <input
					type="button" name="daochu" value="导出名册">
			</form>
		</div>
		<table border="1" cellspacing="0">

			<tr>
				<th align="center" width="150">党组织名称</th>
				<th align="center" width="150">党组织代码</th>
				<th align="center" width="150">党组织类别</th>
				<th align="center" width="150">党组织联系人</th>
				<th align="center" width="150">党组织联系电话</th>
				<th align="center" width="150">党组织负责人</th>
				<th align="center" width="150">操作</th>
			</tr>
			<c:forEach var="branch" items="${pm.list}">
				<tr align="center">
					<td><a href="javascript:void(0)"
						onclick="openSelWindow('${branch.dept_id}');return false; ">${branch.dept_name}</a></td>
					<td>${branch.dept_id}</td>
					<td>${branch.dept_sort}</td>
					<td>${branch.dept_lxr}</td>
					<td>${branch.dept_tel}</td>
					<td>${branch.dept_sj}</td>
					<td><input type="button"
						onclick="openEditWindow('${branch.dept_id}');return false; "
						value="编辑" /> <input type="button"
						onclick="deleteBranch('${branch.dept_id}')" value="删除" /></td>
				</tr>
			</c:forEach>
		</table>
		<input type="button" value="首页" id="first" /> <input type="button"
			value="上一页" id="prev" /> <input type="button" value="下一页" id="next" />
		<input type="button" value="尾页" id="last" />
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("#addOrgan").click(function() {
			var url = "page/i.html";
			$("#main").load(url);
		});
		$("#cx").click(function() {
			$.ajax({
				url : "json/view.json",
				dataType : "text",
				success : cx
			})
		})
	});
	function cx(data) {

		data = eval("(" + data + ")");

		$.each(data["partMember"],
				function(i, partMember) {

					var tr = $('<tr>');
					var td1 = $('<td align="center">');
					td1.append(partMember['dzzmc']);

					var td2 = $('<td align="center">');
					td2.append(partMember['dzzdm']);
					var td3 = $('<td align="center">');
					td3.append(partMember['dzzlb']);
					var td4 = $('<td align="center">');
					td4.append(partMember['dzzfzr']);
					var td5 = $('<td align="center">');
					td5.append(partMember['dzzgzfl']);
					var td6 = $('<td align="center">');
					td6.append(partMember['xxwzd']);

					var td7 = $('<td align="center">');

					td7.append($('<input>').attr('type', 'button').attr(
							'onclick', 'del()').attr('value', '编辑'));
					td7.append($('<input>').attr('type', 'button').attr(
							'value', '删除'));
					tr.append(td1);
					tr.append(td2);
					tr.append(td3);
					tr.append(td4);
					tr.append(td5);
					tr.append(td6);
					tr.append(td7);

					$('table').append(tr);

				})
	};
	function del() {
		var url = "page/bianji.html";
		$("#main").load(url);
	};
</script>
</html>