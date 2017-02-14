<#import "template.ftl" as template>
<#import "createUser.ftl" as createForm>

<@template.htmlTemplate>
    <@createForm.createUser isAdminEnabled='true'/>
</@template.htmlTemplate>
