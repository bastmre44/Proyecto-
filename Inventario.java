public class Inventario {
    int id_producto;
    String nombre;
    int precio;
    int stock;
    int vendidos;
    String archivo = "inventario.csv";

    public Inventario(int id_producto, String nombre, int precio, int stock, int vendidos) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.vendidos = vendidos;

    }

    public int getId() {
        return id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public int getVendidos() {
        return vendidos;
    }
}
