package uma;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StatsProxy implements HealthHospital, HealthStats {
    private HealthHospital healthCalc;
    private List<Float> alturas;
    private List<Float> pesos;
    private List<Integer> edades;
    private List<Float> bmrs;
    private int numHombres;
    private int numMujeres;

    public StatsProxy(HealthHospital healthCalcAdapter) {
        this.healthCalc = healthCalcAdapter;
        this.alturas = new ArrayList<>();
        this.pesos = new ArrayList<>();
        this.edades = new ArrayList<>();
        this.bmrs = new ArrayList<>();
        this.numHombres = 0;
        this.numMujeres = 0;
    }

    @Override
    public int pesoIdeal(Person persona) {
        float idealWeight = healthCalc.pesoIdeal(persona);
        alturas.add((float) persona.height());
        switch (persona.gender()) {
            case MALE:
                numHombres ++;
                break;
            case FEMALE:
                numMujeres++;
                break;
        }
        return (int)idealWeight;
    }

    @Override
    public double bmr(Person persona) {
        double bmr = healthCalc.bmr(persona);
        pesos.add((float) persona.weight());
        alturas.add(persona.height());
        edades.add(persona.age());
        bmrs.add((float) bmr);
        switch (persona.gender()) {
            case MALE:
                numHombres ++;
                break;
            case FEMALE:
                numMujeres++;
                break;
        }
        return bmr;
    }

    @Override
    public float alturaMedia() {
        return calcularMedia(alturas);
    }

    @Override
    public float pesoMedio() {
        return calcularMedia(pesos);
    }

    @Override
    public float edadMedia() {
        return calcularMedia(edades.stream().map(Integer::floatValue).collect(Collectors.toList()));
    }

    @Override
    public float bmrMedio() {
        return calcularMedia(bmrs);
    }

    @Override
    public int numSexoH() {
        return numHombres;
    }

    @Override
    public int numSexoM() {
        return numMujeres;
    }

    @Override
    public int numTotalPacientes() {
        return numHombres + numMujeres;
    }

    private float calcularMedia(List<Float> valores) {
        return valores.isEmpty() ? 0 : (float) valores.stream().mapToDouble(Float::doubleValue).average().orElse(0.0);
    }
    
}
