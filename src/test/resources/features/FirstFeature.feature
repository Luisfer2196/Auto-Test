Feature: Navigation Bar
  To see the subpages
  Without loggin in
  I can click in the navigation bar links

Background: I am on the Free Range Testers web without loggin in
  Given  I navigate to www.freerangertesters.com
 # Given The user navigates to www.freerangertesters.com
  # usando sintaxis para aplicar a mas de 1 valor

@Other
Scenario Outline: I can access the subpages through the navigation bar
#  Given I navigate to www.freerangertesters.com esto lo cubre el Background ya que es algo que se repite
  When I go to a <section> in the nav bar
  Then I am redirected to the right <section>
  Examples:
    | section |
    |Cursos    |
    |Recursos |
    |Udemy    |

@Cursos
  Scenario: Courses are presented to potential customers
    #  Given I navigate to www.freerangertesters.com esto lo cubre el Background ya que es algo que se repite
    When I go to a Cursos in the nav bar
    And select Introduccion al Testing
    And click on Comprar ahora
    Then I should see the course that I'm about to buy

@Plans
  Scenario: Users can select a plan when signing up
    #  Given I navigate to www.freerangertesters.com esto lo cubre el Background ya que es algo que se repite
    When I select Elegir Plan
    Then I can validate the options in the checkout page

