<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page errorPage="ErrorPage.jsp" %>

<%--<fmt:setLocale value="${pageContext.request.getSession(false).getAttribute('localisation')}" />--%>

<fmt:setLocale value="${sessionScope.localisation}"/>
<%--${pageContext.request.setAttribute("next-page", "login")}--%>

<!DOCTYPE html>
<html lang="ru" dir="ltr">

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Airline registration page</title>
</head>

<body>
<c:set var="current_page" value="login" scope="application"/>

<fmt:bundle basename="ui">

    <nav class="navbar navbar-dark bg-primary justify-content-end">


        <form action="" method="post">
            <input type="hidden" name="command" value="set_language"/>
            <input type="hidden" name="page" value="login"/>

            <div class="dropdown">
                <button class="btn btn-primary btn-sm dropdown-toggle" type="button" id="dropdownMenu2"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${sessionScope.localisation}
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenu2">

                    <button class="dropdown-item btn-sm" type="submit" id="b-1" name="language"
                            value="ru">Русский
                    </button>


                    <button class="dropdown-item btn-sm" type="submit" id="b-2" name="language"
                            value="us">English
                    </button>

                </div>
            </div>
        </form>


    </nav>


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
                            <div class="d-inline-block">
                                <button type="submit" class="btn btn-primary" name="command" value="loginuser">
                                    <fmt:message key="button.login"/>
                                </button>
                            </div>
                            <div class="d-inline-block">
                                <button type="submit" class="btn btn-primary" name="command" value="gotoregisterform">
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

    <footer class="page-footer font-small blue">

        <div class="footer-copyright text-center py-3">© 2020 Copyright:
            <a href="https://mdbootstrap.com/"> MDBootstrap.com</a>
        </div>

    </footer>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

</fmt:bundle>
</body>

