<#import "macros/common.ftl" as c>
<@c.page>
    <h2 align="center">Результаты расчета</h2>
<#--    <a class="btn btn-outline-success" href="/newFrame/${customer.id}">Новый каркас</a>-->
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col"> </th>
            <th scope="col">Материал</th>
            <th scope="col">Ед. измерения</th>
            <th scope="col">Количество</th>
            <th scope="col">Стоимость</th>
        </tr>
        <tbody>
        <#list results as result>
            <tr class="table-info"><th>Внешние стены</th>
                <td></td>
                <td></td>
                <td></td>
                <th>${result.getTotalOutPrice()}</th>
            </tr>
            <tr>
                <td>Доска</td>
                <td>${result.nameOfOutWood}</td>
                <td>м3</td>
                <td>${result.volumeOfOutWood}</td>
                <td>${result.priceOfOutWood}</td>
            </tr>
            <tr>
                <td>Утеплитель</td>
                <td>${result.nameOfOutWarm}</td>
                <td>м3</td>
                <td>${result.volumeOfOutWarm}</td>
                <td>${result.priceOfOutWarm}</td>
            </tr>
            <tr>
                <td>ОСБ</td>
                <td>${result.nameOfOutOsb}</td>
                <td>м2</td>
                <td>${result.squareOfOutOsb}</td>
                <td>${result.priceOfOutOsb}</td>
            </tr>
            <tr>
                <td>Парогидроизоляция</td>
                <td>${result.nameOfOutWater}</td>
                <td>м2</td>
                <td>${result.squareOfOutWater}</td>
                <td>${result.priceOfOutWater}</td>
            </tr>
            <tr>
                <td>Ветрозащита</td>
                <td>${result.nameOfOutWind}</td>
                <td>м2</td>
                <td>${result.squareOfOutWind}</td>
                <td>${result.priceOfOutWind}</td>
            </tr>
            <tr class="table-info"><th>Внутренние стены</th>
                <td></td>
                <td></td>
                <td></td>
                <th>${result.getTotalInPrice()}</th>
            </tr>
            <tr>
                <td>Доска</td>
                <td>${result.nameOfInWood}</td>
                <td>м3</td>
                <td>${result.volumeOfInWood}</td>
                <td>${result.priceOfInWood}</td>
            </tr>
            <tr>
                <td>ОСБ</td>
                <td>${result.nameOfInOsb}</td>
                <td>м2</td>
                <td>${result.squareOfInOsb}</td>
                <td>${result.priceOfInOsb}</td>
            </tr>
            <tr class="table-info"><th>Перекрытия</th>
                <td></td>
                <td></td>
                <td></td>
                <th>${result.getTotalOverPrice()}</th>
            </tr>
            <tr>
                <td>Доска</td>
                <td>${result.nameOfOverWood}</td>
                <td>м3</td>
                <td>${result.volumeOfOverWood}</td>
                <td>${result.priceOfOverWood}</td>
            </tr>
            <tr>
                <td>Утеплитель</td>
                <td>${result.nameOfOverWarm}</td>
                <td>м3</td>
                <td>${result.volumeOfOverWarm}</td>
                <td>${result.priceOfOverWarm}</td>
            </tr>
            <tr>
                <td>ОСБ</td>
                <td>${result.nameOfOverOsb}</td>
                <td>м2</td>
                <td>${result.squareOfOverOsb}</td>
                <td>${result.priceOfOverOsb}</td>
            </tr>
            <tr>
                <td>Парогидроизоляция</td>
                <td>${result.nameOfOverWater}</td>
                <td>м2</td>
                <td>${result.squareOfOverWater}</td>
                <td>${result.priceOfOverWater}</td>
            </tr>
            <tr>
                <td>Ветрозащита</td>
                <td>${result.nameOfOverWind}</td>
                <td>м2</td>
                <td>${result.squareOfOverWind}</td>
                <td>${result.priceOfOverWind}</td>
            </tr>
            <tr class="table-info"><th>ИТОГО</th>
                <td></td>
                <td></td>
                <td></td>
                <th>${result.getTotalAllPrice()}</th>
            </tr>
        <#else>
            Заказов нет
        </#list>
        </tbody>
    </table>
</@c.page>