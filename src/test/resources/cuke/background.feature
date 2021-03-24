Feature: Search on Google

Background: 
Given I can open Google

Scenario: Searches for Kittens
	When I search for Kittens
	Then Google will give me Kittens
	
Scenario: Searches for Puppies
	When I search for Puppies
	Then Google will give me Puppies