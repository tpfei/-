<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<% 
 		String dzbId=request.getParameter("dzbId");
 	%> 
<head>
	<meta charset="UTF-8">

	<title>党员</title>
	 <meta name="viewport" content="width=device-width, initial-scale=1">
	  <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
	  <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
	  <script src="https://cdn.bootcss.com/datatables/1.10.16/js/jquery.dataTables.js"></script>
	  
	<!--  <link rel="stylesheet" type="text/css" href="../css/dyxx.css">
	<script type="text/javascript" src="../jQuery/jquery-3.3.1.js"></script>-->
	<script type="text/javascript" src="../js/dyxx2.js"></script>
</head>
<style>
    .content {
      margin: 50px auto;
      border: 1px solid #ccc;
    }
    .operation {
      margin: 10px;
    }
    .operation>button {
      margin: 10px;
    }
    .operation>a>button {
      margin: 10px;
    }
    #books_length {
      float: left;
      margin-left: 20px;
    }
    #books_filter {
      float: right;
      margin-right: 20px;
    }
    #books {
      margin: 5px;
    }
    #more{
    float:right;
    margin:10px 2px 3px 10px;
    }
    #daoru{
    float:right;
    margin:10px 2px 3px 10px;
    }
    #m1{
    float:right;
    }
    .center-block {
      display: block;
      width: 21%;
      margin: auto;
    }
    #a
    {
    	margin-top: 13px;
    	margin-left: 10px;
    }
  </style>

<body>
 	<section class="content">

    <div class="btn-group operation">
      <button id="btn_add" type="button" class="btn bg-primary" onclick="blFun()">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
      </button>
			<a href="../outDangyuan.do">
				<button id="btn_bl" type="button" class="btn">
					<span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>导出名册
				</button>
			</a> <a href="../downDYMessage.do">
				<button id="btn_bl" type="button" class="btn" onclick="downMenu()">
					<span class="glyphicon glyphicon-download" aria-hidden="true"></span>导出采集表
				</button>
			</a>
			<div id="m1">
			<form id="uploadForm" enctype="multipart/form-data">
				<div id="more"><input type="file" name="file" /></div>
				<div id="daoru"><button id="upload" type="button" class="btn" >
					<span class="glyphicon glyphicon-upload" aria-hidden="true"></span>导入采集表
				</button></div>
			</form>
			</div>
      <input type="text" value="输入姓名" id="a" onfocus="this.value='';this.onfocus='';" width="140px" />
		<input type="button" value="查询" id='a' onclick="selectFun()"	/>
    </div>
     <table id="tables" class="table table-striped table-bordered row-border hover order-column" cellspacing="0" width="100%">
      <thead>
        <tr>
          <th>姓名</th>
          <th>身份证号码</th>
          <th>性别</th>
          <th>民族</th>
          <th>入党日期</th>
          <th>人员类别</th>
          <th>所在党支部</th>
          <th>联系方式</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody></tbody>
    </table>
    </section>
	<!--  <input type="button" value="党员排序" id="menu" />
	<input type="button" value="补录" onclick="blFun()" id="menu"/>
	<input type="button" value="导出名册" id="menu"/>
	<input type="button" value="导出采集表" id="menu"/>
	<input type="button" value="导入采集表" id="menu"/>
	<input type="button" value="找回" id="menu"/>
	<table border="1" id="tables">
		<tr>
			<th id="c">姓名</th>
			<th>身份证号码</th>
			<th>性别</th>
			<th>民族</th>
			<th>出生日期</th>
			<th>人员类别</th>
			<th>所在党支部</th>
			<th>联系方式</th>
			<th>操作</th>
		</tr>
	</table>-->
</div>
</body>
</html>
