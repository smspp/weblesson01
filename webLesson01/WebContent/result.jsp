<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<% String title = (String)request.getAttribute("title"); %>
	<% String naiyou = (String)request.getAttribute("naiyou"); %>
	<% String answer = (String)request.getAttribute("answer"); %>

<head>

 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<meta http-equiv="X-UA-Compatible" content="ie=edge">
  	<link rel="stylesheet" href="css/style.css">
	<meta charset = "UTF-8">
	<title>Result</title>

</head>
<body>
<div class="wrap">

	<header>

		<h1>note</h1>

		<ul>
			<li>memo</li>
			<li>list</li>
		</ul>

	</header>


	<h2><%= title %></h2>
	<p><%= naiyou %></p>


	<div><p><%= answer %></p></div>

	<p>登録完了</p>

</div>
</body>
</html>