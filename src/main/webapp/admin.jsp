<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Create an account</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css"
	rel="stylesheet">


</head>
<body onload="show(event,'view-users-page')">
    
	<div class="container">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<h2>
				Welcome ${pageContext.request.userPrincipal.name} | <a
					onclick="document.forms['logoutForm'].submit()">Logout</a>
			</h2>
		</c:if>
	</div>
	<nav class="navbar navbar-default">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li class="tablinks active"><a href="#" onclick="show(event,'view-users-page')">Users</a></li>
      <li class="tablinks"><a href="#" onclick="show(event,'view-user-calories-page')">User Calories</a></li>
      <li class="tablinks"><a href="#" onclick="show(event,'delete-user-page')">Delete User</a></li>
    </ul>
  </div>
</nav>
  
	
	
	<div id="view-users-page" class="tabcontent">
		<h1 align="center">Users List</h1>
		<br />
		<table class="table" >
			<tr>
				<th>User Name</th>
				<th>Calorie limit</th>
			</tr>
		    <tbody id="users-list"></tbody>
	
		</table>
		
    </div>

   
   <div id="view-user-calories-page" class="tabcontent">
    <h1 align="center">User Calories List</h1>
		<br />
		<table class="table" >
			<tr>
				<th>User Name</th>
				<th>Item Name</th>
			    <th>Total Calories</th>
	
			</tr>
		    <tbody id="user-calorie-list"></tbody>
	
		</table>
	     
   
   </div>
   
   <div id="delete-user-page" class="tabcontent">
     <div id="feedback"></div>

        <form class="form-horizontal" id="delete-form">
            <div class="form-group form-group-lg">
                <label class="col-sm-2 control-label">User Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="userName"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" id="bth-search"
                            class="btn btn-primary btn-lg">Delete
                    </button>
                </div>
            </div>
        </form>
   </div>
   
   
   

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${contextPath}/resources/js/common.js"></script>
	
</body>
</html>