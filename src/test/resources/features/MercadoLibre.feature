@TradeTest
  Feature: TradeMe UI and API Test
@dropdownTest
    Scenario: As an user I can see all the car makes in the Makes dropdown
      Given I navigate to MercadoLibre site
      And click on Categorías
      When click on vehiculos option
      And click on Makes dropdown
      Then I can see the total of 82 car makes

@Resultados
    Scenario Outline:
      Given I navigate to MercadoLibre site
      Given I navigate to MercadoLibre site
      And click on Categorías
      When click on vehiculos option
      And click on Makes dropdown
      When I click on <Make>
      And click on search
      Then I can see the <Amount> of results
      Examples:
          |Make| Amount|
          |Chevrolet|4000 |
          |Ferrari  |3     |
          |Mazda | 10 |