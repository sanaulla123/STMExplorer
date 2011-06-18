<% include '/WEB-INF/includes/header.gtpl' %>
<hr/>
<section class="row">
	<section class="col col_14">
		<h5>Related books</h5>
	</section>
</section>
<hr/>
<% request.relatedBooks.each{book-> %>
<section class="row">
	<div class="col col_3">
		<img src="${book.volumeInfo.imageLinks.thumbnail}" alt="${book.volumeInfo.title}"/>
	</div>
	<div class="col col_10">
		<p><a href="${book.volumeInfo.infoLink}">${book.volumeInfo.title}</a></p>
		<p>
			<% if(book.volumeInfo.description != null){ %>
			<em>${book.volumeInfo.description}</em>
			<%}%>
		</p>
	</div>
</section>
<br/>
<% } %>
<section class="row">
	<article class="col col_5 left">
		Results from <a href="http://books.google.com">Google Books</a>
	</article>
</section>
<% include '/WEB-INF/includes/footer.gtpl' %>
	