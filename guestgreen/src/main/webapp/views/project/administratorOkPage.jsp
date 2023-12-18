<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
<script src="/resources/js/project/administratorOk.js"></script>
<link rel="stylesheet" href="/resources/css/project/administratorOkPage.css">

</head>
<body>

	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<main>
        <h2>상세보기</h2>
        <hr class="thick-line">
        <form id="project-administratorok-form">

            <h3 class="adminOkPage_project_informationtitle">프로젝트 정보</h3>
            <div class="mb-3">
                <div class="adminOkPage_project_information">
                    <input type="hidden" name="projectNo" value="${projectDTO.projectNo }"> 
                    <label for="exampleFormControlInput1" class="form-label">프로젝트 이름 </label><br>
                    <input type="text" class="form-control" id="exampleFormControlInput1" name="project-name"
                        value="${ projectDTO.projectName}" disabled><br>


                    <label for="exampleFormControlInput1" class="form-label">프로젝트 소개 </label><br>
                    <input type="text" class="form-control" id="exampleFormControlInput1" name="project-introduce"
                        value="${ projectDTO.projectIntroduce}" disabled><br>

                    <label for="exampleFormControlInput1" class="form-label">프로젝트 내용 </label><br>
                    <div class="project-content" name="project-content">${projectDTO.projectContent }</div>


                    <label for="exampleFormControlInput1" class="form-label">프로젝트 카테고리 </label><br>
                    <input type="text" class="form-control" id="exampleFormControlInput1" name="project-kind"
                        value="${ projectDTO.projectKind}" disabled><br>

                    <label for="exampleFormControlInput1" class="form-label">프로젝트 가격 </label><br>
                    <input type="text" class="form-control" id="exampleFormControlInput1" name="project-price"
                        value="${ projectDTO.projectPrice}" disabled><br>


                    <label for="exampleFormControlInput1" class="form-label">프로젝트 목표 후원금액 </label><br>
                    <input type="text" class="form-control" id="exampleFormControlInput1" name="project-target_amount"
                        value="${ projectDTO.projectTargetAmount}" disabled><br>

                    <label for="exampleFormControlInput1" class="form-label">프로젝트 마감일
                    </label> <br><input type="text" class="form-control" id="exampleFormControlInput1"
                        name="project-end-date" value="${ projectDTO.projectEndDate}" disabled><br>

                    <label for="exampleFormControlInput1" class="form-label">프로젝트 이미지 </label> <br> 
                    <img class="form-label-img" src="/resources/uploads/outerimage/300x300/${projectDTO.projectOuterImageName }"><br>
                </div>
                <hr class="thick-line">

                <h3 class="adminOkPage_project_informationtitle">창작자 정보</h3>

                <label for="exampleFormControlInput1" class="form-label">창작자명</label><br>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="manager-name"
                    value="${ projectDTO.projectManagerName}" disabled><br>

                <label for="exampleFormControlInput1" class="form-label">창작자 소개 </label> <br>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="manager-introduce"
                    value="${ projectDTO.projectManagerIntroduce}" disabled><br>

                <label for="exampleFormControlInput1" class="form-label">창작자 계좌 </label><br>
                 <input type="text"
                    class="form-control" id="exampleFormControlInput1" name="manager-account"
                    value="${ projectDTO.projectManagerAccount}" disabled><br>

                <label for="exampleFormControlInput1" class="form-label">창작자 프로필 사진 </label> <br> 
                <img class="form-label-img" src="/resources/uploads/managerimage/${projectDTO.projectManagerImageName }"><br>

                <br>

                <div class="next_btn_div">
                    <button class="btn-btn-primary" type="button" onclick="yesButton()">승인</button>
                    <button class="btn-btn-primary" type="button" onclick="noButton()">거절</button>
                </div>
            </div>
        </form>
    </main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>