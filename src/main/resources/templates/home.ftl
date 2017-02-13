<#import "template.ftl" as template>
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="com.mokon.spring.boot.backend.domain.CurrentUser" -->
<@template.htmlTemplate>
    <#if !currentUser??>
    <meta HTTP-EQUIV="REFRESH" content="0; /login">
    </#if>
</@template.htmlTemplate>
