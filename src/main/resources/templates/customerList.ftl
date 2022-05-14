<#import "macros/common.ftl" as c>
<@c.page>
    <h2 align="center">Клиенты</h2>
    <a class="btn btn-outline-success" href="/addCustomer">Новый заказчик</a>
    <div class="card-columns" align="center">
        <#list customers as customer>
            <div class="card my-3">
                <span>${customer.last_name}</span>
                <span>${customer.first_name}</span>
                <span>${customer.second_name}</span>
                <div id="button" class="card-footer">
                        <form action="editCustomer/${customer.id}" method="get">
                            <button type="submit" class = "btn btn-outline-success">Редактировать</button>
                        </form>
                        <form method="post">
                            <input type="hidden" name="customerId" value="${customer.id}"/>
                            <input type="hidden" name="action" value="delete"/>
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <button type="submit" class="btn btn-outline-danger">
                                Удалить
                            </button>
                        </form>
                </div>
            </div>
        <#else>
            <a>Они ушли</a>
        </#list>
    </div>
</@c.page>