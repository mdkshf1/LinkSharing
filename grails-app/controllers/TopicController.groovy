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
        else {
            render "Topic Saved Successfully"
            createLinkResource(topic)
            createDocumentResource(topic)
        }
    }
    def delete()
    {
        Long id =  Long.parseLong(params.id)
        topicService.delete(id)
        render "Topic deleted Successfully"
    }
    def show()
    {
        ResourceSearchCO co = new ResourceSearchCO()
        co.topicId = Long.parseLong(params.topicId)
        log.info("Topic id inside is as "+co.topicId,params.topicId)
        co.max = 5 //params.max
        co.offset = 0  //params.offset
        //co.order = params.order
        //co.q = params.q
        //co.sort = params.sort
        List<Resource> resources = Resource.search(co).list()
        if (resources)
        {
            render "Success -> resources are -: "+resources
        }
        else {
            render "No resources found for particular topic"
        }
        }

    def createDocumentResource(Topic topic) {
        DocumentResource documentResource1 = new DocumentResource();
        documentResource1.setTopic(topic)
        documentResource1.setCreatedBy(topic.createdBy)
        documentResource1.setDescription(topic.name)
        documentResource1.setFilePath("/abc/xyz.${topic.name}")
        documentResource1.validate()
        if (documentResource1.hasErrors()) {
            log.info("Error in saving document Resource 1 for Topic 1")
            log.info("Errors are " + documentResource1.errors)
        } else {
            documentResource1.save()
            log.info("Document Resource 1 has been saved")
        }
        DocumentResource documentResource2 = new DocumentResource();
        documentResource2.setTopic(topic)
        documentResource2.setCreatedBy(topic.createdBy)
        documentResource2.setDescription(topic.name)
        documentResource2.setFilePath("/abc/xyz.${topic.createdBy.userName}")
        documentResource2.validate()
        if (documentResource2.hasErrors()) {
            log.info("Error in saving document Resource 2 for Topic 1")
            log.info("Errors are " + documentResource2.errors)
        } else {
            documentResource2.save()
            log.info("Document Resource 2 has been saved")
        }
    }
    def createLinkResource(Topic topic) {
        LinkResource linkResource1 = new LinkResource()
        linkResource1.setTopic(topic)
        linkResource1.setDescription(topic.name)
        linkResource1.setCreatedBy(topic.createdBy)
        linkResource1.setUrl("https://www.${topic.dateCreated}.com")
        if (linkResource1.hasErrors()) {
            log.info("Error in saving link Resource 1 for Topic 1")
            log.info("Errors are " + linkResource1.errors)
        } else {
            linkResource1.save()
            log.info("Link Resource 1 has been saved")
        }
        LinkResource linkResource2 = new LinkResource()
        linkResource2.setTopic(topic)
        linkResource2.setDescription(topic.name)
        linkResource2.setCreatedBy(topic.createdBy)
        linkResource2.setUrl("https://www.${topic.lastUpdated}.com/")
        if (linkResource2.hasErrors()) {
            log.info("Error in saving link Resource 2 for Topic 1")
            log.info("Errors are " + linkResource2.errors)
        } else {
            linkResource2.save()
            log.info("Link Resource 2 has been saved")
        }
    }

    }