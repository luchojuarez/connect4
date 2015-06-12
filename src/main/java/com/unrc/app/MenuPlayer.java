package com.unrc.app;


import com.unrc.app.User;
import com.unrc.app.Rank;
import java.util.List;
import java.util.Scanner;
import org.javalite.activejdbc.Model;

public class MenuPlayer extends Model{
	
	public static void mainMenu (String nickId){
		// String respuesta;
		// char[] charArray;
		// char res;
		// do {
		// 	System.out.println("Presione 1 para jugar");
		// 	System.out.println("Presione 2 para ver ranking");
		// 	System.out.println("Presione 3 ver logros");
		// 	System.out.println("Presione 4 para volver a la pantalla anterior");
		// 	System.out.println("Presione 0 para salir");
		// 	Scanner escaneo = new Scanner(System.in);
		// 	respuesta = escaneo.nextLine();
		// 	charArray = respuesta.toCharArray();
		// 	res = charArray[0];
		// } while ((res != '1') && (res!='2')&& (res!='3')&& (res!='4')&& (res!='0'));
		
		// switch (res) {
		// 	case '1': newGame(nickId,nickId);
		// 		break;
		// 	case '2': showRank(nickId);
		// 		break;
		// 	case '3': showHit(nickId);
		// 		break;
		// 	case '4': Start.begin();
		// 		break;
		// 	case '0': System.out.println("chau!");
		// 		break;
		// }
	}

	public static boolean newGame (String us1,String us2) {
		boolean respuesta = false;
		if(respuesta == false){
			Game g = new Game();
			g.set("dateBegin",Start.getFechaActual());

			System.out.println("-------------"+us1);
			System.out.println("-------------"+us2);
			User u1 = User.findFirst("nickId=?", us1);
			g.set("player1_id",u1.get("id"));

			User u2 = User.findFirst("nickId=?", us2);
			g.set("player2_id",u2.get("id"));

			g.save();
			// int gameState = Play.playing(us1,us2,g);

			Grid grid = new Grid();
			grid.set("X",7);
			grid.set("Y",6);
			grid.save();
			grid.add(g);
			return true;
		}
		else{
			return false;
		}	
	}

	private static void showRank (String nickId){

		//busco el el id del usuario para conectarlo con su ranking
		List<User> us  = User.where("nickId = ?", nickId);
		User u = new User();
		u = us.get(0);
		List<Rank> ran  = Rank.where("user_id = ?",u.get("id"));
// // CUANDO ANDE EL USER_ID CAMBIAR LA LINEA 46 POR LA LINEA 48
// 		List<Rank> ran  = Rank.where("nroRank = ?",u.get("id"));
		Rank r = new Rank();
		r = ran.get(0);

		System.out.println();
		System.out.println("Tu ranking es: ");
		System.out.println("Posicion: "+r.get("nroRank")+" PG: "+r.get("PG")+" PE: "+r.get("PE")+" PP: "+r.get("PP")+" Puntos: "+r.get("points")+".");
		System.out.println();
		mainMenu(nickId);

	}

	private static void showHit (String nickId) {

	}

}