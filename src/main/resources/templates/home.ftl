<#import "template.ftl" as template>
<#import "lorem.ftl" as lorem>
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="com.mokon.spring.boot.backend.domain.CurrentUser" -->
<@template.htmlTemplate>
    <#if !currentUser??>
    <script>redirectToLoginPage()</script>
    <#else>
        <@lorem.lorem/>
    </#if>
</@template.htmlTemplate>
