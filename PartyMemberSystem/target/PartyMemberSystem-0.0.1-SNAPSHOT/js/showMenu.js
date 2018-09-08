$(function()
		{
			$.ajax({
				url:"../json/showMenu.json",
				dataType:"json",
				success:showMenu
			});
		});
		function showMenu(data)
		{	
			d=new dTree('d');
			
			$.each(data,function(i,role){
				d.add(0, -1, role.roleName);
				$.each(role.trees,function(i,tree){
					if(tree.parentId=="null")
					{
						d.add(tree.treeId, 0,tree.treeName);
					}
					else
					{
						d.add(tree.treeId,tree.parentId,tree.treeName,tree.url);
					}
					
				})
			
			})
			document.getElementById("west").innerHTML=d;
			
		}