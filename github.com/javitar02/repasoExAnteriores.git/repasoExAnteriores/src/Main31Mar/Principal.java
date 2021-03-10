package Main31Mar;
import Ex31Mar.Profesor;
import Ex31Mar.ProfesorPrimaria;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}
	
	public static void profesoresDePrimariaConNotaMayorA( Profesor[] profesores, int notaLimite) {
		
		
		for (int i = 0; i < profesores.length; i++) {
			Profesor profesor = profesores[i];
			
			if ( profesor instanceof ProfesorPrimaria ) {
				
				ProfesorPrimaria profesorPrimaria= (ProfesorPrimaria ) profesor;
				
				if ( profesorPrimaria.getNotaUltimaEvaluacion() > notaLimite) {
					System.out.println(profesor);
				}
			}
			
		}
	}
}

