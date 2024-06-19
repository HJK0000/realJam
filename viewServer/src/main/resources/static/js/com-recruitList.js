document.addEventListener('DOMContentLoaded', function() {
	// REST API 서버의 엔드포인트 URL
	const apiUrl = 'http://localhost:9002/com/getRecruitTitle';
	const apiUrl2 = 'http://localhost:9002/com/deleteRecruitment';
	const apiUrl3 = 'http://localhost:9002/com/getRecruitForUpdate';
	const username = localStorage.getItem('username');

	console.log(username);

	// 삭제하기 버튼용 delete 요청
	function deleteJobAd(jobAdId) {

		// 삭제 확인 메시지 표시
		const confirmDelete = confirm(" 해당 채용공고를 정말 삭제하시겠습니까?");

		if (confirmDelete) {
			fetch(apiUrl2 + '/' + jobAdId, {
				method: 'DELETE',
				headers: {
					'Username': username
				}
			})
				.then(response => {
					if (!response.ok) {
						throw new Error('Failed to delete job advertisement');
					}
					return response.json();
				})
				.then(data => {
					// Optionally handle success response, if needed
					console.log('Server response:', data); // 서버에서 보낸 데이터 콘솔에 출력
					alert(data.message);
					// 페이지 새로고침
					window.location.reload();
				})
				.catch(error => {
					console.error('Error deleting job advertisement:', error);
					alert('채용공고 삭제에 실패했습니다');
				});
		}
	}
	// 수정하기 버튼용 update 요청
	function updateJobAd(jobAdId) {

		document.querySelectorAll('.container').forEach(function(div) {
			div.style.display = 'none';
		});

		document.querySelector("#jobUpdate").style.display = "block";
		console.log(username);
		console.log(jobAdId);

		fetch(apiUrl3 + '/' + jobAdId, {

			method: 'GET',
			headers: {

				'Username': username // 요청 헤더에 USERNAME 추가

			}

		})
			.then(response => {

				if (!response.ok) {

					throw new Error('채용정보를 업데이트하는데 실패하였습니다.');

				}

				return response.json();

			})

			.then(data => {

				console.log('Server response :', data);

				// 가져온 데이터를 폼에 넣기
				document.getElementById('jno2').value = data.jno;
				document.getElementById('wantedTitle2').value = data.wantedTitle;
				document.getElementById('sector12').value = data.sector1;
				document.getElementById('position12').value = data.position1;
				document.getElementById('collectPsncnt2').value = data.collectPsncnt;
				document.getElementById('jobCont2').value = data.jobCont;
				document.getElementById('empTpNm2').value = data.empTpNm;
				document.getElementById('region2').value = data.region;
				document.getElementById('educondition2').value = data.educondition;
				document.getElementById('yofExperiences2').value = data.yofExperiences;
				//document.getElementById('needskill2').value = data.needskill;
				document.querySelector(`input[name="rcptMthd2"][value="${data.rcptMthd}"]`).checked = true;
				document.getElementById('wkdWkhCnt2').value = data.wkdWkhCnt;
				document.getElementById('salTpCd2').value = data.salTpCd;
				document.getElementById('sale2').value = data.sale;
				document.getElementById('retirepay2').checked = data.retirepay;
				document.getElementById('etcWelfare2').value = data.etcWelfare;
				document.getElementById('mltsvcExcHope2').checked = data.mltsvcExcHope;
				document.getElementById('empName2').value = data.empName;
				document.getElementById('empTel2').value = data.empTel;
				document.getElementById('empEmail2').value = data.empEmail;
				document.getElementById('receiptCloseDt2').value = data.receiptCloseDt;


			})
			.catch(error => {
				console.error('Error updating job advertisement:', error);

			});
	}


	// Ajax get 요청
	fetch(apiUrl, {
		method: 'GET',
		headers: {

			'Username': username
		}
	})

		.then(response => {
			if (!response.ok) {
				// 서버에서 오류 응답을 보낸 경우

				if (response.status === 404) {
					// 채용공고가 없는 메시지를 표시
					const jobTableMessage = document.getElementById('jobTableMessage');
					jobTableMessage.innerHTML = '<tr><td colspan="3">등록된 채용공고가 없습니다</td></tr>';
					return Promise.reject('채용공고 없음');
				}

				throw new Error('Network response was not ok');
			}

			return response.json();
		})
		.then(data => {
			const tableBody = document.getElementById('jobTableBody');
			const jobTableMessage = document.getElementById('jobTableMessage');

			// 데이터가 없는 경우 처린
			if (!Array.isArray(data) || data.length === 0 || data === null) {
				jobTableMessage.innerHTML = '<tr><td colspan="3">등록된 채용공고가 없습니다</td></tr>';

			} else {

				tableBody.innerHTML = ''; // 기존 내용 지우기

				data.forEach(jobAd => {
					const row = document.createElement('tr');

					// 공고 제목 셀
					const titleCell = document.createElement('td');
					const titleLink = document.createElement('a');
					titleLink.href = '#'; // 클릭 이벤트만 발생시키기 위해 '#' 설정
					titleLink.textContent = jobAd.wantedTitle; // jobAdDto의 title 속성
					titleCell.appendChild(titleLink); // titleLink를 titleCell에 추가
					row.appendChild(titleCell);


					// 클릭 이벤트 리스너 추가
					titleLink.addEventListener('click', () => {

						// jobAd.jno를 사용하여 /com/jobDetail 앤드포인트로 이동
						window.location.href = '/com/jobDetail?id=' + jobAd.jno;

					});

					// 수정 버튼 셀
					const updateCell = document.createElement('td');
					const updateButton = document.createElement('button');
					updateButton.type = 'button';
					updateButton.className = 'update';
					updateButton.textContent = '수정하기';
					updateCell.appendChild(updateButton);
					row.appendChild(updateCell);

					// 수정버튼에 eventListener 달기
					updateButton.addEventListener('click', () => {
						updateJobAd(jobAd.jno); // jobAd의 id인 jno를 매개변수로 넘겨준다.

					})

					// 삭제 버튼 셀
					const deleteCell = document.createElement('td');
					const deleteButton = document.createElement('button');
					deleteButton.type = 'button';
					deleteButton.className = 'delete';
					deleteButton.textContent = '삭제하기';

					console.log("jobAdJno = " + jobAd.jno);

					// 삭제버튼에 eventListener 달기
					deleteButton.addEventListener('click', () => {
						deleteJobAd(jobAd.jno); // Assuming jobAd has an 'id' property
					});


					deleteCell.appendChild(deleteButton);
					row.appendChild(deleteCell);

					// 행을 테이블 본문에 추가
					tableBody.appendChild(row);



				});
			}

		})

		.catch(error => {
			console.error('Error', error);

		});

});
