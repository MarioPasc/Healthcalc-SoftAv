package uma;

public class MetricSystemDecorator implements HealthCalc{
    protected StatsProxy healthCalcStatsProxy;

    public MetricSystemDecorator(StatsProxy healthCalcStatsProxy) {
        this.healthCalcStatsProxy = healthCalcStatsProxy;
    }

    @Override
    public float idealWeight(int height, char gender) throws Exception{
        return healthCalcStatsProxy.idealWeight(height, gender);
    }

    @Override
    public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception{
        return healthCalcStatsProxy.basalMetabolicRate(weight, height, gender, age);
    }
}
