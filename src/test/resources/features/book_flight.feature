Feature: Booking Tiket Flight

  @test-flight
  Scenario: Booking ticket flight and logged in from booking form
    Given I open phptravel homepage
    When I open phptravel login page
    Then close the browser
