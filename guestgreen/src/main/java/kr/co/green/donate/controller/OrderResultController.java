package kr.co.green.donate.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.co.green.common.AlertAndRedirect;
import kr.co.green.donate.model.dto.DonateDTO;
import kr.co.green.donate.model.service.DonateService;
import kr.co.green.donate.model.service.DonateServiceImpl;
import kr.co.green.project.model.dto.ProjectDTO;
import kr.co.green.project.model.service.ProjectService;
import kr.co.green.project.model.service.ProjectServiceImpl;


@WebServlet("/orderResult.do")
public class OrderResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderResultController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
		   BufferedReader reader = request.getReader();
		   while ((line = reader.readLine()) != null) {
			   jb.append(line);
		      }
		} catch (Exception e) {
			System.out.println("결제정보를 불러오는데 실패했습니다");
			e.printStackTrace();
			}
		            
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(jb.toString());
		JsonObject jsonObject = element.getAsJsonObject();

		String donateId = jsonObject.has("donate_id") ? jsonObject.get("donate_id").getAsString() : "";
		int projectNumber = jsonObject.has("project_no") ? jsonObject.get("project_no").getAsInt() : 0;
		int projectPrice = jsonObject.has("project_price") ? jsonObject.get("project_price").getAsInt() : 0;
		int memberNumber = jsonObject.has("member_no") ? jsonObject.get("member_no").getAsInt() : 0;
		
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectNumber(projectNumber);
		projectDTO.setProjectPrice(projectPrice);
		
		DonateDTO donateDTO = new DonateDTO();
		donateDTO.setProjectNumber(projectNumber);
		donateDTO.setMemberNumber(memberNumber);
		donateDTO.setDonateId(donateId);
		
		//project테이블에 후원자 수, 후원된 금액 올리기
		ProjectService projectService = new ProjectServiceImpl();
		int result1 = projectService.projectUpdate(projectDTO);
		
		if(result1>0) {
			//Donate 테이블에 데이터 올리기
			DonateService donateService = new DonateServiceImpl();
			int result2 = donateService.donateEnroll(donateDTO);
			if(result2>0) {
				AlertAndRedirect.alertRedirect(response, "DONATE테이블 등록 성공", "/");
			}
		}
		AlertAndRedirect.alertRedirect(response, "API에서 불러온 객체 PROJECT테이블 업데이트 실패 또는 DONATE테이블 등록 실패", "/");
	}

}










