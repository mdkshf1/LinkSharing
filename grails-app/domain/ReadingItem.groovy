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
                ", isRead=" + isRead +
                ", resource=" + resource.topic.name +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

    def static getUnReadResources(User user)
    {
        def unreadResource = ReadingItem.executeQuery("from readingItem")
        println unreadResource
    }
}
