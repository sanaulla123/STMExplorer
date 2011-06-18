<% include '/WEB-INF/includes/header.gtpl' %>
<section class="row">
	<section class="col col_14">
		<h5>Related Journals</h5>
	</section>
</section>
<section class="row">
	<section class="col col_14">
		<ul>
	<% request.relatedJournals.each{ record -> %>
		<li><a href="${record.url}">${record.title}</a></li>	
	<%}%>
		</ul>
	</section>
</section>

<section class="row">
	<article class="col col_5 left">
		Results from <a href="${request.scholarUrl}">Google Scholar</a>
	</article>
</section>
<% include '/WEB-INF/includes/footer.gtpl' %>