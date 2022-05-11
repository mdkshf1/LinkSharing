import enums.Visibility

class TopicVO {
    Long id
    String name
    Visibility visibility
    Integer count
    String createdBy



    static TopicVO mapper(def trendTopic)
    {
        Topic topic = trendTopic[1] as Topic
        Integer count = trendTopic[0] as Integer
        TopicVO topicVO = new TopicVO();
        topicVO.setName(topic.getName())
        topicVO.setVisibility(topic.getVisibility())
        topicVO.setCount(count)
        topicVO.setCreatedBy(topic.createdBy.getFullName())
        println "topic VO is"
        println topicVO
        topicVO
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", visibility=" + visibility +
                ", count=" + count +
                ", createdBy=" + createdBy +
                '}';
    }
}
