package uma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	private final HealthCalcImpl healthCalc = new HealthCalcImpl();
	
	// Tests para el método "idealWeight" de la clase HealthCalcImpl

	// Tests para valores de entrada negativos o igual a cero

	@Test
	@DisplayName("Test altura negativa para idealWeight")
	public void testAlturaNegativaIdealWeight() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.idealWeight(-5, 'm'), 
		"La altura debe ser un número positivo.");
	}

	@Test
	@DisplayName("Test altura cero para idealWeight")
	public void testAlturaCeroIdealWeight() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.idealWeight(0, 'm'), 
		"La altura debe ser un número positivo.");
	}

	@Test
	@DisplayName("Test peso ideal negativo para hombre -valor de salida")
	public void testPesoIdealNegativoHombre() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.idealWeight(50, 'm'), 
		"El peso debe ser un valor positivo.");
	}

	@Test
	@DisplayName("Test peso ideal negativo para mujer -valor de salida")
	public void testPesoIdealNegativoMujer() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.idealWeight(50, 'w'), 
		"El peso debe ser un valor positivo.");
	}

	// Tests para valores que desbordan el tipo de datos

	@Test
	@DisplayName("Test altura overflow para idealWeight")
	public void testAlturaOverflowIdealWeight() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.idealWeight(Integer.MAX_VALUE, 'm'), 
		"La altura proporcionada es demasiado grande.");
	}

	// Otros tests de parámetros de entrada no válidos

	@Test
	@DisplayName("Test género no válido para idealWeight")
	public void testGeneroNoValidoIdealWeight() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.idealWeight(100, 'x'), 
		"El género debe ser 'm' (hombre) o 'w' (mujer).");
	}

	// TESTS CAJA BLANCA - Funcionamiento esperado interno del método idealWeight
	@Test
    @DisplayName("Test peso ideal hombre")
    public void testPesoIdealHombre() throws Exception {
        int altura = 180;
        char genero = 'm';
        float pesoIdealEsperado = altura - 100 - (altura - 150) / 4f;
        assertEquals(pesoIdealEsperado, healthCalc.idealWeight(altura, genero), 
		"El cálculo del peso ideal para hombre no es correcto.");
    }

    @Test
    @DisplayName("Test peso ideal mujer ")
    public void testPesoIdealMujer() throws Exception {
        int altura = 180;
        char genero = 'w';
        float pesoIdealEsperado = altura - 100 - (altura - 150) / 2.5f;
        assertEquals(pesoIdealEsperado, healthCalc.idealWeight(altura, genero), 
		"El cálculo del peso ideal para mujer no es correcto.");
    }
	// Tests para el método "basalMetabolicRate" de la clase HealthCalcImpl

	// Tests relacionados con parámetros negativos o igual a cero

	@Test
	@DisplayName("Test altura negativa basalMetabolicRate")
	public void testAlturaNegativaBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.basalMetabolicRate(60, -1, 'm', 20), 
		"La altura debe ser un número positivo.");
	}

	@Test
	@DisplayName("Test altura cero basalMetabolicRate")
	public void testAlturaCeroBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.basalMetabolicRate(60, 0, 'm', 20), 
		"La altura debe ser un número positivo.");
	}

	@Test
	@DisplayName("Test peso negativo basalMetabolicRate")
	public void testPesoNegativoBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
			() -> healthCalc.basalMetabolicRate(-1, 170, 'm', 20), 
			"El peso debe ser un número positivo.");
	}

	@Test
	@DisplayName("Test edad negativa basalMetabolicRate")
	public void testEdadNegativaBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
			() -> healthCalc.basalMetabolicRate(60, 170, 'm', -1), 
			"La edad debe ser un número positivo.");
	}

	@Test
	@DisplayName("Test peso cero basalMetabolicRate")
	public void testPesoCeroBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
			() -> healthCalc.basalMetabolicRate(0, 170, 'm', 20), 
			"El peso debe ser un número positivo.");
	}

	@Test
	@DisplayName("Test edad cero basalMetabolicRate")
	public void testEdadCeroBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
			() -> healthCalc.basalMetabolicRate(60, 170, 'm', 0), 
			"La edad debe ser un número positivo.");
	}

	@Test
	@DisplayName("Test metabolismo basal negativo para hombre -valor de salida")
	public void testbasalMetabolicRateNegativoHombre() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.basalMetabolicRate(1, 1, 'M', 50), 
		"El metabolismo basal es cero o menor que cero.");
	}

	@Test
	@DisplayName("Test metabolismo basal negativo para hombre -valor de salida")
	public void testbasalMetabolicRateNegativoMujer() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.basalMetabolicRate(1, 1, 'w', 50), 
		"El metabolismo basal es cero o menor que cero.");
	}

	// Tests para valores de entrada que desbordan el tipo de datos

	@Test
	@DisplayName("Test altura overflow para basalMetabolicRate")
	public void testAlturaOverflowBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.basalMetabolicRate(60, Integer.MAX_VALUE, 'm', 20), 
		"La altura proporcionada es demasiado grande.");
	}

	@Test
	@DisplayName("Test peso overflow para basalMetabolicRate")
	public void testPesoOverflowBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
			() -> healthCalc.basalMetabolicRate(Float.MAX_VALUE, 170, 'm', 20), 
			"El peso proporcionado es demasiado grande.");
	}

	@Test
	@DisplayName("Test edad overflow para basalMetabolicRate")
	public void testEdadOverflowBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
			() -> healthCalc.basalMetabolicRate(60, 170, 'm', Integer.MAX_VALUE), 
			"La edad proporcionada es demasiado grande.");
	}

	// Otros tests de parámetros de entrada no válidos

	@Test
	@DisplayName("Test género no válido para basalMetabolicRate")
	public void testGeneroNoValidoBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.basalMetabolicRate(60, 170, 'X', 17), 
		"El género debe ser 'm' (hombre) o 'w' (mujer).");
	}

	// TESTS CAJA BLANCA - Funcionamiento esperado interno del método basalMetabolicRate
	@Test
    @DisplayName("Test metabolismo basal mujer ")
    public void testMetabolismoBasalMujer() throws Exception {
        int height = 180;
		float weight = 60;
		int age = 20;
        char genero = 'w';
        float pesoIdealEsperado = 10 * weight + 6.25f * height - 5 * age - 161;
        assertEquals(pesoIdealEsperado, healthCalc.basalMetabolicRate(weight, height, genero, age), 
		"El cálculo del metabolismo basal para mujer no es correcto.");
    }

	@Test
    @DisplayName("Test metabolismo basal mujer ")
    public void testMetabolismoBasalHombre() throws Exception {
        int height = 180;
		float weight = 60;
		int age = 20;
        char genero = 'm';
        float pesoIdealEsperado =  10 * weight + 6.25f * height - 5 * age + 5;
        assertEquals(pesoIdealEsperado, healthCalc.basalMetabolicRate(weight, height, genero, age), 
		"El cálculo del metabolismo basal para hombre no es correcto.");
    }





	
}