# Metodologias_tarea2

Se implementan los jugadores (tacticians) y el controlador del juego, además de solucionar los problemas presentes en la Tarea 1. 

Para la comunicación entre los jugadores y el controlador del juego, se hace uso del patrón observer, al igual que para la comunicación entre el controlador del juego y el modelo, ya que dada la estructura del programa (MVC), se hace necesaria la actualización del estado entre las distintas entidades del juego, sin que los jugadores interactúen directamente con el modelo. 

Para la creación de unidades, items y jugadores se usa el patrón Flyweight Factory. De esta manera, el controlador al pedir la creación de unidades, items y jugadores, recurre al factory correspondiente y no necesita recurrir constantemente a new para crear los elementos necesarios para el juego. Para el inicio del juego se hace la suposición de que cada tactician debe contar con al menos un Hero y se le otorgan también el resto de las unidades, decidiendo el tactician si las coloca o no en el mapa del juego.
