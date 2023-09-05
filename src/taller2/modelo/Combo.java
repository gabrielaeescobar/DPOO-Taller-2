package taller2.modelo;

import java.util.ArrayList;

public class Combo implements Producto{
	private static int nextId = 1; 
    private int id; // Combo ID
	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> itemsCombo;
	
	public Combo(String nombre, double descuento)
	{
		this.id = nextId++;
		this.nombreCombo = nombre;
		this.descuento = descuento;
	}
	
	public void agregarItemACombo(ProductoMenu itemCombo)
	{
		itemsCombo.add(itemCombo);
	}
	
	public int getPrecio()
	{	
		int totalPrecio = 0;
		for (ProductoMenu item : itemsCombo) {
			totalPrecio += item.getPrecio();
		}

    totalPrecio -= (totalPrecio * descuento);

    return totalPrecio;
		
	}
	
	public String generarTextoFactura()
	{
		StringBuilder factura = new StringBuilder();
        factura.append("Combo: " + nombreCombo + "\n");
        factura.append("Items:\n");
        for (ProductoMenu item : itemsCombo) {
            factura.append(item.getNombre() + ": $" + item.getPrecio() + "\n");
        }
        factura.append("Descuento: " + (descuento * 100) + "%\n");
        factura.append("Precio con descuento: $" + getPrecio() + "\n");
        return factura.toString();
		
	}
	
	public String getNombre()
	{
		return nombreCombo;
		
	}
	
	public int getId() {
        return id;
    }
	

}
