<#import "macros/common.ftl" as c>
<@c.navpage>
    <style>
        .card {
            max-height: 190px;
            max-width: 340px;
            border-radius: 9px;
            box-shadow: 0 .5rem 1rem rgba(0, 0, 0, .15) !important;
        }
    </style>
    <div id="cards" class="container mb-3" style="max-width: 1140px">
        <div class="row" style="margin-left: 20px">
            <div class="col-1">
                <!-- Button trigger modal -->
                <button id="outline-grey" type="button" class="btn btn-outline-dark"
                        data-bs-toggle="modal" data-bs-target="#addForm">
                    <i class="fa fa-user-plus" aria-hidden="true"></i>
                </button>
            </div>
            <div class="col-3">
                <div class="input-group" style="width: 236px">
                    <input
                            class="form-control border-end-0 border"
                            id="inputSearch"
                            type="text"
                            onkeyup="search()"
                    />
                    <span class="input-group-append">
                    <button class="btn btn-outline-secondary bg-white border-start-0 border-bottom-0 border ms-n5 disabled"
                            type="button">
                        <i class="fa fa-search"></i>
                    </button>
                </span>
                </div>
            </div>
        </div>
        <h2 align="center" style="font-weight: bold">Клиенты</h2>
        <ul id="paginated-list" class="row row-cols-3 mt-5" style="margin-right: 2%">
            <#list customers as customer>
                <li class="col-4">
                    <div class="card p-1 mb-4">
                        <div class="card-body p-4">
                            <!-- Button trigger modal -->
                            <button type="button" class="btn-close pull-right" data-bs-toggle="modal"
                                    data-bs-target="#staticBackdrop"
                                    aria-label="Close">
                            </button>

                            <!-- Окно удаления -->
                            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
                                 data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog modal-sm">
                                    <div class="modal-content" style="border-radius: 8px">
                                        <div class="modal-header d-flex justify-content-end">
                                            Вы точно хотите удалить клиента из базы?
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                Отмена
                                            </button>
                                            <form action="/main/delete" method="post">
                                                <input type="hidden" name="customerId" value="${customer.id}"/>
                                                <input type="hidden" name="action" value="delete"/>
                                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                                <button id="primary-orange" type="submit" class="btn btn-primary">
                                                    Удалить
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="d-flex text-black">
                                <div class="d-inline-flex flex-column md-0 mr-2">
                                    <img src="https://cdn4.iconfinder.com/data/icons/communication-extras/512/Male_User-512.png"
                                         alt="Generic placeholder image" class="img-fluid"
                                         style="width: 100%/9; border-radius: 10px;">
                                </div>
                                <div class="flex-grow-1 ms-3">
                                    <h5 class="mb-1">${customer.lastName} ${customer.firstName}</h5>
                                    <p class="mb-2 pb-1" style="color: #2b2a2a;">№${customer.id}</p>
                                    <div class="d-flex">
                                        <button id="outline-grey" type="button" class="btn btn-outline-dark"
                                                data-bs-toggle="modal" data-bs-target="#editForm">
                                            <i class="fa fa-eye" aria-hidden="true"></i>
                                        </button>
                                        <!-- Окно Изменения -->
                                        <div class="modal fade" id="editForm" data-bs-backdrop="static"
                                             data-bs-keyboard="false" tabindex="-1"
                                             aria-labelledby="staticBackdropLabel"
                                             aria-hidden="true">
                                            <form method="post" action="/main/update">
                                                <div class="modal-dialog">
                                                    <div class="modal-content"
                                                         style="border-radius: 8px; max-width: 80% !important">
                                                        <div class="modal-header">
                                                            <h6 class="modal-title text-center ml-2"
                                                                style="font-weight: bold" id="exampleModalLabel">
                                                                Редактировать профиль</h6>
                                                            <button type="button" class="btn-close"
                                                                    data-bs-dismiss="modal" aria-label="Close"></button>
                                                        </div>
                                                        <div class="modal-body d-block">
                                                            <div class="form-outline mb-2">
                                                                <div class="p-2">
                                                                    <input type="text" name="lastName"
                                                                           class="form-control "
                                                                           placeholder="Фамилия"
                                                                           value="${customer.lastName}"
                                                                           required="required"
                                                                           pattern="[А-Яа-я0-9]{1,20}"/>
                                                                </div>
                                                            </div>
                                                            <div class="form-outline mb-2">
                                                                <div class="p-2">
                                                                    <input type="text" name="firstName"
                                                                           class="form-control"
                                                                           placeholder="Имя"
                                                                           value="${customer.firstName}"
                                                                           required="required"
                                                                           pattern="[А-Яа-я]{1,20}"/>
                                                                </div>
                                                            </div>
                                                            <div class="form-outline mb-2">
                                                                <div class="p-2">
                                                                    <input type="text" name="secondName"
                                                                           class="form-control"
                                                                           placeholder="Отчество"
                                                                           value="${customer.secondName}"
                                                                           required="required"
                                                                           pattern="[А-Яа-я]{1,20}"/>
                                                                </div>
                                                            </div>
                                                            <div class="form-outline mb-2">
                                                                <div class="p-2">
                                                                    <input
                                                                            id="phone"
                                                                            type="text" name="phone"
                                                                            data-mask="phone"
                                                                            class="form-control"
                                                                            placeholder="Телефон"
                                                                            value="${customer.phone}"/>
                                                                </div>
                                                            </div>
                                                            <div class="form-outline mb-2">
                                                                <div class="p-2">
                                                                    <input type="email" name="email"
                                                                           class="form-control"
                                                                           placeholder="some@some.com"
                                                                           value="${customer.email}"
                                                                           required="required"
                                                                           pattern="[A-Za-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}"/>
                                                                </div>
                                                            </div>
                                                            <div class="form-outline mb-2">
                                                                <div class="p-2">
                                                                    <input
                                                                            id="adress"
                                                                            type="text" name="adress"
                                                                            class="form-control"
                                                                            placeholder="Адрес"
                                                                            value="${customer.adress}"
                                                                            required="required"
                                                                            pattern="[А-Яа-я0-9._%+-\s]{1,40}"/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary"
                                                                    data-bs-dismiss="modal">
                                                                Отмена
                                                            </button>
                                                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                                            <input type="hidden" name="customerId"
                                                                   value="${customer.id}"/>
                                                            <button id="primary-orange" type="submit"
                                                                    class="btn btn-primary">Сохранить
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <div style="margin-left: 5px">
                                        <form action="/orders/${customer.id}" method="get">
                                            <button id="primary-orange" type="submit" class="btn btn-primary ml-2">
                                                Заказы
                                            </button>
                                        </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </#list>
        </ul>
    </div>
    <nav class="pagination-container">
        <button class="pagination-button" id="prev-button" title="Previous page" aria-label="Previous page">
            &lt;
        </button>

        <div id="pagination-numbers">
        </div>

        <button class="pagination-button" id="next-button" title="Next page" aria-label="Next page">
            &gt;
        </button>
    </nav>
    <!-- Окно добавления -->
    <div class="modal fade" id="addForm" data-bs-backdrop="static"
         data-bs-keyboard="false" tabindex="-1"
         aria-labelledby="staticBackdropLabel"
         aria-hidden="true">
        <form method="post">
            <div class="modal-dialog">
                <div class="modal-content" style="border-radius: 8px; max-width: 80% !important">
                    <div class="modal-header">
                        <h6 class="modal-title text-center ml-2" style="font-weight: bold" id="exampleModalLabel">Новый
                            клиент</h6>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body d-block">
                        <div class="form-outline mb-2">
                            <div class="p-2">
                                <input type="text" name="lastName"
                                       class="form-control "
                                       placeholder="Фамилия"
                                       required="required" pattern="[А-Яа-я0-9]{1,20}"/>
                            </div>
                        </div>
                        <div class="form-outline mb-2">
                            <div class="p-2">
                                <input type="text" name="firstName"
                                       class="form-control"
                                       placeholder="Имя"
                                       required="required" pattern="[А-Яа-я]{1,20}"/>
                            </div>
                        </div>
                        <div class="form-outline mb-2">
                            <div class="p-2">
                                <input type="text" name="secondName"
                                       class="form-control"
                                       placeholder="Отчество"
                                       required="required" pattern="[А-Яа-я]{1,20}"/>
                            </div>
                        </div>
                        <div class="form-outline mb-2">
                            <div class="p-2">
                                <input
                                        id="phone"
                                        type="text" name="phone"
                                        data-mask="phone"
                                        class="form-control"
                                        placeholder="Телефон"/>
                            </div>
                        </div>
                        <div class="form-outline mb-2">
                            <div class="p-2">
                                <input type="email" name="email"
                                       class="form-control"
                                       placeholder="some@some.com"
                                       required="required" pattern="[A-Za-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}"/>
                            </div>
                        </div>
                        <div class="form-outline mb-2">
                            <div class="p-2">
                                <input
                                        id="adress"
                                        type="text" name="adress"
                                        class="form-control"
                                        placeholder="Адрес"
                                        required="required" pattern="[А-Яа-я0-9._%+-\s]{1,40}"/>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary"
                                data-bs-dismiss="modal">
                            Отмена
                        </button>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button id="primary-orange" type="submit"
                                class="btn btn-primary">Сохранить
                        </button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <script>
        const paginationNumbers = document.getElementById("pagination-numbers");
        const paginatedList = document.getElementById("paginated-list");
        const listItems = paginatedList.querySelectorAll("li");
        const nextButton = document.getElementById("next-button");
        const prevButton = document.getElementById("prev-button");

        const paginationLimit = 6;
        const pageCount = Math.ceil(listItems.length / paginationLimit);
        let currentPage = 1;

        const disableButton = (button) => {
            button.classList.add("disabled");
            button.setAttribute("disabled", true);
        };

        const enableButton = (button) => {
            button.classList.remove("disabled");
            button.removeAttribute("disabled");
        };

        const handlePageButtonsStatus = () => {
            if (currentPage === 1) {
                disableButton(prevButton);
            } else {
                enableButton(prevButton);
            }

            if (pageCount === currentPage) {
                disableButton(nextButton);
            } else {
                enableButton(nextButton);
            }
        };

        const handleActivePageNumber = () => {
            document.querySelectorAll(".pagination-number").forEach((button) => {
                button.classList.remove("active");
                const pageIndex = Number(button.getAttribute("page-index"));
                if (pageIndex === currentPage) {
                    button.classList.add("active");
                }
            });
        };

        const appendPageNumber = (index) => {
            const pageNumber = document.createElement("button");
            pageNumber.className = "pagination-number";
            pageNumber.innerHTML = index;
            pageNumber.setAttribute("page-index", index);
            pageNumber.setAttribute("aria-label", "Page " + index);

            paginationNumbers.appendChild(pageNumber);
        };

        const getPaginationNumbers = () => {
            for (let i = 1; i <= pageCount; i++) {
                appendPageNumber(i);
            }
        };

        const setCurrentPage = (pageNum) => {
            currentPage = pageNum;

            handleActivePageNumber();
            handlePageButtonsStatus();

            const prevRange = (pageNum - 1) * paginationLimit;
            const currRange = pageNum * paginationLimit;

            listItems.forEach((item, index) => {
                item.classList.add("d-none");
                if (index >= prevRange && index < currRange) {
                    item.classList.remove("d-none");
                    item.classList.toggle("is-visible");
                }
            });
        };

        window.addEventListener("load", () => {
            getPaginationNumbers();
            setCurrentPage(1);

            prevButton.addEventListener("click", () => {
                setCurrentPage(currentPage - 1);
            });

            nextButton.addEventListener("click", () => {
                setCurrentPage(currentPage + 1);
            });

            document.querySelectorAll(".pagination-number").forEach((button) => {
                const pageIndex = Number(button.getAttribute("page-index"));

                if (pageIndex) {
                    button.addEventListener("click", () => {
                        setCurrentPage(pageIndex);
                    });
                }
            });
        });

        function search() {
            let input = document.getElementById("inputSearch");
            let filter = input.value.toUpperCase();
            let li = listItems;

            // Перебирайте все элементы списка и скрывайте те, которые не соответствуют поисковому запросу
            for (let i = 0; i < li.length; i++) {
                let a = li[i].getElementsByTagName("h5")[0];
                let txt = a.textContent || a.innerText;
                let nosp = txt.replace(/\s/g, "");
                if (nosp.toUpperCase().indexOf(filter) > -1) {
                    li[i].classList.remove("d-none");
                } else {
                    li[i].classList.add("d-none");
                }
            }

            if (filter === "") {
                setCurrentPage(1);
            }
        }

        document.addEventListener('DOMContentLoaded', () => {

            const elements = document.querySelectorAll('[data-mask="phone"]') // ищем все поля с атрибутом data-mask="phone"
            if (!elements) return // если таких нет, прекращаем выполнение функции
            const phoneOptions = { // создаем объект параметров
                mask: '+{7}(000)000-00-00' // задаем единственный параметр mask
            }
            elements.forEach(el => { // для каждого найденного поля с атрибутом [data-mask="phone"]
                IMask(el, phoneOptions) // инициализируем плагин с установленными выше параметрами
            })

        })
    </script>
</@c.navpage>