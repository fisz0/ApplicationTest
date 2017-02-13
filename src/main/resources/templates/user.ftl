<#import "template.ftl" as template>

<#-- @ftlvariable name="user" type="com.mokon.spring.boot.backend.model.entity.User" -->
<@template.htmlTemplate>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>
<div class="Absolute-Center is-Responsive">

    <h1 class="text-center">User details</h1>

    <p>
    <div class="infoLabel">E-mail:</div>${user.email}</p>

    <p>
    <div class="infoLabel">Role:</div>${user.role}</p>
</div>
</@template.htmlTemplate>
