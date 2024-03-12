package uma.bdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Before
    public void initialization() {
        height = 0;
        gender = ' ';
        calculatedIdealWeight = 0;
        healthcalc = null;
    }

    @Given("I am a HealthCalc user")
    public void i_am_a_HealthCalc_user() {
        healthcalc = new HealthCalcImpl();
    }

    @When("I input my gender as {string} and height as {int} into the calculator")
    public void i_input_my_gender_and_height_into_the_calculator(String gender, int height) {
        char genderChar = gender.charAt(0);
        this.gender = genderChar;
        this.height = height;
        try {
            calculatedIdealWeight = healthcalc.idealWeight(height, genderChar); 
        } catch (Exception e) {
            throw new AssertionError("Error inesperado al calcular el peso ideal: " + e.getMessage());
        }
    }


    @Then("the calculator should calculate and display my ideal weight as {float}")
    public void the_calculator_should_calculate_and_display_my_ideal_weight_as(float expectedIdealWeight) {
        assertEquals(expectedIdealWeight, calculatedIdealWeight); 
    }
}
