package com.unrc.app;


import com.unrc.app.User;
import com.unrc.app.Rank;
import java.util.List;
import java.util.Scanner;
import org.javalite.activejdbc.Model;

public class MenuPlayer extends Model{
	
	public static void mainMenu (String nickId){
		int respuesta;
		do {
			System.out.println("Presione 1 para jugar");
			System.out.println("Presione 2 para ver ranking");
			System.out.println("Presione 3 ver logros");
			System.out.println("Presione 4 para volver a la pantalla anterior");
			System.out.println("Presione 0 para salir");
			Scanner escaneo = new Scanner(System.in);
			respuesta = escaneo.nextInt();
		} while ((respuesta != 1) && (respuesta!=2)&& (respuesta!=3)&& (respuesta!=4)&& (respuesta!=0));
		
		switch (respuesta) {
			case 1: newGame();
				break;
			case 2: showRank(nickId);
				break;
			case 3: showHit();
				break;
			case 4: Start.begin();
				break;
			case 0: System.out.println("chau!");
				break;
		}
	}

	private static void newGame () {

	}

	private static void showRank (String nickId){

		//busco el el id del usuario para conectarlo con su ranking
		List<User> us  = User.where("nickId = ?", nickId);
		User u = new User();
		u = us.get(0);
		//List<Rank> ran  = Rank.where("user_id = ?",u.get("id"));
// CUANDO ANDE EL USER_ID CAMBIAR LA LINEA 46 POR LA LINEA 48
		List<Rank> ran  = Rank.where("nroRank = ?",u.get("id"));
		Rank r = new Rank();
		r = ran.get(0);

		System.out.println();
		System.out.println("Tu ranking es: ");
		System.out.println("Posicion: "+r.get("nroRank")+" PG: "+r.get("PG")+" PE: "+r.get("PE")+" PP: "+r.get("PP")+" Puntos: "+r.get("points")+".");
		System.out.println();
		mainMenu(nickId);

	}

	private static void showHit () {

	}

}