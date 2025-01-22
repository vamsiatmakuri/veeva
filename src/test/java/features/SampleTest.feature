Feature: CP Home Page and DP1 Home

  @Test001
  Scenario: Verify the total number of video feeds on the news and features page
    When click on "<cphomepage>" 
    And click on news and features page
    Then verify the number of videos feeds and its count


