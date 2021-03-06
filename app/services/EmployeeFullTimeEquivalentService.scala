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


import common.Constants
import play.api.Logger
import play.api.libs.json.Json
import play.api.mvc.Result
import play.api.mvc.Results._
import scala.util.{Failure, Success, Try}
import play.api.http.Status._

object EmployeeFullTimeEquivalenceService extends EmployeeFullTimeEquivalenceService{
  override val fullTimeEquivalenceSEISLimit = BigDecimal(Constants.fullTimeEquivalenceSEISLimit)
  override val fullTimeEquivalenceEISLimit = BigDecimal(Constants.fullTimeEquivalenceEISLimit)
  override val fullTimeEquivalenceEISWithKILimit = BigDecimal(Constants.fullTimeEquivalenceEISWithKILimit)
}

trait EmployeeFullTimeEquivalenceService{

  val fullTimeEquivalenceSEISLimit: BigDecimal
  val fullTimeEquivalenceEISLimit: BigDecimal
  val fullTimeEquivalenceEISWithKILimit: BigDecimal

  def checkFullTimeEquivalence(schemeType: String, numberOfFullTimeEquivalentEmployees: String): Result = {

    Try(BigDecimal(numberOfFullTimeEquivalentEmployees)) match{
      case Success(fte) => {
        if(fte.signum!= -1)
          Status(OK)(Json.toJson(checkFTE(schemeType, fte)))
        else
          Status(BAD_REQUEST)(Json.toJson(Map("error" -> "Invalid URL parameter",  "reason" -> "Negative Number")))
      }
      case Failure(_) => {
        Logger.warn(s"[EmployeeFullTimeEquivalentService] [checkFullTimeEquivalence] - Error converting URL parameter to 'BigDecimal'")
        Status(BAD_REQUEST)(Json.toJson(Map("error" -> "Invalid URL parameter", "reason" -> "Invalid Number")))
      }
    }
  }

  private def checkFTE(schemeType: String, numOfFullTimeEquivalence: BigDecimal): Boolean = {
    schemeType match {
      case Constants.schemeTypeEIS => numOfFullTimeEquivalence <= fullTimeEquivalenceEISLimit
      case Constants.schemeTypeSEIS => numOfFullTimeEquivalence <= fullTimeEquivalenceSEISLimit
      case Constants.schemeTypeEISWithKI => numOfFullTimeEquivalence <= fullTimeEquivalenceEISWithKILimit
      case _ => false
    }
  }
}
