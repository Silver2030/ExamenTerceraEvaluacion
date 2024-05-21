package tienda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ListaVentas {
	private ArrayList<Venta> listaVentas = new ArrayList<Venta>();

	public ListaVentas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListaVentas(ArrayList<Venta> listaVentas) {
		super();
		this.listaVentas = listaVentas;
	}
	
	public void cargarDatos() {
		this.listaVentas.add(new VentaOnline("D12D", 10, 10, "Nike", "Tarjeta", "Cudillero, Calle S/N"));
		this.listaVentas.add(new VentaOnline("K91D", 15, 40, "Zara", "Cuenta Bancaria", "Aviles, Parque Ferrera"));
		this.listaVentas.add(new VentaOnline("12DF", 5, 20, "H&M", "Tarjeta", "Oviedo, Calle Covadonga"));
		this.listaVentas.add(new VentaLocal("9DKW", 10, 80, "GAP", "Alfredo", "Cudillero"));
		this.listaVentas.add(new VentaLocal("019D", 15, 40, "Adidas", "Maria", "Aviles"));
		this.listaVentas.add(new VentaLocal("D12D", 2, 100, "Nike", "Susana", "Oviedo"));
	}
	
	public void agregarVenta(String tipoVenta) {
		if(tipoVenta.equalsIgnoreCase("VentaOnline")) {
			VentaOnline ventaAgregar = new VentaOnline();
			this.listaVentas.add(ventaAgregar.agregarVenta());
		}else {
			VentaLocal ventaAgregar = new VentaLocal();
			this.listaVentas.add(ventaAgregar.agregarVenta());
		}
		System.out.println("Venta agregada.");
		System.out.println();
	}
	
	public void buscarVentas(String idProducto) {
		boolean encontrado = false;
		for(Venta venta : this.listaVentas) {
			if(venta.getIdProducto().equalsIgnoreCase(idProducto)) {
				encontrado = true;
				System.out.println(venta.toString());
				System.out.println();
			}
		}
		
		if(encontrado == false) System.out.println("Producto no encontrado");
	}
	
	public void guardarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileOutputStream fichero = null;
		try {
			fichero = new FileOutputStream("ventas.dat");
			ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
			tuberia.writeObject(this.listaVentas);
			System.out.println("Fichero guardado.");
			System.out.println();
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fichero.close();
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void leerFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		DecimalFormat df = new DecimalFormat( "#.##" );
		String[] marcas = {"Nike", "Adidas", "Zara", "H&M", "GAP"};
		int[] ventasMarcas = {0, 0, 0, 0, 0};
		double[] beneficioMarcas = {0.0, 0.0, 0.0, 0.0, 0.0};
		FileInputStream fis;
		try {
			  fis = new FileInputStream("ventas.dat");
			  ObjectInputStream ois = new ObjectInputStream(fis);
			  ArrayList<Venta> list = (ArrayList<Venta>) ois.readObject();
			  ois.close();
			  for(Venta venta : list) {
					for(int i = 0; i < marcas.length ; i++) {
						if(venta.getMarca().equalsIgnoreCase(marcas[i])) {
							ventasMarcas[i] += venta.getCantidad();
							beneficioMarcas[i] += venta.beneficio();
						}
					}
			  }
			  
			  for(int i = 0; i < marcas.length ; i++) {
					System.out.println(marcas[i] + " Total unidades: " + ventasMarcas[i] + " Beneficio:" + df.format(beneficioMarcas[i]));
					System.out.println();
				}
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}
