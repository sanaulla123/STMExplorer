log.info params.searchField
log.info params.searchString
log.info params.contentType

def RESPONSE_FORMAT = "json"
def start = ((params.page?.toInteger()-1)*URLGenerator.RESULT_COUNT.toInteger()+1).toString()

log.info start
ResultRecordSet filteredResults = SearchUtil.searchMetadata(params.searchString,
															  params.contentType,
															  params.searchField,
															  params.subject,
															  params.publication,
															  params.year,
															  params.country,
															  URLGenerator.SEARCH_RESPONSE_FORMAT,
															  start,
															  URLGenerator.RESULT_COUNT,
															  log)
															  

request.results =filteredResults
request.title   = "Search results for ${params.searchString}"
def maxPages = Math.ceil(filteredResults.totalRecords.join("").toInteger()/URLGenerator.RESULT_COUNT.toInteger()).toInteger().toString()
log.info "Max page value: ${maxPages}"
log.info "Next/Prev URL: ${URLGenerator.generateSearchUrl(params.searchString,params.contentType,params.searchField,params.subject,params.publication,params.year,params.country)}"

def navPath = URLGenerator.generateSearchUrlWithoutpage(params.searchString,params.contentType,params.searchField,params.subject,params.publication,params.year,params.country)
if(params.page?.equals("1")){
	request.prev=""
}
else{
	request.prev= navPath+"&page="+URLEncoder.encode((params.page.toInteger()-1).toString())
}
if(params.page?.equals(maxPages)){
	request.next=""
}
else{
	request.next= navPath+"&page="+URLEncoder.encode((params.page.toInteger()+1).toString())
}
if(maxPages.equals("0")){
	request.next=""
	request.prev=""
}


forward "/search.gtpl"