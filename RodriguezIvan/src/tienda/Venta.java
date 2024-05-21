package tienda;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Venta implements Serializable {
	private String idProducto;
	private double precio;
	private int cantidad;
	private String marca;
	
	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venta(String idProducto, double precio, int cantidad, String marca) {
		super();
		this.idProducto = idProducto;
		this.precio = precio;
		this.cantidad = cantidad;
		this.marca = marca;
	}

	public abstract double beneficio();
	
	public String validarMarca(String marcaValidada) {
		Scanner in = new Scanner(System.in);
		boolean marcaPermitida = false;
		String[] marcas = {"Nike", "Adidas", "Zara", "H&M", "GAP"};
		
		while(marcaPermitida == false) {
			for(int i = 0; i < marcas.length ; i++) {
				if(marcaValidada.equalsIgnoreCase(marcas[i])) marcaPermitida = true;
			}
			
			if(marcaPermitida == false) {
				System.out.println();
				System.out.print("Marca introducida erronea, vuelva a intentarlo (Nike, Adidas, Zara, H&M, GAP): ");
				marcaValidada = in.nextLine();
				System.out.println();
			}
		}
		
		return marcaValidada;
	}
	
	public double devolverBeneficio(double[] porcentajes_ventas) {
		String[] marcas = {"Nike", "Adidas", "Zara", "H&M", "GAP"};
		double porcentaje = 0.0;
		
		for(int i = 0; i < marcas.length ; i++) {
			if(this.marca.equalsIgnoreCase(marcas[i])) porcentaje = porcentajes_ventas[i];
		}
		
		return porcentaje;
	}

	/**
	 * @return the idProducto
	 */
	public String getIdProducto() {
		return idProducto;
	}

	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return 	"Id Producto: " + this.idProducto + "\n" +
				"Precio: " + this.precio + "\n" + 
				"Cantidad: " + this.cantidad + "\n" +
				"Marca: " + this.marca;
	}

}
