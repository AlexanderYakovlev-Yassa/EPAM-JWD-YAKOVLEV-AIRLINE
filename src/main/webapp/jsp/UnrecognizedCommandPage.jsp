<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.localisation}"/>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="sources/css/maket.css">
    <link rel="stylesheet" type="text/css" href="sources/css/bootstrap.min.css">
    <link rel="icon" href="sources/images/logo-airline.png" type="image/icon type">
    <script type="text/javascript" src="sources/js/AllPageScript.js"></script>
    <title>Unrecognized</title>
</head>

<body>

<c:set var="current_page" value="unrecognized_command_page" scope="session"/>

<fmt:bundle basename="ui">

    <%--HEADER--%>
    <c:import url="Header.jsp"/>

    <div align="center">
        <h3 class="text-center text-primary pt-5"><fmt:message key="label.security_alert"/></h3>
        <br/><br/>
        <h1 class="text-center text-primary pt-3"><fmt:message key="label.unrecognized_command"/></h1>
        
    </div>

    <c:import url="Footer.jsp"/>

</fmt:bundle>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="sources/css/bootstrap.min.js"></script>
<script src="sources/css/bootstrap.bundle.min.js"></script>

</body>

</html>