<#import "macros/common.ftl" as c>
<@c.navpage>
    <style>
        caption {
            caption-side: top;
            text-align: center;
            padding: 10px 0;
        }

        .card-body {
            height: 550px;
            overflow-y: scroll;
        }

        .cData {
            margin: 0 auto;
            width: 90%;
        }

        .cText {
            font-weight: bold
        }

        .table {
            width: 95%;
            border: none;
            margin: 0 auto;
            border-collapse: collapse;

            page-break-before: auto;
            page-break-after: auto;
            page-break-inside: avoid;
            position: relative;
        }

        .table thead th {
            font-weight: bold;
            text-align: left;
            border: none;
            padding: 10px 15px;
            background: #98b9c8;
            font-size: 14px;
            border-top: 1px solid #ddd;
        }

        .table tbody th {
            font-weight: bold;
            border: none;
            padding: 10px 15px;
            font-size: 15px;
        }

        .table tbody td {
            border: none;
            padding: 10px 15px;
            font-size: 15px;
        }

        hr {
            display: block;
            height: 4px;
            width: 90%;
            border-width: 2px;
            margin: 15px auto;
            padding: 0;
        }

        caption {
            color: #2f2f2f;
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 8px;
            margin-top: 20px;
        }
    </style>
    <div id="rowLabel test" class="d-flex row">
        <div class="card p-1 mb-4"
             style="border-radius: 9px; box-shadow: 0 .5rem 1rem rgba(0, 0, 0, .15)!important; width: 100%; max-height: 600px">
            <div class="card-header text-center">
                <form action="/orders/${customerId}?" method="get">
                    <button
                            type="submit"
                            class="btn-sm btn-icon tbIcon"
                            style="position: absolute; top: 12px; left: 10px;"
                            title="Вернуться"
                    >
                        <i class="fa fa-caret-left" style="font-size: 1.73em; vertical-align: middle"
                           aria-hidden="true"></i>
                        К клиенту
                    </button>
                </form>
                <button
                        type="button"
                        class="btn-sm btn-icon tbIcon"
                        style="position: absolute; top: 12px; right: 10px;"
                        data-bs-toggle="modal" data-bs-target="#addOrder"
                        title="Добавить элемент"
                >
                    <i class="fa fa-plus-square-o" style="font-size: 1.73em" aria-hidden="true"></i>
                </button>
                <!-- Окно выбора -->
                <div class="modal fade" id="addOrder" data-bs-backdrop="static"
                     data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                     aria-hidden="true">
                    <div class="modal-dialog modal-sm">
                        <div class="modal-content" style="border-radius: 8px">
                            <div class="modal-header">
                                Выберите элемент
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="d-grid gap-2">
                                    <form action="/floor/new" method="get">
                                        <#if customerId??><input type="hidden" name="customerId"
                                                                 value="${customerId}"></#if>
                                        <#if orderId??><input type="hidden" name="orderId" value="${orderId}"></#if>
                                        <button type="submit" class="btn btn-secondary btn-block" style="width: 100%">
                                            Каркас этажа
                                        </button>
                                    </form>
                                    <form action="/foundation/new" method="get">
                                        <#if customerId??><input type="hidden" name="customerId"
                                                                 value="${customerId}"></#if>
                                        <#if orderId??><input type="hidden" name="orderId" value="${orderId}"></#if>
                                        <button type="submit" class="btn btn-secondary btn-block" style="width: 100%"
                                                <#if foundationResults??>disabled
                                                </#if>>Фундамент
                                        </button>
                                    </form>
                                    <button type="submit" class="btn btn-secondary btn-block" style="width: 100%"
                                            <#if roofResults??>disabled</#if>>Крыша
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <span class="text-center">Отчет по заказу №${orderId}</span>
                <button type="button"
                        class="btn-sm btn-icon ms-auto tbIcon"
                        title="Сгенерировать pdf"
                        onclick="toPDF()"
                >
                    <i class="fa fa-file-pdf-o" style="font-size: 1.2rem" aria-hidden="true"></i>
                </button>
            </div>
            <div id="html-template" class="card-body p-2 overflow-auto" style="height: auto">
                <div id="hid" style="display: none">
                    <h4 class="mb-4 mt-4 text-center" style="font-weight: bold">Отчет по заказу №${orderId}</h4>
                    <hr/>
                    <div class="container cData">
                        <div class="row"><h5 class="cText">Заказчик</h5></div>
                        <div class="row mt-2 ml-4"><span
                                    class="cText">ФИО:&nbsp </span>
                            <span> ${customer.lastName} ${customer.firstName} ${customer.secondName} </span>
                        </div>
                        <div class="row mt-2 ml-4"><span class="cText">E-mail:&nbsp</span>
                            <span> ${customer.email} </span></div>
                        <div class="row mt-2 ml-4"><span class="cText">Телефон:&nbsp</span>
                            <span> ${customer.phone} </span></div>
                    </div>
                    <hr/>
                </div>
                <#if foundationResults??>
                    <table class="table table-striped table-hover">
                        <caption>
                            <form style="vertical-align: middle;" class="form-inline" action="/foundation" method="get">
                                <input type="hidden" name="customerId" value="${customerId}"/>
                                <input type="hidden" name="orderId" value="${orderId}"/>
                                <span>Фундамент</span>
                                <input type="hidden" name="foundationId" value="${foundationResults.foundation.id}">
                                <button data-html2canvas-ignore="true"
                                        type="submit"
                                        class="btn-sm btn-icon tbIcon"
                                        title="Редактировать"
                                >
                                    <i class="fa fa-pencil" aria-hidden="true"></i>
                                </button>
                            </form>
                        </caption>
                        <thead>
                        <tr style="width: 100%;">
                            <th></th>
                            <th>Материал</th>
                            <th>Количество</th>
                            <th>Ед. измерения</th>
                            <th>Стоимость</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="table-info">
                            <th>Сваи</th>
                            <td></td>
                            <td></td>
                            <td></td>
                            <th>${foundationResults.priceOfPiles}</th>
                        </tr>
                        <tr>
                            <td>Сваи</td>
                            <td>${foundationResults.nameOfPiles}</td>
                            <td>${foundationResults.countOfPiles}</td>
                            <td>шт</td>
                            <td>${foundationResults.priceOfPiles}</td>
                        </tr>
                        <tr class="table-info">
                            <th>Ростверк</th>
                            <td></td>
                            <td></td>
                            <td></td>
                            <th>${foundationResults.totalPriceOfGrillage}</th>
                        </tr>
                        <tr>
                            <td>Бетон</td>
                            <td>${foundationResults.nameOfConcrete}</td>
                            <td>${foundationResults.volumeOfConcrete}</td>
                            <td>м3</td>
                            <td>${foundationResults.priceOfConcrete}</td>
                        </tr>
                        <tr>
                            <td>Арматура</td>
                            <td>${foundationResults.nameOfBigArm}</td>
                            <td>${foundationResults.countOfBigArm}</td>
                            <td>шт</td>
                            <td>${foundationResults.priceOfBigArm}</td>
                        </tr>
                        <tr>
                            <td>Арматура</td>
                            <td>${foundationResults.nameOfSmallArm}</td>
                            <td>${foundationResults.countOfSmallArm}</td>
                            <td>шт</td>
                            <td>${foundationResults.priceOfSmallArm}</td>
                        </tr>
                        <tr class="table-info">
                            <th>Опалубка</th>
                            <td></td>
                            <td></td>
                            <td></td>
                            <th>${foundationResults.totalPriceOfFormwork}</th>
                        </tr>
                        <tr>
                            <td>Доска</td>
                            <td>${foundationResults.nameOfWood}</td>
                            <td>${foundationResults.volumeOfWood}</td>
                            <td>м3</td>
                            <td>${foundationResults.priceOfWood}</td>
                        </tr>
                        <tr>
                            <td>Брус</td>
                            <td>${foundationResults.nameOfBalk}</td>
                            <td>${foundationResults.volumeOfBalk}</td>
                            <td>м3</td>
                            <td>${foundationResults.priceOfBalk}</td>
                        </tr>
                        <tr class="table-info">
                            <th>ИТОГО</th>
                            <td></td>
                            <td></td>
                            <td></td>
                            <th class="result">${foundationResults.totalPrice}</th>
                        </tr>
                        </tbody>
                    </table>
                <#else></#if>

                <#list floorResults?sort as result>
                    <table class="table table-striped table-hover">
                        <caption>
                            <form style="vertical-align: middle;" class="form-inline" action="/floor" method="get">
                                <input type="hidden" name="customerId" value="${customerId}"/>
                                <input type="hidden" name="orderId" value="${orderId}"/>
                                <span>Этаж ${result.floor.number}</span>
                                <input type="hidden" name="floorId" value="${result.floor.id}">
                                <button data-html2canvas-ignore="true"
                                        type="submit"
                                        class="btn-sm btn-icon tbIcon"
                                        title="Редактировать"
                                >
                                    <i class="fa fa-pencil" aria-hidden="true"></i>
                                </button>
                            </form>
                        </caption>
                        <thead>
                        <tr>
                            <th scope="col"></th>
                            <th scope="col">Материал</th>
                            <th scope="col">Количество</th>
                            <th scope="col">Ед. измерения</th>
                            <th scope="col">Стоимость</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="table-info">
                            <th>Внешние стены</th>
                            <td></td>
                            <td></td>
                            <td></td>
                            <th>${result.getTotalOutPrice()}</th>
                        </tr>
                        <tr>
                            <td>Доска</td>
                            <td>${result.nameOfOutWood}</td>
                            <td>${result.volumeOfOutWood}</td>
                            <td>м3</td>
                            <td>${result.priceOfOutWood}</td>
                        </tr>
                        <tr>
                            <td>Утеплитель</td>
                            <td>${result.nameOfOutWarm}</td>
                            <td>${result.volumeOfOutWarm}</td>
                            <td>м3</td>
                            <td>${result.priceOfOutWarm}</td>
                        </tr>
                        <tr>
                            <td>ОСБ</td>
                            <td>${result.nameOfOutOsb}</td>
                            <td>${result.squareOfOutOsb}</td>
                            <td>м2</td>
                            <td>${result.priceOfOutOsb}</td>
                        </tr>
                        <tr>
                            <td>Парогидроизоляция</td>
                            <td>${result.nameOfOutWater}</td>
                            <td>${result.squareOfOutWater}</td>
                            <td>м2</td>
                            <td>${result.priceOfOutWater}</td>
                        </tr>
                        <tr>
                            <td>Ветрозащита</td>
                            <td>${result.nameOfOutWind}</td>
                            <td>${result.squareOfOutWind}</td>
                            <td>м2</td>
                            <td>${result.priceOfOutWind}</td>
                        </tr>
                        <tr class="table-info">
                            <th>Внутренние стены</th>
                            <td></td>
                            <td></td>
                            <td></td>
                            <th>${result.getTotalInPrice()}</th>
                        </tr>
                        <tr>
                            <td>Доска</td>
                            <td>${result.nameOfInWood}</td>
                            <td>${result.volumeOfInWood}</td>
                            <td>м3</td>
                            <td>${result.priceOfInWood}</td>
                        </tr>
                        <tr>
                            <td>ОСБ</td>
                            <td>${result.nameOfInOsb}</td>
                            <td>${result.squareOfInOsb}</td>
                            <td>м2</td>
                            <td>${result.priceOfInOsb}</td>
                        </tr>
                        <tr class="table-info">
                            <th>Перекрытия</th>
                            <td></td>
                            <td></td>
                            <td></td>
                            <th>${result.getTotalOverPrice()}</th>
                        </tr>
                        <tr>
                            <td>Доска</td>
                            <td>${result.nameOfOverWood}</td>
                            <td>${result.volumeOfOverWood}</td>
                            <td>м3</td>
                            <td>${result.priceOfOverWood}</td>
                        </tr>
                        <tr>
                            <td>Утеплитель</td>
                            <td>${result.nameOfOverWarm}</td>
                            <td>${result.volumeOfOverWarm}</td>
                            <td>м3</td>
                            <td>${result.priceOfOverWarm}</td>
                        </tr>
                        <tr>
                            <td>ОСБ</td>
                            <td>${result.nameOfOverOsb}</td>
                            <td>${result.squareOfOverOsb}</td>
                            <td>м2</td>
                            <td>${result.priceOfOverOsb}</td>
                        </tr>
                        <tr>
                            <td>Парогидроизоляция</td>
                            <td>${result.nameOfOverWater}</td>
                            <td>${result.squareOfOverWater}</td>
                            <td>м2</td>
                            <td>${result.priceOfOverWater}</td>
                        </tr>
                        <tr>
                            <td>Ветрозащита</td>
                            <td>${result.nameOfOverWind}</td>
                            <td>${result.squareOfOverWind}</td>
                            <td>м2</td>
                            <td>${result.priceOfOverWind}</td>
                        </tr>
                        <tr class="table-info">
                            <th>ИТОГО</th>
                            <td></td>
                            <td></td>
                            <td></td>
                            <th class="result">${result.getTotalAllPrice()}</th>
                        </tr>
                        </tbody>
                    </table>
                <#else>
                </#list>

                <#if roofResults??>
                    <table class="table table-striped table-hover">
                        <caption>
                            <form style="vertical-align: middle;" class="form-inline" action="/roof" method="get">
                                <input type="hidden" name="customerId" value="${customerId}"/>
                                <input type="hidden" name="orderId" value="${orderId}"/>
                                <span>Крыша</span>
                                <input type="hidden" name="roofId" value="${roofResults.roof.id}">
                                <button data-html2canvas-ignore="true"
                                        type="submit"
                                        class="btn-sm btn-icon tbIcon"
                                        title="Редактировать"
                                >
                                    <i class="fa fa-pencil" aria-hidden="true"></i>
                                </button>
                            </form>
                        </caption>
                        <thead>
                        <tr style="width: 100%;">
                            <th></th>
                            <th>Материал</th>
                            <th>Количество</th>
                            <th>Ед. измерения</th>
                            <th>Стоимость</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="table-info">
                            <th>Каркас</th>
                            <td></td>
                            <td></td>
                            <td></td>
                            <th>${roofResults.totalPriceOfFrame}</th>
                        </tr>
                        <tr>
                            <td>Стропила</td>
                            <td>${roofResults.nameOfRaftersWood}</td>
                            <td>${roofResults.volumeOfRaftersWood}</td>
                            <td>м3</td>
                            <td>${roofResults.priceOfRaftersWood}</td>
                        </tr>
                        <tr>
                            <td>Обрешетка</td>
                            <td>${roofResults.nameOfLathWood}</td>
                            <td>${roofResults.volumeOfLathWood}</td>
                            <td>м3</td>
                            <td>${roofResults.priceOfLathWood}</td>
                        </tr>
                        <tr class="table-info">
                            <th>Изоляция</th>
                            <td></td>
                            <td></td>
                            <td></td>
                            <th>${roofResults.totalPriceOfCover}</th>
                        </tr>
                        <tr>
                            <td>Парогидроизоляция</td>
                            <td>${roofResults.nameOfWater}</td>
                            <td>${roofResults.squareOfWater}</td>
                            <td>м2</td>
                            <td>${roofResults.priceOfWater}</td>
                        </tr>
                        <tr>
                            <td>Утеплитель</td>
                            <td>${roofResults.nameOfWarm}</td>
                            <td>${roofResults.volumeOfWarm}</td>
                            <td>шт</td>
                            <td>${roofResults.priceOfWarm}</td>
                        </tr>
                        <tr class="table-info">
                            <th>Кровля</th>
                            <td></td>
                            <td></td>
                            <td></td>
                            <th>${roofResults.totalPriceOfTop}</th>
                        </tr>
                        <tr>
                            <td>Кровля</td>
                            <td>${roofResults.nameOfTop}</td>
                            <td>${roofResults.squareOfTop}</td>
                            <td>м2</td>
                            <td>${roofResults.priceOfTop}</td>
                        </tr>
                        <tr class="table-info">
                            <th>ИТОГО</th>
                            <td></td>
                            <td></td>
                            <td></td>
                            <th class="result">${roofResults.totalPrice}</th>
                        </tr>
                        </tbody>
                    </table>
                <#else></#if>

                <hr/>
                <h5 class="d-inline-block cText mb-2" style="margin-left: 15px">ИТОГО: </h5>
                <h5 class="d-inline-block cText pull-right mb-2" style="margin-right: 15px">
                    <script>
                        let list = document.getElementsByClassName("result");
                        let sum = 0.0;
                        for (let i = 0; i < list.length; i++) {
                            sum += parseFloat(list[i].innerText.replace(/\s/g, "").replace(/,/, '.'));
                        }

                        document.write(sum.toLocaleString('ru-RU'));
                    </script>
                    &nbspруб.
                </h5>
            </div>
        </div>
    </div>
    <script charset=utf-8>
        function toPDF() {
            let cur = document.getElementById("html-template").cloneNode(true);
            let hidden = cur.firstChild.nextSibling;
            hidden.style.display = "block";
            html2pdf()
                // (C1) SET OPTIONS
                .set({
                    margin: [10, 15, 4, 5],
                    filename: "demo.pdf",
                    image: {type: "jpeg", quality: 1},
                    html2canvas: {
                        scale: 2,
                        logging: true,
                        dpi: 192,
                        letterRendering: true
                    },
                    jsPDF: {format: "A4", orientation: "portrait"}
                })

                // (C2) GET CONTENT FROM SECTION
                .from(cur)
                .toPdf().get('pdf').then(function (pdf) {
                var totalPages = pdf.internal.getNumberOfPages();
                for (i = 1; i <= totalPages; i++) {
                    console.log(pdf.internal.pageSize.getWidth() / 2.3)
                    pdf.setPage(i);
                    pdf.setFontSize(15);
                    pdf.setTextColor(100);
                    pdf.text(i + ' / ' + totalPages, (pdf.internal.pageSize.getWidth() / 2), (pdf.internal.pageSize.getHeight() - 10));
                }
            })

                // (C3) SAVE TO FILE
                .save();
            cur.remove();
        }
    </script>
</@c.navpage>