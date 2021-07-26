<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@include file="templates/bootstrap.jsp"%>
    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>

    <script>
        tinymce.init({
            selector: '#mytextarea'
        });
    </script>
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
            <form method="post" action="/addPost">
                <div class="form-group">
                    <label class="form-label">
                        TITLE:
                    </label>
                    <input type="text" name="title" class="form-control" required />
                </div>
                <div class="form-group">
                    <label class="form-label">
                        CONTENT:
                    </label>
                    <textarea name="content" class="form-control" id="textarea" rows="10" required> </textarea>
                </div>
                <div class="form-group mt-2">
                    <button class="btn btn-info">ADD POST</button>
                </div>
            </form>
        </div>
    </div>
</div>
<br/>

</body>
</html>