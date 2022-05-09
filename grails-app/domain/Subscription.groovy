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
}
