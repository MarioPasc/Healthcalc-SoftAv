package uma;

/**
 * Interfaz que define los métodos para obtener estadísticas de salud.
 */
public interface HealthStats {
    
    /**
     * Calcula la altura media de los pacientes registrados.
     *
     * @return la altura media de los pacientes en centímetros.
     */
    float alturaMedia();
    
    /**
     * Calcula el peso medio de los pacientes registrados.
     *
     * @return el peso medio de los pacientes en kilogramos.
     */
    float pesoMedio();
    
    /**
     * Calcula la edad media de los pacientes registrados.
     *
     * @return la edad media de los pacientes.
     */
    float edadMedia();
    
    /**
     * Calcula la tasa metabólica basal (BMR) media de los pacientes registrados.
     *
     * @return la BMR media de los pacientes.
     */
    float bmrMedio();
    
    /**
     * Obtiene el número de pacientes de sexo masculino registrados.
     *
     * @return el número de pacientes de sexo masculino.
     */
    int numSexoH();
    
    /**
     * Obtiene el número de pacientes de sexo femenino registrados.
     *
     * @return el número de pacientes de sexo femenino.
     */
    int numSexoM();
    
    /**
     * Obtiene el número total de pacientes registrados.
     *
     * @return el número total de pacientes.
     */
    int numTotalPacientes();
}