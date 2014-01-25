<c:choose>
    <c:when test="${tracing_bean.utype == '4'}">
        <jsp:include page="common_pages2/customer_navi_logout.html" />
    </c:when>
    <c:when test="${tracing_bean.utype == '3'}">
        <jsp:include page="common_pages2/Receptionist_navi_logout.html" />
    </c:when>
    <c:when test="${tracing_bean.utype == '2'}">
        <jsp:include page="common_pages2/officer_navi_logout.html" />
    </c:when>
    <c:when test="${tracing_bean.utype == '1'}">
        <jsp:include page="common_pages2/admin_navi_logout.html" />
    </c:when>
    <c:otherwise>
        <jsp:include page="common_pages2/guest_navi_login.html" />
    </c:otherwise>
</c:choose>