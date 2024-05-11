package uma;

import java.util.Arrays;
import java.util.List;

public class AmericanDecorator extends MetricSystemDecorator{
    public static final List<String> UNITS = Arrays.asList("pounds", "feet");    

    public AmericanDecorator(StatsProxy healthCalcStatsProxy) {
        super(healthCalcStatsProxy);
    }

    @Override
    public int pesoIdeal(char gender, float height){
        // La altura viene en pies, hay que pasarla a metros
        return super.pesoIdeal(gender, (int)(height * 0.3048));
        }

    @Override
    public double bmr(char gender, int age, float height, int weight){
        // EL peso viene en libras, hay que pasarlo a gramos
        // La altura viene en pies, hay que pasarla a metros
        return super.bmr(gender, age, (float)(height * 0.3048), (int)(weight * 453.592));
    }

    public List<String> getUnits() {
        return UNITS;
    }
}


