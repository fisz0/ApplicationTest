<#import "template.ftl" as template>

<#-- @ftlvariable name="users" type="java.util.List<eu.kielczewski.example.domain.User>" -->
<@template.htmlTemplate>
<div class="Absolute-Center is-Responsive">
    <h1 class="text-center">List of Users</h1>
    <table class="table table-bordered">
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
</div>


</@template.htmlTemplate>
