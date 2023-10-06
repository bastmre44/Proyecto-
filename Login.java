import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    private String archivo = "usuarios.csv";

    public boolean autenticar(String usuario, String contraseña) {
        try (CSVReader reader = new CSVReader(new FileReader(archivo))) {
            String[] rotulos = reader.readNext();
            int posicionUsuario = -1;
            int posicionContraseña = -1;

            for (int i = 0; i < rotulos.length; i++) {
                if ("Usuario".equalsIgnoreCase(rotulos[i])) {
                    posicionUsuario = i;
                } else if ("Contraseña".equalsIgnoreCase(rotulos[i])) {
                    posicionContraseña = i;
                }
            }

            if (posicionUsuario == -1 || posicionContraseña == -1) {
                System.err.println("No se encontró usuario/contraseña.");
                return false;
            }

            String[] tempo;
            while ((tempo = reader.readNext()) != null) {
                String usuariocsv = tempo[posicionUsuario];
                String contraseñacsv = tempo[posicionContraseña];
                if (usuario.equals(usuariocsv) && contraseña.equals(contraseñacsv)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        Login login = new Login();
        Scanner leer = new Scanner(System.in);

        System.out.print("Bienvenido, por favor ingrese la información que se le solicita: ");
        System.out.print("Usuario: ");
        String ingreso_usuario = leer.nextLine();
        System.out.print("Contraseña: ");
        String ingreso_contraseña = leer.nextLine();

        if (login.autenticar(ingreso_usuario, ingreso_contraseña)) {
            System.out.println("Bienvenido.");
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }

        leer.close();
    }
}
