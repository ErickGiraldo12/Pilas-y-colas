// Aqui van los metodos estaticos de los retos 2, 3, 4, 6 y 7.
public class Retos {

    public Retos() {
    }

    // RETO 2 - El Walkman de Star-Lord
    // Toca la siguiente cancion y la manda al final, para que nunca se acabe la lista.
    public static void reproducirSiguiente(Cola playlist) {
        Object cancion = playlist.sacar();
        if (cancion == null) return; // no hay canciones
        System.out.println("Reproduciendo: " + cancion);
        playlist.enfilar(cancion); // vuelve al final de la fila
    }

    // RETO 3 - El Enredo de Groot
    // Invierte una cola usando una pila temporal.
    public static void invertirCola(Cola cola) {
        Pila temp = new Pila();
        // Paso 1: todo de la cola a la pila
        while (!cola.estaVacia()) {
            temp.apilar(cola.sacar());
        }
        // Paso 2: todo de la pila a la cola (ya sale al reves)
        while (!temp.estaVacia()) {
            cola.enfilar(temp.sacar());
        }
    }

    // RETO 4 - El Arsenal de Drax
    // Saca un arma de la mitad de la pila sin cambiar el orden de las demas.
    public static String buscarYExtraer(Pila armas, String objetivo) {
        Pila auxiliar = new Pila();
        String encontrada = null;

        while (!armas.estaVacia()) {
            String arma = (String) armas.sacar();
            if (arma.equals(objetivo)) {
                encontrada = arma;
                break; // ya la tenemos, dejamos de buscar
            }
            auxiliar.apilar(arma); // guardamos las demas aparte
        }

        // Devolvemos las armas a su pila (al pasar dos veces, queda el orden original)
        while (!auxiliar.estaVacia()) {
            armas.apilar(auxiliar.sacar());
        }
        return encontrada;
    }

    // RETO 6 - La Boveda del Coleccionista
    // Ordena la pila para que el numero mas grande quede arriba.
    // Solo usa UNA pila auxiliar y un entero (sin arreglos, listas ni recursividad).
    public static void ordenarPila(Pila gemas) {
        Pila auxiliar = new Pila();

        while (!gemas.estaVacia()) {
            int temp = (int) gemas.sacar();
            // Si arriba de la auxiliar hay algo MENOR que temp, lo regresamos a gemas
            // para que temp quede debajo de el.
            while (!auxiliar.estaVacia() && (int) auxiliar.verPrimero() < temp) {
                gemas.apilar(auxiliar.sacar());
            }
            auxiliar.apilar(temp);
        }
        // La auxiliar tiene el menor arriba. Al pasarla de vuelta se invierte
        // y en gemas queda el mayor arriba.
        while (!auxiliar.estaVacia()) {
            gemas.apilar(auxiliar.sacar());
        }
    }

    // RETO 7 - Deflectores de la Milano (Round-Robin)
    // Reparte 10 unidades de energia a cada sector por turnos.
    public static void simularDeflectores(Cola cola) {
        while (!cola.estaVacia()) {
            Sector s = (Sector) cola.sacar();
            s.energiaFaltante -= 10;
            if (s.energiaFaltante > 0) {
                System.out.println("Cargando " + s.nombre + "... Restan " + s.energiaFaltante + " para el 100%");
                cola.enfilar(s); // todavia le falta, vuelve al final
            } else {
                System.out.println("Cargando " + s.nombre + "... Listo, al 100%");
            }
        }
    }
}