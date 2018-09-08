$(function () {
	if (currentPage == 1)
		prev.disabled = 'disabled';
	if (currentPage == totalPage)
		next.disabled = 'disabled';
	$("#first").click(function () {
       location.href='addBranch.do?currentPage=1';// 发出GET请求
    });
	$("#next").click(function () {
        location.href='addBranch.do?currentPage='+(Number(currentPage)+1);
    });
	$("#prev").click(function () {
        location.href='addBranch.do?currentPage='+(Number(currentPage)-1);
    });
	$("#last").click(function () {
        location.href='addBranch.do?currentPage='+totalPage;
    });
})