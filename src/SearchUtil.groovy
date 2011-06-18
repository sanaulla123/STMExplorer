import groovy.json.*
import groovy.util.*
import org.htmlcleaner.*
class SearchUtil{
	/**
	 * Utility method to obtain the Records filtered by "title"
	 * @param searchString     The search key which is compared with the title
	 * @param type             limit to either Book or Journal content
	 * @param searchField      The field to search in- title/keyword/author
	 * @param subject          limit to the specified subject collection
	 * @param publication      limit to articles from a particular publication
	 * @param year             limit to articles published in a year
	 * @param country		   limit to articles authored in a particular country
	 * @param responseFormat   The format of the response- pam/json/jsonp
	 * @param start            The start value for the results
	 * @param resultCount      The number of results to be returned per query
	 */
	static def searchMetadata(searchString,
							  type, 
							  searchField,
							  subject,
							  publication,
							  year,
							  country,
							  responseFormat,
							  start,
							  resultCount,
							  log)
	{
		def connectUrl = URLGenerator.getMetaUrl(searchString,
												 type,
												 searchField,
												 subject,
												 publication,
												 year,
												 country,
												 responseFormat,
												 start,
												 resultCount)
		log.info connectUrl
		def payload = new URL(connectUrl).text
		def slurper = new JsonSlurper()
		def doc = slurper.parseText(payload)
		ResultRecordSet recordSet = new ResultRecordSet()
		recordSet.jsonRecordList  = doc.records
		recordSet.totalRecords = doc.result.total
		doc.facets.each{facet->
			if(facet.name.toString().equals("subject")){
				recordSet.subjectFacet = facet.values
			}
			if(facet.name.toString().equals("pub")){
				recordSet.publicationFacet = facet.values
			}
			if(facet.name.toString().equals("year")){
				recordSet.yearFacet = facet.values
			}
			if(facet.name.toString().equals("country")){
				recordSet.countryFacet = facet.values
			}
		}
		return recordSet
	}
	
	static def getIndividualRecord(identifier,log){
		def connectUrl = URLGenerator.getIndividualRecordUrl(identifier)
		log.info "Individual Record: ${connectUrl}"
		def payload = new URL(connectUrl).text
		def slurper = new XmlSlurper()
		def doc = slurper.parseText(payload)
		IndividualRecordDetails record = new IndividualRecordDetails()
		record.identifier      = doc.records.message.head.article.identifier
		record.title           = doc.records.message.head.article.title
		record.creatorList     = doc.records.message.head.article.creator
		record.publicationName = doc.records.message.head.article.publicationName
		record.issn            = doc.records.message.head.article.issn
		record.isbn            = doc.records.message.head.article.isbn
		record.publisher       = doc.records.message.head.article.publisher
		record.publicationDate = doc.records.message.head.article.publicationDate
		record.volume          = doc.records.message.head.article.volume
		record.number          = doc.records.message.head.article.number
		record.startingPage    = doc.records.message.head.article.startingPage
		record.url             = doc.records.message.head.article.url
		record.copyright       = doc.records.message.head.article.copyright
		record.abstractText    = doc.records.message.body.p
		record.keyWords        = doc.facets.facet[1]."facet-value".list()
		
		// Clean any messy HTML
		def cleaner = new HtmlCleaner()
		def node = cleaner.clean(record.url.toString().toURL())
		 
		// Convert from HTML to XML
		def props = cleaner.getProperties()
		def serializer = new SimpleXmlSerializer(props)
		def xml = serializer.getXmlAsString(node)
		
		// Parse the XML into a document we can work with
		def page = new XmlSlurper(false,false).parseText(xml)
		def imgTag = page.'**'.findAll{ it.@class == 'coverImage'}[0]
		def tempUrl = imgTag.@style?.toString().split("\\(")
		if(tempUrl.size() > 0)
			record.imageLink = "http://www.springerlink.com"+tempUrl[1]?.substring(0,tempUrl[1]?.length()-1)
		else 
			record.imageLink = ""
		log.info record.imageLink
		return record
	}
	
	static def getRelatedBooks(queryString, start,count,log){
		def connectUrl = URLGenerator.getBooksSearchUrl(queryString)
		log.info "Related Books: ${connectUrl}"
		def payload = new URL(connectUrl).text
		def slurper = new JsonSlurper()
		def doc = slurper.parseText(payload)
		return doc.items
	}
	
	static def getScholarResults(scholarUrl, numberOfResults,log){
		// Clean any messy HTML
		def cleaner = new HtmlCleaner()
		def node = cleaner.clean(scholarUrl)
		
		// Convert from HTML to XML
		def props = cleaner.getProperties()
		def serializer = new SimpleXmlSerializer(props)
		def xml = serializer.getXmlAsString(node)
		
		// Parse the XML into a document we can work with
		def page = new XmlSlurper(false,false).parseText(xml)

		def h3Divs = page.'**'.findAll{ it.@class == 'gs_rt'}
				
		def scholarList = []
		h3Divs.each{
			GoogleScholar gs = new GoogleScholar()
			log.info "Scholar Title: ${it.h3.a}"
			log.info "Scholar URL: ${it.h3.a.@href}"
			gs.url = it.h3.a.@href
			gs.title =	it.h3.a
			scholarList << gs
		}
		return scholarList
	}
	
}