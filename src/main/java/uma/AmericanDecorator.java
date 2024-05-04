package uma;

import java.util.Arrays;
import java.util.List;

public class AmericanDecorator extends MetricSystemDecorator{
    public static final List<String> UNITS = Arrays.asList("libras", "pies");    

    public AmericanDecorator(StatsProxy healthCalcStatsProxy) {
        super(healthCalcStatsProxy);
    }

    @Override
    public int pesoIdeal(char gender, float height){
        // Asume que la altura viene en metros y la convierte a centímetros
        return super.pesoIdeal(gender, (int)(height * 30.48));
        }

    @Override
    public double bmr(char gender, int age, float height, int weight){
        // Asume que el peso viene en kilogramos y lo convierte a gramos
        return super.bmr(gender, age, (float)(height * 30.48), (int)(weight * 453.592));
    }

    public List<String> getUnits() {
        return UNITS;
    }
}


