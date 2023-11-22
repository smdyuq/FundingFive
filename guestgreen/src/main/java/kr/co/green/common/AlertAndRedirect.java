package kr.co.green.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AlertAndRedirect")
public class AlertAndRedirect extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public AlertAndRedirect() {
        super();
    }

    public static void alertRedirect(HttpServletResponse response, String msg, String url) throws IOException {
      PrintWriter out = response.getWriter();
      out.println("<script>"
            + "location.href='" + url + "';"
            + "alert('" + msg + "')"
            + "</script>");
      out.flush();
      out.close();
   }
    
    

}