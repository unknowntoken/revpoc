import com.rev.ApplicationMain
import spark.Spark
import spark.route.HttpMethod
import spock.lang.Specification

class ApplicationMainSpec extends Specification {


    def "Main should setup routes which matchUri:/hello, acceptType:*/*, httpMethod:get"() {
        given:
            def app = new ApplicationMain()
            def matchUri = "/hello"
            def acceptType = "*/*"
            def httpMethod = HttpMethod.get

        when:
            app.main()

        then:
            def routes = Spark.routes()
                routes.stream().any {
                    it.getMatchUri() == matchUri &&
                    it.getAcceptType() == acceptType &&
                    it.getHttpMethod() == httpMethod
                }
    }

    def "Main should setup routes which matchUri:/echo, acceptType:application/json, httpMethod:post"() {
        given:
        def app = new ApplicationMain()
        def matchUri = "/echo"
        def acceptType = "application/json"
        def httpMethod = HttpMethod.post

        when:
        app.main()

        then:
        def routes = Spark.routes()
        routes.stream().any {
            it.getMatchUri() == matchUri &&
                    it.getAcceptType() == acceptType &&
                    it.getHttpMethod() == httpMethod
        }
    }
}
