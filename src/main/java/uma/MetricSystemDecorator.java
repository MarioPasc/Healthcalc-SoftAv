package uma;

public class MetricSystemDecorator implements HealthHospital{
    protected StatsProxy healthCalcStatsProxy;

    public MetricSystemDecorator(StatsProxy healthCalcStatsProxy) {
        this.healthCalcStatsProxy = healthCalcStatsProxy;
    }

    @Override
    public int pesoIdeal(char gender, float height){
        return healthCalcStatsProxy.pesoIdeal(gender, height);
    }
    @Override
    public double bmr(char gender, int age, float height, int weight){
        return healthCalcStatsProxy.bmr(gender, age, height, weight);
    }
}
