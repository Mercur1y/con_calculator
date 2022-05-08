<#import "macros/common.ftl" as c>
<#import "macros/login.ftl" as l>

<@c.page>
    <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
        <div class="alert alert-danger" role="alert">
            ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
        </div>
    </#if>
    <#if message??>
        <div class="alert alert-${messageType}" role="alert">
            ${message}
        </div>
    </#if>
    <div align="center">
<#--        <img src="../img/logo.png" alt="">-->
        <@l.login "/login" false/>
    </div>
</@c.page>