import java.util.Scanner;

public class MenuT { // menú para trabajadores
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Qué deseas hacer? selecciona una opcion:");
        System.out.println("1. Reservar una cita");
        System.out.println("2. Ver historial clinico");
        System.out.println("3. Ir a inventario");
        System.out.println("4. Eliminar cita");
        System.out.println("5. Editar datos personales");
        System.out.println("6. Salir");
        int a = leer.nextInt();
        switch (a) {
            case 1:
                System.out.println();
                CitaT.main(args);
                break;

            case 2:
                System.out.println();
                historialclicT.main(args);
                break;

            case 3:
                System.out.println();
                Inventario.main(args);
                break;

            case 4:
                System.out.println();
                Cancelar.main(args);

            case 5:
            ActualizarUsuariost.main(args);
                break;

            case 6:
                System.out.println("Saliendo del programa. ¡Hasta luego!");
                System.exit(0);
                break;
        }
        leer.close();
    }
}
