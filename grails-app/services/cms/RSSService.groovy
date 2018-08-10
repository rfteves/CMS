package cms

import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder

import javax.servlet.http.HttpServletResponse

class RSSService {

    def get() {
        def releaseUrl = 'http://rss.cnn.com/rss/edition.rss'
        def http = new HTTPBuilder(releaseUrl)
        http.headers
        http.get(requestContentType: ContentType.XML) { resp, xml ->
            if (resp.status == HttpServletResponse.SC_OK) {
                log.debug("Post Response ${resp.status}: $releaseUrl  $xml")
            } else {
                log.error("Post Response ${resp.status}: $releaseUrl  $xml")
            }
            xml
        }
    }
}
