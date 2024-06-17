document.addEventListener('DOMContentLoaded', function() {
	// REST API 서버의 엔드포인트 URL
	const apiUrl = 'http://localhost:9002/com/getRecruitTitle';
	const username = localStorage.getItem('username');

	console.log(username);

	// Ajax get 요청
	fetch(apiUrl, {
		method: 'GET',
		headers: {

			'Username': username
		}
	})

		.then(response => {
			if (!response.ok) {
				throw new Error('Network response was not ok');
			}
			return response.json();
		})
		.then(data => {

			if (Array.isArray(data)) {

				const tableBody = document.getElementById('jobTableBody');

				tableBody.innerHTML = ''; // 기존 내용 지우기

				data.forEach(jobAd => {
					const row = document.createElement('tr');

					// 공고 제목 셀
					const titleCell = document.createElement('td');
					titleCell.textContent = jobAd.wantedTitle; // jobAdDto의 title 속성
					row.appendChild(titleCell);


					// 수정 버튼 셀
					const updateCell = document.createElement('td');
					const updateButton = document.createElement('button');
					updateButton.type = 'button';
					updateButton.className = 'update';
					updateButton.textContent = '수정하기';
					updateCell.appendChild(updateButton);
					row.appendChild(updateCell);

					// 삭제 버튼 셀
					const deleteCell = document.createElement('td');
					const deleteButton = document.createElement('button');
					deleteButton.type = 'button';
					deleteButton.className = 'delete';
					deleteButton.textContent = '삭제하기';
					deleteCell.appendChild(deleteButton);
					row.appendChild(deleteCell);

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
