package uma;

import java.util.Arrays;
import java.util.List;

public class EuropeanDecorator extends MetricSystemDecorator {
    // Unidades de la calculadora europea
    public static final List<String> UNITS = Arrays.asList("gramos", "metros");


    public EuropeanDecorator(StatsProxy healthCalcStatsProxy) {
        super(healthCalcStatsProxy);
    }

    @Override
    public int pesoIdeal(char gender, float height){
        // Debido a que implementa HealthHospital, no hay que hacer ningún cambio
        return super.pesoIdeal(gender, height);
    }

    @Override
    public double bmr(char gender, int age, float height, int weight){
        // Debido a que implementa HealthHospital, no hay que hacer ningún cambio
        return super.bmr(gender, age, height, weight);
    }

    public List<String> getUnits() {
        return UNITS;
    }
}

