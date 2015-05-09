package com.unrc.app;

import org.javalite.activejdbc.Model;

public class Grid extends Model{

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	//matriz
	private Cell[][] grid;
	private int m; 
	private int n;

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Constructores

	//Defect (7x6)
	public Grid(){

		m = 6;
		n  = 5;
		grid = new Cell[m][n];
		grid = initializeGrid(m,n);
	}

	public Grid(Integer m, Integer n){

		if ((m>=6) && (n>=5)){

			this.m = m;
			this.n  = n;
			grid = new Cell[m][n];
			grid = initializeGrid(m,n);
		}
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Proceso que carga la matriz

	private Cell[][] initializeGrid(Integer m, Integer n){

		for(int i = 0; i<=m; i++){

			for(int j = 0; j<=n; j++){

				grid[i][j] = new Cell(i,j);
			}
		}
	} 

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Get

	//Returna el estado de la ficha indicada 
	public Boolean getCellState(Integer m, Integer n) throws Err{

		if ((m>this.m) || (n>this.n) || (n<0) || (m<0)) throw new Err(" ");
		else return grid[m][n].getState;

	}



//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Set

	//Setea el estado de una celda
	public void setCellState(Integer m, Integer n, Integer p){

		if ((m>this.m) || (n>this.n) || (n<0) || (m<0)) throw new Err(" ");
		if ((p!=0) || (p!=1) || (p!=2)) throw new Err(" ");

		grid[m][n].setState(p);
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------


	



}