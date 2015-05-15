package com.unrc.app;

import org.javalite.activejdbc.Model;

public class Grid extends Model{

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	//matriz
	private Cell[][] grid;
	private int m; 
	private int n;
	private cant;

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Constructores

	//Defect (7x6)
	public Grid(){

		m = 6;
		n  = 5;
		grid = new Cell[m+1][n+1];
		initializeGrid(m,n);
		cant = 0;
	}

	public Grid(int m, int n){

		if ((m>=6) && (n>=5)){

			this.m = m;
			this.n  = n;
			grid = new Cell[m+1][n+1];
			initializeGrid(m,n);
			cant = 0;
		}
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Proceso que carga la matriz

	private void initializeGrid(int m, int n){

		for(int i = 0; i<=m; i++){

			for(int j = 0; j<=n; j++){

				grid[i][j] = new Cell(i,j);
			}
		}
	} 

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Get

	//Retorna el estado de la ficha indicada 
	public int getCellState(Cell c){ 

		int m = c.getx();
		int n =  c.gety();
		return grid[m][n].getState();

	}



//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Set

	//Setea el estado de una celda
	public void setCellState(Cell c, int p){

		int m = c.getx();
		int n =  c.gety();
		grid[m][n].setState(p);
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	//Aumenta la cantidad de fichas en la grilla en 1

	public void incCant(){

		cant++;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	//Retorna la cantidad de celdas ocupadas

	public int getCant(){

		return cant;

	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//Retorna si una grilla esta llena de fichas
	public boolean gridFull(){

		return cant == (m+1)*(n+1);
	}

}