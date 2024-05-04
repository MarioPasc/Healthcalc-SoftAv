package uma;

public class EnglishMessageHandler extends MessageHandlerDecorator {
    public EnglishMessageHandler(MetricSystemDecorator decoratedCalc) {
        super(decoratedCalc);
    }

    @Override
    protected void printMessage(int weight, float height, double bmr, String unitWeight, String unitHeight) {
        System.out.printf("The person with height %.2f %s and weight %d %s has a BMR of %.2f.\n", height, unitHeight, weight, unitWeight, bmr);
    }
}