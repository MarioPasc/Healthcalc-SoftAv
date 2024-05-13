package uma;

import java.util.Arrays;
import java.util.List;

public class AmericanDecorator extends MetricSystemDecorator{
    public static final List<String> UNITS = Arrays.asList("libras", "pies");    

    public AmericanDecorator(StatsProxy healthCalcStatsProxy) {
        super(healthCalcStatsProxy);
    }

    @Override
    public int pesoIdeal(char genero, float altura){
        // La altura viene en pies, la convertimos a metros, que es con lo que trabaja HealthHospital
        return super.pesoIdeal(genero, (float)(altura*0.3048));
        }

    @Override
    public double bmr(char genero, int edad, float altura, int peso){
        // EL peso viene en libras, se convierte a gramos, que es en lo que trabaja HealthHospital
        // La altura viene en pies, la convertimos a metros, que es con lo que trabaja HealthHospital
        return super.bmr(genero, edad, (float)(altura*0.3048), (int)(peso* 453.592));
    }

    public List<String> getUnits() {
        return UNITS;
    }
}


