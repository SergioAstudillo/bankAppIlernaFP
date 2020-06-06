import java.util.ArrayList;

public class Cuenta{
    //Atributos previos:
    private double saldo;
    private Usuario usuario;
    private ArrayList<Gasto> gastos = new ArrayList<>();
    private ArrayList<Ingreso> ingresos = new ArrayList<>();
    
    //Metodos previos:
    public Cuenta(Usuario usuario){
        this.saldo = 0;
        setUsuario(usuario);
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public ArrayList<Gasto> getGastos() {
        return gastos;
    }
    
    public ArrayList<Ingreso> getIngresos() {
        return ingresos;
    }

    //Metodos editados:
    public double addIngresos(String description, double cantidad){
        ingresos.add(new Ingreso(cantidad,description));
        setSaldo(this.saldo += cantidad);
        return saldo;
    }
    
    public double addGastos(String description, double cantidad){
        if (saldo - cantidad < 0) try{
            throw new GastoException();
        }
        catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        else {
            gastos.add(new Gasto(cantidad,description));
            setSaldo(this.saldo -= cantidad);
        }
        return saldo;
    }

    @Override
    public String toString(){ return "El usuario " + usuario.getNombre() + " tiene un saldo de: " + getSaldo() + "€"; }
}
