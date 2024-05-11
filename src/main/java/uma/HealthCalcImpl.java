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
    public float idealWeight(Person persona) throws Exception {        
        // Obtenemos los datos de la persona:
        float height = persona.height();
        Gender gender = persona.gender();
        // Calculamos el peso ideal:
        switch (gender) {
            case MALE:
                float pesoIdealM = height - 100 - (height - 150) / 4f;
                if (pesoIdealM > 0) {
                    return pesoIdealM;
                } else {
                    throw new IllegalArgumentException("El peso ideal es cero o menor que cero.");
                }
            default:
                float pesoIdealF = height - 100 - (height - 150) / 2.5f;
                if (pesoIdealF > 0) {
                    return pesoIdealF;
                } else {
                    throw new IllegalArgumentException("El peso ideal es cero o menor que cero.");
                }
        }
    }

    @Override
    public float basalMetabolicRate(Person person) throws Exception {  
        // Obtenemos los datos de la persona:
        float weight = person.weight();
        float height = person.height();
        int age = person.age();
        Gender gender = person.gender();
        // Calculamos la tasa metabólica basal:
        switch (gender) {
            case MALE:
                float resultadoBMRHombre = 10 * weight + 6.25f * height - 5 * age + 5;
                if (resultadoBMRHombre > 0) {
                    return resultadoBMRHombre;
                } else {
                    throw new IllegalArgumentException("El metabolismo basal es cero o menor que cero.");
                }
            default: // La otra única opción es que sea Gender.FEMALE
                float resultadoBMRMujer = 10 * weight + 6.25f * height - 5 * age - 161;
                if (resultadoBMRMujer > 0) {
                    return resultadoBMRMujer;
                } else {
                    throw new IllegalArgumentException("El metabolismo basal es cero o menor que cero.");
                }
        }
    }
}


