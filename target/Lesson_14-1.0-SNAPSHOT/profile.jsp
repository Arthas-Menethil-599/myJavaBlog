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
            <strong>Error!</strong> Account with email <%=request.getParameter("email")%> already exist.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <% } else if (error.equals("2")) { %>
        <div class="alert alert-primary alert-dismissible fade show" role="alert">
            <strong>Error!</strong> Passwords do not match.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <%
                }
            }
        %>
        <div class="col-sm-6 offset-3">
            <form method="post" action="/updateProfile">
                <div class="form-group">
                    <label class="form-label">
                        EMAIL:
                    </label>
                    <input type="email" name="email" class="form-control" readonly required value= "<%=user.getEmail()%>" />
                </div>
                <div class="form-group">
                    <label class="form-label">
                        FULL NAME:
                    </label>
                    <input type="text" name="full_name" class="form-control" required value= "<%=user.getFullName()%>"/>
                </div>
                <div class="form-group mt-2">
                    <button type="submit" class="btn btn-info">UPDATE PROFILE</button>
                </div>
            </form>
            <form method="post" action="/updatePassword">
                <div class="form-group">
                    <label class="form-label">
                        OLD PASSWORD:
                    </label>
                    <input type="password" name="old_password" class="form-control" required />
                </div>
                <div class="form-group">
                    <label class="form-label">
                        NEW PASSWORD:
                    </label>
                    <input type="password" name="new_password" class="form-control" required>
                </div>
                <div class="form-group">
                    <label class="form-label">
                        CONFIRM PASSWORD:
                    </label>
                    <input type="password" name="confirm_password" class="form-control" required>
                </div>
                <div class="form-group mt-2">
                    <button type="submit" class="btn btn-info">UPDATE PASSWORD</button>
                </div>
            </form>
        </div>
    </div>
</div>
<br/>

</body>
</html>