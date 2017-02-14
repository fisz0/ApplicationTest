<#import "template.ftl" as template>
<#import "createUser.ftl" as createForm>
<#-- @ftlvariable name="users" type="java.util.List<com.mokon.spring.boot.backend.domain.UserCreateForm>" -->
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<@template.htmlTemplate>
    <@createForm.createUser/>
</@template.htmlTemplate>
