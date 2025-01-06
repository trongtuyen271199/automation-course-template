# @Ignore
Feature: Login functionality cucumber

  Scenario Outline: Login case
    Given the user is on the homepage
    When user enters email "<email>"
    And user enters password "<pass>"
    And user submit login
    Then verify login erro email "<expectedMessageErroEmail>"
    Then verify login null mail "<expectedMessageNullEmail>"
    Then verify login erro password "<expectedMessageErroPass>"
    Then verify login null pass "<expectedMessageNullPass>"
    Then verify login null email and pass "<expectedMessageNullEmailAndPass>"
    Then verify login successfully "<expected>"
    # Then user submit logout

    Examples: Page titles
      | email                          | pass            | expected | expectedMessageErroEmail | expectedMessageNullEmail | expectedMessageErroPass | expectedMessageNullPass | expectedMessageNullEmailAndPass |
      | trongtuyen451@gmail.com        | Admin@123456    | true     | false                    | false                    | false                   | false                   | false                           |
      | trongtuyentestfailse@gmail.com | Admin@123456    | false    | true                     | false                    | false                   | false                   | false                           |
      |                                | Admin@123456    | false    | false                    | true                     | false                   | false                   | true                            |
      | trongtuyen451@gmail.com        | Adminpassfailse | false    | false                    | false                    | true                    | false                   | false                           |
      | trongtuyen451@gmail.com        |                 | false    | false                    | false                    | false                   | true                    | false                           |
      |                                |                 | false    | false                    | true                     | false                   | false                   | true                            |
