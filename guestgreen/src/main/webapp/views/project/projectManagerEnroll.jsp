<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
<style>
.project-manager-enroll-form {
	width: 80%;
	margin: 0 auto;
}

.form-label {
	font-size: 17px;
}

.thick-line {
	border-top: 2px solid #000;
	margin-bottom: 40px;
	margin-top: 3%;
}

/* 텍스트 인풋박스 */
.form-control {
	width: 100%;
	height: 30px;
	margin-top: 2%;
	margin-bottom: 4%;
	border: none;
	border-bottom: 1px solid black;
}

/* 파일 인풋박스 */
.form-file-control {
	width: 50%;
	height: 30px;
}

.file-input-container>input {
	border: none;
	margin-top: 2%;
	margin-bottom: 4%;
}

.form-select {
	width: 100%;
	height: 30px;
	margin-top: 2%;
	margin-bottom: 2%;
}

/* 파일 인풋박스 */
input[type=file]::file-selector-button {
	width: 150px;
	height: 30px;
	background: #fff;
	border: 1px solid rgb(77, 77, 77);
	border-radius: 10px;
	cursor: pointer; &: hover { background : rgb( 77, 77, 77);
	color: #fff;
}

}

/* 다음 버튼 */
.next_btn_div {
	margin-top: 3%;
	margin-bottom: 3%;
	display: flex;
	height: auto;
	justify-content: center;
}

.next_btn {
	font-style:;
	background-color: #00E7AF;
	color: black;
	box-shadow: rgba(0, 0, 0, 0.05) 0px 1px 8px;
	border: none;
	border-radius: 10px;
	width: 20%;
	padding-top: 10px;
	padding-bottom: 10px;
	transition: background-color 0.3s ease;
	min-height: 30px; /* 트랜지션 효과 추가 */
}

.next_btn:hover {
	background-color: rgba(0, 231, 175, 0.6); /* 흐려진 색상으로 변경 */
}

.jb-text {
	padding: 15px 20px;
	background-color: #444444;
	border-radius: 5px;
	color: #ffffff;
	position: absolute;
	display: none;
}

.form-label-image:hover+.jb-text {
	display: block;
}
</style>
</head>
<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<main>
		<section>
			<div class="project-manager-enroll-form">
				<h2>창작자 등록</h2>
				<hr class="thick-line">
				<form action="/projectManagerEnroll.do" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="project-name"
						value="${projectDTO.projectName}"> <input type="hidden"
						name="project-introduce" value="${projectDTO.projectIntroduce}">
					<input type="hidden" name="project-kind"
						value="${projectDTO.projectKind}"> <input type="hidden"
						name="project-price" value="${projectDTO.projectPrice}"> <input
						type="hidden" name="project-target-amount"
						value="${projectDTO.projectTargetAmount}"> <input
						type="hidden" name="project-end-date"
						value="${projectDTO.projectEndDate}"> <input type="hidden"
						name="project-outer-image-name"
						value="${projectDTO.projectOuterImageName}"> <input
						type="hidden" name="project-outer-image-path"
						value="${projectDTO.projectOuterImagePath}"> <input
						type="hidden" name="project-inner-image-name"
						value="${projectDTO.projectInnerImageName}"> <input
						type="hidden" name="project-inner-image-path"
						value="${projectDTO.projectInnerImagePath}"> <input
						type="hidden" name="project-content"
						value='${projectDTO.projectContent}'>

					<div class="project_content_div">

						<div>
							<label for="exampleFormControlInput1" class="form-label">프로젝트
								창작자 이름 </label> <input type="text" class="form-control"
								id="exampleFormControlInput1" name="project-manager-name"
								placeholder="창작자 이름을 작성해주세요." required>
						</div>

						<div>
							<label for="exampleFormControlInput1" class="form-label">프로젝트
								창작자 소개 </label> <input type="text" class="form-control"
								id="exampleFormControlInput1" name="project-manager-introduce"
								placeholder="창작자 소개를 작성해주세요." required>
						</div>

						<div>
							<label for="exampleFormControlInput1" class="form-label">프로젝트
								창작자 계좌 </label> <input type="text" class="form-control"
								id="exampleFormControlInput1" name="project-manager-account"
								placeholder="창작자 계좌 작성해주세요." required>
						</div>

						<div class="file-input-container">
							<label for="exampleFormControlInput1" class="form-label-image">프로젝트
								창작자 프로필 이미지 </label>
							<div class="jb-text">이 이미지는 창작자의 프로필 이미지 입니다.</div>
							<input type="file" class="form-control"
								id="exampleFormControlInput1" name="project_manager_image"
								required>
						</div>

						<div>
							<div class="next_btn_div">
								<button class="next_btn" type="submit">등록</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</section>
	</main>
	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>
