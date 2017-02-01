<%-- 
    Document   : PageGenerator2
    Created on : Jan 29, 2017, 11:57:43 PM
    Author     : Joshua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Table!</h1>
        
        <table>
          <%  for(int i=0; i<3;i++){%>
                <tr>
               <% for(int col=0;col<3;col++){%>
               <td>row <%out.println(i);%> col<%out.println(col); %></td>
                <%}
            }%>
            </table>
    </body>
</html>
