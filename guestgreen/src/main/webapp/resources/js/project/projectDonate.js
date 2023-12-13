

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
						project_name : project_name,
						project_price : project_price,
						member_no : member_no,
						project_current_amount : project_current_amount,
						project_target_amount : project_target_amount,
						member_addr : member_addr,
						member_phone : member_phone,
						member_name : member_name
			          }
			        }).then((response) => {
			            try {
			                submit(response.data.projectName, response.data.projectPrice,response.data.memberName
			                		, response.data.memberPhone, response.data.memberAddr);
			            } catch (error) {
			                console.error('Error accessing project_name:', error);
			            }
			        })
			      } else {	
			        alert(`결제에 실패하였습니다. 에러 내용: ${rsp.error_msg}`);
			      }
			    });
		}
		
		function submit(project_name, project_price, member_name, member_phone, member_addr){
			let form = document.createElement("form");
			form.setAttribute("charset", "UTF-8");
			form.setAttribute("method", "post");
			form.setAttribute("action", "/paymentConfirm.do");
	
			setField(form, "project_name", project_name);
			setField(form, "project_price", project_price);
			setField(form, "member_name", member_name);
			setField(form, "member_phone", member_phone);
			setField(form, "member_addr", member_addr);
			
			document.body.appendChild(form);
			form.submit();
		}
		
		function setField(form, name, value){
			let hiddenField = document.createElement("input");
			hiddenField.setAttribute("type", "hidden");
			hiddenField.setAttribute("name", name);
			hiddenField.setAttribute("value", value);
			form.appendChild(hiddenField);
		}