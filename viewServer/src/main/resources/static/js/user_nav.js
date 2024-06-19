$(document).ready(function(){
    	var loggedInUser = localStorage.getItem('username');
        var loginButton = $('#loginButton');
        var signupButton = $('#signupButton');
		
        
        console.log("username: " + loggedInUser);
        
        if (loggedInUser) {
            loginButton.text('로그아웃');
            loginButton.attr('href','#'); // 로그아웃 링크 설정
            loginButton.on('click', function(e) {
                e.preventDefault(); // 링크 클릭 시 기본 동작 방지
                localStorage.removeItem('username');
                localStorage.removeItem('role');
                location.href = '/'; // 로그아웃 후 메인 페이지로 이동
            });
            signupButton.css('display','none'); // 회원가입 버튼 숨기기
        } else {
            loginButton.text('로그인');
            loginButton.attr('href','/loginForm'); // 로그인 링크 설정
        }
        
        const username = localStorage.getItem("username");
   			
   			$.ajax({
   				url: 'http://localhost:9002/user/mypage/' + username,
   				method: 'GET',
   				success: function(response){
   					localStorage.setItem('userData', JSON.stringify(response));
   					
   					$("#userinfo").text("(" + response.uname + ")" + "님 안녕하세요.");
   				},
   				error: function(error){
   					console.error("Error: ", error);
   				}
   			});
    });
    
    function goMypage(){
		 const username = localStorage.getItem("username");
		 
		 
	}