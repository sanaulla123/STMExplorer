<section class="row tk-droid-serif">
	<form action="/searchtitle">
		<input type="hidden" value="name" name="searchField" />
		<input type="hidden" value="1"     name="page"/>
		<div class="col col_12">
			Author is <input type="text" class="col_4 box_shadow rounded" name="searchString"/>
			&nbsp;
			and content type is
			<select name="contentType" class="rounded fontface">
				<option>Book</option>
				<option>Journal</option>
			</select>
		</div>
		<div class="col col_3">
			<input type="submit" value="Search"/>
		</div>
	</form>
</section>