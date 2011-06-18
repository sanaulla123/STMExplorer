log.info params.identification

def recordDetails = SearchUtil.getIndividualRecord(params.identification,log)

request.result = recordDetails
request.title  = recordDetails.title.toString()

forward '/showrecord.gtpl'