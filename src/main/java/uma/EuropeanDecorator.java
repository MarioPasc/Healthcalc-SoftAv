package uma;

public class EuropeanDecorator extends MetricSystemDecorator {

    public EuropeanDecorator(StatsProxy healthCalcStatsProxy) {
        super(healthCalcStatsProxy);
    }

    @Override
    public int pesoIdeal(char gender, float height){
        // Convierte altura de metros a centímetros y calcula el peso ideal, devolviendo el resultado en gramos (!!)
        return 1000 * super.pesoIdeal(gender, (float)(height * 100));
    }

    @Override
    public double bmr(char gender, int age, float height, int weight){
        // Convierte peso de gramos a kilogramos y altura de metros a centímetros para calcular BMR
        return super.bmr(gender, age, (float)(height * 100), (int)(weight / 1000));
    }
}

