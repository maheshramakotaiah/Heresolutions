Feature: Application Links

  Scenario: Documentation page
    Given Verify the Links on Documentation page
     When I am on the Documentation page
     Then Validate all links on that page are loading
      And For each link validate if Angular has initialized
