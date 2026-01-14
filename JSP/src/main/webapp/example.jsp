<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--4) below one is syntax to import arrayList in jsp file (here import is attribute)--%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example code of jsp</title>
</head>
<body>
<h1> welcome to jsp file in this we write both html and java file</h1>

<%-- 3) here we can write comment --%>
<% 
String name="uppi";
int id=20; 
ArrayList<Integer>arr=new ArrayList<>();
// 1) this is called scriptlet in this we can
%>
<%-- 2) (<%=name%>) this is called expression by using this we can write java variables in html--%>
<h2>hi this <%=name%> and id is <%=id%></h2>
</body>
</html>

<%-- 
1) in jsp we donot need to servlet class like Generic servlet or HTTP servlet by default it jsp file convert into servlet class internaly
2) and we use request , response parameters of Generic servlet or HTTP servlet and we do need to write Service and Getmethod or PostMethod explicitly 
by default it implicitly created 
3) onces check in ChatGpt

//in jps(java server page) i learned 4 things
i)where to write java code in jsp [ scriptlet (<% %> ]
ii) how to use java variable in html by using expression tag (<%= here we can write java varible names optional %>
iii) how to write comment is jps (<%-- here we can write comments --&>)
iv) how to write import in jsp  (<%@ page import="java.util.ArrayList" %>)
 --%>