package com.unrc.app;

import org.javalite.activejdbc.Model;

public class Grid extends Model{

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Tablero
	 
	private Cell[][] grid;
	private int x; 		/* cantidad de filas */
	private int y;		/* cantidad de columnas */
	private int cant;	/* cantidad de celdas ocupadas por fichas en la grilla */

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Constructores

	//Defect (7x6)
	public Grid(){

		x = 6;
		y  = 5;
		grid = new Cell[x+1][y+1];
		initializeGrid(x,y);
		cant = 0;
	}

	public Grid(int x, int y){

		if ((x>=6) && (y>=5)){

			this.x = x;
			this.y  = y;
			grid = new Cell[x+1][y+1];
			initializeGrid(x,y);
			cant = 0;
		}
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------

	/*  initializeGrid(int x, int y) inicializa el tablero con celdas vacias, donde su tamaño es x * y
	@param x es la cantidad de filas del tablero
	@param y es la cantidad de columnas del tablero
	*/
	private void initializeGrid(int x, int y){

		for(int i = 0; i<=x; i++){

			for(int j = 0; j<=y; j++){

				grid[i][j] = new Cell(i,j);
				// grid[i][j] = 0;
			}
		}
	} 


//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Gets

	/* getx() retorna la cantidad de filas de la grilla 
	@returns un entero con la cantidad
	*/
	public int getx(){

		return x;	
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	/* gety() retorna la cantidad de columnas de la grilla
	@returns un entero con la cantidad
	 */
	public int gety(){

		return y;	
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	/*   getCell(int x, int y) retorna la celda indicada
	@param x es la fila de la celda
	@param y es la columna de la celda
	@returns una celda en la posicion x,y del tablero
	*/
	public Cell getCell(int x, int y){

		return grid[x][y];	

	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//Set

	/*   setCell(Cell c) setea la celda pasada como parametro
	@param c es la celda a setear
	*/
	public void setCell(Cell c){

		int x = c.getx();
		int y =  c.gety();
		grid[x][y] = c;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	/*   incCant() incrementa en uno la cantidad de fichas dentro del tablero
	*/
	public void incCant(){

		cant++;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------

	/*   getCant() retorna la cantidad de fichas en el tablero
	@returns un entero con la cantidad de fichas
	*/
	public int getCant(){

		return cant;

	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	/*   gridFull() retorna el estado del tablero
	@returns un booleano que indica si el tablero esta lleno o posee celdas libres
	*/
	public boolean gridFull(){

		return cant == (x+1)*(y+1);
	}


	// private String returnFicha(Cell number){
 //        if (number==0){
 //            return "<td bgcolor="+"#ffffff"+"></td>";
 //        }else if(number==1){
 //            return "<td bgcolor="+"#FF0000"+"></td>";
        
 //        }else if (number==2){
 //            return "<td bgcolor="+"#0004FF"+"></td>";
            
 //        }else{
 //            return null;
 //        }
 //    }
	
 	// private String returnFicha(Cell c){
  //       if (grid[c.getx()][c.gety()]==0){
  //           return "<td bgcolor="+"#ffffff"+"></td>";
  //       }else if(grid[c.getx()][c.gety()]==1){
  //           return "<td bgcolor="+"#FF0000"+"></td>";
        
  //       }else if (grid[c.getx()][c.gety()]==2){
  //           return "<td bgcolor="+"#0004FF"+"></td>";
            
  //       }else{
  //           return null;
  //       }
    
    
  //   }
   
    
    // public String toStringTabla(){
    //  String tabla;
    //         tabla="<table><tr>\n" +		
    //             "<td>"+returnFicha(getCell(0,0))+"</td>\n" +

    //             "<td>"+returnFicha(getCell(0,1))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(0,2))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(0,3))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(0,4))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(0,5))+"</td>\n" +

    //             "</tr>\n"+
                
    //             "<tr>\n" +		
    //             "<td>"+returnFicha(getCell(1,0))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(1,1))+"</td>\n"+
    //             "<td>"+returnFicha(getCell(1,2))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(1,3))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(1,4))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(1,5))+"</td>\n" +
    //             "</tr>\n"+
    //             "<tr>\n" +		
    //             "<td>"+returnFicha(getCell(2,0))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(2,1))+"</td>\n"+
    //             "<td>"+returnFicha(getCell(2,2))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(2,3))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(2,4))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(2,5))+"</td>\n" +
    //             "</tr>\n"+
                
    //             "<tr>\n" +		
    //             "<td>"+returnFicha(getCell(3,0))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(3,1))+"</td>\n"+
    //             "<td>"+returnFicha(getCell(3,2))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(3,3))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(3,4))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(3,5))+"</td>\n" +
    //             "</tr>\n"+
    //              "<tr>\n" +		
    //             "<td>"+returnFicha(getCell(4,0))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(4,1))+"</td>\n"+
    //             "<td>"+returnFicha(getCell(4,2))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(4,3))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(4,4))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(4,5))+"</td>\n" +
    //             "</tr>\n"+
    //                 "<tr>\n" +		
    //             "<td>"+returnFicha(getCell(5,0))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(5,1))+"</td>\n"+
    //             "<td>"+returnFicha(getCell(5,2))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(5,3))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(5,4))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(5,5))+"</td>\n" +
    //             "</tr>\n"+
    //             "<tr>\n" +		
    //             "<td>"+returnFicha(getCell(6,0))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(6,1))+"</td>\n"+
    //             "<td>"+returnFicha(getCell(6,2))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(6,3))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(6,4))+"</td>\n" +
    //             "<td>"+returnFicha(getCell(6,5))+"</td>\n" +
    //             "</tr>\n</table>";
                    
                    
                    
                    
                  
                   
    //         return tabla;
    // }
}