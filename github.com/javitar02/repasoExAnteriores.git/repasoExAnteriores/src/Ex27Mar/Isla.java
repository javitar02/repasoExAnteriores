package Ex27Mar;

public class Isla{
	
	private static final int CAPACIDAD_MAXIMA_ISLA = 5;
	private String nombre;
	private int capacidad;
	public int numPersonajes;
	
	
	public Isla(String nombre, int capacidad) throws JuegoException {
		this.nombre = nombre;
		this.capacidad = 0;
		this.numPersonajes = 0;
	
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getNumPersonajes() {
		return numPersonajes;
	}

	public void setNumPersonajes(int numPersonajes) throws JuegoException {
		if(numPersonajes>CAPACIDAD_MAXIMA_ISLA) {
			throw new JuegoException("Error, la capacidad de la isla esta al maximo");	
		}
		
		if(numPersonajes<0) {
			throw new JuegoException("Error, este dato no puede ser negativo "+numPersonajes);	
		}
		
		if(numPersonajes>capacidad) {
			throw new JuegoException("Error, el numero de jugadores en una isla no puede"
					+ "sobrepasar a la capacidad de la isla");	
		}
		this.numPersonajes = numPersonajes;
	}

	public int getCapacidad() {
		return capacidad;
	}
	
	public void incrementarHabitantesIsla() throws JuegoException {
		setNumPersonajes(numPersonajes);
		numPersonajes++;
		capacidad++;
	}

	
	@Override
	public String toString() {
		return "Isla " + nombre + ", cuya capacidad es de "+ capacidad + ", "
				+ " y que tiene " + numPersonajes + " personajes habitando en ella";
	}
	
}
