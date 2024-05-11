package uma;

public class PersonaEspecifica implements Person {
    private float weight;
    private float height;
    private int age;
    private Gender gender;

    /**
     * Constructor de PersonaEspecifica que inicializa una nueva instancia de PersonaEspecifica 
     * con el peso, altura, edad y género especificados.
     * 
     * @param weight el peso de la persona en kilogramos.
     * @param height la altura de la persona en centímetros.
     * @param age la edad de la persona en años.
     * @param gender el género de la persona.
     */
    public PersonaEspecifica(float weight, float height, int age, Gender gender) {
        // Verificaciones de entrada
        if (weight <= 0 || weight >= Float.MAX_VALUE) {
            throw new IllegalArgumentException("El peso debe ser un valor positivo y razonable.");
        }
        if (height <= 0 || height >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("La altura debe ser un valor positivo y razonable.");
        }
        if (age <= 0 || age >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("La edad debe ser un valor positivo y razonable.");
        }
        if (gender == null) {
            throw new NullPointerException("Género no reconocido.");
        }
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
    }

    public PersonaEspecifica(float height, Gender gender) {
        if (height <= 0 || height >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("La altura debe ser un valor positivo y razonable.");
        }
        if (gender == null) {
            throw new NullPointerException("Género no reconocido.");
        }
        this.gender = gender;
        this.height = height;
    }

    /**
     * Retorna el peso de la persona en kilogramos.
     * 
     * @return el peso de la persona en kilogramos.
     */
    @Override
    public float weight() {
        return this.weight;
    }

    /**
     * Retorna la altura de la persona en centímetros.
     * 
     * @return la altura de la persona en centímetros.
     */
    @Override
    public float height() {
        return this.height;
    }

    /**
     * Retorna el género de la persona.
     * 
     * @return el género de la persona.
     */
    @Override
    public Gender gender() {
        return this.gender;
    }

    /**
     * Retorna la edad de la persona en años.
     * 
     * @return la edad de la persona en años.
     */
    @Override
    public int age() {
        return this.age;
    }
}