@hepsi_burada_test
Feature: HepsiBuradaTest

  Scenario: TC01_searching_for_iphone14
    Given go to "hepsi_burada_url"
    When search for "iphone 14"
    And go to product and click it
    And add to cart
    And click go to cart
    And click the "Alışveriş Kredisi" section
    Then verify "Alışveriş Kredisi"
    And click the "Karta taksit yapılamaz" section
    Then verify "Karta taksit yapılamaz"
    And click the Alışverişi tamamla button
    And close driver
