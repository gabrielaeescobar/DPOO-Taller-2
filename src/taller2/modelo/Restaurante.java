package taller2.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurante {
	
	private ArrayList<Combo> combos;
	private ArrayList<Pedido> pedidos;
	private Pedido pedidoEnCurso;
	private ArrayList<ProductoMenu> menuBase;
	private ArrayList<Ingrediente> ingredientes;
	
	public Restaurante()
	{
		
	}
	
	
	public void iniciarPedido(String nombreCliente, String direccionCliente)
	{
		// PENDIENTE
		
	}
	
	public void cerrarYGuardarPedido()
	{
		// PENDIENTE

	}
	
	public Pedido getPedidoEnCurso()
	{
		return pedidoEnCurso;
	}
	
	public ArrayList<ProductoMenu> getMenuBase()
	{
		return menuBase;
	
	}
	
	public ArrayList<Ingrediente> getIngredientes()
	{
		return ingredientes;
		
	}
	
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos)
	{
	}
	
	public static ArrayList<Ingrediente> cargarIngredientes(String archivoIngr)
	{	
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivoIngr));
			String linea;
			System.out.println("LOS INGREDIENTES");
	        while ((linea = br.readLine()) != null) {
	            String[] partes = linea.split(";"); 
	            if (partes.length == 2) {
	                String nombre = partes[0].trim();
	                int precio = Integer.parseInt(partes[1].trim());

	                Ingrediente elIngrediente = buscarIngrediente(ingredientes, nombre, precio);
	                if (elIngrediente == null) {
	                    elIngrediente = new Ingrediente(nombre, precio);
	                    ingredientes.add(elIngrediente);
	                    System.out.println(nombre);
	                }
	            } else {
	                // Handle lines that do not match the expected format
	                System.err.println("Invalid line: " + linea);
	            }
	        }

	        br.close();

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return ingredientes;
	}
	
	private static Ingrediente buscarIngrediente(ArrayList<Ingrediente> ingredientes, String nombreIngr, int precio)
	{
		Ingrediente elIngr = null;

		for (int i = ingredientes.size() - 1; i >= 0 && elIngr == null; i--)
		{
			Ingrediente unIngr = ingredientes.get(i);
			if (unIngr.getNombre().equals(nombreIngr) && unIngr.getCostoAdicional() == precio)
			{
				elIngr = unIngr;
			}
		}

		return elIngr;
	}

	
	public static ArrayList<ProductoMenu> cargarMenu(String archivoMenu)
	{
		ArrayList<ProductoMenu> menu = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
			String linea;
			System.out.println("\nEL MENU");
	        while ((linea = br.readLine()) != null) {
	            String[] partes = linea.split(";"); 
	            if (partes.length == 2) {
	                String nombre = partes[0].trim();
	                int precio = Integer.parseInt(partes[1].trim());

	                ProductoMenu elProduMenu = buscarMenu(menu, nombre, precio);
	                if (elProduMenu == null) {
	                    elProduMenu = new ProductoMenu(nombre, precio);
	                    menu.add(elProduMenu);
	                    System.out.println(nombre);
	                }
	            } else {
	                // Handle lines that do not match the expected format
	                System.err.println("Invalid line: " + linea);
	            }
	        }

	        br.close();

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return menu;

	}
	private static ProductoMenu buscarMenu(ArrayList<ProductoMenu> menu, String nombreMenu, int precioBase)
	{
		ProductoMenu elProduMenu = null;

		for (int i = menu.size() - 1; i >= 0 && elProduMenu == null; i--)
		{
			ProductoMenu unProduMenu = menu.get(i);
			if (unProduMenu.getNombre().equals(nombreMenu) && unProduMenu.getPrecio() == precioBase)
			{
				elProduMenu = unProduMenu;
			}
		}

		return elProduMenu;
	}


	
	
	public static ArrayList<Combo> cargarCombos(String archivoCombos)
	{
		ArrayList<Combo> combo = new ArrayList();
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
			String linea;
			System.out.println("\nLOS COMBOS");
	        while ((linea = br.readLine()) != null) {
	            String[] partes = linea.split(";");
	            if (partes.length == 5) {
	                String nombre = partes[0].trim();
	                double precio = Double.parseDouble(partes[1].trim());
	                String hamburguesa = partes[2].trim();
	                String papas = partes[3].trim();
	                String bebida = partes[4].trim();

	            }
	
	        }
	        
		}
	        catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	//hacer buscar combo para terminar la carga de combos
	


	private static ProductoMenu buscarMenu(ArrayList<ProductoMenu> menu, String nombreMenu, int precioBase)
	{
		ProductoMenu elProduMenu = null;

		for (int i = menu.size() - 1; i >= 0 && elProduMenu == null; i--)
		{
			ProductoMenu unProduMenu = menu.get(i);
			if (unProduMenu.getNombre().equals(nombreMenu) && unProduMenu.getPrecio() == precioBase)
			{
				elProduMenu = unProduMenu;
			}
		}

		return elProduMenu;
	}

	
	
	// PENDEINTE how tf is this done ????? public Restaurante();
	

}
