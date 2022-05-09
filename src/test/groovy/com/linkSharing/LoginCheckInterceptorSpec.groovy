package com.linkSharing

import grails.testing.web.interceptor.InterceptorUnitTest
import linksharing.ApplicationInterceptor
import spock.lang.Specification

class LoginCheckInterceptorSpec extends Specification implements InterceptorUnitTest<ApplicationInterceptor.LoginCheckInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test loginCheck interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"loginCheck")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
