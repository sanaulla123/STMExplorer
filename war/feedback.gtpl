<% include '/WEB-INF/includes/header.gtpl' %>
<hr>
<section class="row">
	<section class="col col_14">
		<h5>Feedback</h5>
	</section>
</section>
<section class="row">
	<section class="col col_14">
		<p class="justify">
			Please feel free to drop in your suggestions on how I can improve the application. 
			Also please report any flaws you have seen in the site.
		</p>
		<p>
			Your suggestions are most welcome!
		</p>
	</section>
</section>
<section class="row">
	<section class="col col_14">
		<form action="/saveFeedback" method="POST" class="col col_10">
	    	<fieldset>	
	        
	            Your name: <br>
				<input type="text" id="name" name="name" class="box_shadow"><br>
				<br>
				
				Your email: <br>
				<input type="text" id="email" name="email" class="box_shadow"><br>
				<br>
				
				Your comments: <br>
				<textarea name="comments" id="comments" rows="15" cols="50" class="box_shadow"></textarea><br><br>
	            <input type="submit" value="Save feedback" />
	        </fieldset>
		</form>
	</section>
</section>
<hr>
<div class="row">

</div>

<% include '/WEB-INF/includes/footer.gtpl' %>

