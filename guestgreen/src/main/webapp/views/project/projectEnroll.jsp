<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<main>
		<section>
			<div class="project-enroll-form">
				<h2>프로젝트 등록</h2>
				<hr>
				<form action="/projectEnroll.do" method="post"
					enctype="multipart/form-data">

					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">프로젝트
							이름 </label> <input type="text" class="form-control"
							id="exampleFormControlInput1" name="project-name"
							placeholder="프로젝트 이름을 작성해주세요." required> <label
							for="exampleFormControlInput1" class="form-label">프로젝트 소개
						</label> <input type="text" class="form-control"
							id="exampleFormControlInput1" name="project-introduce"
							placeholder="프로젝트 소개를 작성해주세요." required> <input
							type="hidden" class="form-control" id="exampleFormControlInput1"
							name="project-content" placeholder="프로젝트 상세내용을 작성해주세요." disabled>
						<label for="exampleFormControlInput1" class="form-label">프로젝트
							카테고리 </label><select class="form-select"
							aria-label="Default select example" name="project-kind">
							<option selected>카테고리를 선택해주세요.</option>					
							<option value="가전">가전</option>
							<option value="의류">의류</option>
							<option value="뷰티">뷰티</option>
							<option value="푸드">푸드</option>
							<option value="주얼리">주얼리</option>
						</select> <label for="exampleFormControlInput1" class="form-label">프로젝트
							가격 </label> <input type="text" class="form-control"
							id="exampleFormControlInput1" name="project-price"
							placeholder="프로젝트 가격을 작성해주세요." required> <label
							for="exampleFormControlInput1" class="form-label">프로젝트 목표
							후원금액 </label> <input type="text" class="form-control"
							id="exampleFormControlInput1" name="project_target_amount"
							placeholder="프로젝트 목표 후원금액을 작성해주세요." required> <label
							for="exampleFormControlInput1" class="form-label">프로젝트
							마감일 </label> <input type="date" class="form-control"
							id="exampleFormControlInput1" name="project-end-date" required>
						<label for="exampleFormControlInput1" class="form-label">프로젝트
							메인 이미지 </label> <input type="file" class="form-control"
							id="exampleFormControlInput1" name="project_outer_image" required>
						<label for="exampleFormControlInput1" class="form-label">프로젝트
							상세 이미지</label> <input type="file" class="form-control"
							id="exampleFormControlInput1" name="project_inner_image" required><br>

						<button class="btn btn-primary" type="submit">다음</button>
					</div>

				</form>
			</div>
		</section>
	</main>
	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>