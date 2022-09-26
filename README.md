# Salesforce website testing diploma
Salesforce website is a CRM platform allowing customers 
to achieve maximum success and designed specifically 
for the tasks of sales, service, marketing, analysis and communication with your customers.

# libraries used in the project:
-selenium version 3.141.59;
-webdrivermanager version 5.2.0;
-testNG version 7.6.0;
-java faker version 1.0.2;
-log4j version 2.18.0;
-lombok version 1.18.24;

# CI
-Jenkins;

# Report
-Allure-report;

# Design Patterns:
-POM (Page Object Module)

# Check list
Salesforce website testing https://stroybaztorg2.my.salesforce.com

- Authorization
    * log in
    * log out
- Testing the Opportunity entity
    * create Opportunity entity
    * delete Opportunity entity
- Testing the Case entity
    * create Case entity 
    * update Case entity
    * delete Case entity
- Testing the Task entity
    * create Task entity
- Testing the Report 
    * create Report

# Running tests
-TestNG command to run: - mvn clean test
-Running tests by groups:
-      mvn clean test -DsuiteXmlFile=’SmokeTest.xml’ test
-      mvn clean test -DsuiteXmlFile=’NegativeTest.xml’ test
-To run tests from one class:
-      mvn clean test -Dtest=’LoginTest’ test
-To run one test from a class:
-      mvn clean test -Dtest=’LoginTest#positiveLoginTest’ test

