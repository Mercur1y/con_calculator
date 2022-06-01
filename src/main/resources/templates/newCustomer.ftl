<#import "macros/common.ftl" as c>
<#import "macros/customer.ftl" as form>
<@c.page>
    <div align="center">
        <form method="post">
            <@form.customer false/>
        </form>
    </div>
</@c.page>