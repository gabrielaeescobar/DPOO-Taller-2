package taller2.modelo;

import java.io.File;
import java.util.ArrayList;

public class Pedido{
	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	// no entiendo aca que con el array de una interfaz 
	private ArrayList<Producto> itemsPedido;
	
	public Pedido(String nombreCliente, String direccionCliente)
	{
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
	}
	
	public int getIdPedido()
	{
		return idPedido;
		//PENDIENTE
	}
	
	public void agregarProducto (Producto nuevoItem)
	{
		//PENDIENTE
	}
	
	private int getPrecioNetoPedido()
	{
		return 0;
		//PENDIENTE
		
	}
	
	private int getPrecioTotalPedido()
	{
		return 0;
		//PENDIENTE
		
	}
	
	private int getPrecioIVAPedido()
	{
		return 0;
		//PENDIENTE
	}
	
	private String generarTextoFactura()
	{
		return null;
		//PENDIENTE
	}
	
	public void guardarFactura(File archivo)
	{
		//PENDIENTE
	}

}
