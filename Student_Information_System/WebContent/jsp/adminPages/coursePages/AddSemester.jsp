<!-- THIS IS THE ADMIN STATIC PAGE  -->

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
	
		<form class="form-horizental" action="AdminAddSemesterCourse" method="post" enctype="multipart/form-data" >
					<br><br>
  					<div class="form-group">
	
			<div class="form-group">
			  <div class="col-lg-2"></div>
			  <div class="col-lg-6">
			  		<div class="form-group">
      					<label  class="col-lg-4 control-label">Semester</label>
     					 <div class="col-lg-8">
     					 		<sx:autocompleter list="semesterList" name="semesterName" showDownArrow="false"></sx:autocompleter>
     					 </div>
     					<br><br>
   					 </div>
			  </div>

			<div class="col-lg-1">
			  	<div class="form-group">
      				<div class="col-lg-10 col-lg-offset-2">
      					<input type="submit" value="View Courses"  class="btn btn-primary" />
					</div>	
			 	</div>
			</div>
			<br><br><br><br><br><br>
		</div>


<!-- 
		<s:set name="msg" value="message"/>
  		<s:if test="%{#msg=='success'}">
 		
					<div class="form-group">
				<table align="center">
						<s:iterator value="CourseList" status="CourseListStatus">
						  <tr>
						  	<s:if test="#CourseListStatus.even == true">
						      <td style="background: #CCCCCC" align="center" ><s:property/></td>
						      <td align="center"><s:property/></td>
						      <td style="background: #CCCCCC" align="center"><s:property/></td>

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
			</div>
  		</s:if>
  		<s:else>
  		</s:else>

		
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

 -->



<!--



 	<form class="form-horizental" action="getSemesterCourses" method="post">
	
			<div class="form-group">
			  <div class="col-lg-2"></div>
			  <div class="col-lg-6">
			  		<div class="form-group">
      					<label  class="col-lg-4 control-label">Semester</label>
     					 <div class="col-lg-8">
     					 		<sx:autocompleter list="semesterList" name="semesterName" showDownArrow="false"></sx:autocompleter>
     					 </div>
     					<br><br>
   					 </div>
			  </div>

			<div class="col-lg-1">
			  	<div class="form-group">
      				<div class="col-lg-10 col-lg-offset-2">
      					<input type="submit" value="View Courses"  class="btn btn-primary" />
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



 -->