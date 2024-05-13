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
    public int pesoIdeal(char genero, float altura){
        return decoratedCalc.pesoIdeal(genero, altura);
    }
    @Override
    public double bmr(char genero, int edad, float altura, int peso){
        double bmr = decoratedCalc.bmr(genero, edad, altura, peso);
        displayBMRMessage(peso, altura, bmr);
        return bmr;
    }

    protected void displayBMRMessage(int peso, float altura, double bmr) {
        List<String> units = decoratedCalc.getUnits();
        String unitWeight = units.get(0);
        String unitHeight = units.get(1);
        printMessage(peso, altura, bmr, unitWeight, unitHeight);
    }

    protected abstract void printMessage(int peso, float altura, double bmr, String unitWeight, String unitHeight);
}
