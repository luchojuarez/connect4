package com.unrc.app;

import org.javalite.activejdbc.Model;


public class Game extends Model {


//----------------------------------------------------------------------------------------------------------------------------------------------------------

//Contructores---------------------------------------------------------------------------------------------------------------------------------------

	private Grid g;

	public Game(){

		g = new Grid();

	}

	public Game(int n, int m){

		g = new Grid(n,m);
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------

//Methods---------------------------------------------------------------------------------------------------------------------------------------------

	//Retorna el estado de la partida
	//Donde 0 indica que el juego termino ya que no hay mas casilleros disponibles
	//Donde 1 indica que el jugador que hizo el ultimo movimiento gano
	//Donde 2 indica que no hay ganador, el juego continua
	public int gameOver(Cell c){

		if (g.gridFull()) return 0;




	}

	//Pone una nueva ficha en la grilla
	public void pushDisc(Cell c){



		g.incCant(); 
	}

	//Retorna el estado de una celda
	public boolean isEmpty(Cell c){

		return g.getCellState(c);
	}

}
