# Monopolio - Proyecto Final

**Estudiante:** Franshelina Camilo Cabrera

## Descripción

Este proyecto consiste en una versión simplificada del juego de mesa **Monopolio**, desarrollada en **Java utilizando JavaFX**.

El juego está diseñado para **2 a 4 jugadores** y permite jugar de forma local por turnos. Los jugadores pueden lanzar los dados, desplazarse por el tablero, comprar propiedades, pagar alquileres, construir casas y hoteles, recibir dinero y enfrentarse a diferentes eventos.

La aplicación cuenta con una interfaz gráfica con una ambientación natural y estilo pixel art.

## Tecnologías utilizadas

* Java
* JavaFX 25.0.3
* FXML
* Scene Builder
* Visual Studio Code

## Casillas implementadas

El tablero cuenta con **24 casillas**.

Entre las casillas implementadas se encuentran:

* Salida
* Propiedades
* Impuestos
* Suerte (Casualidad)
* Comunidad (Arca Comunal)
* Cárcel
* Ir a la cárcel
* Paradas

## Reglas simplificadas

* Pueden participar entre **2 y 4 jugadores**.
* Cada jugador comienza con una cantidad de dinero establecida por el juego.
* En cada turno, el jugador lanza dos dados y avanza según la suma obtenida.
* Si el jugador cae en una propiedad disponible, puede comprarla si tiene suficiente dinero.
* Si cae en una propiedad perteneciente a otro jugador, debe pagar el alquiler correspondiente.
* Si un jugador posee todas las propiedades de un grupo, puede construir casas.
* Las casas aumentan el valor del alquiler de la propiedad.
* Las casillas de impuestos hacen que el jugador pague una cantidad fija al banco.
* Las casillas de Suerte y Comunidad generan diferentes eventos que pueden hacer que el jugador gane o pierda dinero.
* Si un jugador cae en "Ir a la cárcel", pierde su próximo turno.
* Un jugador queda eliminado cuando no puede pagar una deuda.
* Al ser eliminado, pierde sus propiedades y estas vuelven a estar disponibles.
* Cuando solamente queda un jugador activo, este es declarado ganador.

## Instrucciones para jugar

1. Inicia el juego desde la pantalla principal.
2. Selecciona la cantidad de jugadores, entre **2 y 4**.
3. Introduce el nombre de cada jugador y comienza la partida.
4. En cada turno, el jugador correspondiente debe presionar el botón para **lanzar los dados**.
5. La ficha avanzará automáticamente según el resultado de los dados.
6. Dependiendo de la casilla en la que caiga el jugador, podrá:

   * Comprar una propiedad disponible.
   * Pagar alquiler a otro jugador.
   * Pagar impuestos al banco.
   * Recibir o entregar dinero mediante las casillas de Suerte y Comunidad.
   * Construir una casa si cumple con los requisitos.
   * Ser enviado a la cárcel.
7. Los turnos continúan entre los jugadores que permanezcan activos.
8. Si un jugador no puede pagar una deuda, queda eliminado de la partida y sus propiedades vuelven a estar disponibles.
9. La partida termina cuando queda un solo jugador activo.
10. El último jugador que permanezca en la partida es declarado **ganador**.
