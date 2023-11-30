package kr.co.green.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.co.green.project.model.dto.ProjectDTO;
import kr.co.green.project.model.service.ProjectService;
import kr.co.green.project.model.service.ProjectServiceImpl;
import net.coobird.thumbnailator.Thumbnails;

@WebServlet("/projectManagerEnroll.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
		maxFileSize = 1024 * 1024 * 5, // 5MB
		maxRequestSize = 1024 * 1024 * 5 * 5 // 25MB
)
public class ProjectManagerEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProjectManagerEnrollController() {
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

		String projectManagerName = request.getParameter("project-manager-name");
		String projectManagerIntroduce = request.getParameter("project-manager-introduce");
		String projectManagerAccount = request.getParameter("project-manager-account");

		// 파일 업로드
		Collection<Part> parts = request.getParts();
		String uploadDirectory = "C:\\Users\\tmddu\\git\\guestgreen\\guestgreen\\src\\main\\webapp\\resources\\uploads";

		// 파일 업로드하려는 디렉토리 없으면 생성
		File filePath = new File(uploadDirectory);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}

		String fileName = "";
		for (Part part : parts) {

			if (getFileName(part) != null || !Objects.isNull(getFileName(part))) {
				fileName = getFileName(part);
				if (!fileName.equals("")) {
					part.write(filePath + File.separator + fileName);
					// 이미지 리사이징 (100 X 100)					
					resizeImage(uploadDirectory + "\\" + fileName, 100, 100);
				} else if (fileName.equals("")) {
					uploadDirectory = "";
				}
			} else {
				fileName = "";
			}
		}

		ProjectDTO projectleeDTO = new ProjectDTO();

		projectleeDTO.setProjectManagerName(projectManagerName);
		projectleeDTO.setProjectManagerIntroduce(projectManagerIntroduce);
		projectleeDTO.setProjectMangerAccount(projectManagerAccount);
		projectleeDTO.setProjectManagerImageName(fileName);
		projectleeDTO.setProjectManagerImagePath(uploadDirectory);

		ProjectService projectleeservice = new ProjectServiceImpl();

//		프로젝트 번호 조회
		int projectNo = projectleeservice.projectManagerNoSelect();

//		창작자 등록
		int result2 = projectleeservice.projectManagerEnroll(projectleeDTO, no, projectNo);

		if (result2 > 0) {
			response.sendRedirect("/form/homeform.do");
		} else {
			response.sendRedirect("/views/common/error.jsp");

		}
	}

	// 파일 이름 가지고 오는 메소드
	private String getFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");

		// 세미콜론을 기준으로 토큰을 나눠 배열로 저장
		String[] tokens = contentDisposition.split(";");

		// 토큰을 하나씩 꺼내면서 토큰의 이름이 filename으로
		// 시작하는걸 찾을때 까지 반복
		for (String token : tokens) {
			// 토큰의 이름이 filename으로 시작하는지 확인
			if (token.trim().startsWith("filename")) {

				// 파일의 이름이 "filename=" 다음에 나오기 때문에
				// "filename=" 의 다음 문자부터 끝까지 추출
				return token.substring(token.indexOf('=') + 2, token.length() - 1);
			}
		}
		return null;
	}

	// 이미지 리사이징
	void resizeImage(String fileName, int targetWidth, int targetHeight) throws IOException {
		File testFile = new File("thumbnail.jpg");
		System.out.println(testFile);
		Thumbnails.of(new File(fileName)).size(targetWidth, targetHeight).toFile(new File(fileName));

	}

}
