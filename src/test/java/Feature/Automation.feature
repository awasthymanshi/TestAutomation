Feature: To automate the ebay website page

  @TC01Ebay
  Scenario: To open the browser and add items to cart
    Given Browser is launched and url is opened
    And Search for element
    And Select the first option from list
    And click on add to cart button
    Then verify cart has been updated

  @TC02
  Scenario Outline: Automation of get request on "<api>"
    Given Send GET request on "<api>"
    Then Verify response

    Examples:
      | api                                        |
      | https://api.coindesk.com/v1/bpi/currentprice.json  |
