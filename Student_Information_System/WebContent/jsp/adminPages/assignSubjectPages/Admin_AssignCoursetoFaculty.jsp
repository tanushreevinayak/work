<!-- THIS IS THE ADMIN STATIC PAGE  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.iiitb.sis.actions.admin.faculty.Faculty_AssignSubjectAction"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
       
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
          <%@include file="/jsp/adminPages/headPage.jsp" %>
 
 
        
    
  
   <link href="<%=request.getContextPath()%>/sis-bootstrap/font-awesome/css/bootstrap-multiselect.css"
        rel="stylesheet" type="text/css" />
    <script src="<%=request.getContextPath()%>/sis-bootstrap/js/bootstrap-multiselect.js"
        type="text/javascript"></script>
    
    
    
    <link rel="icon" type="image/ico" href="icon.ico"/>
        
</head>
<body style="background-color:#848484">
	 <%@include file="/jsp/adminPages/topNavBar.jsp" %>
	 <%@include file="/jsp/adminPages/sideNavBar.jsp" %>


<!-- SECOND PART OF THE PAGE -->
<div class="col-lg-7">

<div class="mainframe">


 <script type="text/javascript">
        $(function () {
            $('#course_name').multiselect({
                includeSelectAllOption: true,
                enableFiltering: true
            });
            
    
            $('#btnSelected').click(function () {
                var selected = $("#course_name option:selected");
                var message = "Selected Courses : ";
                selected.each(function () {
                    message += $(this).text()+"\n";
                });
       			alert(message);
                $("#courseSelect").submit();
            });
        });
    </script>



<form name="courseSelect" id="courseSelect" action="selectcourseaction" method="post">
			<br><br><br><br>
			
			<h3 align="center"><s:property value="message"/></h3>
			<br><br>

		<div class="form-group">
		 <div class="col-lg-2"></div>
    	  <label class="col-lg-3" for="facultylist">Select Faculty :</label>
    		<select class="col-lg-3" id="facultylist" name="facultyname" >  
    			<s:iterator value="facultylist" >  
 					<option value= "<s:property />">
    				    <s:property /></option>
 				 </s:iterator> 
 		   </select>
			<br><br>
		</div>
	  <div class="form-group">
		 <div class="col-lg-2"></div>
		  <s:iterator  value="courselist" ></s:iterator>      
			<label class="col-lg-3" for="course_name">Select Courses :</label>  
			 <select class="col-lg-4" id="course_name" name="course_names"  multiple="multiple">  
			  <s:iterator value="courselist" >  
				<option value= "<s:property />"> <s:property /></option>
			  </s:iterator> 
     		  </select>
     		  <br><br>
		</div>  
	
	<div class="form-group">
   		<div class="col-lg-2"></div>
       	<div class="col-lg-8 col-lg-offset-4"><input type="button" id="btnSelected" value="Assign Selected Courses" class="btn btn-primary" />&nbsp&nbsp
       	 <input type="reset" class="btn btn-default" name="Reset"/>
     	 </div>
    </div>
	
	 
		

</form>
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>
</div>
   	<%@include file="/jsp/adminPages/newsAnnouncement.jsp" %>

</body>
</html>