package uma;

public abstract class MessageHandlerDecorator implements HealthHospital{
    protected MetricSystemDecorator decoratedCalc;
    protected String unitWeight;
    protected String unitHeight;

    public MessageHandlerDecorator(MetricSystemDecorator decoratedCalc, String unitWeight, String unitHeight) {
        this.decoratedCalc = decoratedCalc;
        this.unitWeight = unitWeight;
        this.unitHeight = unitHeight;
    }

    public void setUnits(String unitWeight, String unitHeight) {
        this.unitWeight = unitWeight;
        this.unitHeight = unitHeight;
    }

    public void setCalculator(MetricSystemDecorator decoratedCalc) {
        this.decoratedCalc = decoratedCalc;
    }

    @Override
    public int pesoIdeal(char gender, float height){
        return decoratedCalc.pesoIdeal(gender, height);
    }
    @Override
    public double bmr(char gender, int age, float height, int weight){
        double bmr = decoratedCalc.bmr(gender, age, height, weight);
        displayBMRMessage(weight, height, bmr);
        return bmr;
    }

    protected abstract void displayBMRMessage(int weight, float height, double bmr);
}
