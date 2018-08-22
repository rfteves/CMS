package cms

class ArticleService<R extends Item> {

    def cnnRssService
    def itemService

    def startSearch() {
        def response = cnnRssService.retrieve()
        response.articles.each { item ->
            Article article = new Article(item)
            article.source = 'CNN'
            article.title = item.title
            article.description = item.description
            article.link = item.link
            article.processedDate = new Date()
            if (item.pubDate) {
                article.pubDate = item.pubDate
            }
            item.images.each { imag ->
                Image image = new Image()
                image.medium = imag.medium
                image.url = imag.url
                image.height = imag.height.toInteger()
                image.width = imag.height.toInteger()
                article.addToImages(image)
            }
            itemService.makeRecord(article)
        }
        response
    }
}
