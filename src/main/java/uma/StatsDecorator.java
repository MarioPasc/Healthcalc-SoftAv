package uma;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StatsDecorator implements HealthCalc, HealthStats {
    private HealthCalcImpl healthCalc;
    private List<Float> alturas;
    private List<Float> pesos;
    private List<Integer> edades;
    private List<Float> bmrs;
    private int numHombres;
    private int numMujeres;

    public StatsDecorator(HealthCalcImpl healthCalc) {
        this.healthCalc = healthCalc;
        this.alturas = new ArrayList<>();
        this.pesos = new ArrayList<>();
        this.edades = new ArrayList<>();
        this.bmrs = new ArrayList<>();
        this.numHombres = 0;
        this.numMujeres = 0;
    }

    @Override
    public float idealWeight(int height, char gender) throws Exception {
        float idealWeight = healthCalc.idealWeight(height, gender);
        alturas.add((float) height);
        if (gender == 'm') {
            numHombres++;
        } else if (gender == 'w') {
            numMujeres++;
        }
        return idealWeight;
    }

    @Override
    public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception {
        float bmr = healthCalc.basalMetabolicRate(weight, height, gender, age);
        pesos.add(weight);
        alturas.add((float) height);
        edades.add(age);
        bmrs.add(bmr);
        if (gender == 'm') {
            numHombres++;
        } else if (gender == 'w') {
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
        if (valores.isEmpty()) {
            return 0;
        }
        float suma = 0;
        for (Float valor : valores) {
            suma += valor;
        }
        return suma / valores.size();
    }
}
