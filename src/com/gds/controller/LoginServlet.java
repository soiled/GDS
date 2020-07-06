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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		UserService service = new UserService();
		HttpSession session = req.getSession();
		Users user = new Users();
		String a = req.getParameter("username");
		String b = req.getParameter("password");
		int c = 0;
		user.setUserName(a);
		user.setUserPwd(b);
		System.out.println("sm��"+a);
		if (a != null && b != null) {
			if (req.getParameter("username").matches("\\S+") && req.getParameter("password").matches("\\S+")) {
				// �˺ź�����ǿ������
				c = service.logincheck(user);
				System.out.println("��¼���벻Ϊ�ս���");
				if (c != 0) {
					System.out.println("�����˺���ȷ");
					session.setAttribute("uid", c);
					session.setAttribute("uname", a);
					session.setAttribute("login_flag", "1");
					resp.sendRedirect("ArkNights.jsp");
					return;
				} else {
					req.setAttribute("msg", "�˻������ڻ��������");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
					return;
				}
			} else {
				req.setAttribute("msg", "����Ϊ��");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				return;
			}
		}
		if (req.getParameter("action").equals("exit")) {
			session.invalidate();
			resp.sendRedirect("ArkNights.jsp");
			return;
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}