<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
<style type="text/css">
#s3 {
	color: black;
	float: right;
}

#s4 {
	color: black;
	float: left;
}

#s1 {
	color: red;
	float: middle;
}

#select1 {
	width: 100px;
}
</style>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/dengji.css">
<script type="text/javascript" src="jQuery/jquery-3.3.1.js"></script>
<% 
 		String dzbId=request.getParameter("dzbId");
 	%> 
</head>
<body>
	<form id="editDataForm" name="editDataForm">
		
		<table>
			<tr class="t1">
				<td id="s3"><span>*</span>支部id：</td>
				<td colspan="0"><input type="text" class="i5"
					readonly="readonly" name="dept_id" value="${branch.dept_id}"></td>
			</tr>
			<tr class="t1">
				<td id="s3"><span>*</span>支部名称：</td>
				<td colspan="0"><input type="text" name="dept_name"
					value="${branch.dept_name}" class="i5"></td>
			</tr>
			<tr class="t1">
				<td id="s3"><span>*</span>上级党组织名称：</td>
				<td colspan="0"><input type="text"
					value="${branch.dept_upname}" class="i5" disabled="disabled"></td>
			</tr>
			<tr class="t1">
				<td id="s3"><span>*</span>党组织书记：</td>
				<td colspan="0"><input type="text" name="dept_sj"
					value="${branch.dept_sj}" class="i5"></td>
			</tr>
			<tr class="t2">
				<td id="s3"><span>*</span>党组织联系人：</td>
				<td colspan="0"><input type="text" name="dept_lxr"
					value="${branch.dept_lxr}" class="i5"></td>
			</tr>
			<tr class="t1">
				<td id="s3"><span>*</span>联系电话：</td>
				<td colspan="0"><input type="text" name="dept_tel"
					value="${branch.dept_tel}" class="i5"></td>
			</tr>
			<tr class="t1">
				<td id="s3"><span>*</span>组织类别：</td>
				<td colspan="0"><input type="text" class="i5"
					disabled="disabled" value="${branch.dept_sort}"></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
		$("#commitEdit").click(function() {
			$.ajax({
				type : "post",
				url : "updateBranch.do",
				data:$('#editDataForm').serialize(),
				success : function(data) {
					alert("修改成功");
					window.opener.location.reload();
					window.close();
				},
				error : function(request) {//请求失败之后的操作
					alert("修改失败");
					window.opener.location.reload();
					window.close();
				}
			});
		})
</script>
</html>