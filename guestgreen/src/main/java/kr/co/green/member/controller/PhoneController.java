package kr.co.green.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.donate.model.dto.DonateDTO;
import kr.co.green.donate.model.service.DonateService;
import kr.co.green.donate.model.service.DonateServiceImpl;
import kr.co.green.project.model.service.ProjectService;
import kr.co.green.project.model.service.ProjectServiceImpl;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;


@WebServlet("/sendSMS.do")
public class PhoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String status = null;
	int projectNo = 0;
    public PhoneController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	DefaultMessageService messageService =  NurigoApp.INSTANCE.initialize("", "", "https://api.coolsms.co.kr");
        																	//API키, API 시크릿 키
        Message message = new Message();
        if(status.equals(null)) {
        	String memberPhone = request.getParameter("memberPhone");
	        
	        Random rand  = new Random();
	        String numStr = "";
	        for(int i=0; i<4; i++) {
	            String ran = Integer.toString(rand.nextInt(10));
	            numStr+=ran;
	        }
	        
	        message.setFrom("");
	        message.setTo(memberPhone);
	        message.setText("인증번호 : " + "["+numStr+"]" + "입니다." + "인증번호를 정확히 입력해주세요."); //어떤 내용을 보낼건지 
	        
	        try {
          	messageService.send(message);
      	} catch (NurigoMessageNotReceivedException exception) {
         	 	System.out.println(exception.getFailedMessageList());
          	System.out.println(exception.getMessage());
      	} catch (Exception exception) {
          	System.out.println(exception.getMessage());
      	}
	        
	        // 인증번호를 세션에 저장
	        PrintWriter out = response.getWriter();
	        out.print(numStr);
	        
	        out.flush();
	        out.close();
	        
        }else if(status.equals("fail")) {
        	
        	DonateService donateService = new DonateServiceImpl();
        	ArrayList<DonateDTO> sponserList = donateService.getSponserInfo(projectNo);
        	
        	message.setFrom("");	//발신자 번호
        	for(int i=0; i<sponserList.size(); i++) {
    	        message.setTo(sponserList.get(i).getMemberPhone());
    	        message.setText(sponserList.get(i).getMemberName() + "님, " 
	        			  + sponserList.get(i).getProjectName() + "프로젝트가 달성 미달."
	        			  + sponserList.get(i).getProjectPrice() + "원 환불예정."); //어떤 내용을 보낼건지 
              try {
	              messageService.send(message);
	          } catch (NurigoMessageNotReceivedException exception) {
	              System.out.println(exception.getFailedMessageList());
	              System.out.println(exception.getMessage());
	          } catch (Exception exception) {
	              System.out.println(exception.getMessage());
	          }
        	}
        	
        	ProjectService projectService = new ProjectServiceImpl();	//프로젝트 승인유무 'N'으로 변경
        	projectService.projectExpire(projectNo);
        	response.sendRedirect("/administratorOk.do?cpage=1");
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void transferMessage(String status, int projectNo, HttpServletRequest request, HttpServletResponse response) {
		this.status = status;
		this.projectNo = projectNo;
		try {
			doGet(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("dsdsdsdsd");
			e.printStackTrace();
		}
	}

}
