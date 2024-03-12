@tag
Feature: Ideal Weight Calculation

"As a Healthcalc User 
I want to input my gender and height into the calculator 
So I can calculate my ideal weight"

  @tag1
  Scenario Outline: Calculate ideal weight accurately
    Given I am a HealthCalc user
    When I input my gender as "<gender>" and height as <height> into the calculator
    Then the calculator should calculate and display my ideal weight as <expected_ideal_weight>

    Examples:
      | gender | height | expected_ideal_weight |
      | m      | 170    | 65                    |
      | w      | 160    | 56                    |

  @tag2
  Scenario: Wrong inputs 
    Given I am a HealthCalc user
    When I input my gender as "<gender>" and height as <height> into the calculator
    Then the calculator should raise an error

    Examples:
      | gender | height | error |
      | 'm'    | 0      | True  |
      | 'w'    | 0      | True  |
      | 'm'    | -1     | True  |
      | 'w'    | -1     | True  |
      | XXXX   | 170    | True  |
      
  @tag3
  Scenario: Ideal weight is negative or zero
    Given I am a HealthCalc user
    When I input my gender as "<gender>" and height as <height> into the calculator
    Then the ideal weight is negative or zero and the calculator should raise an error

    Examples:
      | gender | height  | error |
      | 'm'    | 50      | True  |
      | 'w'    | 50      | True  |
       
   

    