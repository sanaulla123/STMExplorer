<% include '/WEB-INF/includes/header.gtpl' %>
<hr>

<section class="row">
	<div class="col col_16">
		<div id="tabs" class="fontface">
			<ul>
				<li><a href="#tabs-1">Search by Title</a></li>
				<li><a href="#tabs-2">Search by Keyword</a></li>
				<li><a href="#tabs-3">Search by Author</a></li>
			</ul>
			<div id="tabs-1"><% include '/WEB-INF/includes/searchByTitle.gtpl' %></div>
			<div id="tabs-2"><% include '/WEB-INF/includes/searchByKeyword.gtpl' %></div>
			<div id="tabs-3"><% include '/WEB-INF/includes/searchByAuthor.gtpl' %></div>
		</div>
	</div>
</section>
<hr>
<div class="row">

</div>

<% include '/WEB-INF/includes/footer.gtpl' %>

