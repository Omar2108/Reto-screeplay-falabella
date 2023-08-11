Feature: Add product to cart

  Scenario: Add product to cart success
    Given the user opens the falabella page and searches for a product
    When the user adds the product to the shopping cart
    Then The user will be able to see the product and the quantity selected in the shopping cart.