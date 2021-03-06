/*
 * Copyright 2017 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package services

import org.scalatest.BeforeAndAfterEach
import org.scalatest.mock.MockitoSugar
import uk.gov.hmrc.play.test.UnitSpec

class SeisAllowanceServiceSpec extends UnitSpec with MockitoSugar with BeforeAndAfterEach {

  val validAmountMax = 150000
  val invalidAmountBoundary = 150001
  val emptyAmount = 0

  def seisAllowanceCheckExceeds(investmentsTotalSinceStartDate: Int)(test: Boolean => Any) {
    val result = SeisAllowanceService.checkSeisAllowanceExceeded(investmentsTotalSinceStartDate)
    test(result)
  }

  "Sending a valid maximum amount for the investmentsTotalSinceStartDate" should {
    "return false" in {
      seisAllowanceCheckExceeds(validAmountMax)(
        result => {
          result shouldBe false
        }
      )
    }
  }

  "Sending an invalid amount above the maximum for the investmentsTotalSinceStartDate" should {
    "return true" in {
      seisAllowanceCheckExceeds(invalidAmountBoundary)(
        result => {
          result shouldBe true
        }
      )
    }
  }

  "Sending a zero amount for the investmentsTotalSinceStartDate should" should {
    "return false" in {
      seisAllowanceCheckExceeds(emptyAmount)(
        result => {
          result shouldBe false
        }
      )
    }
  }
}
