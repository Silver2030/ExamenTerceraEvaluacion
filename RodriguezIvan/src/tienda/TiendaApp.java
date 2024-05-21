package tienda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TiendaApp {

	public static void main(String[] args) {
		ListaVentas obj = new ListaVentas();
		Scanner in = new Scanner(System.in);
		String venta = "", idBuscar = "";
		int resp = 0;
		
		try {
			obj.cargarDatos();
			do {
				System.out.println("|---------------------------------------|");
				System.out.println("|	       Menu Tienda		|");
				System.out.println("|---------------------------------------|");
				System.out.println();
				System.out.println("1) Agregar Venta");
				System.out.println("2) Buscar Ventas");
				System.out.println("3) Guardar Fichero");
				System.out.println("4) Mostrar Beneficios");
				System.out.println("5) Finalizar programa");
				System.out.print("Opcion: ");
				resp = in.nextInt();
				in.nextLine();
				System.out.println();
				
				switch(resp) {
				case 1:
					System.out.print("Tipo de Venta (VentaOnline/VentaLocal): ");
					venta = in.nextLine();
					System.out.println();
					while((!venta.equalsIgnoreCase("VentaOnline"))&&(!venta.equalsIgnoreCase("VentaLocal"))) {
						System.out.print("Dato introducido erroneo, tipo de Venta (VentaOnline/VentaLocal): ");
						venta = in.nextLine();
						System.out.println();
					}
					obj.agregarVenta(venta);
					break;
				case 2:
					System.out.print("Introduce la id a buscar: ");
					idBuscar = in.nextLine();
					System.out.println();
					obj.buscarVentas(idBuscar);
					break;
				case 3:
					obj.guardarFichero();
					break;
				case 4:
					obj.leerFichero();
					break;
				case 5:
					System.out.println("Finalizando programa...");
					break;
				default:
					System.out.println("Opcion introducida invalida, por favor vuelta a intentarlo");
					System.out.println();
					break;
				}
			}while(resp != 5);
		}catch(FileNotFoundException ex) {
			System.out.println();
			System.out.println("Error: " + ex.getMessage());
			System.out.println();
		}catch(IOException ex) {
			System.out.println();
			System.out.println("Error: " + ex.getMessage());
			System.out.println();
		}catch (ClassNotFoundException ex) {
			System.out.println();
			System.out.println("Error: " + ex.getMessage());
			System.out.println();
		}catch (Exception ex) {
			System.out.println();
			System.out.println("Error: " + ex.getMessage());
			System.out.println();
		}
	}
}
