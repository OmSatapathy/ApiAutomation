Feature: Validation of get method

  @GetUserDetails
  Scenario Outline: Send a valid Request to get user details

    Given I send a request to the URL to get user details
    Then the response will return status
    Examples:
      |id  |employee_salary|employee_name |employee_age  |message                                  |
      |1   |320800         |Tiger Nixon   |61            |Successfully! Record has been fetched.   |
