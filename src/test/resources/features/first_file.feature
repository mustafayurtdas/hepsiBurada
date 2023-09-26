@first
Feature: My First Feature File

  @tc01 @smoke
  Scenario: TC01_search_for_iphone_on_the_google
    Given go to google
    When search for iphone
    Then verify iphone contins in the results
    And verify iphone contains on the title
    And close driver

  @tc02 @test
  Scenario: TC02_search_for_tesla_on_the_google
    Given go to google
    When search for "tesla"
    Then verify "tesla" contins in the results
    And verify "tesla" contains on the title
    And close driver