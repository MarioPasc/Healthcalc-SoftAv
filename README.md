# Health Calculator - Proyecto para la asignatura "Ingeniería de Software Avanzada"

<p align="center">
  <img src="https://github.com/MarioPasc/Mineria-de-Datos-con-R/assets/120520768/8116be8d-7c0d-4564-9678-d1fda0064a6a" width="100" title="Universidad de Málaga">
  &nbsp; &nbsp; &nbsp; &nbsp;
  <img src="https://git-scm.com/images/logos/downloads/Git-Icon-1788C.png" width="100" title="Logo de git">
  &nbsp; &nbsp; &nbsp; &nbsp;
  <img src="https://upload.wikimedia.org/wikipedia/en/3/30/Java_programming_language_logo.svg" width="60" title="Logo de java">
</p>

Este proyecto forma parte de la primera práctica de la asignatura "Ingeniería del Software Avanzada". El principal objetivo es desarrollar los métodos `idealWeight` y `basalMetabolicRate` para la clase `HealthCalcImp` siguiendo una metodología TDD (*Test-Driven Development*). Se ha aplicado la metodología siguiendo el siguiente flujo de trabajo: 

1. Definir los casos de prueba
2. Implementar los tests 
3. Implementar los métodos `idealWeight` y `basalMetabolicRate`

Asimismo, se ha utilizado Git y Github para manejar el control de versiones del proyecto, realizando *commits* significativos con comentarios explicativos y manejando ramas cuando ha sido necesario. 

## Tests

### Tests método `HealthCalcImpl.idealWeight`

#### Tests Caja Negra

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

#### Tests Caja Blanca

- **Test de Peso Ideal para Hombre** `testPesoIdealHombre`

Este test comprueba el cálculo correcto del peso ideal para un hombre, basado en la fórmula específica. Así se confirma que el resultado coincide con el valor esperado. 

- **Test de Peso Ideal para Mujer** `testPesoIdealMujer`

Similar al anterior, este test valida que el cálculo del peso ideal para una mujer es correcto, utilizando su fórmula específica. 


### Tests método `HealthCalcImpl.basalMetabolicRate`

#### Tests Caja Negra

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

- **Test de Género No Válido para Tasa Metabólica Basal** `testGeneroNoValidoBasalMetabolicRate`

Este test verifica que el sistema lanza una excepción `IllegalArgumentException` al recibir un género que no sea 'm' (hombre) o 'w' (mujer) al calcular la tasa metabólica basal. 

#### Tests Caja Blanca

- **Test de Metabolismo Basal para Mujer** `testMetabolismoBasalMujer`

Aquí, se evalúa que el cálculo de la tasa metabólica basal para una mujer es correcto, utilizando la fórmula específica para mujeres. Este test asegura que el cálculo se realiza adecuadamente según los parámetros biológicos diferenciados por género.

- **Test de Metabolismo Basal para Hombre** `testMetabolismoBasalHombre`

Este test confirma que el cálculo de la tasa metabólica basal para un hombre se realiza correctamente, siguiendo la fórmula específica para hombres. El propósito es verificar que el sistema calcula de manera precisa la TMB, tomando en cuenta las diferencias biológicas entre géneros.

## Resultado de los tests

```xml
<testsuite xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="https://maven.apache.org/surefire/maven-surefire-plugin/xsd/surefire-test-report-3.0.xsd" version="3.0" name="healthcalc.HealthCalcTest" time="0.063" tests="1" errors="0" skipped="0" failures="0">
```

<p align="center">
  <img src="https://github.com/MarioPasc/Healthcalc-SoftAv/assets/120520768/48041dd4-c19f-44a3-a542-20d395949866" height="300" title="XML Tests">
  <img src="https://github.com/MarioPasc/Healthcalc-SoftAv/assets/120520768/e5307c5f-fa0c-4e99-b683-61c5183236c5" height="300" title="tests1">
</p>


Como se puede observar, todos los tests se han pasado satisfactoriamente. Esto es un buen indicador, ya que los tests fueron definidos y programados de manera rigurosa para poder comprobar las limitaciones del software. 

## Uso de Git & Github durante el proyecto

<p align="center">
  <img src="https://github.com/MarioPasc/Healthcalc-SoftAv/assets/120520768/deec6194-1f77-4940-a13d-b0affd620049" width="753" title="GIT">
</p>

**Desarrollo**

- Primero empecé trabajando de manera directa en la rama main, sin embargo, cuando implementé todos los tests de caja negra para ambos métodos, decidí crear la rama `testsCajaBlanca`. 
- Desarrollé todos los tests de caja blanca en esta rama con éxito, sin embargo, antes de unir esta rama a la rama `main`, tuve que arreglar un pequeño error que tuve en el test `testPesoOverflowBasalMetabolicRate`, ya que no estaba comprobando el valor con `Float.MAX_VALUE`, sino con `INTEGER.MAX_VALUE`, siendo esto incorrecto ya que la variable de entrada `weight` es de tipo `float`. 
- Una vez arreglado el error, volví a la rama `testsCajaBlanca` para revisar el contenido. Finalmente uní las ramas con `git merge` y terminé de desarrollar unos tests de caja negra. 




## Cómo Usar

```bash
git clone https://github.com/MarioPasc/Healthcalc-SoftAv.git
```

## Contacto

Si tienes alguna pregunta o deseas conectarte, no dudes en contactarme a través de [LinkedIn](https://www.linkedin.com/in/mario-pascual-gonzalez/).
