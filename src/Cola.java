// Cola: funciona como la fila de un banco.
// El primero que llega es el primero que sale (FIFO).
public class Cola {
    Nodo primeroEnLaCola; // por aqui sale la gente
    Nodo ultimoEnLaCola;  // por aqui entra la gente

    public Cola() {
    }

    public Cola(Nodo primeroEnLaCola, Nodo ultimoEnLaCola) {
        this.primeroEnLaCola = primeroEnLaCola;
        this.ultimoEnLaCola = ultimoEnLaCola;
    }

    // Mete un dato al final de la cola
    public void enfilar(Object nuevoObjeto) {
        Nodo nuevoNodo = new Nodo(nuevoObjeto);
        if (primeroEnLaCola == null) {
            primeroEnLaCola = nuevoNodo;            // era la unica persona
        } else {
            ultimoEnLaCola.siguiente = nuevoNodo;   // se pega detras del ultimo
        }
        ultimoEnLaCola = nuevoNodo;
    }

    // Saca al primero de la cola y lo devuelve (si esta vacia devuelve null)
    public Object sacar() {
        if (primeroEnLaCola == null) return null;
        Object dato = primeroEnLaCola.contenido;
        primeroEnLaCola = primeroEnLaCola.siguiente;
        if (primeroEnLaCola == null) ultimoEnLaCola = null; // se quedo vacia
        return dato;
    }

    // Dice si la cola no tiene nada
    public boolean estaVacia() {
        return primeroEnLaCola == null;
    }
}