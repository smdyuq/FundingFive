<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<%@include file="../../views/common/head.jsp"%>

<style>
.project-enroll-form {
	padding-left: 10%;
	padding-right: 10%;
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
	background-color: white;
}

/* 날짜 인풋박스 */
.form-control_date {
	width: 17%;
	height: 30px;
	margin-top: 2%;
	margin-bottom: 4%;
	border: none;
	border-bottom: 1px solid black;
	margin-bottom: 4%;
}

/* 파일 인풋박스 */
.form-file-control {
	width: 50%;
	height: 30px;
	margin-top: 2%;
	margin-bottom: 4%;
}

.form-select {
	width: 100%;
	height: 30px;
	margin-top: 2%;
	margin-bottom: 40px;
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
	margin-bottom: 5%;
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
	width: 20%; padding-top : 10px; padding-bottom : 10px;
	transition: background-color 0.3s ease;
	min-height: 30px;
	padding-top: 10px;
	padding-bottom: 10px; /* 트랜지션 효과 추가 */
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
			<div class="project-enroll-form">
				<h2>프로젝트 등록</h2>
				<hr class="thick-line">
				<form action="/projectEnroll.do" method="post"
					enctype="multipart/form-data">


					<div class="project_content_div">
						<div>
							<label class="form-label">프로젝트 이름 </label><br> <input
								type="text" class="form-control" id="exampleFormControlInput1"
								name="project-name" placeholder="프로젝트 이름을 작성해주세요." required>
						</div>

						<div>
							<label class="form-label">프로젝트 소개 </label><br> <input
								type="text" class="form-control" id="exampleFormControlInput1"
								name="project-introduce" placeholder="프로젝트 소개를 작성해주세요." required>
							<input type="hidden" class="form-control"
								id="exampleFormControlInput1" name="project-content"
								placeholder="프로젝트 상세내용을 작성해주세요." disabled>
						</div>

						<div>
							<label class="form-label">프로젝트 카테고리 </label><br> <select
								class="form-select" aria-label="Default select example"
								name="project-kind">
								<option selected>카테고리를 선택해주세요.</option>
								<option value="가전">가전</option>
								<option value="의류">의류</option>
								<option value="뷰티">뷰티</option>
								<option value="푸드">푸드</option>
								<option value="주얼리">주얼리</option>
								<option value="크리스마스">크리스마스</option>
							</select>
						</div>

						<div>
							<label class="form-label">프로젝트 가격 </label> <br> <input
								type="text" class="form-control" id="exampleFormControlInput1"
								name="project-price" placeholder="프로젝트 가격을 작성해주세요." required>
						</div>

						<div>
							<label class="form-label">프로젝트 목표 후원금액 </label> <br> <input
								type="text" class="form-control" id="exampleFormControlInput1"
								name="project_target_amount" placeholder="프로젝트 목표 후원금액을 작성해주세요."
								required>
						</div>

						<div>
							<label class="form-label">프로젝트 마감일 </label> <br> <input
								type="date" class="form-control_date"
								id="exampleFormControlInput1" name="project-end-date" required>
						</div>

						<div class="file-input-container">
							<label class="form-label-image">프로젝트 메인 이미지 </label>
							<div class="jb-text">이 이미지는 홈페이지 메인에 보일 이미지 입니다.</div>


							<br> <input type="file" class="form-file-control"
								id="exampleFormControlInput1" name="project_outer_image"
								required>
						</div>

						<div class="file-input-container">
							<label class="form-label-image">프로젝트 상세 이미지 </label>
							<div class="jb-text">이 이미지는 상세 페이지 상단에 보일 이미지 입니다.</div>

							<br> <input type="file" class="form-file-control"
								id="exampleFormControlInput1" name="project_inner_image"
								required><br>
						</div>

						<div>
							<div class="next_btn_div">
								<button class="next_btn" type="submit">다음</button>
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