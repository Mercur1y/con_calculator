<#macro add path isEditForm>
<style>
    .form-control-sm {
        max-width: 90%;
    }

    .form-select-sm {
        max-width: 90%;
    }
</style>
<div id="rowLabel test" class="d-flex row">
    <div class="card p-1 mb-4"
         style="border-radius: 9px; box-shadow: 0 .5rem 1rem rgba(0, 0, 0, .15)!important; width: 100%; height: 600px">
        <form action="${path}" method="post" class="needs-validation">
            <#if isEditForm><input type="hidden" name="roofId" value="${roofId}"/></#if>
            <div class="card-header text-center">Крыша</div>
            <div class="accordion accordion-borderless p-2" id="accordionExample">
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingOne">
                        <button class="accordion-button" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            Параметры
                        </button>
                    </h2>
                    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne"
                         data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <div class="row row-cols-2">
                                <div class="col-md-4">
                                    <label for="v1" class="form-label">Длина</label>
                                    <input type="text" name="length" class="form-control form-control-sm" id="v1"
                                           <#if isEditForm>value="${roof.length}"</#if>
                                           required>
                                </div>
                                <div class="col-md-4">
                                    <label for="v2" class="form-label">Ширина</label>
                                    <input type="text" name="width" class="form-control form-control-sm"
                                           <#if isEditForm>value="${roof.width}"</#if>
                                           id="v2" required>
                                </div>
                                <div class="col-md-4">
                                    <label for="v3" class="form-label">Высота</label>
                                    <input type="text" name="height" class="form-control form-control-sm"
                                           id="v3"
                                           <#if isEditForm>value="${roof.height}"</#if>
                                           aria-describedby="inputGroupPrepend" required>
                                </div>
                                <div class="col-md-4">
                                    <label for="v4" class="form-label">Свес кровли</label>
                                    <input type="text" name="overhang" class="form-control form-control-sm"
                                           id="v4"
                                           <#if isEditForm>value="${roof.overhang}"</#if>
                                           aria-describedby="inputGroupPrepend" required>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingThree">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                            Материалы
                        </button>
                    </h2>
                    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree"
                         data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <div class="row row-cols-2">
                                <div class="col-md-4">
                                    <label for="v10" class="form-label">Кровля</label>
                                    <select name="nameOfTop" class="form-select form-select-sm" id="v10"
                                            required>
                                        <#if isEditForm>
                                            <option value="${results.nameOfTop}">
                                                ${results.nameOfTop}
                                            </option>
                                        <#else>
                                            <option value="" selected disabled hidden>
                                                Выбрать
                                            </option>
                                        </#if>
                                        <#list top as top>
                                            <option value="${top.name}">${top.name}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <label for="v11" class="form-label">Парогидроизоляция</label>
                                    <select name="nameOfWater" class="form-select form-select-sm" id="v11"
                                            required>
                                        <#if isEditForm>
                                            <option value="${results.nameOfWater}">
                                                ${results.nameOfWater}
                                            </option>
                                        <#else>
                                            <option value="" selected disabled hidden>
                                                Выбрать
                                            </option>
                                        </#if>
                                        <#list water as water>
                                            <option value="${water.name}">${water.name}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <label for="v13" class="form-label">Теплоизоляция</label>
                                    <select name="nameOfWarm" class="form-select form-select-sm" id="v13"
                                            required>
                                        <#if isEditForm>
                                            <option value="${results.nameOfWarm}">
                                                ${results.nameOfWarm}
                                            </option>
                                        <#else>
                                            <option value="" selected disabled hidden>
                                                Выбрать
                                            </option>
                                        </#if>
                                        <#list warm as warm>
                                            <option value="${warm.name}">${warm.name}</option>
                                        </#list>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row align-items-center" style="right: 20px; bottom: 20px; position: absolute;">
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
                    <#if type??><input type="hidden" name="type" value="${type}"/></#if>
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