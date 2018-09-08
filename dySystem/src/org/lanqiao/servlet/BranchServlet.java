package org.lanqiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.lanqiao.bean.Branch;
import org.lanqiao.service.BranchService;
import org.lanqiao.service.impl.BranchServicrImpl;
import com.google.gson.Gson;


/**
 * Servlet implementation class BranchServlet
 */
public class BranchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public BranchService branchService;
	public Branch branch;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BranchServlet() {
		super();
		branchService = new BranchServicrImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		uri = uri.substring(lastIndex + 1);
		request.setCharacterEncoding("UTF-8");
		System.out.println(uri);
		
		if (uri.equals("addBranch.do")) {
			response.setContentType("application/json;charset=utf-8");
			List<Branch> branchs=new ArrayList<Branch>();
			BranchService branchService = new BranchServicrImpl();
			branchs = branchService.getAllBranch2();// 第一页
			Gson gson=new Gson();
			String data=gson.toJson(branchs);
			PrintWriter out =response.getWriter();
			out.println(data);
			System.out.println(data);
			out.flush();
		}
		else if (uri.equals("saveBranch.do")) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println("111");
			String dept_id = request.getParameter("dept_id");
			String dept_upname = "";
			String dept_name = request.getParameter("dept_name");
			String dept_sj = request.getParameter("dept_sj");
			String dept_lxr = request.getParameter("dept_lxr");
			String dept_tel = request.getParameter("dept_tel");
			String dept_sort = request.getParameter("dept_sort");
			
			System.out.println(dept_name + ":" + dept_sort);
			Branch branch = new Branch();
			branch.setDept_id(dept_id);
			branch.setDept_name(dept_name);
			branch.setDept_upname(dept_upname);
			branch.setDept_sj(dept_sj);
			branch.setDept_lxr(dept_lxr);
			branch.setDept_tel(dept_tel);
			branch.setDept_sort(dept_sort);
			BranchService branchService= new BranchServicrImpl();
			PrintWriter out=response.getWriter();
			if (branchService.saveBranch(branch)) {
				
				System.out.println("save success");
				out.print("保存成功");
				out.flush();
			} else {
				System.out.println(" save  fail");
				out.println("保存失败,该组织ID可能已存在，请刷新重试!");
				out.flush();
				
			}
			
		}else if (uri.equals("updateBranch.do")) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			String dept_id = request.getParameter("dept_id");
			String dept_name = request.getParameter("dept_name");
			String dept_sort = request.getParameter("dept_sort");
			String dept_sj = request.getParameter("dept_sj");
			String dept_lxr = request.getParameter("dept_lxr");
			String dept_tel = request.getParameter("dept_tel");
			branch = new Branch();
			branch.setDept_id(dept_id);
			branch.setDept_name(dept_name);
			branch.setDept_sj(dept_sj);
			branch.setDept_lxr(dept_lxr);
			branch.setDept_tel(dept_tel);
			branch.setDept_sort(dept_sort);
			System.out.println(dept_id);
			branchService=new BranchServicrImpl();
			
			PrintWriter out=response.getWriter();
			if (branchService.updateBranch(branch)) {
				
				System.out.println(" update success");
				out.print("更新成功");
				out.flush();
			} else {
				System.out.println("update  fail");
				out.println("更新失败,该组织ID已存在，请刷新重试!");
				out.flush();
				
			}
		}else if(uri.equals("selectBranch.do")) {
			response.setContentType("application/json;charset=utf-8");

			String branchName=request.getParameter("branchName");
			String branchSort=request.getParameter("branchSort");
			System.out.println(branchName+""+branchSort);
			
		 	BranchService branchService= new BranchServicrImpl();
		 	List<Branch> branchs =branchService.getBranch2(branchName,branchSort);
		 	
		 	Gson gson=new Gson();
			String data=gson.toJson(branchs);
			
		 	PrintWriter out=response.getWriter();
		 	out.print(data);
		 	System.out.println(data);
		 	out.flush();
		}else if(uri.equals("deleteBranch.do")){
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			String branchId=request.getParameter("id");
			System.out.println(branchId+"****");
			  BranchService branchService=new BranchServicrImpl();
			boolean success=  branchService.deleteBranch(branchId);
			
			if(success){
				PrintWriter out=response.getWriter();
				out.println("删除成功");
				out.flush();
			
			}
			
		}
	}

}
