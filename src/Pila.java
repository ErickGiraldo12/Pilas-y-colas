// Pila: funciona como una pila de platos.
// El ultimo que pones arriba es el primero que sacas (LIFO).
public class Pila {
    Nodo primeroDeLaPila; // el nodo que esta en la cima

    public Pila() {
    }

    public Pila(Nodo primeroDeLaPila) {
        this.primeroDeLaPila = primeroDeLaPila;
    }

    // Pone un dato arriba de la pila
    public void apilar(Object nuevoObjeto) {
        Nodo nuevoNodo = new Nodo(nuevoObjeto);
        nuevoNodo.siguiente = primeroDeLaPila; // el nuevo se pega al que estaba arriba
        primeroDeLaPila = nuevoNodo;           // ahora el nuevo es la cima
    }

    // Quita el dato de arriba y lo devuelve (si esta vacia devuelve null)
    public Object sacar() {
        if (primeroDeLaPila == null) return null;
        Object dato = primeroDeLaPila.contenido;
        primeroDeLaPila = primeroDeLaPila.siguiente;
        return dato;
    }

    // Mira el dato de arriba sin quitarlo
    public Object verPrimero() {
        if (primeroDeLaPila == null) return null;
        return primeroDeLaPila.contenido;
    }

    // Dice si la pila no tiene nada
    public boolean estaVacia() {
        return primeroDeLaPila == null;
    }
}
