package uma;

public class EnglishMessageHandler extends MessageHandlerDecorator {
    public EnglishMessageHandler(MetricSystemDecorator decoratedCalc, String unitWeight, String unitHeight) {
        super(decoratedCalc, unitWeight, unitHeight);
    }

    @Override
    protected void displayBMRMessage(int weight, float height, double bmr) {
        System.out.printf("The person with height %.2f %s and weight %d %s has a BMR of %.2f.\n", height, unitHeight, weight, unitWeight, bmr);
    }
}