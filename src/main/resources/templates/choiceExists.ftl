<#import "macros/common.ftl" as c>
<@c.page>
    <div align="center">
        <h3>Выбор конструктивного</h3>
        <h3>элемента</h3>
        <#list floors as floor>
        <div class="col-sm-3">
            <div class="p-2">
                <form action="/newFrame/edit" method="get">
                    <input type="hidden" name="floorId" value="${floor.id}">
                    <button type="submit" class = "btn btn-primary btn-block"> Этаж ${floor.number} </button>
                </form>
            </div>
        </div>
        </#list>
        <#list foundations as foundation>
        <div class="col-sm-3">
            <div class="p-2">
                <form action="/newFoundation/edit" method="get">
                    <input type="hidden" name="foundationId" value="${foundation.id}">
                    <button type="submit" class = "btn btn-primary btn-block">Фундамент</button>
                </form>
            </div>
        </div>
        </#list>
    </div>
</@c.page>