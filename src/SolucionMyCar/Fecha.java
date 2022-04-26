package SolucionMyCar;

import java.time.LocalDate;

public class Fecha {
	protected LocalDate fecha = LocalDate.now();

	public Fecha() {
	}

	public Fecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
}
