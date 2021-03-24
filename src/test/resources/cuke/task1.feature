Feature: DemoWebsite tests

Background:
Given I can open the demo site

Scenario Outline: Login
When I signup <User> <Password>
Then login successfully <User> <Password>

Examples:
| User | Password |
| Test1 | Test1		|
| Test2 | Test2		|