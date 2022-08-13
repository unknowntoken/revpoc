import com.google.gson.Gson
import com.rev.models.echo.EchoRequestModel
import com.rev.models.echo.EchoResponseModel
import com.rev.services.EchoService
import spock.lang.Specification

public class EchoServiceSpec extends Specification {
    def echoService = new EchoService();
    def testString = "Test string. Hi!"
    def validJsonRequest = new Gson().toJson(new EchoRequestModel(testString))

    def "Should return EchoResponseModel when passed a JSON string of validJsonRequest"() {
        given:
            def result = new EchoResponseModel(null);
        when:
            result = echoService.getEchoResponseModel(validJsonRequest)

        then:
            result.getYourString() == testString
    }

}