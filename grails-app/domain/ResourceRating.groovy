class ResourceRating {
    User createdBy
    Integer score
    Resource resource
    Date dateCreated
    Date lastUpdated
    static belongsTo = [resource : Resource]
    static constraints = {
        createdBy nullable : false
        resource size : 1..5, nullable : false
        score nullable : false
    }
}
