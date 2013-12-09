<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
String path = request.getContextPath(); 
//获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）: 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String defstylelist="neptune,sandbox,standard,standard-scoped";
String defstylelist2="access,gray,scoped";
String style="access";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<c:set var="defstylelist2">access,gray,scoped</c:set>
	<c:out value="${defstylelist2}"></c:out>
	<c:out value="${fn:contains(defstylelist2, 'access')}"></c:out>
	<c:if test="${fn:indexOf(defstylelist, style)>-1}">
		<c:out value="${fn:indexOf(defstylelist, 'neptune')}"></c:out>
	</c:if>
<title>Insert title here</title>
</head>
<body>
	<div id="show"></div>
	<div id="dintegral"></div>
</body>
</html>