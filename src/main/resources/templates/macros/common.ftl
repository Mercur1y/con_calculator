<#macro page>
    <!DOCTYPE html>
    <html lang="ru-RU">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Строительный калькулятор</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

        <#--        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">-->
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="/static/css/styles.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
              integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
              crossorigin="anonymous">
        <!-- Font Awesome -->
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    </head>
    <body>
    <div class="container mt-5">
        <#nested>
    </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <!-- Подключение JS файла Popper -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"></script>
    <!-- Подключение JS файла Bootstrap с плагинами -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
            integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
            crossorigin="anonymous"></script>
    </html>
</#macro>

<#macro navpage>
    <!DOCTYPE html>
    <html lang="ru-RU">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Строительный калькулятор</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

        <#--        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">-->
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="/static/css/styles.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
        <!-- Font Awesome -->
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat" rel="stylesheet">

        <script src="/static/js/script.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js"></script>
        <script src="https://unpkg.com/imask" type="text/javascript"></script>
        <!-- Подключение JS файла Popper -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
                integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
                crossorigin="anonymous"></script>
        <!-- Подключение JS файла Bootstrap с плагинами -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
                integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
                crossorigin="anonymous"></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.bundle.min.js'></script>
    </head>
    <body>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #16252a;">
        <div class="container-fluid">
            <!-- Toggle button -->
            <button
                    class="navbar-toggler"
                    type="button"
                    data-mdb-toggle="collapse"
                    data-mdb-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <i class="fas fa-bars"></i>
            </button>

            <!-- Collapsible wrapper -->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <!-- Navbar brand -->
                <a id="nav-key" class="navbar-brand mt-4 mt-lg-0" href="#">
                    <i class="fa fa-crop" aria-hidden="true"></i>
                </a>
                <!-- Left links -->
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="/main">Главная</a>
                    </li>
                </ul>
            </div>
            <!-- Collapsible wrapper -->

            <!-- Right elements -->
            <div class="nav-item dropdown">
                <span class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown"
                   aria-expanded="false">
                    <i class="fa fa-user mr-2" aria-hidden="true"></i>${user.lastName}&nbsp${user.firstName}
                </span>
                <ul class="dropdown-menu mb-2" aria-labelledby="navbarDropdownMenuLink">
                    <li>
                        <form action="/logout" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <button class="dropdown-item mb-2" type="submit">Выход</button>
                        </form>
                    </li>
                    <li class="divider"></li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Navbar -->
    <button type="submit"
            class="btn btn-icon mt-2 ml-2"
            style="background-color:transparent"
            onclick="window.history.go(-1); return false;"
    >
        <span class="icon mr-2"><i class="fa fa-angle-left"></i></span>
        Назад
    </button>
    <div class="container mt-2" style="max-width: 1150px">
        <#nested>
    </div>
    </body>
    </html>
</#macro>