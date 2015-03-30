<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/jsp/adminPages/headPage.jsp" %>
</head>
<body style="background-color:#848484">
	<%@include file="/jsp/adminPages/topNavBar.jsp" %>
	 <%@include file="/jsp/adminPages/sideNavBar.jsp" %>
	 
	<div class="col-lg-7">
	<div class="mainframe">
		<form class="form-horizental" action="getStudentDetails" method="post">
			<br><br>
				<h3 align="center"><s:property value="message"/></h3>
			<br><br>
			<center>
			<div class="form-group">
			  
			  		<div class="form-group">
   					 	<div class="col-lg-3"></div>
			  			
      					<label  class="col-lg-3 control-label">Roll Number</label>
     					 <div class="col-lg-4">
     					 		<sx:autocompleter list="listOfRollNumbers" name="searchKey" showDownArrow="false"></sx:autocompleter>
     					 </div>
     					<br><br> 
   					 </div>
			  	<div class="form-group">
   					 	<div class="col-lg-2"></div>
			  	
      				<div class="col-lg-9 col-lg-offset-0"><input type="submit" value="Get Details"  class="btn btn-primary" />
      			</div>	
			  </div>
			</div>
			</center>
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br> 
			<br><br><br><br><br><br>
		</form>
	</div>	
	</div>
	<%@include file="/jsp/adminPages/newsAnnouncement.jsp" %>


</body>
</html>