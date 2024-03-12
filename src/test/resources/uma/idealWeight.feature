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


    