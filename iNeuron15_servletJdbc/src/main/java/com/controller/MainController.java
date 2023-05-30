package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.StudentServiceFactory;
import com.model.Student;
import com.service.IStudentService;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/controller")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainController() {
		super();
	}

	private IStudentService service = StudentServiceFactory.getStudentService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Request UI Path : " + request.getRequestURI());
		if (request.getRequestURI().endsWith("controller")) {
			String sname = request.getParameter("name");
			String saddress = request.getParameter("saddress");
			String sage = request.getParameter("sage");

			Student stu = new Student();
			stu.setSname(sname);
			stu.setSage(Integer.parseInt(sage));
			stu.setSaddress(saddress);

			String status = service.addData(stu);
			System.out.println("submitted data");
			RequestDispatcher rd = null;
			request.setAttribute("status", "success");
			rd = request.getRequestDispatcher("./disp.jsp");
			rd.forward(request, response);
		}
	}
}
