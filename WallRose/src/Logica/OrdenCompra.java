package Logica;

import java.time.LocalDateTime;

public class OrdenCompra {
	
	private Clientes cliente;
	private LocalDateTime fechaDeCompra;
	private String estadoDeCompra;
	private int idOrden;
	private static int consecutivoO = 1;
	
	
	public OrdenCompra(String estadoDeCompra, Clientes cliente)
	{
		this.estadoDeCompra = estadoDeCompra;
		this.cliente = cliente;
		fechaDeCompra = LocalDateTime.now();
		idOrden = consecutivoO;
		consecutivoO++;
		
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
	
	
	
	public String toString()
	{
		
		String resultado= "Estado de compra: " + estadoDeCompra + "\n"
	            + "Fecha de compra: " + fechaDeCompra+ "\n"
	            + "ID de orden de compra: " + idOrden + "\n";


	    return resultado;
		
	}

	
	

}
