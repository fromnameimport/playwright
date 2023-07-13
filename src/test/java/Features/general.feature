Feature: test
  @functional
  Scenario: Verify login
    Given I open "Login" page
    Then I login with following credentials: username "Admin", password "admin123"
    And I verify that login is successful
  Scenario: Create, edit and delete post
    Given I go to "Buzz" page
    Then I create new post with following body: "Hi! It`s my new awesome post!"
    And I verify that new post is present
    Then I edit new post with following body: "Hi! It`s my edited awesome post!"
    And I verify that new post is edited
    Then I delete new post
    And I verify that new post is deleted
  Scenario: Search admin record
    Given I go to "Admin" page
    Then I open system user search
    And I search current admin record
    Then I verify search results for current admin
  Scenario: Create new user
    Given I go to "Save system user search" page
    Then I create new user with following credentials: username "Test123", password "test12345", employee name "Test", user role "ESS" and status "Enabled"
    Then I open system user search
    And I search user with following credentials: username "Test123", employee name "", user role "ESS" and status "Enabled"
    Then I verify search results for user with following credentials: username "Test123", user role "ESS" and status "Enabled"
  Scenario: Login with new user credentials
    Given I logged out
    Then I login with following credentials: username "Test123", password "test12345"
    And I verify that login is successful
    Then I logout
  Scenario: Delete new user
    Given I login with following credentials: username "Admin", password "admin123"
    Then I go to "Admin" page
    Then I search user with following credentials: username "Test123", employee name "", user role "ESS" and status "Enabled"
    And I delete searched user
  @accessibility
  Scenario: Pages accessibility
    Given I logged out
    Then I check the "Login" page for accessibility
    Then I login with following credentials: username "Admin", password "admin123"
    And I check the "Dashboard" page for accessibility
    Then I go to "Admin" page
    And I check the "Admin" page for accessibility
    Then I go to "Buzz" page
    And I check the "Buzz" page for accessibility