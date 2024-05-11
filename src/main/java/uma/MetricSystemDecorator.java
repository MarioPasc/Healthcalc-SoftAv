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
    public int pesoIdeal(Person persona){
        return healthCalcStatsProxy.pesoIdeal(persona);
    }
    @Override
    public double bmr(Person persona){
        return healthCalcStatsProxy.bmr(persona);
    }
}
