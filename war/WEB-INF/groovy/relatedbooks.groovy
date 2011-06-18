log.info "Title: ${params.title}"

request.title = "Related Books"
def queryString = params.title.toString()

def relatedBooks = SearchUtil.getRelatedBooks(queryString,0,10,log)
request.relatedBooks = relatedBooks
forward "/relatedBooks.gtpl"