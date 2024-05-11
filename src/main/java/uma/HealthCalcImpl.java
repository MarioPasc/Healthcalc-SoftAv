package uma;

public class HealthCalcImpl implements HealthCalc {
    // Patrón Singleton Aplicado
    private static HealthCalcImpl instance;

    private HealthCalcImpl() {}

    public static HealthCalcImpl getInstance() {
        if (instance == null) {
            instance = new HealthCalcImpl();
        }
        return instance;
    }

    @Override
    public float idealWeight(int height, Gender gender) throws Exception {
        // Verificaciones de entrada
        if (height <= 0) {
            throw new IllegalArgumentException("La altura debe ser un número positivo.");
        }
        if (height >= Integer.MAX_VALUE) { 
            throw new IllegalArgumentException("La altura proporcionada es demasiado grande.");
        }
        
        // Calculamos el peso ideal:
        switch (gender) {
            case MALE:
                float pesoIdealM = height - 100 - (height - 150) / 4f;
                if (pesoIdealM > 0) {
                    return pesoIdealM;
                } else {
                    throw new IllegalArgumentException("El peso ideal es cero o menor que cero.");
                }
            case FEMALE:
                float pesoIdealF = height - 100 - (height - 150) / 2.5f;
                if (pesoIdealF > 0) {
                    return pesoIdealF;
                } else {
                    throw new IllegalArgumentException("El peso ideal es cero o menor que cero.");
                }
            default:
                throw new NullPointerException("Género no reconocido.");
        }
    }

    @Override
    public float basalMetabolicRate(float weight, int height, Gender gender, int age) throws Exception {
        // Verificaciones de entrada
        if (weight <= 0 || weight >= Float.MAX_VALUE) {
            throw new IllegalArgumentException("El peso debe ser un valor positivo y razonable.");
        }
        if (height <= 0 || height >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("La altura debe ser un valor positivo y razonable.");
        }
        if (age <= 0 || age >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("La edad debe ser un valor positivo y razonable.");
        }
        
        // Calculamos la tasa metabólica basal:
        switch (gender) {
            case MALE:
                float resultadoBMRHombre = 10 * weight + 6.25f * height - 5 * age + 5;
                if (resultadoBMRHombre > 0) {
                    return resultadoBMRHombre;
                } else {
                    throw new IllegalArgumentException("El metabolismo basal es cero o menor que cero.");
                }
            case FEMALE:
                float resultadoBMRMujer = 10 * weight + 6.25f * height - 5 * age - 161;
                if (resultadoBMRMujer > 0) {
                    return resultadoBMRMujer;
                } else {
                    throw new IllegalArgumentException("El metabolismo basal es cero o menor que cero.");
                }
            default:
                throw new NullPointerException("Género no reconocido.");
        }
    }
}
