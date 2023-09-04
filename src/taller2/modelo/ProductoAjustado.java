package taller2.modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto{
	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	
	public ProductoAjustado(ProductoMenu base)
	{
		this.base = base;
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
		return null;
	
		
	}
	

}
