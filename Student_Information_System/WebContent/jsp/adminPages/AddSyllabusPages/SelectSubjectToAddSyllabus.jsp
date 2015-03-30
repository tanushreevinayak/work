<!-- THIS IS THE ADMIN STATIC PAGE  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<!-- SECOND PART OF THE PAGE -->
<div class="col-lg-7">

<div class="mainframe">
	  		<br><br>
	  		
  		<h3 align="center">Add Syllabus </h3>
		<br><br>
		<form  action="AddSyllabusForSelectedSubject" method="post">
			
			 <div class="form-group">
				<div class="col-lg-2"></div>
     			<label  class="col-lg-2 control-label">Course Name :</label>
     			<sx:autocompleter  list="courselist" name="courseSelected" showDownArrow="false"></sx:autocompleter>
     			<br><br>
       	    </div>  		
       	    <div class="form-group">
				<div class="col-lg-2"></div>
       	     	<div class="col-lg-2 control-label"><label for="comment" >Syllabus :</label></div>
       	     	<div class="col-lg-8">       	     	
       	     		<textarea class="form-control" rows="5"  name="syllabus"></textarea>
       	     	</div>	
       	     	       	    <br><br>
       	     	
    		</div>
    		   <br><br><br><br><br><br>
    		 <div class="form-group">
       	     		<div class="col-lg-2"></div>
					<div class="col-lg-8 col-lg-offset-2">       	     	
       	      		<input type="submit" value="Add Syllabus"  class="btn btn-primary" />
       	      		</div>
      		</div>
		
		</form>
		<br><br><br><br><br><br><br><br><br><br><br><br>
	</div>
  		

</div>
   	<%@include file="/jsp/adminPages/newsAnnouncement.jsp" %>

</body>
</html>