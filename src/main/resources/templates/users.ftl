<#import "template.ftl" as template>

<#-- @ftlvariable name="users" type="java.util.List<eu.kielczewski.example.domain.User>" -->
<@template.htmlTemplate>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/user/create">Create a new user</a></li>
    </ul>
</nav>

<h1>List of Users</h1>

<table>
    <thead>
    <tr>
        <th>E-mail</th>
        <th>Role</th>
    </tr>
    </thead>
    <tbody>
        <#list users as user>
        <tr>
            <td><a href="/user/${user.id}">${user.email}</a></td>
            <td>${user.role}</td>
        </tr>
        </#list>
    </tbody>
</table>
</@template.htmlTemplate>