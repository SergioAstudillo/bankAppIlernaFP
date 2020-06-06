public class Ingreso extends Dinero {
    //Metodos:
    public Ingreso(double ingreso, String description){
        super.setDinero(ingreso);
        super.setDescription(description);
    }

    @Override
    public String toString() { return "El usuario ha realizado un ingreso de " + getDinero() + "€ con la descripcion: \"" + description + "\""; }
}
