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
<div class="col-lg-8">

<div class="mainframe">
<div class="container">


 <%@ taglib prefix="s" uri="/struts-tags"%>

<br>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

 
  <div class="col-lg-2">
<h3>roll No</h3>
<s:iterator  value="rollnos">
<ul>
  <li><s:property value="student_rollno"/><s:property/></li>

</ul>
</s:iterator>
   
   
   </div> 
<div class="col-lg-2">
<h3>Subject</h3>
<s:iterator  value="course">
<ul>
  <li><s:property value="course_name"/><s:property/></li>

</ul>
</s:iterator>
</div> 
   <div class="col-lg-2">
<h3>Marks</h3>
<s:iterator  value="mark">
<ul>
  <li><s:property value="marks"/><s:property/></li>

</ul>
</s:iterator>
   
   
   </div> 
   <div class="col-lg-2">
<h3>Grades</h3>
<s:iterator  value="grades">
<ul>
  <li><s:property value="grade"/><s:property/></li>

</ul>
</s:iterator>
   </div>
   

    <div class="col-lg-2">
<h3>Result</h3>
<s:iterator  value="results">
<ul>
  <li><s:property value="result"/><s:property/></li>

</ul>
</s:iterator>
   </div> 
   
   <br><br>   <br><br>   <br><br>   <br><br>   <br><br>   <br><br>   <br><br>
  </div>
  </div>
  </div>
		<div class="col-lg-2">
<div  class="ann">

   
<h3>ANNOUNCEMENTS</h3>
<marquee  onMouseOver="this.scrollAmount=1" onMouseOut="this.scrollAmount=2" scrollamount="2" direction="up" loop="true" width="100%">
 <s:iterator value="announcementList" >
	<li><a href="#"><span class="glyphicon glyphicon-pushpin"></span> <i style="font-family: ; color:blue"><s:property/></i></a></li>
	<br><br>
</s:iterator>

</marquee>
</div>
<br>
<div  class="ann">

<h3>NEWS</h3>

<marquee  onMouseOver="this.scrollAmount=1" onMouseOut="this.scrollAmount=2" scrollamount="2" direction="up" loop="true" width="100%">
	<s:iterator value="newsList" >
		<li><a href="#"><span class="glyphicon glyphicon-pushpin"></span> <i style="font-family: ; color:blue"><s:property/></i></a></li>
		<br><br>
	</s:iterator>
</marquee>
</div>
</div>

</body>
</html>