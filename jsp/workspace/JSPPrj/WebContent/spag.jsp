<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("result") %>입니다. <br>
	<!-- EL배열 [index] 출력 -->
	${names[1]} <br>
	<!-- EL맵 타이틀 값 출력 -->
	${notice.title} <br>
	<!-- 파라미터 값 출력 -->
	${param.n} <br>
	<!-- 헤더의 accept정보 출력 -->
	${header.accept} <br>
</body>
</html>