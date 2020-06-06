import java.util.*;

public class Main{

    //Creacion de varios escaners para evitar el colapso:
    public static Scanner scannerTexto = new Scanner(System.in);
    public static Scanner scannerSecundario = new Scanner(System.in);
    public static Scanner scannerMenu = new Scanner(System.in);

    public static void main(String[] args) {
        //Creacion e instancia de constantes y variables.
        System.out.println("Introduce el nombre de usuario: ");
        final String nombre = scannerTexto.nextLine();
        
        System.out.println("Introduce la edad del usuario: ");
        final int edad = scannerSecundario.nextInt();
        
        System.out.println("Introduce el DNI del usuario: ");
        String dni = scannerTexto.nextLine();
        
        //Creacion del usuario con los datos proporcionados, ademas lo muestra por pantalla.
        Usuario usuario = creacionUsuario(nombre,edad,dni.toUpperCase());
        System.out.println("Usuario creado correctamente. ");
        Cuenta cuenta = new Cuenta(usuario);
        System.out.println(cuenta.getUsuario());
        mostrarMenu(usuario,cuenta);
    }

    public static Usuario creacionUsuario(final String nombreUsuario, final int edadUsuario, String dniUsuario){
        //Instanciamos a nuestro usuario para poder hacer uso de los miembros de su clase.
        final Usuario usuario = new Usuario();
        //Establecemos los atributos de nuestro usuario (nombre, edad y DNI.)
        usuario.setNombre(nombreUsuario);
        usuario.setEdad(edadUsuario);
        if (!usuario.setDNI(dniUsuario)){
            System.out.println("DNI introducido incorrecto. \nIntroduce el DNI del usuario valido:");
            //Creamos una funcion recursiva para obligar al usuario a introducir un DNI correcto.
            return creacionUsuario(nombreUsuario,edadUsuario,scannerTexto.nextLine().toUpperCase());
        }
        return usuario;
    }
    
    //Funcion para crear el menu.
    public static void mostrarMenu(final Usuario usuario, final Cuenta cuenta){
        System.out.println("Realiza una nueva accion\n" + "1 Introduce un nuevo gasto\n" + "2 Introduce un nuevo ingreso\n" + "3 Mostrar gastos\n" + "4 Mostrar ingresos\n" + "5 Mostrar saldo\n" + "0 Salir\n");
        int opcion = scannerTexto.nextInt();
        interactuarMenu(opcion,usuario,cuenta);
    }
    
    public static String pedirDescripcion(){
        System.out.println("Introduce la descripcion: ");
        return scannerMenu.nextLine();
    }
    
    public static double pedirCantidad(){
        System.out.println("Introduce la cantidad: ");
        return scannerSecundario.useLocale(Locale.US).nextDouble();
    }
    
    //Mostrar un mensaje u otro dependiendo de la opcion que seleccione el usuario en la siguiente funcion.
    public static void mostrarSaldo(final Usuario usuario, final Cuenta cuenta, int seleccion){
        switch (seleccion){
            case 1:
                System.out.println("Saldo restante: " + cuenta.getSaldo() + "€");
                mostrarMenu(usuario, cuenta);
            case 2:
                System.out.println("El saldo actual de la cuenta es: " + cuenta.getSaldo() + "€");
                mostrarMenu(usuario,cuenta);
        }
    }
    
    //Funcion con un switch para poder interactuar con nuestro menu.
    public static void interactuarMenu(int opcion, final Usuario usuario, final Cuenta cuenta){
        switch (opcion){
            case 1: //Gasto:
                cuenta.addGastos(pedirDescripcion(),pedirCantidad());
                mostrarSaldo(usuario, cuenta, 1);
            case 2: //Ingreso:
                cuenta.addIngresos(pedirDescripcion(),pedirCantidad());
                mostrarSaldo(usuario, cuenta,1);
            case 3: //Mostrar gastos:
                if (cuenta.getGastos().isEmpty()){
                    System.out.println("No ha realizado ningun gasto.");
                }
                for (Gasto gasto: cuenta.getGastos()) {
                    System.out.printf("Gasto: %s, cantidad: %s €\n", gasto.getDescription(), gasto.getDinero());
                }
                mostrarMenu(usuario, cuenta);
            case 4: //Mostrar ingresos:
                if (cuenta.getIngresos().isEmpty()){
                    System.out.println("No ha realizado ningun ingreso.");
                }
                for (Ingreso ingreso: cuenta.getIngresos()) {
                    System.out.printf("Ingreso: %s, cantidad: %s €\n", ingreso.getDescription(), ingreso.getDinero());
                }
                mostrarMenu(usuario, cuenta);
            case 5: //Mostrar saldo:
                mostrarSaldo(usuario,cuenta,2);
            case 0:
                System.out.println("Fin del programa. \nGracias por utilizar la aplicacion.");
                System.exit(0);
            default: // Opcion > 5 || Opcion < 0:
                System.err.println("Por favor, introduzca un valor valido. (Mayor o igual que 0 y menor o igual que 5.)");
                mostrarMenu(usuario, cuenta);
        }
    }
}