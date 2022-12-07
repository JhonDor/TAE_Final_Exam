@mobileAutomation
Feature: Disney app testing
  As a Disney app user
  I want to navigate to some sections of the application

  Background:
    Given I am in the Dashboard screen


  Scenario: Verify Map screen
    Given I am in the Map screen
    Then The map screen and its elements should be displayed


  Scenario: Verify Category List
    Given I am in the Map screen
    When I tap on the Category List button
    Then All the categories, including Hotels option, should be displayed


  Scenario: Verify Menu screen
    Given I am in the menu screen
    When I scroll down
    Then All the categories in the menu screen are displayed


  Scenario: Verify Privacy & Legal screen
    Given I am in the menu screen
    When I scroll down
    And I select the Privacy & Legal option
    Then The Privacy & Legal options should be displayed

  Scenario: Verify add plans option
    When I select the add Plans option
    Then The Check Dining Availability option should be displayed