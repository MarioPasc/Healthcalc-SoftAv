package uma;

/**
 * Calculadora de algunos parámetros de salud relacionados con hospitales.
 * 
 */
public interface HealthHospital {
    
    /**
     * Calcula la Tasa Metabólica Basal (BMR) de una persona con la siguiente fórmula:
     *   
     * @param genero    Género de la persona ('m' o 'w').
     * @param edad      Edad de la persona.
     * @param altura    Altura de la persona (METROS).
     * @param peso      Peso de la persona (GRAMOS).
     * @return          La Tasa Metabólica Basal de la persona.
     */
    public double bmr(Gender genero, int edad, float altura, int peso);
    /**
     * Calcula el peso ideal (PI) de una persona siguiendo la fórmula de Lorentz:
     *
     * @param genero    Género de la persona ('m' o 'w').
     * @param altura    Altura de la persona (METROS).
     * @return          El peso ideal de la persona (GRAMOS).
     */
    public int pesoIdeal(Gender genero, float altura);
}
