<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>Sample Shopping Site</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>

<!-- ヘッダ表示領域 -->
<jsp:include page="./parts/header.jsp" />

<!--  メインコンテンツ表示領域 -->
<main>
	<article id="top">
		<div class="container">
		<h1>ようこそ！サンプルショッピングサイトへ</h1>
		<p>このサイトは教材用として作成されています。<br />デザインなどは各自工夫してみましょう。</p>
		</div>
	</article>
</main>

<!-- フッタ表示領域 -->
<jsp:include page="./parts/footer.jsp" />

</body>
</html>