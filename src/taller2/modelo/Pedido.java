package taller2.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pedido{
	private static int numeroPedidos;
	private static int pedidoCounter = 1;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsPedido;
	
	public Pedido(String nombreCliente, String direccionCliente)
	{
		this.idPedido = pedidoCounter++;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.itemsPedido = new ArrayList<>();
        numeroPedidos++;
	}
	
	public int getIdPedido()
	{
		return idPedido;
		//PENDIENTE
	}
	
	public void agregarProducto (Producto nuevoItem)
	{
		itemsPedido.add(nuevoItem);
	}
	
	private int getPrecioNetoPedido()
	{
		int precioNeto = 0;
        for (Producto item : itemsPedido) {
            precioNeto += item.getPrecio();
        }
        return precioNeto;
		
	}
	
	private int getPrecioTotalPedido()
	{
		return 0;
		//PENDIENTE
		
	}
	
	private int getPrecioIVAPedido()
	{
		int precioNeto = getPrecioNetoPedido();
        double ivaP = 0.19; // IVA == 19%
        int ivaPedido = (int) (precioNeto * ivaP);
        return ivaPedido;
	}
	
	private String generarTextoFactura()
	{
		StringBuilder factura = new StringBuilder();
        factura.append("Factura - Pedido #" + idPedido + "\n");
        factura.append("Cliente: " + nombreCliente + "\n");
        factura.append("Dirección: " + direccionCliente + "\n");
        factura.append("Productos:\n");

        for (Producto item : itemsPedido) {
            factura.append(item.getNombre() + ": $" + item.getPrecio() + "\n");
        }

        factura.append("Precio Neto: $" + getPrecioNetoPedido() + "\n");
        factura.append("IVA (12%): $" + getPrecioIVAPedido() + "\n");
        factura.append("Precio Total: $" + getPrecioTotalPedido() + "\n");

        return factura.toString();
	}
	
	public void guardarFactura(File archivo)
	{
		try (FileWriter writer = new FileWriter(archivo)) {
        String facturaText = generarTextoFactura();
        writer.write(facturaText);
        System.out.println("Factura guardada en: " + archivo.getAbsolutePath());
    } catch (IOException e) {
        e.printStackTrace();
    }
	}
	
	public static int getNumeroPedidos() {
        return numeroPedidos;
    }

}
