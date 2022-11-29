@webAutomation
Feature: ESPN testing
  I want to create an account and navigate to other pages

  Background:
    Given I am in the ESPN website home page


  Scenario: Verify the Log in modal elements
    Given I am in the Log In modal
    Then The Log in modal, ESPN Logo, Log in button and Sign up button should be displayed

  Scenario: Verify Sign Up modal elements
    Given I am in the Log In modal
    When I click on the Sing Up button
    Then All the elements to do the sign up should be displayed

  Scenario: Create an account
    Given I am in the Log In modal
    When I click on the Sing Up button
    Then I create a new user

  Scenario: Navigate to WatchPage
    Given I created a new user
    When I go to the Watch page
    Then I validate all the elements are displayed
    And I should be able to return to the Home page

  Scenario: Verify Welcome texts when logged
    Given I created a new user
    When I move the mouse over the User Icon
    Then The welcome text is displayed and my name are displayed

  Scenario: Verify Welcome texts when logged out
    Given I created a new user
    When I log out
    Then The welcome text is displayed without my name


