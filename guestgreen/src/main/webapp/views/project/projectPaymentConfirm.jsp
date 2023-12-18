<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="/resources/css/common/common.css" rel="stylesheet" />
	<link href="/resources/css/project/projectDonate.css" rel="stylesheet" />
	<link href="/resources/css/project/projectPaymentConfirm.css" rel="stylesheet" />
	<%@include file="../../views/common/head.jsp"%>
</head>


<body>
   <%@include file="../../views/common/header.jsp"%>
   <%@include file="../../views/common/nav.jsp"%>
   <main>
      <div class="payment_container">
         <div class="payment0">후원 상세정보</div>
         <hr>
         <div class="payment1">
            <div>
               <p class="project-information">결제내역</p>
               <div class="project-information-div">
                  <p class="project-information-name">프로젝트 명</p>
                  <p>${projectName}</p>
                  <br>
                  <p class="project-information-name">가격</p>
                  <p>${projectPrice}</p>
                  <br>
                  <p class="project-information-name">구매일</p>
                  <c:set var="ymd" value="<%=new java.util.Date()%>" />
				  <fmt:formatDate value="${ymd}" pattern="yyyy-MM-dd" />
				  <p>${ymd}</p>
               </div>
            </div>
         </div>
         <div class="payment2">
            <div>
               <p class="project-information">배송지 정보</p>
               <div class="project-information-div">
                  <p class="project-information-name">이름</p>
                  <p>${memberName}</p>
                  
                  <p class="project-information-name">연락처</p>
                  <p>${memberPhone}</p>
                  
                  <p class="project-information-name">배송지</p>
                  <p>${memberAddr}</p>
                  
                  <p class="instructions">* 연락처 및 배송지 변경은 마이페이지에서 설정에서 가능합니다.</p>
               </div>
            </div>
         </div>
         <div class="payment3">
            <p class="project-information">결제 정보</p>
            <div class="project-information-div">
               <p class="project-information-name">카카오페이</p>
               <span class="payment_information">
                  <p>일시불</p>
               </span>
               <div class="jb-division-line"></div>
               <p class="project-information-name">결제금액</p>
               <p>${projectPrice}원</p>
               <br>
            </div>
         </div>
      </div>
   </main>

   <%@include file="../../views/common/common.jsp"%>
   <%@include file="../../views/common/footer.jsp"%>

</body>
</html>