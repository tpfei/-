<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta charset="UTF-8">
<title>党员子系统</title>
	
	<link rel="stylesheet" type="text/css" 
	href="<%=basePath%>easyui/themes/metro/easyui.css">
	
	
<link rel="stylesheet" type="text/css"

	href="<%=basePath%>easyui/themes/icon.css">
<link rel="stylesheet" href="<%=basePath%>menu/dtree/dtree.css"
	type="text/css" />
<script type="text/javascript" src="<%=basePath%>menu/dtree/dtree.js"></script>
<script type="text/javascript" src="<%=basePath%>easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	function addTab(title, url) {
		if ($('#tt').tabs('exists', title)) {
			$('#tt').tabs('select', title);
		} else {
			var content = '<iframe scrolling="auto" frameborder="0"  src="'
					+ url + '" style="width:100%;height:100%;"></iframe>';
			$('#tt').tabs('add', {
				title : title,
				content : content,
				closable : true
			});
		}
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="background-image: url(image/bt.jpg);overflow: visiable;
		background-position: center center; 
background-repeat: no-repeat; 
 background-size: 100% auto;
 width:100%;
 height:70px">

<table>
			<tr>
				<td rowspan="3"><img src="image/bh.jpg" width="70px"
					height="70px" alt="" /></td>
				<td rowspan="2"><p style="font-family: Simsun;">
						<font size="7" color="yellow"><b>全国党员管理信息系统</b></font>
					</p></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td height="20px"><p style="font-family: Simsun;">
						<font size="3" color="black"></font>
					</p></td>
				<td></td>
				<td></td>
			</tr>
		</table>


	</div>
	<div data-options="region:'west',split:true,title:'功能树'"
		style="width: 150px; background-image: url(image/zuo.jpg);padding: 10px;" id="west">
		<script type="text/javascript">
		
			d = new dTree('d');
			d.add(0, -1, '党员子系统');
			<c:forEach var="role" items="${user.roles}">
			<c:forEach var="menu" items="${role.menus}">
			<c:choose>
			<c:when test="${empty menu.parentId}">
			d.add('${menu.menuId}', 0, '${menu.menuName}', '${menu.URL}');//父菜单的权限
			</c:when>
			<c:otherwise>
			d.add('${menu.menuId}', '${menu.parentId}', '${menu.menuName}',
					'${menu.URL}');//子菜单的权限
			</c:otherwise>
			</c:choose>
			</c:forEach>
			</c:forEach>
			document.write(d);
		</script>
	</div>
	<div
		data-options="region:'east',split:true,collapsed:true,title:'East'"
		style="width: 100px; padding: 10px;">east region</div>
	<!-- <div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div> -->
	<div data-options="region:'center',title:''" id="tt"
		class="easyui-tabs" style="width: 100%; height: 700px;"
		class="easyui_layout">
		<div title="主页"></div>
	</div>
</body>
</html>