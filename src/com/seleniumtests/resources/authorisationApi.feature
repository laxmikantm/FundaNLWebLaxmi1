@API
Feature: Perform API health check

  As a end user
  I should be able to perform basic operations on the API products
  In order to check that if api end points are up and running

  @API
  Scenario: Authorisation API status code check
  Given I am logged onto the UAT environment
  When I send get request to authorisation Api
  Then I should get ¨200¨ status code