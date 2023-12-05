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
<body>
	<label class="tab_item" for="shipping">배송조회</label> 
	<form action="http://info.sweettracker.co.kr/tracking/3" method="post">
            <div class="form-group">
              <input type="hidden" class="form-control" id="t_key" name="t_key" value="bRm16slaIRj7ecv626FPQg">
            </div>
            <div class="form-group">
              <input type="hidden" class="form-control" name="t_code" id="t_code" value="04">
            </div>
            <div class="form-group">
              <label for="t_invoice">운송장 번호</label>
              <input type="text" class="form-control	" name="t_invoice" id="t_invoice" placeholder="운송장 번호">
            </div>
            <button type="submit" class="btn btn-default" onclick="checkShipping()">조회하기</button>
        </form>
</body>
</html>
