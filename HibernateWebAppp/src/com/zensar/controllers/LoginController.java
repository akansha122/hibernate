package com.zensar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.daos.UserDao;
import com.zensar.daos.UserDaoImpl;
import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;
import com.zensar.services.UserService;
import com.zensar.services.UserServiceImpl;

/**
 * @author Akansha Shah
 * @version 2.0
 * @creation_date 28st sep 2019 11.50AM
 * @modification_date 28st sep 2019 11.50SAM
 * @copyright Zensar Technologies. All rights reserved.
 * @description: Servlet implementation class LoginController
 */

@WebServlet("/checkuser")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void init() throws ServletException {
		UserDao userDao = new UserDaoImpl();
		UserService userService = new UserServiceImpl();
		((UserServiceImpl) userService).setuserDao(userDao);
		setUserService(userService);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("passwd");

		User clientUser = new User();
		clientUser.setUsername(username);
		clientUser.setPassword(password);

		try {
			if (userService.validateUser(clientUser)) {
				// out.println("<p> Dear"+ username + " Welcome to online shopping</p>");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		} else {
				out.println("<p> Sorry! Invalid username/password</p>");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
