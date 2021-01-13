
Feature: Search for product

  Scenario: Search by keyword
    Given Sharon is searching for product on Etsy
    When  she searches for 'Masks'
    Then  she should only see products related to 'Mask'

  @current
    Scenario: Display product details
      Given Sharon performed a search for 'Mask'
      When  she views the details of listed item
      Then  the correct details for the listed item should be displayed