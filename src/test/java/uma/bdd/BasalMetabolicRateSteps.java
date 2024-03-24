package uma.bdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uma.HealthCalcImpl;

public class BasalMetabolicRateSteps {
    private float weight;
    private int age;
    private int height;
    private char gender;
    private HealthCalcImpl healthCalc;
    private float calcBasalMetabolicRate;
    private boolean error;
    private String exceptionMessage;
    
    @Before
    public void initialization() {
        this.weight = .0f;
        this.age = 0;
        this.height = 0;
        this.gender = ' ';
        this.calcBasalMetabolicRate = .0f;
        this.healthCalc = null;
        this.error = false;
        this.exceptionMessage = "";
    }

    @Given("I am a nutritionist")
    public void i_am_a_nutritionist() {
        healthCalc = new HealthCalcImpl();
    }

    @When("I input my clients {float}, {int}, {int} and {string} into the calculator")
    public void i_input_my_clients_weight_height_age_and_gender_into_the_calculator(float weight, int age, int height, String gender){
        char genderChar = gender.charAt(0); 
        this.weight = weight;
        this.age = age;
        this.height = height;
        try {
            calcBasalMetabolicRate = healthCalc.basalMetabolicRate(weight, height, genderChar, age); 
        } catch (Exception e) {
            this.exceptionMessage = e.getMessage().toLowerCase();
        }
    }

    @When("I input an age value that is too high for BasalMetabolicRate")
    public void i_input_an_age_value_that_is_too_high_for_basalmetabolicrate() {
        try {
            calcBasalMetabolicRate = healthCalc.basalMetabolicRate(100, 170, 'm', Integer.MAX_VALUE);
        } catch (Exception e) {
            this.exceptionMessage = e.getMessage().toLowerCase();
        } 
    }

    @When("I input a height value that is too high for BasalMetabolicRate")
    public void i_input_a_height_value_that_is_too_high_for_basalmetabolicrate() {
        try {
            calcBasalMetabolicRate = healthCalc.basalMetabolicRate(100, Integer.MAX_VALUE, 'w', 40);
        } catch (Exception e) {
            this.exceptionMessage = e.getMessage().toLowerCase();
        } 
    }
    
    @When("I input a weight value that is too high for BasalMetabolicRate")
    public void i_input_a_weight_value_that_is_too_high_for_basalmetabolicrate() {
        try {
            calcBasalMetabolicRate = healthCalc.basalMetabolicRate(Float.MAX_VALUE, 170, 'm', 40);
        } catch (Exception e) {
            this.exceptionMessage = e.getMessage().toLowerCase();
        } 
    }

    @Then("the calculator should compute and display the basal metabolic rate as {float}") 
    public void the_calculator_should_compute_and_display_the_basal_metabolic_rate_as_bmr (float expectedBMR) {
        Assertions.assertEquals(expectedBMR, this.calcBasalMetabolicRate);
    }

    @Then("the calculator should display specific error messages for each type of invalid input")
    public void the_calculator_should_display_specific_error_messages_for_each_type_of_invalid_input() {
        if ((this.exceptionMessage.contains("debe ser un valor positivo") ||
             this.exceptionMessage.contains("género debe ser"))) {
            this.error = true;
        }
        Assertions.assertTrue(this.error);
    }

    @Then("the basal metabolic rate is negative or zero and the calculator should raise an error")
    public void the_basal_metabolic_rate_is_negative_or_zero_and_the_calculator_should_raise_an_error() {
        if (this.exceptionMessage.contains("es cero o menor que cero")) {
            this.error = true;
        }
        Assertions.assertTrue(this.error);
    }

    @Then("the calculator should raise an overflow error")
    public void the_calculator_should_raise_an_overflow_error() {
        if (this.exceptionMessage.contains("demasiado grande")) {
            this.error = true;
        }
        Assertions.assertTrue(this.error);
    }

}
