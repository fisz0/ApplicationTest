<#import "template.ftl" as template>
<#import "createUser.ftl" as createForm>

<@template.htmlTemplate>
<div class="basicPanel basicLeftPanel">
    <@createForm.createUser isAdminEnabled='true'/>
</div>
</@template.htmlTemplate>
