
		//新建下级党组织的添加
		$(function(){
//			$("#btn_add").click(function(){
//				console.log('add');
//				$("#myModal").modal()
//			});
		$("#saveEdit").click(function() {
			var partyName=document.getElementById("partyName").value;
			console.log(partyName);
			var partyId = document.getElementById("partyId").value;
			console.log(partyId);
			var contacts=$("#select option:selected").text();
			console.log(contacts);
			var category = document.getElementById("category").value;
			console.log(category);
			var tel = document.getElementById("tel").value;
			console.log(tel);
			var responsiblePerson = document.getElementById("responsiblePerson").value;
			console.log(responsiblePerson);
			
			
			var da="dept_name="+partyName+"&dept_id="+partyId+"&dept_lxr="+category+"&dept_sort="+contacts+"&dept_tel="+tel+"&dept_sj="+responsiblePerson;
			$.ajax({
				url:"../saveBranch.do",
				type:"POST",
				dataType:"text",
				data:da,
//				{
//					dept_name:partyName,
//					dept_id:partyId,
//					dept_lxr:contacts,
//					dept_sort:category,
//					dept_tel:tel,
//					dept_sj:responsiblePerson
//				},
				success:function(data){
					alert(data);
				}
			});
		  var tr = $('<tr>'); //创建tr
			
		  var PartyName = $('<td>')
		  PartyName.append(partyName);
			
			var PartyId = $('<td>')
			PartyId.append(partyId);
			
			var Contacts = $('<td>')
			Contacts.append(contacts);
			
			var Category = $('<td>')
			Category.append( category );
			
			var Tel= $('<td>')
			Tel.append(tel);
			
			var ResponsiblePerson = $('<td>')
			ResponsiblePerson.append(responsiblePerson);
			
			var tdOperation = $('<td>');
			tdOperation.append($('<input>').attr('type', 'button').attr('id', 'write').attr('class', 'btn btn-primary')
			.attr('onclick', 'Change(this)').attr('class', 'btn').attr('data-toggle', 'modal').attr('data-target', '#editModel').attr('value', '编辑'));
			tdOperation.append($('<input>').attr('type', 'button').attr('onclick', 'Save(this)')
			.attr('class', 'btn').attr('class', 'btn btn-primary').attr('class', 'btn').attr('value', '保存'));
			tdOperation.append($('<input>').attr('type', 'button').attr('id', 'delete').attr('class', 'btn btn-danger').attr('flg',partyId)
			.attr('class', 'btn').attr('data-toggle', 'modal').attr('data-target', 'deleteModel').attr('value', '删除'));
			
		    tr.append(PartyName);
			tr.append(PartyId);
			tr.append(Contacts);
			tr.append(Category);
			tr.append(Tel);
			tr.append(ResponsiblePerson);
			tr.append(tdOperation);

		    $('#books').append(tr);	
		  //实现删除
			$(".btn").click(function () {
				var id = $(this).attr("flg");
				var t=$(this).parent().parent();
				var str;
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
				//再次打开时清空模态框的input文本框的内容
				$("#myModal").on('hidden.bs.modal',function(){
				$("table input[class='text']").val("");
					});
				
				//实现编辑
				Change = function (obj){ 
					$(obj).parent().prevUntil().each(function()
					{
						var txt=$(this).text();
						var input=$("<input type='text' name='editname' value='"+txt+"'>");//添加文本框
						$(this).html(input); 
					});
					$(obj).html('保存');
					};
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
						})
						}
					
		})
		})
		
		//检查党组织名称输入的内容内容
		function checkPartyName()
		{ 
			var check = false; 
			var partyName = document.getElementById("partyName").value; 
			if (partyName.length < 3) 
			{ 
				document.getElementById("checktext1").innerHTML = " × 党组织名称不能少于3位，请重新输入"; 
				check = false; 
			} 
			else if(partyName.length >20)
			{
				document.getElementById("checktext1").innerHTML = " × 党组织名称不能大于20位，请重新输入"; 
				check = false; 
			}
			else 
			{ 
				document.getElementById("checktext1").innerHTML = " √"; 
				check = true; 
			} 
			return check; 
		} 
		//检查党组织代码
		function checkPartyId()
		{ 
			var check = false; 
			var partyId = document.getElementById("partyId").value; 
			if (partyId.length != 7) 
			{ 
				document.getElementById("checktext2").innerHTML = " × 党组织代码不等于7位，请重新输入"; 
				check = false; 
			} 
			else 
			{ 
				document.getElementById("checktext2").innerHTML = " √"; 
				check = true; 
			} 
			return check; 
		} 
		
		
		
		//检查党组织联系人
		function checkCategory()
		{
			var check = false; 
			var category = document.getElementById("category").value; 
			if (category.length < 3) 
			{ 
				document.getElementById("checktext4").innerHTML = " × 党组织联系人不能少于3位，请重新输入"; 
				check = false; 
			} 
			else if(category.length >7)
			{
				document.getElementById("checktext4").innerHTML = " × 党组织联系人不能大于7位，请重新输入"; 
				check = false; 
			}
			else 
			{ 
				document.getElementById("checktext4").innerHTML = " √"; 
				check = true; 
			} 
			return check; 
			
		}
		//检查党组织联系人的电话
		function checkTel()
		{
			var check = false; 
			var tel = document.getElementById("tel").value; 
			if (tel.length != 11) 
			{ 
				document.getElementById("checktext5").innerHTML = " × 党组织电话号码不等于11位，请重新输入"; 
				check = false; 
			} 
			else 
			{ 
				document.getElementById("checktext5").innerHTML = " √"; 
				check = true; 
			} 
			return check; 
		}
		//检查党组织负责人
		function checkResponsiblePerson()
		{
			var check = false; 
			var responsiblePerson = document.getElementById("responsiblePerson").value; 
			if (responsiblePerson.length < 3) 
			{ 
				document.getElementById("checktext6").innerHTML = " × 党组织联系人不能少于3位，请重新输入"; 
				
				check = false; 
			} 
			else if(responsiblePerson.length >7)
			{
				document.getElementById("checktext6").innerHTML = " × 党组织联系人不能大于7位，请重新输入"; 
				check = false; 
			}
			else 
			{ 
				document.getElementById("checktext6").innerHTML = " √"; 
				check = true; 
			} 
			return check; 
		}
