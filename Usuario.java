public class Usuario {
    protected String usuario; // se crea las variables
    protected String nombre;
    protected String apellido;
    protected int telefono;
    protected String rol;
    protected String contraseña;

    public Usuario(String usuario, String nombre, String apellido, int telefono, String rol, String contraseña) { // se
                                                                                                                  // crea
                                                                                                                  // el
                                                                                                                  // constructor
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        this.contraseña = contraseña;
    }

    public String getUsuario() { // se hacen los gets
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getRol() {
        return rol;
    }

    public String getContraseña() {
        return contraseña;
    }
}