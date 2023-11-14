import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        boolean go = true;

        while (go) {
            Scanner leer = new Scanner(System.in); // objeto scanner
            System.out.println("Bienvenido al sistema de Swift Vision, por favor selecciona una opción ");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            int opcion = Integer.parseInt(leer.nextLine()); // Leer la opción ingresada por el usuario

            switch (opcion) {
                case 1:
                    Login.main(args);
                    break;

                case 2:
                    System.out.println();
                    Registrar.main(args);
                    break;

                case 3:
                    go = false;

                default:
                    System.out.println("\u001B[31mOpción invalida");
                    System.out.println("\u001B[37m");
                    break;
            }
            leer.close();
        }

    }

}
