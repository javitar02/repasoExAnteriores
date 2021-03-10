package Ex31Mar;

public abstract class Profesor implements EvaluableAnualmente {
	
	private String nombre;
	private String centroAdjudicado;
	private String DNI;
	protected int antiguedad;

	public Profesor(String nombre, String centroAdjudicado, String DNI) throws ProfesorException {
		this.nombre = nombre;
		this.antiguedad = 0;
		this.DNI = DNI;
		this.centroAdjudicado = centroAdjudicado;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) throws ProfesorException {

		this.DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCentroAdjudicado() {
		return centroAdjudicado;
	}

	public void setCentroAdjudicado(String centroAdjudicado) throws ProfesorException {
		this.centroAdjudicado = centroAdjudicado;
		this.antiguedad = 0;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre + " centroAdjudicado=" + centroAdjudicado + ", antiguedad=" + antiguedad;
	}
}
