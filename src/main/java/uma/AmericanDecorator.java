package uma;

public class AmericanDecorator extends MetricSystemDecorator{

    public AmericanDecorator(StatsProxy healthCalcStatsProxy) {
        super(healthCalcStatsProxy);
    }

    @Override
    public float idealWeight(int height, char gender) throws Exception{
        // Asume que la altura viene en metros y la convierte a centímetros
        return super.idealWeight((int)(height * 30.48), gender);
        }

    @Override
    public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception{
        // Asume que el peso viene en kilogramos y lo convierte a gramos
        return super.basalMetabolicRate((float)(weight * 453.592), (int)(height * 30.48), gender, age);
    }
}


