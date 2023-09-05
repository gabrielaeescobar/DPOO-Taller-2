package taller2.consola;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import taller2.modelo.Combo;
import taller2.modelo.Ingrediente;
import taller2.modelo.Pedido;
import taller2.modelo.ProductoMenu;
import taller2.modelo.Restaurante;

public class Aplicacion {
	private Restaurante restaurante;
	public Aplicacion() {
        restaurante = new Restaurante(); // Initialize the restaurante object in the constructor
    }
	
	// en las ejecuciones de las funciones del menu de la aplicacion
	// donde necesite algo de Restaurante, lo llamo como restaurante
	
	public void ejecutarAplicacion()
	{	System.out.println("MENU HAMBURGUESAS\n");

		boolean sigapfythx = true;
		while (sigapfythx)
		{
			try
			{
				mostrarMenu();
				
				int opcionsele = Integer.parseInt(input("Por favor seleccione una opcion"));
				//PENDIENTE añadir el resto de ejecuciones
				// ej: ejecutarNuevoPedido
				if (opcionsele == 1)
					ejecutarCargarRestaurante();
				else if (opcionsele == 2)
					ejecutarIniciarPedido();
				else if (opcionsele == 3) 
					ejecutarAgregarElemento();
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
	private void ejecutarCargarRestaurante()
	{
		System.out.println("\n" + "Cargar un archivo de ingredientes" + "\n");
		String archivoIngre = "./data/ingredientes.txt";
		String archivoMenu = "./data/menu.txt";
		String archivoComb = "./data/combos.txt";
		ArrayList<ProductoMenu> menuBase;
		ArrayList<Ingrediente> ingredientes;
		ArrayList<Combo> combo;
		
		Restaurante.cargarInformacionRestaurante(archivoIngre, archivoMenu, archivoComb);

	}
	private void ejecutarIniciarPedido() {
		String nombre = (input("A nombre de quién quiere hacer el pedido?\n"));
		String direccion = (input("Direccion:\n"));
        Pedido pedido = restaurante.iniciarPedido(nombre, direccion);
        System.out.println("Pedido #" + pedido.getIdPedido() + " creado.");

	}
	
	private void ejecutarAgregarElemento() {
		System.out.println(Restaurante.cargarInformacionRestaurante("./data/ingredientes.txt", "./data/menu.txt", "./data/combos.txt"));
		int tipoAgregar=Integer.parseInt(input("Quiere agregar un elemento del menu? (1=si , 0 =no)"));
		if ((tipoAgregar) == 1) {
			ArrayList<ProductoMenu> menuBase = Restaurante.cargarMenu("./data/menu.txt");
			int idBuscado = Integer.parseInt(input("Seleccione el ID del elemento del MENU que quiera anadir:\n"));
			Pedido pedidoEnCurso = restaurante.getPedidoEnCurso();
	        
	        if (pedidoEnCurso != null) {
	            for (ProductoMenu unMenu : menuBase) {
	                if (unMenu.getId() == idBuscado) {
	                    pedidoEnCurso.agregarProducto(unMenu);
	                }
	            }
	        } else {
	            System.out.println("No hay un pedido en curso. Inicie un pedido primero.");
	        }}		
	        else if((tipoAgregar)==0) {
	        	System.out.println("No se agrego ningun elemento a su pedido");
			
		}
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