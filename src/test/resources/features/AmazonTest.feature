@Amazon
Feature: User can add a product

Scenario Outline: User is able to add product from second page


  Given User goes to www.amazon.com
  When They search for <Product>
  And navigate to the page number 2
  And select the item 3
  Then the user should be able to add the product to the cart

  Examples:
    | Product |
    |Alexa    |