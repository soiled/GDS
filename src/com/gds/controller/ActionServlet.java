package com.gds.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gds.entity.Role;
import com.gds.entity.Users;
import com.gds.service.DrawService;
import com.gds.service.UserService;
import com.sun.xml.internal.ws.wsdl.writer.document.Service;

/**
 * Servlet implementation class ActionServerlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		DrawService service = new DrawService();
		response.getWriter().append("Served at: ").append(request.getContentType());
		if (request.getParameter("draw") != null) {
			System.out.println("draw显示不为空");
			if (session.getAttribute("uid") != null) {
				if (request.getParameter("draws").equals("单抽")) {
					int chance = 1;
					int userId = (int) session.getAttribute("uid");
					List<Role> list = service.draw(userId, chance);
					session.setAttribute("drole", list);
					response.sendRedirect("ArkNights.jsp");
					return;
				} else if (request.getParameter("draws").equals("十连")) {
					int chance = 10;
					int userId = (int) session.getAttribute("uid");
					List<Role> list = service.draw(userId, chance);
					session.setAttribute("drole", list);
					response.sendRedirect("ArkNights.jsp");
					return;
				}
			}

			response.sendRedirect("login.jsp");
			return;
		}
		if (request.getParameter("myroom") != null) {
			System.out.println("myroom显示不为空");
			UserService s=new UserService();
			int userId = (int) session.getAttribute("uid");
			s.my_house(userId);
			List<Role> list1 = s.my_house(userId);
			session.setAttribute("urole", list1);
			response.sendRedirect("userroom.jsp");
			return;
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
