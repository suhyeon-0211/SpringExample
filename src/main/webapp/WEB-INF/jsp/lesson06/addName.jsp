<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 추가하기</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<%-- ajax를 사용하려면 더 많은 함수가 있는 jquery js를 포함해야한다. --%>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<b>이름:</b>
		<label><input type="text" class="form-control" id="name"></label>
		<button type="button" id="nameCheckBtn" class="btn btn-success">중복확인</button>
		<div id="nameStatusArea">
		
		</div><br>
		<button type="button" id="joinBtn" class="btn btn-primary">회원가입</button>
	</div>
	
	<script>
		$(document).ready(function() {
			$('#nameCheckBtn').on('click', function(e) {
				let name = $('#name').val().trim();
				
				$('#nameStatusArea').empty(); // div 태그 안에 있는 (자식 태그) 들을 비운다.
				
				// validation check
				// 이름이 있는지 확인
				if (name == '') {
					$('#nameStatusArea').append('<small class="text-danger">이름을 입력하세요</small>');	
					return;
				}
				
				// 이름이 중복되는지 확인(DB 조회) -> AJAX 통신
				$.ajax({
					type: "GET"
					, url : "/lesson06/ex02/is_duplication"
					, data : {"name" : name}
					, success : function(data) {
						if(data.is_duplication == true) {
							$('#nameStatusArea').append('<small class="text-danger">중복된 이름입니다.</small>');
						}/*  else {
							$('#nameStatusArea').append('<small class="text-success">사용 가능한 이름입니다.</small>');
						} */
					}
					, error : function(e) {
						alert("실패 : " + e);
					}
				});
			});
			
			$('#joinBtn').on('click', function() {
				// alert("회원가입 버튼 클릭");
				
				console.log($('#nameStatusArea').children().length);
				if ($('#nameStatusArea').children().length == 0) {
					alert("서브밋 가능");
				} else {
					alert("서브밋 불가");
				}
			});
		});
	</script>
</body>
</html>