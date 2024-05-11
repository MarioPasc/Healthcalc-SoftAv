package uma;

public class SpanishMessageHandler extends MessageHandlerDecorator {
    public SpanishMessageHandler(MetricSystemDecorator decoratedCalc) {
        super(decoratedCalc);
    }

    @Override
    protected void printMessage(Person persona, double bmr, String unitWeight, String unitHeight) {
        System.out.printf("La persona con altura %.2f %s y peso %.2f %s tiene un BMR de %.2f.\n", persona.height(), unitHeight, persona.weight(), unitWeight, bmr);
    }
}
