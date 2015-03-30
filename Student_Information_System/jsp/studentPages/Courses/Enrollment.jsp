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

<title>Insert title here</title>
</head>
<body style="background-color:#848484">

<!-- FIRST PART OF THE PAGE -->
    <div class="navbar navbar-default " >
    <div class="col-lg-4"><p style="font-size:125%"> print the student name here</p></div>
    <div class="col-lg-4">
         <div class="navbar-collapse collapse navbar-responsive-collapse" style="text-align:center">
            
               <span style="color:black" class="glyphicon glyphicon-user gi-5x"></span>
               <b style="color:grey;font-size:175%">Student Information  System</b>
               <span style="color:black" class="glyphicon glyphicon-user gi-5x"></span>
         </div>    
         </div>
       <div class="col-lg-4">
     <p style="text-align:right"> <a href="#">Logout</a></p>
       
   
  </div>
</div>
   
   
<div class="col-lg-2">

<div class="frame1">
<ul class="nav nav-pills nav-stacked">
     <li  class="active"><a href="Enrollment"><i class="fa fa-home "></i>&nbsp;Home</a></li>
   
</ul>
</div>


<div class="frame1">
<ul class="nav nav-pills nav-stacked">
     <li  class="active"><a href="#"><i  class="fa fa-gears"></i>&nbsp;Profile Settings</a></li>
   
</ul>
</div>
<div class="frame1">
<ul class="nav nav-pills nav-stacked">
     <li  class="active"><a href="#"><i class="fa fa-check-circle-o fa-fw"></i>&nbsp;View Results</a></li>
   
</ul>
</div>
<div class="frame1">
<ul class="nav nav-pills nav-stacked">
     <li  class="active"><a href="#"><i  class="fa fa-book"></i>&nbsp;View Syllabus</a></li> 
   
</ul>
</div>
 

</div>

<div class="col-lg-7">
<div class="mainframe">




<br><br><br>
<form class="form-horizental" action="enr">
	
	<div class="form-group">
	<center>
	<!--  
<label for="Course Name">Course Name</label>
<!-- <s:textfield name="course_name"></s:textfield> -->
<!--  <input type="text" name="course_name" class="form-control" id="course_name"/>
   <input type="hidden" name="flag" id="flag" value="option"/>-->
<select id="subjects" name="subjects" multiple="multiple" > 
		<s:iterator value="subjects">
		<option value="<s:property/>"><s:property/></option>
		</s:iterator>
		</select>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
<link href="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
rel="stylesheet" type="text/css" />
<script src="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/js/bootstrap-multiselect.js"
type="text/javascript"></script>
<script type="text/javascript">
$(function () {
	$('#subjects').multiselect({
	includeSelectAllOption: true
	});
});
</script>

<script type="text/javascript">


/*jQuery(document).ready(function($){
$('.frm_chzn').chosen({max_selected_options: 5});
alert("you cannot select more than 5 subjects");
$('.frm_chzn').bind("chosen:maxselected", function () {
}); 
});*/

</script>


<br><br>
<div class="row">
      <input type="submit" value="Select Subjects"  class="btn btn-primary" />
      </div> 
</center>
</div>
       
     	
     	 
    
    
	 	
</form>
</div>
</div>

<div class="col-lg-3">
<div  class="ann">

   
<h3>ANNOUNCEMENTS</h3>
<marquee  onMouseOver="this.scrollAmount=1" onMouseOut="this.scrollAmount=2" scrollamount="2" direction="up" loop="true" width="100%">
 
Scroll of announcements

<!-- 	<li><a href="http://www.ndtv.com/article/cheat-sheet/barack-obama-s-thumbs-up-for-daredevil-stunt-riders-at-republic-day-parade-10-developments-653780?pfrom=home-lateststories"><span class="glyphicon glyphicon-pushpin"></span> <i style="font-family: ; color:blue">Barack Obama's Thumbs Up for Daredevil Stunt Riders at Republic Day Parade: 10 Developments</i></a></li>
    <li><a href="http://sports.ndtv.com/australia-tri-series-2015/news/236589-tri-series-rain-gods-offer-india-lifeline-can-mahendra-singh-dhoni-co-take-it?pfrom=home-cricket"><span class="glyphicon glyphicon-pushpin"></span> <i style="font-family: ; color:blue">Can MS Dhoni & Co. Take the Rain Gods' Lifeline? </a></li>
       <li><a href="http://auto.ndtv.com/news/indian-students-develop-vehicle-that-delivers-mileage-of-200km-l-733735?pfrom=home-auto"><span class="glyphicon glyphicon-pushpin"></span> <i style="font-family: ; color:blue">Indian Students Develop Vehicle That Delivers Mileage of 200Km/l</a></li> 
           <li><a href="http://gadgets.ndtv.com/telecom/news/whatsim-lets-you-use-whatsapp-for-free-while-roaming-worldwide-652145?pfrom=home-editorpick"><span class="glyphicon glyphicon-pushpin"></span> <i style="font-family: ; color:blue">Use WhatsApp for Free, Anywhere in the World</a></li>
     -->  
</marquee>
</div>
<br>
<div  class="ann">

<h3>NEWS</h3>

<marquee  onMouseOver="this.scrollAmount=1" onMouseOut="this.scrollAmount=2" scrollamount="2" direction="up" loop="true" width="100%">
<!-- 
	<li><a href="http://www.ndtv.com/article/cheat-sheet/barack-obama-s-thumbs-up-for-daredevil-stunt-riders-at-republic-day-parade-10-developments-653780?pfrom=home-lateststories"><span class="glyphicon glyphicon-pushpin"></span> <i style="font-family: ; color:blue">Barack Obama's Thumbs Up for Daredevil Stunt Riders at Republic Day Parade: 10 Developments</i></a></li>
    <li><a href="http://sports.ndtv.com/australia-tri-series-2015/news/236589-tri-series-rain-gods-offer-india-lifeline-can-mahendra-singh-dhoni-co-take-it?pfrom=home-cricket"><span class="glyphicon glyphicon-pushpin"></span> <i style="font-family: ; color:blue">Can MS Dhoni & Co. Take the Rain Gods' Lifeline? </a></li>
       <li><a href="http://auto.ndtv.com/news/indian-students-develop-vehicle-that-delivers-mileage-of-200km-l-733735?pfrom=home-auto"><span class="glyphicon glyphicon-pushpin"></span> <i style="font-family: ; color:blue">Indian Students Develop Vehicle That Delivers Mileage of 200Km/l</a></li> 
           <li><a href="http://gadgets.ndtv.com/telecom/news/whatsim-lets-you-use-whatsapp-for-free-while-roaming-worldwide-652145?pfrom=home-editorpick"><span class="glyphicon glyphicon-pushpin"></span> <i style="font-family: ; color:blue">Use WhatsApp for Free, Anywhere in the World</a></li>
 -->
 Scroll of News      
</marquee>
</div>
</div>



</body>
</html>