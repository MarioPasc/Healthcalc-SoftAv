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
    public int pesoIdeal(char gender, float height) {
        float idealWeight = healthCalc.pesoIdeal(gender, height);
        alturas.add((float) height);
        if (gender == 'm') {
            numHombres++;
        } else if (gender == 'w') {
            numMujeres++;
        }
        return (int)idealWeight;
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        double bmr = healthCalc.bmr(genero, edad, altura, peso);
        pesos.add((float) peso);
        alturas.add(altura);
        edades.add(edad);
        bmrs.add((float) bmr);
        if (genero == 'm') {
            numHombres++;
        } else if (genero == 'w') {
            numMujeres++;
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
