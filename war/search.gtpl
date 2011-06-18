<% include '/WEB-INF/includes/header.gtpl' %>
<section class="row">
	<section class="col col_10">	
		<h3>Search results</h3>
		<% request.results.jsonRecordList.each{record -> %>
		<section class="col col_10">
			<h5><a href="/showrecord/${URLEncoder.encode(record.identifier)}">${record.title}</a></h5>			
			<p class="col col_8 tk-droid-serif" >
				<span class="bold">Published on</span>: ${record.publicationDate}<br/>
				<span class="bold">Publication name</span>: ${record.publicationName}<br/>
				<span class="bold">Published by</span>: ${record.publisher}<br/>
			</p>
		</section>
		<%}%>
	</section>
	<section class="col col_4">
		<% include '/WEB-INF/includes/searchSidebar.gtpl' %>
	</section>
</section>
<!-- Pagination -->
<% include '/WEB-INF/includes/pagination.gtpl' %>
<hr>

<% include '/WEB-INF/includes/footer.gtpl' %>