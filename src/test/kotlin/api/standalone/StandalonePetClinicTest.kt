package api.standalone


import org.junit.jupiter.api.*
import io.restassured.RestAssured.given

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StandalonePetClinicTest {

    lateinit var petclinicUrl: String

    @BeforeAll
    fun beforeAll() {
        petclinicUrl = "http://localhost:8080"
//        given().get("$petclinicUrl/")
//        println("BeforeAll")
    }


//    @AfterEach
//    fun after() {
//        given().get("$petclinicUrl/owners/4/edit").then().statusCode(200)
//    }
//
    @Test
    fun getOwner4InfoPage() {
        given().get("$petclinicUrl/owners/4").then().statusCode(200)
    }

    @Test
    fun getOwner4EditPage() {
        given().get("$petclinicUrl/owners/4/edit").then().statusCode(200)
    }
//
//
//    @Disabled
//    @Test
//    fun getVetsPage() {
//        given().get("$petclinicUrl/vets")
//    }
//
//    @Test
//    fun getHomePage() {
//        given().get("$petclinicUrl/")
//    }
//
//    @Disabled
//    @Test
//    fun getErrorPage() {
//        given().get("$petclinicUrl/oups")
//    }
}


//TestExecutionListener
//class Listener5 : EngineExecutionListener {
//    override fun executionFinished(testDescriptor: TestDescriptor?, testExecutionResult: TestExecutionResult?) {
//        println("${testDescriptor?.uniqueId} finished")
//    }
//
//    override fun reportingEntryPublished(testDescriptor: TestDescriptor?, entry: ReportEntry?) {
//        println("${testDescriptor?.uniqueId} reportingEntryPublished")
//    }
//
//    override fun executionSkipped(testDescriptor: TestDescriptor?, reason: String?) {
//        println("${testDescriptor?.uniqueId} executionSkipped")
//    }
//
//    override fun executionStarted(testDescriptor: TestDescriptor?) {
//        println("${testDescriptor?.uniqueId} started")
//    }
//
//    override fun dynamicTestRegistered(testDescriptor: TestDescriptor?) {
//        println("${testDescriptor?.uniqueId} dynamicTestRegistered")
//    }
//
//}
