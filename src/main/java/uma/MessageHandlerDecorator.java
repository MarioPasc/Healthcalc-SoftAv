package uma;

import java.util.List;

public abstract class MessageHandlerDecorator implements HealthHospital{
    protected MetricSystemDecorator decoratedCalc;

    public MessageHandlerDecorator(MetricSystemDecorator decoratedCalc) {
        this.decoratedCalc = decoratedCalc;
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

    protected void displayBMRMessage(int weight, float height, double bmr) {
        List<String> units = decoratedCalc.getUnits();
        String unitWeight = units.get(0);
        String unitHeight = units.get(1);
        printMessage(weight, height, bmr, unitWeight, unitHeight);
    }

    protected abstract void printMessage(int weight, float height, double bmr, String unitWeight, String unitHeight);
}
