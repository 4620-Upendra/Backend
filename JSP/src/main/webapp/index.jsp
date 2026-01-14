<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.Scanner" %>

<%-- This is a JSP comment (not visible in browser) --%>
<!-- This is an HTML comment (visible in page source) -->

<!DOCTYPE html>
<html>
<head>
    <title>JSP Example</title>
</head>
<body>

<%
    // Scriptlet:Here we write only Java code
    String name = "Upendra";
    int age = 22;
    Date today = new Date();
    
 // Importing and using Scanner class
    Scanner sc = new Scanner(System.in);
    System.out.println("enter a message");
    String message=sc.nextLine();
    System.out.println(message);
%>

<h2>Welcome to JSP</h2>

<p>Name: <%= name %></p>
<p>Age: <%= age %></p>
<p>Date: <%= today %></p>

</body>
</html>
