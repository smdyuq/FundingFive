<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@include file="../../views/common/head.jsp"%>
	<link rel="stylesheet" href="/resources/css/common/header.css">
	<link rel="stylesheet" href="/resources/css/common/nav.css">
	<link rel="stylesheet" href="/resources/css/common/footer.css">
	<!-- jQuery -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<!-- iamport.payment.js -->
	<script type="text/javascript"
		src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	<!-- 	axios -->
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	
	<script>
		var IMP = window.IMP;
		IMP.init("imp57550081");
	
		var today = new Date();
		var hours = today.getHours(); // 시
		var minutes = today.getMinutes(); // 분
		var seconds = today.getSeconds(); // 초
		var milliseconds = today.getMilliseconds();
		var makeMerchantUid = '' + hours + minutes + seconds + milliseconds;
	
		function requestPay() {
			IMP.request_pay({
				pg : "kakaopay.TC0ONETIME",
				pay_method : 'card',
				merchant_uid : "IMP" + makeMerchantUid,
				name : '당근 10kg',
				amount : 100,
				buyer_email : 'Iamport@chai.finance',
				buyer_name : '아임포트 기술지원팀',
				buyer_tel : '010-1234-5678',
				buyer_addr : '서울특별시 강남구 삼성동',
				buyer_postcode : '123-456'
			},rsp => {
			    if (rsp.success) {   
			        // axios로 HTTP 요청
			        axios({
			          url: "/orderResult.do",
			          method: "post",
			          headers: { "Content-Type": "application/json" },
			          data: {
			            imp_uid: rsp.imp_uid,
			            merchant_uid: rsp.merchant_uid
			          }
			        }).then((data) => {
			          // 서버 결제 API 성공시 로직
			        })
			      } else {
			        alert(`결제에 실패하였습니다. 에러 내용: ${rsp.error_msg}`);
			      }
			    });
		}
	
	</script>
	
	<title>Insert title here</title>
</head>
<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>

	<table>
		<tbody>
			<tr>
				<th>연락처</th>
				<td>${memberDTO.phone}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${memberDTO.name}</td>
			</tr>
		</tbody>
	</table>

	<!-- 	후원하기 버튼 누르면 결제 -->
	<button onclick="requestPay()">후원하기</button>


	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>

















