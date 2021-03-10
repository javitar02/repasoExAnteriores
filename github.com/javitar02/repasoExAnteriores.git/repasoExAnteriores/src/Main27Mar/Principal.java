package Main27Mar;

import Ex27Mar.Isla;
import Ex27Mar.JuegoException;
import Ex27Mar.Personaje;

public class Principal {

	public static void main(String[] args) {
		try {
			Isla isla = new Isla("MI ISLA", 4);
			Personaje aldeana=new Personaje("ALDEANA", isla, 10);
			Personaje canela=new Personaje("CANELA", isla, 12);
			Personaje mickey=new Personaje("MICKEY", isla, 10);
			Personaje minnie=new Personaje("MINNIE", isla, 15);
			
			mickey.recoger("PLATANO");
			mickey.recoger("CAÑA DE PESCAR");
			
			mickey.regalar(minnie, "CAÑA DE PESCAR");
		
			System.out.println(mickey);
			
		} catch (JuegoException e1) {
			System.out.println(e1.getMessage());
		}
			
						
			
			
		
		

	}

}


