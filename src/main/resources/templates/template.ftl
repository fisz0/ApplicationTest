<#import "/spring.ftl" as spring>
<#macro htmlTemplate>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home page</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <script src="/js/library.js"></script>

    <link href="/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <#if currentUser??>
    <nav class="navbar navbar-default sidebar is-Responsive" role="navigation">
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
                                <li><a href="/user/create">Create user</a></li>
                                <li><a href="/users">View all users</a></li>
                            </#if>
                            <li><a href="/user/${currentUser.id}">View myself</a></li>
                            <li class="divider"></li>
                            <li><a href="#">TODO: Separatet section</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Trainings<span style="font-size:16px;"
                                                   class="pull-right hidden-xs showopacity glyphicon glyphicon-th-list"></span></a>
                    </li>

                    <li><a href="#" id="logoutLink">Training Calendar<span style="font-size:16px;"
                                                                           class="pull-right hidden-xs showopacity glyphicon glyphicon-calendar"></span></a>
                    </li>
                    <li><a href="#" id="logoutLink">Progress monitor<span style="font-size:16px;"
                                                                          class="pull-right hidden-xs showopacity glyphicon glyphicon-signal"></span></a>
                    </li>
                    <li><a href="#" id="logoutLink">Goals<span style="font-size:16px;"
                                                               class="pull-right hidden-xs showopacity glyphicon glyphicon-flag"></span></a>
                    </li>
                    <li><a href="#" id="logoutLink">Logout<span style="font-size:16px;"
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
