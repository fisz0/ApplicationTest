<#import "/spring.ftl" as spring>
<#macro htmlTemplate>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>Home page</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <script src="/js/jquery-3.1.1.js"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.0.3/jquery-confirm.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.0.3/jquery-confirm.min.js"></script>

    <script src="/js/library.js"></script>

    <link href="/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <#if currentUser??>
    <nav class="navbar navbar-default sidebar" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#bs-sidebar-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">Home<span style="font-size:16px;"
                                                             class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Users <span
                                class="caret"></span><span
                                style="font-size:16px;"
                                class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a>
                        <ul class="dropdown-menu forAnimate" role="menu">
                            <#if currentUser.role == "ADMIN">
                                <li><a href="/admin/create">Create user</a></li>
                                <li><a href="/users">View all users</a></li>
                            </#if>
                            <li><a href="/user/${currentUser.id}">View myself</a></li>
                            <li class="divider"></li>
                            <li><a href="#">TODO: Separatet section</a></li>
                        </ul>
                    </li>
                    <li><a href="/trainings/${currentUser.id}">Trainings<span
                            class="menuItem pull-right hidden-xs showopacity glyphicon glyphicon-th-list"></span></a>
                    </li>

                    <li><a href="/calendar/${currentUser.id}">Training Calendar<span
                            class="pull-right hidden-xs showopacity glyphicon glyphicon-calendar"></span></a>
                    </li>
                    <li><a href="/progress/${currentUser.id}">Progress monitor<span
                            class="pull-right hidden-xs showopacity glyphicon glyphicon-signal"></span></a>
                    </li>
                    <li><a href="/goals/${currentUser.id}" id="logoutLink">Goals<span
                            class="pull-right hidden-xs showopacity glyphicon glyphicon-flag"></span></a>
                    </li>
                    <li><a href="/logout" id="logoutLink">Logout<span
                            class="pull-right hidden-xs showopacity glyphicon glyphicon-log-out"></span></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    </#if>
    <#nested>
</body>
</html>
</#macro>
