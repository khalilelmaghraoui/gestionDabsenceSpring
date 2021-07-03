<%--
  Created by IntelliJ IDEA.
  User: KURAPIKA.dll
  Date: 6/1/2021
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/enseignantHeader.jsp" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <s:authorize access="isAuthenticated()">
    <h1>Hello <s:authentication property="firstName"/></h1>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">



          <jsp:include page="../fragments/eneignantMenu.jsp"/>

        </div>
    </nav>

    <div>
        <h3>User home page</h3>
        <p>Hello and welcome to your application</p>


            You are connected with:
            <s:authentication property="principal.username" /> <br>
            Your Email : <s:authentication property="principal.email" /><br>
            Your First Name : <s:authentication property="principal.firstName" /><br>
            Your Last name : <s:authentication property="principal.LastName" /><br>
        </s:authorize>
    </div>

</div>

</body>
</html>
