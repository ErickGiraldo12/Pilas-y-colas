// Nodo: es un "eslabon" de una cadena.
// Guarda un dato y sabe cual es el eslabon que sigue.
public class Nodo {
    Object contenido; // el dato que guardamos
    Nodo siguiente;   // el eslabon que viene despues (null si no hay mas)

    public Nodo() {
    }

    public Nodo(Object contenido) {
        this.contenido = contenido;
        this.siguiente = null;
    }
}