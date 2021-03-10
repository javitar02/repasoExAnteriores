package Ex31Mar;

public class ProfesorPrimaria extends Profesor {
	private static final int NOTA_MIN_PRIMARIA = 0;
	private static final int NOTA_MAX_PRIMARIA = 5;
	private static final int ANTIGUEDAD_CENTRO_MINIMO = 3;
	private static final int SIN_NOTA = -1;

	EspecialidadesPrimaria especialidad;
	protected int notaUltimaEvaluacion;

	public ProfesorPrimaria(String nombre, String centroAdjudicado, String DNI, EspecialidadesPrimaria especialidad)
			throws ProfesorException {
		super(nombre, centroAdjudicado, DNI);
		this.especialidad = especialidad;
		this.notaUltimaEvaluacion = SIN_NOTA;
	}

	public ProfesorPrimaria(String nombre, String centroAdjudicado, String DNI) throws ProfesorException {
		super(nombre, centroAdjudicado, DNI);
		this.especialidad = EspecialidadesPrimaria.GENERAL;
		this.notaUltimaEvaluacion = SIN_NOTA;
	}

	public EspecialidadesPrimaria getEspecialidad() {
		return especialidad;
	}

	public double getNotaUltimaEvaluacion() {
		return notaUltimaEvaluacion;
	}

	public void setCentroAdjudicado(String centroAdjudicado) throws ProfesorException {
		if (this.getAntiguedad() < ANTIGUEDAD_CENTRO_MINIMO) {
			throw new ProfesorException(
					"Error, debe estar en este centro como minimo " + ANTIGUEDAD_CENTRO_MINIMO + " años");
		}
		super.setCentroAdjudicado(centroAdjudicado);
	}

	public void evaluacionAnual(int nota) throws ProfesorException {
		if (nota < NOTA_MIN_PRIMARIA || nota > NOTA_MAX_PRIMARIA) {
			throw new ProfesorException("La nota debe ir entre " + NOTA_MIN_PRIMARIA + " y " + NOTA_MAX_PRIMARIA);
		}

		this.notaUltimaEvaluacion = nota;
		antiguedad++;
	}

	@Override
	public String toString() {
		return super.toString() + " profesor de primaria especializado en" + especialidad+ "y cuya"
				+ "nota de la ultima evaluacion es "+notaUltimaEvaluacion;
	}
}
