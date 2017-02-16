<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="users" type="java.util.List<com.mokon.spring.boot.backend.model.entity.User>" -->
<table class="table table-bordered table-responsive" id="usersTable">
    <thead>
    <tr>
        <th>Login</th>
        <th>Name</th>
        <th>Last name</th>
        <th>E-mail</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>
            <button type="button" name="${user.id}" id="userDetailsBtn" class="linkBtn">${user.login}</button>
        </td>
        <td>${user.name}</td>
        <td>${user.lastName}</td>
        <td class="fit">${user.email}</td>
        <td>${user.role}</td>
        <#if user.id==currentUser.id>
            <td class="removeUserCell">
                <button type="button" disabled="disabled" id="${user.id}"
                        class="deleteUserBtn btn btn-default pull-right showopacity glyphicon glyphicon-remove">
                </button>
            </td>
        <#else>
            <td class="removeUserCell">
                <button type="button" id="${user.id}"
                        class="deleteUserBtn btn btn-block btn-danger showopacity glyphicon glyphicon-remove">
                </button>

            </td>
        </#if>
    </tr>
    </#list>
    </tbody>
</table>
