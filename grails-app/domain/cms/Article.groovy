package cms

class Article extends Item  {

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
        description maxSize: 600, nullable: true
    }

    static mapping = {
        id column: 'article_id'
    }
}
