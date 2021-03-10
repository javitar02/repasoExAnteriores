package Main27Mar;

import Ex27Mar.Isla;
import Ex27Mar.JuegoException;
import Ex27Mar.Personaje;

public class Principal {

	public static void main(String[] args) {
		try {
			Isla isla1=new Isla("Cayo Paloma", 0);
			Personaje p1=new Personaje("PEPE", isla1, 11);
			System.out.println(isla1);
			System.out.println(p1);
		} catch (JuegoException e) {
			System.out.println(e.getMessage());
		}

	}

}
