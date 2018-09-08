package org.lanqiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.bean.User;
import org.lanqiao.bean.UserTemp;
import org.lanqiao.service.UserService;
import org.lanqiao.service.impl.UserServiceImpl;
import org.lanqiao.util.TransactionManager;

import com.google.gson.Gson;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		userService = new UserServiceImpl();
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
		System.out.println(uri);
		if (uri.equals("viewUser.do")) {
			System.out.println("sssss");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			UserService userService = new TransactionManager<UserService>().createProxy(new UserServiceImpl());
			System.out.println(userService.getAllUser().size());
			List<User> users = userService.getAllUser();
			Gson gson = new Gson();
			String json = gson.toJson(users);
			System.out.println(json);
			PrintWriter out = response.getWriter();
			out.write(json);
			out.flush();
		}
		if (uri.equals("addUser.do")) {
//			request.getRequestDispatcher("page/addUser.html").forward(request, response);
			System.out.println("fangwen");
			String username = request.getParameter("username");
//			String password = request.getParameter("password");
			String roleId = request.getParameter("rolename");
			
			if (userService.saveUser(username, roleId)) {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json");
				System.out.println("success");
				String roleName = userService.getRoleName(roleId);
				User user = userService.getUser(username);
				UserTemp userTemp = new UserTemp(user.getUserId(),username,user.getPassword(),roleName);
				Gson gson = new Gson();
				String json = gson.toJson(userTemp);
				System.out.println(json);
				PrintWriter out = response.getWriter();
				out.write(json);
				out.flush();
			} else {
				System.out.println("fail");
			}
		} else if (uri.equals("editUser.do")) {
//			userId:editBookName,
//			username : editBookAuthor,
//			password : editBookPrice,
//			rolename : editBookPublish
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			String userId = request.getParameter("userId");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String roleId = request.getParameter("rolename");
			System.out.println(username +"-"+ password + "-"+ roleId);
			if (userService.updataUser(username, userId, password, roleId)) {
				System.out.println("update success!!");
			}
		}else if(uri.equals("deleteUser.do")) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			String userId= request.getParameter("userId");
			System.out.println(userId);
			if (userService.deleteUser(userId)) {
				System.out.println("É¾³ý³É¹¦");
			}
		}
	}

}
