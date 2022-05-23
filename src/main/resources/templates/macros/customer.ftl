<#import "common.ftl" as c>
<#include "security.ftl">
    <#macro customer isEditPage>
        <div class="col-sm-6">
            <div class="p-2">
                <input type="text" name="last_name" <#if isEditPage>value="${customer.last_name}"</#if>
                       class="form-control w-50"
                       placeholder="Фамилия"/>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="p-2">
                <input type="text" name="first_name"
                       class="form-control w-50" <#if isEditPage>value="${customer.first_name}"</#if>
                       placeholder="Имя" />
            </div>
        </div>
        <div class="col-sm-6">
            <div class="p-2">
                <input type="text" name="second_name" <#if isEditPage>value="${customer.second_name}"</#if>
                       class="form-control w-50"
                       placeholder="Отчество"/>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="p-2">
                <input
                        id="phone"
                        type="text" name="phone" <#if isEditPage>value="${customer.phone}"</#if>
                        class="form-control w-50"
                        placeholder="Телефон">
            </div>
        </div>
        <div class="col-sm-6">
            <div class="p-2">
                <input type="email" name="email"
                       class="form-control w-50 ${(emailError??)?string('is-invalid', '')}"
                       placeholder="some@some.com" <#if isEditPage>value="${customer.email}"/></#if>
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
                        placeholder="Адрес" <#if isEditPage>value="${customer.adress}"</#if>/>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="p-2">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="hidden" name="id" value="${user.id}" />
                <button class="btn btn-primary" type="submit">Сохранить</button>
            </div>
        </div>
    </#macro>