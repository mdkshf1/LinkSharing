import enums.Seriousness

class SubscriberService {
    TopicService topicService
    Subscription save(Long id,String seriousness,User user)
    {
        Subscription subscription = new Subscription()
        Topic topic = topicService.get(id)
        subscription.setTopic(topic)
        subscription.setUser(user)
        if (seriousness == "Serious" || seriousness == null)
            subscription.setSeriousness(Seriousness.SERIOUS)
        else if (seriousness == "Very_Serious")
            subscription.setSeriousness(Seriousness.VERY_SERIOUS)
        else if (seriousness == "casual")
            subscription.setSeriousness(Seriousness.CASUAL)
        subscription.save()
    }
    Subscription check(Long id)
    {
        Subscription subscription = Subscription.get(id)
        return subscription
    }
    Subscription update(Subscription subscription,String seriousness)
    {
        if (seriousness == "Serious")
            subscription.setSeriousness(Seriousness.SERIOUS)
        else if (seriousness == "Very_Serious")
            subscription.setSeriousness(Seriousness.VERY_SERIOUS)
        else if (seriousness == "casual")
            subscription.setSeriousness(Seriousness.CASUAL)
        subscription.save()
    }
    Integer delete(Long id)
    {
        Subscription subscription = Subscription.get(id)
        if (subscription == null)
            return 0
        subscription.delete()
        return 1
    }
}
