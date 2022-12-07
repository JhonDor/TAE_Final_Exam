@mobileAutomation
Feature: Disney app testing
  As a Disney app user
  I want to navigate to some sections of the application

  Background:
    Given I am in the Dashboard screen

  @mobileAutomation
  Scenario: Verify Map screen
    Given I am in the Map screen
    Then The map screen and its elements should be displayed

  @mobileAutomation
  Scenario: Verify Category List
    Given I am in the Map screen
    When I tap on the Category List button
    Then All the categories, including Hotels option, should be displayed

  @mobileAutomation
  Scenario: Verify Menu screen
    Given I am in the menu screen
    When I scroll down
    Then All the categories in the menu screen are displayed

  @mobileAutomation
  Scenario: Verify Privacy & Legal view
    Given I am in the menu screen
    When I scroll down
    And I select the Privacy & Legal option
    Then The Privacy & Legal options should be displayed

  @mobileAutomation
  Scenario: Verify add plans option
    When I select the add Plans option
    Then The Check Dining Availability option should be displayed