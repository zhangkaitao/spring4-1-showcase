<%@ page import="org.springframework.web.servlet.resource.ResourceUrlProvider" %>
<%@page contentType="text/html; utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

hello
<%=((ResourceUrlProvider)request.getAttribute("org.springframework.web.servlet.resource.ResourceUrlProvider"))
        .getForLookupPath("/static/css/style.css")%>

</body>
</html>