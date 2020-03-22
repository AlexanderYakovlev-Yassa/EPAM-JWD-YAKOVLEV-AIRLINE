<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page errorPage="ErrorPage.jsp" %>

<fmt:setLocale value="${sessionScope.localisation}"/>


<!DOCTYPE html>
<html lang="ru" dir="ltr">

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <title>Airline welcome page</title>
</head>

<body>
<c:set var="current_page" value="index" scope="request"/>
<fmt:bundle basename="ui">

    <div class="main-background">

        <c:import url="Header.jsp" />

        <div>
            <br/> <br/> <br/> <br/>
        </div>

        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="" method="post">
                            <h3 class="text-center text-info"><fmt:message key="label.welcome"/></h3>
                            <div class="form-group">
                                <div class="d-flex justify-content-between">
                                    <button type="submit" class="btn btn-primary" name="command" value="goto_login_page">
                                        <fmt:message key="button.login"/>
                                    </button>
                                    <button type="submit" class="btn btn-primary" name="command" value="goto_registration_page">
                                        <fmt:message key="button.register"/>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <c:import url="Footer.jsp" />

    </div>
</fmt:bundle>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>--%>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>


</body>

</html>