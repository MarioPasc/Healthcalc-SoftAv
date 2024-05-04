package uma;

public class EuropeanDecorator extends MetricSystemDecorator {

    public EuropeanDecorator(StatsProxy healthCalcStatsProxy) {
        super(healthCalcStatsProxy);
    }

    @Override
    public float idealWeight(int height, char gender) throws Exception {
        // Convierte altura de metros a centímetros y calcula el peso ideal, devolviendo el resultado en gramos (!!)
        return 1000 * super.idealWeight(height * 100, gender);
    }

    @Override
    public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception {
        // Convierte peso de gramos a kilogramos y altura de metros a centímetros para calcular BMR
        return super.basalMetabolicRate(weight / 1000, height * 100, gender, age);
    }
}

