<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../jQuery/jquery-3.3.1.js"></script>
<title>基本信息</title>
<style>
div
{
	width: 100%;
}
table
{
	width:100%; 
	text-align: left;
	border-collapse: collapse;
}
th
{
	width: 25%;
}
tr
{
	width:100%; 
	height:35px;
}
</style>
</head>
<body>
  <div>
	<table border="0">
		<tr>
			<th >姓名:</th>
			<th id="td0"></th>
			<th >性别:</th>
			<th id="td1"></th>
		</tr>
		<tr>
			<td colspan="2">名族</td>
			<td colspan="2" id="td2"></td>
		</tr>
		<tr>
			<td colspan="2">公民身份证号:</td>
			<td colspan="2" id="td3"></td>
		</tr>
		<tr>
			<td colspan="2">出生日期:</td>
			<td colspan="2" id="td4"></td>
		</tr>
		<tr>
			<td colspan="2">学历:</td>
			<td colspan="2" id="td5"></td>
		</tr>
		<tr>
			<td colspan="2">人员类别:</td>
			<td colspan="2" id="td6"></td>
		</tr>
		<tr>
			<td colspan="2">所在党支部:</td>
			<td colspan="2" id="td7"></td>
		</tr>
		<tr>
			<td colspan="2">加入党组织日期:</td>
			<td colspan="2" id="td8"></td>
		</tr>
		<tr>
			<td colspan="2">转为正式党员日期:</td>
			<td colspan="2" id="td9"></td>
		</tr>
		<tr>
			<td colspan="2">工作岗位:</td>
			<td colspan="2" id="td10"></td>
		</tr>
		<tr>
			<td colspan="2">联系电话:</td>
			<td colspan="2" id="td11"></td>
		</tr>
		<tr>
			<td colspan="1">固定电话（区号）</td>
			<td colspan="1" id="td12"></td>
			<td colspan="1">+电话</td>
			<td colspan="1" id="td13"></td>
		</tr>
		<tr>
			<td colspan="2">家庭住址:</td>
			<td colspan="2" id="td14"></td>
		</tr>
		<tr>
			<td colspan="2">党籍状态:</td>
			<td colspan="2" id="td15"></td>
		</tr>
		<tr>
			<td colspan="1">是否失联</td>
			<td colspan="1" id="td16"></td>
			<td colspan="1">失去联系日期</td>
			<td colspan="1" id="td17"></td>
		</tr>
		<tr>
			<td colspan="1">是否流动党员</td>
			<td colspan="1" id="td18"></td>
			<td colspan="1">外出流向</td>
			<td colspan="1" id="td19"></td>
		</tr>
	</table>
  </div>
  <script>
  		$(function()
  			{	$("tr:odd").css("background-color","#bbbbff");
  				$("tr:even").css("background-color","#494949");
  				$.ajax({
  					url:"../json/select.json",
  					dataType:"json",
  					data:
  					{
  						"姓名":"张三",
  						"身份证":"16463164615"
  					},
  					success:addMessage
  				});
  			});
  		function addMessage(data)
  		{	
  			var j=0;console.log(j);
  			$.each(data,function(i,mess)
  					{
  					
  						$('#td'+j).html(mess);  
  						j++;
  						
  					})
  		}
  </script>
</body>
</html>