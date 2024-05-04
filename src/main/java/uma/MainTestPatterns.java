package uma;

public class MainTestPatterns {
    public static void main(String[] args) throws Exception{
        // Creamos una instancia de la calculadora
        HealthCalcImpl.getInstance();
        // Asociamos un StatsProxy a esta calculadora
        StatsProxy healthCalcStats = new StatsProxy();
        // Intentamos realizar algunas operaciones
        System.out.println("BMR:");
        System.out.println(healthCalcStats.basalMetabolicRate(50, 100, 'w', 50));
        System.out.println(healthCalcStats.basalMetabolicRate(70, 130, 'm', 60));
        System.out.println(healthCalcStats.basalMetabolicRate(100, 150, 'w', 80));
        // Probamos ahora un cálculo con el hospital
        HealthCalcAdapter adapterHospital = new HealthCalcAdapter();
        System.out.println("Hospital Calculations for ideal weight:");
        // Como podemos comprobar, si introducimos la altura en metro y el peso en gramos, nos da el mismo
        // resultado que la primera entrada de BMR
        System.out.println(adapterHospital.bmr('w', 50, 1, 50000));

        System.out.println("=======================================");

        System.out.println("Ideal Weight:");
        System.out.println(healthCalcStats.idealWeight(100, 'w'));
        System.out.println(healthCalcStats.idealWeight(150, 'm'));
        System.out.println(healthCalcStats.idealWeight(200, 'w'));
        System.out.println("Hospital Calculations for ideal weight:");
        System.out.println(adapterHospital.pesoIdeal('w', (float)(1.0)));

        System.out.println("=======================================");
        System.out.println("European Decorator");
        EuropeanDecorator europeMetricSystemCalc = new EuropeanDecorator(healthCalcStats);
        // Acepta la altura en metros y el peso en gramos
        System.out.println("BMR: " + europeMetricSystemCalc.basalMetabolicRate(50*1000, 1, 'w', 50));
        System.out.println("IW (grams): " + europeMetricSystemCalc.idealWeight(1, 'w'));
        System.out.println("American Decorator");
        AmericanDecorator americanMetricSystemCalc = new AmericanDecorator(healthCalcStats);
        // Acepta la altura en metros y el peso en gramos
        System.out.println("BMR: " + americanMetricSystemCalc.basalMetabolicRate((float)(110.231), 3, 'w', 50));
        System.out.println("IW (pounds): " + americanMetricSystemCalc.idealWeight(3, 'w'));

        // Imprimimos las estadísticas
        System.out.println("========== Healthcalc Stats ==========");
        System.out.println("Avg BMR:              " + healthCalcStats.bmrMedio());
        System.out.println("Avg Weight:           " + healthCalcStats.pesoMedio());
        System.out.println("Avg Age:              " + healthCalcStats.edadMedia());
        System.out.println("Avg Height:           " + healthCalcStats.alturaMedia());
        System.out.println("Avg Males:            " + healthCalcStats.numSexoH());
        System.out.println("Avg Females:          " + healthCalcStats.numSexoM());
        System.out.println("Avg Patients:         " + healthCalcStats.numTotalPacientes());
    }
}
