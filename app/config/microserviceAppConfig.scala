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

package config

import play.api.Play.{configuration, current}
import uk.gov.hmrc.play.config.ServicesConfig

trait AppConfig {
  val getRegistrationDetailsURL: String
  val safeIDQuery: String
  val desEnvironment: String
  val desToken: String
  val submissionURL: String
  val authURL: String
  val authorityURL: String
  val throttleThreshold: Int
}

object MicroserviceAppConfig extends AppConfig with ServicesConfig {

  private def loadConfig(key: String) = configuration.getString(key).getOrElse(throw new Exception(s"Missing configuration key: $key"))
  override lazy val getRegistrationDetailsURL = loadConfig("get-registration-details.url")
  override lazy val safeIDQuery = loadConfig("get-registration-details.safeid")
  override lazy val desEnvironment = loadConfig("microservice.services.des.environment")
  override lazy val desToken = loadConfig("microservice.services.des.token")
  override lazy val submissionURL = baseUrl("des")
  override lazy val authURL = baseUrl("auth")
  override lazy val authorityURL = loadConfig("authority.url")
  override lazy val throttleThreshold = getConfInt("throttle.threshold", throw new Exception("throttle-threshold not found in config"))
}
