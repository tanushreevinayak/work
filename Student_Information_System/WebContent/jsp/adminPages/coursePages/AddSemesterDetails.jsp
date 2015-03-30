<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		<br><br>
			<s:set name="msg" value="message"/>
  		<s:if test="%{#msg=='success'}">
  			<h2 align="center">Semester Added Successfully.</h2>
  		</s:if>
  		<s:elseif test="%{#msg=='failure'}">
  			<h2 align="center"><label class="control-label">Course Name Already Exists. </label></h2>			
  		</s:elseif>
  		<s:else>
  			
  		</s:else>
		
		<!-- Fields to Add Course  -->
	
		<form class="form-horizental" action="AddSemesterDetails" method="post" enctype="multipart/form-data" >
					<br><br>
					
					<div class="form-group">
										
  					<div class="form-group">
  						 <div class="col-lg-2"></div>
  					
      					<label  class="col-lg-4 control-label">Semester Name</label> 
     					 <div class="col-lg-4">
     					 		<input type="text" class="form-control" placeholder="Type semester Name here" name="semesterName" required>
       					 </div>
     					  <br><br>
   					 </div>
   					
  					<div class="form-group">
   						 <div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Semester Id</label>
     					 <div class="col-lg-4">
       							 <input type="text" class="form-control"  placeholder="Semester Id here" name="semesterId" required>
     					 </div>
     					<br><br><br> 
   					 </div>

  					<div class="form-group">
   						 <div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Course Id</label>
     					 <div class="col-lg-4">
       							 <input type="text" class="form-control"  placeholder="Course Id here" name="courseId" required>
     					 </div>
     					<br><br><br> 
   					 </div>

   					
   					<div class="form-group">
   						 <div class="col-lg-2"></div>
       						<div class="col-lg-8 col-lg-offset-4">
       						<input type="submit" value="Add Semester"  class="btn btn-primary" />&nbsp&nbsp
       						 <input type="reset" class="btn btn-default" name="Reset"/>
     						 </div>
    				</div>
   					 
  				</form>
  							<br><br><br><br>
  							<br><br><br><br>
  							<br><br><br><br>
  							<br><br><br><br>
  							<br><br><br><br>
  							<br><br><br><br>
  							
	</div>
	</div>
	<%@include file="/jsp/adminPages/newsAnnouncement.jsp" %>
	
</body>
</html>