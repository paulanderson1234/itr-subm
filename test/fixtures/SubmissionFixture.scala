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

package fixtures
import play.api.libs.json.Json

trait SubmissionFixture {
  val validSubmitJsonAA = """{"submissionType":{"agentReferenceNumber":"AARN1234567","correspondenceDetails":{"contactName":{"name1":"nameOne","name2":"nameTwo"},"contactDetails":{"phoneNumber":"00000 000001","emailAddress":"test@test.com"},"contactAddress":{"addressLine1":"line 1","addressLine2":"Line 2","addressLine3":"Line 3","addressLine4":"Line 4","postalCode":"AA1 1AA","countryCode":"GB"}},"organisationType":"Limited","submission":{"advancedAssurance":{"schemeTypes":{"eis":true,"seis":false,"sitr":false,"vct":false},"trade":{"businessActivity":"Research And Development","baDescription":"Some nature of business description","marketInfo":{"newGeographicMarket":false,"newProductMarket":true},"dateTradeCommenced":"2001-12-01","annualCosts":{"annualCost":[{"periodEnding":"2005","operatingCost":{"amount":"101","currency":"GBP"},"researchAndDevelopmentCost":{"amount":"201","currency":"GBP"}},{"periodEnding":"2004","operatingCost":{"amount":"102","currency":"GBP"},"researchAndDevelopmentCost":{"amount":"202","currency":"GBP"}},{"periodEnding":"2003","operatingCost":{"amount":"103","currency":"GBP"},"researchAndDevelopmentCost":{"amount":"203","currency":"GBP"}}]},"annualTurnover":{"annualTurnover":[{"periodEnding":"2003","turnover":{"amount":"66","currency":"GBP"}},{"periodEnding":"2004","turnover":{"amount":"67","currency":"GBP"}},{"periodEnding":"2004","turnover":{"amount":"68","currency":"GBP"}},{"periodEnding":"2004","turnover":{"amount":"69","currency":"GBP"}},{"periodEnding":"2005","turnover":{"amount":"70","currency":"GBP"}}]}},"proposedInvestment":{"growthJustification":"It will help me invest in new equipment and R&D","unitType":"Shares","investmentAmount":{"amount":"250000","currency":"GBP"}},"subsidiaryPerformingTrade":{"ninetyPercentOwned":true,"companyDetails":{"organisationName":"Made up test subsidiary org name","ctUtr":"1234567891","crn":"11111112","companyAddress":{"addressLine1":"line 1","addressLine2":"Line 2","addressLine3":"Line 3","addressLine4":"Line 4","postalCode":"TF1 4NY","countryCode":"GB"}}},"knowledgeIntensive":{"skilledEmployeesConditionMet":true,"innovationConditionMet":"reason met","kiConditionMet":true},"organisation":{"utr":"1234567891","chrn":"2222222222","startDate":"2007-06-05","firstDateOfCommercialSale":"2009-04-01","orgDetails":{"organisationName":"my org name","ctUtr":"5555555555","crn":"crnvalue","companyAddress":{"addressLine1":"line 1","addressLine2":"Line 2","addressLine3":"Line 3","addressLine4":"Line 4","postalCode":"TF1 4NY","countryCode":"GB"}},"previousRFIs":{"previousRFI":[{"schemeType":"EIS","name":"Other 1","issueDate":"2003-02-01","amount":{"amount":"2000","currency":"GBP"},"amountSpent":{"amount":"19","currency":"GBP"}},{"schemeType":"EIS","name":"Other 2","issueDate":"2004-03-02","amount":{"amount":"5000","currency":"GBP"},"amountSpent":{"amount":"20","currency":"GBP"}},{"schemeType":"EIS","name":"Other 3","issueDate":"2006-05-04","amount":{"amount":"6000","currency":"GBP"},"amountSpent":{"amount":"21","currency":"GBP"}}]}}}}}}"""
  val validSubmissionJsValAA = Json.parse(validSubmitJsonAA)

