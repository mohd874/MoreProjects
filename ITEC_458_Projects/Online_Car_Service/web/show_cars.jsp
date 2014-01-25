<%@ include file="WEB-INF/jspf/top.jspf" %>
<c:if test="${userBean.id == -1}">
    <jsp:forward page="login.jsp"/>
</c:if>

<div id="content">
    <c:if test="${userBean.type == 'admin'}">
        <form method="post" action="<c:url value="/showCars" />">
            <input type="hidden" value="showCarsForDate" name="action" />
            <table width="350" border="0" align="center">
                <tr>
                    <td>
                        Show Cars for Date:
                    </td>
                    <td>
                        <input name="serviceDate" type="text" value="${serviceDate}"/>
                    </td>
                    <td>
                        <input type="submit" value="Submit"/>
                    </td>
                </tr>
            </table>
        </form>
    </c:if>
    <table width="350" border="0" align="center">
        <tr>
            <th scope="row" align="right">#</th>
            <th scope="row" align="right">Plate Number</th>
            <th scope="row" align="right">Plate Color</th>
            <th scope="row" align="right">Chassis Number</th>
            <th scope="row" align="right">Manufacturer</th>
            <th scope="row" align="right">Model</th>
            <th scope="row" align="right">Year of Manufacturing</th>
            <th scope="row" align="right">Service Type</th>
            <th scope="row" align="right">Service Date</th>
            <th scope="row" align="right">Service Price</th>
        </tr>
        <c:forEach var="car" items="${cars}" varStatus="count">
            <tr>
                <td scope="row" align="right">${count.count}</td>
                <td scope="row" align="right">${car.plateNumber}</td>
                <td scope="row" align="right">${car.plateColor}</td>
                <td scope="row" align="right">${car.chasisNumber}</td>
                <td scope="row" align="right">${car.manufacturer}</td>
                <td scope="row" align="right">${car.model}</td>
                <td scope="row" align="right">${car.yearOfManufacturing}</td>
                <td scope="row" align="right">${car.service}</td>
                <td scope="row" align="right">${car.serviceDate}</td>
                <td scope="row" align="right">${car.servicePrice}</td>
            </tr>
        </c:forEach>
        <tr>
            <th scope="row" align="right" colspan="8">&nbsp;</th>
            <th scope="row" align="right">Grand Total: </th>
            <th scope="row" align="right">${grandTotal}</th>
        </tr>
    </table>
</div>
<%@ include file="WEB-INF/jspf/bottom.jspf" %>

