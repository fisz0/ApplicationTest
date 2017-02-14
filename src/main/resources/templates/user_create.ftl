<#import "template.ftl" as template>
<#import "/spring.ftl" as spring>

<@template.htmlTemplate>
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.mokon.spring.boot.backend.domain.UserCreateForm" -->
<div class="Absolute-Center is-Responsive">
    <form role="form" name="form" action="" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="form-group">
            <label for="login">Login:</label>
            <input type="text" class="form-control" name="login" id="login" value="${form.login}" placeholder="Login"
                   required autofocus/>
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" name="name" id="name" value="${form.name}" placeholder="Name"
                   required/>
        </div>
        <div class="form-group">
            <label for="lastName">Last name:</label>
            <input type="text" class="form-control" name="lastName" id="lastName" value="${form.lastName}"
                   placeholder="Last name"
                   required/>
        </div>
        <div class="form-group">
            <label for="email">Email address:</label>
            <input type="email" class="form-control" name="email" id="email" value="${form.email}" placeholder="E-mail"
                   required/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="Password" required/>
        </div>
        <div class="form-group">
            <label for="passwordRepeated">Repeat:</label>
            <input type="password" class="form-control" name="passwordRepeated" id="passwordRepeated"
                   placeholder="Repeat password" required/>
        </div>
        <div class="form-group">
            <label for="role">Role</label>
            <select name="role" id="role" class="form-control" required>
                <#list roles as role>
                    <option>${role}</option>
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
