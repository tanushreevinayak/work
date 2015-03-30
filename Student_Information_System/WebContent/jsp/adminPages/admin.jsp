<!-- THIS IS THE ADMIN STATIC PAGE  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

        <title> Welcome to Student Information System</title>
         <%@include file="/jsp/adminPages/headPage.jsp" %>
        
</head>
<body style="background-color:#848484">
	 <%@include file="/jsp/adminPages/topNavBar.jsp" %>
	 <%@include file="/jsp/adminPages/sideNavBar.jsp" %>

	<!-- SECOND PART OF THE PAGE -->
	<div class="col-lg-7">

		<div class="mainframe">
<center> Welcome Admin</center>
				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		</div>

	</div>

   	<%@include file="/jsp/adminPages/newsAnnouncement.jsp" %>
 
</body>
</html>