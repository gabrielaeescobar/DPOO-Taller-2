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
	
	
	public Pedido iniciarPedido(String nombreCliente, String direccionCliente)
	{
		pedidos = new ArrayList<>();
		Pedido nuevoPedido = new Pedido(nombreCliente, direccionCliente);
	    pedidos.add(nuevoPedido);
	    pedidoEnCurso = nuevoPedido;
	    int id = nuevoPedido.getIdPedido();
	    System.out.println("Pedido iniciado para " + nombreCliente + " en " + direccionCliente + " con ID " + id);	
	    return nuevoPedido;
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
	
	public static Restaurante cargarInformacionRestaurante(String archivoIngredientes, String archivoMenu, String archivoCombos) {
	    ArrayList<Ingrediente> ingredientes = cargarIngredientes(archivoIngredientes);
	    ArrayList<ProductoMenu> menu = cargarMenu(archivoMenu);
	    ArrayList<Combo> combos = cargarCombos(archivoCombos);
	    // se un nuevo restaurante y se le inicializan los ingredientes, menu y combos
	    Restaurante restaurante = new Restaurante();
	    restaurante.setIngredientes(ingredientes);
	    restaurante.setMenuBase(menu);
	    restaurante.setCombos(combos);
	    
	    return restaurante;
	}
	
	///setters
	
	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setMenuBase(ArrayList<ProductoMenu> menuBase) {
        this.menuBase = menuBase;
    }

    public void setCombos(ArrayList<Combo> combos) {
        this.combos = combos;
    }
    /// final de setters
	
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
	                    System.out.println("Ingrediente ID: " + elIngrediente.getId() + ", Nombre: " + nombre);
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
	                    System.out.println("ProductoMenu ID: " + elProduMenu.getId() + ", Nombre: " + nombre);
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


	
	
	private static ArrayList<Combo> cargarCombos(String archivoCombos)
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
	                String descuento0 = partes[1].trim();
	                double descuento = Double.parseDouble(descuento0.replace("%", ""));
	                String hamburguesa = partes[2].trim();
	                String papas = partes[3].trim();
	                String bebida = partes[4].trim();
	                Combo elCombo = buscarCombo(combo,nombre);
	                if (elCombo == null) {
	                    elCombo = new Combo(nombre, descuento);
	                    combo.add(elCombo);
	                    System.out.println("Combo ID: " + elCombo.getId() + ", Nombre: " + nombre);
	                }
	            } else {
	                // Handle lines that do not match the expected format
	                System.err.println("Invalid line: " + linea);
	            }
	        }

	        br.close();
	            }
	        catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		return combo;
		}
	
	private static Combo buscarCombo(ArrayList<Combo> combo, String nombreCom)
	{
		Combo elCombo = null;

		for (int i = combo.size() - 1; i >= 0 && elCombo == null; i--)
		{
			Combo unCombo = combo.get(i);
			if (unCombo.getNombre().equals(nombreCom))
			{
				elCombo = unCombo;
			}
		}

		return elCombo;
	}

	
	
}
	

