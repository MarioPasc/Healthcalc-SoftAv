package uma;

public class MainTestPatterns {
    public static void main(String[] args) throws Exception{
        Person personaBMREuropea = new PersonaEspecifica(108, (float)(1.7), 20, Gender.MALE);
        Person personaBMRAmericana = new PersonaEspecifica(48988, (float)(5.57743), 20, Gender.MALE);
        Person personaIdealWeightEuropea = new PersonaEspecifica((float)1.7, Gender.MALE);
        Person personaIdealWeightAmericana = new PersonaEspecifica((float)(5.57743), Gender.MALE);
        // Creamos una instancia de la calculadora
        HealthCalcImpl.getInstance();
        HealthCalcAdapter adapterHospital = new HealthCalcAdapter();
        // Asociamos un StatsProxy a esta calculadora Hospital
        StatsProxy healthCalcStats = new StatsProxy(adapterHospital);
        System.out.println("=======================================");
        System.out.println("Languages Decorator");
        // Creas las calculadoras que quieras tener, las asocias a un proxy de estadísticas que está asociado a una HealthCalcImpl
        AmericanDecorator americanMetricSystemCalc = new AmericanDecorator(healthCalcStats);
        EuropeanDecorator europeMetricSystemCalc = new EuropeanDecorator(healthCalcStats);
        // Creas una clase por cada idioma que se implemente, ajustando las unidades y asociando el tipo de calculadora a cada uno
        SpanishMessageHandler messageCalcES = new SpanishMessageHandler(americanMetricSystemCalc);
        EnglishMessageHandler messageCalcEN = new EnglishMessageHandler(americanMetricSystemCalc);
        // Realizas cálculos
        System.out.println("## Calculadora Americana ##");
        messageCalcEN.bmr(personaBMRAmericana);
        messageCalcES.bmr(personaBMRAmericana);
        System.out.println("## Calculadora Europea ##");
        // Cambias los parámetros de los decoradores para cambiar de calculadora
        messageCalcES.setCalculator(europeMetricSystemCalc);
        messageCalcEN.setCalculator(europeMetricSystemCalc);
        messageCalcEN.bmr(personaBMREuropea);
        messageCalcES.bmr(personaBMREuropea);
        System.out.println("=======================================");
        System.out.println("Comprobación peso ideal");
        System.out.println("Comprobación con calculadora Europea: " + europeMetricSystemCalc.pesoIdeal(personaIdealWeightEuropea) + " gramos");
        System.out.println("Comprobación con calculadora Americana: " + americanMetricSystemCalc.pesoIdeal(personaIdealWeightAmericana) + " gramos");
        // Imprimimos las estadísticas
        System.out.println("========== Healthcalc Stats ==========");
        System.out.println("Avg BMR:              " + healthCalcStats.bmrMedio() + " kcal/dia");
        System.out.println("Avg Weight:           " + healthCalcStats.pesoMedio()+ " gramos" );
        System.out.println("Avg Age:              " + healthCalcStats.edadMedia()+ " años");
        System.out.println("Avg Height:           " + healthCalcStats.alturaMedia()+" m");
        System.out.println("Avg Males:            " + healthCalcStats.numSexoH()+   " hombres");
        System.out.println("Avg Females:          " + healthCalcStats.numSexoM()+   " mujeres");
        System.out.println("Avg Patients:         " + healthCalcStats.numTotalPacientes()+ " pacientes");
    }
}
