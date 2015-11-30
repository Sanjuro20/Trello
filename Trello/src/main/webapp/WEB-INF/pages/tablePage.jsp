<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style/assets/tablePage.css" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<title>Insert title here</title>
	</head>
	<body style = "	background-color: #3385FF;
					height: 100%;">
		<header style = "background-color: blue;
							color: white;
							text-algin: center;
							width: 100%;
							height: 50px;
							border-radius: 10px;">
			<center>Trello</center>
		</header>
		Lists of "${tableName}" board:
		</br>
		<a href="/Trello/addList/${tableIndex}/${tableName}/List name">
			<div style = "width: 200px;
						height: 25px;
						background-color: red;
						border-radius: 10px;">
							
				<center>ADD List</center>
							
			</div>
		</a>
		</br>
		<aside style="float:right; width:35%;">
			<h3>Historia</h3>
			<c:forEach items="${requestScope.history}" var="event" varStatus="loopCounter">
				<c:out value="${event}"/><br/>
			</c:forEach>
		</aside>
		<c:forEach items="${requestScope.lists}" var="list" varStatus="loopCounter">
			<div style = "width: 210px;
					height: 150px;
					float: left;">
							
	      	<tr>
	      		<td><c:out value="${list.name}"/></td>
	        </tr>
	      	<a href="/Trello/deleteList/${tableIndex}/${tableName}/${loopCounter.index}"><button>Delete</button></a>
	        </br>
	        <a href="/Trello/addCard/${tableIndex }/${tableName}/${loopCounter.index}/nazwa"><button>Add Card</button></a>
	        <br>
	        	<c:forEach items="${list.cards}" var="card" varStatus="nr">
	        		<tr>
	      				<td><button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">${card.name}</button></td><a href="/Trello/deleteCard/${tableIndex }/${loopCounter.index}/${nr }/nazwa"><button>Delete Card</button></a>
	        		</tr>
	        		<br>
				</c:forEach>
			</div>
		</c:forEach>
		<div class="container">
			  
			  
			  <!-- Modal -->
			  <div class="modal fade" id="myModal" role="dialog">
			    <div class="modal-dialog">
			    
			      <!-- Modal content-->
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title">Komentarze</h4>
			        </div>
			        <div class="modal-body">
			          <h5>Dodaj komentarz</h5>
			           <textarea class="form-control" rows="5" id="comment"></textarea>
			        </div>
			        <div class="modal-footer">
			          <button type="button" class="btn btn-default" data-dismiss="modal">Save</button>	
			          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			        </div>
			      </div>
			      
			    </div>
			  </div>
  
</div>
	</body>
</html>