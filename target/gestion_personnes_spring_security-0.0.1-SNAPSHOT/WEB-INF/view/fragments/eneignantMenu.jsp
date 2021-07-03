<%--
  Created by IntelliJ IDEA.
  User: KURAPIKA.dll
  Date: 6/1/2021
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link active"
                                aria-current="page"
                                href="${pageContext.request.contextPath}/admin/showAdminHome">Home</a></li>
        <li class="nav-item"><a class="nav-link"
                                href="${pageContext.request.contextPath}/admin/showForm">Saisir des absences</a></li>
        <li class="nav-item"><a class="nav-link"
                                href="${pageContext.request.contextPath}/admin/managePersons">fiche d’absence</a></li>

        <li class="nav-item"><a class="nav-link"
                                href="${pageContext.request.contextPath}/admin/createAccounts">Demandes</a></li>
        <li class="nav-item"><a class="nav-link"
                                href="${pageContext.request.contextPath}/admin/manageAccounts">List
            Accounts</a></li>
        <li class="nav-item"><f:form
            action="${pageContext.request.contextPath}/logout" method="POST">

            <button type="submit" class="btn btn-link">logout</button>

        </f:form></li>


    </ul>
</div>
