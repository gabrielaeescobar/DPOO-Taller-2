package taller2.modelo;

public class ProductoMenu implements Producto{
	
	private String nombre;
	private int precioBase;
	
	
	public ProductoMenu(String nombre, int precioBase)
	{
		this.nombre = nombre;
		this.precioBase = precioBase;
	}
	//de la INTERFACE PRODUCTO
	public int getPrecio()
	{
		return precioBase;
		
	}
	
	public String generarTextoFactura()
	{
		return null;
		//PENDIENTE
	}
	
	public String getNombre()
	{
		return nombre;
	
		
	}
	


}
