package cms

class Image extends Item {

    String url
    String medium
    Integer height
    Integer width

    static belongsTo = [article: Article]

    static constraints = {
    }

    static mapping = {
        id column: 'image_id'
    }
}
