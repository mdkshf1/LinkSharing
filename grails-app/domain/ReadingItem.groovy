import enums.Seriousness

class ReadingItem implements Serializable{
    User user
    Boolean isRead
    Resource resource
    Date dateCreated
    Date lastUpdated
    static constraints = {
        user nullable : false
        isRead nullable : false
        resource nullable : false
    }
    //user and resource single
    static belongsTo = [user: User]
    static mapping = {
        id composite:['resource','user']
    }

    @Override
    public String toString() {
        return "ReadingItem{" +
                "user=" + user +
                ", isRead=" + isRead +
                ", resource=" + resource +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
