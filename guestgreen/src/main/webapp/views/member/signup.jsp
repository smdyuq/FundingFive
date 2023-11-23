<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../views/common/head.jsp"%>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<%@include file="../../views/common/header.jsp"%>

	<main>

		<h2>회원가입</h2>
		<form action="/signup.do" method="POST">

			<div class="signup-input"></div>
			<div class="signup-input">
				<label for="member-id">아이디:</label> <input type="text"
					id="member-id" name="member-id" onkeyup="duplicateId()"
					placeholder="사용하실 id를 입력해주세요." required><br> <span
					id="idMsg"></span>
			</div>
			<br>
			<div class="signup-input">
				<label for="member-pwd">비밀번호:</label> <input type="password"
					id="member-pwd" name="member-pwd" onkeyup="validatePassword()"
					placeholder="비밀번호를 입력해주세요." required> <br> <span
					id="passwordMsg"></span>
			</div>
			<br>
			<div class="signup-input">
				<label for="member-pwdCheck">비밀번호 확인:</label> <input type="password"
					id="member-pwdCheck" name="member-pwdCheck"
					onkeyup="validatePassword()" placeholder="비밀번호를 확인합니다." required>
				<br> <span id="passwordChkMsg"></span>
			</div>
			<br>
			<div class="signup-input">
				<label for="member-name">이름:</label> <input type="text"
					id="member-name" name="member-name" onkeyup="validateName() "
					placeholder="이름을 입력해주세요." required><br> <span
					id="nameMsg"></span>
			</div>
			<br>
			<div class="signup-input">
				<label for="member-phone">휴대폰 번호:</label> <input type="number"
					id="member-phone" name="member-phone" onkeyup=""
					placeholder="숫자만 입력해주세요." required><button>인증하기</button><br> <span
					id="phonekMsg"></span>
			</div>
			<br>
			<div class="signup-input">
				<label for="member-addr">주소:</label> <input type="text"
					id="member-addr" name="member-addr" onkeyup=""
					placeholder="주소를 입력해주세요." required><input type="button"
					value="우편번호검색" onclick="checkPost()"><br> <input
					type="text" id="member-addr-detail" name="member-addr-detail"
					onkeyup="" placeholder="상세주소를 입력해주세요." required><br> <span
					id="addrMsg"></span>
			</div>
			<br>
			<button type="submit">회원가입</button>

		</form>
		</div>
		</section>





	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>

<script>
	/* <!-- 서버에서 전달한 실패 메시지를 확인하고 팝업창 띄우기  --> */
    <%String errorMessage = (String) request.getAttribute("errorMessage");
if (errorMessage != null && !errorMessage.isEmpty()) {%> alert('<%=errorMessage%>
	');
<%}%>
/* 아이디 중복체크 및 유효성 검사 */
function duplicateId() {
    const id = document.getElementById("member-id").value;
    const idCheck = document.getElementById("idMsg");
    const idRegExp = /^[a-zA-z0-9]{4,12}$/; // 아이디 유효성 검사 정규식
    if (id == ""){
    	idCheck.innerHTML = "아이디를 입력해주세요.";
    	idCheck.style.color = "red";
    } else if (!idRegExp.test(id)) { // 아이디 유효성 검사
        idCheck.style.color = "red";
        idCheck.innerHTML = "아이디는 영문자와 숫자로 이루어진 4~12자여야 합니다.";
        return;
    } else {
	    $.ajax({
	        type: "POST",
	        url: "/duplicateId.do",
	        data: {
	            id: id
	        },
	        contentType: "application/x-www-form-urlencoded",
	        success: function (res) {
	            if (res === 'true') {
	                idCheck.style.color = "red";
	                idCheck.innerHTML = "중복된 아이디입니다.";
	            } else {
	                idCheck.style.color = "green";
	                idCheck.innerHTML = "사용 가능한 아이디입니다.";
	            }
	        },
	        error: function (response) {
	        }
	    })
    	
    }
    

}
	

	// 이름 유효성 검사
	function validateName() {
		const nameRegex = /^[가-힣]{2,}$/;
		const name = document.getElementById("member-name").value;
		const nameMsg = document.getElementById("nameMsg");

		if (name == "") {
			nameMsg.innerHTML = "이름을 입력해주세요.";
			nameMsg.style.color = "red";
		} else if (nameRegex.test(name)) {
			nameMsg.innerHTML = "사용 가능한 이름입니다.";
			nameMsg.style.color = "green";
		} else {
			nameMsg.innerHTML = "이름은 한글만 가능합니다.";
			nameMsg.style.color = "red";
		}
	}

	// 비밀번호 유효성 검사 + 비밀번호 확인하고 같은지
	function validatePassword() {
		const passwordRegex = /^(?=.*[a-zA-Z])(?=.*[@$!%*?&\#])[A-Za-z\d@$!%*?&\#]{6,20}$/;
		const password = document.getElementById("member-pwd").value;
		const msg = document.getElementById("passwordMsg");

		if (password == "") {
			msg.innerHTML = "비밀번호를 입력하세요.";
			msg.style.color = "red";
		} else if (passwordRegex.test(password)) {
			msg.innerHTML = "사용 가능한 비밀번호 입니다.";
			msg.style.color = "green";
		} else {
			msg.innerHTML = "패스워드 정책에 맞지 않습니다.";
			msg.style.color = "red";
		}

		const passwordChk = document.getElementById("member-pwdCheck").value;
		const msg2 = document.getElementById("passwordChkMsg");

		console.log(msg2); 
	    if (msg2) {
	        if (passwordChk === "") {
	            msg2.innerHTML = "비밀번호 확인을 입력하세요.";
	            msg2.style.color = "red";
	        } else if (password === passwordChk) {
	            msg2.innerHTML = "패스워드가 동일합니다.";
	            msg2.style.color = "green";
	        } else {
	            msg2.innerHTML = "패스워드가 동일하지 않습니다.";
	            msg2.style.color = "red";
	        }
	    } 

	}
	
	
</script>
