<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body>

<nav class="navbar navbar-dark bg-primary justify-content-end">
    <form action="" method="post">
        <input type="hidden" name="command" value="set_language"/>
        <input type="hidden" name="page" value="${requestScope.current_page}"/>
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

</body>
</html>
