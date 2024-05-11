package uma;

public class HealthCalcAdapter implements HealthHospital {
    private HealthCalcImpl healthCalcCore;

    public HealthCalcAdapter() {
        // No tenemos que pasarle una instancia de la calculadora ya que se ha aplicado Singleton
        this.healthCalcCore = HealthCalcImpl.getInstance();
    }

    @Override
    public double bmr(Person persona) {
        float alturaEnCm = persona.height() * 100; // Convertir metros a centímetros
        float pesoEnKg = persona.weight() / 1000.0f; // Convertir gramos a kilogramos
        Person personaEspecifica = new PersonaEspecifica(pesoEnKg, (int) alturaEnCm, persona.age(), persona.gender());
        try {
            float bmr = healthCalcCore.basalMetabolicRate(personaEspecifica);
            return (double) bmr;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    @Override
    public int pesoIdeal(Person persona) {
        float alturaEnCm = persona.height() * 100; // Convertir metros a centímetros
        Person personaEspecifica = new PersonaEspecifica((int) alturaEnCm, persona.gender());
        try {
            return (int)(1000*healthCalcCore.idealWeight(personaEspecifica));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

