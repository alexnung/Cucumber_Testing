Feature: Search on Google

Background: 
Given I can open Google

Scenario Outline:
	When I search for <search>
	Then Google will give me <result>
	
 Examples:
    | search  | result  |
    | Kittens | Kittens |
    | Puppies | Puppies |