package cms

import grails.converters.JSON
import org.jdom2.Element
import org.jdom2.Namespace
import org.jdom2.filter.ElementFilter
import org.jdom2.input.SAXBuilder

import java.text.SimpleDateFormat


class CnnRssService {

    def retrieve() {
        def results = [articles:[], success: false]
        def releaseUrl = 'http://rss.cnn.com/rss/edition.rss'
        def saxBuilder = new SAXBuilder()
        def document = saxBuilder.build(releaseUrl)
        def media = Namespace.getNamespace("media", "http://search.yahoo.com/mrss/")
        def items = document.getDescendants(new ElementFilter('item'))
        while (items.hasNext()) {
            Element item = (Element) items.next()
            def news = [:]
            news.images = []
            news.title = item.getChildText('title')
            def description = item.getChildText('description')
            if (!description?.startsWith('<') && description?.length() < 600) {
                news.description = description
            }

            news.link = item.getChildText('link')
            def pubDate = item.getChildText('pubDate')
            if (pubDate?.length() == 29) {
                news.pubDate = parseDate(pubDate)
            }
            Iterator images = item.getDescendants(new ElementFilter("content", media))
            while (images.hasNext()) {
                Element image = (Element) images.next()
                def imag = [:]
                imag.medium = image.getAttributeValue('medium')
                imag.url = image.getAttributeValue('url')
                imag.height = image.getAttributeValue('height')
                imag.width = image.getAttributeValue('width')
                news.images << imag
            }
            results.articles << news
        }
        results
    }
    def parseDate(strDate) {
        //Tue, 21 Aug 2018 18:42:49 GMT
        SimpleDateFormat sdf = new SimpleDateFormat('EEE, dd MMM yyyy HH:mm:ss zzz')
        sdf.parse(strDate)
    }
}
