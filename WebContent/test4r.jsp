<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@page import="webCl.Main"%>
<%@page import="webCl.MailSend"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript"> 
var methodStr = "<%=webCl.Main.test()%>"; 
alert(methodStr);  
</script>  
</body>
</html>