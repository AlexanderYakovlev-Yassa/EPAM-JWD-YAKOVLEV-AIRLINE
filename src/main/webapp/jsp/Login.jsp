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
    <link rel="icon"  type="image/icon type" href="sources/images/logo-airline.png">
    <title>Airline</title>
</head>

<body>

<c:set var="current_page" value="login" scope="session"/>

<fmt:bundle basename="ui">

    <%--HEADER--%>
    <c:import url="Header.jsp"/>

    <div class="d-flex justify-content-center">
        <div class="card mb-5 border-primary" style="max-width: 920px;">
            <div class="row no-gutters">
                <div class="col-md-6">
                    <div class="card-body">
                        <h5 class="card-title text-primary"><fmt:message key="label.login_form"/></h5>
                        <form id="login-form" class="form" action="" method="post">
                            <div class="form-group">
                                <label for="usernicname" class="text-primary">
                                    <fmt:message key="label.user_nickname"/>
                                </label><br>
                                <input type="text" name="employee_nickname" id="usernicname"
                                       class="form-control border-primary">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-primary">
                                    <fmt:message key="label.password"/>
                                </label><br>
                                <input type="password" name="employee_password" id="password"
                                       class="form-control border-primary">
                            </div>
                            <div class="form-group">
                                <div class="d-flex justify-content-between">
                                    <button type="submit" class="btn btn-outline-primary" name="command"
                                            value="login_user">
                                        <fmt:message key="button.login"/>
                                    </button>
                                    <button type="submit" class="btn btn-outline-primary" name="command"
                                            value="GOTO_REGISTRATION_PAGE">
                                        <fmt:message key="button.register"/>
                                    </button>
                                    <button type="submit" class="btn btn-outline-primary" name="command"
                                            value="GOTO_PAGE">
                                        <input type="hidden" name="page" value="index"/>
                                        <fmt:message key="button.home"/>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-6">
                    <img src="sources/images/them-picture-light.jpg" class="card-img mt-5">
                </div>
            </div>
        </div>
    </div>

    <div>
        <br/><br/><br/><br/>
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