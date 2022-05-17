import enums.Visibility
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LoginController {
    //public static final Logger log = LoggerFactory.getLogger(this)
    UserService userService;
    def index()
    {
        if (!session.user)
            render "User session not found/Failure"
        //redirect(controller: "User",action: "index")
        if (session.user) {
            if (flash.error)
                render flash.error
            if (params.topicId == null)
                render "Give Topic Id to get a topic"
            Topic topic = Topic.read(params.topicId)
            if (topic == null) {
                flash.error = "Topic with this id cannot be found"
                forward(action: "index")
            }
            log.info("Topic is found")
            if (topic.visibility == Visibility.PUBLIC)
                render "Success"
                else if (topic.visibility == Visibility.PRIVATE){
                Set<Subscription> subscriptions = topic.subscriptions
                subscriptions.forEach(subscription ->
                {
                    if (subscription.user == session.user){
                        render "Success for private access"
                    }
                })
                flash.error = "You are not subscribed to this topic"
                forward(action: "index")
            }
            else {
                render "Failed to show topic"
            }
        }
    }
    def loginHandler()
    {
        if (params.userName == null || params.password == null)
        {
            render "Please Enter name and Password for the use to login"
        }
        User user = userService.getUserforLogin(params.userName,params.password)
        if (user == null)
        {
            flash.error = "User not found please provide correct username and password"
            forward(action: "action")
        }
        if (user.isActive)
        {
            log.info("Authentication Successful")
            session.user = user
            render "Session name is " +session.user
        }
        else {
            flash.error = "User is not Active"
            redirect(action:  "loginHandler")
        }
    }
    def logoutAction()
    {
        session.invalidate()
        forward(action: "index")
    }
    def action()
    {
        render flash.error
    }
    def register()
    {
        User user = new User()
        if (params.confirmPassword != params.password)
            render "Password and confirm password does not match"
        user.firstName = params.firstName
        user.lastName = params.lastName
        user.email = params.email
        user.userName = params.userName
        user.password = params.password
        user.confirmPassword = params.confirmPassword
        user.isAdmin = false
        user.isActive = true
        if (user.validate())
        {
            user.save()
            render "User saved Successfully"
        }
        else {
            user.errors.allErrors.each{
                //it k functions ek chota sa error message k lye
                render it
            }
        }
    }
    def log()
    {
        render(view : 'login')
    }
    def reg()
    {
        render(view: 'layoutpage')
    }
    def forgotPassword()
    {
        render "Forget Password Page"
    }
}
