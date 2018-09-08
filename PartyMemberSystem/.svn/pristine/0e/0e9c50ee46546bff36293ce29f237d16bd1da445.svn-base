package org.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.bean.User;
import org.lanqiao.service.LoginService;
import org.lanqiao.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginService loginService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		loginService = new LoginServiceImpl();
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("application/json");
		User user = loginService.login(username, password);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
//			Gson json = new Gson();
//			String loginUser = json.toJson(user);
//			PrintWriter out=response.getWriter();
//			out.write(loginUser);
//			out.flush();
			request.getRequestDispatcher("menu/index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login.html").forward(request, response);
		}
	}

}
