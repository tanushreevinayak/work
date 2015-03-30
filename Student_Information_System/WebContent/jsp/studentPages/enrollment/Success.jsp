<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@include file="/jsp/studentPages/headPage.jsp" %>

</head>
<body style="background-color:#848484">
	<%@include file="/jsp/studentPages/topNavBar.jsp" %>
	<%@include file="/jsp/studentPages/sideNavBar.jsp"%>


 <div class="col-lg-7">
<div class="mainframe">
		<br><br>
		<h2 align="center"><s:property value="result"/></h2>	
		<br><br><br>
		<br><br><br><br><br><br><br><br><br><br><br><br>
		<br><br><br><br><br><br><br><br>
 </div>
 </div>
 		<%@include file="/jsp/studentPages/newsAnnouncement.jsp" %>
 
</body>
</html>