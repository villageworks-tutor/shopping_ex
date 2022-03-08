<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>商品一覧</title>
	<link rel="stylesheet" href="./css/style.css">
	<script>
	function createSelectBox(upper, selected = -1) {
		document.write("<select name=\"quantity\">");
		for (i = 0; i < upper; i++) {
			if (i + 1 == selected) {
				document.write("<option value\"" + (i + 1) + "\" selected>" + (i + 1) + "</option>");
			} else {
				document.write("<option value\"" + (i + 1) + "\">" + (i + 1) + "</option>");
			}
		}
		document.write("</select>");
	}
	</script>
</head>
<body>

<!-- ヘッダ表示領域 -->
<jsp:include page="./parts/header.jsp" />

<main>
	<article id="list">
		<form class="container">
			<h1>商品一覧</h1>
			<c:forEach  items="${requestScope.items}" var="item">
			<dl>
				<dt>商品番号</dt><dd>${pageScope.item.code}</dd>
				<dt>商品名</dt><dd>${pageScope.item.name}</dd>
				<dt>価格（税込）</dt><dd>${pageScope.item.price}円</dd>
				<dt>個数</dt>
				<dd>
					<script>
						createSelectBox(5, 1);
					</script>
				</dd>
				<dd>
					<button formaction="CartServlet" name="action" value="add">
						カートに追加
						<input type="hidden" name="code" value="${pageScope.item.code}" />
					</button>
				</dd>
			</dl>
			</c:forEach>
		</form>
	</article>
</main>

<!-- フッタ表示領域 -->
<jsp:include page="./parts/footer.jsp" />

</body>
</html>