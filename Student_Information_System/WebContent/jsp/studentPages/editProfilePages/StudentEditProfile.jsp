
<!-- EDIT PROFILE OF STUDENT -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="StudentEdit" method="post" name="studentEditProfileForm" onsubmit="return valid()" >
		<br><br>
		<h3 align="center"><s:property value="message"/></h3>
		<br><br>
		 <h3 align="center">Edit Profile</h3>
		 <br><center><label id="abc" class="text-danger"></label><br></center>
	<div class="form-group">
		<div class="col-lg-2"></div>
      	<label  class="col-lg-2 control-label">Phone No:</label>
      	<div class="col-lg-4">
     		<div class="input-group">
     			<span class="input-group-addon" id="basic-addon1">
     			  <span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>
     			</span>
       			<input type="text" class="form-control" placeholder="Type phone no. here" name="phone">
       		 </div>       							
     </div>
   
     
      	<br><br>
      </div>	 	
    		
    <div class="form-group">
		<div class="col-lg-2"></div>
      	<label  class="col-lg-2 control-label">Password</label>
      	<div class="col-lg-4">
     		<div class="input-group">
     			<span class="input-group-addon" id="basic-addon1">
     			  <span class="glyphicon glyphicon-lock" aria-hidden="true"></span> 
     			</span>
       			<input type="password" class="form-control" placeholder="********" name="password">
       		 </div>       							
       							  
      	</div>
      	<br><br>
      </div>
    <div class="form-group">
		<div class="col-lg-2"></div>
      	<label  class="col-lg-2 control-label">Address:</label>
      	<div class="col-lg-4">
     		<div class="input-group">
     			<span class="input-group-addon" id="basic-addon1">
     			  <span class="glyphicon glyphicon-home" aria-hidden="true"></span> 
     			</span>
       			<textarea class="form-control" rows="2" placeholder ="Type address here" name="address">
       			</textarea>
       		 </div>       							
       							  
      	</div>
      	<br><br>
      	<br>
      </div>	 
      
      <div class="form-group">
		<div class="col-lg-2"></div>
     	<label  class="col-lg-2 control-label">Interest:</label>
      	<div class="col-lg-4">
      	   <select id="a" name="a" multiple="multiple">
		      <s:iterator value="interests">
 	    		 <option value="<s:property/>"><s:property/></option>
				</s:iterator>
			</select>
		</div>
	<br><br><br>
	<div class="form-group">
		<div class="col-lg-2"></div>
      	<div class="col-lg-8 col-lg-offset-2"><input type="submit" value="Submit"  class="btn btn-primary" />
       	<input type="reset" class="btn btn-primary" name="Reset"/>
     	 </div>
     </div>
	
	</div>
	</form>

	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	</div>
</div>
<%@include file="/jsp/studentPages/newsAnnouncement.jsp" %>
   
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
<link href="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
    rel="stylesheet" type="text/css" />
<script src="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/js/bootstrap-multiselect.js"
    type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        $('#a').multiselect({
            includeSelectAllOption: true
        });
    });
</script>
<script>
function valid()
{
	var phno = document.studentEditProfileForm.phone.value;
	var reg_exp_phn_no = /^\d{10}$/;

	if(phno =="" || (!phno.match(reg_exp_phn_no))){
		 document.getElementById('abc').innerHTML="Please enter correct phone number";
		 return false;
	 }
	else
		document.addstudentform.submit();
	}
</script>


</body>
</html>