import enums.Seriousness

class Subscription implements Serializable {
    User user
    Topic topic
    Seriousness seriousness
    Date dateCreated
    Date lastUpdated
    static constraints = {
        user nullable : true
        topic nullable : true
        seriousness nullable : true
    }

    static mapping = {
        id composite:['topic', 'user']
    }
    static fetchMode = [user: 'eager',topic: 'eager']

    @Override
    public String toString() {
        return "Subscription{" +
                ", topic=" + topic.name +
                ", seriousness=" + seriousness +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
