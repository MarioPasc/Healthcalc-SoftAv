package uma;

public class EnglishMessageHandler extends MessageHandlerDecorator {
    public EnglishMessageHandler(MetricSystemDecorator decoratedCalc) {
        super(decoratedCalc);
    }

    @Override
    protected void printMessage(Person persona, double bmr, String unitWeight, String unitHeight) {
        System.out.printf("The person with height %.2f %s and weight %.2f %s has a BMR of %.2f.\n", persona.height(), unitHeight, persona.weight(), unitWeight, bmr);
    }
}