package Logica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdenCompra {

    private Clientes cliente;
    private LocalDateTime fechaDeCompra;
    private String estadoDeCompra;
    private int idOrden;
    private static int consecutivoO = 1;

    private List<DetallesDeCompra> detalles;

    public OrdenCompra(String estadoDeCompra, Clientes cliente)
    {
        this.estadoDeCompra = estadoDeCompra;
        this.cliente = cliente;
        fechaDeCompra = LocalDateTime.now();
        idOrden = consecutivoO;
        consecutivoO++;
        this.detalles = new ArrayList<>();
    }

    public Clientes getCliente()
    {
        return cliente;
    }

    public String getEstadoDeCompra() {
        return estadoDeCompra;
    }

    public void setEstadoDeCompra(String estadoDeCompra) {
        this.estadoDeCompra = estadoDeCompra;
    }

    public LocalDateTime getFechaDeCompra() {
        return fechaDeCompra;
    }

    public int getIdOrden() {
        return idOrden;
    }
    
    public List<DetallesDeCompra> getDetalles() {
        return detalles;
    }

    public void agregarDetalle(DetallesDeCompra detalle)
    {
        detalles.add(detalle);
    }

    public void eliminarDetalle(DetallesDeCompra detalle)
    {
        detalles.remove(detalle);
    }

    
    public double total()
    {
        double suma = 0;

        for (int i = 0; i < detalles.size(); i++)
        {
            DetallesDeCompra detalle = detalles.get(i);
            suma = suma + detalle.getProducto().getPrecio() * detalle.getCantidad();
        }

        return suma;
    }

    public double impuesto()
    {
        return total() * 0.13;
    }

    public double totalConImpuesto()
    {
        return total() + impuesto();
    }

    public String toString()
    {
       String resultado =  "Estado de compra: " + estadoDeCompra + "\n"
             + "Fecha de compra: " + fechaDeCompra + "\n"
             + "ID de orden compra: " + idOrden + "\n"
             + "Total sin impuesto: " + total() + "\n"
             + "Impuesto: " + impuesto() + "\n"
             + "Total final: " + totalConImpuesto() + "\n";
       return resultado;
		
	}

	
	

}
