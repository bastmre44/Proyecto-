import java.util.Scanner;

public class MenuU { // Menú para clientes
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Qué deseas hacer? selecciona una opcion");
        System.out.println("1. Reservar una cita");
        System.out.println("2. Ver historial clinico");
        System.out.println("3. Editar datos personales");
        System.out.println("4. Salir");
        int a = leer.nextInt();
        switch (a) {
            case 1:
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------");
                CitaU.main(args);
                break;

            case 2:
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------");
                historialclicU.main(args);
                break;

            case 3:
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------");
                ActualizarUsuariosU.main(args);
                break;

            case 4:
                System.out.println("Saliendo del programa. ¡Hasta luego!");
                System.exit(0);
                break;
        }
        leer.close();
    }

}
