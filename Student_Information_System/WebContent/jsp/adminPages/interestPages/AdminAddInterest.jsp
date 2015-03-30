<!-- THIS IS THE ADMIN STATIC PAGE  -->
<!-- THIS IS THE ADMIN STATIC PAGE  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
    
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

<h2 align="center"> Add Interest</h2>

<form class="form-horizontal" action="add_interest" method="post">
	<center>
		<s:set name="msg" value="message"/>
  		<s:if test="%{#msg=='success'}">
  			<h3 align="center">Interest Added Successfully</h3><br><br>
  		</s:if>
  		<s:else>
  		<h3 align="center"><label class="control-label"><s:property value="message"/>  </label></h3>	<br><br>		
  		</s:else>
  		</center>
  <fieldset>
    <div class="form-group">
    	<div class="col-lg-2"></div>
      <label for="interest_name" class="col-lg-3 control-label">Interest</label>
      <div class="col-lg-4">
        <input name="interest_name" class="form-control" id="interest_name" placeholder="Enter Interest Name here..." type="text" />
      </div>
      <br><br>
    </div>

	<div class="form-group">
	   	<div class="col-lg-2"></div>
	    <div class="col-lg-8 col-lg-offset-2">
	    <button type="submit" id="submit" class="btn btn-primary">Add Interest</button>&nbsp&nbsp&nbsp
	    <button type="reset" class="btn btn-default">Reset</button>
      </div>
    </div>
  </fieldset>
</form>



<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>

</div>



   	<%@include file="/jsp/adminPages/newsAnnouncement.jsp" %>

</body>
</html>