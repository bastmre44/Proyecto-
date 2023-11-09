
// Commit1 (Superclase Consulta, propiedades, constructor)
import java.io.*;
import java.util.*;

public class Consulta {

    protected String usuario;
    protected String fecha;
    protected int hora;
    protected String diagnostico;
    protected String doctor;
    protected String farmacia;
    protected int total;

    public Consulta(String usuario, String fecha, String diagnostico, String doctor, String farmacia, int hora,
            int total) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.doctor = doctor;
        this.farmacia = farmacia;
        this.hora = hora;
        this.total = total;
    }
