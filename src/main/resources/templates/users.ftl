<#import "template.ftl" as template>

<#-- @ftlvariable name="users" type="java.util.List<eu.kielczewski.example.domain.User>" -->
<@template.htmlTemplate>
<div class="Absolute-Center is-Responsive">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Login</th>
            <th>Name</th>
            <th>Last name</th>
            <th>E-mail</th>
            <th>Role</th>
        </tr>
        </thead>
        <tbody>
            <#list users as user>
            <tr>
                <td><a href="/user/${user.id}">${user.login}</a></td>
                <td>${user.name}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.role}</td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>


</@template.htmlTemplate>
