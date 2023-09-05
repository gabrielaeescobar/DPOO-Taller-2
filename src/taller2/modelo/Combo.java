package taller2.modelo;

import java.util.ArrayList;

public class Combo implements Producto{
	private static int nextId = 1; // Static ID counter
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
	
	public void agregarItemACombo(Producto itemCombo)
	{
		
	}
	
	//de la INTERFACE PRODUCTO
	public int getPrecio()
	{
		return 0;
		
	}
	
	public String generarTextoFactura()
	{
		return null;
		
	}
	
	public String getNombre()
	{
		return nombreCombo;
		
	}
	
	public int getId() {
        return id;
    }
	

}
