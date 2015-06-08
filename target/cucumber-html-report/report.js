$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 2,
  "name": "login to OneFlow Parameterised",
  "description": "",
  "id": "login-to-oneflow-parameterised",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@runY"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Login to the OneFlow",
  "description": "",
  "id": "login-to-oneflow-parameterised;login-to-the-oneflow",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I am on the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I fill \u003cusername\u003e and \u003cpassword\u003e on the login page",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I click keyboard enter key in order to login",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the \u003cstatus\u003e should be shown",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "status"
      ],
      "line": 10
    },
    {
      "cells": [
        "IncorrectUsername",
        "InvalidPassword",
        "unsuccessful"
      ],
      "line": 11
    },
    {
      "cells": [
        "SteeleVirginia",
        "challenge!",
        "successful"
      ],
      "line": 12
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "WebDriverExcerciseBDD.login_page()"
});
formatter.result({
  "duration": 186806706,
  "error_message": "java.lang.NullPointerException\r\n\tat com.seleniumtests.pageobject.BasePage.getBasePage(BasePage.java:49)\r\n\tat com.seleniumtests.pageobject.LoginPage.getBasePage(LoginPage.java:37)\r\n\tat com.seleniumtests.test.WebDriverExcerciseBDD.login_page(WebDriverExcerciseBDD.java:41)\r\n\tat ✽.Given I am on the login page(Login.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "WebDriverExcerciseBDD.i_fill_username_and_password_on_the_login_page(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "WebDriverExcerciseBDD.i_click_keyboard_enter_key_in_order_to_login()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "WebDriverExcerciseBDD.the_status_should_be_shown()"
});
formatter.result({
  "status": "skipped"
});
});