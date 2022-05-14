<#import "macros/common.ftl" as c>

<@c.page>
    <form action="/editUser/${user.id}" method="post">
        <div class="col-sm-6">
            <div class="p-2">
                <input type="text" name="username"
                       class="form-control w-50 ${(usernameError??)?string('is-invalid', '')}"
                       placeholder="some@some.com" value="${user.username}"/>
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
                       placeholder="some@some.com" value="${user.email}"/>
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
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="hidden" name="id" value="${user.id}" />
                <button class="btn btn-primary" type="submit">Сохранить</button>
            </div>
        </div>
    </form>
</@c.page>