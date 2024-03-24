# Health Calculator - Proyecto para la asignatura "Ingeniería de Software Avanzada"

<p align="center">
  <img src="https://github.com/MarioPasc/Mineria-de-Datos-con-R/assets/120520768/8116be8d-7c0d-4564-9678-d1fda0064a6a" width="100" title="Universidad de Málaga">
  &nbsp; &nbsp; &nbsp; &nbsp;
  <img src="https://git-scm.com/images/logos/downloads/Git-Icon-1788C.png" width="100" title="Logo de git">
  &nbsp; &nbsp; &nbsp; &nbsp;
  <img src="https://upload.wikimedia.org/wikipedia/en/3/30/Java_programming_language_logo.svg" width="60" title="Logo de java">
</p>


<details>
<summary>Tabla de Contenido</summary>

- [Práctica 1: Tests](#práctica-1-tests)
- [Práctica 2: Casos de Uso](#práctica-2-casos-de-uso)
- [Práctica 3: BDD](#práctica-3-bdd)

</details>

# Práctica 1: Tests
  
El principal objetivo de esta sección es desarrollar los métodos `idealWeight` y `basalMetabolicRate` para la clase `HealthCalcImp` siguiendo una metodología TDD (*Test-Driven Development*). Se ha aplicado la metodología siguiendo el siguiente flujo de trabajo: 

1. Definir los casos de prueba
2. Implementar los tests 
3. Implementar los métodos `idealWeight` y `basalMetabolicRate`

<details>
<summary>Tests</summary>

#### Tests método `HealthCalcImpl.idealWeight`

##### Tests Caja Negra

- **Test de Altura Negativa** `testAlturaNegativaIdealWeight`

En este test, compruebo que la aplicación lanza una excepción cuando se introduce una altura negativa para calcular el peso ideal. Es fundamental asegurar que el sistema maneje adecuadamente entradas inválidas como esta, ya que una altura negativa no tiene sentido en un contexto real.

- **Test de Altura Cero** `testAlturaCeroIdealWeight`

Aquí, verifico que el sistema reacciona correctamente al recibir un valor de altura igual a cero para el cálculo del peso ideal, lanzando una excepción. 

- **Test de Peso Ideal Negativo para Hombre** `testPesoIdealNegativoHombre`

Este test asegura que el sistema identifica y rechaza un cálculo de peso ideal que resulte negativo para un hombre, lo cual indicaría un error en el algoritmo o en la entrada de datos. 

- **Test de Peso Ideal Negativo para Mujer** `testPesoIdealNegativoMujer`

Similar al anterior, pero enfocado en el género femenino, este test confirma que el sistema detecta y evita retornar un peso ideal negativo para una mujer. 

- **Test de Altura Desbordada** `testAlturaOverflowIdealWeight`

Este test verifica que el sistema lanza una excepción cuando se proporciona una altura que excede el límite máximo permitido por el tipo de dato (overflow). Este escenario es crucial para asegurar que el sistema maneja correctamente valores extremadamente grandes que podrían causar errores en el cálculo.

- **Test de Género No Válido** `testGeneroNoValidoIdealWeight`

Con este test, aseguro que el sistema identifica y rechaza entradas de género que no sean 'm' (hombre) o 'w' (mujer), lanzando una excepción.

##### Tests Caja Blanca

- **Test de Peso Ideal para Hombre** `testPesoIdealHombre`

Este test comprueba el cálculo correcto del peso ideal para un hombre, basado en la fórmula específica. Así se confirma que el resultado coincide con el valor esperado. 

- **Test de Peso Ideal para Mujer** `testPesoIdealMujer`

Similar al anterior, este test valida que el cálculo del peso ideal para una mujer es correcto, utilizando su fórmula específica. 


#### Tests método `HealthCalcImpl.basalMetabolicRate`

##### Tests Caja Negra

- **Test de Altura Negativa para Tasa Metabólica Basal** `testAlturaNegativaBasalMetabolicRate`

En este test, se verifica que se lanza una excepción `IllegalArgumentException` al recibir una altura negativa. Es esencial garantizar que el sistema maneje adecuadamente entradas inválidas como una altura negativa, ya que no representa un escenario realista en el contexto de calcular la tasa metabólica basal.

- **Test de Altura Cero para Tasa Metabólica Basal** `testAlturaCeroBasalMetabolicRate`

Aquí, se comprueba que el sistema lanza correctamente una excepción `IllegalArgumentException` cuando se le proporciona un valor de altura igual a cero para calcular la tasa metabólica basal. 

- **Test de Peso Negativo para Tasa Metabólica Basal** `testPesoNegativoBasalMetabolicRate`

Este test confirma que el sistema identifica y rechaza correctamente un valor de peso negativo al calcular la tasa metabólica basal, lanzando una excepción `IllegalArgumentException`. 

- **Test de Edad Negativa para Tasa Metabólica Basal** `testEdadNegativaBasalMetabolicRate`

Con este test, se asegura que el sistema lanza una excepción `IllegalArgumentException` al introducir una edad negativa para el cálculo de la tasa metabólica basal. 

- **Test de Peso Cero para Tasa Metabólica Basal** `testPesoCeroBasalMetabolicRate`

Este test verifica que el sistema reacciona adecuadamente al recibir un valor de peso igual a cero para el cálculo de la tasa metabólica basal, lanzando una excepción `IllegalArgumentException`. 

- **Test de Edad Cero para Tasa Metabólica Basal** `testEdadCeroBasalMetabolicRate`

Aquí, se examina que el sistema emite correctamente una excepción `IllegalArgumentException` cuando se calcula la tasa metabólica basal con una edad igual a cero. 

- **Test de Altura Desbordada** `testAlturaOverflowBasalMetabolicRate`

Este test comprueba que la aplicación lanza una excepción cuando se introduce un peso que supera el límite máximo permitido por el tipo de dato (overflow). 

- **Test de Peso Desbordado** `testPesoOverflowBasalMetabolicRate`

Este test comprueba que la aplicación lanza una excepción cuando se introduce un peso que supera el límite máximo permitido por el tipo de dato (overflow). 

- **Test de Edad Desbordada** `testEdadOverflowBasalMetabolicRate`

En este test, se verifica que el sistema arroja una excepción cuando se suministra una edad que excede el límite máximo aceptable por el tipo de dato (overflow). 

- **Test de Metabolismo Basal Negativo para Hombre** `testbasalMetabolicRatetNegativoHombre`

Este test asegura que el sistema identifica y rechaza un cálculo de metabolismo basal que resulte negativo para un hombre, lo cual indicaría un error en el algoritmo o en la entrada de datos. 

- **Test de Metabolismo Basal Negativo para Mujer** `testbasalMetabolicRatetNegativoHombre`

Similar al anterior, pero enfocado en el género femenino, este test confirma que el sistema detecta y evita retornar un metabolismo basal negativo para una mujer. 

- **Test de Género No Válido para Tasa Metabólica Basal** `testGeneroNoValidoBasalMetabolicRate`

Este test verifica que el sistema lanza una excepción `IllegalArgumentException` al recibir un género que no sea 'm' (hombre) o 'w' (mujer) al calcular la tasa metabólica basal. 

##### Tests Caja Blanca

- **Test de Metabolismo Basal para Mujer** `testMetabolismoBasalMujer`

Aquí, se evalúa que el cálculo de la tasa metabólica basal para una mujer es correcto, utilizando la fórmula específica para mujeres. Este test asegura que el cálculo se realiza adecuadamente según los parámetros biológicos diferenciados por género.

- **Test de Metabolismo Basal para Hombre** `testMetabolismoBasalHombre`

Este test confirma que el cálculo de la tasa metabólica basal para un hombre se realiza correctamente, siguiendo la fórmula específica para hombres. El propósito es verificar que el sistema calcula de manera precisa la TMB, tomando en cuenta las diferencias biológicas entre géneros.
</details>

<details>
<summary>Resultado de los tests</summary>

```xml
version="3.0" name="healthcalc.HealthCalcTest" time="0.063" tests="1" errors="0" skipped="0" failures="0">
```

<p align="center">
  <img src="https://github.com/MarioPasc/Healthcalc-SoftAv/assets/120520768/af179b2e-f13d-422e-9bc6-50c2561c8f8f" height="250" title="XML Tests">
  <img src="https://github.com/MarioPasc/Healthcalc-SoftAv/assets/120520768/e5307c5f-fa0c-4e99-b683-61c5183236c5" height="250" title="tests1">
</p>


Como se puede observar, todos los tests se han pasado satisfactoriamente. Esto es un buen indicador, ya que los tests fueron definidos y programados de manera rigurosa para poder comprobar las limitaciones del software. 
</details>

<details>
<summary>Uso de Git & Github durante la práctica 1</summary>

<p align="center">
  <img src="https://github.com/MarioPasc/Healthcalc-SoftAv/assets/120520768/5ca2b0ff-b523-485a-ba84-d0620ded30fe" width="753" title="GIT">
</p>


**Desarrollo**

- Primero empecé trabajando de manera directa en la rama main, sin embargo, cuando implementé todos los tests de caja negra para ambos métodos, decidí crear la rama `testsCajaBlanca`. 
- Desarrollé todos los tests de caja blanca en esta rama con éxito, sin embargo, antes de unir esta rama a la rama `main`, tuve que arreglar un pequeño error que tuve en el test `testPesoOverflowBasalMetabolicRate`, ya que no estaba comprobando el valor con `Float.MAX_VALUE`, sino con `INTEGER.MAX_VALUE`, siendo esto incorrecto ya que la variable de entrada `weight` es de tipo `float`. 
- Una vez arreglado el error, volví a la rama `testsCajaBlanca` para revisar el contenido. Finalmente uní las ramas con `git merge` y terminé de desarrollar unos tests de caja negra. 
</details>

# Práctica 2: Casos de Uso

El principal objetivo de esta sección es desarrollar diagramas de casos de uso del proyecto y la especificación de uno de los casos de uso. 

<details>
<summary>Diagrama de Casos de Uso - Básico</summary>

<p align="center">
  <img src="https://github.com/MarioPasc/Healthcalc-SoftAv/assets/120520768/d4bfce46-80e7-427d-92f8-ea1defbd9f45" height="280" title="casosusodiag1">
</p>

En el diagrama de casos de uso básico podemos observar que se modela la funcionalidad de los métodos `idealWeight` y `basalMetabolicRate`. Se han considerado dos herencias para poder expandir el diagrama fácilmente cuando se deban añadir nuevas funcionalidades relacionadas con realizar cálculos al sistema en el futuro, y que conlleven también la introducción de parámetros por teclado.   

</details>

<details>
<summary>Diagrama de Casos de Uso - Extendido</summary>

<p align="center">
  <img src="https://github.com/MarioPasc/Healthcalc-SoftAv/assets/120520768/00e4bfbe-4a77-4010-8388-30440490bdde" width="805" title="casosusodiag1">
</p>

En el diagrama de casos de uso extendido incluye además dos métodos que también realizan un cálculo utilizando parámetros introducidos por teclado. Estos dos nuevos métodos tienen una relación con *Realizar Cálculo* y *Introducir Parámetros* similar a la que tenían los métodos `idealWeight` y `basalMetabolicRate`. 

El primer método introducido, **BMI**, realizaría el cálculo del índice de masa corporal siguiendo la fórmula $BMI = peso \times altura^2$.  
El segundo método introducido, **Ritmo Máximo Cardíaco**, realizaría el cálculo del RMC, siguiendo las fórmulas:

$$RMC_{hombre} = 220 - \text{Edad} - \frac{\text{Peso}}{20}$$

$$RMC_{mujer} = 226 - \text{Edad} - \frac{\text{Peso}}{22}$$

Donde:
- $RMC_{hombre}$ es el ritmo cardíaco máximo estimado para hombres.
- $RMC_{mujer}$ es el ritmo cardíaco máximo estimado para mujeres.
- $\text{Edad}$ es la edad de la persona en años.
- $\text{Peso}$ es el peso de la persona en kilogramos.

</details>

<details>
<summary>Especificación de Casos de Uso: IdealWeight</summary>

```bash
Nombre: Cálculo Peso Ideal
Stakeholders: 
    - Usuario: Poder realizar el cálculo de su peso ideal.
    - Equipo de desarrollo del software: Asegurar que el programa HealCalc se usa y desempeña con normalidad.
Actor principal: Usuario
Alcance (scope): Aplicación HealthCalc
Nivel de abstracción: USER GOAL. Se describe una interacción usuario-sistema
Precondiciones:
    - El usuario puede ejecutar el programa de la calculadora con éxito
Garantías:
    - Mínima: Se muestra un mensaje de error al usuario, explicando qué parte ha fallado. 
    - De Éxito: Se devuelve el peso ideal del usuario.
Trigger: El usuario selecciona la opción de Calcular Peso Ideal en el programa HealthCalc.
Escenario principal:
    1. El usuario selecciona la opción "Calcular Peso Ideal" en el programa HealthCalc.
    2. El sistema solicita al usuario los parámetros a rellenar. 
    3. El usuario introduce los valores de los parámetros. 
    4. El sistema aplica la fórmula con los parámetros introducidos. 
    5. El sistema muestra el resultado.
Extensiones:
    3a. El usuario introduce parámetros no válidos.
        3a.1. El sistema muestra un mensaje de error, indicando qué campos son incorrectos.
        3a.2. Se vuelve a 2.
    4a. El resultado está fuera de un rango. 
        4a.1. El sistema muestra un mensaje de error, indicando que el valor de salida es negativo o cero. 
        4a.2. Se vuelve a 2.  
```

</details>

<details>
<summary>Uso de Git & Github durante la práctica 2</summary>

<p align="center">
  <img src="https://github.com/MarioPasc/Healthcalc-SoftAv/assets/120520768/13b2fb6c-c997-4bd3-9533-5aae6ee036f1" width="753" title="GIT">
</p>

**Desarrollo**

Como se puede observar, se han creado dos nuevas ramas. La rama `practica1` hace referencia a la versión de `main` en la que está contenida toda la práctica 1. 

Por otra parte, la rama `practica2` está destinada a almacenar todos los cambios de la práctica 2. Estos cambios aún no se muestran en el repositorio ya que esta rama no ha sido unida (`git merge`) con la rama `main` aún, sin embargo, su contenido está disponible en los anteriores apartados de este fichero readme. 

</details>

# Práctica 3: BDD

El principal objetivo de esta práctica es implementar user stories y criterios de aceptación utilizando la metodología **Behavior-Driven Development (BDD)**, a través del uso de **Cucumber y el lenguaje Gherkin**. Dentro del repositorio, se encuentran los archivos:
1. **.feature**, los cuales contienen las implementaciones detalladas de los criterios de aceptación en Gherkin.
2. **.java** con el código de los pasos (steps) necesarios para ejecutar estas definiciones en pruebas automatizadas.
3. **.txt** en el directorio ./docs/ con las definiciones en lenguaje natural de las user stories y los criterios de aceptación. Las user stories siguen la estructura "Como [rol], Quiero [función], Para [beneficio]" para describir las necesidades y objetivos de los usuarios. Los criterios de aceptación se estructuran como "Dado que [contexto], Cuando [acción], Entonces [resultado esperado]" para especificar el comportamiento esperado del sistema bajo diferentes condiciones.

**Estructura de ficheros del proyecto**
```bash
Healthcalc-SoftAv/
├── doc/
│   └── user-stories.txt
├── src/
│   ├── main_java/uma/
│   │   ├── HealthCalc.java
│   │   └── HealthCalcImpl.java
│   └── test/
│       ├── java/uma/
│       │   ├── bdd/
│       │   │   ├── BasalMetabolicRateSteps.java
│       │   │   ├── IdealWeightSteps.java
│       │   │   └── RunCucumberTest.java
│       │   └── HealthCalcTest.java
│       └── resources/uma/
│           ├── basalMetabolicRate.feature
│           └── idealWeight.feature
└── pom.xml
```

<details>
<summary>Historias de Usuario y Criterios de Aceptación</summary>

### User Stories

#### IdealWeight:
> "As a HealthCalc User  
I want to input my gender and height into the calculator  
So that I can calculate my ideal weight"

#### BasalMetabolicRate:
> "As a nutritionist  
I want to determine the basal metabolic rate of my client  
So that I can elaborate a better diet plan for him/her"

### Acceptance Criteria

#### IdealWeight:

**Scenario: Calculate ideal weight with valid parameters**
- Given I am a HealthCalc user
- When I input my gender and height into the calculator
- Then the calculator should calculate and display my ideal weight.

**Scenario: Display error when input parameters are incorrect**  
(e.g. height less or equal to zero, gender not recognized by the system)
- Given I am a HealthCalc user
- When I input my gender and height into the calculator
        *AND* the system recognizes the inputs as invalid
- Then the calculator should display a specific error message guiding me to enter a valid gender and height.

**Scenario: Display error when input height exceeds the max value admitted by the datatype (int)**
- Given I am a HealthCalc user
- When I input a height value that is too high for IdealWeight
- Then the calculator should throw an overflow error

**Scenario: Display error when computed ideal weight is negative or zero**
- Given I am a HealthCalc user
- When I input my gender and height into the calculator
       *AND* the computed ideal weight is less or equal to zero 
- Then the calculator should display an error message indicating an unrealistic output.

#### BasalMetabolicRate:

**Scenario: Calculate the basal metabolic rate with valid inputs**
- Given I am a nutritionist
- When I input my client's weight, age, height, and gender into the calculator
- Then the calculator should compute and display its basal metabolic rate.

**Scenario: Display error when input parameters are incorrect**  
(e.g., gender not recognized by the system, numeric inputs less or equal to zero)
- Given I am a nutritionist
- When I input my client's weight, age, height, and gender into the calculator
  *AND* the inputs are recognized as invalid by the system
- Then the calculator should display specific error messages for each type of invalid input.

**Scenario: Display error when numeric input parameters are too high**  
(INTEGER.MAX_VALUE for age and height and FLOAT.MAX_VALUE for weight) 
- Given I am a nutritionist
- When I input values for my client's weight, age, or height 
  *AND* any value is too high for its datatype 
- Then the calculator should display an overflow error.

**Scenario: Display error when computed basal metabolic rate is negative or zero**
- Given I am a nutritionist
- When I input my client's weight, age, height, and gender into the calculator
  *AND* the computed basal metabolic rate is less or equal to zero 
- Then the calculator should display an error message indicating unrealistic output value.

</details>

<details>
<summary>Uso de Git & Github durante la práctica 3</summary>

<p align="center">
  <img src="https://github.com/MarioPasc/Healthcalc-SoftAv/assets/120520768/b59423f8-307b-4b06-b426-0bf4aadc1f17" width="753" title="GIT">
</p>

**Desarrollo**

Como se puede observar, para mantener un desarrollo limpio e independiente de las otras prácticas, se ha creado una nueva rama, `practica3`, en la cual se han hecho los commits adecuados. 

Principalmente se pueden obserar 4 commits, el primero incluye una configuración correcta de las dependencias del fichero `pom.xml`, además de el ajuste del `RunCucumberTest.java` para la estructura de ficheros del proyecto. Los siguientes dos commits incluyen las implementaciones de los ficheros `.feature` y su correspondiente `*Steps.java` para los métodos `idealWeight` y `basalMetabolicRate`. Finalmente, se ha realizado un commit con el fichero .txt que contiene el log de la ejecución de los tests, este fichero se ha podido obtener ejecutando `mvn test > ./doc/output-tests.txt` en la terminal desde la carpeta del proyecto. 

</details>


## Cómo Usar

```bash
git clone https://github.com/MarioPasc/Healthcalc-SoftAv.git
```

## Contacto

Si tienes alguna pregunta o deseas conectarte, no dudes en contactarme a través de [LinkedIn](https://www.linkedin.com/in/mario-pascual-gonzalez/).
