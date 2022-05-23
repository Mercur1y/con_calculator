<#import "macros/common.ftl" as c>
<@c.page>
    <div align="center">
        <h3>Выбор конструктивного</h3>
        <h3>элемента</h3>
        <form action="orders/${customer.id}/addFrame" method="get">
            <button type="submit" class = "btn btn-outline-primary">Каркас</button>
        </form>
        <form>
            <button type="submit" class = "btn btn-outline-primary">Фундамент</button>
        </form>
        <button type="submit" class = "btn btn-outline-primary">Крыша</button>
    </div>
</@c.page>