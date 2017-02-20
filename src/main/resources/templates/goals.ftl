<#import "template.ftl" as template>
<#import "lorem.ftl" as lorem>
<#-- @ftlvariable name="users" type="java.util.List<eu.kielczewski.example.domain.User>" -->

<@template.htmlTemplate>
<div id="userTableContainer" class="basicPanel basicLeftPanel">
    <@lorem.lorem />
</div>
<div id="userDetailsPanel" class="basicPanel basicRightPanel">
    <@lorem.lorem />
</div>
<div id="usersBottomPanel" class="basicPanel basicBottomPanel">
    <@lorem.lorem />
    <@lorem.lorem />
</div>
</@template.htmlTemplate>
