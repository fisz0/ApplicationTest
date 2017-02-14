<#import "template.ftl" as template>

<#-- @ftlvariable name="user" type="com.mokon.spring.boot.backend.model.entity.User" -->
<@template.htmlTemplate>
<div class="Absolute-Center is-Responsive">

    <h1 class="text-center">User details</h1>
    <p>
    <div class="infoLabel">Login:</div>
    ${user.login}</p>
    <p>
    <p>
    <div class="infoLabel">Name:</div>
    ${user.name}</p>
    <p>
    <p>
    <div class="infoLabel">Last name:</div>
    ${user.lastName}</p>
    <p>
    <div class="infoLabel">E-mail:</div>
    ${user.email}</p>

    <p>
    <div class="infoLabel">Role:</div>
    ${user.role}</p>
</div>
</@template.htmlTemplate>
