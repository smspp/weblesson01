<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<% String english = (String)request.getAttribute("english"); %>
	<% String japanese = (String)request.getAttribute("japanese"); %>
	<% String exe = (String)request.getAttribute("exe"); %>
	<% int count = (int)request.getAttribute("registcount"); %>
	<% int i = (int)request.getAttribute("registint"); %>

<head>

 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<meta http-equiv="X-UA-Compatible" content="ie=edge">
  	<link rel="stylesheet" href="css/style.css">
	<meta charset = "UTF-8">
	<title>Result</title>
	<link rel="stylesheet" href="css/reset.css">
 	 <link rel="stylesheet" href="css/result.css">

</head>
<body>
<div class="wrap">

	<header>

		<h1>NOTE</h1>

		<ul>
			<li><a href="index.html">MEMO</a></li>
			<li><a href="list">LIST</a></li>
		</ul>

	</header>

	<div class="res">
		<h2><%= count %>件登録</h2>
		<div class="line"></div>

		<dl>
		<dt>English word</dt><dd><%= english %></dd>
		<dt>Meaning</dt><dd><%= japanese %></dd>
		<dt>Example</dt><dd><%= exe %></dd>
		</dl>

		<p>現在<%= i %>件登録済み</p>
	</div>


</div>
</body>
</html>