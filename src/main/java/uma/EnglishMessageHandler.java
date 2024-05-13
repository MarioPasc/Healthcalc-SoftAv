package uma;

public class EnglishMessageHandler extends MessageHandlerDecorator {
    public EnglishMessageHandler(MetricSystemDecorator decoratedCalc) {
        super(decoratedCalc);
    }

    @Override
    protected void printMessage(int peso, float altura, double bmr, String unitWeight, String unitHeight) {
        System.out.printf("The person with height %.2f %s and weight %d %s has a BMR of %.2f kcal/day\n", altura, unitHeight, peso, unitWeight, bmr);
    }
}