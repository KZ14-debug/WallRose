package Logica;

public class Producto {

    private int idProducto;
    private String nombreProducto;
    private double precio;
    private int disponible;
    private static int consecutivo = 1;

    
    public Producto(String nombreProducto, double precio, int disponible) {
    	
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.disponible = disponible;
        this.idProducto = consecutivo;
        consecutivo++;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    public String toString() {
        return "ID Producto: " + idProducto + "\n"
             + "Nombre: " + nombreProducto + "\n"
             + "Precio: " + precio + "\n"
             + "Disponibilidad: " + disponible + "\n";
    }
}


