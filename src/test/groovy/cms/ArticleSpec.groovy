package cms

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ArticleSpec extends Specification implements DomainUnitTest<Article> {

    void "test something"() {
        when:
        def one = 1

        then:
        one == 1
    }
}
