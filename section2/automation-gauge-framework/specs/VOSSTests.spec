# Voss Specification
Tags: voss, web

## Ultimate QA Test - Login
Tags: ultimate_qa_test_login

* User goes to ultimate qa page
* Validate Page title is "Automation Practice - Ultimate QA"
* Take a screenshot with the name "Landing Page".
* Maximize browser
* Click "Login automation" link
* Validate login page is displayed
* Enter email "zainglenn1995@gmail.com" and password "T3sting!23"
* Click 'Sign In' button
* Solve capture problem
* Validate home page is displayed for user "Zain G"
* Logout

## Ultimate QA Test - Fill Forms
Tags: ultimate_qa_test_form

* User goes to ultimate qa page
* Click "Fill out forms" link
* Click Submit on left form
* Validate name and message is required field on left form
* Complete form on left
    |key    | message                 |
    |-------|-------------------------|
    |name   | zains left message      |
    |message| this is my left message |
* Click Submit on right form
* Validate name and message is required field on right form
* Complete form on right
    |key    | message                 |
    |-------|-------------------------|
    |name   | zains left message      |
    |message| this is my left message |
* Solve math problem
* Click Submit on left form
* Validate left form fails to submit
* Click Submit on right form
* Validate right form fails to submit

## Ultimate QA Test - Purchase Package
Tags: ultimate_qa_test_purchase

* User goes to ultimate qa page
* Click "Fake Pricing Page" link
* Validate Fake pricing page is open
* Validate package "Basic" is valued at "$80"/month
* Click purchase on package tier named - "Basic"
* Fail test - "Feature incomplete Basic button has no action"
___
* Shut down browser