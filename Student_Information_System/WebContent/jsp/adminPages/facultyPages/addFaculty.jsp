<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	 <%@include file="/jsp/adminPages/headPage.jsp" %>
<script>
function valid()
{
	var facname=document.addfacultyform.facultyName.value;
	var facletters = /^[A-Za-z]+$/;

	var username=document.addfacultyform.facultyUserName.value;
	var userletters = /^[A-Za-z]+$/;
	
	var email = document.addfacultyform.email.value;
	var mail = /^[a-z/_.\-/0-9]*[@][a-z]*\.[a-z]{2,4}$/;

	var phno = document.addfacultyform.phoneNumber.value;
	var reg_exp_phn_no = /^\d{10}$/;

	if(facname=="" ||  (!facname.match(facletters)))
	{
		document.getElementById('a').innerHTML="Please enter your name";
		return false;
	}
	else if(username=="" ||  (!username.match(userletters)))
	{
		document.getElementById('b').innerHTML="Please enter your username";
		return false;
	}
	else if(email =="" || (!email.match(mail))){
		 document.getElementById('c').innerHTML="Please enter correct email id";
		 return false;
	 }
	else if(phno =="" || (!phno.match(reg_exp_phn_no))){
		 document.getElementById('d').innerHTML="Please enter correct phone number";
		 return false;
	 }
	else
		document.addstudentform.submit();
	}
</script>



</head>
<body style="background-color:#848484">
	 <%@include file="/jsp/adminPages/topNavBar.jsp" %>
	 <%@include file="/jsp/adminPages/sideNavBar.jsp" %>
	<div class="col-lg-7">
	<div class="mainframe">
	<br><br>
			<s:set name="msg" value="message"/>
  		<s:if test="%{#msg=='success'}">
  			<h2 align="center">Faculty Added Successfully</h2>
  		</s:if>
  		<s:else>
  			<h2 align="center"><label class="control-label"><s:property value="msg"/> </label></h2>			
  		</s:else>
	<form name="addfacultyform" class="form-horizental" action="AddFaculty" method="post" enctype="multipart/form-data" onsubmit="return valid()">
  					<div class="form-group">
  						<div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Faculty Name</label> 
     					 <div class="col-lg-4">
     					 		<div class="input-group">
     					 			<span class="input-group-addon" id="basic-addon1">
     					 				  <span class="glyphicon glyphicon-user" aria-hidden="true"></span> 
     					 			</span>
       							 <input type="text" class="form-control" placeholder="Type Faculty Name here" name="facultyName">
       							 </div>       							  
      					</div>
      	<div class="col-lg-2"><label id="a" class="text-danger"></label></div>
   					  <br><br>
   					 </div>
   					 
					<div class="form-group">
						<div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Faculty UserName</label> 
     					 <div class="col-lg-4">
     					 		<div class="input-group">
     					 			<span class="input-group-addon" id="basic-addon1">
     					 				  <span class="glyphicon glyphicon-user" aria-hidden="true"></span> 
     					 			</span>
       							 <input type="text" class="form-control" placeholder="Type Faculty UserName here" name="facultyUserName">
       							 </div>       							  
      					</div>
      	<div class="col-lg-2"><label id="b" class="text-danger"></label></div>
     					  <br><br>
   					 </div>
   					 
   					
   					 <div class="form-group">
   					 	<div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Email</label>
     					 <div class="col-lg-4">
       							 <input type="text" class="form-control"  placeholder="Type Faculty Email Id Here" name="email">
     					 </div>
      	<div class="col-lg-2"><label id="c" class="text-danger"></label></div>
     					<br><br> 
   					 </div>
   					 
   					 <div class="form-group">
   					 	<div class="col-lg-2"></div>	
      					<label  class="col-lg-4 control-label">Phone Number</label>
     					 <div class="col-lg-4">
       							 <input type="text" class="form-control"  placeholder="Type Phone Number here" name="phoneNumber">
     					 </div>
      	<div class="col-lg-2"><label id="d" class="text-danger"></label></div>
     					<br><br> 
   					 </div> 
   					 <div class="form-group">
   					 	<div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Qualifications</label>
     					 <div class="col-lg-4">
       							 <textarea class="form-control"  placeholder="Type Qualifications of the faculty here" name="qualifications" ></textarea>
     					 </div>
     					<br><br><br><br> 
   					 </div>
   					 
   					 <div class="form-group">
   					 		<div class="col-lg-2"></div>
      						<div class="col-lg-8 col-lg-offset-3"><input type="submit" value="Add Faculty"  class="btn btn-primary" />
       						 &nbsp&nbsp
       						 <input type="reset" class="btn btn-default" name="Reset"/>
     						 </div>
    				</div>
   					 
  				</form>
  				
			<br><br><br><br><br><br><br><br><br><br>
			</div>
		
			</div>
			<%@include file="/jsp/adminPages/newsAnnouncement.jsp" %>
			
</body>
</html>