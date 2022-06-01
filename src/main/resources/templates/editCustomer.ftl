<#import "macros/common.ftl" as c>
<#include "macros/security.ftl"/>
<@c.page>
    <form method="post">
        <input type="hidden" name="customerId" value="${customer.id}"/>
    <div align="center">
        <div class="col-sm-6">
            <div class="p-2">
                <input type="text" name="last_name" value="${customer.last_name}"
                       class="form-control w-50"
                       placeholder="Фамилия"/>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="p-2">
                <input type="text" name="first_name"
                       class="form-control w-50" value="${customer.first_name}"
                       placeholder="Имя" />
            </div>
        </div>
        <div class="col-sm-6">
            <div class="p-2">
                <input type="text" name="second_name" value="${customer.second_name}"
                       class="form-control w-50"
                       placeholder="Отчество"/>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="p-2">
                <input
                        id="phone"
                        type="text" name="phone" value="${customer.phone}"
                        class="form-control w-50"
                        placeholder="Телефон">
            </div>
        </div>
        <div class="col-sm-6">
            <div class="p-2">
                <input type="email" name="email"
                       class="form-control w-50 ${(emailError??)?string('is-invalid', '')}"
                       placeholder="some@some.com" value="${customer.email}"/>
                <#if emailError??>
                    <div class="invalid-feedback">
                        ${emailError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="p-2">
                <input
                        id="adress"
                        type="text" name="adress"
                        class="form-control w-50"
                        placeholder="Адрес" value="${customer.adress}"/>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="p-2">
                <a href="javascript:history.back()">Назад</a>
            </div>
            <div class="p-2">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="hidden" name="id" value="${user.id}" />
                <button class="btn btn-primary" type="submit">Сохранить</button>
            </div>
        </div>
    </div>
    </form>
</@c.page>