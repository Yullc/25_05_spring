<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="ARTICLE DETAIL"></c:set>
<%@ include file="../common/head.jspf"%>


<body>
	<h2>${article.id}번 글 수정
	</h2>

	<a href="../home/main">메인으로 이동</a>

	<form action="doModify" method="POST">
		<input type="hidden" value="${article.id}" name="id" />
		<div>
			번호 :
			${article.id}</div>

		<div>
			날짜 :
			${article.reDate}</div>
		<div>
			새 제목 : <input type="text" placeholder="제목 입력" name="title" />
		</div>
		<div>
			새 내용 :
			<textarea type="text" placeholder="내용 입력" name="body"></textarea>
		</div>
		<button type="submit">수정</button>
	</form>
</body>


<%@ include file="../common/foot.jspf"%>