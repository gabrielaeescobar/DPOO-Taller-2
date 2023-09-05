package taller2.modelo;

public class ProductoMenu implements Producto{
	private static int nextId = 1;
	private int id;
	private String nombre;
	private int precioBase;
	
	
	public ProductoMenu(String nombre, int precioBase)
	{
		this.id = nextId++;
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
	
	public int getId() 
	{
        return id;
    }

	


}
