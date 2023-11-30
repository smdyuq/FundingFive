<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<footer class="footer_con">
    <style>
        /* 오른쪽 */
        .container {
            background-color: #e0e0e0;
            width: 100%;
            height: auto;
            display: flex;
            flex-direction: row;
        }

        .footerInfo {
            background-color: pink;
            width: 70%;
            padding-left: 3%;
            
        }

        .answer {
            display: none;
            padding-bottom: 30px;
        }

        .faq-content {
            border-bottom: 1px solid #e0e0e0;
            width: 90%;
        }

        .question {
            font-size: 19px;
            padding: 30px 0;
            cursor: pointer;
            border: none;
            outline: none;
            background: none;
            width: 100%;
            text-align: left;
        }

        .question:hover {
            color: #2962ff;
        }

        [id$="-toggle"] {
            margin-right: 15px;
        }

        /* 왼쪽 */
        .footerSns {
            background-color: skyblue;
            flex-grow: 1;
            padding: 2%;
        }

        .footerSns>div {
            width: 50%;
            display: flex;
            justify-content: space-between;
            flex-direction: row;
        }

        .sns_image>a:hover img {
            transform: scale(1.3);
            transition: transform 1s;
            filter: brightness(70%);
        }


        
    </style>
<script language="JavaScript">

    function terms() {
        window.open(
          "/views/common/child.jsp",
          "Child",
          "width=500, height=800, top=50, left=50"
        );
    }

    </script>


 <div class="container">
    <div class="footerInfo" data-itemtype="company-info">

        <div class="groupInfo">
            <span class="footer_group_Name">
                <strong>조명</strong>
                <span>F5</span>                    
            </span>
            <span class="footer_group_arr">
                <strong>주소</strong>
                <span>경기도 안양시 만안구 안양로 303 KR 메타포스빌</span>
            </span>
            <span>
                <strong>대표</strong>
                <span>이승엽</span>
            </span>
            <span>
                <strong>대표번호</strong>
                <span>031-000-1111</span>
            </span>
            <div>
                <strong>문의</strong>
                <span>문의 사항은 톡 문의하기의 상담원 연결을 이용해주시기 바랍니다.</span>
            </div>
            <div>
                <strong onclick="terms()">이용 약관</strong>
            </div>
            <div>
                일부 상품의 경우 [F5]는 통신판매중개자이며 통신판매 당사자가 아닙니다.
                해당되는 상품의 경우 상품, 상품정보, 거래에 관한 의무와 책임은 판매자에게 있으므로, 각 상품 페이지에서 구체적인 내용을 확인하시기 바랍니다.
            </div>
        </div>

        <div class="faq-content">
            <button class="question" id="que-1"><span id="que-1-toggle">+</span><span>[Team] F5 팀원소개</span></button>
            <div class="answer" id="ans-1">팀장: 이승엽 <br>[Front] 강나영, 이윤호 <br>[Back] 나재윤, 정윤제</div>
        </div>

        <p class="InfoRaw">Copyright 2023. [Team] F5. All Rights Reserved.</p>
    </div>
    <div class="footerSns">
        <div>
            <div class="sns_image">
                <a href="https://www.instagram.com/"><img src="./instagram.png"
                        style="width:25px; height:25px;"></a>
            </div>
            <div class="sns_image">
                <a href="https://twitter.com/?lang=ko"><img src="./twitter.png"
                        style="width:25px; height:25px;"></a>
            </div>
            <div class="sns_image">
                <a href="https://www.facebook.com/?locale=ko_KR"><img src="./facebook.png"
                        style="width:25px; height:25px;"></a>
            </div>
        </div>
    </div>
</div>

</div>


</footer>
<script>
    const items = document.querySelectorAll('.question');

    // function openCloseAnswer() {
    //     const answerId = this.id.replace('que', 'ans');

    //     if (document.getElementById(answerId).style.display === 'block') {
    //         document.getElementById(answerId).style.display = 'none';
    //         document.getElementById(this.id + '-toggle').textContent = '+';
    //     } else {
    //         document.getElementById(answerId).style.display = 'block';
    //         document.getElementById(this.id + '-toggle').textContent = '-';
    //     }
    // }

    items.forEach(item => item.addEventListener('click', openCloseAnswer));

    function openCloseAnswer() {
    const answerId = this.id.replace('que', 'ans');
    const answerElement = document.getElementById(answerId);

    if (answerElement.style.display === 'block') {
        answerElement.style.display = 'none';
        document.getElementById(this.id + '-toggle').textContent = '+';
    } else {
        answerElement.style.display = 'block';
        document.getElementById(this.id + '-toggle').textContent = '-';
        answerElement.scrollIntoView({ behavior: 'smooth', block: 'end', inline: 'nearest' });
    }
}

</script>