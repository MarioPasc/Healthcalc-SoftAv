@tag
Feature: Ideal Weight Calculation

"As a Healthcalc User 
I want to input my gender and height into the calculator 
So I can calculate my ideal weight"

  @tag1
  Scenario Outline: Calculate ideal weight with valid parameters
    Given I am a HealthCalc user
    When I input my gender as "<gender>" and height as <height> into the calculator
    Then the calculator should calculate and display my ideal weight as <expected_ideal_weight>

    Examples:
      | gender | height | expected_ideal_weight |
      | m      | 170    | 65                    |
      | w      | 160    | 56                    |

  @tag2
  Scenario: Display error when input parameters are incorrect
    Given I am a HealthCalc user
    When I input my gender as "<gender>" and height as <height> into the calculator
    Then the calculator should raise an error

    Examples:
      | gender | height | error |
      | m      | 0      | True  |
      | w      | 0      | True  |
      | m      | -1     | True  |
      | w      | -1     | True  |
      | XXXX   | 170    | True  |
      
  @tag3
  Scenario: Display error when computed ideal weight is negative or zero 
    Given I am a HealthCalc user
    When I input my gender as "<gender>" and height as <height> into the calculator
    Then the ideal weight is negative or zero and the calculator should raise an error

    Examples:
      | gender | height  | error |
      | 'm'    | 1       | True  |
      | 'w'    | 1       | True  |

  @tag4
  Scenario: Display error when input height exceeds the max value admitted by the datatype
    Given I am a HealthCalc user
    When I input a height value that is too high for IdealWeight
    Then the calculator should throw an overflow error 
       
   

    