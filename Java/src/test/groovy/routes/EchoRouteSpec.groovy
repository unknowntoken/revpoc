package routes

import com.google.gson.Gson
import com.rev.model.ApiResponse
import com.rev.model.echo.EchoRequestModel
import com.rev.model.echo.EchoResponseModel
import com.rev.routes.EchoRoute
import spark.Request
import spark.Response
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class EchoRouteSpec extends Specification {

    @Subject
    def echoRoute = new EchoRoute()

    Gson gson = new Gson()

    @Unroll
    def "Should return ApiResponse success with valid json, contentType and input: #inputStrings" (){
        given:
            def request = Mock(Request)
            def response = Mock(Response)
            request.contentType() >> "application/json"
            request.body() >>  gson.toJson(new EchoRequestModel(inputStrings))

        when:
            def respObject = echoRoute.handle(request,response)
        then:
            response.status(200)
            respObject instanceof ApiResponse
            def apiResponse = (ApiResponse) respObject
            apiResponse.getStatus() == ApiResponse.ResponseStatus.Success

            def echoResponseModel = (EchoResponseModel) apiResponse.getData()
            echoResponseModel instanceof EchoResponseModel
            echoResponseModel.getYourString() == inputStrings
        where:
            inputStrings ||_
            "hello" ||_
            "World" ||_
    }

    def "Return from .handle should be ApiResponse failure for valid json but invalid application context" (){
        given:
            def request = Mock(Request)
            def response = Mock(Response)
            request.contentType() >> "application/xml"
        when:
            def respObject = echoRoute.handle(request,response)
        then:
            respObject instanceof ApiResponse
            def apiResponse = (ApiResponse) respObject
            apiResponse.getStatus() == ApiResponse.ResponseStatus.Failure
            apiResponse.getMessage() == "Invalid content type"
            1*response.status(415)
    }

    def "Return from .handle should be ApiResponse failure for valid json but invalid body. Bad request" (){
        given:
            def request = Mock(Request)
            def response = Mock(Response)
            request.contentType() >> "application/json"
        when:
            def respObject = echoRoute.handle(request,response)
        then:
            respObject instanceof ApiResponse
            def apiResponse = (ApiResponse) respObject
            apiResponse.getStatus() == ApiResponse.ResponseStatus.Failure
            apiResponse.getMessage() == "Bad Request"
            1*response.status(400)
    }

}