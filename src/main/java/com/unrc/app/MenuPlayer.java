package com.unrc.app;


import com.unrc.app.User;
import com.unrc.app.Rank;
import java.util.List;
import java.util.Scanner;
import org.javalite.activejdbc.Model;

public class MenuPlayer extends Model{
	
	public static void mainMenu (String nickId){
		String respuesta;
		char[] charArray;
		char res;
		do {
			System.out.println("Presione 1 para jugar");
			System.out.println("Presione 2 para ver ranking");
			System.out.println("Presione 3 ver logros");
			System.out.println("Presione 4 para volver a la pantalla anterior");
			System.out.println("Presione 0 para salir");
			Scanner escaneo = new Scanner(System.in);
			respuesta = escaneo.nextLine();
			charArray = respuesta.toCharArray();
			res = charArray[0];
		} while ((res != '1') && (res!='2')&& (res!='3')&& (res!='4')&& (res!='0'));
		
		switch (res) {
			case '1': newGame(nickId);
				break;
			case '2': showRank(nickId);
				break;
			case '3': showHit(nickId);
				break;
			case '4': Start.begin();
				break;
			case '0': System.out.println("chau!");
				break;
		}
	}

	private static void newGame (String nickId) {
		Game g = new Game();
		g.set("dateBegin",Start.getFechaActual());


		User u1 = User.findFirst("nickId=?", nickId);
		g.set("player1_id",u1.get("id"));


		System.out.println("Empezando Juego nuevo");
		System.out.println("Loguea al segundo jugador");
		System.out.println();
		System.out.print("Ingrese el nick: ");
		String ni = "";
		Scanner name = new Scanner(System.in);
		ni = name.nextLine();//se le pide su nickId que es el atributo por el cual buscamos en la base
		if (!(nickId.equals(ni))){
			if (Start.search(ni)) {//si el usuario es correcto 

				System.out.println();
				System.out.print("Ingrese su password: ");
				String pass = "";
				Scanner word = new Scanner(System.in);
				pass = word.nextLine();//se le pide su password

				if(Start.checkPass(ni,pass)){//si la password es correcta ingresa
					System.out.println();
					System.out.println("Login: user IN");
	//				g.set("player2_id",ni);
					g.save();
					int gameState = Play.playing(nickId,ni,g);

					if (gameState==0) System.out.println("Juego Empatado");
					if (gameState==1) System.out.println("Gano "+ nickId+"!!!!");
					if (gameState==2) System.out.println("Gano "+ ni+"!!!!");
//					g.set("player2_id",2);
					
					User u2 = User.findFirst("nickId=?", ni);
					g.set("player2_id",u2.get("id"));

					Grid grid = new Grid();
					System.out.println();
					System.out.println("ingresar la dimension de la grilla: ");
					System.out.println();
					System.out.println("ingresar X: ");
					int x ;
					Scanner dimX = new Scanner(System.in);
					x = dimX.nextInt();
					System.out.println("ingresar Y: ");
					int y ;
					Scanner dimY = new Scanner(System.in);
					y = dimY.nextInt();

					grid.set("X",x);
					grid.set("Y",y);
					grid.save();

					g.save();
					grid.add(g);
				}
				else{
					System.out.println();
					System.out.println("Nick o Pass incorrectos");
					mainMenu(nickId);				
				}
			}
			else{
				System.out.println();
				System.out.println("Nick invalido");
				mainMenu(nickId);				
			}
		}
		else{
			System.out.println();
			System.out.print("No podes jugar contra ti mismo");
			System.out.println();
			mainMenu(nickId);
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