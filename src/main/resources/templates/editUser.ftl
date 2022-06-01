<#import "macros/common.ftl" as c>
<#--    <#include "macros/security.ftl"/>-->

<@c.page>
    <form action="/user/edit/${user.id}" method="post">
        <div class="form-group">
            <div class="col-sm-6">
                <div class="p-2">
                    <input type="text" name="username"
                           class="form-control w-50 ${(usernameError??)?string('is-invalid', '')}"
                           placeholder="Логин" value="${user.getUsername()}"/>
                    <#if usernameError??>
                        <div class="invalid-feedback">
                            ${usernameError}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="p-2">
                    <input type="email" name="email"
                           class="form-control w-50 ${(emailError??)?string('is-invalid', '')}"
                           placeholder="some@some.com" value="${user.getEmail()}"/>
                    <#if emailError??>
                        <div class="invalid-feedback">
                            ${emailError}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="p-2">
                    <input type="text" name="first_name"
                           class="form-control w-50" value="${user.first_name}"
                           placeholder="Имя" />
                </div>
            </div>
            <div class="col-sm-6">
                <div class="p-2">
                    <input type="text" name="second_name" value="${user.second_name}"
                           class="form-control w-50"
                           placeholder="Отчество"/>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="p-2">
                    <input type="text" name="last_name" value="${user.last_name}"
                           class="form-control w-50"
                           placeholder="Фамилия"/>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="p-2">
                    <input
                            id="phone"
                            type="text" name="phone" value="${user.phone}"
                            class="form-control w-50"
                            placeholder="Телефон">
                </div>
            </div>
            <div class="col-sm-6">
                <div class="p-2">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="status" id="inlineRadio1" value="В штате" checked="checked">
                        <label class="form-check-label" for="inlineRadio1">В штате</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="status" id="inlineRadio2" value="Уволен">
                        <label class="form-check-label" for="inlineRadio2">Уволен</label>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="p-2">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <button class="btn btn-primary" type="submit">Сохранить</button>
                </div>
            </div>
        </div>
    </form>
</@c.page>