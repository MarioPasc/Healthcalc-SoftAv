package uma;

import java.util.Arrays;
import java.util.List;

public class AmericanDecorator extends MetricSystemDecorator{
    public static final List<String> UNITS = Arrays.asList("libras", "pies");    

    public AmericanDecorator(StatsProxy healthCalcStatsProxy) {
        super(healthCalcStatsProxy);
    }

    @Override
    public int pesoIdeal(Person persona){
        // La altura viene en pies, la convertimos a metros, que es con lo que trabaja HealthHospital
        Person personaAmericano = new PersonaEspecifica((float)(persona.height()*0.3048), persona.gender());
        return super.pesoIdeal(personaAmericano);
        }

    @Override
    public double bmr(Person persona){
        // EL peso viene en libras, se convierte a gramos, que es en lo que trabaja HealthHospital
        // La altura viene en pies, la convertimos a metros, que es con lo que trabaja HealthHospital
        Person personaAmericano = new PersonaEspecifica((float)(persona.weight() * 453.592), (float)(persona.height()*0.3048), persona.age(), persona.gender());
        return super.bmr(personaAmericano);
    }

    public List<String> getUnits() {
        return UNITS;
    }
}


