package tienda;

import java.io.Serializable;
import java.util.Scanner;

public class VentaLocal extends Venta implements Serializable{
	private String vendedor;
	private String ubicacion;
	
	public VentaLocal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VentaLocal(String idProducto, double precio, int cantidad, String marca, String vendedor, String ubicacion) {
		super(idProducto, precio, cantidad, marca);
		this.vendedor = vendedor;
		this.ubicacion = ubicacion;
	}

	public VentaLocal agregarVenta() {
		Scanner in = new Scanner(System.in);
		VentaLocal ventaLo = new VentaLocal();
		
		System.out.print("Id Producto: ");
		ventaLo.setIdProducto(in.nextLine());
		System.out.println();
		System.out.print("Precio: ");
		ventaLo.setPrecio(in.nextDouble());
		System.out.println();
		System.out.print("Cantidad: ");
		ventaLo.setCantidad(in.nextInt());
		in.nextLine();
		System.out.println();
		System.out.print("Marca (Nike, Adidas, Zara, H&M, GAP): ");
		ventaLo.setMarca(ventaLo.validarMarca(in.nextLine()));
		System.out.println();
		System.out.print("Vendedor: ");
		ventaLo.setVendedor(in.nextLine());
		System.out.println();
		System.out.print("Ubicación: ");
		ventaLo.setUbicacion(in.nextLine());
		System.out.println();
		
		return ventaLo;
	}

	@Override
	public double beneficio() {
		// TODO Auto-generated method stub
		double[] porcentaje_ventaLocal = {0.02, 0.05, 0.10, 0.20, 0.28};
		double porcentaje = devolverBeneficio(porcentaje_ventaLocal);
		
		return super.getPrecio() * super.getCantidad() * porcentaje;
	}

	/**
	 * @return the vendedor
	 */
	public String getVendedor() {
		return vendedor;
	}

	/**
	 * @param vendedor the vendedor to set
	 */
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return 	"VENTA LOCAL\n" +
				super.toString() + "\n" +
				"Vendedor: " + this.vendedor + "\n" +
				"Ubicación: " + this.ubicacion;
	}
	
	
}
