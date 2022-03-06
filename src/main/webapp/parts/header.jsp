<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<nav id="menu">
		<ol>
			<li><a href="./index.html">ようこそ</a></li>
			<c:forEach items="${applicationScope.categories}" var="category">
				<li><a href="./ItemServlet?action=list&code=${pageScope.category.code}">${pageScope.category.name}</a></li>
			</c:forEach>
			<li><a href="./cart.html">カートを見る</a></li>
		</ol>
	</nav>
</header>
