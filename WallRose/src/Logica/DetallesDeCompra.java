package Logica;

public class DetallesDeCompra {
	
	private double cantidad;
	private Producto producto;
	
	public DetallesDeCompra(Producto producto, double cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

	public double getCantidad() {
		return cantidad;
	}

	public Producto getProducto() {
        return producto;
    }
	
	public double getCostos() {
        return producto.getPrecio() * cantidad;
    }
	
	
	public String toString() {
	    return "Producto: " + producto + "\n"
	         + "Cantidad: " + cantidad + "\n"
	         + "Costo: " + getCostos() + "\n";
	}
	

}
