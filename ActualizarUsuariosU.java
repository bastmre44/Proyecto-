import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ActualizarUsuariosU {

    private String archivo = "usuarios.csv";

    public void actualizarUsuario(String usuario, String nuevoNombre, String nuevoApellido,
            String nuevoTelefono, String nuevoRol, String nuevaContraseña) {
        try {
            File archivoCSV = new File(archivo);
            Scanner leer = new Scanner(archivoCSV);
            StringBuilder nuevo = new StringBuilder();

            if (leer.hasNextLine()) {
                nuevo.append(leer.nextLine()).append("\n");
            }

            while (leer.hasNextLine()) {
                String linea = leer.nextLine();
                String[] columna = linea.split(",");
                String usuarioo = columna[0].trim();

                if (usuarioo.equals(usuario)) {
                    columna[1] = nuevoNombre;
                    columna[2] = nuevoApellido;
                    columna[3] = nuevoTelefono;
                    columna[4] = nuevoRol;
                    columna[5] = nuevaContraseña;
                }

                nuevo.append(String.join(",", columna)).append("\n");
            }
            leer.close();

            // reemplazar los datos del usuario
            FileWriter escribir = new FileWriter(archivo);
            escribir.write(nuevo.toString());
            escribir.close();

            System.out.println("Información actualizada con éxito para el usuario: " + usuario);

            // Regresar al menú de usuarios
            MenuU.main(new String[]{});
        } catch (IOException e) {
            System.err.println("Error al actualizar la información: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Usuario: ");
        String usuario = leer.nextLine();
        System.out.print("Nuevo Nombre: ");
        String nuevoNombre = leer.nextLine();
        System.out.print("Nuevo Apellido: ");
        String nuevoApellido = leer.nextLine();
        System.out.print("Nuevo Teléfono: ");
        String nuevoTelefono = leer.nextLine();
        System.out.print("Nuevo Rol: ");
        String nuevoRol = leer.nextLine();
        System.out.print("Nueva Contraseña: ");
        String nuevaContraseña = leer.nextLine();
        leer.close();

        ActualizarUsuariosU actualizarUsuarios = new ActualizarUsuariosU();
        actualizarUsuarios.actualizarUsuario(usuario, nuevoNombre, nuevoApellido, nuevoTelefono, nuevoRol,
                nuevaContraseña);
    }
}
