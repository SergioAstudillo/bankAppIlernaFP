public class GastoException extends Exception{
    //Metodos propios:
    @Override
    public String getMessage(){
        return "No puede realizar un gasto superior a la cantidad de dinero que posee.";
    }
}
