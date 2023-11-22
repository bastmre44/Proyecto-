import java.io.*;
import java.util.Scanner;

public class Cancelar {

    public static void main(String[] args) {
        String temporal = "temporal.csv";
        String original = "clientes.csv";
        String linea = "";
        String nombre = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la persona con la que se guardó la cita:");
        nombre = scanner.nextLine();

        try {
            BufferedReader read = new BufferedReader(new FileReader(original));
            BufferedWriter write = new BufferedWriter(new FileWriter(temporal));

            while ((linea = read.readLine()) != null) {
                if (!linea.contains(nombre)) {
                    write.write(linea);
                    write.newLine();
                }
            }

            read.close();
            write.close();
            scanner.close();

            // Eliminamos el archivo original
            File antiguo = new File(original);
            antiguo.delete();

            // Renombramos el nuevo archivo (temporal)
            File nuevo = new File(temporal);
            nuevo.renameTo(antiguo);
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }
}