<section class="row">
	<section class="col col_4">
		<a href="/relatedbooks/${URLEncoder.encode(request.result.title.toString())}">Related Books</a>
	</section>
</section>
<!-- <section class="row">
	<section class="col col_4">
		<a href="/relatedjournals/${URLEncoder.encode(request.result.title.toString())}">Related journals</a>
	</section>
</section> -->
<section class="row">
	<section class="col col_4">
		<script type="text/javascript" src="http://static.evernote.com/noteit.js"></script>
		<a href="#" onclick="Evernote.doClip({
							providerName:'STM Explorer',
							contentId:'abstract',
							url:'${request.result.url}',
							title:'${request.result.title}'}); return false;" class="left">
			Make a note of this &nbsp;<img src="http://static.evernote.com/site-mem-16.png" alt="Clip to Evernote" />
		</a>
	</section>
</section>