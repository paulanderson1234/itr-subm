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

package controllers

import metrics.MetricsEnum
import play.api.libs.json.Json
import play.api.mvc.{Action, AnyContent}
import uk.gov.hmrc.play.microservice.controller.BaseController
import services.{AuditService, ThrottleService}
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

object ThrottleController extends ThrottleController{
  val auditService = AuditService
  override val throttleService = ThrottleService
}

trait ThrottleController extends BaseController{

  val auditService : AuditService
  val throttleService : ThrottleService

  def checkUserAccess(): Action[AnyContent] = Action.async {
    implicit request =>
      val timerContext = AuditService.metrics.startTimer(MetricsEnum.TAVC_USERACCESS)

      throttleService.checkUserAccess map{
        timerContext.stop()
        result => Ok(Json.toJson(result))
      }
  }

}
