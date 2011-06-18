
class URLGenerator{
	static def BASE_METADATA_URL        = "http://api.springer.com/metadata"
	static def GOOGLE_BOOKS_VOLUME_URL  = "https://www.googleapis.com/books/v1/volumes"
	static def RESULT_COUNT  = "20"
	static def SEARCH_RESPONSE_FORMAT = "json"
	/*
	 * type-   		   limit to either Book or Journal content
	 * subject-		   limit to the specified subject collection
	 * publication-    limit to articles from a particular publication
	 * year-           limit to articles published in a year
	 * country-        limit to articles authored in a particular country
	 * responseFormat- Format of the response- pam, jsonp, json
	 */
	static def getMetaUrl(searchString,
						  type,
						  searchField,
						  subject,
						  publication,
						  year,
						  country,					  
						  responseFormat,start,resultCount)
	{
	
		def queryBuilder  = []
		if(searchField != null && searchString != null)
			queryBuilder << URLEncoder.encode("${searchField}:${searchString}")
		if(type != null)
			queryBuilder << URLEncoder.encode("type:${type}")
		if(subject != null)
			queryBuilder << URLEncoder.encode("""subject:"${subject}" """)
		if(publication != null)
			queryBuilder << URLEncoder.encode("""pub:"${publication}" """)
		if(year != null)
			queryBuilder << URLEncoder.encode("year:${year}")
		if(country != null)
			queryBuilder << URLEncoder.encode("""country:"${country}" """)
		def queryString = queryBuilder.join("+")
		
		def baseUrl = "${BASE_METADATA_URL}/${responseFormat}"
		def eStart       = URLEncoder.encode(start)
		def eResultCount = URLEncoder.encode(resultCount)
		def eApiKey      = URLEncoder.encode(ApiKey.METADATA_KEY)
		return "${baseUrl}?q=${queryString}&api_key=${eApiKey}&s=$eStart&p=${eResultCount}"
	}
	
	static def getIndividualRecordUrl(identifier){
		return BASE_METADATA_URL+"/pam?q=${identifier}&api_key=${ApiKey.METADATA_KEY}"
	}
	
	static def getBooksSearchUrl(queryString){
		def queryBuilder = []
		if(queryString != null)
			queryBuilder << "q="+URLEncoder.encode(queryString)
		queryBuilder << "orderBy=relevance"
		queryBuilder << "key="+ApiKey.GOOGLE_BOOKS_KEY
		
		return GOOGLE_BOOKS_VOLUME_URL+"?"+queryBuilder.join("&")
		
	}
	static def generateSearchUrlWithoutpage(searchString,
								 contentType,
								 searchField,
								 subject,
								 publication,
						  		 year,
	   						     country){
		def queryBuilder = []
		if(searchString != null)
			queryBuilder << "searchString="+URLEncoder.encode(searchString)
		if(contentType != null)
			queryBuilder << "contentType="+URLEncoder.encode(contentType)
		if(searchField != null)
			queryBuilder << "searchField="+URLEncoder.encode(searchField)
		
		if(subject != null)
			queryBuilder << "subject="+URLEncoder.encode(subject)
		if(publication != null)
			queryBuilder << "publication="+URLEncoder.encode(publication)
		if(year != null)
			queryBuilder << "year="+URLEncoder.encode(year)
		if(country != null)
			queryBuilder << "country="+URLEncoder.encode(country)
		def queryString = queryBuilder.join("&")
		return "/searchtitle?${queryString}"
	}
	static def generateSearchUrl(searchString,
								 contentType,
								 searchField,
								 subject,
								 publication,
						  		 year,
	   						     country){
		
		def searchUrl = generateSearchUrlWithoutpage(searchString,
													 contentType,
								 			  		 searchField,
							     					 subject,
								  					 publication,
						  		 					 year,
	   						     					 country)
		return searchUrl+"&page=1"
	}
	
}