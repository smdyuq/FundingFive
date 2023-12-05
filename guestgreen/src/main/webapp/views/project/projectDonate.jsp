<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="/resources/js/project/apiKey.js"></script>

<script src="/resources/js/common/common.js"></script>
<title>Insert title here</title>
<link href="/resources/css/common/common.css" rel="stylesheet" />
<link href="/resources/css/project/projectDonate.css" rel="stylesheet" />
<%@include file="../../views/common/head.jsp"%>
</head>
<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>

	<main>

		<div class="main-container">
			<div class="top-container">
				<div class="main-div">
					<div class="main-img">
						<img src="" alt="이미지">
					</div>
					<div class="main-text">
						<div class="main-cartegory">카테고리 명</div>
						<div class="main-project-name">프로젝트명</div>
						<div class="main-price">
							<p>00000원</p>
							<p class="main-percent">000%</p>
							<p>n일 남음</p>
						</div>
					</div>
				</div>
			</div>
			<div class="bottom-container">
				<div class="project-information-all">
					<div>
						<p class="project-information">후원자 정보</p>
						<div class="project-information-div">
							<p class="project-information-name">이름</p>
							<p>${memberDTO.memberName}</p>
							<br>
							<p class="project-information-name">연락처</p>
							<p>${memberDTO.memberPhone}</p>
							<br>
						</div>
					</div>
					<div>
						<p class="project-information">프로젝트 정보</p>
						<div class="project-information-div">
							<p class="project-information-name">프로젝트 명</p>
							<p>${projectDTO.projectName}</p>
							<br>
							<p class="project-information-name">가격</p>
							<p>${projectDTO.projectPrice}</p>
							<br>
						</div>
					</div>
					<div>
						<p class="project-information">배송지 정보</p>
						<div class="project-information-div">
							<p class="project-information-name">이름</p>
							<p>{}</p>
							<br>
							<p class="project-information-name">연락처</p>
							<p>${memberDTO.memberPhone}</p>
							<br>
							<p class="project-information-name">배송지</p>
							<p>${memberDTO.memberAddr}</p>
							<br>
							<p class="instructions">* 연락처 및 배송지 변경은 마이페이지에서 설정에서 가능합니다.</p>
						</div>
					</div>
				</div>
				<div class="payment-information">
					<div class="payment-information-div">
						<p class="payment-information-name">최종 후원 금액 :</p>
						<p>원</p>
					</div>
					<button class="donateButton" id="donateButton">카카오톡으로 후원하기</button>
				</div>
			</div>
		</div>

	</main>

	<%@include file="../../views/common/common.jsp"%>
	<%@include file="../../views/common/footer.jsp"%>

	<script>
		var IMP = window.IMP;
		IMP.init(config.store_identification_code);
		
		var today = new Date();
		var hours = today.getHours(); 
		var minutes = today.getMinutes(); 
		var seconds = today.getSeconds(); 
		var milliseconds = today.getMilliseconds();
		var make_donate_id = '' + hours + minutes + seconds + milliseconds;
		
		function requestPay(project_name, project_price, member_name, 
							member_phone, member_addr, project_no, member_no, project_current_amount, project_target_amount ) {
			IMP.request_pay({
                pg : "kakaopay.TC0ONETIME",
                pay_method : 'card',
                merchant_id : "IMP" + make_donate_id,
                name : project_name,
                amount : project_price,
                buyer_email : 'Iamport@chai.finance',
                buyer_name : member_name,
                buyer_tel : member_phone,
                buyer_addr : member_addr,
                buyer_postcode : '123-456'
			},rsp => {
			    if (rsp.success) {
			        axios({
			          url: "/orderResult.do",
			          method: "post",
			          headers: { "Content-Type": "application/json" },
			          data: {
			            donate_id: "IMP" + make_donate_id,
						project_no : project_no,
						project_price : project_price,
						member_no : member_no,
						project_current_amount : project_current_amount
						project_target_amount : project_target_amount,
						member_addr : member_addr,
						member_phone : member_phone,
						member_name : member_name
			          }
			        }).then((data) => {
			        })
			      } else {
			        alert(`결제에 실패하였습니다. 에러 내용: ${rsp.error_msg}`);
			      }
			    });
		}
		
		document.getElementById('donateButton').addEventListener('click', function(){
			requestPay('${projectDTO.projectName}', '${projectDTO.projectPrice}',
	                '${memberDTO.memberName}', '${memberDTO.memberPhone}', '${memberDTO.memberAddr}',
	                '${projectDTO.projectNo}', '${memberDTO.memberNo}', '${projectDTO.projectCurrentAmount}', '${projectDTO.projectTargetAmount}');
		});
		
	</script>
</body>
</html>











