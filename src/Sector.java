// RETO 7 - Un sector de escudos de la nave
public class Sector {
    String nombre;        // Frontal, Trasero, etc.
    int energiaFaltante;// cuanta energia le falta para llegar al 100%

    public Sector() {
    }

    public Sector(String nombre, int energiaFaltante) {
        this.nombre = nombre;
        this.energiaFaltante = energiaFaltante;
    }
}
