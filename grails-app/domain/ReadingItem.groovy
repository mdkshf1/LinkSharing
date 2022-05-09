class ReadingItem {
    User user
    Boolean isRead
    Resource resource
    Date dateCreated
    Date lastUpdated
    static constraints = {
        user nullable : false, unique : true
        isRead nullable : false
        resource nullable : false, unique : true
    }
}
