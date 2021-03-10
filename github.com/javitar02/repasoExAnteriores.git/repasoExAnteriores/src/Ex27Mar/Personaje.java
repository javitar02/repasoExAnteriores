package Ex27Mar;

public class Personaje {

	private static final int PERTENENCIAS_MAX = 10;
	private static final int EDAD_MAXIMA = 20;
	private static final int EDAD_MINIMA = 10;
	
	private int edad;
	private String nombre;
	private Isla isla;
	private String[] arrayPertenencias=new String[PERTENENCIAS_MAX];
	private static int pertenenciasEnComun;
	
	public static int getPertenenciasEnComun() {
		return pertenenciasEnComun;
	}

	public Personaje(String nombre, Isla isla, int edad) throws JuegoException {
		this.nombre = nombre;
		this.isla = isla;
		this.edad=edad;
		
	}
	
	public Personaje(String nombre, Isla isla) throws JuegoException {
		this.nombre = nombre;
		this.isla = isla;
		this.edad=10;
		
	}

	public String getNombre() {
		return nombre;
	}


	public Isla getIsla() {
		return isla;
	}

	public void setIsla(Isla isla) {
		this.isla = isla;
	}

	public int getEdad() {
		return edad;
	}
	
	public void cumpleaños() throws JuegoException {
		setEdad(edad);
		edad++;
	}

	public void setEdad(int edad) throws JuegoException {
		if(edad<EDAD_MINIMA || edad>EDAD_MAXIMA){
			throw new JuegoException("Error, la edad del personaje debe estar comprendida entre " 
		+EDAD_MINIMA+ " y "+EDAD_MAXIMA);
		}
		
	}
	
	public void añadirPertenencia(String pertenencia)throws JuegoException  {
		int i;
		
		if(arrayPertenencias.length==PERTENENCIAS_MAX) {
			throw new JuegoException("Error, no hay mas hueco en el array");
		}
		for(i=0;i<arrayPertenencias.length;i++) {
			if(arrayPertenencias[i]==null) {
				arrayPertenencias[i]=pertenencia;
				pertenenciasEnComun+=pertenenciasEnComun;
			}
		}
	}
	
	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", isla=" + isla + ", edad=" + edad + "]";
	}
	
}
