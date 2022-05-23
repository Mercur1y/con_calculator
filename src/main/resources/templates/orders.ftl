<#import "macros/common.ftl" as c>
<@c.page>
    <h2 align="center">Карточка клиента</h2>
    <a class="btn btn-outline-success" href="/newFrame/${customer.id}">Новый каркас</a>
    <table class="table">
        <thead>
        <tr>
            <th>Дата создания</th>
            <th>Статус</th>
            <th>Адрес</th>
        </tr>
        <tbody>
        <#list orders as order>
            <tr>
                <td>${order.localDateTime}</td>
                <td>типа актуален</td>
                <td><a class="btn btn-outline-success" href="/results/${order.id}">тык</a></td>
                <td>
                    <form method="post">
                        <input type="hidden" name="orderId" value="${order.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <button type="submit" class="btn btn-outline-danger">
                            Удалить
                        </button>
                    </form>
                </td>
            </tr>
        <#else>
            Заказов нет
        </#list>
        </tbody>
    </table>
</@c.page>