<!-- THIS IS THE ADMIN STATIC PAGE  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
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


     <br><center> <h2>Student Profile</h2><br></center>      
	<form action="student_search" method="post" class="navbar-form navbar-right" role="search">
			<div class="form-group" >
         		 <input name="student_rollno" class="form-control" placeholder="Search Friend Here" type="text" required />
        	</div>
			<button type="submit" name="submit" class="btn btn-info">
        		  <span class="glyphicon glyphicon-search"></span>
        	</button>
        	
	</form>
     <br><br>
     <center> 
     <div align="right" class="form-horizontal">
     <div class="col-sm-9"></div>
      <div class="col-sm-3">
  				
  								<label class=" control-label"><img alt="" width="150px" src="getImage?sid=<s:property value="obj.student_rollno"/>"></label>
  				
  	  </div>
     
     </div>
	<div align="center" class="form-horizontal">
	 
		  
        <div class="form-group">
          <label class="control-label col-sm-4" for="student">Student Name : </label>
          <div class="col-sm-4">
			<input type="text" class="form-control" value="<s:property value = "obj.student_name"/>" readonly/><br/>
          </div>
         
        </div>

        <div class="form-group">
				<label class="control-label col-sm-4" for="ID">Roll No. : </label>
				<div class="col-sm-4">

			<input type="text"  class="form-control" value="<s:property value = "obj.student_rollno" />" readonly/><br/>
          </div>
        </div>

        <div class="form-group">
          <label class="control-label col-sm-4" for="student">Phone No. : </label>
          <div class="col-sm-4">
			<input type="text" name="student_phoneno" class="form-control" value="<s:property value="obj.student_phoneno"/>" readonly/><br/>
          </div>
        </div>

        <div class="form-group">
          <label class="control-label col-sm-4" for="mailid">Mail ID : </label>
          <div class="col-sm-4">
			<input type="text" name="student_mailid" class="form-control" value="<s:property value="obj.student_mailid"/>" readonly/><br/>
          </div>
        </div>

        <div class="form-group">
          <label class="control-label col-sm-4" for="dob">Date Of Birth : </label>
          <div class="col-sm-4">
			<input type="text" name="student_dob" class="form-control" value="<s:property value="obj.student_dob"/>" readonly/><br/>
          </div>
        </div>

        <div class="form-group">
          <label class="control-label col-sm-4" for="Interest">Interests :</label>
          <div class="col-sm-4">
			<input type="text" name="student_interest" class="form-control" value="<s:property value="obj.student_interest"/>" readonly/>
          </div>
        </div>

        <div class="form-group">
          <label class="control-label col-sm-4" for="Interest">Courses Registered : </label>
          <div class="col-sm-4">
			<input type="text" name="student_course" class="form-control" value="<s:property value="obj.student_course"/>" readonly/><br/>
          </div>
        </div>
        </div>
       
  			<br><br><br>        
  		
            </center>
    </div>

</div>

		<%@include file="/jsp/studentPages/newsAnnouncement.jsp" %>

</body>
</html>