<%@ include file="WEB-INF/jspf/top.jspf" %>
<c:if test="${userBean.id == -1}">
    <jsp:forward page="login.jsp"/>
</c:if>
<div id="content">
    <%@ include file="WEB-INF/jspf/errorViewer.jspf" %>
    <table width="250" border="0" align="center">
        <tr>
            <th scope="col"><h3>Service (Km)</h3></th>
            <th scope="col"><h3>Price (AED)</h3></th>
        </tr>
        <tr>
            <th scope="row">5000</th>
            <td><div align="center">800 </div></td>
        </tr>
        <tr>
            <th scope="row">10000</th>
            <td><div align="center">1000</div></td>
        </tr>
        <tr>
            <th scope="row">20000</th>
            <td><div align="center">1200</div></td>
        </tr>
        <tr>
            <th scope="row">30000</th>
            <td><div align="center">1500</div></td>
        </tr>
    </table>
    
    <br />
    <form method="post" action="<c:url value="/registerCar" />">
        <input type="hidden" value="registerCar" name="action" />
        <table width="350" border="0" align="center">
            <tr>
                <td scope="row" align="center" colspan="2">All Fields are required </td>
            </tr>
            <tr>
                <th scope="row" align="right">Plate No.:</th>
                <td><input type="text" name="plateNumber" value="${plateNumber}"/></td>
            </tr>
            <tr>
                <th scope="row" align="right">Plate Color:</th>
                <td><input type="text" name="plateColor" value="${plateColor}"/></td>
            </tr>
            <tr>
                <th scope="row" align="right">Cahssis No.:</th>
                <td><input type="text" name="chasis" value="${chasis}"/></td>
            </tr>
            <tr>
                <th scope="row" align="right">Manufacturer:</th>
                <td><input name="manufacturer" type="text" id="manufacturer" value="${manufacturer}"/></td>
            </tr>
            <tr>
                <th scope="row" align="right">Model:</th>
                <td><input name="model" type="text" id="model" value="${model}"/></td>
            </tr>
            <tr>
                <th scope="row" align="right">Year of Manufacturering:</th>
                <td><input name="yearOfManufacturing" type="text" id="yearOfManufacturing" value="${yearOfManufacturing}"/></td>
            </tr>
            <tr>
                <th scope="row" align="right">Service Type:</th>
                <td><select name="service">
                        <option>5000</option>
                        <option>10000</option>
                        <option>20000</option>
                        <option>30000</option>
                    </select>
                <strong>KM</strong> </td>
            </tr>
            <tr>
                <th scope="row" align="right">Date to Serve the Car: (dd-mm-yyyy)</th>
                <td>
                    <input name="serviceDate" type="text" id="serviceDate" value="${serviceDate}"/>
                    <input type=button value="select" onclick="displayDatePicker('serviceDate', false, 'dmy', '-');">
                </td>
            </tr>
            <tr>
                <th colspan="2" scope="row">
                    <center>
                        <input type="submit" name="Submit" value="Submit" />
                </center>                </th>
            </tr>
        </table>
    </form>
</div>
<%@ include file="WEB-INF/jspf/bottom.jspf" %>

