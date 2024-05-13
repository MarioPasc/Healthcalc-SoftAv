package uma;

public class SpanishMessageHandler extends MessageHandlerDecorator {
    public SpanishMessageHandler(MetricSystemDecorator decoratedCalc) {
        super(decoratedCalc);
    }

    @Override
    protected void printMessage(int peso, float altura, double bmr, String unitWeight, String unitHeight) {
        System.out.printf("La persona con altura %.2f %s y peso %d %s tiene un BMR de %.2f kcal/dia\n", altura, unitHeight, peso, unitWeight, bmr);
    }
}
