

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class UtilController {
    public static final Logger log = LoggerFactory.getLogger(this)
    def index()
    {
        log.info("WE are in utilController")
        render "Hello world"
    }
}
