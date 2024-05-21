package tienda;

import java.io.Serializable;
import java.util.Scanner;

public class VentaOnline extends Venta implements Serializable{
	private String metodoPago;
	private String direccionEnvio;
	
	public VentaOnline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VentaOnline(String idProducto, double precio, int cantidad, String marca, String metodoPago, String direccionEnvio) {
		super(idProducto, precio, cantidad, marca);
		this.metodoPago = metodoPago;
		this.direccionEnvio = direccionEnvio;
	}

	public VentaOnline agregarVenta() {
		Scanner in = new Scanner(System.in);
		VentaOnline ventaOn = new VentaOnline();
		
		System.out.print("Id Producto: ");
		ventaOn.setIdProducto(in.nextLine());
		System.out.println();
		System.out.print("Precio: ");
		ventaOn.setPrecio(in.nextDouble());
		System.out.println();
		System.out.print("Cantidad: ");
		ventaOn.setCantidad(in.nextInt());
		in.nextLine();
		System.out.println();
		System.out.print("Marca (Nike, Adidas, Zara, H&M, GAP): ");
		ventaOn.setMarca(ventaOn.validarMarca(in.nextLine()));
		System.out.println();
		System.out.print("Metodo Pago: ");
		ventaOn.setMetodoPago(in.nextLine());
		System.out.println();
		System.out.print("Direccion Envio: ");
		ventaOn.setDireccionEnvio(in.nextLine());
		System.out.println();
		
		return ventaOn;
	}

	@Override
	public double beneficio() {
		// TODO Auto-generated method stub
		double[] porcentajes_ventasOnline = {0.11, 0.15, 0.23, 0.25, 0.31};
		double porcentaje = devolverBeneficio(porcentajes_ventasOnline);
		
		return super.getPrecio() * super.getCantidad() * porcentaje;
	}

	/**
	 * @return the metodoPago
	 */
	public String getMetodoPago() {
		return metodoPago;
	}

	/**
	 * @param metodoPago the metodoPago to set
	 */
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	/**
	 * @return the direccionEnvio
	 */
	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	/**
	 * @param direccionEnvio the direccionEnvio to set
	 */
	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	@Override
	public String toString() {
		return 	"VENTA ONLINE\n" +
				super.toString() + "\n" +
				"Metodo de Pago: " + this.metodoPago + "\n" +
				"Direccion de Envio: " + this.direccionEnvio;
	}
	
}
