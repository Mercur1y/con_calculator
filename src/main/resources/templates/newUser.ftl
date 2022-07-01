<#import "macros/common.ftl" as c>
<#import "macros/login.ftl" as l>

<@c.page>
    <div align="center">
        <div class="mb-1"><h3>Добавить пользователя</h3></div>
        <@l.login "/user/new" true />
    </div>
</@c.page>