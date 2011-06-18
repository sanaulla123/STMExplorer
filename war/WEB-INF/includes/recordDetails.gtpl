<section class="row">
	<section class="col col_15">
		<section class="row">
			<section class="col col_3">
				<img src="${request.result.imageLink}" class="width_3" alt="${request.result.title}"/>
			</section>
			<section class="col col_7">
				<section class="row">
					<section class="col col_7">
						<strong>Published on&nbsp;</strong>
						${request.result.publicationDate}
					</section>
				</section>
				<section class="row">
					<section class="col col_7">
						<strong>Published by&nbsp;</strong>${request.result.publisher}
					</section>
				</section>
				<section class="row">
					<section class="col col_7">
						<strong>Publication &nbsp;</strong>
						<a href="/searchtitle?publication=%22${request.result.publicationName}%22&page=1">
							${request.result.publicationName}
						</a>
					</section>
				</section>
				<section class="row">
					<section class="col col_7">
						<strong>Authors</strong>
						<ul>
							<% request.result.creatorList.each{author-> %>
							<li>${author}</li>
							<%}%>
						</ul>		
					</section>
				</section>
				<section class="row">
					<section class="col col_7">
						<strong>
						<a href="/relatedbooks/${URLEncoder.encode(request.result.title.toString())}">Related books</a>
						</strong>
					</section>
				</section>
			</section>
			<section class="col col_2">
				<a href="http://twitter.com/share" class="twitter-share-button" data-count="vertical" data-via="sanaulla">Tweet</a>
				<script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
				
			</section>
			<section class="col col_2">
				<script type="text/javascript" src="http://static.evernote.com/noteit.js"></script>
				<a href="#" onclick="Evernote.doClip({
									providerName:'STM Explorer',
									contentId:'abstract',
									url:'${request.result.url}',
									title:'${request.result.title}'}); return false;" class="left">
					<img src="http://static.evernote.com/article-clipper-vert.png" alt="Clip to Evernote" />
				</a>
			</section>
		</section>
		<hr/>
		<section class="row">
			<section class="col col_15">
				<strong>Abstract</strong>
				<p class="align_justify" id="abstract">
					${request.result.abstractText}
				</p>
			</section>	
		</section>
		<section class="row">
			<section class="col col_15">
				<a href="${request.result.url}" class="more gradient_radial rounded">Read more</a>
			</section>	
		</section>
	</section>
</section>
