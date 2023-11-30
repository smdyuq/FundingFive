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
<title>Insert title here</title>
<%@include file="../../views/common/head.jsp"%>

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

	<button id="donateButton">카카오톡으로 후원하기</button>


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
							member_phone, member_addr, project_no, member_no ) {
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
						member_no : member_no
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
	                '${projectDTO.projectNo}', '${memberDTO.memberNo}');
		});
		
	</script>
</body>
</html>












