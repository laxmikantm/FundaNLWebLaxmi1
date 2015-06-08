@runY
Feature: login to OneFlow Parameterised

Scenario: Login to the OneFlow
    Given I am on the login page
    When I fill <username> and <password> on the login page
	And I click keyboard enter key in order to login
	Then the <status> should be shown	
	
	|username				| password			| status		|
	|IncorrectUsername		| InvalidPassword	| unsuccessful	|
	|SteeleVirginia			| challenge!		| successful	|