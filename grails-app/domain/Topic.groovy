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
    //subscription jo hai subscription hi hai
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
        //Topic.withNewSession {
            Subscription subscription = new Subscription(user: createdBy,seriousness: Seriousness.SERIOUS,topic: this)
            log.info("Subscribing default user")
            println subscription
            createdBy.addToSubscriptions(subscription)
            subscription.save()
            log.info("Subscribed default user")
        //}
    }
    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", createdBy=" + createdBy.fullName +
                '}';
    }
    static mapping = {
        //id composite:['topic', 'createdBy']
        sort "name"
    }

    //projections mai list output kaise aa raha hai or kyu aa rha hai
    static def getTrendingTopic()
    {
        def trendingTopics = Topic.createCriteria()
        List<TopicCO> result = trendingTopics.list {
            projections{
                createAlias('resources','r')
                count("r.topic","countTopic")
                groupProperty("r.topic")
            }
            order("countTopic","desc")
            order("name")
        }
        println "REsult is"
        println result
        result
    }
}