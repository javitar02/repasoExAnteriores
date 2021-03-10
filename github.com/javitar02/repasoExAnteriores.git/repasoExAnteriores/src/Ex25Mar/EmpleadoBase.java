package Ex25Mar;

public class EmpleadoBase extends Empleado {
	private static final double AUMENTO_SALARIO_EMPLEADO_BASE = 1.025;
	public static final int SUELDO_INICIAL_ADMINISTRATIVO= 1150;
	public static final int SUELDO_INICIAL_OPERARIO = 1100;
	public static final int SUELDO_INICIAL_CONTABLE = 1350;
	
	EspecialidadEmpleadoBase especialidad;
	
	public EmpleadoBase(String dni, String nombre,EspecialidadEmpleadoBase especialidad) throws EmpresaException {
		super(dni, nombre,sueldoInicialPorPuesto(especialidad));
		this.especialidad=especialidad;
	}
	
	public EspecialidadEmpleadoBase getEspecialidad() {
		return especialidad;
	}
	
	public static int sueldoInicialPorPuesto(EspecialidadEmpleadoBase especialidad) throws EmpresaException{
		int sueldoInicial=0;
		
		switch(especialidad) {
		case ADMINISTRATIVO:
			sueldoInicial=SUELDO_INICIAL_ADMINISTRATIVO;
			break;
		case OPERARIO:
			sueldoInicial=SUELDO_INICIAL_ADMINISTRATIVO;
			break;
		case CONTABLE:
			sueldoInicial=SUELDO_INICIAL_CONTABLE;
		}
		 return sueldoInicial;
	}
	
	@Override
	public String toString() {
		return super.toString()+ "EmpleadoBase [especialidad=" + especialidad + "]";
	}

	@Override
	public void actualizarSueldo() throws EmpresaException {
		int sueldoFinal=(int) (super.getSueldo()+sueldo*AUMENTO_SALARIO_EMPLEADO_BASE);
		super.setSueldo(sueldoFinal);
	}
	
	
}
