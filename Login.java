import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
    private String archivo = "usuarios.csv";

    public String obtenerRol(String nombre, String contraseña) {
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
                    String usuario = rotulos[0].trim();
                    String Contraseña = rotulos[5].trim();
                    String rol = rotulos[4].trim();

                    if (usuario.equals(nombre) && Contraseña.equals(contraseña)) {
                        leer.close();
                        return rol;
                    }
                }
            }
            leer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresa los datos que se te solicitan:");
        System.out.print("Usuario: ");
        String nombre = leer.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = leer.nextLine();

        Login login = new Login();
        String rol = login.obtenerRol(nombre, contraseña);

        if (rol != null) {
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("¡Muy bien, empezemos, " + nombre + "!");

            if (rol.equals("cliente")) {
                MenuU.main(args);
            } else if (rol.equals("trabajador")) {
                MenuT.main(args);
            }
        } else {
            System.out.println("Oh no parece que tu usuario o contraseña son incorrectos.");
            System.exit(0);
        }

        leer.close();
    }
}
