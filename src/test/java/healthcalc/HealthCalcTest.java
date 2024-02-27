package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	private final HealthCalcImpl healthCalc = new HealthCalcImpl();
	
	// Tests para el método "idealWeight" de la clase HealthCalcImpl
	@Test
	@DisplayName("Test altura negativa")
	public void testAlturaNegativa() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.idealWeight(-5, 'm'), 
		"La altura debe ser un número positivo.");
	}

	@Test
	@DisplayName("Test altura cero")
	public void testAlturaCero() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.idealWeight(0, 'm'), 
		"La altura debe ser un número positivo.");
	}

	@Test
	@DisplayName("Test altura overflow")
	public void testAlturaOverflow() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.idealWeight(Integer.MAX_VALUE, 'm'), 
		"La altura proporcionada es demasiado grande.");
	}

	@Test
	@DisplayName("Test género no válido")
	public void testGeneroNoValido() {
		assertThrows(IllegalArgumentException.class, 
		() -> healthCalc.idealWeight(100, 'x'), 
		"El género debe ser 'm' (hombre) o 'w' (mujer).");
	}
}