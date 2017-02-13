<#import "template.ftl" as template>

<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<@template.htmlTemplate>
<div class="Absolute-Center is-Responsive">
    <form role="form" action="/login" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <h1 class="text-center" id="loginBanner">Log in</h1>
        <div class="form-group input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input class="form-control" type="email" name='email' placeholder="E-mail" autofocus/>
        </div>
        <div class="form-group input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <input class="form-control" type="password" name='password' placeholder="Password" required/>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="remember-me" id="remember-me">Remember me</a>
            </label>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-def btn-block">Login</button>
        </div>
        <#if error.isPresent()>
            <p class="errorParagraph text-center">The email or password you have entered is invalid, try again.</p>
        </#if>
    </form>
</div>

<div id="bottomTip">
    <p>You can use: demo@localhost / demo</p>
</div>

</@template.htmlTemplate>
