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
  			<h2 align="center">Course Added Successfully.</h2>
  		</s:if>
  		<s:elseif test="%{#msg=='failure'}">
  			<h2 align="center"><label class="control-label">Course Name Already Exists. </label></h2>			
  		</s:elseif>
  		<s:else>
  			
  		</s:else>
		
		<!-- Fields to Add Course  -->
	
		<form class="form-horizental" action="AddCourse" method="post" enctype="multipart/form-data" >
					<br><br>
					



					<div class="form-group">
<!-- 				<table align="center">
<s:merge id="myMergedIterator">
     <s:param value="%{CourseIdList}" />
     <s:param value="%{CourseList}" />
     <s:param value="%{CourseCreditsList}" />
</s:merge>
 				
<s:iterator value="myMergedIterator">
     <s:property />
</s:iterator>

 
 				
						<s:iterator value="myMergedIterator" status="myMergedIteratorStatus">
						  <tr>
						  	<s:if test="#CourseListStatus.even == true">
						      <td style="background: #CCCCCC" align="center" ><s:property /></td>
						      <td align="center"><s:property /></td>
						      <td style="background: #CCCCCC" align="center"><s:property /></td>

						    </s:if>
 						    <s:elseif test="#CourseListStatus.first == true">
						      <td align="center"><s:property/></td>
						      <td style="background: #CCCCCC" align="center"><s:property/></td>
						      <td align="center"><s:property/></td>
						    </s:elseif>
 						    <s:else>
						      <td align="center"><s:property/></td>
						      <td style="background: #CCCCCC" align="center"><s:property/></td>
						      <td align="center"><s:property/></td>
						    </s:else>
						  </tr>
						</s:iterator>
 				</table>
 -->
 <table align="center">
 <tr>
 	<td width="5%">s.no</td>
 	<td width="5%">course id</td>
 	<td width="5%">course name</td>
 	<td width="5%">course credit</td>
 </tr>


<s:merge id="myMergedIterator">
     <s:param value="%{CourseIdList}" />
    
</s:merge>

<s:iterator value="myMergedIterator" status="rowstatus">
 <tr class="<s:if test="#rowstatus.odd == true">odd</s:if><s:else>even</s:else>">
 	<td width="5%"><s:property value="#rowstatus.count"/></td>
 	<td width="5%"><s:property /><s:property value="obj.courseid" /></td>
  </tr>
</s:iterator>
</table>
			</div>
					
					
										
  					<div class="form-group">
  						 <div class="col-lg-2"></div>
  					
      					<label  class="col-lg-4 control-label">Course Name</label> 
     					 <div class="col-lg-4">
     					 		<input type="text" class="form-control" placeholder="Type Course Name here" name="courseName" required>
       					 </div>
     					  <br><br>
   					 </div>
   					
  					<div class="form-group">
   						 <div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Credits</label>
     					 <div class="col-lg-4">
       							 <input type="text" class="form-control"  placeholder="Number of credits" name="courseCredits" required>
     					 </div>
     					<br><br><br> 
   					 </div>

  					<div class="form-group">
   						 <div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Credits</label>
     					 <div class="col-lg-4">
       							 <input type="text" class="form-control"  placeholder="semester" name="semesterName" required>
     					 </div>
     					<br><br><br> 
   					 </div>

   					
   					<div class="form-group">
   						 <div class="col-lg-2"></div>
       						<div class="col-lg-8 col-lg-offset-4"><input type="submit" value="Add Course"  class="btn btn-primary" />&nbsp&nbsp
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