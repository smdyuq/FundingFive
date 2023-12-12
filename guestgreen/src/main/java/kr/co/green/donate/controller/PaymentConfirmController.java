package kr.co.green.donate.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/paymentConfirm.do")
public class PaymentConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaymentConfirmController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("projectName", request.getParameter("project_name"));
		request.setAttribute("projectPrice", Integer.parseInt(request.getParameter("project_price")));
		request.setAttribute("memberName", request.getParameter("member_name"));
		request.setAttribute("memberPhone", request.getParameter("member_phone"));
		request.setAttribute("memberAddr", request.getParameter("member_addr"));
		
		RequestDispatcher view = request.getRequestDispatcher("/views/project/projectPaymentConfirm.jsp");
		view.forward(request, response);
	}

}
