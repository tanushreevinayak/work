<!-- THIS IS THE ADMIN STATIC PAGE  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
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

    <div class="container">

      <h2>Faculty Profile</h2>      

      <form action="faculty_search" method="post" class="form-horizontal" role="form">
	   <div class="form-group">
          <label class="control-label col-sm-2" for="Faculty Name">Faculty Name : </label>
          <div class="col-sm-3">
			<input type="text" name="faculty_name" class="form-control" value="<s:property value = "obj.faculty_name"/>" readonly/><br/>
          </div>
        </div>

        <div class="form-group">
				<label class="control-label col-sm-2" for="Faculty ID">Faculty ID : </label>
				<div class="col-sm-3">
			<input type="text" name="faculty_id" class="form-control" value="<s:property value = "obj.faculty_id" />" readonly/><br/>
          </div>
        </div>

        <div class="form-group">
          <label class="control-label col-sm-2" for="student">Phone No. : </label>
          <div class="col-sm-3">
			<input type="text" name="faculty_phoneno" class="form-control" value="<s:property value="obj.faculty_phoneno"/>" readonly/><br/>
          </div>
        </div>

        <div class="form-group">
          <label class="control-label col-sm-2" for="Mail ID">Mail ID : </label>
          <div class="col-sm-3">
			<input type="text" name="faculty_mailid" class="form-control" value="<s:property value="obj.faculty_mailid"/>" readonly/><br/>
          </div>
        </div>



        <div class="form-group">
          <label class="control-label col-sm-2" for="Course">Course : </label>
          <div class="col-sm-3">
			<input type="text" name="faculty_course" class="form-control" value="<s:property value="obj.faculty_course"/>" readonly/><br/>
          </div>
        </div>

      </form>
    </div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	</div>

	</div>
		<%@include file="/jsp/facultyPages/newsAnnouncement.jsp" %>
   
</body>
</html>