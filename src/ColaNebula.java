// RETO 5 - El Cerebro Cibernetico
// Una cola hecha SOLO con dos pilas (sin nodos ni punteros propios).
public class ColaNebula {

    // Pila donde se guardan los datos que van llegando
    private Pila pilaEntrada = new Pila();

    // Pila de donde salen los datos, ya en orden de cola (el primero en llegar sale primero)
    private Pila pilaSalida = new Pila();

    // Meter un dato a la cola:
    // solo lo ponemos arriba de la pila de entrada, no hay que hacer nada mas
    public void enfilar(Object obj) {
        pilaEntrada.apilar(obj);
    }

    // Sacar un dato de la cola
    public Object sacar() {
        // Solo si la pila de salida esta vacia, pasamos todo desde la entrada.
        // Al pasar los datos de una pila a otra, el orden se da vuelta:
        // el que llego primero queda arriba, listo para salir.
        if (pilaSalida.estaVacia()) {
            while (!pilaEntrada.estaVacia()) {
                pilaSalida.apilar(pilaEntrada.sacar());
            }
        }

        // Sacamos el de arriba de la pila de salida.
        // Si no habia nada en ninguna de las dos pilas, devuelve null.
        return pilaSalida.sacar();
    }

    // La cola esta vacia solo si las dos pilas estan vacias
    public boolean estaVacia() {
        return pilaEntrada.estaVacia() && pilaSalida.estaVacia();
    }
}