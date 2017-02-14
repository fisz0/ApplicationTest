<#import "template.ftl" as template>
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="users" type="java.util.List<com.mokon.spring.boot.backend.model.entity.User>" -->
<@template.htmlTemplate>
<div class="Absolute-Center is-Responsive">
    <table class="table table-bordered" id="usersTable">
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
                <#if user.id!=currentUser.id>
                    <td>
                        <button type="button" onclick="deleteUser(${user.id})"><span
                                class="pull-right hidden-xs showopacity glyphicon glyphicon-remove"></span>

                    </td>
                </#if>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</@template.htmlTemplate>
