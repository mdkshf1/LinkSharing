import CO.ResourceSearchCO

abstract class Resource {
    User createdBy
    String description
    Topic topic
    Set<ResourceRating> ratings
    Set<ReadingItem> readingItems
    Date dateCreated
    Date lastUpdated
    static hasMany = [readingItems : ReadingItem, ratings : ResourceRating]
    static mapping = {
        tablePerHierarchy false
    }
    static namedQueries = {
/*        search {
            ResourceSearchCO co ->
                Topic topic1 = Topic.findById(co.topicId)
                println "Inside Co of resource"
                println topic1
                eq 'topic',topic1
        }*/
        visibilitySearch {
            ResourceSearchCO co ->
                Topic topic1 = Topic.findById(co.topicId)
                println "Topic for visibility"
                println topic1
                eq 'topic',topic1
                eq topic.visibility,co.visibility
        }
    }
}
