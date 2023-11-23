import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Registrar extends Usuario { // para el registro extendemos de usuario

    String archivo = "usuarios.csv"; // ponemos como se llama el csv al que queremos ingresar

    public Registrar(String usuario, String nombre, String apellido, int telefono, String rol, String contraseña) {
        super(usuario, nombre, apellido, telefono, rol, contraseña); // llamamos al constructor de Usuario
    }

    public void guardarusuario(Usuario usuario) { // guarda los datos del usuario en el csv con los gets que estan en la
                                                  // superclase

        try {
            FileWriter insertar = new FileWriter(archivo, true);
            insertar.append(usuario.getUsuario());
            insertar.append(",");
            insertar.append(usuario.getNombre());
            insertar.append(",");
            insertar.append(usuario.getApellido());
            insertar.append(",");
            insertar.append(String.valueOf(usuario.getTelefono()));
            insertar.append(",");
            insertar.append(usuario.getRol());
            insertar.append(",");
            insertar.append(usuario.getContraseña());
            insertar.append("\n");
            insertar.flush();
            insertar.close();
            System.out.println("Su registro ha sido exitoso.");
        } catch (IOException e) {
            System.err.println("Error, no se guardaron los datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) { // metodo para solicitarle al usuario su información
        Scanner leer = new Scanner(System.in);
        System.out.print("Para ingresar un nuevo usuario, proporciona la siguiente información: \n");
        System.out.print("Usuario: ");
        String usuario = leer.nextLine();
        System.out.print("Nombre: ");
        String nombre = leer.nextLine();
        System.out.print("Apellido: ");
        String apellido = leer.nextLine();
        System.out.print("Telefono: ");
        int telefono = Integer.parseInt(leer.nextLine());
        System.out.print("Rol (cliente/trabajador): ");
        String rol = leer.nextLine();
        System.out.print("Contraseña (sin numeros): ");
        String contraseña = leer.nextLine();

        leer.close();

        Usuario user = new Usuario(usuario, nombre, apellido, telefono, rol, contraseña);
        Registrar guardar = new Registrar(usuario, nombre, apellido, telefono, rol, contraseña);
        guardar.guardarusuario(user);
    }
}
