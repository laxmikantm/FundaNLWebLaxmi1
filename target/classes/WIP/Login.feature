@runX
Feature: login to OneFlow

  Scenario: Successful login to OneFlow
    Given I am on login page
    When I fill in username as "SteeleVirginia" and password as "challenge!" on login page
    And click on signin button
    Then I should be taken to the Landing page
    
