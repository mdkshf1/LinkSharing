import CO.ResourceSearchCO
import enums.Visibility

class ResourceController {
    def search()
    {
        ResourceSearchCO co = new ResourceSearchCO()
        co.topicId = Long.parseLong(params.topicId)
        log.info("Topic id inside is as "+co.topicId,params.topicId)
        co.max = 5 //params.max
        co.offset = 0  //params.offset
        if (params.visibility == "public" || params.visibility == null)
            co.visibility= Visibility.PUBLIC
        else if (params.visibility == "private")
            co.visibility = Visibility.PRIVATE
        List<Resource> resourcesList = Resource.visibilitySearch(co).list
        println resourcesList
        render resourcesList
    }
    def show()
    {
        List<TopicVO> topicVOS=new ArrayList<>()
        def trend = Topic.getTrendingTopic()
        for (List<TopicCO> topicCO in (trend as List<List<TopicCO>>))
        {
            TopicVO topicVO = TopicVO.mapper(topicCO)
            topicVOS << topicVO
        }
        render topicVOS
    }
    def ratingShow()
    {
        Resource.getResourceDetails()
        render "Rating"

    }
    def showTopPost()
    {
        Resource.getTopPost()
        render 'top post'
    }
    def unread()
    {
        User user = session.user
        println "Session ka user "+user
        User user1 = User.findByUserName("normal.user")
        //find unread data
        println user.isAttached()
        ReadingItem.getUnReadResources(user1)
        render 'unread'
    }
}