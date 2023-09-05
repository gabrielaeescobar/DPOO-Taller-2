package taller2.modelo;

public class Ingrediente {
	private static int nextId = 1; // Static ID counter
    private int id;
	private String nombre;
	private int costoAdicional;
	
	public Ingrediente(String nombre, int costoAdicional)
	{
		this.id = nextId++;
		this.nombre= nombre;
		this.costoAdicional= costoAdicional;
				
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getCostoAdicional()
	{
		return this.costoAdicional;
	}
	
	public int getId() 
	{
        return id;
    }

}
