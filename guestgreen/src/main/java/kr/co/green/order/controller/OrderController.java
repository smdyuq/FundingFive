package kr.co.green.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.common.AlertAndRedirect;
import kr.co.green.donation.dto.DonationDTO;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//주문페이지 요청
		HttpSession session = request.getSession();
		int projectNo = Integer.parseInt(request.getParameter("project-no"));
		
		if(projectNo == 0) {
			System.out.println("상품을 찾을 수 없습니다");
			AlertAndRedirect.alertRedirect(response, "상품을 찾을 수 없습니다.", "/");
		}
		
		//로그인 된 회원의 회원번호로
		int memberNo = (int)session.getAttribute("no");
		//주문번호를 매번 유니크하게 생성한다.
		long nano = System.currentTimeMillis();
		String paymentId = "pid-" + nano;
		
		//회원의 후원 이력을 등록한다.
		DonationDTO donationDTO = new DonationDTO();
		donationDTO.setMemberNo(memberNo);
		donationDTO.setProjectNo(projectNo);
		
//		DonationService donationService = new DonationServiceImpl();
//		int result = donationService.donationUpdate(donationDTO);
		
		//포트원SDK가 필요로하는 채널키 정보와 결제데이터 정보 추가
		String pgCode = "TC0ONETIME";
		String channelKey = "channel-key-d767166f-109d-45e1-804d-d51f1922fb7a";
		
		//스토어아이디
		request.setAttribute("storeId", "store-7dadb47c-0791-4955-b25e-29576fa9a712\r\n");
		//PG사 채널키
		request.setAttribute("channelKey", channelKey);
		//직연동 간편결제사 채널키
		
		//상점 주문번호
		
		//회원, 상품, 주문정보
		request.setAttribute("donationDTO", donationDTO);
		
		
		
	}

}









