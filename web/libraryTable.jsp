

<%@page import="models.Mp3File"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous">
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
         body  {
            	background-image: url(back1.jpg);
                background-size: 70%;
            }
            </style>
    </head>
    <body>
        <h1>MP3 Library</h1>
        <% ArrayList<Mp3File> mylist = (ArrayList)request.getAttribute("mylist");%>
        <table class="table">
               <thead>
                  <tr>
                  <th>Title</th>
                  <th>Artist</th>
                  <th>Album</th>
                  <th>Year</th>
                  <th>Lyrics</th>
                  <th>Delete</th>
                  </tr>
               </thead>
               <div class="container">
        <% for (Mp3File mp3: mylist){%>
                <tbody>
                 <tr>
                   <td><%= mp3.getTitle()%></td>
                  <td><%= mp3.getArtist()%></td>
                   <td><%= mp3.getAlbum()%></td>
                   <td><%= mp3.getYear()%></td>
                   <td><%= mp3.getLyrics()%></td>
      <td><a href="DeleteServlet?title=<%= mp3.getTitle() %>&artist=<%= mp3.getArtist() %>">click to delete</a></td>
                </tr>
              <%}%>
                </tbody>
                
  </table>
</div>
        
    </body>
</html>
