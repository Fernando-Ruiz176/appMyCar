package SolucionMyCar;

public class Auto  {
	private String ppu;
	private String marca;
	private String modelo;
	private int añoFabricacion;
	private boolean conMantenimiento;
	private Cliente responsable;
	
	public Auto() {	
	}

	public Auto(String ppu, String marca, String modelo, int añoFabricacion, boolean conMantenimiento,
			Cliente responsable) {
		this.ppu = ppu;
		this.marca = marca;
		this.modelo = modelo;
		this.añoFabricacion = añoFabricacion;
		this.conMantenimiento = conMantenimiento;
		this.responsable = responsable;
	}

	public String getPpu() {
		return ppu;
	}

	public void setPpu(String ppu) {
		this.ppu = ppu;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAñoFabricacion() {
		return añoFabricacion;
	}

	public void setAñoFabricacion(int añoFabricacion) {
		this.añoFabricacion = añoFabricacion;
	}

	public boolean isConMantenimiento() {
		return conMantenimiento;
	}

	public void setConMantenimiento(boolean conMantenimiento) {
		this.conMantenimiento = conMantenimiento;
	}

	public Cliente getResponsable() {
		return responsable;
	}

	public void setResponsable(Cliente responsable) {
		this.responsable = responsable;
	}

}