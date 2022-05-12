import CO.SearchCO

class User {
    String firstName
    String lastName
    String email
    String userName
    String password
    Boolean isActive
    Boolean isAdmin
    byte[] image
    Date dateCreated
    Date lastUpdated
    Set<Topic> topics
    Set<Subscription> subscriptions
    Set<ReadingItem> readingItems
    Set<Resource> resources
    static hasMany = [topics: Topic,subscriptions: Subscription,readingItems: ReadingItem,resources: Resource]
    static transients = ["fullName","confirmPassword"]
    String confirmPassword
    String getFullName()
    {
        return "${firstName} ${lastName}"
    }
    static constraints = {
        email unique : true, nullable : false, blank : false, email : true
        password size : 5..15, nullable : false, blank : false
        firstName nullable : false, blank : false
        lastName nullable : false, blank : false
        image nullable : true
        isActive nullable : true
        isAdmin nullable : true
        userName unique : true, nullable : false, blank : false
        image maxSize : 2*1024*1024
        //confirmPassword nullable : false
    }
    static mapping = {
        sort userName: "desc"
        readingItems lazy : false
    }

    //static fetchMode = [resources: "eager",readingItems: "eager"]

/*    def static getUnReadResources(User user)
    {
        def unreadResource = executeQuery("from resource r where")
    }*/


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}