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
    Then Different categories, including Hotels option, should be displayed