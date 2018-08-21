package cms

class Article  {

    String source

    // RSS required fields
    String title
    String link
    String description

    Date pubDate
    Date processedDate

    static hasMany = [images : Image]

    static constraints = {
        pubDate nullable: true
        processedDate nullable: true
        description maxSize: 500, nullable: true
    }

    static mapping = {
        id column: 'article_id'
    }
}
