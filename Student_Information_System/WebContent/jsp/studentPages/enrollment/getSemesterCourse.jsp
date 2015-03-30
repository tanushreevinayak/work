<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="/jsp/studentPages/headPage.jsp" %>
	<link href="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
rel="stylesheet" type="text/css" />
<script>
function val(){
	if(document.form.subjects.Indexed.length > 4){
		alert("not more than 4 courses");		
	}
}
</script>
</head>
<body style="background-color:#848484">
	<%@include file="/jsp/studentPages/topNavBar.jsp" %>
	<%@include file="/jsp/studentPages/sideNavBar.jsp"%>


<div class="col-lg-7">
<div class="mainframe">
<br>
		<s:set name="msg" value="result"/>
  		<s:if test="%{#msg=='success'}">
  			<h2 align="center">Registered Successfully</h2>
  			
  		</s:if>
  		<s:elseif test="%{#msg=='failure'}">
  			<h2>You Are Already Registered</h2>
  		</s:elseif>
  		<s:else>
  		
			<br><br><br>
			<form name="form" class="form-horizental" action="enrollsubjects" method="post">
			
			<div class="form-group">
				<table align="center">
						<s:iterator value="CourseList" status="CourseListStatus">
						  <tr>
						  	<s:if test="#CourseListStatus.even == true">
						      <td style="background: #CCCCCC" align="center" ><s:property/></td>
						      <td align="center"><s:property/></td>
						      <td style="background: #CCCCCC" align="center"><s:property/></td>

						    </s:if>
 						    <s:elseif test="#CourseListStatus.first == true">
						      <td align="center"><s:property/></td>
						      <td style="background: #CCCCCC" align="center"><s:property/></td>
						      <td align="center"><s:property/></td>
						    </s:elseif>
 						    <s:else>
						      <td align="center"><s:property/></td>
						      <td style="background: #CCCCCC" align="center"><s:property/></td>
						      <td align="center"><s:property/></td>
						    </s:else>
						  </tr>
						</s:iterator>
				</table>
			</div>
				
			<div class="form-group">
				<center>
					<select id="subjects" name="subjects" multiple="multiple" > 
						<s:iterator value="CourseList">
							<option value="<s:property/>"><s:property/></option>
						</s:iterator>
					</select>
			<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

			<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>

			<script src="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/js/bootstrap-multiselect.js"
			type="text/javascript"></script>
			<script type="text/javascript">
				$(function () {
					$('#subjects').multiselect({
						includeSelectAllOption: true
					});
				});
			</script>
		<br><br>		
		<div class="row">
  		    <input type="submit" value="Select Subjects"  class="btn btn-primary" onclick="val()"/>
   	   </div> 
   	   		<br><br><br><br>
   	   	</center>
	</div>
       
 	 	
</form>
 </s:else>
 		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
   	   		

</div>
</div>
		<%@include file="/jsp/studentPages/newsAnnouncement.jsp" %>

</body>
</html>