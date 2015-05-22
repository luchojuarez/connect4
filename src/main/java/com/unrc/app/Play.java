package com.unrc.app;

import com.unrc.app.User;
import com.unrc.app.Rank;
import java.util.Scanner;
import org.javalite.activejdbc.Model;

public class Play extends Model{

	/* playing(String player1, String player2,Game game) maneja todo el juego, y devuelve el ganador (o empate)
	@player1 es el nombre del jugador 1
	@player2 es el nombre del jugador 2
	@game es el tablero de juego
	@returns un entero con el resultado de la partida donde:

		1 = gano el jugador 1
		2 = gano el jugador 2
		0 = empate

	*/
	public static int playing(String player1, String player2,Game game){


		Cell c = null;					/* Celda usada para la insersion de fichas */
		Scanner pos = new Scanner(System.in);	/* Scanner usado para lectura de datos */
		int y = game.gety();				/* cantidad de columnas del tablero */
		int disc = 0;					/* columna donde ira la ficha  */
		boolean turn = true;				/* indica que jugador debe jugar (turno) */
		boolean correct = false;				/* indica si un movimiento es posible */

		String msj = "Ingrese la columna en donde ingresar la ficha, desde 0 hasta "+y+": ";
		
		/* mientras no termine el juego */
		while (game.gameOver(c)==2){

			if (c!=null) turn = !turn; 	/* si se pudo ingresar la ficha, cambio de turno */

			/* mientras no ingrese una columna correcta */
			while (!correct){	

				System.out.println("");
				if  (turn) System.out.print(player1+" "+msj);
				if (!turn) System.out.print(player2+" "+msj);	
			
				disc = pos.nextInt();
				correct = check_column(disc,y);	/* Checkeamos si la columna es correcta */
				if (!correct) System.out.println("La columna no existe");
			}

			if (turn) c = game.pushDisc(disc,1);
			else 	 c = game.pushDisc(disc,2);
			
			correct = false;
		}

		if (game.gameOver(c)==0) return 0;
		if (turn) return 1;
		else return 2;

	}

	/* check_column(int column, int y) devuelve si la columna en donde vamos a ingresar la ficha existe
	@param column es la columna a evaluar
	@param y es la cantidad de columnas del tablero
	@returns un booleano donde:

		true = columna valida
		false = columna invalida
	*/

	public static boolean check_column(int column, int y){

		return (column>=0) && (column<=y);

	}












}