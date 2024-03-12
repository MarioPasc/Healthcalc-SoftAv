package uma.bdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uma.HealthCalcImpl;


public class IdealWeightSteps {
    private int height;
    private char gender;
    private float calculatedIdealWeight;
    private HealthCalcImpl healthcalc; 
    private boolean error;

    @Before
    public void initialization() {
        height = 0;
        gender = ' ';
        calculatedIdealWeight = 0;
        healthcalc = null;
        error = false;
    }

    @Given("I am a HealthCalc user")
    public void i_am_a_HealthCalc_user() {
        healthcalc = new HealthCalcImpl();
    }

    @When("I input my gender as {string} and height as {int} into the calculator")
    public void i_input_my_gender_and_height_into_the_calculator(String gender, int height) {
        char genderChar = gender.charAt(0); // Parece que cucumber solo acepta {string}
        this.gender = genderChar;
        this.height = height;
        try {
            calculatedIdealWeight = healthcalc.idealWeight(height, genderChar); 
        } catch (Exception e) {
            error = true;
        }
    }

    @Then("the calculator should calculate and display my ideal weight as {float}")
    public void the_calculator_should_calculate_and_display_my_ideal_weight_as(float expectedIdealWeight) {
        Assertions.assertEquals(expectedIdealWeight, calculatedIdealWeight); 
    }

    @Then("the calculator should raise an error")
    public void the_calculator_should_raise_an_error() {
        Assertions.assertTrue(error);
    }

    @Then("the ideal weight is negative or zero and the calculator should raise an error")
    public void the_ideal_weight_is_negative_or_zero_and_the_calculator_should_raise_an_error() {
        Assertions.assertTrue(error);
    }
}
