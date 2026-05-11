package Logica;

import java.time.LocalDateTime;

public class Clientes {
	
	private String nombre;
	private String correo;
	private String idCliente;
	private int codigoCliente;
	private static int consecutivoC = 1;
	
	
	public Clientes(String nombre, String correo, String idCliente)
	{
		this.nombre = nombre;
		this.correo = correo;
		this.idCliente = idCliente;
		this.codigoCliente = consecutivoC;
		consecutivoC++;
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getCodigoCliente() {
	    return codigoCliente;
	}
	
	public String toString()
	{
		
		String resultado= "Nombre: " + nombre + "\n"
	            + "Correo: " + correo + "\n"
	            + "Identificacion cliente: " + idCliente + "\n";


	    return resultado;
		
	}

}
