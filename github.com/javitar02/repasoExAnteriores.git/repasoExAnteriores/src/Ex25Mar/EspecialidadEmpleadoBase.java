package Ex25Mar;

public enum EspecialidadEmpleadoBase {
ADMINISTRATIVO(EmpleadoBase.SUELDO_INICIAL_ADMINISTRATIVO),
OPERARIO(EmpleadoBase.SUELDO_INICIAL_OPERARIO),
CONTABLE(EmpleadoBase.SUELDO_INICIAL_CONTABLE);

	private int sueldoInicial;
	
	private EspecialidadEmpleadoBase(int sueldoInicial) {
		this.sueldoInicial = sueldoInicial;
	}

	public int getSueldoInicial() {
		return sueldoInicial;
	}
	
}
