document.addEventListener('DOMContentLoaded', function() {

	// REST API 서버의 엔드포인트 URL
	const apiUrl = 'http://localhost:9002/com/getRecruitTitle';
	const username = localStorage.getItem('username');

	console.log(username);
	// Ajax get 요청
	fetch('apiUrl', {

		method: 'GET',
		headers: {
			'Content-Type': 'application/json',
			'Username': username

		}

	})

		.then(response => response.json())
		.then(data => {

			if (Array.isArray(data)) {

				const tableBody = document.getElementById('jobTableBody');

				tableBody.innerHTML = ''; // 기존 내용 지우기

				data.forEach(jobAd => {
					const row = document.createElement('tr');
					const cell = document.createElement('td');
					cell.textContent = jobAd.title; // jobAdDto의 title 속성
					row.appendChild(cell);
					tableBody.appendChild(row);



				});

			} else {

				console.error('Invalid data format:', data);
			}



		})
		
		.catch(error => {
			console.error('Error', error);
		});

	});
