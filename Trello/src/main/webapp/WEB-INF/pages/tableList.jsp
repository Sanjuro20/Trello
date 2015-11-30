<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style/assets/tableList.css" />
		<title>Insert title here</title>
	</head>
	<body class = "body_table">
		<header class = "header_table">
			<center>Trello</center>
		</header>
		
			<a href="/Trello/addTable/Board name">
				<div class = "add_button">

						<center>ADD Board</center>
				</div>
			</a>
			<aside class = "history_panel">
				<h3>Historia</h3>
					<c:forEach items="${requestScope.history}" var="event" varStatus="loopCounter">
						<c:out value="${event}"/><br/>
					</c:forEach>
			</aside>
			<section class = "main_panel">
				<c:forEach items="${requestScope.tables}" var="table" varStatus="loopCounter">
					<div class = "list_button_shadow">
						
						<a href="/Trello/tablePage/${loopCounter.index}/${table.name}">					
							<div class = "list_button">								
	
								<c:out value="${table.name}"/>	
								<a href="/Trello/deleteTable/${loopCounter.index}"><button>Delete</button></a>
								
							</div>
						</a>
					</div>
				</c:forEach>
			</section>
	</body>
</html>