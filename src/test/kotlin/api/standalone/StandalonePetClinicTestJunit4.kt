package api.standalone

import io.restassured.RestAssured.given
import org.junit.*
import org.junit.internal.TextListener
import org.junit.runner.Description
import org.junit.runner.Result
import org.junit.runner.RunWith
import org.junit.runner.notification.Failure
import org.junit.runner.notification.RunListener
import org.junit.runner.notification.RunNotifier
import org.junit.runners.*
import org.junit.runners.model.*


//@RunWith(TestRunner::class)
class StandalonePetClinicTestJunit4 {

   var petclinicUrl = "http://localhost:8080"

//    @Before
//    fun before() {
//        println("Before")
//
//    }

    companion object {
        @JvmStatic
        @BeforeClass
        fun beforeClassFirst() {
            println("BeforeClass")
            given().get("http://localhost:8080/")

        }

//        @JvmStatic
//        @AfterClass
//        fun afterClass() {
//            println("AfterClass")
//            given().get("http://localhost:8080/owners/4/edit")
//        }
    }

//    @Before
//    fun beforeEachTest(){
//       /// given().get("$petclinicUrl/vets")
//    }

//    @After
//    fun afterEachTest(){
//        given().get("$petclinicUrl/vets")
//    }


    @Test
    fun getOwner4InfoPage() {
        given().get("$petclinicUrl/owners/4").then().statusCode(400)
        println("Test")
    }

//    @Test
//    fun getOwner4EditPage() {
//        assert(true)
//        ///given().get("$petclinicUrl/owners/4/edit").then().statusCode(200)
//    }


//    @Ignore
//    @Test
//    fun getVetsPage() {
//        given().get("$petclinicUrl/vets")
//    }

    @Test
    fun getHomePage() {
        given().get("$petclinicUrl/")
        println("Test")
    }

//    @Ignore
//    @Test
//    fun getErrorPage() {
//        given().get("$petclinicUrl/oups")
//    }
}


class Listener() : org.junit.runner.notification.RunListener (){

    override fun testRunStarted(description: Description?) {
        println("BeforeAll ${description?.displayName} started ")
    }

    override fun testStarted(description: Description?) {
        println("${description?.displayName} started")

    }

    override fun testAssumptionFailure(failure: Failure?) {
        println("testAssumptionFailure")


    }

    override fun testRunFinished(result: Result?) {
        println("AfterAll ${result} started ")

    }

    override fun testFailure(failure: Failure?) {
        println("testFailure")
    }

    override fun testFinished(description: Description?) {
        println("${description?.displayName} testFinished")
    }

    override fun testIgnored(description: Description?) {
        println("${description?.displayName} testIgnored")
    }
}

class TestRunner(klass: Class<*>?) : BlockJUnit4ClassRunner(klass) {
    private val seleniumRunListener: Listener = Listener()

    override fun run(notifier: RunNotifier) {
        notifier.addListener(seleniumRunListener)
        //notifier.addListener(TextListener(System.out))
        super.run(notifier)
    }

}

