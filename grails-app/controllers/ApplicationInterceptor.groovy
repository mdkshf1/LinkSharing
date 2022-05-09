/*
package linksharing

import ch.qos.logback.core.joran.conditional.IfAction


class ApplicationInterceptor {
    public ApplicationInterceptor
    {
        match controller:"Login" , action : 'loginHandler'
        match controller:"Login" , action : 'logoutAction'
        match controller: "user", action: "index"
        match controller: "Util", action: "index"
    }

    boolean before() {
        if (session.user)
        {
            return true
        }
        else {
            return false
        }
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
*/
