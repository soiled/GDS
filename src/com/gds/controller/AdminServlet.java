package com.gds.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.gds.entity.Users;
import com.gds.service.AdminService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		AdminService service =new AdminService();
		HttpSession session =request.getSession();
		String a =request.getParameter("admin");
		String flag ="0";
		if(a!=null) {
		for(Users u:service.selectadmin()) {
			System.out.println(u.getAdminPwd());
			if(u.getAdminPwd()!=null&&u.getAdminPwd().equals(a)) {
				//Users admin =u;
				session.setAttribute("uname", u.getUserName());
				session.setAttribute("uid", u.getUserId());
				session.setAttribute("admin", "1");//表示登录
				request.getRequestDispatcher("Adminmain.jsp").forward(request, response);
				a=null;
				System.out.println("成功");
				return; 
		}
		}//遍历后没有符合进行跳跃
		if(flag.equals("0")) {
			session.setAttribute("msg", "worry");
			request.getRequestDispatcher("Admin.jsp").forward(request, response);
			return;
		}
	}
	
	
	
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
