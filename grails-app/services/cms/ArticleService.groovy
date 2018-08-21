package cms

class ArticleService<R extends Item>{

    def cnnRssService

    def startSearch() {
        def response = cnnRssService.retrieve()
        response
    }
}
