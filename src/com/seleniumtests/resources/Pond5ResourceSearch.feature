@runX
Feature: Search a Car related resource on the Pond5 web-portal

Scenario: Searching for car related resources
    Given I am on the Pond5 Home Page
    When I fill in <keyword> in search box
	And I click on Find button
	Then the search results for the "keyword" should be displayed
	And the search results page should have correct title & header
	And the search results page should have correct page footer
	And the search results page should have "filters"
	|Membership Type, Price Range, Resolution, FPS |
	
	|keyword				| 
	|Car					| 
	|Bus			| 
	|Sky |
	|Pop-band|