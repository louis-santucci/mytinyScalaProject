package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class HomeControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "HomeController GET" should {

    "render a page that prints the sum of tow numbers" in {
      val request = FakeRequest(GET, "/sum/10/20")
      val sumOfNumbers = route(app, request).get

      status(sumOfNumbers) mustBe OK
      contentType(sumOfNumbers) mustBe Some("text/html")
      contentAsString(sumOfNumbers) must include ("The sum is 30!")
    }
  }
}
