$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("scenario-list.feature");
formatter.feature({
  "line": 1,
  "name": "A list of scenarios to test Cucumber redundancy check",
  "description": "",
  "id": "a-list-of-scenarios-to-test-cucumber-redundancy-check",
  "keyword": "Business Need"
});
formatter.scenario({
  "line": 3,
  "name": "Some made up steps",
  "description": "",
  "id": "a-list-of-scenarios-to-test-cucumber-redundancy-check;some-made-up-steps",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "a made up scenario",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I execute the scenario",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I am not going to check the result",
  "keyword": "Then "
});
formatter.match({
  "location": "StepImplementation.a_made_up_scenario()"
});
formatter.result({
  "duration": 139979454,
  "status": "passed"
});
formatter.match({
  "location": "StepImplementation.i_execute_the_scenario()"
});
formatter.result({
  "duration": 25683,
  "status": "passed"
});
formatter.match({
  "location": "StepImplementation.i_am_not_going_to_check_the_result()"
});
formatter.result({
  "duration": 27692,
  "status": "passed"
});
});