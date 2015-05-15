package com.unrc.app;

import java.util.Scanner;
import org.javalite.activejdbc.Model;

public class MenuPlayer extends Model{
	
	public static void mainMenu (){
		int respuesta;
		do {
			System.out.println("Presione 1 para jugar");
			System.out.println("Presione 2 para ver ranking");
			System.out.println("Presione 3 ver logros");
			System.out.println("Presione 0 para salir");
			Scanner escaneo = new Scanner(System.in);
			respuesta = escaneo.nextInt();
		} while ((respuesta != 1) && (respuesta!=2)&& (respuesta!=3)&& (respuesta!=0));
		
		switch (respuesta) {
			case 1: newGame();
				break;
			case 2: showRank();
				break;
			case 3: showHit();
				break;
			case 0: System.out.println("chau!");
				break;
		}
	}

	private static void newGame () {

	}

	private static void showRank (){

	}

	private static void showHit () {

	}

}