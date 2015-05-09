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
	private Integer state;
             //private Boolean state;

	//Coordenadas de la celda
	private Integer x;
	private Integer y;


//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Constructores

	public Cell(Integer x, Integer y){

		state = 0;
		this.x = x;
		this.y = y;
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Gets

	public Integer getx(){

		return this.x;
	}

	public Integer gety(){

		return this.y;
	}

	public Integer getState(){

		return this.state;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Sets

	public void setx(Integer x){

		this.x = x;
	}

	public void sety(Integer y){

		this.y = y;
	}

	public void setState(Integer state){

		this.state = state;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------






	
}