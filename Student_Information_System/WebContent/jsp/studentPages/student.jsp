<!-- THIS IS THE ADMIN STATIC PAGE  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="/jsp/studentPages/headPage.jsp" %>

</head>
<body style="background-color:#848484">

	<%@include file="/jsp/studentPages/topNavBar.jsp" %>
	<%@include file="/jsp/studentPages/sideNavBar.jsp"%>

<!-- SECOND PART OF THE PAGE -->
<div class="col-lg-7">

<div class="mainframe">
<br><h5 align="center">Welcome <s:property value="loggedInUser"/></h5><br>

<form action="student_search" method="post" class="navbar-form navbar-right" role="search">
        <div class="form-group" >
          <input name="student_rollno" class="form-control" placeholder="Search Friend Here" type="text" required />
        </div>
		<button type="submit" name="submit" class="btn btn-info">
          <span class="glyphicon glyphicon-search"></span>
        </button>
</form>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>

</div>
		<%@include file="/jsp/studentPages/newsAnnouncement.jsp" %>

</body>
</html>