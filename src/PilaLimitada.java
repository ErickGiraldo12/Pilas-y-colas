// RETO 1 - El Cargador de Rocket
// Es una pila igual a Pila.java, pero con un limite de elementos.
public class PilaLimitada {
    Nodo primeroDeLaPila;
    int capacidadMaxima; // cuantas baterias caben como maximo
    int cantidadActual;  // cuantas hay ahora mismo

    public PilaLimitada() {
    }

    // Al crearla le decimos el tamano maximo, por ejemplo new PilaLimitada(5)
    public PilaLimitada(int max) {
        this.capacidadMaxima = max;
        this.cantidadActual = 0;
    }

    public void apilar(Object nuevoObjeto) {
        // Si ya esta llena, mostramos error y NO apilamos
        if (cantidadActual >= capacidadMaxima) {
            System.out.println("ERROR: el canon explotaria. Ya hay " + capacidadMaxima
                    + " baterias, no cabe: " + nuevoObjeto);
            return;
        }
        Nodo nuevoNodo = new Nodo(nuevoObjeto);
        nuevoNodo.siguiente = primeroDeLaPila;
        primeroDeLaPila = nuevoNodo;
        cantidadActual++; // una bateria mas
    }

    public Object sacar() {
        if (primeroDeLaPila == null) return null;
        Object dato = primeroDeLaPila.contenido;
        primeroDeLaPila = primeroDeLaPila.siguiente;
        cantidadActual--; // una bateria menos
        return dato;
    }

    public boolean estaVacia() {
        return primeroDeLaPila == null;
    }
}