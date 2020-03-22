<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page errorPage="ErrorPage.jsp" %>

<fmt:setLocale value="${pageContext.request.getSession(false).getAttribute('localisation')}" />

<%--<fmt:setLocale value="${sessionScope.localisation}"/>--%>
<%--${pageContext.request.setAttribute("next-page", "login")}--%>

<!DOCTYPE html>
<html lang="ru" dir="ltr">

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Airline login page</title>
</head>

<body>
<c:set var="current_page" value="login" scope="request"/>

<fmt:bundle basename="ui">

    <c:import url="Header.jsp" />

    <h3 class="text-center text-white pt-5"><fmt:message key="label.login_form"/></h3>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <form id="login-form" class="form" action="" method="post">
                        <h3 class="text-center text-info"><fmt:message key="label.login_form"/></h3>
                        <div class="form-group">
                            <label for="userfirstname" class="text-info">
                                <fmt:message key="label.user_first_name"/>
                            </label><br>
                            <input type="text" name="userfirstname" id="userfirstname" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="usersecondname" class="text-info"><fmt:message
                                    key="label.user_last_name"/></label><br>
                            <input type="text" name="usersecondname" id="usersecondname" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="password" class="text-info"><fmt:message key="label.password"/></label><br>
                            <input type="text" name="password" id="password" class="form-control">
                        </div>
                        <div class="form-group">
                            <div class="d-flex justify-content-between">
                                <button type="submit" class="btn btn-primary" name="command" value="login_user">
                                    <fmt:message key="button.login"/>
                                </button>
                                <button type="submit" class="btn btn-primary" name="command" value="GOTO_REGISTRATION_PAGE">
                                    <fmt:message key="button.register"/>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div>
        <br/><br/><br/><br/>
    </div>

    <c:import url="Footer.jsp" />

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

</fmt:bundle>
</body>

