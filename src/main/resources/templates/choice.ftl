<#import "macros/common.ftl" as c>
<@c.page>
        <div align="center">
            <h3>Выбор конструктивного</h3>
            <h3>элемента</h3>
            <div class="col-sm-3">
                <div class="p-2">
                    <form action="/floor/new" method="get">
                        <#if customerId??><input type="hidden" name="customerId" value="${customerId}"></#if>
                        <#if orderId??><input type="hidden" name="orderId" value="${orderId}"></#if>
                        <button type="submit" class = "btn btn-primary btn-block"> Каркас этажа </button>
                    </form>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="p-2">
                    <form action="/foundation/new" method="get">
                        <#if customerId??><input type="hidden" name="customerId" value="${customerId}"></#if>
                       <#if orderId??> <input type="hidden" name="orderId" value="${orderId}"></#if>
                        <button type="submit" class = "btn btn-primary btn-block">Фундамент</button>
                    </form>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="p-2">
                    <button type="submit" class = "btn btn-primary btn-block">Крыша</button>
                </div>
            </div>
        </div>
</@c.page>