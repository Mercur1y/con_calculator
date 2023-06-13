<#macro add path isEditForm>
    <style>
        .col-md-4 {
            width: 50%
        }
    </style>
    <div class="card p-1 mb-4 d-flex justify-content-center"
         style="border-radius: 9px;
         box-shadow: 0 .5rem 1rem rgba(0, 0, 0, .15)!important;
         max-width:700px; height: 355px; margin: 0 auto; position: relative;
  top: 50%;  transform: translateY(20%);">
        <div class="card-header text-center">Фундамент</div>
        <div class="card-body">
            <form action="${path}" method="post" class="needs-validation">
                <#if isEditForm><input type="hidden" name="foundationId" value="${foundationId}"/></#if>
                <div class="row mb-4 mt-4">
                    <div class="col-md-4">
                        <label for="v1" class="form-label">Периметр внешних стен</label>
                        <input type="text" name="outPerimeter" class="form-control form-control-sm" id="v1"
                               <#if isEditForm>value="${foundation.outPerimeter}"</#if>
                               required>
                    </div>
                    <div class="col-md-4">
                        <label for="v2" class="form-label">Сваи</label>
                        <select name="nameOfPiles" class="form-select form-select-sm" id="v2" required>
                            <#if isEditForm>
                                <option value="${curPiles}">${curPiles}</option>
                            <#else>
                                <option value="" selected disabled hidden>
                                    Выбрать
                                </option>
                            </#if>
                            <#list piles as piles>
                                <option value="${piles.name}">${piles.name}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <label for="v3" class="form-label">Периметр внутр. стен</label>
                        <input type="text" name="inPerimeter" class="form-control form-control-sm"
                               <#if isEditForm>value="${foundation.inPerimeter}"</#if>
                               id="v3" required>
                    </div>
                    <div class="col-md-4">
                        <label for="v4" class="form-label">Бетон</label>
                        <select name="nameOfConcrete" class="form-select form-select-sm" id="v4" required>
                            <#if isEditForm>
                                <option value="${curConcrete}">
                                    ${curConcrete}
                                </option>
                            <#else>
                                <option value="" selected disabled hidden>
                                    Выбрать
                                </option>
                            </#if>
                            <#list concrete as concrete>
                                <option value="${concrete.name}">
                                    ${concrete.name}
                                </option>
                            </#list>
                        </select>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="row align-items-center" style="right: 50px; bottom: 20px; position: absolute;">
                    <#if orderId??>
                        <input type="hidden" name="orderId" value="${orderId}">
                    <#else>
                        <div class="col-auto">
                            <label for="adres" class="col-form-label">Адрес</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="adres" name="adress"
                                   class="form-control form-control-sm"
                                   aria-describedby="inputGroupPrepend" required>
                        </div>
                    </#if>
                    <div class="col-auto">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <input type="hidden" name="customerId" value="${customerId}"/>
                        <button id="primary-orange" type="submit"
                                class="btn btn-primary">Сохранить
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</#macro>