<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
	
</head>
<body>

<nav class="navbar navbar-inverse navbar-default">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">JD2 Project v 26</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="manager-form">Home</a></li>
            <c:choose>
				<c:when test="${not empty sessionScope.manager}">																							<!--если юзер в системе, то видна ссылка на свои расходы, если нет, то нет-->	
					<li class="disabled"><a href="#">Login</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="go-to-logination">Login</a></li>
				</c:otherwise>
			</c:choose>   
            
            <c:choose>
				<c:when test="${not empty sessionScope.manager}">																							<!--если юзер в системе, то видна ссылка на свои расходы, если нет, то нет-->	
					<li styly="font-color:white;"><a  href="go-to-manager-options">Manager options</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled" ><a href="#">Manager options</a></li>
				</c:otherwise>
			</c:choose>   
			<c:choose>
				<c:when test="${not empty sessionScope.manager}">																							<!--если юзер в системе, то видна ссылка на свои расходы, если нет, то нет-->	
					<li><a href="unlogination">Unlogin</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a href="#">Unlogin</a></li>
				</c:otherwise>
			</c:choose>   
			
            
<!--             <li class="dropdown"> -->
<!--               <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a> -->
<!--               <ul class="dropdown-menu"> -->
<!--                 <li><a href="#">Action</a></li> -->
<!--                 <li><a href="#">Another action</a></li> -->
<!--                 <li><a href="#">Something else here</a></li> -->
<!--                 <li role="separator" class="divider"></li> -->
<!--                 <li class="dropdown-header">Nav header</li> -->
<!--                 <li><a href="#">Separated link</a></li> -->
<!--                 <li><a href="#">One more separated link</a></li> -->
<!--               </ul> -->
<!--             </li> -->
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

<div class="container">
<div class="jumbotron" style="padding-bottom:300px;">
        <h1>Начни работу в Tour project!</h1>
        <p class="lead">Мы надеемся, что здесь вы найдете интересующую Вас информацию о странах и городах, где Вы уже побывали и хотите побывать снова, а также узнаете что-то новое о путешествиях, о турах и странах, где Вы еще не были, но мечтаете или готовитесь их посетить. Вы познакомитесь с историей компании,  с разнообразным  спектром услуг которые мы предлагаем. </p>
        
        <div class="row"></div>
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
        <div class="container"><p>Если ты менеджер - зарегистрируйся!</p></div>
        <form action="manager-registration" method="post">  
			E-mail: <input type="email" class="form-control" name="email" placeholder="Enter your e-mail" /> <br>
			Password: <input type="password" class="form-control" name="password" placeholder="Enter your password" /><br>
			<input class="btn btn-success btn" type="submit" />
		</form>
		<i style="color: red">
			<c:if test="${not empty requestScope.errorMessage}" >
				<c:out value="${requestScope.errorMessage}"/>
			</c:if>
		</i>
		</div>
		<div class="col-lg-3"></div>
</div>
	
</div>

<footer style="margin:100px 0 0 0; padding:0;">
      <div class="container">
        <p class="text-muted text-center">© 2018 New Corporation Inc.</p>
      </div>
 </footer>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>

</body>
</html>