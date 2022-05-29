<#import "macros/common.ftl" as c>

<@c.page>
    <form action="/newFrame/edit" method="post">
        <input type="hidden" name="floorId" value="${floorId}">
        <div>
            <h5>Коробка</h5>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Высота этажа:</label>
                <div class="col-sm-10">
                    <input type="text" name="height"
                           value="${floor.height}"
                           class="form-control form-control-sm w-25">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Периметр внешних стен:</label>
                <div class="col-sm-10">
                    <input type="text" name="outPerimeter"
                           value="${floor.outPerimeter}"
                           class="form-control form-control-sm w-25">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Периметр внутр. стен:</label>
                <div class="col-sm-10">
                    <input type="text" name="inPerimeter"
                           value="${floor.inPerimeter}"
                           class="form-control form-control-sm w-25">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label-sm">Толщина внешних стен:</label>
                <div class="col-sm-10">
                    <select name="outWallWidth"
                            class="form-control form-control-sm w-25">
                        <option value="${floor.outWallWidth}">
                            ${floor.outWallWidth}
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
                        <option value="${floor.inWallWidth}">
                            ${floor.inWallWidth}
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
                           value="${floor.square}"
                           class="form-control form-control-sm w-25">
                </div>
            </div>
            <h5>Окна и двери</h5>
            <h7>Оконные проемы</h7>
            <div id="hole" class="form-group row">
                    <#list holes as hole>
                        <div class="col-sm-2 col-form-label-sm">
                            <label>Высота</label>
                            <input type="text" name="height"
                                   value="${hole.height}"
                                   class="form-control form-control-sm">
                        </div>
                        <div class="col-sm-2 col-form-label-sm">
                            <label>Ширина</label>
                            <input type="text" name="width"
                                   value="${hole.width}"
                                   class="form-control form-control-sm">
                        </div>
                        <div class="col-sm-2 col-form-label-sm">
                            <label>Количество</label>
                            <input type="number" name="count"
                                   value="${hole.count}"
                                   class="form-control form-control-sm">
                        </div>
                    </#list>
            </div>
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
                        <option value="${curOutOsb}">
                            ${curOutOsb}
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
                        <option value="${curOutWater}">
                           ${curOutWater}
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
                        <option value="${curOutWind}">
                            ${curOutWind}
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
                        <option value="${curOutWarm}">
                            ${curOutWarm}
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
                        <option value="${curInOsb}">
                            ${curInOsb}
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
                        <option value="${floor.overWidth}">
                            ${floor.overWidth}
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
                        <option value="${curOverOsb}">
                            ${curOverOsb}
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
                        <option value="${curOverWater}">
                            ${curOverWater}
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
                        <option value="${curOverWind}">
                           ${curOverWind}
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
                        <option value="${curOverWarm}">
                            ${curOverWarm}
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