// Main: aqui se prueban los 7 retos. Ejecuta esta clase.
public class Main {
    public static void main(String[] args) {

        System.out.println("=== RETO 1: Pila limitada (max 5) ===");
        PilaLimitada cargador = new PilaLimitada(5);
        for (int i = 1; i <= 6; i++) {
            cargador.apilar("Bateria " + i); // la 6 debe dar error
        }
        System.out.println("Saco: " + cargador.sacar());
        cargador.apilar("Bateria 7"); // ahora si cabe

        System.out.println("\n=== RETO 2: Walkman infinito ===");
        Cola playlist = new Cola();
        playlist.enfilar("Cancion A");
        playlist.enfilar("Cancion B");
        playlist.enfilar("Cancion C");
        for (int i = 0; i < 7; i++) {   // 7 veces para ver que da la vuelta
            Retos.reproducirSiguiente(playlist);
        }

        System.out.println("\n=== RETO 3: Invertir cola ===");
        Cola coordenadas = new Cola();
        coordenadas.enfilar(1);
        coordenadas.enfilar(2);
        coordenadas.enfilar(3);
        coordenadas.enfilar(4);
        Retos.invertirCola(coordenadas);
        while (!coordenadas.estaVacia()) {
            System.out.print(coordenadas.sacar() + " "); // 4 3 2 1
        }
        System.out.println();

        System.out.println("\n=== RETO 4: Arsenal de Drax ===");
        Pila armas = new Pila();
        armas.apilar("Espada");
        armas.apilar("Dagas de Vibranium");
        armas.apilar("Hacha");
        armas.apilar("Escudo");
        System.out.println("Extraigo: " + Retos.buscarYExtraer(armas, "Dagas de Vibranium"));
        System.out.print("Quedan (de arriba a abajo): ");
        while (!armas.estaVacia()) {
            System.out.print(armas.sacar() + " | "); // Escudo | Hacha | Espada
        }
        System.out.println();

        System.out.println("\n=== RETO 5: Cola de Nebula (solo pilas) ===");
        ColaNebula nebula = new ColaNebula();
        nebula.enfilar("Uno");
        nebula.enfilar("Dos");
        nebula.enfilar("Tres");
        System.out.println(nebula.sacar()); // Uno
        nebula.enfilar("Cuatro");
        while (!nebula.estaVacia()) {
            System.out.println(nebula.sacar()); // Dos, Tres, Cuatro
        }

        System.out.println("\n=== RETO 6: Ordenar pila ===");
        Pila gemas = new Pila();
        int[] poderes = {30, 5, 50, 10, 40};
        for (int p : poderes) gemas.apilar(p);
        Retos.ordenarPila(gemas);
        System.out.print("De arriba a abajo: ");
        while (!gemas.estaVacia()) {
            System.out.print(gemas.sacar() + " "); // 50 40 30 10 5
        }
        System.out.println();

        System.out.println("\n=== RETO 7: Deflectores de la Milano ===");
        Cola sectores = new Cola();
        sectores.enfilar(new Sector("Frontal", 25));
        sectores.enfilar(new Sector("Trasero", 10));
        sectores.enfilar(new Sector("Izquierdo", 30));
        sectores.enfilar(new Sector("Derecho", 15));
        Retos.simularDeflectores(sectores);
    }
}