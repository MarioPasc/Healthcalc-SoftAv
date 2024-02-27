package healthcalc;

public class HealthCalcImpl implements HealthCalc{

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
        if (gender != 'm' && gender != 'w') {
            throw new IllegalArgumentException("El género debe ser 'm' (hombre) o 'w' (mujer).");
        }
        
        // Calculamos el peso ideal:
        if (gender == 'm') {
            return height - 100 - (height - 150) / 4f;
        } else {
            return height - 100 - (height - 150) / 2.5f;
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
        if (weight >= Integer.MAX_VALUE) { 
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

        if (gender != 'm' && gender != 'w') {
            throw new IllegalArgumentException("El género debe ser 'm' (hombre) o 'w' (mujer).");
        }
        
        // Calculate BMR using the specified formula
        if (gender == 'm') {
            return 10 * weight + 6.25f * height - 5 * age + 5;
        } else {
            return 10 * weight + 6.25f * height - 5 * age - 161;
        }
    }
}
