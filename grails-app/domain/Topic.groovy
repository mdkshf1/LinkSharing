import enums.Seriousness
import enums.Visibility
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Topic implements Serializable{
    public static final Logger log = LoggerFactory.getLogger(this)
    String name
    Visibility visibility
    User createdBy
    Date dateCreated
    Date lastUpdated
    Set<Subscription> subscriptions
    Set<Resource> resources
    static hasMany = [subscriptions : Subscription, resources : Resource]
    static belongsTo = [createdBy: User]
    static constraints = {
        name blank : false, nullable : false
        visibility nullable : false, blank : false
        createdBy nullable : false, blank : false
    }
    def afterInsert()
    {
        Topic.withNewSession {
            //subscribtion table mai check krna hai k subscriber add hua k nahi
            //run it without withNewSession or check krna hai k log ayga ya nahi
            Subscription subscription = new Subscription(user: createdBy,seriousness: Seriousness.SERIOUS,topic: this)
            log.info("Subscribing default user")
            createdBy.addToSubscriptions(subscription)
        }
    }
    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", createdBy=" + createdBy.fullName +
                '}';
    }
    static mapping = {
        //id composite:['name', 'createdBy']
        sort "name"
    }
}
