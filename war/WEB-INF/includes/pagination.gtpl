<section id="pg" class="row">
	<div class="col_11">
	<% if(request.prev?.equals("")){ %>
		<span class="disabled">Previous</span>	
	<%}else{%>
		<a href="${request.prev}" class="gradient_radial">Previous</a>
	<%}%>
	<%if(request.next?.equals("")){%>
		<span class="disabled">Next</span>	
	<%}else{%>
		<a href="${request.next}" class="gradient_radial">Next</a>
	<%}%>
	</div>
</section>