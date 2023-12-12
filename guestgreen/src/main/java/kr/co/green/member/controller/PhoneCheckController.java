package kr.co.green.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/PhoneCheck.do")
public class PhoneCheckController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String authNum = (String) session.getAttribute("authNum");
        String inputNum = request.getParameter("inputNum");

        if (authNum.equals(inputNum)) {
            // 인증 성공
            response.getWriter().write("success");
        } else {
            // 인증 실패
            response.getWriter().write("failed");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

