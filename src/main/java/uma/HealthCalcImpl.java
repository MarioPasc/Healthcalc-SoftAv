package uma;

public class HealthCalcImpl implements CardiovascularMetrics, MetabolicMetrics {
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
    public double getIdealBodyWeight(Person persona) {        
        // Obtenemos los datos de la persona:
        float height = persona.height();
        Gender gender = persona.gender();
        // Calculamos el peso ideal:
        switch (gender) {
            case MALE:
                double pesoIdealM = height - 100 - (height - 150) / 4f;
                if (pesoIdealM > 0) {
                    return pesoIdealM;
                } else {
                    throw new IllegalArgumentException("El peso ideal es cero o menor que cero.");
                }
            default:
                double pesoIdealF = height - 100 - (height - 150) / 2.5f;
                if (pesoIdealF > 0) {
                    return pesoIdealF;
                } else {
                    throw new IllegalArgumentException("El peso ideal es cero o menor que cero.");
                }
        }
    }

    @Override
    public double basalMetabolicRate(Person person) {
        // Obtenemos los datos de la persona:
        float weight = person.weight();
        float height = person.height();
        int age = person.age();
        Gender gender = person.gender();
        // Calculamos la tasa metabólica basal:
        switch (gender) {
            case MALE:
                double resultadoBMRHombre = 10 * weight + 6.25f * height - 5 * age + 5;
                if (resultadoBMRHombre > 0) {
                    return resultadoBMRHombre;
                } else {
                    throw new IllegalArgumentException("El metabolismo basal es cero o menor que cero.");
                }
            default: // La otra única opción es que sea Gender.FEMALE
                double resultadoBMRMujer = 10 * weight + 6.25f * height - 5 * age - 161;
                if (resultadoBMRMujer > 0) {
                    return resultadoBMRMujer;
                } else {
                    throw new IllegalArgumentException("El metabolismo basal es cero o menor que cero.");
                }
        }
    }
}


