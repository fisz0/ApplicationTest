<#import "template.ftl" as template>

<#-- @ftlvariable name="user" type="eu.kielczewski.example.domain.User" -->
<@template.htmlTemplate>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>User details</h1>

<p>E-mail: ${user.email}</p>

<p>Role: ${user.role}</p>
</@template.htmlTemplate>