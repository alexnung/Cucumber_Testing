$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/cuke/task2.feature");
formatter.feature({
  "line": 1,
  "name": "store tests",
  "description": "",
  "id": "store-tests",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1874263400,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "I can open the store site",
  "keyword": "Given "
});
formatter.match({
  "location": "Test2.i_can_open_the_store_site()"
});
formatter.result({
  "duration": 3345144200,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "checkout dress",
  "description": "",
  "id": "store-tests;checkout-dress",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I add dress to basket",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I checkout",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I create account",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "purchase is complete",
  "keyword": "Then "
});
formatter.match({
  "location": "Test2.i_add_dress_to_basket()"
});
formatter.result({
  "duration": 2956210200,
  "status": "passed"
});
formatter.match({
  "location": "Test2.i_checkout()"
});
formatter.result({
  "duration": 4217639100,
  "status": "passed"
});
formatter.match({
  "location": "Test2.i_create_account()"
});
formatter.result({
  "duration": 5095157900,
  "status": "passed"
});
formatter.match({
  "location": "Test2.purchase_is_complete()"
});
formatter.result({
  "duration": 14800,
  "status": "passed"
});
formatter.after({
  "duration": 705910100,
  "status": "passed"
});
});