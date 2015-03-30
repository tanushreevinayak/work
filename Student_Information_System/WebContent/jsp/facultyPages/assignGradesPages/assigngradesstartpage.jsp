<!-- THIS IS THE ADMIN STATIC PAGE  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="/jsp/facultyPages/headPage.jsp" %>
</head>
<body style="background-color:#848484">
	<%@include file="/jsp/facultyPages/topNavBar.jsp" %>
	<%@include file="/jsp/facultyPages/sideNavBar.jsp"%>

<!-- SECOND PART OF THE PAGE -->
	<div class="col-lg-7">

	<div class="mainframe">
		<br><br>
		<h3 align="center">Assign Grades</h3>
		<br><br>
		<form class="form-horizental" action="AssignGradesStudentDetails" method="post">
			<div class="form-group">
						<div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Course Name</label>
     					 <div class="col-lg-4">
     					 		<sx:autocompleter list="courselist" name="searchKey" showDownArrow="false"></sx:autocompleter>
     					 </div>
     					<br><br> 
			  </div>
			  	<div class="form-group">
			  		<div class="col-lg-2"></div>
      				<div class="col-lg-8 col-lg-offset-2"><input type="submit" value="Get Students List "  class="btn btn-primary" />
      			</div>	
			  </div>
		</form>
				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	</div>
		
	</div>


		<%@include file="/jsp/facultyPages/newsAnnouncement.jsp" %>

</body>
</html>