package uma;

import java.util.Arrays;
import java.util.List;

public class MetricSystemDecorator implements HealthHospital{
    protected StatsProxy healthCalcStatsProxy;
    // Unidades por defecto
    private static final List<String> UNITS = Arrays.asList("kg", "cm");


    public MetricSystemDecorator(StatsProxy healthCalcStatsProxy) {
        this.healthCalcStatsProxy = healthCalcStatsProxy;
    }

    public List<String> getUnits() {
        return UNITS;
    }

    @Override
    public int pesoIdeal(Gender gender, float height){
        return healthCalcStatsProxy.pesoIdeal(gender, height);
    }
    @Override
    public double bmr(Gender gender, int age, float height, int weight){
        return healthCalcStatsProxy.bmr(gender, age, height, weight);
    }
}
