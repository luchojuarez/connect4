package com.unrc.app;

import org.javalite.activejdbc.Model;

//----------------------------------------------------------------------------------------------------------------------------------------------------------
/*

Primera idea de la celda

el estado sera un valor entero donde:

	0 = Disponible
	1 = Ocupada por jugador 1
	2 = Ocupada por jugador 2

las variables x,y indican la posicion en la matriz, podria representarse como una tupla

*/

public class Cell extends Model{

	//Estado de la celda 
	private int state;
             //private Boolean state;

	//Coordenadas de la celda
	private int x;
	private int y;


//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Constructores

	public Cell(){

		state = 0;
		x = 0;
		y = 0;
	}

	public Cell(int x, int y){

		state = 0;
		this.x = x;
		this.y = y;
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Gets

	public int getx(){

		return this.x;
	}

	public int gety(){

		return this.y;
	}

	public int getState(){

		return this.state;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Sets

	public void setx(int x){

		this.x = x;
	}

	public void sety(int y){

		this.y = y;
	}

	public void setState(int state){

		this.state = state;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------






	
}