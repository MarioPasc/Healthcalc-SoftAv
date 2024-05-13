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
    public int pesoIdeal(char genero, float altura){
        return healthCalcStatsProxy.pesoIdeal(genero, altura);
    }
    @Override
    public double bmr(char genero, int edad, float altura, int peso){
        return healthCalcStatsProxy.bmr(genero, edad, altura, peso);
    }
}
