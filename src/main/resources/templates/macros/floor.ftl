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
            <#if isEditForm><input type="hidden" name="floorId" value="${floorId}"/></#if>
            <div class="card-header text-center">Каркас этажа <#if isEditForm>${floor.number}</#if></div>
            <div class="accordion accordion-borderless p-2" id="accordionExample">
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingOne">
                        <button class="accordion-button" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            Коробка
                        </button>
                    </h2>
                    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne"
                         data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <div class="row row-cols-2">
                                <div class="col-md-4">
                                    <label for="v1" class="form-label">Высота этажа</label>
                                    <input type="text" name="height" class="form-control form-control-sm" id="v1"
                                           <#if isEditForm>value="${floor.height}"</#if>
                                           required>
                                </div>
                                <div class="col-md-4">
                                    <label for="v2" class="form-label">Периметр внешних стен</label>
                                    <input type="text" name="outPerimeter" class="form-control form-control-sm"
                                           <#if isEditForm>value="${floor.outPerimeter}"</#if>
                                           id="v2" required>
                                </div>
                                <div class="col-md-4">
                                    <label for="v3" class="form-label">Периметр внутренних стен</label>
                                    <input type="text" name="inPerimeter" class="form-control form-control-sm"
                                           id="v3"
                                           <#if isEditForm>value="${floor.inPerimeter}"</#if>
                                           aria-describedby="inputGroupPrepend" required>
                                </div>
                                <div class="col-md-4">
                                    <label for="v4" class="form-label">Толщина внешних стен</label>
                                    <select name="outWallWidth" class="form-select form-select-sm" id="v4" required>
                                        <#if isEditForm>
                                            <option value="${floor.outWallWidth}">
                                                ${floor.outWallWidth}
                                            </option>
                                        <#else>
                                        <option value="" selected disabled hidden>
                                            Выбрать
                                        </option>
                                        </#if>
                                        <option value=100>100</option>
                                        <option value=150>150</option>
                                        <option value=200>200</option>
                                        <option value=250>250</option>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <label for="v5" class="form-label">Толщина внутренних стен</label>
                                    <select name="inWallWidth" class="form-select form-select-sm" id="v5" required>
                                        <#if isEditForm>
                                            <option value="${floor.inWallWidth}">
                                                ${floor.inWallWidth}
                                            </option>
                                        <#else>
                                            <option value="" selected disabled hidden>
                                                Выбрать
                                            </option>
                                        </#if>
                                        <option value=100>100</option>
                                        <option value=150>150</option>
                                        <option value=200>200</option>
                                        <option value=250>250</option>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <label for="v6" class="form-label">Площадь основания</label>
                                    <input type="text" name="square" class="form-control form-control-sm" id="v6"
                                           aria-describedby="inputGroupPrepend"
                                           <#if isEditForm>value="${floor.square}"</#if>
                                           required>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingTwo">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            Оконные проемы
                        </button>
                    </h2>
                    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo"
                         data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <div id="hole" class="row row-cols-3">
                                <#if isEditForm>
                                <#list floor.holes as hole>
                                <div class="col-md-4">
                                    <label for="v7" class="form-label">Высота</label>
                                    <input type="text" name="height" class="form-control form-control-sm" id="v7"
                                           value="${hole.height}"
                                           aria-describedby="inputGroupPrepend" required>
                                </div>
                                <div class="col-md-4">
                                    <label for="v8" class="form-label">Ширина</label>
                                    <input type="text" name="width" class="form-control form-control-sm" id="v8"
                                           value="${hole.width}"
                                           aria-describedby="inputGroupPrepend" required>
                                </div>
                                <div class="col-md-4">
                                    <label for="v9" class="form-label">Количество</label>
                                    <input type="number" name="count" class="form-control form-control-sm" id="v9"
                                           value="${hole.count}"
                                           aria-describedby="inputGroupPrepend" required>
                                </div>
                                </#list>
                                <#else>
                                    <div class="col-md-4">
                                        <label for="v7" class="form-label">Высота</label>
                                        <input type="text" name="height" class="form-control form-control-sm" id="v7"
                                               aria-describedby="inputGroupPrepend" required>
                                    </div>
                                    <div class="col-md-4">
                                        <label for="v8" class="form-label">Ширина</label>
                                        <input type="text" name="width" class="form-control form-control-sm" id="v8"
                                               aria-describedby="inputGroupPrepend" required>
                                    </div>
                                    <div class="col-md-4">
                                        <label for="v9" class="form-label">Количество</label>
                                        <input type="number" name="count" class="form-control form-control-sm" id="v9"
                                               aria-describedby="inputGroupPrepend" required>
                                    </div>
                                </#if>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingThree">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                            Обшивка внешних стен
                        </button>
                    </h2>
                    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree"
                         data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <div class="row row-cols-2">
                                <div class="col-md-4">
                                    <label for="v10" class="form-label">ОСБ</label>
                                    <select name="nameOfOutOsb" class="form-select form-select-sm" id="v10"
                                            required>
                                        <#if isEditForm>
                                        <option value="${results.nameOfOutOsb}">
                                            ${results.nameOfOutOsb}
                                        </option>
                                        <#else>
                                        <option value="" selected disabled hidden>
                                            Выбрать
                                        </option>
                                        </#if>
                                        <#list osb as osb>
                                            <option value="${osb.name}">${osb.name}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <label for="v11" class="form-label">Парогидроизоляция</label>
                                    <select name="nameOfOutWater" class="form-select form-select-sm" id="v11"
                                            required>
                                        <#if isEditForm>
                                            <option value="${results.nameOfOutWater}">
                                                ${results.nameOfOutWater}
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
                                    <label for="v12" class="form-label">Ветрозащита</label>
                                    <select name="nameOfOutWind" class="form-select form-select-sm" id="v12"
                                            required>
                                        <#if isEditForm>
                                            <option value="${results.nameOfOutWind}">
                                                ${results.nameOfOutWind}
                                            </option>
                                        <#else>
                                            <option value="" selected disabled hidden>
                                                Выбрать
                                            </option>
                                        </#if>
                                        <#list wind as wind>
                                            <option value="${wind.name}">${wind.name}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <label for="v13" class="form-label">Теплоизоляция</label>
                                    <select name="nameOfOutWarm" class="form-select form-select-sm" id="v13"
                                            required>
                                        <#if isEditForm>
                                            <option value="${results.nameOfOutWarm}">
                                                ${results.nameOfOutWarm}
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
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingFour">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                            Обшивка внутренних стен
                        </button>
                    </h2>
                    <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour"
                         data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <div class="row row-cols-2">
                                <div class="col-md-4">
                                    <label for="v14" class="form-label">ОСБ</label>
                                    <select name="nameOfInOsb" class="form-select form-select-sm" id="v14" required>
                                        <#if isEditForm>
                                            <option value="${results.nameOfInOsb}">
                                                ${results.nameOfInOsb}
                                            </option>
                                        <#else>
                                            <option value="" selected disabled hidden>
                                                Выбрать
                                            </option>
                                        </#if>
                                        <#list osb as osb>
                                            <option value="${osb.name}">${osb.name}</option>
                                        </#list>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingFive">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                            Перекрытия
                        </button>
                    </h2>
                    <div id="collapseFive" class="accordion-collapse collapse" aria-labelledby="headingFive"
                         data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <div class="row row-cols-2">
                                <div class="col-md-4">
                                    <label for="v15" class="form-label">Толщина перекрытия</label>
                                    <select name="overWidth" class="form-select form-select-sm" id="v15" required>
                                        <#if isEditForm>
                                            <option value="${floor.overWidth}">
                                                ${floor.overWidth}
                                            </option>
                                        <#else>
                                            <option value="" selected disabled hidden>
                                                Выбрать
                                            </option>
                                        </#if>
                                        <option value=100>100</option>
                                        <option value=150>150</option>
                                        <option value=200>200</option>
                                        <option value=250>250</option>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <label for="v16" class="form-label">ОСБ</label>
                                    <select name="nameOfOverOsb" class="form-select form-select-sm" id="v16"
                                            required>
                                        <#if isEditForm>
                                            <option value="${results.nameOfOverOsb}">
                                                ${results.nameOfOverOsb}
                                            </option>
                                        <#else>
                                            <option value="" selected disabled hidden>
                                                Выбрать
                                            </option>
                                        </#if>
                                        <#list osb as osb>
                                            <option value="${osb.name}">${osb.name}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <label for="v17" class="form-label">Парогидроизоляция</label>
                                    <select name="nameOfOverWater" class="form-select form-select-sm" id="v17"
                                            required>
                                        <#if isEditForm>
                                            <option value="${results.nameOfOverWater}">
                                                ${results.nameOfOverWater}
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
                                    <label for="v18" class="form-label">Ветрозащита</label>
                                    <select name="nameOfOverWind" class="form-select form-select-sm" id="v18"
                                            required>
                                        <#if isEditForm>
                                            <option value="${results.nameOfOverWind}">
                                                ${results.nameOfOverWind}
                                            </option>
                                        <#else>
                                            <option value="" selected disabled hidden>
                                                Выбрать
                                            </option>
                                        </#if>
                                        <#list wind as wind>
                                            <option value="${wind.name}">${wind.name}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <label for="v19" class="form-label">Теплоизоляция</label>
                                    <select name="nameOfOverWarm" class="form-select form-select-sm" id="v19"
                                            required>
                                        <#if isEditForm>
                                            <option value="${results.nameOfOverWarm}">
                                                ${results.nameOfOverWarm}
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