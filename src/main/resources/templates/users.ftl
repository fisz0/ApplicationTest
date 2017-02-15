<#import "template.ftl" as template>
<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="users" type="java.util.List<com.mokon.spring.boot.backend.model.entity.User>" -->
<@template.htmlTemplate>
<div class="Absolute-Center is-Responsive col-lg-4 col-sm-6 col-xs-12 divBordered" id="usersTable">
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
                    <td>
                        <button type="button" disabled="disabled"
                                class="btn btn-default pull-right showopacity glyphicon glyphicon-remove"
                                onclick="deleteUser(${user.id})">
                        </button>
                    </td>
                <#else>
                    <td>
                        <button type="button"
                                class="btn btn-block btn-danger showopacity glyphicon glyphicon-remove"
                                onclick="deleteUser(${user.id})">
                        </button>

                    </td>
                </#if>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
<div id="injectContainer" class="Absolute-Center is-Responsive col-lg-4 col-sm-6 col-xs-12 divBordered usersDiv">

</div>
</@template.htmlTemplate>
