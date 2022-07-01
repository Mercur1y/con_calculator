<#include "security.ftl">
<#import "/spring.ftl" as spring />

<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="col-sm-6">
            <div class="p-2">
                <input type="text" name="username"
                       class="form-control w-50 ${(usernameError??)?string('is-invalid', '')}"
                       placeholder="Логин" />
            </div>
        </div>
        <div class="col-sm-6">
            <div class="p-2">
                <input type="password" name="password"
                       class="form-control w-50 ${(passwordError??)?string('is-invalid', '')}"
                       placeholder="Пароль" />
            </div>
        </div>
        <#if isRegisterForm>
            <div class="col-sm-6">
                <div class="p-2">
                    <input type="email" name="email"
                           class="form-control w-50 ${(emailError??)?string('is-invalid', '')}"
                           placeholder="some@some.com" />
                </div>
            </div>
            <div class="col-sm-6">
                <div class="p-2">
                    <input type="text" name="first_name"
                           class="form-control w-50 ${(first_nameError??)?string('is-invalid', '')}"
                           placeholder="Имя" />
                </div>
            </div>
            <div class="col-sm-6">
                <div class="p-2">
                    <input type="text" name="second_name"
                           class="form-control w-50 ${(second_nameError??)?string('is-invalid', '')}"
                           placeholder="Отчество"/>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="p-2">
                    <input type="text" name="last_name"
                           class="form-control w-50 ${(last_nameError??)?string('is-invalid', '')}"
                           placeholder="Фамилия"/>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="p-2">
                    <input
                            id="phone"
                            type="text" name="phone"
                            class="form-control w-50 ${(phoneError??)?string('is-invalid', '')}"
                            placeholder="Телефон">
                </div>
            </div>
        </#if>
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
        <form action="/user/new" method="get">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button class="btn btn-primary" type="submit">Registration</button>
        </form>
    </#if>
</#macro>