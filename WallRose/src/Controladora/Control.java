package Controladora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Logica.Clientes;
import Logica.OrdenCompra;
import Logica.Producto;

public class Control
{
    private static Control instance;
    private List<Clientes> clientes;
    private List<Producto> productos;
    private Map<Integer, OrdenCompra> ordenes;

    private Clientes clienteActual;
    private Producto productoActual;
    
    private Control() 
    {
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
        ordenes = new HashMap<>();
    }

    public static Control getInstance()
    {
        if (instance == null)
        {
            instance = new Control();
        }

        return instance;
    }
    //*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
    public void agregarCliente(String idCliente,String nombre,String correo)
    {
    	clientes.add(new Clientes(idCliente, nombre, correo));
    }

    public List<Clientes> obtenerListadoClientes()
    {
        return clientes;
    }
    
    public Clientes buscarCliente(String idCliente)
    {
    	 for (Clientes clien : clientes) 
    	 {
    	    
    		if (clien.getIdCliente() == (idCliente)) 
    		{
               return clien;
    	    }
    		
    	 }
    	 return null;
    }
    
    public void eliminarCliente(String idCliente) throws Exception
    {
        Clientes clien = buscarCliente(idCliente); //Esto recorre la lista de clientes hasta encontrar el mismo id que se ingreso

        if (clien == null)
        {
            throw new Exception("El cliente no existe");
        }

        clientes.remove(clien);
    }


    public void cambiarCliente(String idCliente) throws Exception
    {
        Clientes clien = buscarCliente(idCliente); //Esto recorre la lista de clientes hasta encontrar el mismo id que se ingreso

        if (clien == null) 
        {
            throw new Exception("El cliente no es válido");
        }

        clienteActual = clien; // Selecciona el cliente que se busco y lo marca para que se pueda hacer el cambio correspondiente
    }

    //*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
    
    public void agregarProducto(String nombreProducto, double precio, int disponible)
    {
        productos.add(new Producto(nombreProducto, precio, disponible));
    }

    public List<Producto> obtenerListadoProductos()
    {
        return productos;
    }
    
    public Producto buscarProducto(int idProducto)
    {
    	for (Producto produc : productos) 
   	 		{
   	    
    			if (produc.getIdProducto() == (idProducto)) 
    			{
    				return produc;
    			}
   		
   	 		}
   	 	return null;
    }
    
    
    public void eliminarProducto(int idProducto) throws Exception
    {
    	Producto produc = buscarProducto(idProducto); 

        if (produc == null)
        {
            throw new Exception("El producto no existe");
        }

        productos.remove(produc);
    }

    public void cambiarProducto(int idProducto) throws Exception
    {
    	Producto produc = buscarProducto(idProducto); 
    	
        if (produc == null) 
        {
            throw new Exception("El producto no es válido");
        }

        productoActual = produc; 
    }

  
}