<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.localisation}"/>

<html>

<head>
    <title>Header</title>
</head>

<body>

<fmt:bundle basename="ui">

    <div><br/></div>

    <%--Top toolbar--%>
    <div class="container">
        <div class="row">

                <%--Logo--%>
            <div class="col-4 d-flex justify-content-start">
                    <%--<div class="btn logo-img"></div>--%>
                <img src="sources/images/logo-airline-100.png" class="img-fluid" alt="Responsive image"/>
            </div>


            <div class="col-8 d-flex justify-content-end">
                    <%--Current user name--%>
                <div class="btn btn-link">${sessionScope.get("current_session_user")}</div>

                    <%--Form for selecting language--%>
                <form action="" method="post">
                    <input type="hidden" name="command" value="set_language"/>
                    <input type="hidden" name="page" value="${requestScope.current_page}"/>
                    <button class="btn btn-outline-primary" type="submit" name="language" value="ru">
                        Рус
                    </button>
                    <button class="btn btn-outline-primary" type="submit" name="language" value="us">
                        Eng
                    </button>
                </form>

            </div>

        </div>
    </div>

    <div><br/></div>

    <%--Toolbar--%>
    <div class="container">
        <div class="row">
            <div class="col-12 pb-2">

                <form action="" method="post">
                    <input type="hidden" name="command" value="goto_page"/>
                    <button class="btn btn-outline-primary" type="submit" name="page" value="index">
                        <fmt:message key="button.home"/>
                    </button>
                    <button class="btn btn-outline-primary" type="submit" name="page" value="login">
                        <fmt:message key="button.login"/>
                    </button>
                    <input type="hidden" name="command" value="goto_page"/>
                    <button class="btn btn-outline-primary" type="submit" name="page" value="aircrafts">
                        <fmt:message key="button.aircrafts"/>
                    </button>
                    <button class="btn btn-outline-primary" type="submit" name="page" value="employee">
                        <fmt:message key="button.personell_management"/>
                    </button>
                    <div class="btn btn-outline-primary">Flights</div>
                    <div class="btn btn-outline-primary">User cabinet</div>
                </form>

            </div>
        </div>
    </div>

</fmt:bundle>

</body>

</html>
