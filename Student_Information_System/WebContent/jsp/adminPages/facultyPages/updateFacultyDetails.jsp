<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="/jsp/adminPages/headPage.jsp" %>
	<script type="text/javascript"> 
	goBack() { 
		window.history.back();
		} 
	</script>
	
</head>
<body style="background-color:#848484">
<body style="background-color:#848484">
	
	 <%@include file="/jsp/adminPages/topNavBar.jsp" %>
	 <%@include file="/jsp/adminPages/sideNavBar.jsp" %>
	 
	<div class="col-lg-7">
		<div class="mainframe">
		 		
		<form class="form-horizental" action="updateFacultyDetails" method="post"  >
					<br><br>
  					<div class="form-group">
  						<div class="col-lg-2"></div>
      					<label  class="col-lg-3 control-label">Faculty User Name</label> 
     					 <div class="col-lg-4">
     					 		<div class="input-group">
     					 			<span class="input-group-addon" id="basic-addon1">
     					 				  <span class="glyphicon glyphicon-user" aria-hidden="true"></span> 
     					 			</span>
       							 <input type="text" class="form-control" value="<s:property value="facultyModelObj.facultyUserName"/>" name="facultyUserName" readOnly>
       							 </div>       							
       							  
      					</div>
     					  <br><br>
   					 </div>
  					<div class="form-group">
  					  	<div class="col-lg-2"></div>
  						<label  class="col-lg-3 control-label">Faculty Name</label> 
     					 <div class="col-lg-4">
     					 		<div class="input-group">
     					 			<span class="input-group-addon" id="basic-addon1">
     					 				  <span class="glyphicon glyphicon-user" aria-hidden="true"></span> 
     					 			</span>
       							 <input type="text" class="form-control" value="<s:property value="facultyModelObj.facultyName"/>" name="facultyName" readOnly>
       							 </div>       							
       							  
      					</div>
     					  <br><br>
   					 </div>
   					
   					 <div class="form-group">
   					 	<div class="col-lg-2"></div>
      					<label  class="col-lg-3 control-label">Email</label>
     					 <div class="col-lg-4">
       							 <input type="text" class="form-control"  value="<s:property value="facultyModelObj.email"/>" name="email"  >
     					 </div>
     					<br><br> 
   					 </div>
   					 <div class="form-group">
   					 	<div class="col-lg-2"></div>
      					<label  class="col-lg-3 control-label">Phone Number</label>
     					 <div class="col-lg-4">
       							 <input type="text" class="form-control"  value="<s:property value="facultyModelObj.phoneNumber"/>" name="phoneNumber" >
     					 </div>
     					<br><br> 
   					 </div>
   					 <div class="form-group">
   					 	<div class="col-lg-2"></div>
      					<label  class="col-lg-3 control-label">Qualifications</label>
     					 <div class="col-lg-4">
       							 <textarea class="form-control"  name="qualifications" ><s:property value="facultyModelObj.qualifications"/></textarea>
     					 </div>
     					<br><br><br><br> 
   					 </div>
   					 <div class="form-group">
   					 	<div class="col-lg-2"></div>
      					<label  class="col-lg-3 control-label">Status</label>
     					 <div class="col-lg-4">
     					 	<s:set name="selected" value="facultyModelObj.status"/>
     					 	<select class="form-control" name="status">
       							 	<s:if test="%{#selected=='Active'}">
  									  	<option value="Active" selected>Active</option>
  									  	<option value="Inactive">InActive</option>		
  									</s:if>
  									<s:else>
  										<option value="Active" >Active</option>
  									  	<option value="Inactive" selected>InActive</option>					
  									</s:else>
       						</select>
       							
     					 </div>
     					<br><br> 
   					 </div> 					 
   					 <div class="form-group">
   					 		<div class="col-lg-2"></div>
      						<div class="col-lg-8 col-lg-offset-2">
      						<input type="submit" value="Update"  class="btn btn-primary" />
      						<button onclick="goBack()" class="btn btn-primary">Back</button>
     						 </div>
    				</div>
   					 
  				</form>
  				<br><br><br><br><br><br><br><br>
			<br><br><br><br>
			</div>
		
		
	</div>
	<%@include file="/jsp/adminPages/newsAnnouncement.jsp" %>



</body>
</html>