<%@ page contentType="text/html; charset=gb2312"%>
<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="DBconn" scope="page" class="Show.DBconn"/>
<html>
  <head>
����<title>Show MySQL!</title>
��</head>
��<body>
�� 
������ٴ�<a href="Show.jsp">���ȫ��</a>&nbsp;&nbsp;<a href="Add.jsp">���</a>&nbsp;&nbsp;<a href="del.jsp">ɾ��</a>&nbsp;&nbsp;<a href="Find.jsp">����</a>    
����<%
      ResultSet RS = DBconn.executeQuery
      ("SELECT * FROM data");
      while (RS.next()) {
        out.print("<h1>" + RS.getString("id") + "&nbsp;" + RS.getString("logname") + "&nbsp;" + RS.getString("em") + "</h1>");
      }
      RS.close();
     %>
��</body >
</html >
