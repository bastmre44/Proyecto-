import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in); //objeto scanner 
        System.out.println("Bienvenido al sistema de Swift Vision, por favor selecciona una opción ");
        System.out.println("1. Iniciar Sesión");
        System.out.println("2. Registrarse");
        System.out.println("3. Salir");
        int opcion = Integer.parseInt(leer.nextLine()); // Leer la opción ingresada por el usuario


        if (opcion == 1) {
            Login.main(args);
        }

        if (opcion == 2) {
            System.out.println();
            Registrar.main(args);
        }

        if (opcion == 3) {
            System.exit(0);
        }

        leer.close();
    }

}
