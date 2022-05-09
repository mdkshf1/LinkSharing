
class UserController {
    def index()
    {
        render "User Dashboard"
    }
    def subscribeTopics()
    {
        //how to do debugging
        User user = session.user
        Set<Topic> topics = user.topics
        Set<Topic> allTopics = Topic.findAll()
        Set<Topic> toSubscribeTopics = allTopics
        for (Topic topic in topics)
        {
            println topic
            toSubscribeTopics.remove(topic)
        }
        println "All the topics are"
        println allTopics
        println "Topics found are:"
        println topics
        println "To subscribe Topics are"
        println toSubscribeTopics
        render toSubscribeTopics
    }
/*    def ReadingItems()
    {
        User user = session.user
        Set<Resource> resources = Resource.findAll() as Set<Resource>
        Set<Resource> createdResource = user.getResources()
        Set<ReadingItem> readingItems = user.getReadingItems()
        Set<Resource> toReadResource = resources - createdResource

        println toReadResource
        render toReadResource
    }*/
}