<%@ page language="java"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>

<html>
  <head>
    <title>
      Show customers
    </title>
  </head>
  <body>
    <html:form action="bookEdit">
      <table border="1">
        <tbody>
          <%-- set the header --%>
          <tr>
            <td>
              Last name
            </td>
            <td>
              First name
            </td>
            <td>
              Borrow
            </td>
          </tr>

          <%-- start with an iterate over the collection users --%>
          <logic:present name="customers">
            <logic:iterate name="customers" id="customer">
              <tr>
                <%-- book informations --%>
                <td>
                  <bean:write name="customer" property="lastname" />
                </td>
                <td>
                  <bean:write name="customer" property="firstname" />
                </td>
                <td>
                  <html:radio property="customerId" value="${customer.id}" />
                </td>
              </tr>
            </logic:iterate>
          </logic:present>
          <%-- end interate --%>

          <%-- if customers cannot be found display a text --%>
          <logic:notPresent name="customers">
            <tr>
              <td colspan="5">
                No customers found.
              </td>
            </tr>
          </logic:notPresent>
        </tbody>
      </table>

      <%-- set the book id to lent --%>
      <html:hidden property="id" />

      <%-- set the parameter for the dispatch action --%>
      <html:hidden property="do" value="saveBorrow" />

      <%-- submit and back button --%>
      <html:button property="back" onclick="history.back();">
                                 Back
        </html:button>
        &nbsp;
        <html:submit>Save</html:submit>
    </html:form>
  </body>
</html>
