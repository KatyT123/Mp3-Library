<%-- 
    Document   : newjsp
    Created on : Oct 26, 2018, 11:23:44 AM
    Author     : KATY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
       <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous">
        </script>
    </head>
    <body>
       
        <jsp:include page="index.html" flush="true">
            <jsp:param name="myfile" value="myfile"/>
        </jsp:include>
         <script type="text/javascript">
            alert("File Uploaded !");
        </script>
         <div class="alert alert-success">
         <strong>Success!</strong> 
         </div>
    </body>
</html>
