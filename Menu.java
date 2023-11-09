import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de Swift Vision, por favor selecciona una opción ");
        System.out.println("1. Iniciar Sesión");
        System.out.println("2. Registrarse");
        System.out.println("3. Salir");
        int opcion = Integer.parseInt(leer.nextLine());

        if (opcion == 1) {
            Login.main(args);
            System.out.println("Qué deseas hacer? selecciona una opcion");
            System.out.println("1. Reservar una cita");
            System.out.println("2. Ver historial clinico");
            System.out.println("3. Ir a inventario");
            System.out.println("4. Salir");
            int a = Integer.parseInt(leer.nextLine());

            if (a == 1) {
                // consulta
            }
            if (a == 2) {
                historialclic.main(args);
            }
            if (a == 3) {
                Inventario.main(args);
            }
            if (a == 4) {
                System.exit(0);
            }

        }

        if (opcion == 2) {
            Registrar.main(args);
        }

        if (opcion == 3) {
            System.exit(0);
        }

        leer.close();
    }

}