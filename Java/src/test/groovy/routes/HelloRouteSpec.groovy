package routes


import com.rev.models.ApiResponse
import com.rev.routes.HelloRoute
import spark.Request
import spark.Response
import spock.lang.Specification

class HelloRouteSpec extends Specification {

    def helloRoute = new HelloRoute();

    def "Any call should be wrapped by ApiResponse" (){
        given:
            def request = Mock(Request)
            def response = Mock(Response)
        when:
            def respObject = helloRoute.handle(request,response)
        then:
            respObject instanceof ApiResponse
    }

    def "Call to handle with any request should return HelloResponseModel in json format" (){
        given:
            Request request = Mock(Request)
            Response response = Mock(Response)
        when:
            helloRoute.handle(request,response)
        then:
            1*response.status(200)
    }

}