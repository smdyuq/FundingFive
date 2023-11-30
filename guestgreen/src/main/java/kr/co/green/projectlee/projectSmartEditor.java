package kr.co.green.projectlee;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.co.green.member.model.dto.MemberDTO;
import kr.co.green.member.model.service.MemberServiceImpl;
import kr.co.green.projectlee.dto.ProjectleeDTO;
import kr.co.green.projectlee.service.ProjectleeserviceImpl;
import net.coobird.thumbnailator.Thumbnails;

@WebServlet("/smartEditor.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
		maxFileSize = 1024 * 1024 * 5, // 5MB
		maxRequestSize = 1024 * 1024 * 5 * 5 // 25MB
)
public class projectSmartEditor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public projectSmartEditor() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		int no = (int) session.getAttribute("no");
		MemberServiceImpl memberService = new MemberServiceImpl();
		MemberDTO memberDTO = memberService.selectMember(no);
		request.setAttribute("member", memberDTO);

		String projectContent = request.getParameter("editorTxt");

		ProjectleeserviceImpl projectservice = new ProjectleeserviceImpl();

		ProjectleeDTO projectleeDTO = new ProjectleeDTO();
		projectleeDTO.setProjectContent(projectContent);

		int projectNo = projectservice.projectManagerNoSelect();

//		프로젝트 스토리(상세내용) 등록
		int result = projectservice.projectContentUpdate(projectleeDTO, projectNo);

		if (result > 0) {
			RequestDispatcher view = request.getRequestDispatcher("/views/project/projectManagerEnroll.jsp");

			view.forward(request, response);
		} else {
			response.sendRedirect("/views/common/error.jsp");
		}

	}

}
