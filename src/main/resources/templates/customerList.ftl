<#import "macros/common.ftl" as c>
<@c.page>
    <h2 align="center">Клиенты</h2>
    <a class="btn btn-outline-success" href="/addCustomer">Новый заказчик</a>
    <table class="table">
    <thead>
    <tr>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
    </tr>
    <tbody>
    <#list customers as customer>
        <tr>
            <td>${customer.last_name}</td>
            <td>${customer.first_name}</td>
            <td>${customer.second_name}</td>
            <td>
                <form action="orders/${customer.id}" method="get">
                    <button type="submit" class = "btn btn-outline-success">Заказы</button>
                </form>
            </td>
            <td>
                <form action="editCustomer/${customer.id}" method="get">
                    <button type="submit" class = "btn btn-outline-success">Редактировать</button>
                </form>
            </td>
            <td>
                <form method="post">
                    <input type="hidden" name="customerId" value="${customer.id}"/>
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <button type="submit" class="btn btn-outline-danger">
                        Удалить
                    </button>
                </form>
            </td>
        </tr>
        <#else>
            <h4 align="center">Ты безработный</h4>
    </#list>
    </tbody>
</@c.page>