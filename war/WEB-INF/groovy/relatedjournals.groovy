request.title = "Related Journals"

def queryString = params.title.toString()

def numberOfResults = 20
def scholarUrl = "http://scholar.google.com/scholar?q=%22${URLEncoder.encode(queryString)}%22&num=${numberOfResults}"

def relatedJournals = SearchUtil.getScholarResults(scholarUrl,numberOfResults,log)
request.scholarUrl = scholarUrl
request.relatedJournals = relatedJournals
forward "/relatedJournals.gtpl"