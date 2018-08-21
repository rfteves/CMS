package cms

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class CnnRssServiceSpec extends Specification implements ServiceUnitTest<CnnRssService> {

    void "test something"() {
        when:
        def response = service.get()

        then:
        response != null
    }
}
