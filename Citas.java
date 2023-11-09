
//Commit 4 (Subclase citas)
import java.io.*;
import java.util.*;

public class Citas extends Consulta {

    String archivo = "clientes.csv";

    public Citas(String usuario, String fecha, String diagnostico, String doctor, String farmacia, int hora,
            int total) {
        super(usuario, fecha, diagnostico, doctor, farmacia, hora, total);
    }

    