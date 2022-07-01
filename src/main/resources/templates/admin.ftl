<#import "macros/common.ftl" as c>
<#include "macros/security.ftl">
<@c.page>
    <h3>Список пользователей</h3>
    <form action="/user/new" method="get">
        <button class = "btn btn-primary">Добавить</button>
    </form>

    <table cellpadding="7">
        <thead>
        <tr>
            <th>Логин</th>
            <th>Роль</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role.name}</#list></td>
                <td>
                    <form action="user/${user.id}" method="get">
                        <button type="submit" class = "btn btn-success">Редактировать</button>
                    </form>
                </td>
                <td>
                    <form action="/admin" method="post">
                        <input type="hidden" name="userId" value="${user.id}"/>
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <input type="hidden" name="action" value="delete"/>
                        <button type="submit" class = "btn btn-danger">Удалить</button>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>

</@c.page>