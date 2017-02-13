<#import "template.ftl" as template>
<#import "/spring.ftl" as spring>

<@template.htmlTemplate>
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.mokon.spring.boot.backend.domain.UserCreateForm" -->
<div class="Absolute-Center is-Responsive">
    <h1>Create a new user</h1>
    <form role="form" name="form" action="" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="form-group">
            <label for="email">Email address:</label>
            <input type="email" class="form-control" name="email" id="email" value="${form.email}" required autofocus/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" name="password" id="password" required/>
        </div>
        <div class="form-group">
            <label for="passwordRepeated">Repeat:</label>
            <input type="password" class="form-control" name="passwordRepeated" id="passwordRepeated" required/>
        </div>
        <div class="form-group">
            <label for="role">Role</label>
            <select name="role" id="role" class="form-control" required>
                <#list roles as role>
                    <option <#if form.role == role>selected</#if>>USER</option>
                </#list>
            </select>
        </div>
        <button class="btn btn-def btn-block" type="submit">Save</button>
    </form>
    <@spring.bind "form" />
    <#if spring.status.error>
        <#list spring.status.errorMessages as error>
            <p class="errorParagraph text-center">${error}</p>
        </#list>
    </#if>
</div>
</@template.htmlTemplate>
