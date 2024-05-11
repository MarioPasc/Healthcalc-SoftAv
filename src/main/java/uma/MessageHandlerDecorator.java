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
    public int pesoIdeal(Person persona){
        return decoratedCalc.pesoIdeal(persona);
    }
    @Override
    public double bmr(Person persona){
        double bmr = decoratedCalc.bmr(persona);
        displayBMRMessage(persona, bmr);
        return bmr;
    }

    protected void displayBMRMessage(Person persona, double bmr) {
        List<String> units = decoratedCalc.getUnits();
        String unitWeight = units.get(0);
        String unitHeight = units.get(1);
        printMessage(persona, bmr, unitWeight, unitHeight);
    }

    protected abstract void printMessage(Person persona, double bmr, String unitWeight, String unitHeight);
}
