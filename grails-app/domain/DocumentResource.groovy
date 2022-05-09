class DocumentResource extends Resource{
    String filePath
    static constraints = {
        filePath unique : true, nullable : false, blank : false
    }
}
