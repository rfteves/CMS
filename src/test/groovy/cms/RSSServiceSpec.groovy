package cms

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class RSSServiceSpec extends Specification implements ServiceUnitTest<RSSService> {

    void "test something"() {
        when:
        def object = service.get().getClass()

        then:
        object != null
    }
}
