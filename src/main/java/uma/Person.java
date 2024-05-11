package uma;

public interface Person {
    /**
     * Retorna el peso de la persona en kilogramos.
     * 
     * @return el peso de la persona en kilogramos.
     */
    public float weight();

    /**
     * Retorna la altura de la persona en centímetros.
     * 
     * @return la altura de la persona en centímetros.
     */
    public float height();

    /**
     * Retorna el género de la persona.
     * 
     * @return el género de la persona.
     */
    public Gender gender();

    /**
     * Retorna la edad de la persona en años.
     * 
     * @return la edad de la persona en años.
     */
    public int age();
}