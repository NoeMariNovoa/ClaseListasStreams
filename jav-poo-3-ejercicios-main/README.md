# JAV: Taller de Estructuras de Datos

### Configuración:
1. Se requiere tener instalado Java 17 y Intellij IDEA
2. Abrir el Intellij IDEA, ir a File -> New -> Project from Version Control -> Git y pongan como URL `https://github.com/despegar/jav-poo-3-ejercicios.git`
3. Clickear donde dice `Setup SDK` en la parte superior del editor de texto y seleccionar la versión correspondiente.
4. Si ven algún error en el IDE, probar borrar la cache del IDE. Por ejemplo en IntelliJ lo pueden hacer en la opción "File > Invalidate Caches" y reiniciar

### Ejercicio Principal:

El ejercicio principal cuenta de varios puntos que deberemos resolver interpretando la documentación de cada uno de los métodos correspondientes.
Todo lo que debemos resolver estar identificado con `TODO` y debera pertenecer al paquete `com.despegar.exercise`

La clase FlightProvider representa un proveedor de vuelos, por lo tanto, tendrá las siguientes responsabilidades:

**search**: Nos permite hacer una búsqueda y encontrar que vuelos nos ofrece en un contexto determinado.  
**book**: Proceso por el cual creamos una reserva y se quita de disponibilidad los asientos reservados.  

A continuación se detallan los métodos que deberemos resolver:  
A) FlightProvider -> search  
B) FlightProvider -> book  
C) Flight -> totalPrice  
D) FlightProvider -> searchOrderByPrice

### Ejercicios Extras:

Los siguientes ejercicios se encuentran en el paquete `com.despegar.extras` y son ejercicios extras para practicar con colecciones.  
Resolver los mismos de forma posterior a los ejercicios principales.  
1. Completar el método `equals` de `Auto` 
2. Completar los métodos de `ListaDeAutosConArray` respetando el orden en que aparecen. Usar `ListaDeAutosConArrayTest` para validar que lo que hicieron funciona correctamente 
3. Completar los métodos de `ListaGenerica` respetando el orden en que aparecen. Usar `ListaGenericaTest` para validar que lo que hicieron funciona correctamente 
4. Completar el método `hashCode` de `Auto` 
5. Completar los métodos de `DiccionarioDeAutosConLista` respetando el orden en que aparecen. Usar `DiccionarioDeAutosConListaTest` para validar que lo que hicieron funciona correctamente 
6. Completar los métodos de `DiccionarioGenerico` respetando el orden en que aparecen. Usar `DiccionarioGenericoTest` para validar que lo que hicieron funciona correctamente 
7. Completar los métodos de `StreamsTest` utilizando los criterios especificados
8. Realizar actividad

