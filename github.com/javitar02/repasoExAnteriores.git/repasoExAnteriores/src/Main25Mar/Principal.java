package Main25Mar;

import Ex25Mar.Empleado;
import Ex25Mar.EmpleadoBase;
import Ex25Mar.EspecialidadEmpleadoBase;
import Ex25Mar.JefeDepartamento;

public class Principal {

	public static void main(String[] args) {
		try {
			Empleado[] listaEmpleados=new Empleado[5];
			JefeDepartamento jefe1=new JefeDepartamento("12323A", "MANOLO", 1500, "LOGISTICA");
			JefeDepartamento jefe2=new JefeDepartamento("12323B", "PEPE", 1400, "I+D");
			Empleado empleado1=new EmpleadoBase("3234SS", "JAVI",  EspecialidadEmpleadoBase.ADMINISTRATIVO);
			Empleado empleado2=new EmpleadoBase("324SS", "JAVI", EspecialidadEmpleadoBase.ADMINISTRATIVO);
			Empleado empleado3=new EmpleadoBase("3234S", "JAVI", EspecialidadEmpleadoBase.ADMINISTRATIVO);
			listaEmpleados[0]=jefe1;
			listaEmpleados[1]=jefe2;
			listaEmpleados[2]=empleado1;
			listaEmpleados[3]=empleado2;
			listaEmpleados[4]=empleado3;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
