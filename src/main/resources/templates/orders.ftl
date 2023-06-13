<#import "macros/common.ftl" as c>
<@c.navpage>
    <style>
        .bodycontainer {
            max-height: 450px;
            width: 100%;
            margin: 0;
            overflow-y: auto;
        }

        .table-scrollable {
            table-layout: auto;
            margin: 0;
            padding: 0;
        }

        .card {
            box-shadow: 0 .5rem 1rem rgba(0, 0, 0, .15) !important;
        }
    </style>
    <h2 align="center" style="font-weight: bold">Карточка клиента №${customerId}</h2>
    <div class="row mt-5">
    <div class="col-md-5">
        <div class="card p-1 mb-4" style="border-radius: 9px; height: 175px">
            <div class="card-header text-center">Личные данные</div>
            <div class="card-body">
                <div class="mb-1">
                    ${customer.lastName} ${customer.firstName} ${customer.secondName}
                </div>
                <div class="mb-1">
                    ${customer.email}
                </div>
                <div>
                    ${customer.phone}
                </div>
            </div>
        </div>
        <div class="card p-1 mb-4 text-center" style="border-radius: 9px; height: 300px">
            <div class="card-header">Статистика заказов</div>
            <div class="card-body mt-2">
                <div id="chart-container" style="height: 190px">
                    <canvas id="doughnutChart"></canvas>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-7">
        <div class="card p-1 mb-4" style="border-radius: 9px; height: 500px">
            <div class="card-header" style="height: 49px">
                <button type="button"
                        class="btn-sm btn-icon pull-right tbIcon"
                        style="position: absolute; top: 12px; right: 10px;"
                        data-bs-toggle="modal" data-bs-target="#addOrder"
                        title="Новый заказ"
                >
                    <i class="fa fa-plus-square-o" style="font-size: 1.73em" aria-hidden="true"></i>
                </button>
                <h6 class="text-center mt-1 ml-4">Список заказов</h6>

                <div class="card-body p-0 mt-4">
                    <div class="table-responsive">
                        <table id="tb" class="table table-striped table-hover table-condensed table-sm">
                            <thead>
                            <tr>
                                <th class="text-center" style="width: 10%">Дата</th>
                                <th class="text-center" style="width: 20%">Статус</th>
                                <th class="text-center" style="width: 30%">Адрес</th>
                                <th class="text-center"></th>
                            </tr>
                            </thead>
                        </table>
                        <div class="bodycontainer scrollable" style="height: 345px">
                            <table class="table table-hover table-striped table-scrollable">
                                <#list orders?sort?reverse as order>
                                    <tbody>
                                    <tr id="tb-data" style="border-bottom:2px solid transparent">
                                        <td style="vertical-align: middle;">${order.localDateTime}</td>
                                        <td style="vertical-align: middle;">
                                            <span class="statItem">${order.status}</span>
                                        </td>
                                        <td style="vertical-align: middle;">
                                            <button class="btn-sm btn-icon mr-2 tbIcon"
                                                    title="Изменение статуса"
                                                    data-bs-toggle="modal"
                                                    data-bs-target="#upModal">
                                                    <span class="icon"><i class="fa fa-pencil-square-o"
                                                                          style="color: #4faab3"
                                                                          aria-hidden="true"></i></span>
                                            </button>
                                            <!-- Окно изменения статуса -->
                                            <div class="modal fade" id="upModal" data-bs-backdrop="static"
                                                 data-bs-keyboard="false" tabindex="-1"
                                                 aria-labelledby="staticBackdropLabel"
                                                 aria-hidden="true">
                                                <form method="post" action="/orders/updateStatus">
                                                    <div class="modal-dialog modal-sm">
                                                        <div class="modal-content"
                                                             style="border-radius: 8px">
                                                            <div class="modal-header">
                                                                Статус заказа
                                                                <button type="button" class="btn-close"
                                                                        data-bs-dismiss="modal"
                                                                        aria-label="Close"></button>
                                                            </div>
                                                            <div class="modal-body ml-4">
                                                                <div class="p-2">
                                                                    <div class="form-check form-check-inline">
                                                                        <input class="form-check-input"
                                                                               type="radio" name="status"
                                                                               id="inlineRadio1"
                                                                               value="Создан"
                                                                               checked="checked">
                                                                        <label class="form-check-label"
                                                                               for="inlineRadio1">Создан</label>
                                                                    </div>
                                                                </div>
                                                                <div class="p-2">
                                                                    <div class="form-check form-check-inline">
                                                                        <input class="form-check-input"
                                                                               type="radio" name="status"
                                                                               id="inlineRadio2"
                                                                               value="Актуален">
                                                                        <label class="form-check-label"
                                                                               for="inlineRadio2">Актуален</label>
                                                                    </div>
                                                                </div>
                                                                <div class="p-2">
                                                                    <div class="form-check form-check-inline">
                                                                        <input class="form-check-input"
                                                                               type="radio" name="status"
                                                                               id="inlineRadio3"
                                                                               value="Завершен">
                                                                        <label class="form-check-label"
                                                                               for="inlineRadio3">Завершен</label>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button"
                                                                        class="btn btn-secondary"
                                                                        data-bs-dismiss="modal">
                                                                    Отмена
                                                                </button>
                                                                <input type="hidden" name="orderId"
                                                                       value="${order.id}"/>
                                                                <input type="hidden" name="customerId"
                                                                       value="${customerId}">
                                                                <input type="hidden" name="_csrf"
                                                                       value="${_csrf.token}"/>
                                                                <button id="primary-orange" type="submit"
                                                                        class="btn btn-primary">
                                                                    Изменить
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </td>
                                        <td style="vertical-align: middle;">${order.adress}</td>
                                        <td class="tbBtn">
                                            <form action="/results" method="get">
                                                <input type="hidden" name="orderId" value="${order.id}"/>
                                                <input type="hidden" name="customerId" value="${customerId}"/>
                                                <button class="btn-sm btn-icon mr-2 tbIcon">
                                                    <span class="icon"><i class="fa fa-fax"
                                                                          title="Открыть отчет"
                                                                          aria-hidden="true"></i></span>
                                                </button>
                                            </form>
                                        </td>
                                        <td class="tbBtn">
                                            <button type="button" class="btn-sm btn-icon tbIcon"
                                                    data-bs-toggle="modal" data-bs-target="#delModal">
                                                    <span class="icon"><i class="fa fa-times"
                                                                          title="Удалить"
                                                                          aria-hidden="true"></i></span>
                                            </button>
                                            <!-- Окно удаления -->
                                            <div class="modal fade" id="delModal" data-bs-backdrop="static"
                                                 data-bs-keyboard="false" tabindex="-1"
                                                 aria-labelledby="staticBackdropLabel"
                                                 aria-hidden="true">
                                                <div class="modal-dialog modal-sm">
                                                    <div class="modal-content" style="border-radius: 8px">
                                                        <div class="modal-header d-flex justify-content-end">
                                                            Вы точно хотите удалить заказ?
                                                            <button type="button" class="btn-close"
                                                                    data-bs-dismiss="modal" aria-label="Close"></button>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary"
                                                                    data-bs-dismiss="modal">
                                                                Отмена
                                                            </button>
                                                            <form method="post">
                                                                <input type="hidden" name="orderId"
                                                                       value="${order.id}"/>
                                                                <input type="hidden" name="customerId"
                                                                       value="${customerId}">
                                                                <input type="hidden" name="action" value="delete"/>
                                                                <input type="hidden" name="_csrf"
                                                                       value="${_csrf.token}"/>
                                                                <button id="primary-orange" type="submit"
                                                                        class="btn btn-primary">
                                                                    Удалить
                                                                </button>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                </#list>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Окно выбора -->
    <div class="modal fade" id="addOrder" data-bs-backdrop="static"
         data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
         aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content" style="border-radius: 8px">
                <div class="modal-header">
                    Выберите элемент
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="d-grid gap-2">
                        <form action="/floor/new" method="get">
                            <#if customerId??><input type="hidden" name="customerId" value="${customerId}"></#if>
                            <#if orderId??><input type="hidden" name="orderId" value="${orderId}"></#if>
                            <button type="submit" class="btn btn-secondary btn-block" style="width: 100%"> Каркас этажа</button>
                        </form>
                        <form action="/foundation/new" method="get">
                            <#if customerId??><input type="hidden" name="customerId" value="${customerId}"></#if>
                            <#if orderId??><input type="hidden" name="orderId" value="${orderId}"></#if>
                            <button type="submit" class="btn btn-secondary btn-block" style="width: 100%">Фундамент</button>
                        </form>
                        <button type="submit" class="btn btn-secondary btn-block"
                                data-bs-target="#Modal2" data-bs-toggle="modal" data-bs-dismiss="modal"
                                style="width: 100%">Крыша</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Окно выбора крыши -->
    <div class="modal fade" id="Modal2" data-bs-backdrop="static"
         data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
         aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalToggleLabel2">Выберите тип</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="d-grid gap-2">
                    <form action="/roof/new" method="get">
                        <#if customerId??><input type="hidden" name="customerId" value="${customerId}"></#if>
                        <#if orderId??><input type="hidden" name="orderId" value="${orderId}"></#if>
                        <input type="hidden" name="type" value="1">
                        <button type="submit" class="btn btn-secondary btn-block" style="width: 100%">Односкатная</button>
                    </form>
                    <form action="/roof/new" method="get">
                        <#if customerId??><input type="hidden" name="customerId" value="${customerId}"></#if>
                        <#if orderId??><input type="hidden" name="orderId" value="${orderId}"></#if>
                        <input type="hidden" name="type" value="2">
                        <button type="submit" class="btn btn-secondary btn-block" style="width: 100%">Двускатная</button>
                    </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.bundle.min.js'></script>
    <script>
        const elemList = document.getElementsByClassName("statItem");
        const cList = [];
        const zList = [];
        const aList = [];

        for (let i = 0; i < elemList.length; i++) {
            let txt = elemList[i].textContent || elemList[i].innerText;
            if (txt === "Создан") {
                cList.push(txt)
            }
            if (txt === "Актуален") {
                aList.push(txt)
            }
            if (txt === "Завершен") {
                zList.push(txt)
            }
        }

        var doughnutChart = document.getElementById('doughnutChart').getContext('2d');
        var myDoughnutChart = new Chart(doughnutChart, {
            type: 'doughnut',
            data: {
                datasets: [{
                    data: [cList.length, zList.length, aList.length],
                    backgroundColor: ['#4faab3', '#4481C1', '#ff4800']
                }],

                labels: [
                    'Созданные',
                    'Завершенные',
                    'Актуальные'
                ]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                legend: {
                    position: 'bottom'
                },
                layout: {
                    padding: {
                        left: 20,
                        right: 20,
                        top: 20,
                        bottom: 20
                    }
                }
            }
        });
    </script>
</@c.navpage>