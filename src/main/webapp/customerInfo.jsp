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
	<article id="entry">
		<div class="container">
			<section id="cart">
				<h2>ご注文商品</h2>
				<table>
					<tr>
						<th>商品番号</th>
						<th>商品名</th>
						<th>単価（税込）</th>
						<th>個数</th>
						<th>小計</th>
					</tr>
					<c:forEach items="${sessionScope.cart.items}" var="item">
					<tr>
						<td>${pageScope.item.code}</td>
						<td>${pageScope.item.name}</td>
						<td>${pageScope.item.price}円</td>
						<td>${pageScope.item.quantity}</td>
						<td>${pageScope.item.price * pageScope.item.quantity}円</td>
					</tr>
					</c:forEach>
					<tr>
						<td colspan="6" class="right-align">総計：${sessionScope.cart.total}円</td>
					</tr>
				</table>
			</section>
			<section id="customer">
				<h2>お客様情報を入力してください。</h2>
				<form name="entry">
					<table>
						<tr>
							<th>お名前</th>
							<td>
								<input type="text" name="name" value="鈴木一郎" />
							</td>
						</tr>
						<tr>
							<th>住所</th>
							<td>
								<input type="text" name="address" value="東京都渋谷区" />
							</td>
						</tr>
						<tr>
							<th>電話番号</th>
							<td>
								<input type="text" name="tel" value="03-3333-2222" />
							</td>
						</tr>
						<tr>
							<th>e-mail</th>
							<td>
								<input type="text" name="email" value="ichiro@abc.com" />
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<button formaction="OrderServlet" formmethod="post" name="action" value="confirm">確認画面へ</button>
							</td>
						</tr>
					</table>
				</form>
			</section>
		</div>
	</article>
</main>

<!-- フッタ表示領域 -->
<jsp:include page="./parts/footer.jsp" />

</body>
</html>