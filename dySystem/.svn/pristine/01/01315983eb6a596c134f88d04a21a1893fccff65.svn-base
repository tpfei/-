package org.lanqiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.bean.Pay;
import org.lanqiao.service.PayService;
import org.lanqiao.service.impl.PayServiceImpl;
import org.lanqiao.util.PageModel2;
import org.lanqiao.util.TransactionManager;

import com.google.gson.Gson;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public PayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		uri = uri.substring(lastIndex+1);
		System.out.println(uri);
		if("showPay.do".equals(uri)) {
			response.setContentType("application/json;charset=UTF-8");
			
			String page=request.getParameter("page");
			String rows=request.getParameter("rows");
			
			PayService payService=new TransactionManager<PayService>().createProxy(new PayServiceImpl());
			PageModel2<Pay> pm=payService.viewPay(Integer.parseInt(page),Integer.parseInt(rows));
			
			Gson gson=new Gson();
			String payJson=gson.toJson(pm);
			System.out.println(payJson);
			PrintWriter out=response.getWriter();
			out.print(payJson);
			out.flush();
		}
		else if("updatePay.do".equals(uri)) {
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out=response.getWriter();
			
			String result="";
			PayService payService=new PayServiceImpl();
			String dy_id=request.getParameter("dy_id");
			if(payService.updateRole(dy_id)==1)
			{
				result="{\"errorMsg\":\"\"}";
				out.write(result);
			}
			else
			{
				result="{\"errorMsg\":\"\"}";
				out.write(result);
			}
			out.flush();
		}
	}

}
