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
					<form action="faculty_search" method="post" class="navbar-form navbar-right" role="search">
       					 <div class="form-group">
         					 <input name="faculty_id" class="form-control" placeholder="search here" type="text" required />
       					 </div>
						<button type="submit" name="submit" class="btn btn-info">
        				  <span class="glyphicon glyphicon-search"></span> Search
       					 </button>
					</form>
					
				<br>
				<s:set name="msg" value="Info"/>
  				<s:if test="%{#msg=='markssuccess'}">
  						<h2 align="center">Marks Entered SuccessFully.</h2>
  				</s:if>
  				<s:elseif test="%{#msg=='marksfail'}">
  						<h2 align="center">Student was Assigned Marks</h2>
  				</s:elseif>
  				<s:else>
  					<h2 align="center"><label class="control-label">Welcome Faculty </label></h2>			
  				</s:else>
				<br><br><br><br><br><br>
			</div>

		</div>

		<%@include file="/jsp/facultyPages/newsAnnouncement.jsp" %>
  
	</body>
</html>