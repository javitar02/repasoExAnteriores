package Ex31Mar;

public class ProfesorSecundaria extends Profesor {
	private static final int ANTIGUEDAD_CENTRO_MINIMO = 2;
	private static final int NOTA_MIN_SECUNDARIA = 0;
	private static final int NOTA_MAX_SECUNDARIA = 10;

	EspecialidadesSecundaria especialidad;
	private int sumaTotalNotas;
	private int evaluaciones;

	public ProfesorSecundaria(String nombre, String centroAdjudicado, String DNI, EspecialidadesSecundaria especialidad)
			throws ProfesorException {
		super(nombre, centroAdjudicado, DNI);
		this.especialidad = especialidad;
		//NO HACE FALTA PONERLAS A 0 NI ESCRIBIRLAS
		this.sumaTotalNotas=0;
		this.evaluaciones=0;
		
	}


	public EspecialidadesSecundaria getEspecialidad() {
		return especialidad;
	}

	public void setCentroAdjudicado(String centroAdjudicado) throws ProfesorException {
		if (this.getAntiguedad() < ANTIGUEDAD_CENTRO_MINIMO) {
			throw new ProfesorException(
					"Error, debe estar en este centro como minimo " + ANTIGUEDAD_CENTRO_MINIMO + " años");
		}
		super.setCentroAdjudicado(centroAdjudicado);
	}

	public void evaluacionAnual(int nota) throws ProfesorException {
		if (nota < NOTA_MIN_SECUNDARIA || nota > NOTA_MAX_SECUNDARIA) {
			throw new ProfesorException("La nota debe ir entre " + NOTA_MIN_SECUNDARIA + " y " + NOTA_MAX_SECUNDARIA);
		}
		sumaTotalNotas+=nota;
		evaluaciones++;
		antiguedad++;
	}

	public double calcularMedia()throws ProfesorException {
		double media;
		if(evaluaciones==0) {
			throw new ProfesorException("No se dispone de nota media todavia");
		}
		media=(double)sumaTotalNotas/evaluaciones;
		
		return media;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + " profesor de secundaria especializado en " + especialidad;
	}

}