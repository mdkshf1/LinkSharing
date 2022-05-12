import enums.Visibility
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class BootStrap {
    public static final Logger log = LoggerFactory.getLogger(this)

    def init = { servletContext ->
        if (User.count() == 0) {
            createUsers()
        }
        if (Topic.count() == 0 && Resource.count() == 0) {
            createTopics()
        }

        //notSubscribedTopics()
        //subscribeTopics()
        println "notsubscribed topic"
        User user = User.findByUserName("normal.user")
        notSubscribedTopics(user)
        User user1 = User.findByUserName("dummy.user")
        notSubscribedTopics(user1)
    }

    def createUsers() {
        User adminUser = new User(firstName: 'Mohd', lastName: "Kashif", email: "mohdkashif1108@gmail.com", userName: "mdkshf", password: "123456",confirmPassword: "123456" ,isAdmin: true, isActive: true)
        adminUser.validate()
        if (adminUser.hasErrors()) {
            log.info("Error in saving admin User")
            log.info("Errors are " + adminUser.errors)
        } else {
            adminUser.save()
            log.info("Saving Admin User")
        }
        User normalUser = new User(firstName: 'normal', lastName: 'user', email: 'normaluser@gmail.com', userName: 'normal.user', password: '123456',confirmPassword: "123456", isAdmin: false, isActive: true)
        normalUser.validate()
        if (normalUser.hasErrors()) {
            log.info("Error in saving normal User")
            log.info("Errors are " + normalUser.errors)
        } else {
            normalUser.save()
            log.info("Saving Normal User")
        }
        User user = new User(firstName: 'Dummy', lastName: 'user', email: 'dummyuser@gmail.com', userName: 'dummy.user', password: '123456',confirmPassword: "123456", isAdmin: false, isActive: true)
        user.validate()
        if (user.hasErrors()) {
            log.info("Error in saving normal User")
            log.info("Errors are " + user.errors)
        } else {
            user.save()
            log.info("Saving Normal User")
        }
    }
    def createTopics() {
        User user = User.findByUserName("normal.user")
        log.info("User is " + user)
        Topic topic1 = new Topic(name: 'Groovy', visibility: Visibility.PUBLIC, createdBy: user)
        topic1.validate()
        if (topic1.hasErrors()) {
            log.info("Error in saving first default topic")
            log.info("Errors are " + topic1.errors)
        } else {
            topic1.save()
            createDocumentResource(topic1)
            createLinkResource(topic1)
            log.info("Topic 1 saved")
        }
        Topic topic2 = new Topic(name: 'Java', visibility: Visibility.PRIVATE, createdBy: user)
        topic2.validate()
        if (topic2.hasErrors()) {
            log.info("Error in saving Second default topic")
            log.info("Errors are " + topic2.errors)
        } else {
            topic2.save()
            log.info("Topic 2 saved")
        }

        Topic topic3 = new Topic(name: 'Grails', visibility: Visibility.PUBLIC, createdBy: user)
        topic3.validate()
        if (topic3.hasErrors()) {
            log.info("Error in saving Third default topic")
            log.info("Errors are " + topic3.errors)
        } else {
            topic3.save()
            log.info("Topic 3 saved")
        }
        Topic topic4 = new Topic(name: 'Gradle', visibility: Visibility.PUBLIC, createdBy: user)
        topic4.validate()
        if (topic4.hasErrors()) {
            log.info("Error in saving fourth default topic")
            log.info("Errors are " + topic4.errors)
        } else {
            topic4.save()
            log.info("Topic 4 saved")
        }
        Topic topic5 = new Topic(name: 'SpringBoot', visibility: Visibility.PRIVATE, createdBy: user)
        topic1.validate()
        if (topic5.hasErrors()) {
            log.info("Error in saving fifth default topic")
            log.info("Errors are " + topic5.errors)
        } else {
            topic5.save()
            log.info("Topic 5 saved")
        }
    }

    def createDocumentResource(Topic topic) {
        DocumentResource documentResource1 = new DocumentResource();
        documentResource1.setTopic(topic)
        documentResource1.setCreatedBy(topic.createdBy)
        documentResource1.setDescription(topic.name)
        documentResource1.setFilePath('/abc/xyz.file1.txt')
        documentResource1.validate()
        if (documentResource1.hasErrors()) {
            log.info("Error in saving document Resource 1 for Topic 1")
            log.info("Errors are " + documentResource1.errors)
        } else {
            documentResource1.save()
            createReadingItems(documentResource1,topic.createdBy)
            createResourceRatings(documentResource1)
            log.info("Document Resource 1 has been saved")
        }
        DocumentResource documentResource2 = new DocumentResource();
        documentResource2.setTopic(topic)
        documentResource2.setCreatedBy(topic.createdBy)
        documentResource2.setDescription(topic.name)
        documentResource2.setFilePath('/abc/xyz.file2.txt')
        documentResource2.validate()
        if (documentResource2.hasErrors()) {
            log.info("Error in saving document Resource 2 for Topic 1")
            log.info("Errors are " + documentResource2.errors)
        } else {
            documentResource2.save()
            createReadingItems(documentResource2,topic.createdBy)
            createResourceRatings(documentResource2)
            log.info("Document Resource 2 has been saved")
        }
    }
    def createLinkResource(Topic topic) {
        LinkResource linkResource1 = new LinkResource()
        linkResource1.setTopic(topic)
        linkResource1.setDescription(topic.name)
        linkResource1.setCreatedBy(topic.createdBy)
        linkResource1.setUrl("https://www.google.com/")
        if (linkResource1.hasErrors()) {
            log.info("Error in saving link Resource 1 for Topic 1")
            log.info("Errors are " + linkResource1.errors)
        } else {
            linkResource1.save()
            createReadingItems(linkResource1,topic.createdBy)
            createResourceRatings(linkResource1)
            log.info("Link Resource 1 has been saved")
        }
        LinkResource linkResource2 = new LinkResource()
        linkResource2.setTopic(topic)
        linkResource2.setDescription(topic.name)
        linkResource2.setCreatedBy(topic.createdBy)
        linkResource2.setUrl("https://www.google.com/")
        if (linkResource2.hasErrors()) {
            log.info("Error in saving link Resource 2 for Topic 1")
            log.info("Errors are " + linkResource2.errors)
        } else {
            linkResource2.save()
            createReadingItems(linkResource2,topic.createdBy)
            createResourceRatings(linkResource2)
            log.info("Link Resource 2 has been saved")
        }
    }

    def createReadingItems(Resource resource,User user)
    {
        ReadingItem readingItem = new ReadingItem()
        readingItem.setResource(resource)
        readingItem.setIsRead(false)
        readingItem.setUser(user)
        println "Item jo read m add ho rha hai"
        println readingItem
        readingItem.save()
    }
    def notSubscribedTopics(User user)
    {
        List<Resource> resources = Resource.findAll()
        List<Resource> userResources = user.resources as List
        println "User"
        println user.getFullName()
        println "All resources"
        println resources
        println "User ki resources"
        println userResources
        List<Resource> notReadCreated = resources - userResources
        println "Read wali items"
        println notReadCreated
        resources.forEach(resource ->
        {
            createResourceRatings(resource)
        })
        notReadCreated.forEach(resource ->
        {
            createReadingItems(resource,user)
            //createResourceRatings(resource)
        })
    }
    def createResourceRatings(Resource resource)
    {
        ResourceRating rating = new ResourceRating()
        Random random = new Random()
        int n = random.nextInt(6)
        rating.setResource(resource)
        rating.setCreatedBy(resource.topic.createdBy)
        rating.setScore(n)
        rating.save()
    }
    def destroy = {
    }
}
