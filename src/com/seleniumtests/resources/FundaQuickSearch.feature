@runX
Feature: Perform quick search on Funda.nl properties website homepage

	As a end user
	I should be able to perform quick search on Funda.nl homepage
	In order to reterive search result based on criteria specified.

Scenario: Searching for apartment in Netherland cities
    Given I am on the Funda Home Page
	When I search for "Den Haag" location
	Then I should be shown with the result for the specificed criteria