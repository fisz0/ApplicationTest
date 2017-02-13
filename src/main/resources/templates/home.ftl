<#import "template.ftl" as template>
<#import "spring.ftl" as spring>
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="com.mokon.spring.boot.backend.domain.CurrentUser" -->
<@template.htmlTemplate>
    <#if !currentUser??>
        <meta HTTP-EQUIV="REFRESH" content="0; /login">
    </#if>
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
                <li class="active"><a href="#">Home<span style="font-size:16px;"
                                                         class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Users <span class="caret"></span><span
                        style="font-size:16px;"
                        class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a>
                    <ul class="dropdown-menu forAnimate" role="menu">
                        <#if currentUser?? && currentUser.role == "ADMIN">
                            <li><a href="/user/create">Create user</a></li>
                            <li><a href="/users">View all users</a></li>
                        </#if>
                        <#if currentUser??>
                            <li><a href="/user/${currentUser.id}">View myself</a></li>
                        </#if>
                        <li class="divider"></li>
                        <li><a href="#">TODO: Separatet section</a></li>
                    </ul>
                </li>
                <li><a href="#">TODO: My Trainings<span style="font-size:16px;"
                                                     class="pull-right hidden-xs showopacity glyphicon glyphicon-th-list"></span></a>
                </li>
                <#if currentUser??>
                    <li><a href="/logout" id="logoutLink">Logout<span style="font-size:16px;"
                                                                      class="pull-right hidden-xs showopacity glyphicon glyphicon-log-out"></span></a>
                    </li>
                </#if>
            </ul>
        </div>
    </div>
</nav>
</@template.htmlTemplate>
