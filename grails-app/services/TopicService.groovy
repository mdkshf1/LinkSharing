import enums.Visibility

class TopicService {
    //make it transactional
    Topic save(String name,String visibility,User user)
    {
        Topic topic = new Topic()
        topic.setName(name)
        topic.setCreatedBy(user)
        if (visibility == "public" || visibility == null)
        {
            topic.setVisibility(Visibility.PUBLIC)
        }
        else if (visibility == "private")
        {
            topic.setVisibility(Visibility.PRIVATE)
        }
        topic.save()
    }
    Topic get(Long id)
    {
        Topic topic = Topic.get(id)
        return topic
    }
    void delete(Long id){
        Topic topic = Topic.load(id)
        topic.delete()
    }
}
