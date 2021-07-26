<%@ page import="org.itstep.Lesson_14.models.Blog" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@include file="templates/bootstrap.jsp"%>
</head>
<body>
<% List<Blog> posts = (List<Blog>) request.getAttribute("posts"); %>
<div class="container-fluid">
    <%@include file="templates/navbar.jsp"%>
</div>
<br/>
<%  if (posts != null) {
    for (Blog post : posts) {
%>
<h1><%=post.getTitle()%></h1>
<%
        }
    }
%>
</body>
</html>