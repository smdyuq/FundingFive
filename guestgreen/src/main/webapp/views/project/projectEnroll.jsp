<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<%@include file="../../views/common/head.jsp"%>
<style>
.form-label {
	font-size: 17px;
}

/* 텍스트 인풋박스 */
.project_content_div>div>input {
	width: 100%;
	height: 30px;
	margin-top: 2%;
	margin-bottom: 2%;
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
.next_btn {
	margin-top: 5%;
	padding: 10px 15px 10px 15px; /* 상단 우측 하단 좌측 */
	font-size: 15px;
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
                <hr>
                <form action="/projectEnroll.do" method="post" enctype="multipart/form-data">

                    <div class="project_content_div">
                        <div>
                            <label class="form-label">프로젝트 이름 </label><br>
                            <input type="text" class="form-control" id="exampleFormControlInput1" name="project-name"
                                placeholder="프로젝트 이름을 작성해주세요." required>
                        </div>

                        <div>
                            <label class="form-label">프로젝트 소개 </label><br>
                            <input type="text" class="form-control" id="exampleFormControlInput1"
                                name="project-introduce" placeholder="프로젝트 소개를 작성해주세요." required> <input type="hidden"
                                class="form-control" id="exampleFormControlInput1" name="project-content"
                                placeholder="프로젝트 상세내용을 작성해주세요." disabled>
                        </div>

                        <div>
                            <label class="form-label">프로젝트 카테고리 </label><br>
                            <select class="form-select" aria-label="Default select example" name="project-kind">
                                <option selected>카테고리를 선택해주세요.</option>
                                <option value="Entire">전체</option>
                                <option value="Home Appliances">가전</option>
                                <option value="Clothes">의류</option>
                                <option value="Perfume and Beauty">향수·뷰티</option>
                                <option value="Food">푸드</option>
                                <option value="Jewelry">주얼리</option>
                            </select>
                        </div>

                        <div>
                            <label class="form-label">프로젝트 가격 </label> <br>
                            <input type="text" class="form-control" id="exampleFormControlInput1" name="project-price"
                                placeholder="프로젝트 가격을 작성해주세요." required>
                        </div>

                        <div>
                            <label class="form-label">프로젝트 목표 후원금액 </label> <br>
                            <input type="text" class="form-control" id="exampleFormControlInput1"
                                name="project_target_amount" placeholder="프로젝트 목표 후원금액을 작성해주세요." required>
                        </div>

                        <div>
                            <label class="form-label">프로젝트 마감일 </label> <br>
                            <input type="date" class="form-control" id="exampleFormControlInput1"
                                name="project-end-date" required>
                        </div>

                        <div class="file-input-container">
                            <label class="form-label">프로젝트 메인 이미지 </label> <br>
                            <input type="file" class="form-file-control" id="exampleFormControlInput1"
                                name="project_outer_image" required>
                        </div>

                        <div class="file-input-container">
                            <label class="form-label">프로젝트 상세 이미지</label> <br>
                            <input type="file" class="form-file-control" id="exampleFormControlInput1"
                                name="project_inner_image" required><br>
                        </div>

                        <button class="next_btn" type="submit">다음</button>
                    </div>

                </form>
            </div>
        </section>
    </main>
	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>