<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, webLesson01.NoteDAO"%>
<%@ page import="java.util.List, webLesson01.Note"%>
<!DOCTYPE html>

	<% List<Note> ar = (List<Note>)request.getAttribute("ar"); %>

<head>

 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<meta http-equiv="X-UA-Compatible" content="ie=edge">
  	<link rel="stylesheet" href="css/style.css">
	<meta charset = "UTF-8">
	<title>List</title>
	<link rel="stylesheet" href="css/reset.css">
 	 <link rel="stylesheet" href="css/list.css">

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
		<h2>登録済みの単語</h2>
		<div class="line"></div>
	</div>

	<div class="ar">
	<%
		for( int i = 0 ; i < ar.size() ; i++ ){

			out.println( ar.get(i) );
			out.println( "<br>" );
		}

	%>
	</div>


</div>
</body>
</html>