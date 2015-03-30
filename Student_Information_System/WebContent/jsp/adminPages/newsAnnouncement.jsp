<div class="col-lg-3">
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