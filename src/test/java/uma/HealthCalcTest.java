package uma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

    private final HealthCalcImpl healthCalc = HealthCalcImpl.getInstance();

    // Tests para el método "idealWeight" de la clase HealthCalcImpl
    // Tests para valores de entrada negativos o igual a cero
    @Test
    @DisplayName("Test altura negativa para idealWeight")
    public void testAlturaNegativaIdealWeight() {
        assertThrows(IllegalArgumentException.class, 
        () -> new PersonaEspecifica(70, -5, 25, Gender.MALE), 
        "La altura debe ser un valor positivo y razonable.");
    }

    @Test
    @DisplayName("Test altura cero para idealWeight")
    public void testAlturaCeroIdealWeight() {
        assertThrows(IllegalArgumentException.class, 
        () -> new PersonaEspecifica(70, 0, 25, Gender.MALE), 
        "La altura debe ser un valor positivo y razonable.");
    }

    @Test
    @DisplayName("Test peso negativo para idealWeight")
    public void testPesoNegativoIdealWeight() {
        assertThrows(IllegalArgumentException.class, 
        () -> new PersonaEspecifica(-1, 170, 25, Gender.MALE), 
        "El peso debe ser un valor positivo y razonable.");
    }

    @Test
    @DisplayName("Test edad negativa para idealWeight")
    public void testEdadNegativaIdealWeight() {
        assertThrows(IllegalArgumentException.class, 
        () -> new PersonaEspecifica(70, 170, -1, Gender.MALE), 
        "La edad debe ser un valor positivo y razonable.");
    }

    // Tests para valores que desbordan el tipo de datos
    @Test
    @DisplayName("Test altura overflow para idealWeight")
    public void testAlturaOverflowIdealWeight() {
        assertThrows(IllegalArgumentException.class, 
        () -> new PersonaEspecifica(70, Integer.MAX_VALUE, 25, Gender.MALE), 
        "La altura debe ser un valor positivo y razonable.");
    }

    @Test
    @DisplayName("Test peso overflow para idealWeight")
    public void testPesoOverflowIdealWeight() {
        assertThrows(IllegalArgumentException.class, 
        () -> new PersonaEspecifica(Float.MAX_VALUE, 170, 25, Gender.MALE), 
        "El peso debe ser un valor positivo y razonable.");
    }

    @Test
    @DisplayName("Test edad overflow para idealWeight")
    public void testEdadOverflowIdealWeight() {
        assertThrows(IllegalArgumentException.class, 
        () -> new PersonaEspecifica(70, 170, Integer.MAX_VALUE, Gender.MALE), 
        "La edad debe ser un valor positivo y razonable.");
    }

    // Otros tests de parámetros de entrada no válidos
    @Test
    @DisplayName("Test género no válido para idealWeight")
    public void testGeneroNoValidoIdealWeight() {
        assertThrows(NullPointerException.class, 
        () -> new PersonaEspecifica(70, 170, 25, null), 
        "Género no reconocido.");
    }

    // TESTS CAJA BLANCA - Funcionamiento esperado interno del método idealWeight
    @Test
    @DisplayName("Test peso ideal hombre")
    public void testPesoIdealHombre() throws Exception {
        PersonaEspecifica persona = new PersonaEspecifica(70, 180, 25, Gender.MALE);
        float pesoIdealEsperado = 180 - 100 - (180 - 150) / 4f;
        assertEquals(pesoIdealEsperado, healthCalc.idealWeight(persona), 
        "El cálculo del peso ideal para hombre no es correcto.");
    }

    @Test
    @DisplayName("Test peso ideal mujer ")
    public void testPesoIdealMujer() throws Exception {
        PersonaEspecifica persona = new PersonaEspecifica(60, 180, 25, Gender.FEMALE);
        float pesoIdealEsperado = 180 - 100 - (180 - 150) / 2.5f;
        assertEquals(pesoIdealEsperado, healthCalc.idealWeight(persona), 
        "El cálculo del peso ideal para mujer no es correcto.");
    }

	// Tests para el método "basalMetabolicRate" de la clase HealthCalcImpl

	// Tests relacionados con parámetros negativos o igual a cero

	@Test
	@DisplayName("Test altura negativa basalMetabolicRate")
	public void testAlturaNegativaBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
		() -> new PersonaEspecifica(60, -1, 20, Gender.MALE), 
		"La altura debe ser un valor positivo y razonable.");
	}

	@Test
	@DisplayName("Test altura cero basalMetabolicRate")
	public void testAlturaCeroBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
		() -> new PersonaEspecifica(60, 0, 20, Gender.MALE), 
		"La altura debe ser un valor positivo y razonable.");
	}

	@Test
	@DisplayName("Test peso negativo basalMetabolicRate")
	public void testPesoNegativoBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
			() -> new PersonaEspecifica(-1, 170, 20, Gender.MALE), 
			"El peso debe ser un valor positivo y razonable.");
	}

	@Test
	@DisplayName("Test edad negativa basalMetabolicRate")
	public void testEdadNegativaBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
			() -> new PersonaEspecifica(60, 170, -1, Gender.MALE), 
			"La edad debe ser un valor positivo y razonable.");
	}

	// Tests para valores de entrada que desbordan el tipo de datos

	@Test
	@DisplayName("Test altura overflow para basalMetabolicRate")
	public void testAlturaOverflowBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
		() -> new PersonaEspecifica(60, Integer.MAX_VALUE, 20, Gender.MALE), 
		"La altura debe ser un valor positivo y razonable.");
	}

	@Test
	@DisplayName("Test peso overflow para basalMetabolicRate")
	public void testPesoOverflowBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
			() -> new PersonaEspecifica(Float.MAX_VALUE, 170, 20, Gender.MALE), 
			"El peso debe ser un valor positivo y razonable.");
	}

	@Test
	@DisplayName("Test edad overflow para basalMetabolicRate")
	public void testEdadOverflowBasalMetabolicRate() {
		assertThrows(IllegalArgumentException.class, 
			() -> new PersonaEspecifica(60, 170, Integer.MAX_VALUE, Gender.MALE), 
			"La edad debe ser un valor positivo y razonable.");
	}
	// Otros tests de parámetros de entrada no válidos

	@Test
	@DisplayName("Test género no válido para basalMetabolicRate")
	public void testGeneroNoValidoBasalMetabolicRate() {
		assertThrows(NullPointerException.class, 
		() -> new PersonaEspecifica(60, 170, 17, null), 
		"Género no reconocido.");
	}

	// TESTS CAJA BLANCA - Funcionamiento esperado interno del método basalMetabolicRate
	@Test
	@DisplayName("Test metabolismo basal mujer ")
	public void testMetabolismoBasalMujer() throws Exception {
		PersonaEspecifica persona = new PersonaEspecifica(60, 180, 20, Gender.FEMALE);
		float pesoIdealEsperado = 10 * persona.weight() + 6.25f * persona.height() - 5 * persona.age() - 161;
		assertEquals(pesoIdealEsperado, healthCalc.basalMetabolicRate(persona), 
		"El cálculo del metabolismo basal para mujer no es correcto.");
	}

	@Test
	@DisplayName("Test metabolismo basal hombre ")
	public void testMetabolismoBasalHombre() throws Exception {
		PersonaEspecifica persona = new PersonaEspecifica(60, 180, 20, Gender.MALE);
		float pesoIdealEsperado =  10 * persona.weight() + 6.25f * persona.height() - 5 * persona.age() + 5;
		assertEquals(pesoIdealEsperado, healthCalc.basalMetabolicRate(persona), 
		"El cálculo del metabolismo basal para hombre no es correcto.");
	}
}