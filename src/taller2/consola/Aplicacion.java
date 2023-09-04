package taller2.consola;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import taller2.modelo.Ingrediente;
import taller2.modelo.ProductoMenu;
import taller2.modelo.Restaurante;

public class Aplicacion {
	private static Restaurante restaurante;
	
	// en las ejecuciones de las funciones del menu de la aplicacion
	// donde necesite algo de Restaurante, lo llamo como restaurante
	
	public void ejecutarAplicacion()
	{	System.out.println("MENU HAMBURGUESAS\n");

		boolean sigapfythx = true;
		while (sigapfythx)
		{	System.out.println("whaat");

			try
			{
				mostrarMenu();
				
				int opcionsele = Integer.parseInt(input("Por favor seleccione una opcion"));
				//PENDIENTE añadir el resto de ejecuciones
				// ej: ejecutarNuevoPedido
				if (opcionsele == 1)
					ejecutarCargarIngredientes();
				else if (opcionsele == 6)
				{
					System.out.println("Saliendo de la aplicacion...");
					sigapfythx = false;
				}
				
					
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los numeros de las opciones");
			}
		}
	}
	
	private String input(String prompt) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print(prompt + " ");
	    String userInput = scanner.nextLine();
	    return userInput;
	}

	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Ver el menú");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la información de un pedido dado su id");
		System.out.println("6. Salir de la aplicación");
	}
	//PENDIENTE hacer el view de las opciones del menu,
	// de las funciones
	private void ejecutarCargarIngredientes()
	{
		System.out.println("\n" + "Cargar un archivo de ingredientes" + "\n");
		String archivoIngre = "./data/ingredientes.txt";
		String archivoMenu = "./data/menu.txt";
		String archivoComb = "./data/menu.txt";
		ArrayList<ProductoMenu> menuBase;
		ArrayList<Ingrediente> ingredientes;
		
		ingredientes = Restaurante.cargarIngredientes(archivoIngre);
		menuBase = Restaurante.cargarMenu(archivoMenu);

	}
	
	
	public static void main(String[] args)

	{	
		
		Aplicacion app = new Aplicacion();
		app.ejecutarAplicacion();
		
		/*
	
		System.out.println("AAAA");
		System.out.print("aaaaaabgixhbwih\n");
		Scanner scanner = new Scanner (System.in);
	
		System.out.println("what is ur name? ");
		
		String name = scanner.nextLine();
		
		System.out.println("how old r u? ");
		int age = scanner.nextInt();
		scanner.close();
		System.out.println("hello "+ name);
		System.out.println("ur "+ age + " years old");
		int friends = 10;
		friends = (int) ((double) friends / 3);
		
		
		System.out.println(friends);

		 */
		 
	}
}