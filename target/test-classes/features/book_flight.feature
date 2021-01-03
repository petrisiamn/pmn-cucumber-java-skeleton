Feature: Booking Tiket Flight

  @test-flight
  Scenario: Booking ticket flight and logged in from booking form
    Given I open phptravel homepage
    And I tap on Flight menu
    And I choose one way trip
    And I select "Business" class
    And I select "LAX" as Departure Airport
    And I select "MXP" as Destination Airport
    And I choose "3" adults and "2" child and "1" infant
    And I tap on search flight button
    And I will see flight search result
    When I tap on book button from first result flight
    And I tap Sign In from book flight page
    And I input email "user@phptravels.com"
    And I input password "demouser"
    And I fills passenger form
    And I will see booking summary for flight from "LAX" to "MXP"
    And I tap on confirm flight booking
    And I tap on pay arraival
    Then I will see info "Your booking status is Reserved"
    And close the browser
