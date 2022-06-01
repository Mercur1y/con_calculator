<#import "macros/common.ftl" as c>

<@c.page>
    <form action="/floor/add" method="post">
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
            <h5>Коробка</h5>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Высота этажа:</label>
                <div class="col-sm-10">
                    <input type="text" name="height"
                           class="form-control form-control-sm w-25">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Периметр внешних стен:</label>
                <div class="col-sm-10">
                    <input type="text" name="outPerimeter"
                           class="form-control form-control-sm w-25">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Периметр внутр. стен:</label>
                <div class="col-sm-10">
                    <input type="text" name="inPerimeter"
                           class="form-control form-control-sm w-25">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Толщина внешних стен:</label>
                <div class="col-sm-10">
                <select name="outWallWidth"
                        class="form-control form-control-sm w-25">
                        <option value="" selected disabled hidden>
                            Выбрать
                        </option>
                        <option value = 100>100</option>
                        <option value = 150>150</option>
                        <option value = 200>200</option>
                        <option value = 250>250</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Толщина внутр. стен:</label>
                <div class="col-sm-10">
                    <select name="inWallWidth" class="form-control form-control-sm w-25">
                        <option value="" selected disabled hidden>
                            Выбрать
                        </option>
                        <option value = 100>100</option>
                        <option value = 150>150</option>
                        <option value = 200>200</option>
                        <option value = 250>250</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Площадь основания:</label>
                <div class="col-sm-10">
                    <input type="text" name="square"
                           class="form-control form-control-sm w-25">
                </div>
            </div>
            <h5>Окна и двери</h5>
            <h7>Оконные проемы</h7>
            <div id="hole" class="form-group row">
                <div class="col-sm-2 col-form-label-sm">
                    <label>Высота</label>
                    <input type="text" name="height" class="form-control form-control-sm">
                </div>
                <div class="col-sm-2 col-form-label-sm">
                    <label>Ширина</label>
                    <input type="text" name="width" class="form-control form-control-sm">
                </div>
                <div class="col-sm-2 col-form-label-sm">
                    <label>Количество</label>
                    <input type="number" name="count" class="form-control form-control-sm">
                </div>
            </div>

<#--            <div id="parentElement" class="row text-right">-->
<#--                <label>Add another input line</label>-->
<#--                <button onclick="addInputLine()" name="addInputLine" class="btn btn-default" ><span class="fa fa-plus"></span></button>-->
<#--            </div>-->
<#--            <script>-->
<#--                function addInputLine() {-->
<#--                    var node = document.createElement("hole");                // Create an <input> node-->
<#--                    document.getElementById("parentElement").appendChild(node);     // Append it to the parent-->
<#--                }-->
<#--            </script>-->
<#--            <h7>Дверные проемы (внеш.)</h7>-->
<#--            <div class="form-group row">-->
<#--                <div class="col-sm-2 col-form-label-sm">-->
<#--                    <label>Высота</label>-->
<#--                    <input type="text" name="height" class="form-control form-control-sm">-->
<#--                </div>-->
<#--                <div class="col-sm-2 col-form-label-sm">-->
<#--                    <label>Ширина</label>-->
<#--                    <input type="text" name="width" class="form-control form-control-sm">-->
<#--                </div>-->
<#--                <div class="col-sm-2 col-form-label-sm">-->
<#--                    <label>Количество</label>-->
<#--                    <input type="number" name="count" class="form-control form-control-sm">-->
<#--                </div>-->
<#--            </div>-->
<#--            <h7>Дверные проемы (внутр.)</h7>-->
<#--            <div class="form-group row">-->
<#--                <div class="col-sm-2 col-form-label-sm">-->
<#--                    <label>Высота</label>-->
<#--                    <input type="text" name="height" class="form-control form-control-sm">-->
<#--                </div>-->
<#--                <div class="col-sm-2 col-form-label-sm">-->
<#--                    <label>Ширина</label>-->
<#--                    <input type="text" name="width" class="form-control form-control-sm">-->
<#--                </div>-->
<#--                <div class="col-sm-2 col-form-label-sm">-->
<#--                    <label>Количество</label>-->
<#--                    <input type="number" name="count" class="form-control form-control-sm">-->
<#--                </div>-->
<#--            </div>-->
            <h5>Обшивка внешних стен</h5>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">ОСБ:</label>
                <div class="col-sm-10">
                    <select name="outOsbName" class="form-control form-control-sm w-25">
                        <option value="" selected disabled hidden>
                            Выбрать
                        </option>
                        <#list osb as osb>
                            <option value="${osb.name}">${osb.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Парогидроизоляция:</label>
                <div class="col-sm-10">
                    <select name="outWaterName" class="form-control form-control-sm w-25">
                        <option value="" selected disabled hidden>
                            Выбрать
                        </option>
                        <#list water as water>
                            <option value="${water.name}">${water.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Ветрозащита:</label>
                <div class="col-sm-10">
                    <select name="outWindName" class="form-control form-control-sm w-25">
                        <option value="" selected disabled hidden>
                            Выбрать
                        </option>
                        <#list wind as wind>
                            <option value="${wind.name}">${wind.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Теплоизоляция:</label>
                <div class="col-sm-10">
                    <select name="outWarmName" class="form-control form-control-sm w-25">
                        <option value="" selected disabled hidden>
                            Выбрать
                        </option>
                        <#list warm as warm>
                            <option value="${warm.name}">${warm.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <h5>Обшивка внутренних стен</h5>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">ОСБ:</label>
                <div class="col-sm-10">
                    <select name="inOsbName" class="form-control form-control-sm w-25">
                        <option value="" selected disabled hidden>
                            Выбрать
                        </option>
                        <#list osb as osb>
                            <option value="${osb.name}">${osb.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <h5>Перекрытия</h5>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Толщина перекрытия:</label>
                <div class="col-sm-10">
                    <select name="overWidth" class="form-control form-control-sm w-25">
                        <option value="" selected disabled hidden>
                            Выбрать
                        </option>
                        <option value = 100>100</option>
                        <option value = 150>150</option>
                        <option value = 200>200</option>
                        <option value = 250>250</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">ОСБ:</label>
                <div class="col-sm-10">
                    <select name="overOsbName" class="form-control form-control-sm w-25">
                        <option value="" selected disabled hidden>
                            Выбрать
                        </option>
                        <#list osb as osb>
                            <option value="${osb.name}">${osb.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Парогидроизоляция:</label>
                <div class="col-sm-10">
                    <select name="overWaterName" class="form-control form-control-sm w-25">
                        <option value="" selected disabled hidden>
                            Выбрать
                        </option>
                        <#list water as water>
                            <option value="${water.name}">${water.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Ветрозащита:</label>
                <div class="col-sm-10">
                    <select name="overWindName" class="form-control form-control-sm w-25">
                        <option value="" selected disabled hidden>
                            Выбрать
                        </option>
                        <#list wind as wind>
                            <option value="${wind.name}">${wind.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Теплоизоляция:</label>
                <div class="col-sm-10">
                    <select name="overWarmName" class="form-control form-control-sm w-25">
                        <option value="" selected disabled hidden>
                            Выбрать
                        </option>
                        <#list warm as warm>
                            <option value="${warm.name}">${warm.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Сохранить</button>
    </form>
</@c.page>