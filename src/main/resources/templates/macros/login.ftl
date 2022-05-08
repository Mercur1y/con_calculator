<#include "security.ftl">

<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="col-sm-6">
            <div class="p-2">
                <input type="text" name="username" value="<#if user??>${user.username}</#if>"
                       class="form-control w-50 ${(usernameError??)?string('is-invalid', '')}"
                       placeholder="Логин" />
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>
<#--        <#if isRegisterForm>-->
<#--            <div class="form-group row">-->
<#--                <label class="col-sm-2 col-form-label">Email:</label>-->
<#--                <div class="col-sm-6">-->
<#--                    <input type="email" name="email" value="<#if user??>${user.email}</#if>"-->
<#--                           class="form-control ${(emailError??)?string('is-invalid', '')}"-->
<#--                           placeholder="some@some.com" />-->
<#--                    <#if emailError??>-->
<#--                        <div class="invalid-feedback">-->
<#--                            ${emailError}-->
<#--                        </div>-->
<#--                    </#if>-->
<#--                </div>-->
<#--            </div>-->
<#--        </#if>-->
        <div class="col-sm-6">
            <div class="p-2">
                <input type="password" name="password"
                       class="form-control w-50 ${(passwordError??)?string('is-invalid', '')}"
                       placeholder="Пароль" />
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="p-2">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit"><#if isRegisterForm>Создать<#else>Войти</#if></button>
            </div>
        </div>
    </form>
</#macro>

<#macro logout>
    <div class="col-sm-6">
            <div class="p-2">
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary mr-3" type="submit"><#if user??>Выйти<#else>Войти</#if></button>
    </form>
    </div>
    </div>
</#macro>

<#macro registration>
    <#if !user??>
        <form action="/newuser" method="get">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button class="btn btn-primary" type="submit">Registration</button>
        </form>
    </#if>
</#macro>