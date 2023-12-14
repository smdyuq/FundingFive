<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
	function checkShipping(){
		let data = {
				t_code : document.getElementById("t_code").value,
				t_invoice : document.getElementById("t_invoice").value,
				t_key : document.getElementById("t_key").value
		}
		axios.post("https://info.sweettracker.co.kr/api/v1/trackingInfo", data, {
		      headers: {
		        'Content-Type': 'application/x-www-form-urlencoded',
		      },
		    })
		    .then(function (response) {
		      console.log(response);
		      response.data.status,
		      response.data.msg,
		      response.data.firstDetail,
 		      response.data.invoiceNo,
		      response.data.itemName
		    })
		    .catch(function (error) {
		      console.log("api로 데이터 전송 실패");
		    });
		  }
</script>
</head>
</html>
