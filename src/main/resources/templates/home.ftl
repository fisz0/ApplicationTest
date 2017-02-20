<#import "template.ftl" as template>
<#import "lorem.ftl" as lorem>
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="com.mokon.spring.boot.backend.domain.CurrentUser" -->
<@template.htmlTemplate>
    <#if currentUser??>
    <div class="basicPanel basicLeftPanel">
        <@lorem.lorem />
    </div>
    <div class="basicPanel basicRightPanel">
        <@lorem.lorem />
    </div>
    <div class="basicPanel basicBottomPanel">
        <@lorem.lorem />
    <@lorem.lorem />
    </div>
    <#else>
    <script>redirectToLoginPage()</script>
    </#if>
</@template.htmlTemplate>
