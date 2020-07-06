package com.gds.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gds.entity.Users;
import com.gds.service.UserService;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		UserService service = new UserService();
		HttpSession session = req.getSession();
		Users user = new Users();
		String a = req.getParameter("username");
		String b = req.getParameter("password");
		int c = 0;
		user.setUserName(a);
		user.setUserPwd(b);
		System.out.println(a);
		if (a != null && b != null) {
			if (req.getParameter("username").matches("\\S+") && req.getParameter("password").matches("\\S+")) {
				// 账号和密码非空则进入
				if (service.signup(user) != 0) {
					session.setAttribute("uid", c);
					session.setAttribute("uname", a);
					session.setAttribute("login_flag", "1");
					resp.sendRedirect("loading.jsp");
					return;
				} else {
					req.setAttribute("msg", "账户已存在");
					req.getRequestDispatcher("signup.jsp").forward(req, resp);
					return;
				}
			} else {
				req.setAttribute("msg", "不能为空");
				req.getRequestDispatcher("signup.jsp").forward(req, resp);
				return;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
