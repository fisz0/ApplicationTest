<#import "template.ftl" as template>
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="com.mokon.spring.boot.backend.domain.CurrentUser" -->
<@template.htmlTemplate>
<nav role="navigation">
    <ul>
        <#if !currentUser??>
            <li><a href="/login">Log in</a></li>
        </#if>
        <#if currentUser??>
            <form action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-def btn-block">Log out</button>
            </form>
            <li><a href="/user/${currentUser.id}">View myself</a></li>
        </#if>
        <#if currentUser?? && currentUser.role == "ADMIN">
            <li><a href="/user/create">Create a new user</a></li>
            <li><a href="/users">View all users</a></li>
        </#if>
    </ul>
</nav>
</@template.htmlTemplate>
