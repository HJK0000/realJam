/**
 * 
 */

document.addEventListener('DOMContentLoaded', function() {
	// 기업 정보 수정 페이지가 로드되면 이 함수가 바로 실행됨

	// REST API 서버의 엔드포인트 URL

	const username = localStorage.getItem('username'); 
	const apiUrl = 'http://localhost:9002/com/getCompanyInfo/' + username;
	console.log(username);
	// Ajax get 요청
	$.ajax({

		url: apiUrl,
		type: 'GET',
		headers: {
					"Username" : username // 요청 헤더에 username추가
		}, 
		success: function(response) {
			const obj = response;
			console.log("obj = " + obj);
			$("input[name='username'] ").val(obj.username);
			$("input[name='password'] ").val(obj.password);
			$("input[name='cname'] ").val(obj.cname);
			$("input[name='logo'] ").val(obj.logo);
			$("input[name='ceo'] ").val(obj.ceo);
			$("input[name='cnum'] ").val(obj.cnum);
			$("input[name='caddr'] ").val(obj.caddr);
			$("input[name='employees'] ").val(obj.employees);
			$("input[name='url'] ").val(obj.url);
			$("input[name='size'] ").val(obj.size);
			$("input[name='major'] ").val(obj.major);
			$("input[name='yrSales'] ").val(obj.yrSales);
			$("input[name='sector'] ").val(obj.sector);


		},

		error: function(jqXHR, textStatus, errorThrown) {
			$("#error_result").text(
				"Error: " + textStatus + " - "
				+ errorThrown);
		}


	});
})
	