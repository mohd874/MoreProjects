<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ include file="commonLayout/taglibs.jspf" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<tiles:insert page="/commonLayout/commonLayout.jsp" flush="true">
    <tiles:put name="title" type="string"
               value="Room ${roomObj.name} Schedule" />
    <tiles:put name="header" value="/commonLayout/header.jsp" />
    <tiles:put name="footer" value="/commonLayout/footer.jsp" />
    <tiles:put name="content" direct="true">
        <html:errors />
        <html:form action="roomSchedule">
            <html:hidden property="semesterWeek" value="${semesterWeek}"/>
            <html:hidden property="room" value="${room}"/>
            <html:hidden property="semester" value="${semester}"/>
            <html:hidden property="numberOfWeeksForSemester" value="${numberOfWeeksForSemester}"/>
            
            <jsp:useBean id="next" class="java.util.HashMap"/>
            <jsp:useBean id="prev" class="java.util.HashMap"/>
            <c:set target="${next}" property="action" value="next"/>
            <c:set target="${prev}" property="action" value="prev"/>
            
            <table border="0">
                <td>
                    <%--html:link action="roomSchedule" name="prev"><< Prev Week</html:link--%>
                    <html:submit value="<< Prev Week" property="action" disabled="${semesterWeek <= 1}"/>
                </td>
                <td>
                    <p><b>name:</b> ${roomObj.name} <b>Section:</b> ${roomObj.block.name} <b>Short Descreption:</b> ${roomObj.description}</p>
                    <p align="center"> <b>Week:</b> ${semesterWeek}</p>
                </td>
                <td>
                    <%--html:link action="roomSchedule" name="next">Next Week>></html:link--%>
                    <html:submit value="Next Week >>" property="action" disabled="${semesterWeek >= numberOfWeeksForSemester}"/>
                </td>
            </table>
            <table border="1">
                <tr>
                    <td >Time</td>
                    <td >Saturday</td>
                    <td >Sunday</td>
                    <td >Monday</td>
                    <td >Tuesday</td>
                    <td >Wednesday</td>
                    <td >Thursday</td>
                </tr>
                <jsp:useBean id="isEmpty" class="java.util.HashMap"/>
                <c:forEach var="period" items="${periods}" varStatus="periodIndex">
                    <tr>
                        <td>${period.periodSegment}</td>
                        <c:forEach var="obj" items="${objs}" varStatus="objIndex">
                            <td>
                                <c:set target="${isEmpty}" property="isEmpty" value="true"/>
                                <c:forEach var="classSchedule" items="${period.classSchedules}">
                                    <c:if test="${classSchedule.dayOfWeek == (objIndex.count)}">
                                    ${classSchedule.course.code}<br>
                                    ${classSchedule.course.title}<br>
                                    ${classSchedule.reserver.loginName}<br>
                                        <c:set target="${isEmpty}" property="isEmpty" value="false"/>
                                    </c:if>
                                </c:forEach>
                                <c:if test="${isEmpty['isEmpty'] == 'true'}">
                                    <html:checkbox  property="periodDay" value="${period.id}-${objIndex.count}"/>
                                </c:if>
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
            <p> 
                <html:submit value="Reserve" property="action"/>
                <html:radio property="reservationWeeks" value="ThisWeek"/> Only This Week 
                <html:radio property="reservationWeeks" value="ThisSemester"/> Whole Semester
                <html:select property="selectedCourse" value="id">
                    <%--c:forEach var="c" items="${courses}">
                        <html:option value="${c.id}">${c.fullName}</html:option>
                    </c:forEach--%>
                    <html:optionsCollection name="courses" value="id" label="fullName" />
                </html:select>
            </p>
        </html:form>
    </tiles:put>
</tiles:insert>