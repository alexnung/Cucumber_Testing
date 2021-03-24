Feature: store tests

Background:
Given I can open the store site

Scenario: checkout dress
When I add dress to basket
When I checkout
When I create account
Then purchase is complete
