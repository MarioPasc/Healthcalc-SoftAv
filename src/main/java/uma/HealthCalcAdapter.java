package uma;

public class HealthCalcAdapter implements HealthHospital {
    private StatsProxy healthCalcRecordStats;

    public HealthCalcAdapter() {
        // No tenemos que pasarle una instancia de la calculadora ya que se ha aplicado Singleton
        this.healthCalcRecordStats = new StatsProxy();
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        float alturaEnCm = altura * 100; // Convertir metros a centímetros
        float pesoEnKg = peso / 1000.0f; // Convertir gramos a kilogramos
        
        try {
            float bmr = healthCalcRecordStats.basalMetabolicRate(pesoEnKg, (int) alturaEnCm, genero, edad);
            return (double) bmr;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    @Override
    public int pesoIdeal(char genero, float altura) {
        float alturaEnCm = altura * 100; // Convertir metros a centímetros
        
        try {
            return (int) healthCalcRecordStats.idealWeight((int) alturaEnCm, genero);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

