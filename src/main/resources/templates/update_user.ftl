<#import "template.ftl" as template>
<#import "spring.ftl" as spring>
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.mokon.spring.boot.backend.domain.UserCreateForm" -->
<@template.htmlTemplate>
<div class="basicPanel basicLeftPanel">
    <form role="form" name="updateForm" action="/update" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="form-group">
            <label for="login">Login:</label>
            <input type="text" class="form-control" name="login" id="login" value="${currentUser.login}"
                   placeholder="Login"
                   required autofocus/>
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" name="name" id="name" value="${currentUser.name}" placeholder="Name"
                   required/>
        </div>
        <div class="form-group">
            <label for="lastName">Last name:</label>
            <input type="text" class="form-control" name="lastName" id="lastName" value="${currentUser.lastName}"
                   placeholder="Last name"
                   required/>
        </div>
        <div class="form-group">
            <label for="email">Email address:</label>
            <input type="email" class="form-control" name="email" id="email" value="${currentUser.email}"
                   placeholder="E-mail"
                   required/>
        </div>
        <button class="btn btn-def btn-block" type="submit">Update</button>
    </form>
    <@spring.bind "updateForm" />
    <#if spring.status.error>
        <#list spring.status.errorMessages as error>
            <p class="errorParagraph text-center">${error}</p>
        </#list>
    </#if>
</div>
<div class="basicPanel basicRightPanel"></div>
<div class="basicPanel basicBottomPanel"></div>
</@template.htmlTemplate>
