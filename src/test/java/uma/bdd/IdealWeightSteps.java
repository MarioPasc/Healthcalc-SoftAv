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
    private String exceptionMessage;

    @Before
    public void initialization() {
        this.height = 0;
        this.gender = ' ';
        this.calculatedIdealWeight = 0;
        this.healthcalc = null;
        this.error = false;
        this.exceptionMessage = "";
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
            this.exceptionMessage = e.getMessage().toLowerCase();
            error = true;
        }
    }

    @When("I input {int} as my height value, less or equal to zero AND my gender as {string}")
    public void i_input_as_my_height_value_less_or_equal_to_zero(int height, String gender) {
        char genderChar = gender.charAt(0); 
        this.gender = genderChar;
        this.height = height;
        try {
            calculatedIdealWeight = healthcalc.idealWeight(height, genderChar); 
        } catch (Exception e) {
            this.exceptionMessage = e.getMessage().toLowerCase();
            error = true;
        }
    }

    @When("I input a gender not recognized by the system")
    public void i_input_as_my_gender_not_recognized_by_the_system() {
        this.gender = 'X';
        this.height = 170;
        try {
            calculatedIdealWeight = healthcalc.idealWeight(this.height, this.gender); 
        } catch (Exception e) {
            this.exceptionMessage = e.getMessage().toLowerCase();
            error = true;
        }
    }

    @When("I input a height value that is too high for IdealWeight")
    public void i_input_a_height_value_that_is_too_high_for_idealweight() {
        try {
            calculatedIdealWeight = healthcalc.idealWeight(Integer.MAX_VALUE, 'm');
        } catch (Exception e) {
            this.exceptionMessage = e.getMessage().toLowerCase();        
        } 
    }

    @Then("the calculator should calculate and display my ideal weight as {float}")
    public void the_calculator_should_calculate_and_display_my_ideal_weight_as(float expectedIdealWeight) {
        Assertions.assertEquals(expectedIdealWeight, calculatedIdealWeight); 
    }

    @Then("the calculator should raise an error")
    public void the_calculator_should_raise_an_error() {
        // Se comprueba si la calculadora es capaz de mostrar un mensaje específico para estos
        // casos de error. 
        if ((this.exceptionMessage.contains("número positivo") || 
             this.exceptionMessage.contains("género debe ser"))) {
                this.error = true;
             }
        Assertions.assertTrue(error);
        
    }

    @Then("the ideal weight is negative or zero and the calculator should raise an error")
    public void the_ideal_weight_is_negative_or_zero_and_the_calculator_should_raise_an_error() {
        // Se comprueba si la calculadora es capaz de mostrar un mensaje específico para este
        // caso de error. 
        if (this.exceptionMessage.contains("peso ideal es cero o menor que cero.")) {
            this.error = true;
        }
        Assertions.assertTrue(error);

    }

    @Then("the calculator should throw an overflow error")
    public void the_calculator_should_throw_an_overflow_error() {
        // Se comprueba si la calculadora es capaz de mostrar un mensaje específico para este
        // caso de error. 
         if (this.exceptionMessage.contains("demasiado grande")) {
            this.error = true;
         }
        Assertions.assertTrue(error);
        
    }
}
