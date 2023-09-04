package taller2.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PruebaCarga {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n" + "Cargar un archivo de atletas" + "\n");
		System.out.println("Por favor ingrese el nombre del archivo CSV con los atletas");
		String name = scanner.nextLine();
		ArrayList<String> ingredientes = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(name));
			String linea = br.readLine();
				
			linea = br.readLine();
			while (linea != null)
			{
				String[] partes = linea.split(",");
				String nombreIngrediente = partes[0];
				int precioIngrediente = Integer.parseInt(partes[1]);
			}
			
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
