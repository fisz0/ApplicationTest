<#import "template.ftl" as template>
<#import "lorem.ftl" as lorem>
<#import "/spring.ftl" as spring>

<@template.htmlTemplate>
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.mokon.spring.boot.backend.domain.UserCreateForm" -->

    <@lorem.lorem/>
</@template.htmlTemplate>
