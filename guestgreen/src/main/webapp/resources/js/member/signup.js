
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
	            memberId: id
	        },
	        contentType: "application/x-www-form-urlencoded",
	        success: function(res) {
	            if (res === 'true') {
	                idCheck.style.color = "red";
	                idCheck.innerHTML = "중복된 아이디입니다.";
	            } else {
	                idCheck.style.color = "green";
	                idCheck.innerHTML = "사용 가능한 아이디입니다.";
	            }
	        },
	        error: function(res) {
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
	
	///////////////////////////////인증번호////////////////////////////////////
	
	let numStr;

	  // 인증하기 버튼 클릭 시 처리
	  function randomExample() {
	    // 여기에 인증하기 처리하는 코드 작성
	    let verificationCode = document.getElementById("verificationCode").value;
		console.log(numStr);
	    
		console.log(numStr);

	    if(verificationCode === numStr){
	    	alert('확인되었습니다.');
	    	signupBtn.disabled = false;
	    }else{
	    	alert('인증번호가 틀렸습니다.');
	    }
	  }

	document.addEventListener("DOMContentLoaded", function(){
		
		$('#sendPhoneNumber').click(function(e){
	   		e.preventDefault(); // 기본 이벤트를 막음 (페이지 리로드 방지)
	
		    let phoneNumber = $('#member-phone').val();
		    
			    $.ajax({
			        type: "GET",
			        url: "/sendSMS.do",
			        data: {
			            "memberPhone" : phoneNumber
			        },
			        success: function(res){
			            // 인증번호 발송 성공 시 처리
			            numStr = res;
			            console.log(numStr);
			        },
			        error: function(err) {
			            // 인증번호 발송 실패 시 처리
			            
			        }
			    })
			});
		
	// 인증 요청 버튼 클릭 시 인증하기 버튼 보이게
	  document.getElementById("sendPhoneNumber").addEventListener("click", function() {
	    // 여기에 인증 요청 처리하는 코드 작성
	    // 인증 요청 성공 시 아래의 코드를 사용하여 인증 섹션을 보여줌
	    document.getElementById("verificationSection").style.display = "block";
	  });
});
	
