$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Pond5ResourceSearch.feature");
formatter.feature({
  "line": 2,
  "name": "Search a Car related resource on the Pond5 web-portal",
  "description": "",
  "id": "search-a-car-related-resource-on-the-pond5-web-portal",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@runX"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Searching for car related resources",
  "description": "",
  "id": "search-a-car-related-resource-on-the-pond5-web-portal;searching-for-car-related-resources",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I am on the Pond5 Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I fill in \u003ckeyword\u003e in search box",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I click on Find button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the search results for the \"keyword\" should be displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "the search results page should have correct title \u0026 header",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "the search results page should have correct page footer",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the search results page should have \"filters\"",
  "rows": [
    {
      "cells": [
        "Membership Type, Price Range, Resolution, FPS"
      ],
      "line": 12
    },
    {
      "cells": [
        "keyword"
      ],
      "line": 14
    },
    {
      "cells": [
        "Car"
      ],
      "line": 15
    },
    {
      "cells": [
        "Bus"
      ],
      "line": 16
    },
    {
      "cells": [
        "Sky"
      ],
      "line": 17
    },
    {
      "cells": [
        "Pop-band"
      ],
      "line": 18
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "WebDriverExcerciseBDD.landingPage()"
});
formatter.result({
  "duration": 512612162,
  "error_message": "java.lang.NullPointerException\r\n\tat com.seleniumtests.pageobject.BasePage.getBasePage(BasePage.java:39)\r\n\tat com.seleniumtests.test.WebDriverExcerciseBDD.landingPage(WebDriverExcerciseBDD.java:32)\r\n\tat ✽.Given I am on the Pond5 Home Page(Pond5ResourceSearch.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "WebDriverExcerciseBDD.i_fill_in_keyword_in_search_box()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "WebDriverExcerciseBDD.i_click_on_Find_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "keyword",
      "offset": 28
    }
  ],
  "location": "WebDriverExcerciseBDD.the_search_results_for_the_should_be_displayed(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "WebDriverExcerciseBDD.the_search_results_page_should_have_correct_title_header()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "WebDriverExcerciseBDD.the_search_results_page_should_have_correct_page_footer()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "filters",
      "offset": 37
    }
  ],
  "location": "WebDriverExcerciseBDD.the_search_results_page_should_have(String,DataTable)"
});
formatter.result({
  "status": "skipped"
});
});