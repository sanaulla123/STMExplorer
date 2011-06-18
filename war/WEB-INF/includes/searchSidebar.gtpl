<section class="row">
	<section class="col col_4">
		<% if(request.results.subjectFacet?.size() > 0){ %>
			<h5>Subjects</h5>
			<ul>
			<% request.results.subjectFacet.each{ %>
				<a href="${URLGenerator.generateSearchUrl(params.searchString,
												   params.contentType,
												   params.searchField,
												   it.value,params.publication,params.year,params.country)}"><li>${it.value}(${it.count})</li></a>
			<%}%>
			</ul>
		<% } %>
	</section>
</section>
<section class="row">
	<section class="col col_4">
		<% if(request.results.publicationFacet?.size() > 0){ %>
			<h5>Publication</h5>
			<ul>
			<% request.results.publicationFacet.each{ %>
				<a href="${URLGenerator.generateSearchUrl(params.searchString,
												   params.contentType,
												   params.searchField,
												   params.subject,
												   it.value,
												   params.year,
												   params.country)}"><li>${it.value}(${it.count})</li></a>
			<%}%>
			</ul>
		<% } %>
	</section>
</section>
<section class="row">
	<section class="col col_4">
		<% if(request.results.yearFacet?.size() > 0){ %>
			<h5>Year</h5>
			<ul>
			<% request.results.yearFacet.each{ %>
				<a href="${URLGenerator.generateSearchUrl(params.searchString,
												   params.contentType,
												   params.searchField,
												   params.subject,
												   params.publication,
												   it.value,
												   params.country)}"><li>${it.value}(${it.count})</li></a>
			<%}%>
			</ul>
		<% } %>
	</section>
</section>
<section class="row">
	<section class="col col_4">
		<% if(request.results.countryFacet?.size() > 0){ %>
			<h5>Country</h5>
			<ul>
			<% request.results.countryFacet.each{ %>
				<a href="${URLGenerator.generateSearchUrl(params.searchString,
												   params.contentType,
												   params.searchField,
												   params.subject,
												   params.publication,
												   params.year,
												   it.value)}"><li>${it.value}(${it.count})</li></a>
			<%}%>
			</ul>
		<% } %>
	</section>
</section>