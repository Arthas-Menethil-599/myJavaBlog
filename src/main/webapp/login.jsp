<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <%@include file="templates/bootstrap.jsp"%>
</head>
<body>
<% String error = request.getParameter("error"); %>
<div class="container-fluid">
  <%@include file="templates/navbar.jsp"%>
</div>
<div class="container mt-3">
  <div class="row">
    <%if (error != null) { %>
    <%if (error.equals("1")) {%>
    <div class="alert alert-warning alert-dismissible fade show" role="alert">
      <strong>Error!</strong> There is no account with such email.
      <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <% } else if (error.equals("2")) { %>
    <div class="alert alert-primary alert-dismissible fade show" role="alert">
      <strong>Error!</strong> Password is not correct.
      <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <%
    }
      }
    %>
    <div class="col-sm-6 offset-3">
      <form method="post" action="/login">
        <div class="form-group">
          <label class="form-label">
            EMAIL:
          </label>
          <input type="email" name="email" class="form-control" required value= "<%=request.getParameter("email") != null ? request.getParameter("email") : ""%>" />
        </div>
        <div class="form-group">
          <label class="form-label">
            PASSWORD:
          </label>
          <input type="password" name="password" class="form-control" required>
        </div>
        <div class="form-group mt-2">
          <button type="submit" class="btn btn-info">Sign in</button>
        </div>
      </form>
    </div>
  </div>
</div>
<br/>

</body>
</html>