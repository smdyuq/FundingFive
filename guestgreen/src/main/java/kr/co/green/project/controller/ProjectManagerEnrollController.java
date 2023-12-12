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

import kr.co.green.common.AlertAndRedirect;
//github.com/smdyuq/guestgreen.git
import kr.co.green.project.model.dto.ProjectDTO;
import kr.co.green.project.model.service.ProjectService;
import kr.co.green.project.model.service.ProjectServiceImpl;
import net.coobird.thumbnailator.Thumbnails;

@WebServlet("/projectManagerEnroll.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 1MB
		maxFileSize = 1024 * 1024 * 5 * 10, // 5MB
		maxRequestSize = 1024 * 1024 * 10 * 10 // 25MB
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

		HttpSession session = request.getSession();
		int memberNo = (int) session.getAttribute("memberNo");

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
					part.write(filePath + File.separator + "managerimage" + File.separator + fileName);

					// 이미지 리사이징 (managerImage) (width X height)
					resizeImage(uploadDirectory + "/managerimage/" + fileName, 120, 120);

				} else if (fileName.equals("")) {
					uploadDirectory = "";
				}
			} else {
				fileName = "";
			}
		}

		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectName(request.getParameter("project-name"));
		projectDTO.setProjectIntroduce(request.getParameter("project-introduce"));
		projectDTO.setProjectKind(request.getParameter("project-kind"));
		projectDTO.setProjectPrice(Integer.parseInt(request.getParameter("project-price")));
		projectDTO.setProjectTargetAmount(Integer.parseInt(request.getParameter("project-target-amount")));
		projectDTO.setProjectEndDate(request.getParameter("project-end-date"));
		projectDTO.setProjectOuterImageName(request.getParameter("project-outer-image-name"));
		projectDTO.setProjectOuterImagePath(request.getParameter("project-outer-image-path"));
		projectDTO.setProjectInnerImageName(request.getParameter("project-inner-image-name"));
		projectDTO.setProjectInnerImagePath(request.getParameter("project-inner-image-path"));
		projectDTO.setProjectContent(request.getParameter("project-content"));
		projectDTO.setProjectManagerName(request.getParameter("project-manager-name"));
		projectDTO.setProjectManagerIntroduce(request.getParameter("project-manager-introduce"));
		projectDTO.setProjectManagerAccount(request.getParameter("project-manager-account"));
		projectDTO.setProjectManagerImageName(fileName);
		projectDTO.setProjectManagerImagePath(uploadDirectory);

		ProjectService projectService = new ProjectServiceImpl();

		if (projectService.projectEnroll(projectDTO) > 0) { // 1. 프로젝트 등록하기
			int projectNo = projectService.projectNoSelect(); // 2. 등록한 프로젝트의 번호 가져오기
			if (projectNo != 0) {
				if (projectService.innerimageEnroll(projectDTO, projectNo) > 0) { // 3. 프로젝트 내부이미지 등록하기
					if (projectService.projectManagerEnroll(projectDTO, memberNo, projectNo) > 0) { // 4. 프로젝트 창작자 정보
																									// 등록하기
						AlertAndRedirect.alertRedirect(response, "관리자가 승인하면 프로젝트가 등록됩니다.", "/");
					}
				}
			}

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
