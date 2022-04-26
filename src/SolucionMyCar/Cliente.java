package SolucionMyCar;

import java.util.ArrayList;

public class Cliente extends Fecha {
	private String nombre;
	private String apellido;
	private String rut;
	private String correo;
	private String fono;
	private ArrayList<Auto> autos = new ArrayList<>();
	
	public Cliente() {	
	}
	
	public Cliente(String nombre, String apellido, String rut, String correo, String fono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.correo = correo;
		this.fono = fono;
	}
	
	public void addAuto(Auto auto) {
		this.autos.add(auto);
	}
	
	public String autosCliente() {
		String autosCliente = "";
		for (Auto auto : this.autos) {
			autosCliente = autosCliente + "\n** Patente : ** "+auto.getPpu()+"\n"
						  + "** Marca   : ** "+auto.getMarca()+"\n"
						  + "** Modelo  : ** "+auto.getModelo()+"\n"
						  + "** A�o     : ** "+auto.getAñoFabricacion()+"\n"
						  + "=======================================\n";
		}
		return autosCliente;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public ArrayList<Auto> getAuto() {
		return autos;
	}

	public void setAuto(ArrayList<Auto> autos) {
		this.autos = autos;
	}
	
	
}
