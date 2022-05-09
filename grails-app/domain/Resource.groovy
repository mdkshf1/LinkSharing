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
        search{
            ResourceSearchCO co->
                if (co.topicId)
                {
                    eq('topic',co.topicId)
                }
        }
    }
}
