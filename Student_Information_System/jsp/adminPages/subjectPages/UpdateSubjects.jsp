<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="<%=request.getContextPath()%>/sis-bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
 <link href="<%=request.getContextPath()%>/sis-bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
   <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/sis-bootstrap/css/stylish-portfolio.css" rel="stylesheet" type="text/css"/>
     <!-- Custom Fonts -->
    <link href="<%=request.getContextPath()%>/sis-bootstrap/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
      <script src="<%=request.getContextPath()%>/sis-bootstrap/js/bootstrap.js"></script>
        <script src="<%=request.getContextPath()%>/sis-bootstrap/js/bootstrap.min.js"></script>
 <link rel="icon" type="image/ico" href="icon.ico"/>

<title>UPDATE SUBJECTS HERE</title>
</head>
<body>
<br><br>
<div class="col-lg-2">
</div>
<div class="col-lg-7">
<form method="post" action="UpdateSubjects" class="form-horizental">
	
	<div class="form-group">
	<center>
	<label for="Course id">Course id</label>
<input type="text" name="course_id"  value="<s:property value="course_id"/>" class="form-control" id="course_id"/>
	
<label for="Course Name">Course Name</label>
<!-- <s:textfield name="course_name"></s:textfield> -->
<s:property value="course_name"/>
<input type="text" name="course_name" class="form-control" value="<s:property value="course_name"/>" id="course_name"/>

<label for="Course Syllabus">Course Syllabus</label>
<input type="text" name="course_syllabus" value="<s:property value="course_syllabus"/>" class="form-control" id="course_syllabus"/>

   <input type="hidden" name="flag" id="flag" value="subjects"/>

<label for="Course Credits">Course Credits</label>
<input type="text" name="course_credits" value="<s:property value="course_credits"/>" class="form-control" id="course_credits

"/>

      <input type="submit" value="Update"  class="btn btn-primary" /> 
       </center>
     	 </div>
     	 
    
    
	 	
</form>
</div>
<div class="col-lg-3"></div>



</body>
</html>