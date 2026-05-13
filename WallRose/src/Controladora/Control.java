package Controladora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    
    
    public Clientes buscarCliente(String idCliente) throws Exception
    {
    	for (int i = 0; i < clientes.size(); i++) //Esto recorre la lista de productos uno por uno
        {
        	
            if (clientes.get(i).getIdCliente() == idCliente ) 
            {
                return clientes.get(i); 
            }
            
        }

        throw new Exception("Cliente no encontrado");
    
    }
    
    
    public void eliminarCliente(String idCliente) throws Exception
    {
    	for (int i = 0; i < clientes.size(); i++) //Esto recorre la lista de clientes uno por uno
        {
        	
            if (clientes.get(i).getIdCliente().equals(idCliente)) // Se usa .equals() porque idCliente es un String y se debe comparar el contenido del texto
            {
                clientes.remove(i); //Al coincidir el id ingresado con el de la lista se elimina ese cliente mediante el id
                return;
            }
            
        }

        throw new Exception("Cliente no encontrado");
    }


    public void actualizarDatosCliente(String idCliente, String nombre, String correo)  throws Exception
    {
    	
    	for (int i = 0; i < clientes.size(); i++) //Esto recorre la lista de clientes uno por uno
        {
        	
            if (clientes.get(i).getIdCliente().equals(idCliente)) // Se usa .equals() porque idCliente es un String y se debe comparar el contenido del texto
            {
            	clientes.get(i).setNombre(nombre);
                clientes.get(i).setCorreo(correo);
                return;
            }
            
        }

        throw new Exception("Cliente no encontrado");
    
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
    
    
    public Producto buscarProducto(int idProducto) throws Exception
    {
    	for (int i = 0; i < productos.size(); i++) //Esto recorre la lista de productos uno por uno
        {
        	
            if (productos.get(i).getIdProducto() == idProducto ) 
            {
                return productos.get(i); 
            }
            
        }

        throw new Exception("Producto no encontrado");
    
    }
    
    
    public void eliminarProducto(int idProducto) throws Exception
    {
    	for (int i = 0; i < productos.size(); i++) //Esto recorre la lista de productos uno por uno
        {
        	
            if (productos.get(i).getIdProducto() == idProducto ) 
            {
                productos.remove(i); 
                return;
            }
            
        }

        throw new Exception("Producto no encontrado");
    }

    public void actualizarDatosProducto(int idProducto, String nombreProducto, double precio, int disponible)  throws Exception
    {
    	
    	for (int i = 0; i < productos.size(); i++) //Esto recorre la lista de clientes uno por uno
        {
        	
            if (productos.get(i).getIdProducto() == idProducto) // Se usa .equals() porque idCliente es un String y se debe comparar el contenido del texto
            {
            	productos.get(i).setNombreProducto(nombreProducto);
                productos.get(i).setPrecio(precio);
                productos.get(i).setDisponible(disponible);
                return;
            }
            
        }

        throw new Exception("Producto no encontrado");
    
    }

    //*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
    public void crearOrdenCompra(String estadoDeCompra, String idCliente) throws Exception
    {
    	Clientes cliente = buscarCliente(idCliente);

        OrdenCompra orden = new OrdenCompra(estadoDeCompra, cliente);

        ordenes.put(orden.getIdOrden(), orden);
    }

    
    public void eliminarOrdenCompra(int idOrden) throws Exception
    {

    	if(!ordenes.containsKey(idOrden))
		{
			throw new Exception("El identificador de esta orden no es valido");
		}
		ordenes.remove(idOrden);
    	
    }

    
    public OrdenCompra buscarOrdenCompra(int idOrden) throws Exception
    {
    	if (!ordenes.containsKey(idOrden))
        {
            throw new Exception("Orden no encontrada");
        }

        return ordenes.get(idOrden);
    	
    }

    
    public Map<Integer, String> obtenerListadoOrdenesCliente(String idCliente)
    {
        Map<Integer, String> resultado = new TreeMap<>();

        for (OrdenCompra orden : ordenes.values())
        {
            if (orden.getCliente().getIdCliente().equals(idCliente))
            {
                resultado.put(orden.getIdOrden(), orden.getEstadoDeCompra());
            }
        }

        return resultado;
    }
    

    public Map<Integer, String> obtenerListadoOrdenesPendientesCliente(String idCliente)
    {
    	Map<Integer, String> resultado = new TreeMap<>();

        for (OrdenCompra orden : ordenes.values())
        {
        	
            if (orden.getCliente().getIdCliente().equals(idCliente) && orden.getEstadoDeCompra().equals("Pendiente"))
            {
                resultado.put(orden.getIdOrden(), orden.getEstadoDeCompra());
            }
            
        }

        return resultado;
    }

    public Map<Integer, String> obtenerListadoOrdenesTerminadasCliente(String idCliente)
    {
    	Map<Integer, String> resultado = new TreeMap<>();

        for (OrdenCompra orden : ordenes.values())
        {
        	
            if (orden.getCliente().getIdCliente().equals(idCliente) && orden.getEstadoDeCompra().equals("Terminada"))
            {
                resultado.put(orden.getIdOrden(), orden.getEstadoDeCompra());
            }
            
        }

        return resultado;
    }

    public void establecerOrdenPendiente(int idOrden) throws Exception
    {

    	if (!ordenes.containsKey(idOrden))
        {
            throw new Exception("Orden no encontrada");
        }

        OrdenCompra orden = ordenes.get(idOrden);
        orden.setEstadoDeCompra("Pendiente");
    	
    }

    public void establecerOrdenTerminada(int idOrden) throws Exception
    {

    	if (!ordenes.containsKey(idOrden))
        {
            throw new Exception("Orden no encontrada");
        }

        OrdenCompra orden = ordenes.get(idOrden);
        orden.setEstadoDeCompra("Terminada");
    	
    }

   
}