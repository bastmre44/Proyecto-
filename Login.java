import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
    private String archivo = "usuarios.csv"; // ponemos como se llama el csv al que queremos ingresar

    public boolean login(String nombre, String contraseña) { // metodo para almacenar y verificar el usuario y
                                                             // contraseña
        try {
            File archivoCSV = new File(archivo);
            Scanner leer = new Scanner(archivoCSV);

            if (leer.hasNextLine()) {
                leer.nextLine();
            }

            while (leer.hasNextLine()) {
                String linea = leer.nextLine();
                String[] rotulos = linea.split(",");

                if (rotulos.length == 6) {
                    String usuario = rotulos[0].trim();// se especifica en que columna se debe buscar en el excel
                    String Contraseña = rotulos[5].trim();

                    if (usuario.equals(nombre) && Contraseña.equals(contraseña)) {
                        leer.close();
                        return true;

                    }
                }
            }
            leer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) { // metodo para solicitarle al usuario sus credenciales
        Scanner leer = new Scanner(System.in);
        System.out.println("Bienvenido al programa, por favor brinda los datos que se te solicitan:");
        System.out.print("Usuario: ");
        String nombre = leer.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = leer.nextLine();

        Login login = new Login();
        boolean ingreso = login.login(nombre, contraseña);

        if (ingreso) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Bienvenido " + nombre);
            System.out.println();
            System.out.println();
            System.out.println("Qué deseas hacer? selecciona una opcion");
            System.out.println("1. Reservar una cita");
            System.out.println("2. Ver historial clinico");
            System.out.println("3. Ir a inventario");
            System.out.println("4. Salir");
            int a = leer.nextInt();

            switch (a) {
                case 1:
                    System.out.println();
                    Cita.main(args);
                    break;

                case 2:
                    System.out.println();
                    historialclic.main(args);
                    break;

                case 3:
                    System.out.println();
                    Inventario.main(args);
                    break;

                case 4:
                    System.exit(0);
                    break;
            }

        } else {
            System.out.println("Error, usuario o contraseña incorrectos.");
            System.exit(0);
        }

        leer.close();
    }
}
