<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	 <%@include file="/jsp/adminPages/headPage.jsp" %>
	 <!-- 
	 <script>
	 function validate(){
		 var studentName = document.getElementsByName('studentName').value;
		 var letters = /^[A-Za-z]+$/;
		 
		 <!--var rollno = document.getElementsByName('studentRollNo').value;
		 var roll = /^[M,m][T,t][2][0][1][4][0-9]{3}$/;
		 
		 var dob = document.getElementsByName('dateOfBirth').value;
		 var date = /^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/;
		 
		 var email = document.getElementsByName('email').value;
		 var mail = /^[a-z/_.\-/0-9]*[@][a-z]*\.[a-z]{2,4}$/;
		 
		 var phno = document.getElementsByName('phoneNumber').value;
		 var reg_exp_phn_no = /^\d{10}$/;
		 
		 var flag = 1;
		 
		 if(studentName =="" || (!studentName.match(letters))){
		    	document.getElementById('studentnameid').innerHTML="Please enter your name";
		    	document.addstudentform.studentName.focus();
				flag = 0;
				return false;			
		 }
		 
		 else if(rollno =="" || (!rollno.match(roll))){
		    	document.getElementById('rollnoid').innerHTML="Please enter your roll number";
		    	document.addstudentform.studentRollNo.focus();
				flag = 0;
				return false;			
		 }
		 else if(dob =="" || (!dob.match(date))){
		    	document.getElementById('dobid').innerHTML="Please enter your DOB";
		    	document.addstudentform.dateOfBirth.focus();
				flag = 0;
				return false;			
		 }
		 else if(email =="" || (!email.match(mail))){
		    	document.getElementById('emailid').innerHTML="Please enter correct email";
		    	document.addstudentform.email.focus();
				flag = 0;
				return false;			
		 }
		 else if(phno =="" || (!phno.match(reg_exp_phn_no))){
		    	document.getElementById('phonenoid').innerHTML="Please enter correct phone number";
		    	document.addstudentform.phoneNumber.focus();
				flag = 0;
				return false;			
		 }
		
		 
		 if(flag==1)
		    {
		    	document.addstudentform.submit();
		    }
	 }
	 </script>
-->
<script type="text/javascript">

function valid()
{
	var name=document.addstudentform.studentName.value;
	var letters = /^[A-Za-z]+$/;
	
	var rollno = document.addstudentform.studentRollNo.value;
	var roll = /^[M,m][T,t][2][0][1][4][0-9]{3}$/;
	 
	 var dob = document.addstudentform.dateOfBirth.value;
	 var date = /^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/;

	 var email = document.addstudentform.email.value;
	 var mail = /^[a-z/_.\-/0-9]*[@][a-z]*\.[a-z]{2,4}$/;

	 var phno = document.addstudentform.phoneNumber.value;
	 var reg_exp_phn_no = /^\d{10}$/;

	 if(name=="" ||  (!name.match(letters)))
		{
		document.getElementById('a').innerHTML="Please enter your name";
		return false;
		}
	 else if(rollno =="" || (!rollno.match(roll))){
		document.getElementById('b').innerHTML="Please enter your roll number";
		return false;
	 }
	 else if(dob =="" || (!dob.match(date))){
		 document.getElementById('c').innerHTML="Please enter correct DOB";
		 return false;
	 }
	 else if(email =="" || (!email.match(mail))){
		 document.getElementById('d').innerHTML="Please enter correct email id";
		 return false;
	 }
	 else if(phno =="" || (!phno.match(reg_exp_phn_no))){
		 document.getElementById('e').innerHTML="Please enter correct phone number";
		 return false;
	 }
	 else
		document.addstudentform.submit();
	}
</script>
<script type="text/javascript">
function addressCheck(){
	 var addr = document.addstudentform.address.value;
	 var required = 30;
	 var left = required - addr.length;
	 if(left>0){
		 document.getElementById('f').innerHTML=left+"characters required";
		 return false;
	 }
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
  			<h2 align="center">Student Added Successfully</h2>
  		</s:if>
  		<s:else>
  			<h2 align="center"><label class="control-label"><s:property value="msg"/> </label></h2>			
  		</s:else>
  		
				<form class="form-horizental" action="AddStudent" method="post" enctype="multipart/form-data"  name="addstudentform" onsubmit="return valid()">
  					<div class="form-group">
  						<div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Student Name</label> 
     					 <div class="col-lg-4">
     					 		<div class="input-group">
     					 			<span class="input-group-addon" id="basic-addon1">
     					 				  <span class="glyphicon glyphicon-user" aria-hidden="true"></span> 
     					 			</span>
       							 <input  type="text" class="form-control" placeholder="Type Student Name here" name="studentName" >
       							 </div>       							
       							  
      					</div>
      	<div class="col-lg-2"><label id="a" class="text-danger"></label></div>
     					  <br><br>
   					 </div>
   					
  					<div class="form-group">
  						<div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Roll Number</label>
     					 <div class="col-lg-4">
       							 <input type="text" class="form-control"  placeholder="Type Roll Number here" name="studentRollNo" >
     					 </div>
      	<div class="col-lg-2"><label id="b" class="text-danger"></label></div>
     					<br><br> 
   					 </div>
   					 
   					 <div class="form-group">
   					 	<div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Date Of Birth</label>
     					 <div class="col-lg-4">
       							<input type="date" class="form-control"  placeholder="dd/mm/yyyy" name="dateOfBirth" >        							 
     					 </div>
      	<div class="col-lg-2"><label id="c" class="text-danger"></label></div>
     					<br><br> 
   					 </div>
   					 
   					 <div class="form-group">
   					 	<div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Email</label>
     					 <div class="col-lg-4">
       							 <input type="text" class="form-control"  placeholder="Type Email Id Here" name="email" >
     					 </div>
       	<div class="col-lg-2"><label id="d" class="text-danger"></label></div>
     					<br><br> 
   					 </div>
   					 
   					 <div class="form-group">
   					 	<div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Phone Number</label>
     					 <div class="col-lg-4">
       							 <input type="text" class="form-control"  placeholder="Type Phone Number here" name="phoneNumber" >
     					 </div>
      	<div class="col-lg-2"><label id="e" class="text-danger"></label></div>     					 
     					<br><br> 
   					 </div>
   					 
   					 <div class="form-group">
   					 	<div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Address</label>
     					 <div class="col-lg-4">
       							 <textarea class="form-control"  placeholder="Type Address here" name="address" ></textarea>
     					 </div>
      	<div class="col-lg-2"><label id="f" class="text-danger"></label></div>     					 
     					<br><br><br><br> 
   					 </div>
   					<div class="form-group">
   					
   						<div class="col-lg-2"></div>
      					<label  class="col-lg-4 control-label">Picture</label>
     					 <div class="col-lg-4">
     					 	
       							 <s:file class="form-control"   name="image"></s:file>
     					 </div>
     					 <br><br> 
   					 </div>
   					 
   					 
   					 <div class="form-group">
   					 		<div class="col-lg-2"></div>
      						<div class="col-lg-8 col-lg-offset-2"><input type="submit" value="Submit"  class="btn btn-primary" />
       						 <input type="reset" class="btn btn-default" name="Reset"/>
     						 </div>
    				</div>
   					 
  				</form>
			<br><br><br><br><br><br><br><br>
			</div>
			</div>
		
		
			<%@include file="/jsp/adminPages/newsAnnouncement.jsp" %>
			
			
</body>
</html>