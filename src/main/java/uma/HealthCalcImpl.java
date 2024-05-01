package uma;

public class HealthCalcImpl implements HealthCalc{
    // Patrón Singleton Aplicado
	private static HealthCalcImpl instance;

    private HealthCalcImpl() {}

    public static HealthCalcImpl getInstance() {
        if (instance == null) {
            instance = new HealthCalcImpl();
        }
        return instance;
    }

    @Override
    public float idealWeight(int height, char gender) throws Exception {

        // 1. La altura debe ser positiva
        // 2. El género debe estar dentro de los valores permitidos
        // 3. La altura debe tener un límite superior asociado al tipo de dato (int)
        if (height <= 0) {
            throw new IllegalArgumentException("La altura debe ser un número positivo.");
        }
        if (height >= Integer.MAX_VALUE) { 
            throw new IllegalArgumentException("La altura proporcionada es demasiado grande.");
        }
        if (Character.toLowerCase(gender) != 'm' && Character.toLowerCase(gender) != 'w') {
            throw new IllegalArgumentException("El género debe ser 'm' (hombre) o 'w' (mujer).");
        }
        
        // Calculamos el peso ideal:
        if (Character.toLowerCase(gender) == 'm') {
            float pesoIdeal = height - 100 - (height - 150) / 4f;
            if (pesoIdeal > 0) {return pesoIdeal;} 
            else {throw new IllegalArgumentException("El peso ideal es cero o menor que cero.");}
        } else {
            float pesoIdeal = height - 100 - (height - 150) / 2.5f;
            if (pesoIdeal > 0) {return pesoIdeal;} 
            else {throw new IllegalArgumentException("El peso ideal es cero o menor que cero.");}
        }
    }

    @Override
    public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception {

        // 1. El peso debe ser mayor que cero
        // 2. El peso no debe causar un overflow del tipo de datos
        // 3. La altura debe ser mayor que cero
        // 4. La altura no debe causar un overflow del tipo de datos
        // . La edad debe ser mayor que cero
        // . El género debe estar dentro de los valores establecidos
        if (weight <= 0) {
            throw new IllegalArgumentException("El peso debe ser un valor positivo.");
        }
        if (weight >= Float.MAX_VALUE) { 
            throw new IllegalArgumentException("El peso proporcionado es demasiado grande.");
        }

        if (height <= 0) {
            throw new IllegalArgumentException("La altura debe ser un valor positivo.");
        }
        if (height >= Integer.MAX_VALUE) { 
            throw new IllegalArgumentException("La altura proporcionada es demasiado grande.");
        }

        if (age <= 0) {
            throw new IllegalArgumentException("La edad debe ser un valor positivo.");
        }
        if (age >= Integer.MAX_VALUE) { 
            throw new IllegalArgumentException("La edad proporcionada es demasiado grande.");
        }

        if (Character.toLowerCase(gender) != 'm' && Character.toLowerCase(gender) != 'w') {
            throw new IllegalArgumentException("Debe elegir un género");
        }
        
        // Calculate BMR using the specified formula
        if (Character.toLowerCase(gender) == 'm') {
            float metabolicrate = 10 * weight + 6.25f * height - 5 * age + 5;
            if (metabolicrate > 0) {return metabolicrate;} 
            else {throw new IllegalArgumentException("El metabolismo basal es cero o menor que cero.");}
        } else {
            float metabolicrate = 10 * weight + 6.25f * height - 5 * age - 161;
            if (metabolicrate > 0) {return metabolicrate;} 
            else {throw new IllegalArgumentException("El metabolismo basal es cero o menor que cero.");}
        }
    }
}
