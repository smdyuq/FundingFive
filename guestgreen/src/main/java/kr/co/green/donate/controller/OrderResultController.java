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
		int projectNo = jsonObject.has("project_no") ? jsonObject.get("project_no").getAsInt() : 0;
		int projectPrice = jsonObject.has("project_price") ? jsonObject.get("project_price").getAsInt() : 0;
		int memberNo = jsonObject.has("member_no") ? jsonObject.get("member_no").getAsInt() : 0;
		int projectCurrentAmount = jsonObject.has("project_current_amount") ? jsonObject.get("project_current_amount").getAsInt() : 0;
		int projectTargetAmount = jsonObject.has("project_target_amount") ? jsonObject.get("project_target_amount").getAsInt() : 0;
		String memberAddr = jsonObject.has("member_addr") ? jsonObject.get("member_addr").getAsString() : "";
		String memberPhone = jsonObject.has("member_phone") ? jsonObject.get("member_phone").getAsString() : "";
		String memberName = jsonObject.has("member_name") ? jsonObject.get("member_name").getAsString() : "";
		
		ProjectService projectService = new ProjectServiceImpl();
		
		//달성률 업데이트를 위한 달성률 가져오기
		
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectNo(projectNo);
		projectDTO.setProjectPrice(projectPrice);
		projectDTO.setProjectCurrentAmount(projectCurrentAmount + projectPrice);
		
		projectDTO.setProjectCurrentPercentage((double)projectDTO.getProjectCurrentAmount()/projectTargetAmount*100);
		
		DonateDTO donateDTO = new DonateDTO();
		donateDTO.setProjectNo(projectNo);
		donateDTO.setMemberNo(memberNo);
		donateDTO.setDonateId(donateId);
		donateDTO.setMemberName(memberName);
		donateDTO.setMemberAddr(memberAddr);
		donateDTO.setMemberPhone(memberPhone);
		
		//project테이블에 후원자 수, 후원된 금액 갱신
		int projectUpdate = projectService.projectUpdate(projectDTO);
		
		if(projectUpdate>0) {
			//Donate 테이블에 데이터 올리기
			DonateService donateService = new DonateServiceImpl();
			int donateEnroll = donateService.donateEnroll(donateDTO);
			if(donateEnroll>0) {
				AlertAndRedirect.alertRedirect(response, "결제가 완료되었습니다.", "/");
			}else{
				AlertAndRedirect.alertRedirect(response, "DONATE테이블 등록 실패", "/");
			}
		}else {
			AlertAndRedirect.alertRedirect(response, "API에서 불러온 객체 PROJECT테이블 업데이트 실패", "/");
		}
	}

}










