package kr.co.green.project.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.donate.model.dto.DonateDTO;
import kr.co.green.donate.model.service.DonateService;
import kr.co.green.donate.model.service.DonateServiceImpl;
import kr.co.green.member.controller.PhoneController;
import kr.co.green.project.model.service.ProjectService;
import kr.co.green.project.model.service.ProjectServiceImpl;


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
		int projectNo = Integer.parseInt(request.getParameter("project-no"));
		
		if(status.equals("success")){	//관리자페이지에서 성공한 프로젝트 클릭 시
			class EmailManager{
				
				class MailAuth extends Authenticator{		//인증용 파일
					PasswordAuthentication pa;
					public MailAuth() {
						String mailId = "nobuts98@gmail.com";
						String mailPwd = request.getParameter("google-api-secret-key");	
						System.out.println(mailId);
						System.out.println(mailPwd);
						System.out.println("");
						pa = new PasswordAuthentication(mailId, mailPwd);
					}
					public PasswordAuthentication getPasswordAuthentication() {
						return pa;
					}
				}
				
				void sendEmailManager() {
					Properties prop = System.getProperties();
					
					prop.put("mail.smtp.ssl.ciphersuites", "TLS_AES_128_GCM_SHA256");  // 암호 스위트를 명시적으로 지정
					prop.put("mail.smtp.starttls.enable", "true");	//로그인 시 TLS를 사용할 것인지 설정
					prop.put("mail.smtp.host", "smtp.gmail.com");	//이메일 발송을 처리해줄 SMTP서버
					prop.put("mail.smtp.auth", "true");				// SMTP 서버의 인증을 사용한다는 의미
					prop.put("mail.smtp.port", "587");				// TLS의 포트번호는 587이다
					prop.put("mail.smtp.ssl.protocols", "TLSv1.3");  // TLS 프로토콜 버전을 명시적으로 지정
					
					Authenticator auth = new MailAuth();
					Session session = Session.getDefaultInstance(prop, auth);
					
					MimeMessage msg = new MimeMessage(session);
					try{
						msg.setSentDate(new Date());	//보내는 날짜 지정
						msg.setFrom(new InternetAddress("nobuts98@gmail.com", "관리자(나중에 웹사이트명으로 변경)"));	//발송자메일 / 보일 이름 지정
						
						ProjectService projectService = new ProjectServiceImpl();
						String projectManagerEmail = projectService.getProjectManagerEmail(projectNo);
						InternetAddress to = new InternetAddress(projectManagerEmail);	//수신자 메일
						
						msg.setRecipient(Message.RecipientType.TO, to);	//수신자 설정
						
						DonateService donateService = new DonateServiceImpl();
						ArrayList<DonateDTO> sponserList = donateService.getSponserInfo(projectNo);
						
						String managerMsg = "";
						for(int i=0; i<sponserList.size(); i++) {
							managerMsg += "\n" + "프로젝트 이름: " + sponserList.get(i).getProjectName() + "\n" +
												 "회원 이름: " + sponserList.get(i).getMemberName() + "\n" +
												 "회원 전화번호: " + sponserList.get(i).getMemberPhone() + "\n" +
												 "회원 전화번호: " + sponserList.get(i).getMemberAddr() + "\n" +
												 "----------------------------- \n";
						}
						msg.setSubject("프로젝트 목표금액 달성 및 후원자 정보입니다. ", "UTF-8");	//메일 제목 지정
						msg.setText("상품 제작 및 발송 후 운송장번호 전달해주세요.\n\n" + managerMsg, "UTF-8");	//메일 내용. 창작자는 프로젝트 상품을 후원자에게 발송 후 관리자에게 회원번호와 송장번호를 전달.
													//그 과정은 생략하며 이후 관리자는 후원자의 전화번호로 송장을 전달한다.
						Transport.send(msg);
					}catch (AddressException ae) {
						ae.printStackTrace();
					} catch (MessagingException me) {
						me.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
			EmailManager emailManager = new EmailManager();
			emailManager.sendEmailManager();
			ProjectService projectService = new ProjectServiceImpl();
        	projectService.projectExpire(projectNo);
        	
        	response.sendRedirect("/administratorOk.do?cpage=1");			
		}else if(status.equals("fail")){		//관리자페이지에서 실패한 프로젝트 클릭시
			//회원 전화번호 조회 후 플랫폼에서 묶어놨던 후원금액 환불 메세지 전송
			PhoneController phoneController = new PhoneController();
			phoneController.transferMessage(status, projectNo, request, response);
		}
	}

}
