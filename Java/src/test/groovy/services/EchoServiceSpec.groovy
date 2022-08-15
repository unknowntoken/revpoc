package services

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.rev.models.echo.EchoRequestModel
import com.rev.models.echo.EchoResponseModel
import com.rev.services.EchoService
import spock.lang.Specification

class EchoServiceSpec extends Specification {
    //Feature under testing
    def echoService = new EchoService();

    def "Method processEchoRequest should return EchoResponseModel when passed a valid EchoResponseModel"() {

        when:
            def result = echoService.processEchoRequest(new EchoRequestModel(testStrings))
        then:
            println testStrings
            result.getYourString() == testStrings
        where:
            testStrings         ||_
            "process echo req"  ||_
            "Testing process!"  ||_
    }

    def "Method getEchoRequestModelFromReqBody should return valid EchoRequestModel with my-string field " () {
        def input = new EchoRequestModel(testStrings)
        when:
            def reqModel = echoService.getEchoRequestModelFromReqBody(new Gson().toJson(input))
        then:
            println testStrings
            reqModel.getMyString() == testStrings
        where:
            testStrings         ||_
            "From json to echo" ||_
            "Testing conversion"||_
    }
    def "Method getEchoRequestModelFromReqBody should throw Exception on invalid json string" (){
        when:
            echoService.getEchoRequestModelFromReqBody("invalidJson")
        then:
            thrown JsonSyntaxException

    }

    def "Method getEchoRequestModelFromReqBody should throw NullPointerException on null input"(){
        when:
            echoService.getEchoRequestModelFromReqBody(null)
        then:
            thrown NullPointerException

    }

    def "Method getEchoRequestModelFromReqBody should throw Exception on valid Json but valid object"(){
        when:
            echoService.getEchoRequestModelFromReqBody("{}")
        then:
            thrown Exception
    }

    def "Method getEchoRequestModelFromReqBody should throw Exception on valid Json but field my-string is empty"(){
        def input = new EchoRequestModel("");
        when:
            echoService.getEchoRequestModelFromReqBody(new Gson().toJson(input))
        then:
        thrown Exception
    }

}