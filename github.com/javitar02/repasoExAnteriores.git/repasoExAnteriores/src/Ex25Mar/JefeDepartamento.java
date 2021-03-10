package Ex25Mar;


public class JefeDepartamento extends Empleado{
	private static final double AUMENTO3_JEFE = 1.06;
	private static final double AUMENTO2_JEFE = 1.04;
	private static final double AUMENTO1_JEFE = 1.03;
	private static final int LIMITE_SUBORDINADOS = 12;
	private static final int SUELDO_MINIMO_JEFE = 1300;
	
	
	private String departamento;
	private Empleado[] arraySubordinados=new Empleado[LIMITE_SUBORDINADOS];
	private int numRealSubordinados;
	
	public JefeDepartamento(String dni, String nombre, int sueldo,String departamento) throws EmpresaException {
		super(dni, nombre, sueldo);
		this.departamento=departamento;
		
	}

	public String getDepartamento() {
		return departamento;
	}

	
	protected void setSueldo( int sueldo) throws EmpresaException {
		if (sueldo < SUELDO_MINIMO_JEFE)
			throw new EmpresaException("El sueldo de cualquier empleado debe superar los " + SUELDO_MINIMO_JEFE + "  euros");
		
		super.setSueldo(sueldo);
	}
	
	public void annadirSubordinados(Empleado subordinado)throws EmpresaException {
		
			if(numRealSubordinados==LIMITE_SUBORDINADOS) {
				throw new EmpresaException("Error, no hay mas hueco para añadir subordinados");
			}
			
			if(this.getSueldo()<subordinado.getSueldo()) {
				throw new EmpresaException("Error, un empleado base no puede cobrar mas que un jefe");
			}
			
			arraySubordinados[numRealSubordinados]=subordinado;
			numRealSubordinados++;
			
		}

	@Override
	public void actualizarSueldo() {
		int sueldoFinal = 0;
		
			try {
				if(this.numRealSubordinados<3) {
					sueldoFinal=(int) (super.getSueldo()+sueldo*AUMENTO1_JEFE);
				}else {
					if( this.numRealSubordinados<=8) {
						sueldoFinal=(int) (super.getSueldo()+sueldo*AUMENTO2_JEFE);
					}else {
							sueldoFinal=(int) (super.getSueldo()+sueldo*AUMENTO3_JEFE);
						}
					}
				super.setSueldo(sueldoFinal);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
			
		}
		
	
	@Override
	public String toString() {
		return super.toString()+" JefeDepartamento departamento=" + departamento + ", subordinados="
				+ arraySubordinados.length + "]";
	}

	
	
	

}
