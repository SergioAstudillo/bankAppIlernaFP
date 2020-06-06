public class Gasto extends Dinero {
    //Metodos:
    public Gasto(double gasto, String description){
        super.setDinero(gasto);
        super.setDescription(description);
    }
    
    @Override
    public String toString(){ return "El usuario ha declarado un gasto de " + getDinero() + "€ con la descripcion: \"" + description + "\""; }
}
