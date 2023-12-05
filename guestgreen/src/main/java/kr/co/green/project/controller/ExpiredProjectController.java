package kr.co.green.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/expiredProject.do")
public class ExpiredProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExpiredProjectController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		
		if(status.equals("success")) {
			
		}else if(status.equals("fail")) {
			
		}
	}

}
