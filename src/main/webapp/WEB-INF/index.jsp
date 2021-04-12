<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>NinjaGold</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h1>Your gold:${ gold } </h1>

<div class="container">
        <div class="farm">
            <form action='/' method='post'>
                <h3>Farm</h3>
                <p>(Earns 10-20 golds)</p>
                <br>
                
                <input type="hidden" name="farm" value="farm">
                <a href="/"><button class="btn btn-success">Find Gold!</button></a>
            </form>
        </div>
        <div class="cave">
            <form action='/' method='post'>
                <h3>Cave</h3>
                <p>(Earns 5-10 golds)</p>
                <br>
              
                <input type="hidden" name="cave" value="cave">
                <a href="/"><button class="btn btn-success">Find Gold!</button></a>
            </form>
        </div>
        <div class="house">
            <form action='/' method='post'>
                <h3>House</h3>
                <p>(Earns 2-5 golds)</p>
                <br>
              
                <input type="hidden" name="house" value="house">
                <a href="/"><button class="btn btn-success">Find Gold!</button></a>
            </form>
        </div>
        <div class="casino">
            <form action='/' method='post'>
                <h3>Casino</h3>
                <p>(Earns 0-50 golds)</p>
                <br>
               
                <input type="hidden" name="casino" value="casino">
                <a href="/"><button class="btn btn-success">Find Gold!</button></a>
            </form>
        </div>
        <form action="/destroy" method="POST">
        <input name="destroy" type="submit" value="Reset">
        </form>
    </div>
    
    <div class="activities">
    <c:forEach var="activity" items="${ activities }">
    	<h2>${ activity }</h2>
    </c:forEach>
    
    </div>

</body>
</html>