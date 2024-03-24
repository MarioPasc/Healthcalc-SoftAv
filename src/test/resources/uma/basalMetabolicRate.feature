@tag
Feature: Basal Metabolic Rate Calculation

"As a nutritionist
I want to determine the basal metabolic rate of my client
So that I can elaborate a better diet plan for him/her"

  @tag1
  Scenario Outline: Calculate the basal metabolic rate with valid inputs
    Given I am a nutritionist
    When I input my clients <weight>, <age>, <height> and "<gender>" into the calculator
    Then the calculator should compute and display the basal metabolic rate as <expected_basal_metabolic_rate>

    Examples:
        | weight | age | height | gender | expected_basal_metabolic_rate |
        | 70     | 30  | 170    | m      | 1617.5                        |
        | 50     | 25  | 160    | w      | 1214.0                        |

  @tag2
  Scenario Outline: Display error when input parameters are incorrect
    Given I am a nutritionist
    When I input my clients <weight>, <age>, <height> and "<gender>" into the calculator
    Then the calculator should display specific error messages for each type of invalid input

    Examples:
        | weight | age  | height | gender | error |
        | 0      | 30   | 170    | m      | true  |
        | -50    | 25   | 160    | w      | true  |
        | 70     | 0    | 170    | m      | true  |
        | 50     | -25  | 160    | w      | true  |
        | 70     | 30   | 0      | m      | true  |
        | 50     | 25   | -160   | w      | true  |
        | 70     | 30   | 170    | XXXX   | true  |
  
  @tag3
  Scenario Outline: Display error when computed basal metabolic rate is negative or zero 
    Given I am a nutritionist
    When I input my clients <weight>, <age>, <height> and "<gender>" into the calculator
    Then the basal metabolic rate is negative or zero and the calculator should raise an error

    Examples:
      | weight | age  | height | gender | error |
      | 1      | 50   | 1      | m      | true  |
      | 1      | 50   | 1      | w      | true  |
    
  @tag4
  Scenario: Display error when numeric input parameters are too high: Age
    Given I am a nutritionist
    When I input an age value that is too high for BasalMetabolicRate
    Then the calculator should raise an overflow error 
    
  @tag4
  Scenario: Display error when numeric input parameters are too high: Height
    Given I am a nutritionist
    When I input a height value that is too high for BasalMetabolicRate
    Then the calculator should raise an overflow error

  @tag5
  Scenario: Display error when numeric input parameters are too high: Weight
    Given I am a nutritionist
    When I input a weight value that is too high for BasalMetabolicRate
    Then the calculator should raise an overflow error


           
