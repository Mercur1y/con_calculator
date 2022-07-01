<#import "macros/common.ftl" as c>
<@c.page>
    <h2 align="center">Результаты расчета</h2>
    <div class="form-row">
        <form action="/choice/order" method="get">
            <input type="hidden" name="orderId" value="${orderId}"/>
            <button type="submit" class="btn btn-outline-success">
                Добавить
            </button>
        </form>
        <form action="/choice" method="get">
            <input type="hidden" name="orderId" value="${orderId}"/>
            <button type="submit" class="btn btn-outline-success">
                Редактировать
            </button>
        </form>
    </div>

    <#list floorResults as result>
        <table class="table table-bordered">
            <h3>Этаж ${result.floor.number}</h3>
            <thead>
            <tr>
                <th scope="col"> </th>
                <th scope="col">Материал</th>
                <th scope="col">Ед. измерения</th>
                <th scope="col">Количество</th>
                <th scope="col">Стоимость</th>
            </tr>
            <tbody>
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
            </tbody>
        </table>
    <#else>
    </#list>
    <#list foundationResults as result>
        <table class="table table-bordered">
            <h3>Фундамент</h3>
            <thead>
            <tr>
                <th scope="col"> </th>
                <th scope="col">Материал</th>
                <th scope="col">Ед. измерения</th>
                <th scope="col">Количество</th>
                <th scope="col">Стоимость</th>
            </tr>
            <tbody>
            <tr class="table-info"><th>Сваи</th>
                <td></td>
                <td></td>
                <td></td>
                <th>${result.priceOfPiles}</th>
            </tr>
            <tr>
                <td>Сваи</td>
                <td>${result.nameOfPiles}</td>
                <td>шт</td>
                <td>${result.countOfPiles}</td>
                <td>${result.priceOfPiles}</td>
            </tr>
            <tr class="table-info"><th>Ростверк</th>
                <td></td>
                <td></td>
                <td></td>
                <th>${result.totalPriceOfGrillage}</th>
            </tr>
            <tr>
                <td>Бетон</td>
                <td>${result.nameOfConcrete}</td>
                <td>м3</td>
                <td>${result.volumeOfConcrete}</td>
                <td>${result.priceOfConcrete}</td>
            </tr>
            <tr>
                <td>Арматура</td>
                <td>${result.nameOfBigArm}</td>
                <td>шт</td>
                <td>${result.countOfBigArm}</td>
                <td>${result.priceOfBigArm}</td>
            </tr>
            <tr>
                <td>Арматура</td>
                <td>${result.nameOfSmallArm}</td>
                <td>шт</td>
                <td>${result.countOfSmallArm}</td>
                <td>${result.priceOfSmallArm}</td>
            </tr>
            <tr class="table-info"><th>Опалубка</th>
                <td></td>
                <td></td>
                <td></td>
                <th>${result.totalPriceOfFormwork}</th>
            </tr>
            <tr>
                <td>Доска</td>
                <td>${result.nameOfWood}</td>
                <td>м3</td>
                <td>${result.volumeOfWood}</td>
                <td>${result.priceOfWood}</td>
            </tr>
            <tr>
                <td>Брус</td>
                <td>${result.nameOfBalk}</td>
                <td>м3</td>
                <td>${result.volumeOfBalk}</td>
                <td>${result.priceOfBalk}</td>
            </tr>
            <tr class="table-info"><th>ИТОГО</th>
                <td></td>
                <td></td>
                <td></td>
                <th>${result.totalPrice}</th>
            </tr>
            </tbody>
        </table>
    <#else>
    </#list>
<#--    <table class="table table-bordered">-->
<#--    <tr class="table-success"><th>ИТОГО: ${total}</th>-->
<#--    </tr>-->
<#--    </table>-->
</@c.page>