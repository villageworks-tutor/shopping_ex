<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>Welcome shopping!</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>

<!-- ヘッダ表示領域 -->
<jsp:include page="./parts/header.jsp" />

<main>
	<article id="cart">
		<form class="container">
			<h2>現在のカートの中身</h2>
			<table>
				<tr>
					<th>商品番号</th>
					<th>商品名</th>
					<th>単価（税込）</th>
					<th>個数</th>
					<th>小計</th>
					<th>削除</th>
				</tr>
				<c:forEach items="${sessionScope.cart.items}" var="item">
				<tr>
					<td>${pageScope.item.code}</td>
					<td>${pageScope.item.name}</td>
					<td>${pageScope.item.price}円</td>
					<td>${pageScope.item.quantity}</td>
					<td>${pageScope.item.price * pageScope.item.quantity}円</td>
					<td>
						<form action="CartServlet" method="post">
							<button type="submit" name="action" value="delete">削除</button>
							<input type="hidden" name="code" value="${pageScope.item.code}" />
						</form>
					</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="6" class="right-align">総計：${sessionScope.cart.total}円</td>
				</tr>
				<tr>
					<td colspan="6" class="button">
						<button formaction="./customerInfo.html" formmethod="post" name="action" value="entry">注文する</button>
					</td>
				</tr>
			</table>
		</form>
	</article>
</main>

<!-- フッタ表示領域 -->
<jsp:include page="./parts/footer.jsp" />

</body>
</html>