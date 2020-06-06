
public class Usuario{
    //Atributos previos:
    private String nombre;
    private int edad;
    private String DNI;
    
    //Metodos previos:
    public Usuario(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    public boolean setDNI(String DNI) {
        if (validacionDNI(DNI)){
            this.DNI = DNI;
        }
        return validacionDNI(DNI);
    }
    
    @Override
    public String toString(){ return "El usuario " + getNombre() + " con DNI " + getDNI() + " y una edad de " + getEdad() + " años ahora posee una cuenta en esta entidad bancaria."; }
    
    //Metodos propios:
    public boolean validacionDNI(String dni){
        if (dni.contains("-")){
            if (dni.length()!=10) return false;
            boolean validarLetras = Character.toString(dni.charAt(9)).matches("[A-Z]+");
            boolean validarGuion = dni.charAt(8) == '-';
            boolean validarNumeros = dni.substring(0,8).matches("[0-9]+");
            return validarLetras && validarNumeros && validarGuion;
        }
        else {
            if (dni.length()!=9) return false;
            boolean validarLetras = Character.toString(dni.charAt(8)).matches("[A-Z]+");
            boolean validarNumeros = dni.substring(0,8).matches("[0-9]+");
            return validarLetras && validarNumeros;
        }
    }
}
