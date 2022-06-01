<#import "macros/common.ftl" as c>

<@c.page>
<form action="/foundation/add" method="post">
    <#if customerId??><input type="hidden" name="customerId" value="${customerId}">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label-sm">Адрес:</label>
            <div class="col-sm-10">
                <input type="text" name="adress"
                       class="form-control form-control-sm w-25">
            </div>
        </div>
    </#if>
    <#if orderId??><input type="hidden" name="orderId" value="${orderId}"></#if>
    <div>
        <h5>Фундамент</h5>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label-sm">Периметр внешних стен:</label>
            <div class="col-sm-10">
                <input type="text" name="outPerimeter" class="form-control form-control-sm w-25">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label-sm">Периметр внутр. стен:</label>
            <div class="col-sm-10">
                <input type="text" name="inPerimeter" class="form-control form-control-sm w-25">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label-sm">Бетонные сваи:</label>
            <div class="col-sm-10">
                <select name="pilesName" class="form-control form-control-sm w-25">
                    <option value="" selected disabled hidden>Выбрать</option>
                    <#list piles as piles>
                        <option value="${piles.name}">${piles.name}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label-sm">Бетон:</label>
            <div class="col-sm-10">
                <select name="concreteName" class="form-control form-control-sm w-25">
                    <option value="" selected disabled hidden>Выбрать</option>
                    <#list concrete as concrete>
                        <option value="${concrete.name}">${concrete.name}</option>
                    </#list>
                </select>
            </div>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">Сохранить</button>
</form>
</@c.page>