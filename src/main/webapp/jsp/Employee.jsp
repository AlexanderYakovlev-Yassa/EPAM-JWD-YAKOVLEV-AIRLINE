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
    <title>Airline</title>
</head>

<body>

<c:set var="current_page" value="employee" scope="request"/>

<fmt:bundle basename="ui">


    <c:import url="Header.jsp"/><%--HEADER--%>

    <div class="container">
        <div class="row"><%--0--%>
            <div class="col-12" align="center">
                <h3 class="text-center text-primary pt-5"><fmt:message key="label.personell_management"/></h3>
            </div>
        </div>
            <%--0--%>
        <div class="row"><%--A--%>
            <div class="col-4 card border-primary"><%--B1--%>
                <h4 class="text-center text-primary pt-5"><fmt:message key="label.employee_list"/></h4>
                <div class="overflow-auto" style="heigth: 200px"><%--C--%>

                    <ul class="list-group">
                        <li class="list-group-item">Cras justo odio</li>
                        <li class="list-group-item">Dapibus ac facilisis in</li>
                        <li class="list-group-item">Morbi leo risus</li>
                        <li class="list-group-item">Porta ac consectetur ac</li>
                        <li class="list-group-item">Vestibulum at eros</li>
                        <li class="list-group-item">Cras justo odio</li>
                        <li class="list-group-item">Dapibus ac facilisis in</li>
                        <li class="list-group-item">Morbi leo risus</li>
                        <li class="list-group-item">Porta ac consectetur ac</li>
                        <li class="list-group-item">Vestibulum at eros</li>
                        <li class="list-group-item">Cras justo odio</li>
                        <li class="list-group-item">Dapibus ac facilisis in</li>
                        <li class="list-group-item">Morbi leo risus</li>
                        <li class="list-group-item">Porta ac consectetur ac</li>
                        <li class="list-group-item">Vestibulum at eros</li>
                    </ul>

                </div>
                    <%--C--%>
            </div>
                <%--B1--%>

            <div class="col-8 card border-primary"><%--B2--%><%--Card employee info--%>
                <h4 class="text-center text-primary pt-5"><fmt:message key="label.employee_info"/></h4>

                <form id="add-aircraft-form" class="form" action="" method="post"><%--Form--%>
                    <div class="row"><%--D--%>
                        <div class="col-md-6"><%--D1--%>
                            <div class="card-body">
                                <%--<input type="hidden" name="page" value="employee"/>
                                <input type="hidden" name="command" value="ADD_AIRCRAFT"/>--%>

                                <div class="form-group"><%--login name--%>
                                    <label for="text-box-1" class="text-primary">
                                        <fmt:message key="label.user_nickname"/>
                                    </label><br>
                                    <input type="text" name="employee_nickame" id="text-box-1"
                                           class="form-control border-primary">
                                </div>

                                <div class="form-group"><%--first name--%>
                                    <label for="text-box-2" class="text-primary">
                                        <fmt:message key="label.user_first_name"/>
                                    </label><br>
                                    <input type="text" name="employee_first_name" id="text-box-2"
                                           class="form-control border-primary">
                                </div>

                                <div class="form-group"><%--last name--%>
                                    <label for="text-box-3" class="text-primary">
                                        <fmt:message key="label.user_last_name"/>
                                    </label><br>
                                    <input type="text" name="employee_last_name" id="text-box-3"
                                           class="form-control border-primary">
                                </div>
                            </div>
                        </div>
                            <%--D1--%>
                        <div class="col-md-6"><%--D2--%>

                            <div class="form-group"><%--system role--%>
                                <label for="text-box-3" class="text-primary">
                                    <fmt:message key="label.system_role"/>
                                </label><br>
                                <input type="text" name="employee_system_role" id="text-box-4"
                                       class="form-control border-primary dropdown-toggle">
                            </div>

                            <div class="form-group"><%--crew role--%>
                                <label for="text-box-3" class="text-primary">
                                    <fmt:message key="label.crew_role"/>
                                </label><br>
                                <input type="text" name="employee_crew_role" id="text-box-5"
                                       class="form-control border-primary">
                            </div>
                        </div>
                            <%--D2--%>
                    </div>
                        <%--D--%>

                    <div class="row">

                        <div class="col-md-12"><%--F--%>
                            <div class="form-group">
                                <div class="d-flex justify-content-between">
                                    <button type="submit" class="btn btn-outline-primary" name="command"
                                            value="add_aircraft">
                                        <fmt:message key="button.add"/>
                                    </button>
                                    <button type="submit" class="btn btn-outline-primary" name="command"
                                            value="delete_aircraft">
                                        <fmt:message key="button.delete"/>
                                    </button>
                                    <button type="submit" class="btn btn-outline-primary" name="command"
                                            value="GOTO_PAGE">
                                        <input type="hidden" name="page" value="index"/>
                                        <fmt:message key="button.home"/>
                                    </button>
                                    <button type="button" class="btn btn-outline-primary"
                                            onclick="aircraftsPageAlert()">
                                        JS-alert
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                        <%--F--%>
                </form>
            </div>
                <%--B2--%>
        </div>
            <%--A--%>
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