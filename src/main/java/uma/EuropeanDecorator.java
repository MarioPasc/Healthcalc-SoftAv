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
    public int pesoIdeal(Person persona){
        // Debido a que la interfaz HealthHospital ya trabaja en gramos y metros, no hay que hacer ningun cambio
        Person personaEuropeo = new PersonaEspecifica(persona.height(), persona.gender());
        return super.pesoIdeal(personaEuropeo);
    }

    @Override
    public double bmr(Person persona){
        Person personaEuropeo = new PersonaEspecifica(persona.weight(), persona.height(), persona.age(), persona.gender());
        return super.bmr(personaEuropeo);
    }

    public List<String> getUnits() {
        return UNITS;
    }
}

