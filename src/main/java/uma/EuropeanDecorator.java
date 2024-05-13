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
    public int pesoIdeal(char genero, float altura){
        // Debido a que la interfaz HealthHospital ya trabaja en gramos y metros, no hay que hacer ningun cambio
        return super.pesoIdeal(genero, altura);
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso){
        return super.bmr(genero, edad, altura, peso);
    }

    public List<String> getUnits() {
        return UNITS;
    }
}

