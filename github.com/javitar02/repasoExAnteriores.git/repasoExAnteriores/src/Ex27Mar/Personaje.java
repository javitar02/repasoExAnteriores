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
		setIsla(isla);
		setEdad(edad);
		
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

	public void setIsla(Isla isla) throws JuegoException{
		if(isla.equals(this.getIsla())) {
			throw new JuegoException("La isla esta ya creada");
		}
		isla.incrementarHabitantesIsla();
		this.isla = isla;
	}

	public void regalar (Personaje otro, String pertenencia) throws JuegoException {
		boolean encontrada=false;
		int posicionPertencia=0;
		
		if ( !this.isla.equals(otro.isla)) {
			throw new JuegoException("No puedes regalar a un personaje si  estais en una isla distinta");
		}
		
		for (int i = 0; i < arrayPertenencias.length && !encontrada; i++) {
			
			if (pertenencia.equals( arrayPertenencias[i])) {
				encontrada=true;
				posicionPertencia=i;
				
			}
		}
		if (!encontrada) {
			throw new JuegoException("No puede regalar el objeto " + pertenencia + " porque no lo tiene");
		}
		
		//busca la pertenencia y  si la encuentra la pone a null
		
		otro.recoger(pertenencia);
		arrayPertenencias[posicionPertencia]=null; //SUELTA LA PERTENECIA AL FINAL, SI NO HAY ERROR.
		pertenenciasEnComun --; // como utilizo el mismo método para regalar y recoger resto ahora para que el número de objetos quede igual
	}
	
	public void recoger( String nuevaPertenencia) throws JuegoException {
		
		int posicionHueco=buscarHueco();
		
		arrayPertenencias[posicionHueco]=nuevaPertenencia;
		
		//Incrementamos la variable estática total de objetos recogidos
		pertenenciasEnComun++;
	}
	
	private int buscarHueco() throws JuegoException {
		
		int posicionHueco=-1;
		for (int i = 0; i < arrayPertenencias.length && posicionHueco==-1; i++) {
			
			if (arrayPertenencias[i]==null) {
				posicionHueco=i; //sale del bucle
			}
		}
		if (posicionHueco ==-1) {
			throw new JuegoException("El personaje " + this.nombre + " no tiene espacio para más objetos");
		}
		
		return posicionHueco;
		
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
