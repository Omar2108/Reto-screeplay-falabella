Feature: Add product to cart

  Scenario: Randomly add 1 product to the shopping cart
    Given the user opens the falabella page and searches for a product
    When the user adds the product to the shopping cart randomly
    Then The user will be able to see the product and the quantity selected in the shopping cart.