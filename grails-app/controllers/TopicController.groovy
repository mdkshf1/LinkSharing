import CO.ResourceSearchCO

class TopicController {
    TopicService topicService
    def save()
    {
        if (!session.user)
        {
            render "Session for any user not found"
            redirect(controller: "Login",action: "index")
        }
        String name = params.name
        String visibility = params.visibility
        User user = session.user
        Topic topic = topicService.save(name,visibility,user)
        if (topic == null)
            render "Error in saving topic"
        else
            render "Topic Saved Successfully"
    }
    def delete()
    {
        Long id = Long.parseLong(params.id)
        topicService.delete(id)
        render "Topic deleted Successfully"
    }
    def show()
    {
        ResourceSearchCO co = new ResourceSearchCO()
        co.topicId = params.topicId
        co.max = params.max
        co.offset = params.offset
        co.order = params.order
        co.q = params.q
        co.sort = params.sort
        if (co.validate())
        {
            List<Resource> resources = Resource.namedQueries(co).find
        }
        else {
            user.errors.allErrors.each{
                render it
            }
        }
    }
}
