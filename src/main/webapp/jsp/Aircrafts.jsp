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
    <script type="text/javascript" src="sources/js/script.js"></script>
    <link rel="icon" type="image/icon type" href="sources/images/logo-airline.png">
    <title>Aircrafts</title>
</head>

<body>

<c:set var="current_page" value="Aircrafts" scope="request"/>

<fmt:bundle basename="ui">

    <%--HEADER--%>
    <c:import url="Header.jsp"/>

    <!-- Modal -->
    <div class="modal fade" id="alertMessage" role="dialog">
        <div class="modal-dialog modal-dialog-centered">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Modal Header</h4>
                </div>
                <div class="modal-body">
                    <p id="alert_1"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>


    <%--Card--%>
    <div class="d-flex justify-content-center">
        <div class="card mb-5 border-primary" style="max-width: 920px;">
            <div class="row no-gutters">
                <div class="col-md-6">
                    <div class="card-body">

                            <%--Card title--%>
                        <h5 class="card-title text-primary"><fmt:message key="label.aircraft_management"/></h5>

                            <%--Form--%>
                        <form id="add-aircraft-form" class="form" action="" method="post">
                            <input type="hidden" name="page" value="aircrafts"/>
                            <input type="hidden" name="command" value="ADD_AIRCRAFT"/>
                            <div class="form-group">
                                <label for="text-box-1" class="text-primary">
                                    <fmt:message key="label.aircraft_model_name"/>
                                </label><br>
                                <input type="text" name="aircraft_model_name" id="text-box-1"
                                       class="form-control border-primary">
                            </div>
                            <div class="form-group">
                                <label for="text-box-2" class="text-primary">
                                    <fmt:message key="label.aircraft_capacity"/>
                                </label><br>
                                <input type="text" name="aircraft_model_capacity" id="text-box-2"
                                       class="form-control border-primary">
                            </div>
                            <div class="form-group">
                                <label for="text-box-3" class="text-primary">
                                    <fmt:message key="label.aircraft_bord_number"/>
                                </label><br>
                                <input type="text" name="aircraft_side_number" id="text-box-3"
                                       class="form-control border-primary">
                            </div>
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
                                    <button type="button" class="btn btn-outline-primary" onclick="aircraftsPageAlert()">
                                        JS-alert
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
<script src="css/bootstrap.min.js"></script>
<script src="css/bootstrap.bundle.min.js"></script>

</body>

</html>