
// routes for the blobstore service example
get "/upload",  forward: "/upload.gtpl"
get "/success", forward: "/success.gtpl"
get "/failure", forward: "/failure.gtpl"

get "/",       						forward: "/index.groovy"
get "/about",                       forward: "/about.groovy"
get "/feedback",					forward: "/showFeedback.groovy"
post "/saveFeedback",               forward: "/saveFeedback.groovy"
get "/searchtitle", 				forward: "/search/searchMetadata.groovy"
get "/searchkeyword", 				forward: "/search/searchMetadata.groovy"
get "/searchauthor",				forward: "/search/searchMetadata.groovy"
get "/search/results", 				forward: "/search.gtpl"
get "/showrecord/@doi",				forward: "/showRecord.groovy?identification=@doi"
get "/relatedbooks/@title",         forward: "/relatedbooks.groovy?title=@title"
get "/relatedjournals/@title",      forward: "/relatedjournals.groovy?title=@title"
get "/favicon.ico", redirect: "/images/gaelyk-small-favicon.png"