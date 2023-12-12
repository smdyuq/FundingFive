package kr.co.green.project.controller;

import java.awt.image.BufferedImage;
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
import javax.servlet.http.Part;

import kr.co.green.project.model.dto.ProjectDTO;
import net.coobird.thumbnailator.Thumbnails;

@WebServlet("/projectEnroll.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 30, // 2KB
		maxFileSize = 1024 * 1024 * 20, // 1KB
		maxRequestSize = 1024 * 1024 * 10 * 10 // 25MB
)
public class ProjectEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProjectEnrollController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 파일 업로드
		Collection<Part> parts = request.getParts();

		String uploadDirectory = "C:\\Users\\yh631\\git\\guestgreen\\guestgreen\\src\\main\\webapp\\resources\\uploads";

		// 파일 업로드하려는 디렉토리 없으면 생성
		File filePath = new File(uploadDirectory);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}

		String fileName = "";
		String[] fileNameArr = new String[2];
		int index = 0;
		for (Part part : parts) {
			if (getFileName(part) != null || !Objects.isNull(getFileName(part))) {
				fileName = getFileName(part);
				if (!fileName.equals("")) {
					fileNameArr[index] = fileName;
					if (index == 0) { // outer image
						System.out.println("a");
						part.write(filePath + File.separator + "outerimage" + File.separator + "180x153"
								+ File.separator + fileName);
						part.write(filePath + File.separator + "outerimage" + File.separator + "130x105"
								+ File.separator + fileName);
						part.write(filePath + File.separator + "outerimage" + File.separator + "230x185"
								+ File.separator + fileName);
						part.write(filePath + File.separator + "outerimage" + File.separator + "760x280"
								+ File.separator + fileName);
						part.write(filePath + File.separator + "outerimage" + File.separator + "160x120"
								+ File.separator + fileName);
						part.write(filePath + File.separator + "outerimage" + File.separator + "300x300"
								+ File.separator + fileName);
						System.out.println("b");
						resizeImage(uploadDirectory + "/outerimage/180x153/" + fileName, 180, 153);
						resizeImage(uploadDirectory + "/outerimage/130x105/" + fileName, 130, 105);
						resizeImage(uploadDirectory + "/outerimage/230x185/" + fileName, 230, 185);
						resizeImage(uploadDirectory + "/outerimage/760x280/" + fileName, 760, 280);
						resizeImage(uploadDirectory + "/outerimage/160x120/" + fileName, 160, 120);
						resizeImage(uploadDirectory + "/outerimage/300x300/" + fileName, 300, 300);
						System.out.println("c");
					} else { // inner image
						part.write(filePath + File.separator + "innerimage" + File.separator + fileName);

						resizeImage(uploadDirectory + "/innerimage/" + fileName, 500, 500);

					}

					index++;
					// 이미지 리사이징 (width X height)

				} else if (fileName.equals("")) {
					uploadDirectory = "";
				}
			} else {
				fileName = "";
			}
		}

		String projectName = request.getParameter("project-name");
		String projectIntroduce = request.getParameter("project-introduce");
		String projectKind = request.getParameter("project-kind");
		int projectPrice = Integer.parseInt(request.getParameter("project-price"));
		int projectTargetAmount = Integer.parseInt(request.getParameter("project_target_amount"));
		String projectEndDate = request.getParameter("project-end-date");
//		프로젝트 정보를 객체에 담아서 projectSmartEditor.jsp로 보냄
		ProjectDTO projectDTO = new ProjectDTO();

		projectDTO.setProjectName(projectName);
		projectDTO.setProjectIntroduce(projectIntroduce);
		projectDTO.setProjectKind(projectKind);
		projectDTO.setProjectPrice(projectPrice);
		projectDTO.setProjectTargetAmount(projectTargetAmount);
		projectDTO.setProjectEndDate(projectEndDate);
		projectDTO.setProjectOuterImageName(fileNameArr[0]);
		projectDTO.setProjectOuterImagePath(uploadDirectory);
		projectDTO.setProjectInnerImageName(fileNameArr[1]);
		projectDTO.setProjectInnerImagePath(uploadDirectory);

		request.setAttribute("projectDTO", projectDTO);
		RequestDispatcher view = request.getRequestDispatcher("/views/project/projectSmartEditor.jsp");
		view.forward(request, response);
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
		Thumbnails.of(new File(fileName)).size(targetWidth, targetHeight).toFile(new File(fileName));
	}
}
