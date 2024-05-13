package uma;

public class HealthCalcAdapter implements HealthHospital {
    private HealthCalcImpl healthCalcCore;

    public HealthCalcAdapter() {
        // No tenemos que pasarle una instancia de la calculadora ya que se ha aplicado Singleton
        this.healthCalcCore = HealthCalcImpl.getInstance();
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        float alturaEnCm = altura * 100; // Convertir metros a centímetros
        float pesoEnKg = peso / 1000.0f; // Convertir gramos a kilogramos
        
        Gender gender;
        if (genero == 'w' || genero == 'W') {
            gender = Gender.FEMALE;
        } else if (genero == 'm' || genero == 'M') {
            gender = Gender.MALE;
        } else {
            gender = null; // La clase PersonaEspecifica maneja la excepción
        }
        
        Person personaEspecifica = new PersonaEspecifica(pesoEnKg, (int) alturaEnCm, edad, gender);
        try {
            double bmr = healthCalcCore.basalMetabolicRate(personaEspecifica);
            return bmr;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    @Override
    public int pesoIdeal(char genero, float altura) {
        float alturaEnCm = altura * 100; // Convertir metros a centímetros
        Gender gender;
        if (genero == 'w' || genero == 'W') {
            gender = Gender.FEMALE;
        } else if (genero == 'm' || genero == 'M') {
            gender = Gender.MALE;
        } else {
            gender = null; // La clase PersonaEspecifica maneja la excepción
        }
        Person personaEspecifica = new PersonaEspecifica((int) alturaEnCm, gender);
        try {
            return (int)(1000*healthCalcCore.getIdealBodyWeight(personaEspecifica));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

