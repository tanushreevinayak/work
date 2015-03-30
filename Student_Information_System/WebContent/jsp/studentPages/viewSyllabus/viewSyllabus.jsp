<!-- THIS IS THE ADMIN STATIC PAGE  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
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
	<br><br>
	<form class="form-horizental" action="getSyllabus" method="post">
	
			<div class="form-group">
			  <div class="col-lg-2"></div>
			  <div class="col-lg-6">
			  		<div class="form-group">
      					<label  class="col-lg-4 control-label">Course Name</label>
     					 <div class="col-lg-8">
     					 		<sx:autocompleter list="courseList" name="courseName" showDownArrow="false"></sx:autocompleter>
     					 </div>
     					<br><br> 
   					 </div>
			  </div>

			  <div class="col-lg-1">
			  	<div class="form-group">
      				<div class="col-lg-10 col-lg-offset-2"><input type="submit" value="View Syllabus"  class="btn btn-primary" />
      			</div>	
			  </div>
			</div>
			<br><br><br><br><br><br>
		</div>

		<s:set name="msg" value="message"/>
  		<s:if test="%{#msg=='success'}">
  			
  					<div class="form-group">
  						<div class="col-lg-2"></div>
      					<label  class="col-lg-3 control-label">Course ID</label> 
     					 <div class="col-lg-4">
      					 		 <label  class="col-lg-3 control-label"><s:property value="courseId"/></label> 
      					</div>
     					  <br><br>
   					 </div>
  					<div class="form-group">
  						<div class="col-lg-2"></div>
      					<label  class="col-lg-3 control-label">Course Name</label> 
     					 <div class="col-lg-7">
     					 		  <label  class="col-lg-7 control-label"><s:property value="courseName"/></label> 
      					</div>
     					  <br><br>
   					 </div>
   					 <div class="form-group">
   						<div class="col-lg-2"></div>
      					<label  class="col-lg-3 control-label">Credits</label> 
     					 <div class="col-lg-4">
      					 		 <label  class="col-lg-3 control-label"><s:property value="courseCredits"/></label> 
     					 		
      					</div>
     					  <br><br>
   					 </div>
  					<div class="form-group">
  						<div class="col-lg-2"></div>
      					<label  class="col-lg-3 control-label">Syllabus</label> 
     					 <div class="col-lg-7">
      					 		 <label  class="col-lg-6 control-label"><s:property value="courseSyllabus"/></label> 
     					 		
      					</div>
     					  <br><br>
   					 </div>
   					
  		</s:if>
  		<s:else>
  		</s:else>
		</form>
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	</div>
	<br><br><br><br>
	
	
</div>
		<%@include file="/jsp/studentPages/newsAnnouncement.jsp" %>
</body>
</html>