  val validSubmitJsonCS = """{
                            |  "submissionType": {
                            |    "correspondenceDetails": {
                            |      "contactName": {
                            |        "name1": "Gerald McCaw"
                            |      },
                            |      "contactDetails": {
                            |        "emailAddress": "Gerald.McCaw@FunkyTown.com"
                            |      },
                            |      "contactAddress": {
                            |        "addressLine1": "38 UpperMarshall Street",
                            |        "addressLine2": "Post Box Aptms",
                            |        "postalCode": "SY4 9BN",
                            |        "countryCode": "GB"
                            |      }
                            |    },
                            |    "organisationType": "Limited",
                            |    "submission": {
                            |      "complianceStatement": {
                            |        "schemeType": "SEIS",
                            |        "trade": {
                            |          "businessActivity": "Preparing To Trade",
                            |          "baDescription": "Florist",
                            |          "dateTradeCommenced": "2017-01-21"
                            |        },
                            |        "investment": {
                            |          "growthJustification": "Investment Growth Justification",
                            |          "unitIssue": {
                            |            "description": "Investment Unit Issue description",
                            |            "dateOfIssue": "2012-12-11",
                            |            "unitType": "Shares",
                            |            "nominalValue": {
                            |              "amount": "55000",
                            |              "currency": "GBP"
                            |            },
                            |            "numberUnitsIssued": 3321,
                            |            "totalAmount": {
                            |              "amount": "213",
                            |              "currency": "GBP"
                            |            }
                            |          },
                            |          "organisationStatus": {
                            |            "numberOfFTEmployees": 100,
                            |            "shareOrLoanCapitalChanges": "Share Or Loan Capital Change",
                            |            "grossAssetBefore": {
                            |              "amount": "2450",
                            |              "currency": "GBP"
                            |            },
                            |            "grossAssetAfter": {
                            |              "amount": "3450",
                            |              "currency": "GBP"
                            |            }
                            |          }
                            |        },
                            |        "investorDetails": {
                            |          "investor": [
                            |            {
                            |              "investorType": "Named Investor",
                            |              "investorInfo": {
                            |                "investorDetails": {
                            |                  "companyDetails": {
                            |                    "organisationName": "Terry Tate's Automobiles",
                            |                    "companyAddress": {
                            |                      "addressLine1": "1 Weston Street",
                            |                      "addressLine2": "GrangeHall",
                            |                      "postalCode": "GH23 4WE",
                            |                      "countryCode": "GB"
                            |                    }
                            |                  }
                            |                },
                            |                "numberOfUnitsHeld": 324,
                            |                "investmentAmount": {
                            |                  "amount": "2356",
                            |                  "currency": "GBP"
                            |                }
                            |              }
                            |            }
                            |          ]
                            |        },
                            |        "repayments": {
                            |          "repayment": [
                            |            {
                            |              "repaymentDate": "2013-12-12",
                            |              "repaymentAmount": {
                            |                "amount": "2342",
                            |                "currency": "GBP"
                            |              },
                            |              "unitType": "Debentures",
                            |              "holdersName": {
                            |                "name1": "Jeffery Turner"
                            |              },
                            |              "subsidiaryName": "Sub name 1"
                            |            }
                            |          ]
                            |        },
                            |        "organisation": {
                            |          "startDate": "2012-03-31",
                            |          "orgDetails": {
                            |            "organisationName": "Sub name 1"
                            |          }
                            |        }
                            |      }
                            |    }
                            |  }
                            |}""".stripMargin
  val validSubmissionJsValCS = Json.parse(validSubmitJsonCS)


  val dummyTavcRef = "XDTAVC000544444"
  //lazy val validJs: JsValue = Json.toJson(targetSubmissionModel)

  val validSubmissionDetails =

    """{
      |"processingDate":"2015-09-22T10:30:06Z",
      |    "countReturned":"2",
      |    "countTotal":"2",
      |    "submissions":[
      |    {
      |      "formBundleNumber":"000000123456",
      |      "submissionType":"Compliance Statement",
      |      "submissionDate":"2015-09-22",
      |      "schemeType":[
      |      {
      |        "scheme":"EIS"
      |      },
      |      {
      |        "scheme":"UCT"
      |      }
      |      ],
      |      "status":"Received",
      |      "contactNoteReference":"003333333333"
      |    },
      |    {
      |      "formBundleNumber":"000000000000",
      |      "submissionType":"Advance Assurance",
      |      "submissionDate":"2015-09-22",
      |      "schemeType":[
      |      {
      |        "scheme":"EIS"
      |      },
      |      {
      |        "scheme":"UCT"
      |      }
      |      ],
      |      "status":"Rejected",
      |      "contactNoteReference":"003333333334"
      |    }
      |    ]
      |  }""".stripMargin

  val validSubmissionDetailsJsVal = Json.parse(validSubmissionDetails)
}
